package com.wushuangtech.myvideoimprove;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build;
import android.os.SystemClock;
import android.view.Surface;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.expansion.bean.OmniVideoFrame;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.video.MediaCodecHelper;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.library.video.bean.MediaCodecSurface;
import com.wushuangtech.library.video.bean.VideoFrame;
import com.wushuangtech.library.video.egl.EGLEnvImpl;
import com.wushuangtech.library.video.egl.EGLSurfaceHolder;
import com.wushuangtech.library.video.egl.EGLSurfaceType;
import com.wushuangtech.library.video.egl.EGLSurfaceWrap;
import com.wushuangtech.library.video.egl.OnEGLEventCallBack;
import com.wushuangtech.library.video.opengles.input.CameraPreviewInput;
import com.wushuangtech.library.video.opengles.input.ExternalVideoSourceRenderer;
import com.wushuangtech.library.video.opengles.input.GLTextureOutputRenderer;
import com.wushuangtech.library.video.opengles.output.VideoEncodeEndpoint;
import com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder;
import com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder;
import com.wushuangtech.myvideoimprove.inter.OnLocalVideoModuleEventCallBack;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.microedition.khronos.egl.EGLContext;

public class ExternalVideoSource implements HardwareEncoder.OnHardwareSurfaceLifeListener {
    private static final int MAX_CACHE_BUF_SIZE = 30;
    private static final int STATUS_ERROR_ARGS = -2;
    private static final int STATUS_ERROR_NOT_ENABLED = -1;
    private static final int STATUS_ERROR_RAW_COPY_FAILED = -20;
    private static final int STATUS_ERROR_SIZE_NOT_EQUALS = -3;
    private static final int STATUS_ERROR_TEXTURE_CREATE_RENDERER_FAILED_11 = -50;
    private static final int STATUS_ERROR_TEXTURE_CREATE_RENDERER_FAILED_14 = -51;
    private static final int STATUS_OK = 0;
    private static final String TAG = "ExternalVideoSource";
    private static volatile ExternalVideoSource mInstance;
    private int draw_frame;
    private int last_real_fps;
    private long last_time;
    private ByteBuffer mByteBuffer;
    private int mCropBottom;
    private int mCropLeft;
    private int mCropRight;
    private int mCropTop;
    private int mEncodeBitrate;
    private int mEncodeFps;
    private int mEncodeHeight;
    private int mEncodeWidth;
    private LocalVideoEncoder mEncoder;
    private ExternalVideoFrameWorker mExternalVideoFrameWorker;
    private Thread mExternalVideoFrameWorkerThread;
    private boolean mFocusSoftEncode;
    private ConcurrentLinkedQueue<VideoFrame> mGLByteBufferCache;
    private EGLContext mLastEGLContext11;
    private android.opengl.EGLContext mLastEGLContext14;
    private int mLastTextureType;
    private final Object mLock = new Object();
    /* access modifiers changed from: private */
    public OnLocalVideoModuleEventCallBack mOnLocalVideoModuleEventCallBack;
    private OpenGLRenderer mOpenGLRenderer;
    private boolean mStartEncoded;
    private boolean mSurfaceEncoded;
    private int mTargetHeight;
    private int mTargetWidth;
    private int mVideoBitrateMode = 1;
    private boolean mVideoRemoteHorMirror;
    private int real_fps;

    private ExternalVideoSource() {
    }

    public static ExternalVideoSource getInstance() {
        if (mInstance == null) {
            synchronized (ExternalVideoSource.class) {
                if (mInstance == null) {
                    mInstance = new ExternalVideoSource();
                }
            }
        }
        return mInstance;
    }

    public void setOnLocalVideoModuleEventCallBack(OnLocalVideoModuleEventCallBack onLocalVideoModuleEventCallBack) {
        this.mOnLocalVideoModuleEventCallBack = onLocalVideoModuleEventCallBack;
    }

    public void setExternalVideoParams(int i, int i2, int i3, int i4) {
        synchronized (this.mLock) {
            this.mEncodeWidth = i;
            this.mEncodeHeight = i2;
            this.mEncodeFps = i3;
            this.mEncodeBitrate = i4;
        }
    }

    public void setExternalVideoMirror(boolean z) {
        synchronized (this.mLock) {
            if (this.mVideoRemoteHorMirror != z) {
                this.mVideoRemoteHorMirror = z;
                OpenGLRenderer openGLRenderer = this.mOpenGLRenderer;
                if (!(openGLRenderer == null || openGLRenderer.mVideoEncodeEndpoint == null)) {
                    this.mOpenGLRenderer.mVideoEncodeEndpoint.setRenderMirror(z);
                }
            }
        }
    }

