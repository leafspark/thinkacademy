package com.eaydu.omni.core.screen;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.eaydu.omni.core.screen.ScreenCapture;
import com.eaydu.omni.core.screen.opes.EglCore;
import com.eaydu.omni.core.screen.opes.MainFrameRect;
import com.eaydu.omni.core.screen.opes.Texture2dProgram;
import com.eaydu.omni.core.screen.opes.WindowSurface;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class TextureMovieEncoder implements Runnable {
    private static final int MSG_FRAME_AVAILABLE = 2;
    private static final int MSG_QUIT = 7;
    private static final int MSG_START_RECORDING = 0;
    private static final int MSG_STOP_RECORDING = 1;
    private static final String TAG = "SCREEN_WATCH";
    private static final boolean VERBOSE = true;
    /* access modifiers changed from: private */
    public Callback mCallback;
    private EglCore mEglCore;
    private MainFrameRect mFullScreen;
    /* access modifiers changed from: private */
    public volatile EncoderHandler mHandler;
    private WindowSurface mInputWindowSurface;
    /* access modifiers changed from: private */
    public boolean mReady;
    private final Object mReadyFence = new Object();
    private ScreenCapture.RecordCallback mRecordCallback;
    private boolean mRunning;
    private Surface mSurface;
    /* access modifiers changed from: private */
    public SurfaceTexture mSurfaceTexture;
    private int mTextureId;
    private Timer mTimer;
    private LocalTimerTask mTimerTask;
    private float[] mTransform = new float[16];
    /* access modifiers changed from: private */
    public VideoEncoderCore mVideoEncoder;
    private Handler mVideoFrameHandler;
    private HandlerThread mVideoFrameSender;

    public interface Callback {
        void onInputSurfacePrepared(Surface surface);

        void onStartWorkingResult(boolean z);

        void onStopWorkingResult();
    }

    /* access modifiers changed from: package-private */
    public boolean isRecording() {
        boolean z;
        synchronized (this.mReadyFence) {
            z = this.mRunning;
        }
        return z;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    /* access modifiers changed from: package-private */
    public void setRecordCallback(ScreenCapture.RecordCallback recordCallback) {
        this.mRecordCallback = recordCallback;
    }

    /* access modifiers changed from: package-private */
    public boolean startRecording(ScreenEncoderConfig screenEncoderConfig) {
        synchronized (this.mReadyFence) {
            if (this.mRunning) {
                OmniLog.screen_e(TAG, "Screen render thread already running!");
                return false;
            }
            this.mRunning = true;
            Thread thread = new Thread(this, "TextureMovieEncoder");
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
            while (!this.mReady) {
                try {
                    this.mReadyFence.wait();
                } catch (InterruptedException unused) {
                }
            }
            this.mHandler.sendMessage(this.mHandler.obtainMessage(0, screenEncoderConfig));
            OmniLog.screen_d(TAG, "Screen render thread created!");
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean stopRecording() {
        synchronized (this.mReadyFence) {
            if (this.mReady) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(7));
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean prepareEncoder(ScreenEncoderConfig screenEncoderConfig) {
        VideoEncoderCore videoEncoderCore = new VideoEncoderCore(this.mRecordCallback);
        this.mVideoEncoder = videoEncoderCore;
        if (!videoEncoderCore.initEncoder(screenEncoderConfig)) {
            return false;
        }
        this.mEglCore = new EglCore(screenEncoderConfig.mEglContext, 1);
        WindowSurface windowSurface = new WindowSurface(this.mEglCore, this.mVideoEncoder.getInputSurface(), true);
        this.mInputWindowSurface = windowSurface;
        windowSurface.makeCurrent();
        MainFrameRect mainFrameRect = new MainFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
        this.mFullScreen = mainFrameRect;
        mainFrameRect.setTopCropped(screenEncoderConfig.mTopCropped);
        this.mFullScreen.setBottomCropped(screenEncoderConfig.mBottomCropped);
        this.mTextureId = this.mFullScreen.createTextureObject();
        OmniLog.screen_d(TAG, "Texture created id: " + this.mTextureId);
        HandlerThread handlerThread = new HandlerThread("SurfaceFrameSender");
        this.mVideoFrameSender = handlerThread;
        handlerThread.start();
        this.mVideoFrameHandler = new Handler(this.mVideoFrameSender.getLooper());
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureId);
        this.mSurfaceTexture = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(screenEncoderConfig.mWidth, screenEncoderConfig.mHeight);
        Surface surface = new Surface(this.mSurfaceTexture);
        this.mSurface = surface;
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onInputSurfacePrepared(surface);
        }
        this.mTimer = new Timer();
        LocalTimerTask localTimerTask = new LocalTimerTask(this);
        this.mTimerTask = localTimerTask;
        try {
            this.mTimer.scheduleAtFixedRate(localTimerTask, 0, 33);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void handleFrameAvailable() {
        this.mSurfaceTexture.getTransformMatrix(this.mTransform);
        VideoEncoderCore videoEncoderCore = this.mVideoEncoder;
        if (videoEncoderCore != null) {
            videoEncoderCore.drainEncoder(false);
        }
        MainFrameRect mainFrameRect = this.mFullScreen;
        if (mainFrameRect != null) {
            mainFrameRect.drawFrame(this.mTextureId, this.mTransform);
        }
        this.mInputWindowSurface.swapBuffers();
    }

    /* access modifiers changed from: private */
    public void releaseEncoder() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer.purge();
            this.mTimer = null;
        }
        LocalTimerTask localTimerTask = this.mTimerTask;
        if (localTimerTask != null) {
            localTimerTask.removeRef();
            this.mTimerTask = null;
        }
        VideoEncoderCore videoEncoderCore = this.mVideoEncoder;
        if (videoEncoderCore != null) {
            videoEncoderCore.release();
            this.mVideoEncoder = null;
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        WindowSurface windowSurface = this.mInputWindowSurface;
        if (windowSurface != null) {
            windowSurface.release();
            this.mInputWindowSurface = null;
        }
        MainFrameRect mainFrameRect = this.mFullScreen;
        if (mainFrameRect != null) {
            mainFrameRect.release(false);
            this.mFullScreen = null;
        }
        EglCore eglCore = this.mEglCore;
        if (eglCore != null) {
            eglCore.release();
            this.mEglCore = null;
        }
        if (this.mVideoFrameHandler != null) {
            this.mVideoFrameHandler = null;
        }
        HandlerThread handlerThread = this.mVideoFrameSender;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mVideoFrameSender = null;
        }
    }

    public void run() {
        Looper.prepare();
        synchronized (this.mReadyFence) {
            this.mHandler = new EncoderHandler(this);
            this.mReady = true;
            this.mReadyFence.notify();
        }
        OmniLog.screen_d(TAG, "Screen render thread running!");
        Looper.loop();
        OmniLog.screen_d(TAG, "Screen render thread exiting");
        synchronized (this.mReadyFence) {
            this.mRunning = false;
            this.mReady = false;
            this.mHandler = null;
        }
    }

    private static class LocalTimerTask extends TimerTask {
        private final WeakReference<TextureMovieEncoder> outReference;

        LocalTimerTask(TextureMovieEncoder textureMovieEncoder) {
            this.outReference = new WeakReference<>(textureMovieEncoder);
        }

        /* access modifiers changed from: package-private */
        public void removeRef() {
            this.outReference.clear();
        }

        public void run() {
            EncoderHandler access$000;
            TextureMovieEncoder textureMovieEncoder = (TextureMovieEncoder) this.outReference.get();
            if (textureMovieEncoder != null && (access$000 = textureMovieEncoder.mHandler) != null && !access$000.hasMessages(2)) {
                if (!(access$000 instanceof Handler)) {
                    access$000.sendEmptyMessage(2);
                } else {
                    AsynchronousInstrumentation.sendEmptyMessage(access$000, 2);
                }
            }
        }
    }

    private static class EncoderHandler extends Handler {
        private long capFrames;
        private WeakReference<TextureMovieEncoder> mWeakEncoder;

        EncoderHandler(TextureMovieEncoder textureMovieEncoder) {
            this.mWeakEncoder = new WeakReference<>(textureMovieEncoder);
        }

        public void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            int i = message.what;
            Object obj = message.obj;
            TextureMovieEncoder textureMovieEncoder = (TextureMovieEncoder) this.mWeakEncoder.get();
            if (textureMovieEncoder == null) {
                OmniLog.screen_e(TextureMovieEncoder.TAG, "EncoderHandler.handleMessage: encoder is null");
                AsynchronousInstrumentation.handlerMessageEnd();
                return;
            }
            if (i == 0) {
                OmniLog.screen_d(TextureMovieEncoder.TAG, "Prepare encoder!");
                if (textureMovieEncoder.prepareEncoder((ScreenEncoderConfig) obj)) {
                    textureMovieEncoder.mCallback.onStartWorkingResult(true);
                } else {
                    textureMovieEncoder.mCallback.onStartWorkingResult(false);
                }
            } else if (i == 1) {
                OmniLog.screen_d(TextureMovieEncoder.TAG, "stopRecording");
                textureMovieEncoder.mVideoEncoder.drainEncoder(true);
                textureMovieEncoder.releaseEncoder();
            } else if (i == 2) {
                VideoEncoderCore access$300 = textureMovieEncoder.mVideoEncoder;
                if (!textureMovieEncoder.mReady || access$300 == null) {
                    AsynchronousInstrumentation.handlerMessageEnd();
                    return;
                } else if (access$300.smoothTimestamp() < 0) {
                    AsynchronousInstrumentation.handlerMessageEnd();
                    return;
                } else {
                    textureMovieEncoder.handleFrameAvailable();
                    if (textureMovieEncoder.mSurfaceTexture != null) {
                        textureMovieEncoder.mSurfaceTexture.updateTexImage();
                    }
                    this.capFrames++;
                }
            } else if (i == 7) {
                OmniLog.screen_d(TextureMovieEncoder.TAG, "Exit encoder loop");
                Looper myLooper = Looper.myLooper();
                if (myLooper != null) {
                    myLooper.quit();
                }
                textureMovieEncoder.mCallback.onStopWorkingResult();
            } else {
                RuntimeException runtimeException = new RuntimeException("Unhandled msg what=" + i);
                AsynchronousInstrumentation.handlerMessageEnd();
                throw runtimeException;
            }
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    }
}
