package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.location.Location;
import android.media.AudioRecord;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.VideoCaptureConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.camera.core.internal.utils.VideoUtil;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class VideoCapture extends UseCase {
    private static final String AUDIO_MIME_TYPE = "audio/mp4a-latm";
    private static final int[] CamcorderQuality = {8, 6, 5, 4};
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final int DEQUE_TIMEOUT_USEC = 10000;
    public static final int ERROR_ENCODER = 1;
    public static final int ERROR_FILE_IO = 4;
    public static final int ERROR_INVALID_CAMERA = 5;
    public static final int ERROR_MUXER = 2;
    public static final int ERROR_RECORDING_IN_PROGRESS = 3;
    public static final int ERROR_UNKNOWN = 0;
    private static final String TAG = "VideoCapture";
    private static final String VIDEO_MIME_TYPE = "video/avc";
    private int mAudioBitRate;
    private final MediaCodec.BufferInfo mAudioBufferInfo = new MediaCodec.BufferInfo();
    private volatile int mAudioBufferSize;
    private int mAudioChannelCount;
    private MediaCodec mAudioEncoder;
    private Handler mAudioHandler;
    private HandlerThread mAudioHandlerThread;
    private volatile AudioRecord mAudioRecorder;
    private int mAudioSampleRate;
    private int mAudioTrackIndex;
    Surface mCameraSurface;
    private DeferrableSurface mDeferrableSurface;
    private final AtomicBoolean mEndOfAudioStreamSignal = new AtomicBoolean(true);
    private final AtomicBoolean mEndOfAudioVideoSignal = new AtomicBoolean(true);
    private final AtomicBoolean mEndOfVideoStreamSignal = new AtomicBoolean(true);
    private final AtomicBoolean mIsAudioEnabled = new AtomicBoolean(true);
    private final AtomicBoolean mIsFirstAudioSampleWrite = new AtomicBoolean(false);
    private final AtomicBoolean mIsFirstVideoSampleWrite = new AtomicBoolean(false);
    private volatile boolean mIsRecording = false;
    private MediaMuxer mMuxer;
    private final Object mMuxerLock = new Object();
    private final AtomicBoolean mMuxerStarted = new AtomicBoolean(false);
    private volatile ParcelFileDescriptor mParcelFileDescriptor;
    private ListenableFuture<Void> mRecordingFuture = null;
    volatile Uri mSavedVideoUri;
    private SessionConfig.Builder mSessionConfigBuilder = new SessionConfig.Builder();
    private final MediaCodec.BufferInfo mVideoBufferInfo = new MediaCodec.BufferInfo();
    MediaCodec mVideoEncoder;
    private Handler mVideoHandler;
    private HandlerThread mVideoHandlerThread;
    private int mVideoTrackIndex;

    public static final class Metadata {
        public Location location;
    }

    public interface OnVideoSavedCallback {
        void onError(int i, String str, Throwable th);

        void onVideoSaved(OutputFileResults outputFileResults);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoCaptureError {
    }

    VideoCapture(VideoCaptureConfig videoCaptureConfig) {
        super(videoCaptureConfig);
    }

    private static MediaFormat createVideoMediaFormat(VideoCaptureConfig videoCaptureConfig, Size size) {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(VIDEO_MIME_TYPE, size.getWidth(), size.getHeight());
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", videoCaptureConfig.getBitRate());
        createVideoFormat.setInteger("frame-rate", videoCaptureConfig.getVideoFrameRate());
        createVideoFormat.setInteger("i-frame-interval", videoCaptureConfig.getIFrameInterval());
        return createVideoFormat;
    }

    public UseCaseConfig<?> getDefaultConfig(boolean z, UseCaseConfigFactory useCaseConfigFactory) {
        Config config = useCaseConfigFactory.getConfig(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE);
        if (z) {
            config = Config.CC.mergeConfigs(config, DEFAULT_CONFIG.getConfig());
        }
        if (config == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config).getUseCaseConfig();
    }

    public void onAttached() {
        this.mVideoHandlerThread = new HandlerThread("CameraX-video encoding thread");
        this.mAudioHandlerThread = new HandlerThread("CameraX-audio encoding thread");
        this.mVideoHandlerThread.start();
        this.mVideoHandler = new Handler(this.mVideoHandlerThread.getLooper());
        this.mAudioHandlerThread.start();
        this.mAudioHandler = new Handler(this.mAudioHandlerThread.getLooper());
    }

    /* access modifiers changed from: protected */
    public Size onSuggestedResolutionUpdated(Size size) {
        if (this.mCameraSurface != null) {
            this.mVideoEncoder.stop();
            this.mVideoEncoder.release();
            this.mAudioEncoder.stop();
            this.mAudioEncoder.release();
            releaseCameraSurface(false);
        }
        try {
            this.mVideoEncoder = MediaCodec.createEncoderByType(VIDEO_MIME_TYPE);
            this.mAudioEncoder = MediaCodec.createEncoderByType(AUDIO_MIME_TYPE);
            setupEncoder(getCameraId(), size);
            notifyActive();
            return size;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to create MediaCodec due to: " + e.getCause());
        }
    }

    /* renamed from: startRecording */
    public void lambda$startRecording$0$VideoCapture(OutputFileOptions outputFileOptions, Executor executor, OnVideoSavedCallback onVideoSavedCallback) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute(new VideoCapture$$ExternalSyntheticLambda7(this, outputFileOptions, executor, onVideoSavedCallback));
            return;
        }
        Logger.i(TAG, "startRecording");
        this.mIsFirstVideoSampleWrite.set(false);
        this.mIsFirstAudioSampleWrite.set(false);
        VideoSavedListenerWrapper videoSavedListenerWrapper = new VideoSavedListenerWrapper(executor, onVideoSavedCallback);
        CameraInternal camera = getCamera();
        if (camera == null) {
            videoSavedListenerWrapper.onError(5, "Not bound to a Camera [" + this + "]", (Throwable) null);
        } else if (!this.mEndOfAudioVideoSignal.get()) {
            videoSavedListenerWrapper.onError(3, "It is still in video recording!", (Throwable) null);
        } else {
            if (this.mIsAudioEnabled.get()) {
                try {
                    if (this.mAudioRecorder.getState() == 1) {
                        this.mAudioRecorder.startRecording();
                    }
                } catch (IllegalStateException e) {
                    Logger.i(TAG, "AudioRecorder cannot start recording, disable audio." + e.getMessage());
                    this.mIsAudioEnabled.set(false);
                    releaseAudioInputResource();
                }
                if (this.mAudioRecorder.getRecordingState() != 3) {
                    Logger.i(TAG, "AudioRecorder startRecording failed - incorrect state: " + this.mAudioRecorder.getRecordingState());
                    this.mIsAudioEnabled.set(false);
                    releaseAudioInputResource();
                }
            }
            AtomicReference atomicReference = new AtomicReference();
            this.mRecordingFuture = CallbackToFutureAdapter.getFuture(new VideoCapture$$ExternalSyntheticLambda0(atomicReference));
            CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
            this.mRecordingFuture.addListener(new VideoCapture$$ExternalSyntheticLambda3(this), CameraXExecutors.mainThreadExecutor());
            try {
                Logger.i(TAG, "videoEncoder start");
                this.mVideoEncoder.start();
                if (this.mIsAudioEnabled.get()) {
                    Logger.i(TAG, "audioEncoder start");
                    this.mAudioEncoder.start();
                }
                try {
                    synchronized (this.mMuxerLock) {
                        MediaMuxer initMediaMuxer = initMediaMuxer(outputFileOptions);
                        this.mMuxer = initMediaMuxer;
                        Preconditions.checkNotNull(initMediaMuxer);
                        this.mMuxer.setOrientationHint(getRelativeRotation(camera));
                        Metadata metadata = outputFileOptions.getMetadata();
                        if (!(metadata == null || metadata.location == null)) {
                            this.mMuxer.setLocation((float) metadata.location.getLatitude(), (float) metadata.location.getLongitude());
                        }
                    }
                    this.mEndOfVideoStreamSignal.set(false);
                    this.mEndOfAudioStreamSignal.set(false);
                    this.mEndOfAudioVideoSignal.set(false);
                    this.mIsRecording = true;
                    this.mSessionConfigBuilder.clearSurfaces();
                    this.mSessionConfigBuilder.addSurface(this.mDeferrableSurface);
                    updateSessionConfig(this.mSessionConfigBuilder.build());
                    notifyUpdated();
                    if (this.mIsAudioEnabled.get()) {
                        this.mAudioHandler.post(new VideoCapture$$ExternalSyntheticLambda5(this, videoSavedListenerWrapper));
                    }
                    this.mVideoHandler.post(new VideoCapture$$ExternalSyntheticLambda6(this, videoSavedListenerWrapper, getCameraId(), getAttachedSurfaceResolution(), completer));
                } catch (IOException e2) {
                    completer.set(null);
                    videoSavedListenerWrapper.onError(2, "MediaMuxer creation failed!", e2);
                }
            } catch (IllegalStateException e3) {
                completer.set(null);
                videoSavedListenerWrapper.onError(1, "Audio/Video encoder start fail", e3);
            }
        }
    }

    public /* synthetic */ void lambda$startRecording$2$VideoCapture() {
        this.mRecordingFuture = null;
        if (getCamera() != null) {
            setupEncoder(getCameraId(), getAttachedSurfaceResolution());
            notifyReset();
        }
    }

    public /* synthetic */ void lambda$startRecording$4$VideoCapture(OnVideoSavedCallback onVideoSavedCallback, String str, Size size, CallbackToFutureAdapter.Completer completer) {
        if (!videoEncode(onVideoSavedCallback, str, size)) {
            onVideoSavedCallback.onVideoSaved(new OutputFileResults(this.mSavedVideoUri));
            this.mSavedVideoUri = null;
        }
        completer.set(null);
    }

    /* renamed from: stopRecording */
    public void lambda$stopRecording$5$VideoCapture() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute(new VideoCapture$$ExternalSyntheticLambda4(this));
            return;
        }
        Logger.i(TAG, "stopRecording");
        this.mSessionConfigBuilder.clearSurfaces();
        this.mSessionConfigBuilder.addNonRepeatingSurface(this.mDeferrableSurface);
        updateSessionConfig(this.mSessionConfigBuilder.build());
        notifyUpdated();
        if (!this.mIsRecording) {
            return;
        }
        if (this.mIsAudioEnabled.get()) {
            this.mEndOfAudioStreamSignal.set(true);
        } else {
            this.mEndOfVideoStreamSignal.set(true);
        }
    }

    public void onDetached() {
        lambda$stopRecording$5$VideoCapture();
        ListenableFuture<Void> listenableFuture = this.mRecordingFuture;
        if (listenableFuture != null) {
            listenableFuture.addListener(new VideoCapture$$ExternalSyntheticLambda2(this), CameraXExecutors.mainThreadExecutor());
        } else {
            lambda$onDetached$6$VideoCapture();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: releaseResources */
    public void lambda$onDetached$6$VideoCapture() {
        this.mVideoHandlerThread.quitSafely();
        releaseAudioInputResource();
        if (this.mCameraSurface != null) {
            releaseCameraSurface(true);
        }
    }

    private void releaseAudioInputResource() {
        this.mAudioHandlerThread.quitSafely();
        MediaCodec mediaCodec = this.mAudioEncoder;
        if (mediaCodec != null) {
            mediaCodec.release();
            this.mAudioEncoder = null;
        }
        if (this.mAudioRecorder != null) {
            this.mAudioRecorder.release();
            this.mAudioRecorder = null;
        }
    }

    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config) {
        return Builder.fromConfig(config);
    }

    public void onStateDetached() {
        lambda$stopRecording$5$VideoCapture();
    }

    private void releaseCameraSurface(boolean z) {
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            MediaCodec mediaCodec = this.mVideoEncoder;
            deferrableSurface.close();
            this.mDeferrableSurface.getTerminationFuture().addListener(new VideoCapture$$ExternalSyntheticLambda8(z, mediaCodec), CameraXExecutors.mainThreadExecutor());
            if (z) {
                this.mVideoEncoder = null;
            }
            this.mCameraSurface = null;
            this.mDeferrableSurface = null;
        }
    }

    static /* synthetic */ void lambda$releaseCameraSurface$7(boolean z, MediaCodec mediaCodec) {
        if (z && mediaCodec != null) {
            mediaCodec.release();
        }
    }

    public void setTargetRotation(int i) {
        setTargetRotationInternal(i);
    }

    /* access modifiers changed from: package-private */
    public void setupEncoder(final String str, final Size size) {
        VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig) getCurrentConfig();
        this.mVideoEncoder.reset();
        this.mVideoEncoder.configure(createVideoMediaFormat(videoCaptureConfig, size), (Surface) null, (MediaCrypto) null, 1);
        if (this.mCameraSurface != null) {
            releaseCameraSurface(false);
        }
        Surface createInputSurface = this.mVideoEncoder.createInputSurface();
        this.mCameraSurface = createInputSurface;
        this.mSessionConfigBuilder = SessionConfig.Builder.createFrom(videoCaptureConfig);
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        ImmediateSurface immediateSurface = new ImmediateSurface(this.mCameraSurface);
        this.mDeferrableSurface = immediateSurface;
        ListenableFuture<Void> terminationFuture = immediateSurface.getTerminationFuture();
        Objects.requireNonNull(createInputSurface);
        terminationFuture.addListener(new VideoCapture$$ExternalSyntheticLambda1(createInputSurface), CameraXExecutors.mainThreadExecutor());
        this.mSessionConfigBuilder.addNonRepeatingSurface(this.mDeferrableSurface);
        this.mSessionConfigBuilder.addErrorListener(new SessionConfig.ErrorListener() {
            public void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                if (VideoCapture.this.isCurrentCamera(str)) {
                    VideoCapture.this.setupEncoder(str, size);
                    VideoCapture.this.notifyReset();
                }
            }
        });
        updateSessionConfig(this.mSessionConfigBuilder.build());
        this.mIsAudioEnabled.set(true);
        setAudioParametersByCamcorderProfile(size, str);
        this.mAudioEncoder.reset();
        this.mAudioEncoder.configure(createAudioMediaFormat(), (Surface) null, (MediaCrypto) null, 1);
        if (this.mAudioRecorder != null) {
            this.mAudioRecorder.release();
        }
        this.mAudioRecorder = autoConfigAudioRecordSource(videoCaptureConfig);
        if (this.mAudioRecorder == null) {
            Logger.e(TAG, "AudioRecord object cannot initialized correctly!");
            this.mIsAudioEnabled.set(false);
        }
        synchronized (this.mMuxerLock) {
            this.mVideoTrackIndex = -1;
            this.mAudioTrackIndex = -1;
        }
        this.mIsRecording = false;
    }

    private boolean writeVideoEncodedBuffer(int i) {
        if (i < 0) {
            Logger.e(TAG, "Output buffer should not have negative index: " + i);
            return false;
        }
        ByteBuffer outputBuffer = this.mVideoEncoder.getOutputBuffer(i);
        if (outputBuffer == null) {
            Logger.d(TAG, "OutputBuffer was null.");
            return false;
        }
        if (this.mMuxerStarted.get()) {
            if (this.mVideoBufferInfo.size > 0) {
                outputBuffer.position(this.mVideoBufferInfo.offset);
                outputBuffer.limit(this.mVideoBufferInfo.offset + this.mVideoBufferInfo.size);
                this.mVideoBufferInfo.presentationTimeUs = System.nanoTime() / 1000;
                synchronized (this.mMuxerLock) {
                    if (!this.mIsFirstVideoSampleWrite.get()) {
                        Logger.i(TAG, "First video sample written.");
                        this.mIsFirstVideoSampleWrite.set(true);
                    }
                    this.mMuxer.writeSampleData(this.mVideoTrackIndex, outputBuffer, this.mVideoBufferInfo);
                }
            } else {
                Logger.i(TAG, "mVideoBufferInfo.size <= 0, index " + i);
            }
        }
        this.mVideoEncoder.releaseOutputBuffer(i, false);
        if ((this.mVideoBufferInfo.flags & 4) != 0) {
            return true;
        }
        return false;
    }

    private boolean writeAudioEncodedBuffer(int i) {
        ByteBuffer outputBuffer = getOutputBuffer(this.mAudioEncoder, i);
        outputBuffer.position(this.mAudioBufferInfo.offset);
        if (this.mMuxerStarted.get()) {
            try {
                if (this.mAudioBufferInfo.size <= 0 || this.mAudioBufferInfo.presentationTimeUs <= 0) {
                    Logger.i(TAG, "mAudioBufferInfo size: " + this.mAudioBufferInfo.size + " presentationTimeUs: " + this.mAudioBufferInfo.presentationTimeUs);
                } else {
                    synchronized (this.mMuxerLock) {
                        if (!this.mIsFirstAudioSampleWrite.get()) {
                            Logger.i(TAG, "First audio sample written.");
                            this.mIsFirstAudioSampleWrite.set(true);
                        }
                        this.mMuxer.writeSampleData(this.mAudioTrackIndex, outputBuffer, this.mAudioBufferInfo);
                    }
                }
            } catch (Exception e) {
                Logger.e(TAG, "audio error:size=" + this.mAudioBufferInfo.size + "/offset=" + this.mAudioBufferInfo.offset + "/timeUs=" + this.mAudioBufferInfo.presentationTimeUs);
                e.printStackTrace();
            }
        }
        this.mAudioEncoder.releaseOutputBuffer(i, false);
        if ((this.mAudioBufferInfo.flags & 4) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean videoEncode(OnVideoSavedCallback onVideoSavedCallback, String str, Size size) {
        boolean z = false;
        boolean z2 = false;
        while (!z && !z2) {
            if (this.mEndOfVideoStreamSignal.get()) {
                this.mVideoEncoder.signalEndOfInputStream();
                this.mEndOfVideoStreamSignal.set(false);
            }
            int dequeueOutputBuffer = this.mVideoEncoder.dequeueOutputBuffer(this.mVideoBufferInfo, 10000);
            if (dequeueOutputBuffer == -2) {
                if (this.mMuxerStarted.get()) {
                    onVideoSavedCallback.onError(1, "Unexpected change in video encoding format.", (Throwable) null);
                    z2 = true;
                }
                synchronized (this.mMuxerLock) {
                    this.mVideoTrackIndex = this.mMuxer.addTrack(this.mVideoEncoder.getOutputFormat());
                    if ((this.mIsAudioEnabled.get() && this.mAudioTrackIndex >= 0 && this.mVideoTrackIndex >= 0) || (!this.mIsAudioEnabled.get() && this.mVideoTrackIndex >= 0)) {
                        this.mMuxerStarted.set(true);
                        Logger.i(TAG, "MediaMuxer started on video encode thread and audio enabled: " + this.mIsAudioEnabled);
                        this.mMuxer.start();
                    }
                }
            } else if (dequeueOutputBuffer != -1) {
                z = writeVideoEncodedBuffer(dequeueOutputBuffer);
            }
        }
        try {
            Logger.i(TAG, "videoEncoder stop");
            this.mVideoEncoder.stop();
        } catch (IllegalStateException e) {
            onVideoSavedCallback.onError(1, "Video encoder stop failed!", e);
            z2 = true;
        }
        try {
            synchronized (this.mMuxerLock) {
                if (this.mMuxer != null) {
                    if (this.mMuxerStarted.get()) {
                        this.mMuxer.stop();
                    }
                    this.mMuxer.release();
                    this.mMuxer = null;
                }
            }
        } catch (IllegalStateException e2) {
            onVideoSavedCallback.onError(2, "Muxer stop failed!", e2);
            z2 = true;
        }
        if (this.mParcelFileDescriptor != null) {
            try {
                this.mParcelFileDescriptor.close();
                this.mParcelFileDescriptor = null;
            } catch (IOException e3) {
                onVideoSavedCallback.onError(2, "File descriptor close failed!", e3);
                z2 = true;
            }
        }
        this.mMuxerStarted.set(false);
        this.mEndOfAudioVideoSignal.set(true);
        Logger.i(TAG, "Video encode thread end.");
        return z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: audioEncode */
    public boolean lambda$startRecording$3$VideoCapture(OnVideoSavedCallback onVideoSavedCallback) {
        OnVideoSavedCallback onVideoSavedCallback2 = onVideoSavedCallback;
        long j = 0;
        boolean z = false;
        while (!z && this.mIsRecording) {
            if (this.mEndOfAudioStreamSignal.get()) {
                this.mEndOfAudioStreamSignal.set(false);
                this.mIsRecording = false;
            }
            if (this.mAudioEncoder != null && this.mAudioRecorder != null) {
                try {
                    int dequeueInputBuffer = this.mAudioEncoder.dequeueInputBuffer(-1);
                    if (dequeueInputBuffer >= 0) {
                        ByteBuffer inputBuffer = getInputBuffer(this.mAudioEncoder, dequeueInputBuffer);
                        inputBuffer.clear();
                        int read = this.mAudioRecorder.read(inputBuffer, this.mAudioBufferSize);
                        if (read > 0) {
                            this.mAudioEncoder.queueInputBuffer(dequeueInputBuffer, 0, read, System.nanoTime() / 1000, this.mIsRecording ? 0 : 4);
                        }
                    }
                } catch (MediaCodec.CodecException e) {
                    Logger.i(TAG, "audio dequeueInputBuffer CodecException " + e.getMessage());
                } catch (IllegalStateException e2) {
                    Logger.i(TAG, "audio dequeueInputBuffer IllegalStateException " + e2.getMessage());
                }
                while (true) {
                    int dequeueOutputBuffer = this.mAudioEncoder.dequeueOutputBuffer(this.mAudioBufferInfo, 0);
                    if (dequeueOutputBuffer == -2) {
                        synchronized (this.mMuxerLock) {
                            int addTrack = this.mMuxer.addTrack(this.mAudioEncoder.getOutputFormat());
                            this.mAudioTrackIndex = addTrack;
                            if (addTrack >= 0 && this.mVideoTrackIndex >= 0) {
                                this.mMuxerStarted.set(true);
                                Logger.i(TAG, "MediaMuxer start on audio encoder thread.");
                                this.mMuxer.start();
                            }
                        }
                    } else if (dequeueOutputBuffer != -1) {
                        if (this.mAudioBufferInfo.presentationTimeUs > j) {
                            z = writeAudioEncodedBuffer(dequeueOutputBuffer);
                            j = this.mAudioBufferInfo.presentationTimeUs;
                        } else {
                            Logger.w(TAG, "Drops frame, current frame's timestamp " + this.mAudioBufferInfo.presentationTimeUs + " is earlier that last frame " + j);
                            this.mAudioEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                        }
                    }
                    if (dequeueOutputBuffer >= 0) {
                        if (z) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        try {
            Logger.i(TAG, "audioRecorder stop");
            this.mAudioRecorder.stop();
        } catch (IllegalStateException e3) {
            onVideoSavedCallback2.onError(1, "Audio recorder stop failed!", e3);
        }
        try {
            this.mAudioEncoder.stop();
        } catch (IllegalStateException e4) {
            onVideoSavedCallback2.onError(1, "Audio encoder stop failed!", e4);
        }
        Logger.i(TAG, "Audio encode thread end");
        this.mEndOfVideoStreamSignal.set(true);
        return false;
    }

    private ByteBuffer getInputBuffer(MediaCodec mediaCodec, int i) {
        return mediaCodec.getInputBuffer(i);
    }

    private ByteBuffer getOutputBuffer(MediaCodec mediaCodec, int i) {
        return mediaCodec.getOutputBuffer(i);
    }

    private MediaFormat createAudioMediaFormat() {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(AUDIO_MIME_TYPE, this.mAudioSampleRate, this.mAudioChannelCount);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("bitrate", this.mAudioBitRate);
        return createAudioFormat;
    }

    private AudioRecord autoConfigAudioRecordSource(VideoCaptureConfig videoCaptureConfig) {
        int i = this.mAudioChannelCount == 1 ? 16 : 12;
        try {
            int minBufferSize = AudioRecord.getMinBufferSize(this.mAudioSampleRate, i, 2);
            if (minBufferSize <= 0) {
                minBufferSize = videoCaptureConfig.getAudioMinBufferSize();
            }
            int i2 = minBufferSize;
            AudioRecord audioRecord = new AudioRecord(5, this.mAudioSampleRate, i, 2, i2 * 2);
            if (audioRecord.getState() != 1) {
                return null;
            }
            this.mAudioBufferSize = i2;
            Logger.i(TAG, "source: 5 audioSampleRate: " + this.mAudioSampleRate + " channelConfig: " + i + " audioFormat: " + 2 + " bufferSize: " + i2);
            return audioRecord;
        } catch (Exception e) {
            Logger.e(TAG, "Exception, keep trying.", e);
            return null;
        }
    }

    private void setAudioParametersByCamcorderProfile(Size size, String str) {
        boolean z = false;
        try {
            int[] iArr = CamcorderQuality;
            int length = iArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                int i2 = iArr[i];
                if (CamcorderProfile.hasProfile(Integer.parseInt(str), i2)) {
                    CamcorderProfile camcorderProfile = CamcorderProfile.get(Integer.parseInt(str), i2);
                    if (size.getWidth() == camcorderProfile.videoFrameWidth && size.getHeight() == camcorderProfile.videoFrameHeight) {
                        this.mAudioChannelCount = camcorderProfile.audioChannels;
                        this.mAudioSampleRate = camcorderProfile.audioSampleRate;
                        this.mAudioBitRate = camcorderProfile.audioBitRate;
                        z = true;
                        break;
                    }
                }
                i++;
            }
        } catch (NumberFormatException unused) {
            Logger.i(TAG, "The camera Id is not an integer because the camera may be a removable device. Use the default values for the audio related settings.");
        }
        if (!z) {
            VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig) getCurrentConfig();
            this.mAudioChannelCount = videoCaptureConfig.getAudioChannelCount();
            this.mAudioSampleRate = videoCaptureConfig.getAudioSampleRate();
            this.mAudioBitRate = videoCaptureConfig.getAudioBitRate();
        }
    }

    private MediaMuxer initMediaMuxer(OutputFileOptions outputFileOptions) throws IOException {
        ContentValues contentValues;
        if (outputFileOptions.isSavingToFile()) {
            File file = outputFileOptions.getFile();
            this.mSavedVideoUri = Uri.fromFile(outputFileOptions.getFile());
            return new MediaMuxer(file.getAbsolutePath(), 0);
        } else if (outputFileOptions.isSavingToFileDescriptor()) {
            if (Build.VERSION.SDK_INT >= 26) {
                return Api26Impl.createMediaMuxer(outputFileOptions.getFileDescriptor(), 0);
            }
            throw new IllegalArgumentException("Using a FileDescriptor to record a video is only supported for Android 8.0 or above.");
        } else if (outputFileOptions.isSavingToMediaStore()) {
            if (outputFileOptions.getContentValues() != null) {
                contentValues = new ContentValues(outputFileOptions.getContentValues());
            } else {
                contentValues = new ContentValues();
            }
            this.mSavedVideoUri = outputFileOptions.getContentResolver().insert(outputFileOptions.getSaveCollection(), contentValues);
            if (this.mSavedVideoUri != null) {
                try {
                    if (Build.VERSION.SDK_INT < 26) {
                        String absolutePathFromUri = VideoUtil.getAbsolutePathFromUri(outputFileOptions.getContentResolver(), this.mSavedVideoUri);
                        Logger.i(TAG, "Saved Location Path: " + absolutePathFromUri);
                        return new MediaMuxer(absolutePathFromUri, 0);
                    }
                    this.mParcelFileDescriptor = outputFileOptions.getContentResolver().openFileDescriptor(this.mSavedVideoUri, "rw");
                    return Api26Impl.createMediaMuxer(this.mParcelFileDescriptor.getFileDescriptor(), 0);
                } catch (IOException e) {
                    this.mSavedVideoUri = null;
                    throw e;
                }
            } else {
                throw new IOException("Invalid Uri!");
            }
        } else {
            throw new IllegalArgumentException("The OutputFileOptions should assign before recording");
        }
    }

    public static final class Defaults implements ConfigProvider<VideoCaptureConfig> {
        private static final int DEFAULT_ASPECT_RATIO = 1;
        private static final int DEFAULT_AUDIO_BIT_RATE = 64000;
        private static final int DEFAULT_AUDIO_CHANNEL_COUNT = 1;
        private static final int DEFAULT_AUDIO_MIN_BUFFER_SIZE = 1024;
        private static final int DEFAULT_AUDIO_SAMPLE_RATE = 8000;
        private static final int DEFAULT_BIT_RATE = 8388608;
        private static final VideoCaptureConfig DEFAULT_CONFIG;
        private static final int DEFAULT_INTRA_FRAME_INTERVAL = 1;
        private static final Size DEFAULT_MAX_RESOLUTION;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 3;
        private static final int DEFAULT_VIDEO_FRAME_RATE = 30;

        static {
            Size size = new Size(1920, 1080);
            DEFAULT_MAX_RESOLUTION = size;
            DEFAULT_CONFIG = new Builder().setVideoFrameRate(30).setBitRate(8388608).setIFrameInterval(1).setAudioBitRate(DEFAULT_AUDIO_BIT_RATE).setAudioSampleRate(DEFAULT_AUDIO_SAMPLE_RATE).setAudioChannelCount(1).setAudioMinBufferSize(1024).setMaxResolution(size).setSurfaceOccupancyPriority(3).setTargetAspectRatio(1).getUseCaseConfig();
        }

        public VideoCaptureConfig getConfig() {
            return DEFAULT_CONFIG;
        }
    }

    private static final class VideoSavedListenerWrapper implements OnVideoSavedCallback {
        Executor mExecutor;
        OnVideoSavedCallback mOnVideoSavedCallback;

        VideoSavedListenerWrapper(Executor executor, OnVideoSavedCallback onVideoSavedCallback) {
            this.mExecutor = executor;
            this.mOnVideoSavedCallback = onVideoSavedCallback;
        }

        public /* synthetic */ void lambda$onVideoSaved$0$VideoCapture$VideoSavedListenerWrapper(OutputFileResults outputFileResults) {
            this.mOnVideoSavedCallback.onVideoSaved(outputFileResults);
        }

        public void onVideoSaved(OutputFileResults outputFileResults) {
            try {
                this.mExecutor.execute(new VideoCapture$VideoSavedListenerWrapper$$ExternalSyntheticLambda1(this, outputFileResults));
            } catch (RejectedExecutionException unused) {
                Logger.e(VideoCapture.TAG, "Unable to post to the supplied executor.");
            }
        }

        public void onError(int i, String str, Throwable th) {
            try {
                this.mExecutor.execute(new VideoCapture$VideoSavedListenerWrapper$$ExternalSyntheticLambda0(this, i, str, th));
            } catch (RejectedExecutionException unused) {
                Logger.e(VideoCapture.TAG, "Unable to post to the supplied executor.");
            }
        }

        public /* synthetic */ void lambda$onError$1$VideoCapture$VideoSavedListenerWrapper(int i, String str, Throwable th) {
            this.mOnVideoSavedCallback.onError(i, str, th);
        }
    }

    public static final class Builder implements UseCaseConfig.Builder<VideoCapture, VideoCaptureConfig, Builder>, ImageOutputConfig.Builder<Builder>, ThreadConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls == null || cls.equals(VideoCapture.class)) {
                setTargetClass((Class<VideoCapture>) VideoCapture.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }

        static Builder fromConfig(Config config) {
            return new Builder(MutableOptionsBundle.from(config));
        }

        public static Builder fromConfig(VideoCaptureConfig videoCaptureConfig) {
            return new Builder(MutableOptionsBundle.from(videoCaptureConfig));
        }

        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        public VideoCaptureConfig getUseCaseConfig() {
            return new VideoCaptureConfig(OptionsBundle.from(this.mMutableConfig));
        }

        public VideoCapture build() {
            if (getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, null) == null || getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, null) == null) {
                return new VideoCapture(getUseCaseConfig());
            }
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }

        public Builder setVideoFrameRate(int i) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_VIDEO_FRAME_RATE, Integer.valueOf(i));
            return this;
        }

        public Builder setBitRate(int i) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_BIT_RATE, Integer.valueOf(i));
            return this;
        }

        public Builder setIFrameInterval(int i) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_INTRA_FRAME_INTERVAL, Integer.valueOf(i));
            return this;
        }

        public Builder setAudioBitRate(int i) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_BIT_RATE, Integer.valueOf(i));
            return this;
        }

        public Builder setAudioSampleRate(int i) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_SAMPLE_RATE, Integer.valueOf(i));
            return this;
        }

        public Builder setAudioChannelCount(int i) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_CHANNEL_COUNT, Integer.valueOf(i));
            return this;
        }

        public Builder setAudioMinBufferSize(int i) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_MIN_BUFFER_SIZE, Integer.valueOf(i));
            return this;
        }

        public Builder setTargetClass(Class<VideoCapture> cls) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, cls);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) == null) {
                setTargetName(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        public Builder setTargetName(String str) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, str);
            return this;
        }

        public Builder setTargetAspectRatio(int i) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, Integer.valueOf(i));
            return this;
        }

        public Builder setTargetRotation(int i) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i));
            return this;
        }

        public Builder setTargetResolution(Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, size);
            return this;
        }

        public Builder setDefaultResolution(Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
            return this;
        }

        public Builder setMaxResolution(Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, size);
            return this;
        }

        public Builder setSupportedResolutions(List<Pair<Integer, Size[]>> list) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
            return this;
        }

        public Builder setBackgroundExecutor(Executor executor) {
            getMutableConfig().insertOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
            return this;
        }

        public Builder setDefaultSessionConfig(SessionConfig sessionConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
            return this;
        }

        public Builder setDefaultCaptureConfig(CaptureConfig captureConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
            return this;
        }

        public Builder setSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        public Builder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        public Builder setSurfaceOccupancyPriority(int i) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i));
            return this;
        }

        public Builder setCameraSelector(CameraSelector cameraSelector) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, cameraSelector);
            return this;
        }

        public Builder setUseCaseEventCallback(UseCase.EventCallback eventCallback) {
            getMutableConfig().insertOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK, eventCallback);
            return this;
        }

        public Builder setAttachedUseCasesUpdateListener(Consumer<Collection<UseCase>> consumer) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_ATTACHED_USE_CASES_UPDATE_LISTENER, consumer);
            return this;
        }
    }

    public static class OutputFileResults {
        private Uri mSavedUri;

        OutputFileResults(Uri uri) {
            this.mSavedUri = uri;
        }

        public Uri getSavedUri() {
            return this.mSavedUri;
        }
    }

    public static final class OutputFileOptions {
        private static final Metadata EMPTY_METADATA = new Metadata();
        private final ContentResolver mContentResolver;
        private final ContentValues mContentValues;
        private final File mFile;
        private final FileDescriptor mFileDescriptor;
        private final Metadata mMetadata;
        private final Uri mSaveCollection;

        OutputFileOptions(File file, FileDescriptor fileDescriptor, ContentResolver contentResolver, Uri uri, ContentValues contentValues, Metadata metadata) {
            this.mFile = file;
            this.mFileDescriptor = fileDescriptor;
            this.mContentResolver = contentResolver;
            this.mSaveCollection = uri;
            this.mContentValues = contentValues;
            this.mMetadata = metadata == null ? EMPTY_METADATA : metadata;
        }

        /* access modifiers changed from: package-private */
        public File getFile() {
            return this.mFile;
        }

        /* access modifiers changed from: package-private */
        public FileDescriptor getFileDescriptor() {
            return this.mFileDescriptor;
        }

        /* access modifiers changed from: package-private */
        public ContentResolver getContentResolver() {
            return this.mContentResolver;
        }

        /* access modifiers changed from: package-private */
        public Uri getSaveCollection() {
            return this.mSaveCollection;
        }

        /* access modifiers changed from: package-private */
        public ContentValues getContentValues() {
            return this.mContentValues;
        }

        /* access modifiers changed from: package-private */
        public Metadata getMetadata() {
            return this.mMetadata;
        }

        /* access modifiers changed from: package-private */
        public boolean isSavingToMediaStore() {
            return (getSaveCollection() == null || getContentResolver() == null || getContentValues() == null) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public boolean isSavingToFile() {
            return getFile() != null;
        }

        /* access modifiers changed from: package-private */
        public boolean isSavingToFileDescriptor() {
            return getFileDescriptor() != null;
        }

        public static final class Builder {
            private ContentResolver mContentResolver;
            private ContentValues mContentValues;
            private File mFile;
            private FileDescriptor mFileDescriptor;
            private Metadata mMetadata;
            private Uri mSaveCollection;

            public Builder(File file) {
                this.mFile = file;
            }

            public Builder(FileDescriptor fileDescriptor) {
                Preconditions.checkArgument(Build.VERSION.SDK_INT >= 26, "Using a FileDescriptor to record a video is only supported for Android 8.0 or above.");
                this.mFileDescriptor = fileDescriptor;
            }

            public Builder(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
                this.mContentResolver = contentResolver;
                this.mSaveCollection = uri;
                this.mContentValues = contentValues;
            }

            public Builder setMetadata(Metadata metadata) {
                this.mMetadata = metadata;
                return this;
            }

            public OutputFileOptions build() {
                return new OutputFileOptions(this.mFile, this.mFileDescriptor, this.mContentResolver, this.mSaveCollection, this.mContentValues, this.mMetadata);
            }
        }
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        static MediaMuxer createMediaMuxer(FileDescriptor fileDescriptor, int i) throws IOException {
            return new MediaMuxer(fileDescriptor, i);
        }
    }
}