    public void setFocusSoftEncode(boolean z) {
        this.mFocusSoftEncode = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0011, code lost:
        r3 = r2.mEncoder;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        if (r3 != null) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0016, code lost:
        r3.setVideoBitrateMode(com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderType.MAIN, r2.mVideoBitrateMode);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setVideoBitrateMode(int r3) {
        /*
            r2 = this;
            int r0 = r2.mVideoBitrateMode
            if (r0 != r3) goto L_0x0005
            return
        L_0x0005:
            r2.mVideoBitrateMode = r3
            java.lang.Object r3 = r2.mLock
            monitor-enter(r3)
            boolean r0 = r2.mStartEncoded     // Catch:{ all -> 0x001e }
            if (r0 != 0) goto L_0x0010
            monitor-exit(r3)     // Catch:{ all -> 0x001e }
            return
        L_0x0010:
            monitor-exit(r3)     // Catch:{ all -> 0x001e }
            com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder r3 = r2.mEncoder
            if (r3 != 0) goto L_0x0016
            return
        L_0x0016:
            com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$VideoEncoderType r0 = com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderType.MAIN
            int r1 = r2.mVideoBitrateMode
            r3.setVideoBitrateMode(r0, r1)
            return
        L_0x001e:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x001e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.ExternalVideoSource.setVideoBitrateMode(int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x000f, code lost:
        r0.requestKeyFrame(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0012, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000a, code lost:
        r0 = r2.mEncoder;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000c, code lost:
        if (r0 != null) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void requestKeyFrame(com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderType r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.mLock
            monitor-enter(r0)
            boolean r1 = r2.mStartEncoded     // Catch:{ all -> 0x0013 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            return
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder r0 = r2.mEncoder
            if (r0 != 0) goto L_0x000f
            return
        L_0x000f:
            r0.requestKeyFrame(r3)
            return
        L_0x0013:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.ExternalVideoSource.requestKeyFrame(com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$VideoEncoderType):void");
    }

    public boolean startExterVideoSource(boolean z) {
        synchronized (this.mLock) {
            logI("Start external video source. started: " + this.mStartEncoded);
            if (this.mStartEncoded) {
                return true;
            }
            this.mSurfaceEncoded = Build.VERSION.SDK_INT >= 21;
            GlobalConfig.mExternalVideoSource = true;
            GlobalConfig.mExternalVideoSourceIsTexture = z;
            initEncoder();
            this.mStartEncoded = true;
            this.mVideoRemoteHorMirror = GlobalConfig.mLocalVideoSentDataHorMirrorEnabled;
            return true;
        }
    }

    public void stopExterVideoSource() {
        synchronized (this.mLock) {
            logI("Stop external video source. started: " + this.mStartEncoded);
            if (this.mStartEncoded) {
                GlobalConfig.mExternalVideoSourceIsTexture = false;
                unInitEncoder();
                long currentTimeMillis = System.currentTimeMillis();
                OpenGLRenderer openGLRenderer = this.mOpenGLRenderer;
                if (openGLRenderer != null) {
                    openGLRenderer.unInitEGL();
                    this.mOpenGLRenderer = null;
                }
                logI("UnInit EGL thread, elapsed: " + (currentTimeMillis - System.currentTimeMillis()));
                ConcurrentLinkedQueue<VideoFrame> concurrentLinkedQueue = this.mGLByteBufferCache;
                if (concurrentLinkedQueue != null) {
                    concurrentLinkedQueue.clear();
                    this.mGLByteBufferCache = null;
                }
                this.mTargetWidth = 0;
                this.mTargetHeight = 0;
                this.mCropLeft = 0;
                this.mCropTop = 0;
                this.mCropRight = 0;
                this.mCropBottom = 0;
                this.mLastEGLContext11 = null;
                this.mLastEGLContext14 = null;
                this.mLastTextureType = 0;
                this.mByteBuffer = null;
                this.mStartEncoded = false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001a, code lost:
        if (r2 == false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0020, code lost:
        if (r6.format == 10) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0026, code lost:
        if (r6.format == 11) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0028, code lost:
        return -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002b, code lost:
        if (r6.textureID != 0) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002d, code lost:
        return -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0030, code lost:
        if (r6.eglContext14 != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0034, code lost:
        if (r6.eglContext11 != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0036, code lost:
        return -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x003a, code lost:
        if (r6.format == 1) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x003f, code lost:
        if (r6.format == 3) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0044, code lost:
        if (r6.format == 4) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0049, code lost:
        if (r6.format == 5) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x004b, code lost:
        return -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x004e, code lost:
        if (r6.buf != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0050, code lost:
        return -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005b, code lost:
        if ((r5.mEncodeWidth * r5.mEncodeHeight) == (r6.stride * r6.height)) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x005d, code lost:
        return -3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x005f, code lost:
        r0 = r5.real_fps;
        r1 = r5.mEncodeFps;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0063, code lost:
        if (r0 == r1) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0065, code lost:
        r5.real_fps = r1;
        r5.last_time = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x006f, code lost:
        if (needDropThisFrame() == false) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0071, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0073, code lost:
        r0 = checkFrameSizeChanged(r6);
        r4 = r5.mLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0079, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x007c, code lost:
        if (r5.mStartEncoded != false) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x007e, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x007f, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0080, code lost:
        if (r2 == false) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0084, code lost:
        if (r5.mOpenGLRenderer != null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0086, code lost:
        r1 = createRenderer(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x008a, code lost:
        if (r1 == 0) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x008c, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x008d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x008e, code lost:
        r5.mEncoder.startEncoder(com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderType.MAIN);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0095, code lost:
        if (r0 == false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0097, code lost:
        handleEncodeParamsChanged(r5.mEncoder, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x009c, code lost:
        if (r2 == false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x009e, code lost:
        r6 = handleTextureRender(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00a2, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00a3, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00a4, code lost:
        r6 = handleRawRender(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00a8, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00a9, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int handleVideoFrame(com.wushuangtech.expansion.bean.OmniVideoFrame r6) {
        /*
            r5 = this;
            r0 = -2
            if (r6 == 0) goto L_0x00b0
            int r1 = r6.stride
            if (r1 <= 0) goto L_0x00b0
            int r1 = r6.height
            if (r1 > 0) goto L_0x000d
            goto L_0x00b0
        L_0x000d:
            java.lang.Object r1 = r5.mLock
            monitor-enter(r1)
            boolean r2 = r5.mStartEncoded     // Catch:{ all -> 0x00ad }
            r3 = -1
            if (r2 != 0) goto L_0x0017
            monitor-exit(r1)     // Catch:{ all -> 0x00ad }
            return r3
        L_0x0017:
            boolean r2 = com.wushuangtech.library.GlobalConfig.mExternalVideoSourceIsTexture     // Catch:{ all -> 0x00ad }
            monitor-exit(r1)     // Catch:{ all -> 0x00ad }
            if (r2 == 0) goto L_0x0037
            int r1 = r6.format
            r4 = 10
            if (r1 == r4) goto L_0x0029
            int r1 = r6.format
            r4 = 11
            if (r1 == r4) goto L_0x0029
            return r0
        L_0x0029:
            int r1 = r6.textureID
            if (r1 != 0) goto L_0x002e
            return r0
        L_0x002e:
            android.opengl.EGLContext r1 = r6.eglContext14
            if (r1 != 0) goto L_0x0051
            javax.microedition.khronos.egl.EGLContext r1 = r6.eglContext11
            if (r1 != 0) goto L_0x0051
            return r0
        L_0x0037:
            int r1 = r6.format
            r4 = 1
            if (r1 == r4) goto L_0x004c
            int r1 = r6.format
            r4 = 3
            if (r1 == r4) goto L_0x004c
            int r1 = r6.format
            r4 = 4
            if (r1 == r4) goto L_0x004c
            int r1 = r6.format
            r4 = 5
            if (r1 == r4) goto L_0x004c
            return r0
        L_0x004c:
            byte[] r1 = r6.buf
            if (r1 != 0) goto L_0x0051
            return r0
        L_0x0051:
            int r0 = r5.mEncodeWidth
            int r1 = r5.mEncodeHeight
            int r0 = r0 * r1
            int r1 = r6.stride
            int r4 = r6.height
            int r1 = r1 * r4
            if (r0 == r1) goto L_0x005f
            r6 = -3
            return r6
        L_0x005f:
            int r0 = r5.real_fps
            int r1 = r5.mEncodeFps
            if (r0 == r1) goto L_0x006b
            r5.real_fps = r1
            r0 = 0
            r5.last_time = r0
        L_0x006b:
            boolean r0 = r5.needDropThisFrame()
            if (r0 == 0) goto L_0x0073
            r6 = 0
            return r6
        L_0x0073:
            boolean r0 = r5.checkFrameSizeChanged(r6)
            java.lang.Object r4 = r5.mLock
            monitor-enter(r4)
            boolean r1 = r5.mStartEncoded     // Catch:{ all -> 0x00aa }
            if (r1 != 0) goto L_0x0080
            monitor-exit(r4)     // Catch:{ all -> 0x00aa }
            return r3
        L_0x0080:
            if (r2 == 0) goto L_0x0095
            com.wushuangtech.myvideoimprove.ExternalVideoSource$OpenGLRenderer r1 = r5.mOpenGLRenderer     // Catch:{ all -> 0x00aa }
            if (r1 != 0) goto L_0x0095
            int r1 = r5.createRenderer(r6)     // Catch:{ all -> 0x00aa }
            if (r1 == 0) goto L_0x008e
            monitor-exit(r4)     // Catch:{ all -> 0x00aa }
            return r1
        L_0x008e:
            com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder r1 = r5.mEncoder     // Catch:{ all -> 0x00aa }
            com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$VideoEncoderType r3 = com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderType.MAIN     // Catch:{ all -> 0x00aa }
            r1.startEncoder(r3)     // Catch:{ all -> 0x00aa }
        L_0x0095:
            if (r0 == 0) goto L_0x009c
            com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder r0 = r5.mEncoder     // Catch:{ all -> 0x00aa }
            r5.handleEncodeParamsChanged(r0, r6)     // Catch:{ all -> 0x00aa }
        L_0x009c:
            if (r2 == 0) goto L_0x00a4
            int r6 = r5.handleTextureRender(r6)     // Catch:{ all -> 0x00aa }
            monitor-exit(r4)     // Catch:{ all -> 0x00aa }
            return r6
        L_0x00a4:
            int r6 = r5.handleRawRender(r6)     // Catch:{ all -> 0x00aa }
            monitor-exit(r4)     // Catch:{ all -> 0x00aa }
            return r6
        L_0x00aa:
            r6 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00aa }
            throw r6
        L_0x00ad:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00ad }
            throw r6
        L_0x00b0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.ExternalVideoSource.handleVideoFrame(com.wushuangtech.expansion.bean.OmniVideoFrame):int");
    }

    private int createRenderer(OmniVideoFrame omniVideoFrame) {
        OpenGLRenderer openGLRenderer = new OpenGLRenderer(this.mSurfaceEncoded, this.mVideoRemoteHorMirror);
        if (omniVideoFrame.eglContext14 != null) {
            if (!openGLRenderer.initEGL14(omniVideoFrame.eglContext14)) {
                return STATUS_ERROR_TEXTURE_CREATE_RENDERER_FAILED_14;
            }
            this.mLastEGLContext14 = omniVideoFrame.eglContext14;
        } else if (omniVideoFrame.eglContext11 != null) {
            if (!openGLRenderer.initEGL11(omniVideoFrame.eglContext11)) {
                return STATUS_ERROR_TEXTURE_CREATE_RENDERER_FAILED_11;
            }
            this.mLastEGLContext11 = omniVideoFrame.eglContext11;
        }
        this.mOpenGLRenderer = openGLRenderer;
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000e, code lost:
        if (r4 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
        r4.setVideoEncoderParams(com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderType.MAIN, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000c, code lost:
        r4 = r2.mEncoder;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void changeEncParam(int r3, int r4) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.mLock
            monitor-enter(r0)
            boolean r1 = r2.mStartEncoded     // Catch:{ all -> 0x0016 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return
        L_0x0009:
            r2.real_fps = r4     // Catch:{ all -> 0x0016 }
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder r4 = r2.mEncoder
            if (r4 == 0) goto L_0x0015
            com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$VideoEncoderType r0 = com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderType.MAIN
            r4.setVideoEncoderParams(r0, r3)
        L_0x0015:
            return
        L_0x0016:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.ExternalVideoSource.changeEncParam(int, int):void");
    }

    private boolean checkFrameSizeChanged(OmniVideoFrame omniVideoFrame) {
        return (this.mTargetWidth != 0 && this.mTargetHeight != 0 && omniVideoFrame.stride == this.mTargetWidth && omniVideoFrame.height == this.mTargetHeight && omniVideoFrame.cropLeft == this.mCropLeft && omniVideoFrame.cropTop == this.mCropTop && omniVideoFrame.cropRight == this.mCropRight && omniVideoFrame.cropBottom == this.mCropBottom) ? false : true;
    }

    private void initEncoder() {
        logI("Init encoder... ");
        LocalVideoEncoder localVideoEncoder = new LocalVideoEncoder(VideoStatus.THREAD_VIDEO_EXTERNAL_GLENV);
        this.mEncoder = localVideoEncoder;
        localVideoEncoder.init(LocalVideoEncoder.VideoEncoderType.MAIN);
        this.mEncoder.setOnLocalVideoEncoderTypeChangedListener(new OnLocalVideoEncoderCallBackImpl(this));
        this.mEncoder.setSoftEncodrType(LocalVideoEncoder.VideoEncoderType.MAIN, this.mFocusSoftEncode);
        if (!this.mSurfaceEncoded || !GlobalConfig.mExternalVideoSourceIsTexture) {
            this.mEncoder.setHardwareEncoderSurfaceEnabled(LocalVideoEncoder.VideoEncoderType.MAIN, false);
            this.mEncoder.setOnHardwareSurfaceLifeListener((HardwareEncoder.OnHardwareSurfaceLifeListener) null);
            this.mExternalVideoFrameWorker = new ExternalVideoFrameWorker();
            Thread thread = new Thread(this.mExternalVideoFrameWorker);
            this.mExternalVideoFrameWorkerThread = thread;
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            this.mEncoder.setHardwareEncoderSurfaceEnabled(LocalVideoEncoder.VideoEncoderType.MAIN, true);
            this.mEncoder.setOnHardwareSurfaceLifeListener(this);
        }
    }

    private void unInitEncoder() {
        logI("Uninit encoder... ");
        LocalVideoEncoder localVideoEncoder = this.mEncoder;
        if (localVideoEncoder != null) {
            localVideoEncoder.stopEncoder(LocalVideoEncoder.VideoEncoderType.MAIN);
            this.mEncoder = null;
        }
        ExternalVideoFrameWorker externalVideoFrameWorker = this.mExternalVideoFrameWorker;
        if (externalVideoFrameWorker != null) {
            boolean unused = externalVideoFrameWorker.mDestoryed = true;
            this.mExternalVideoFrameWorker = null;
        }
        Thread thread = this.mExternalVideoFrameWorkerThread;
        if (thread != null) {
            thread.interrupt();
            this.mExternalVideoFrameWorkerThread = null;
        }
    }

    private void handleEncodeParamsChanged(LocalVideoEncoder localVideoEncoder, OmniVideoFrame omniVideoFrame) {
        int i = MediaCodecHelper.isMtk() ? 32 : 16;
        this.mTargetWidth = omniVideoFrame.stride;
        this.mTargetHeight = omniVideoFrame.height;
        this.mCropLeft = omniVideoFrame.cropLeft;
        this.mCropTop = omniVideoFrame.cropTop;
        this.mCropRight = omniVideoFrame.cropRight;
        this.mCropBottom = omniVideoFrame.cropBottom;
        this.mByteBuffer = ByteBuffer.allocate(this.mTargetWidth * this.mTargetHeight * 4);
        logI("adjust OmniVideoFrame infos : " + omniVideoFrame.toString());
        int checkCropParams = checkCropParams(this.mCropLeft);
        int checkCropParams2 = checkCropParams(this.mCropTop);
        logI("adjust mAdjustCropLeft : " + checkCropParams + " | mAdjustCropTop : " + checkCropParams2 + " | mCropRight : " + this.mCropRight + " | mCropBottom : " + this.mCropBottom);
        int i2 = this.mTargetWidth - (checkCropParams + this.mCropRight);
        int i3 = this.mTargetHeight - (checkCropParams2 + this.mCropBottom);
        StringBuilder sb = new StringBuilder();
        sb.append("adjust one mCropWidth : ");
        sb.append(i2);
        sb.append(" | mCropHeight : ");
        sb.append(i3);
        logI(sb.toString());
        int i4 = i2 % i;
        logI("adjust surplusCropWidth : " + i4);
        if (i4 != 0) {
            i2 -= i - i4;
        }
        int i5 = i3 % i;
        logI("adjust surplusCropHeight : " + i5);
        if (i5 != 0) {
            i3 -= i - i5;
        }
        logI("adjust two mCropWidth : " + i2 + " | mCropHeight : " + i3);
        localVideoEncoder.setExternalVideoColorFormat(omniVideoFrame.format);
        localVideoEncoder.setVideoEncoderParams(LocalVideoEncoder.VideoEncoderType.MAIN, this.mEncodeWidth, this.mEncodeHeight, this.mEncodeFps, this.mEncodeBitrate, 1);
        logI("Size changed target size : " + this.mTargetWidth + " * " + this.mTargetHeight);
    }

    private int handleTextureRender(OmniVideoFrame omniVideoFrame) {
        if (this.mLastEGLContext14 != omniVideoFrame.eglContext14) {
            this.mEncoder.stopEncoder(LocalVideoEncoder.VideoEncoderType.MAIN);
            this.mOpenGLRenderer.unInitEGL();
            if (!this.mOpenGLRenderer.initEGL14(omniVideoFrame.eglContext14)) {
                return STATUS_ERROR_TEXTURE_CREATE_RENDERER_FAILED_14;
            }
            this.mLastEGLContext14 = omniVideoFrame.eglContext14;
            this.mEncoder.startEncoder(LocalVideoEncoder.VideoEncoderType.MAIN);
        }
        if (omniVideoFrame.eglContext14 == null && this.mLastEGLContext11 != omniVideoFrame.eglContext11) {
            this.mEncoder.stopEncoder(LocalVideoEncoder.VideoEncoderType.MAIN);
            this.mOpenGLRenderer.unInitEGL();
            if (!this.mOpenGLRenderer.initEGL11(omniVideoFrame.eglContext11)) {
                return STATUS_ERROR_TEXTURE_CREATE_RENDERER_FAILED_11;
            }
            this.mLastEGLContext11 = omniVideoFrame.eglContext11;
            this.mEncoder.startEncoder(LocalVideoEncoder.VideoEncoderType.MAIN);
        }
        if (this.mLastTextureType != omniVideoFrame.format) {
            this.mOpenGLRenderer.setTextureType(omniVideoFrame.format);
            this.mLastTextureType = omniVideoFrame.format;
        }
        if (!this.mSurfaceEncoded && this.mGLByteBufferCache == null) {
            this.mGLByteBufferCache = new ConcurrentLinkedQueue<>();
        }
        this.mOpenGLRenderer.setRenderParams(omniVideoFrame.stride, omniVideoFrame.height, omniVideoFrame.transform, omniVideoFrame.textureID);
        this.mOpenGLRenderer.requestRender();
        return 0;
    }

    private int handleRawRender(OmniVideoFrame omniVideoFrame) {
        if (this.mGLByteBufferCache == null) {
            this.mGLByteBufferCache = new ConcurrentLinkedQueue<>();
            LocalVideoEncoder localVideoEncoder = this.mEncoder;
            if (localVideoEncoder != null) {
                localVideoEncoder.startEncoder(LocalVideoEncoder.VideoEncoderType.MAIN);
                logI("Start encoder...");
            }
        }
        if (this.mGLByteBufferCache.size() >= 30) {
            this.mGLByteBufferCache.poll();
        }
        try {
            byte[] bArr = new byte[omniVideoFrame.buf.length];
            System.arraycopy(omniVideoFrame.buf, 0, bArr, 0, omniVideoFrame.buf.length);
            VideoFrame videoFrame = new VideoFrame();
            videoFrame.format = omniVideoFrame.format;
            videoFrame.data = bArr;
            videoFrame.width = this.mTargetWidth;
            videoFrame.height = this.mTargetHeight;
            videoFrame.mRotate = omniVideoFrame.rotation;
            videoFrame.timeStamp = System.currentTimeMillis();
            this.mGLByteBufferCache.add(videoFrame);
            VideoStatus.mVideoExternalEncodeRecvFrameTimes++;
            return 0;
        } catch (Exception unused) {
            return STATUS_ERROR_RAW_COPY_FAILED;
        }
    }

    private boolean needDropThisFrame() {
        int i = this.last_real_fps;
        int i2 = this.real_fps;
        if (i != i2) {
            this.last_real_fps = i2;
            this.last_time = SystemClock.uptimeMillis();
            this.draw_frame = 1;
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.last_time;
        int i3 = this.draw_frame;
        int i4 = this.real_fps;
        if (j < ((long) ((i3 * 1000) / i4))) {
            return true;
        }
        this.draw_frame = i3 + 1;
        if (j > 1000) {
            this.last_real_fps = i4;
            this.last_time = uptimeMillis;
            this.draw_frame = 1;
        }
        return false;
    }

    private int checkCropParams(int i) {
        if (i == 0) {
            return 0;
        }
        if (i < 2) {
            return 2;
        }
        return i % 2 != 0 ? i + 1 : i;
    }

    /* access modifiers changed from: private */
    public void readDataFromGL() {
        if (!this.mSurfaceEncoded) {
            this.mByteBuffer.clear();
            GLES20.glReadPixels(0, 0, this.mTargetWidth, this.mTargetHeight, 6408, 5121, this.mByteBuffer);
            byte[] array = this.mByteBuffer.array();
            byte[] bArr = new byte[array.length];
            System.arraycopy(array, 0, bArr, 0, array.length);
            synchronized (this.mLock) {
                ConcurrentLinkedQueue<VideoFrame> concurrentLinkedQueue = this.mGLByteBufferCache;
                if (concurrentLinkedQueue != null) {
                    if (concurrentLinkedQueue.size() >= 30) {
                        this.mGLByteBufferCache.poll();
                    }
                    VideoFrame videoFrame = new VideoFrame();
                    videoFrame.data = bArr;
                    videoFrame.width = this.mTargetWidth;
                    videoFrame.height = this.mTargetHeight;
                    videoFrame.timeStamp = System.currentTimeMillis();
                    this.mGLByteBufferCache.add(videoFrame);
                }
            }
        }
    }

    public void onSurfaceCreated(MediaCodecSurface mediaCodecSurface) {
        notifySurfaceUpdated(mediaCodecSurface.getSurface(), false);
    }

    public void onSurfaceReleased(MediaCodecSurface mediaCodecSurface) {
        notifySurfaceUpdated(mediaCodecSurface.getSurface(), true);
    }

    private void notifySurfaceUpdated(Surface surface, boolean z) {
        logI("Encoder surface updated... surface : " + surface + " | " + z);
        OpenGLRenderer openGLRenderer = this.mOpenGLRenderer;
        if (openGLRenderer == null) {
            logE("Encoder surface updated failed... OpenGLRenderer is null");
        } else if (!openGLRenderer.updateEGLSurface(surface, !z)) {
            logE("Encoder surface updated failed...");
        }
    }

    private static class ExternalVideoFrameWorker implements Runnable {
        /* access modifiers changed from: private */
        public volatile boolean mDestoryed;

        private ExternalVideoFrameWorker() {
        }

        public void run() {
            while (!this.mDestoryed) {
                ExternalVideoSource.getInstance().pollNextFrame();
                try {
                    Thread.sleep(15);
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pollNextFrame() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            boolean r1 = r5.mStartEncoded     // Catch:{ all -> 0x0027 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0009:
            com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder r1 = r5.mEncoder     // Catch:{ all -> 0x0027 }
            java.util.concurrent.ConcurrentLinkedQueue<com.wushuangtech.library.video.bean.VideoFrame> r2 = r5.mGLByteBufferCache     // Catch:{ all -> 0x0027 }
        L_0x000d:
            if (r2 == 0) goto L_0x0025
            int r3 = r2.size()     // Catch:{ all -> 0x0027 }
            if (r3 <= 0) goto L_0x0025
            java.lang.Object r3 = r2.poll()     // Catch:{ all -> 0x0027 }
            com.wushuangtech.library.video.bean.VideoFrame r3 = (com.wushuangtech.library.video.bean.VideoFrame) r3     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x000d
            if (r3 == 0) goto L_0x000d
            com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$VideoEncoderType r4 = com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderType.MAIN     // Catch:{ all -> 0x0027 }
            r1.receiveVideoData(r4, r3)     // Catch:{ all -> 0x0027 }
            goto L_0x000d
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.ExternalVideoSource.pollNextFrame():void");
    }

    private static class OpenGLRenderer implements OnEGLEventCallBack, EGLSurfaceHolder.OnEGLSurfaceHolderCallBack, GLTextureOutputRenderer.OnFrameAvailableListener {
        private static final int EGL_DESTORY = 2;
        private static final int EGL_UPDATE_EGLSURFACE = 1;
        private GLTextureOutputRenderer mCameraPreviewInput;
        private final EGLEnvImpl mEGLEnvImpl = new EGLEnvImpl(VideoStatus.THREAD_VIDEO_EXTERNAL_GLENV, this);
        private boolean mEGLInitResult;
        private boolean mEGLSurfaceAddResult;
        private EGLSurfaceHolder mEGLSurfaceHolder;
        private Object mEncodeWindow;
        private GLTextureOutputRenderer mGLRenderer;
        private int mLastHeight;
        private int mLastTextureId;
        private float[] mLastTransform;
        private int mLastWidth;
        private boolean mOESTexture;
        private boolean mSurfaceEncodeEnabled;
        private SurfaceTexture mSurfaceTexture;
        /* access modifiers changed from: private */
        public VideoEncodeEndpoint mVideoEncodeEndpoint;
        private boolean mVideoRemoteHorMirror;

        public void onEGLRendererError(int i) {
        }

        public OpenGLRenderer(boolean z, boolean z2) {
            this.mSurfaceEncodeEnabled = z;
            this.mVideoRemoteHorMirror = z2;
        }

        public boolean initEGL11(EGLContext eGLContext) {
            this.mEGLEnvImpl.initEGL11Sync(eGLContext);
            return this.mEGLInitResult;
        }

        public boolean initEGL14(android.opengl.EGLContext eGLContext) {
            this.mEGLEnvImpl.initEGL14Sync(eGLContext);
            return this.mEGLInitResult;
        }

        public void setTextureType(int i) {
            this.mOESTexture = i == 11;
            CommonEventBean commonEventBean = new CommonEventBean();
            commonEventBean.mEventType = 2;
            commonEventBean.mObjects = new Object[0];
            this.mEGLEnvImpl.handleSyncMessage(commonEventBean);
            if (this.mOESTexture) {
                CameraPreviewInput cameraPreviewInput = new CameraPreviewInput();
                this.mCameraPreviewInput = cameraPreviewInput;
                cameraPreviewInput.setOnFrameAvailableListener(this);
            } else {
                ExternalVideoSourceRenderer externalVideoSourceRenderer = new ExternalVideoSourceRenderer();
                this.mGLRenderer = externalVideoSourceRenderer;
                externalVideoSourceRenderer.setOnFrameAvailableListener(this);
            }
            if (this.mSurfaceEncodeEnabled) {
                VideoEncodeEndpoint videoEncodeEndpoint = new VideoEncodeEndpoint(1);
                this.mVideoEncodeEndpoint = videoEncodeEndpoint;
                videoEncodeEndpoint.setRenderMirror(this.mVideoRemoteHorMirror);
                this.mVideoEncodeEndpoint.setMatrixRotate(LocalSDKConstants.SCREEN_ROTATE_180);
            }
        }

        public void setRenderParams(int i, int i2, float[] fArr, int i3) {
            GLTextureOutputRenderer gLTextureOutputRenderer;
            if (this.mOESTexture) {
                gLTextureOutputRenderer = this.mCameraPreviewInput;
            } else {
                gLTextureOutputRenderer = this.mGLRenderer;
            }
            if (!(i == this.mLastWidth && i2 == this.mLastHeight)) {
                gLTextureOutputRenderer.setRenderSize(i, i2);
                this.mVideoEncodeEndpoint.setEncodeSize(i, i2);
                this.mVideoEncodeEndpoint.setEncodeRawSize(i, i2);
                this.mLastWidth = i;
                this.mLastHeight = i2;
            }
            if (!Arrays.equals(fArr, this.mLastTransform)) {
                if (this.mOESTexture) {
                    ((CameraPreviewInput) gLTextureOutputRenderer).setMatrix(fArr);
                } else {
                    ((ExternalVideoSourceRenderer) gLTextureOutputRenderer).setMatrix(fArr);
                }
                this.mLastTransform = fArr;
            }
            if (this.mLastTextureId != i3) {
                SurfaceTexture surfaceTexture = this.mSurfaceTexture;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                this.mSurfaceTexture = new SurfaceTexture(i3);
                gLTextureOutputRenderer.setTextureId(i3);
                this.mLastTextureId = i3;
            }
        }

        public boolean updateEGLSurface(Object obj, boolean z) {
            CommonEventBean commonEventBean = new CommonEventBean();
            commonEventBean.mEventType = 1;
            commonEventBean.mObjects = new Object[]{Boolean.valueOf(z), obj};
            this.mEGLEnvImpl.handleSyncMessage(commonEventBean);
            return this.mEGLSurfaceAddResult;
        }

        public boolean requestRender() {
            if (!this.mEGLInitResult) {
                return false;
            }
            CommonEventBean commonEventBean = new CommonEventBean();
            commonEventBean.mEventType = 1003;
            this.mEGLEnvImpl.handleRendererEvent(commonEventBean);
            return true;
        }

        public void unInitEGL() {
            CommonEventBean commonEventBean = new CommonEventBean();
            commonEventBean.mEventType = 2;
            commonEventBean.mObjects = new Object[0];
            this.mEGLEnvImpl.handleSyncMessage(commonEventBean);
            this.mEGLEnvImpl.unInitEGLSync();
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
            this.mLastTextureId = 0;
            this.mLastWidth = 0;
            this.mLastHeight = 0;
            this.mLastTransform = null;
        }

        public void onEGLRendererEvent(CommonEventBean commonEventBean) {
            GLTextureOutputRenderer gLTextureOutputRenderer;
            int i = commonEventBean.mEventType;
            if (i == 1) {
                boolean booleanValue = ((Boolean) commonEventBean.mObjects[0]).booleanValue();
                Object obj = commonEventBean.mObjects[1];
                if (booleanValue) {
                    boolean addEGLSurface = this.mEGLSurfaceHolder.addEGLSurface(EGLSurfaceType.ENCODE, obj);
                    this.mEGLSurfaceAddResult = addEGLSurface;
                    if (addEGLSurface) {
                        this.mEncodeWindow = obj;
                        return;
                    }
                    return;
                }
                this.mEGLSurfaceAddResult = this.mEGLSurfaceHolder.releaseEGLSurface(obj);
                this.mEncodeWindow = null;
            } else if (i == 2) {
                handleEventForDestory();
            } else if (i == 1000) {
                this.mEGLInitResult = ((Boolean) commonEventBean.mObjects[0]).booleanValue();
                this.mEGLSurfaceHolder = new EGLSurfaceHolder(this.mEGLEnvImpl.getBaseEGL(), this);
            } else if (i == 1001) {
                this.mEGLSurfaceHolder.destroy();
                this.mEGLSurfaceHolder = null;
            } else if (i == 1003) {
                SurfaceTexture surfaceTexture = this.mSurfaceTexture;
                if (this.mOESTexture) {
                    gLTextureOutputRenderer = this.mCameraPreviewInput;
                } else {
                    gLTextureOutputRenderer = this.mGLRenderer;
                }
                if (gLTextureOutputRenderer != null && surfaceTexture != null) {
                    surfaceTexture.updateTexImage();
                    gLTextureOutputRenderer.onDrawFrame();
                    if (this.mSurfaceEncodeEnabled) {
                        VideoEncodeEndpoint videoEncodeEndpoint = this.mVideoEncodeEndpoint;
                        EGLSurfaceHolder eGLSurfaceHolder = this.mEGLSurfaceHolder;
                        if (videoEncodeEndpoint != null && eGLSurfaceHolder != null) {
                            videoEncodeEndpoint.setTextureId(gLTextureOutputRenderer.getFrameBufferTextureId());
                            EGLSurfaceWrap eGLSurface = eGLSurfaceHolder.getEGLSurface(this.mEncodeWindow);
                            if (eGLSurface != null && !eGLSurfaceHolder.renderEGLSurface(eGLSurface)) {
                                OmniLog.e(OmniLog.EXTERNAL_VIDEO_WATCH, ExternalVideoSource.TAG, "Render external video source failed...");
                            }
                        }
                    }
                }
            }
        }

        private void handleEventForDestory() {
            GLTextureOutputRenderer gLTextureOutputRenderer;
            VideoEncodeEndpoint videoEncodeEndpoint;
            if (this.mOESTexture) {
                gLTextureOutputRenderer = this.mCameraPreviewInput;
            } else {
                gLTextureOutputRenderer = this.mGLRenderer;
            }
            if (gLTextureOutputRenderer != null) {
                gLTextureOutputRenderer.destroy();
                if (this.mSurfaceEncodeEnabled && (videoEncodeEndpoint = this.mVideoEncodeEndpoint) != null) {
                    videoEncodeEndpoint.setTextureId(gLTextureOutputRenderer.getFrameBufferTextureId());
                    EGLSurfaceHolder eGLSurfaceHolder = this.mEGLSurfaceHolder;
                    if (eGLSurfaceHolder != null) {
                        eGLSurfaceHolder.releaseEGLSurface(this.mEncodeWindow);
                    }
                }
                OmniLog.i(OmniLog.EXTERNAL_VIDEO_WATCH, ExternalVideoSource.TAG, "Destroy opengl resource success...");
            }
        }

        public boolean onEGLSurfaceHolderDrawFrame(EGLSurfaceWrap eGLSurfaceWrap) {
            VideoEncodeEndpoint videoEncodeEndpoint = this.mVideoEncodeEndpoint;
            if (videoEncodeEndpoint == null) {
                return true;
            }
            return videoEncodeEndpoint.onDrawFrame();
        }

        public void onFrameAvailable(int i, int i2) {
            ExternalVideoSource.getInstance().readDataFromGL();
        }
    }

    private void logI(String str) {
        OmniLog.i(OmniLog.EXTERNAL_VIDEO_WATCH, TAG, str);
    }

    private void logE(String str) {
        OmniLog.e(OmniLog.EXTERNAL_VIDEO_WATCH, TAG, str);
    }

    private static class OnLocalVideoEncoderCallBackImpl implements LocalVideoEncoder.OnLocalVideoEncoderCallBack {
        private final WeakReference<ExternalVideoSource> mOutReference;

        public void onEncoderStartFailed() {
        }

        public void onEncoderStartSuccess() {
        }

        public void onEncoderTypeChanged(boolean z) {
        }

        public OnLocalVideoEncoderCallBackImpl(ExternalVideoSource externalVideoSource) {
            this.mOutReference = new WeakReference<>(externalVideoSource);
        }

        public void onEncodedDataReport(boolean z, byte[] bArr, int i, int i2, int i3, long j) {
            ExternalVideoSource externalVideoSource = (ExternalVideoSource) this.mOutReference.get();
            if (externalVideoSource != null && externalVideoSource.mOnLocalVideoModuleEventCallBack != null) {
                externalVideoSource.mOnLocalVideoModuleEventCallBack.onVideoEncodedDataReport(z, bArr, i, i2, i3, j);
            }
        }
    }
}
