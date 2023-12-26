package com.wushuangtech.myvideoimprove.render;

import android.graphics.SurfaceTexture;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.view.Display;
import android.view.WindowManager;
import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.bean.FastLogCacheBean;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.GlobalVideoConfig;
import com.wushuangtech.library.video.RenderSmooth;
import com.wushuangtech.library.video.VideoErrorConstants;
import com.wushuangtech.library.video.VideoStatistical;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.library.video.bean.MediaCodecSurface;
import com.wushuangtech.library.video.egl.BaseEGL;
import com.wushuangtech.library.video.egl.EGLEnvImpl;
import com.wushuangtech.library.video.egl.EGLRenderRateControl;
import com.wushuangtech.library.video.egl.EGLSurfaceHolder;
import com.wushuangtech.library.video.egl.EGLSurfaceType;
import com.wushuangtech.library.video.egl.EGLSurfaceWrap;
import com.wushuangtech.library.video.opengles.WaterMarkController;
import com.wushuangtech.myvideoimprove.VideoRenderer;
import com.wushuangtech.myvideoimprove.bean.LocalOpenGLRendererBean;
import com.wushuangtech.myvideoimprove.capture.VideoCapFrame;
import com.wushuangtech.myvideoimprove.render.LocalOpenGLRenderer;
import com.wushuangtech.myvideoimprove.render.VideoRendererImpl;
import com.wushuangtech.myvideoimprove.view.VideoRenderView;
import com.wushuangtech.utils.DeviceUtils;
import com.wushuangtech.utils.MyGLUtils;
import com.wushuangtech.utils.OmniLog;

public class LocalVideoRenderer extends VideoRendererImpl implements LocalOpenGLRenderer.OpenGLRendererCallBack, EGLSurfaceHolder.OnEGLSurfaceHolderCallBack {
    private static final int EGL_RENDERER_START = 500;
    private static final int EGL_RENDERER_STOP = 501;
    private static final int EGL_VIDEO_DISPLAY_SURFACE_CREATED = 602;
    private static final int EGL_VIDEO_DISPLAY_SURFACE_RELEASE = 603;
    private static final int EGL_VIDEO_ENCODER_SURFACE_CREATED = 604;
    private static final int EGL_VIDEO_ENCODER_SURFACE_RELEASE = 605;
    private static final int EGL_VIDEO_FIRST_DATA = 620;
    private static final String TAG = "LocalVideoRenderer";
    private int mCameraTextureId;
    private Display mDefaultDisplay;
    private RenderSmooth mDisplayRenderSmooth;
    private Object mDisplaySurfaceTexture;
    int mDualEncoderFps = 15;
    private RenderSmooth mDualEncoderSmooth;
    private MediaCodecSurface mDualMediaCodecSurface;
    private boolean mEGLEncodeStop;
    private final EGLEnvImpl mEGLEnvImpl;
    private EGLRenderRateControl mEGLRenderRateControl;
    private EGLSurfaceHolder mEGLSurfaceHolder;
    private int mEncodeHeight;
    private int mEncodeWidth;
    private boolean mFirstFrameDraw;
    private int mLastExpectHeight;
    private int mLastExpectWidth;
    private int mLastPreviewHeight;
    private int mLastPreviewRotate;
    private int mLastPreviewWidth;
    private int mLastRotation = -1;
    private final LocalOpenGLRenderer mLocalOpenGLRenderer = new LocalOpenGLRenderer();
    private final Object mLock;
    int mMainEncoderFps = 15;
    private RenderSmooth mMainEncoderSmooth;
    private MediaCodecSurface mMediaCodecSurface;
    private boolean mNotifyFirstFrameDraw;
    private int[] mOpenGLReadPixelArgs;
    private boolean mPauseRenderer;
    private final FastLogCacheBean mRenderDisplayEGLSurfaceEmpty;
    private final FastLogCacheBean mRenderDisplayEGLSurfaceFailed;
    int mRenderFps = 15;
    private boolean mRendererStarted;
    private int mVideoCapRotate;
    private SurfaceTexture mVideoCapSurfaceTexture;
    private final int mWaitEncoderRestartMaxTime = 500;
    private long mWaitStartTimestamp;
    private boolean mWaitingForEncoderRestart;

    public void setWaterMark(WaterMarkController waterMarkController) {
    }

    public void setWaitingForEncoderRestart(boolean z) {
        synchronized (this.mLock) {
            OmniLog.i(TAG, OmniLog.SCREEN_ROTATE, "Recv encoder restart over!");
            this.mWaitingForEncoderRestart = z;
        }
    }

    public LocalVideoRenderer(VideoRenderer.OnVideoRendererAddSurfaceCallBack onVideoRendererAddSurfaceCallBack) {
        super(onVideoRendererAddSurfaceCallBack);
        String str = TAG;
        this.mRenderDisplayEGLSurfaceFailed = new FastLogCacheBean("LocalVideoRenderer::drawOpenGLForDisplay::renderEGLSurface", str, OmniLog.VIDEO_RENDER_WATCH, 2);
        this.mRenderDisplayEGLSurfaceEmpty = new FastLogCacheBean("LocalVideoRenderer::drawOpenGLForDisplay::getEGLSurface=null", str, OmniLog.VIDEO_RENDER_WATCH, 2);
        this.mLock = new Object();
        this.mEGLEnvImpl = new EGLEnvImpl(VideoStatus.THREAD_VIDEO_LOCAL_GLENV, new VideoRendererImpl.LocalEGLEventCallBackImpl(this));
        try {
            this.mDefaultDisplay = ((WindowManager) GlobalHolder.getInstance().getContext().getSystemService("window")).getDefaultDisplay();
        } catch (Exception unused) {
        }
    }

    public boolean isRendererStarted() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mRendererStarted;
        }
        return z;
    }

    public void setCameraId(int i) {
        this.mLocalOpenGLRenderer.setCameraId(i);
    }

    public void setEnableReadPixel(boolean z) {
        LocalOpenGLRendererBean localOpenGLRendererBean = new LocalOpenGLRendererBean();
        localOpenGLRendererBean.mOpenGLReadPixelArgs = this.mOpenGLReadPixelArgs;
        this.mLocalOpenGLRenderer.setRenderType(z, localOpenGLRendererBean);
        synchronized (this.mLock) {
            this.mEGLEncodeStop = z;
        }
    }

    public void setRotate(int i) {
        synchronized (this.mLock) {
            this.mVideoCapRotate = i;
            this.mLocalOpenGLRenderer.setRotate(i);
        }
    }

    public void setVideoCapRate(int i) {
        synchronized (this.mLock) {
            this.mRenderFps = i;
            this.mMainEncoderFps = i;
            this.mDualEncoderFps = i;
            RenderSmooth renderSmooth = this.mDisplayRenderSmooth;
            if (renderSmooth != null) {
                renderSmooth.setRenderFps(i);
            }
            RenderSmooth renderSmooth2 = this.mMainEncoderSmooth;
            if (renderSmooth2 != null) {
                renderSmooth2.setRenderFps(this.mMainEncoderFps);
            }
            RenderSmooth renderSmooth3 = this.mDualEncoderSmooth;
            if (renderSmooth3 != null) {
                renderSmooth3.setRenderFps(this.mDualEncoderFps);
            }
        }
    }

    public void setVideoEncodeRate(int i) {
        synchronized (this.mLock) {
            this.mMainEncoderFps = i;
        }
        RenderSmooth renderSmooth = this.mMainEncoderSmooth;
        if (renderSmooth != null) {
            renderSmooth.setRenderFps(i);
        }
    }

    public void setVideoDualEncodeRate(int i) {
        synchronized (this.mLock) {
            this.mDualEncoderFps = i;
        }
        RenderSmooth renderSmooth = this.mDualEncoderSmooth;
        if (renderSmooth != null) {
            renderSmooth.setRenderFps(i);
        }
    }

    public void setVideoEncodedSize(int i, int i2) {
        synchronized (this.mLock) {
            this.mEncodeWidth = i;
            this.mEncodeHeight = i2;
            this.mOpenGLReadPixelArgs = new int[]{0, 0, i, i2};
        }
        this.mLocalOpenGLRenderer.setVideoEncodeSize(i, i2);
    }

    public void setVideoDualEncodedSize(int i, int i2) {
        this.mLocalOpenGLRenderer.setVideoDualEncodeSize(i, i2);
    }

    public void setEnableBeautify(boolean z) {
        this.mLocalOpenGLRenderer.setBeautifyStatus(z);
    }

    public void setBeautifyLevel(float f) {
        this.mLocalOpenGLRenderer.setBeautifyLevel(f);
    }

    public void setBrightLevel(float f) {
        this.mLocalOpenGLRenderer.setBrightLevel(f);
    }

    public void setRenderMirror(boolean z, boolean z2) {
        this.mLocalOpenGLRenderer.setRenderMirror(z, z2);
    }

    public void setRenderEncodeMirror(boolean z) {
        this.mLocalOpenGLRenderer.setRenderEncodeMirror(z);
    }

    public void setVideoSurfaceWindowForEncode(boolean z, MediaCodecSurface mediaCodecSurface) {
        if (mediaCodecSurface != null) {
            String str = TAG;
            log(false, str, "bug1001 Recv video encode surface changed : " + z + " | surface : " + mediaCodecSurface.toString());
            CommonEventBean commonEventBean = new CommonEventBean();
            commonEventBean.mEventType = z ? EGL_VIDEO_ENCODER_SURFACE_CREATED : EGL_VIDEO_ENCODER_SURFACE_RELEASE;
            commonEventBean.mObjects = new Object[]{mediaCodecSurface};
            handleSyncEvent(commonEventBean);
        }
    }

    public int[] getOpenGLReadPixelArgs() {
        return this.mOpenGLReadPixelArgs;
    }

    public void setRenderPreviewStatus(boolean z) {
        this.mLocalOpenGLRenderer.setRenderPreviewStatus(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int[] calcVideoEncodeSize(int r18, int r19, int r20, int r21, int r22) {
        /*
            r17 = this;
            r7 = r17
            r0 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r11 = r22
            java.lang.Object r12 = r7.mLock
            monitor-enter(r12)
            int r1 = r7.mLastExpectWidth     // Catch:{ all -> 0x00eb }
            r13 = 1
            r14 = 2
            r15 = 0
            if (r0 != r1) goto L_0x0032
            int r1 = r7.mLastExpectHeight     // Catch:{ all -> 0x00eb }
            if (r8 != r1) goto L_0x0032
            int r1 = r7.mLastPreviewWidth     // Catch:{ all -> 0x00eb }
            if (r9 != r1) goto L_0x0032
            int r1 = r7.mLastPreviewHeight     // Catch:{ all -> 0x00eb }
            if (r10 != r1) goto L_0x0032
            int r1 = r7.mLastPreviewRotate     // Catch:{ all -> 0x00eb }
            if (r11 != r1) goto L_0x0032
            int[] r0 = new int[r14]     // Catch:{ all -> 0x00eb }
            int r1 = r7.mEncodeWidth     // Catch:{ all -> 0x00eb }
            r0[r15] = r1     // Catch:{ all -> 0x00eb }
            int r1 = r7.mEncodeHeight     // Catch:{ all -> 0x00eb }
            r0[r13] = r1     // Catch:{ all -> 0x00eb }
            monitor-exit(r12)     // Catch:{ all -> 0x00eb }
            return r0
        L_0x0032:
            r7.mLastExpectWidth = r0     // Catch:{ all -> 0x00eb }
            r7.mLastExpectHeight = r8     // Catch:{ all -> 0x00eb }
            r7.mLastPreviewWidth = r9     // Catch:{ all -> 0x00eb }
            r7.mLastPreviewHeight = r10     // Catch:{ all -> 0x00eb }
            r7.mLastPreviewRotate = r11     // Catch:{ all -> 0x00eb }
            r1 = 90
            if (r11 == r1) goto L_0x0054
            r1 = 270(0x10e, float:3.78E-43)
            if (r11 != r1) goto L_0x0045
            goto L_0x0054
        L_0x0045:
            int r1 = java.lang.Math.min(r9, r0)     // Catch:{ all -> 0x00eb }
            int r2 = java.lang.Math.min(r10, r8)     // Catch:{ all -> 0x00eb }
            if (r0 != r9) goto L_0x0068
            if (r8 != r10) goto L_0x0068
            r1 = r9
            r2 = r10
            goto L_0x0068
        L_0x0054:
            int r1 = java.lang.Math.min(r9, r8)     // Catch:{ all -> 0x00eb }
            int r2 = java.lang.Math.min(r10, r0)     // Catch:{ all -> 0x00eb }
            if (r0 != r10) goto L_0x0063
            if (r8 != r9) goto L_0x0063
            r2 = r9
            r1 = r10
            goto L_0x0068
        L_0x0063:
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x0068:
            int r3 = r1 % 16
            int r4 = r2 % 16
            r5 = 240(0xf0, float:3.36E-43)
            if (r1 < r5) goto L_0x0078
            if (r2 < r5) goto L_0x0078
            if (r3 == 0) goto L_0x0075
            int r1 = r1 - r3
        L_0x0075:
            if (r4 == 0) goto L_0x0078
            int r2 = r2 - r4
        L_0x0078:
            r6 = r1
            r5 = r2
            r7.mEncodeWidth = r6     // Catch:{ all -> 0x00eb }
            r7.mEncodeHeight = r5     // Catch:{ all -> 0x00eb }
            r1 = r17
            r2 = r6
            r3 = r5
            r4 = r20
            r13 = r5
            r5 = r21
            r14 = r6
            r6 = r22
            int[] r1 = r1.calcReadPixelSuitSize(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00eb }
            r7.mOpenGLReadPixelArgs = r1     // Catch:{ all -> 0x00eb }
            java.lang.String r1 = TAG     // Catch:{ all -> 0x00eb }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00eb }
            r2.<init>()     // Catch:{ all -> 0x00eb }
            java.lang.String r3 = "Calc video encode size -> expect size : "
            r2.append(r3)     // Catch:{ all -> 0x00eb }
            r2.append(r0)     // Catch:{ all -> 0x00eb }
            java.lang.String r0 = " * "
            r2.append(r0)     // Catch:{ all -> 0x00eb }
            r2.append(r8)     // Catch:{ all -> 0x00eb }
            java.lang.String r0 = " | encode size : "
            r2.append(r0)     // Catch:{ all -> 0x00eb }
            r2.append(r14)     // Catch:{ all -> 0x00eb }
            java.lang.String r0 = " * "
            r2.append(r0)     // Catch:{ all -> 0x00eb }
            r2.append(r13)     // Catch:{ all -> 0x00eb }
            java.lang.String r0 = " | preview size : "
            r2.append(r0)     // Catch:{ all -> 0x00eb }
            r2.append(r9)     // Catch:{ all -> 0x00eb }
            java.lang.String r0 = " * "
            r2.append(r0)     // Catch:{ all -> 0x00eb }
            r2.append(r10)     // Catch:{ all -> 0x00eb }
            java.lang.String r0 = " | previewRotate : "
            r2.append(r0)     // Catch:{ all -> 0x00eb }
            r2.append(r11)     // Catch:{ all -> 0x00eb }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00eb }
            r7.log(r15, r1, r0)     // Catch:{ all -> 0x00eb }
            monitor-exit(r12)     // Catch:{ all -> 0x00eb }
            com.wushuangtech.myvideoimprove.render.LocalOpenGLRenderer r0 = r7.mLocalOpenGLRenderer
            int[] r1 = r7.mOpenGLReadPixelArgs
            r0.setReadPixelParams(r1)
            r0 = 2
            int[] r0 = new int[r0]
            int r1 = r7.mEncodeWidth
            r0[r15] = r1
            int r1 = r7.mEncodeHeight
            r2 = 1
            r0[r2] = r1
            return r0
        L_0x00eb:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00eb }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.render.LocalVideoRenderer.calcVideoEncodeSize(int, int, int, int, int):int[]");
    }

    public void notifyPreviewFrameOutput(VideoCapFrame videoCapFrame) {
        synchronized (this.mLock) {
            if (!this.mFirstFrameDraw) {
                this.mFirstFrameDraw = true;
                CommonEventBean commonEventBean = new CommonEventBean();
                commonEventBean.mEventType = EGL_VIDEO_FIRST_DATA;
                commonEventBean.mObject = videoCapFrame;
                commonEventBean.mObjects = new Object[]{false};
                this.mEGLEnvImpl.handleRendererEventUrgent(commonEventBean);
                return;
            }
            this.mLocalOpenGLRenderer.setRenderRawData(videoCapFrame);
        }
    }

    public void initRenderer() {
        this.mEGLEnvImpl.initEGL14Sync((EGLContext) null);
    }

    public void unInitVideoRenderer() {
        this.mEGLEnvImpl.unInitEGLSync();
    }

    public void destroyVideoRenderer() {
        this.mEGLEnvImpl.destroyEGLThread();
    }

    public boolean startRender() {
        log(false, TAG, "============ local renderer starting!");
        CommonEventBean commonEventBean = new CommonEventBean();
        commonEventBean.mEventType = 500;
        this.mEGLEnvImpl.handleRendererEventUrgent(commonEventBean);
        return true;
    }

    public void stopRender() {
        CommonEventBean commonEventBean = new CommonEventBean();
        commonEventBean.mEventType = 501;
        this.mEGLEnvImpl.handleRendererEventUrgent(commonEventBean);
    }

    public void pauseRender() {
        synchronized (this.mLock) {
            VideoStatus.mEglRenderStatus = VideoStatus.OpenglESRenderStatus.PAUSE;
            this.mPauseRenderer = true;
        }
    }

    public void resumeRender() {
        synchronized (this.mLock) {
            VideoStatus.mEglRenderStatus = VideoStatus.OpenglESRenderStatus.RENDERING;
            this.mPauseRenderer = false;
        }
    }

    public void setVideoSize(int i, int i2) {
        this.mLocalOpenGLRenderer.setVideoSize(i, i2);
    }

    public void setViewSize(int i, int i2) {
        this.mLocalOpenGLRenderer.setViewSize(i, i2);
    }

    public void setRenderMode(int i) {
        this.mLocalOpenGLRenderer.setRenderMode(i);
    }

    public void setDisplaySurfaceWindow(Object obj, Object obj2) {
        synchronized (this.mViewLock) {
            VideoRenderView videoRenderView = (VideoRenderView) this.mVideoRenderViewRef.get();
            if (!(obj == null || obj2 == null)) {
                if (videoRenderView != null) {
                    if (obj == videoRenderView) {
                        CommonEventBean commonEventBean = new CommonEventBean();
                        commonEventBean.mEventType = 602;
                        commonEventBean.mObjects = new Object[]{obj, obj2};
                        handleSyncEvent(commonEventBean);
                    }
                }
            }
        }
    }

    public void releaseDisplaySurfaceWindow(Object obj, Object obj2) {
        synchronized (this.mViewLock) {
            VideoRenderView videoRenderView = (VideoRenderView) this.mVideoRenderViewRef.get();
            if (!(obj == null || obj2 == null)) {
                if (videoRenderView != null) {
                    if (obj == videoRenderView) {
                        CommonEventBean commonEventBean = new CommonEventBean();
                        commonEventBean.mEventType = 603;
                        commonEventBean.mObjects = new Object[]{obj, obj2};
                        handleSyncEvent(commonEventBean);
                    }
                }
            }
        }
    }

    public SurfaceTexture getVideoCapSurfaceTexture() {
        return this.mVideoCapSurfaceTexture;
    }

    public int onRendererTextureReadyCallBack(byte[] bArr, int i, int i2, int i3, int i4, long j) {
        if (this.onVideoRendererAddSurfaceCallBack != null) {
            return this.onVideoRendererAddSurfaceCallBack.onVideoFrameData(i, bArr, i2, i3, i4, j);
        }
        return 0;
    }

    public void handleEGLRenderEvent(CommonEventBean commonEventBean) {
        int i = commonEventBean.mEventType;
        if (i == 500) {
            executingEGLRendererStart();
        } else if (i == 501) {
            executingEGLRendererStop();
        } else if (i == EGL_VIDEO_FIRST_DATA) {
            String str = TAG;
            OmniLog.i(OmniLog.VIDEO_CAP_SPEED_WATCH, str, "Execute first frame event: " + (System.currentTimeMillis() - GlobalConfig.mVideoCapStartTimestamp));
            this.mLocalOpenGLRenderer.setRenderRawData((VideoCapFrame) commonEventBean.mObject);
            drawOpenGLForDisplay(false);
        } else if (i == 1003) {
            executingEGLRendererWorking(commonEventBean);
        } else if (i == 1000) {
            executingEGLInited(commonEventBean);
        } else if (i != 1001) {
            switch (i) {
                case 602:
                    executingEGLDisplaySurfaceCreate(commonEventBean);
                    return;
                case 603:
                    executingEGLDisplaySurfaceRelease(commonEventBean);
                    return;
                case EGL_VIDEO_ENCODER_SURFACE_CREATED /*604*/:
                    executingEGLEncodeSurfaceCreated(commonEventBean);
                    return;
                case EGL_VIDEO_ENCODER_SURFACE_RELEASE /*605*/:
                    executingEGLEncodeSurfaceReleased(commonEventBean);
                    return;
                default:
                    return;
            }
        } else {
            executingEGLunInited();
        }
    }

    public void handleEGLRenderError(int i) {
        this.onVideoRendererAddSurfaceCallBack.onVideoFrameDrawingFailed(i);
    }

    public boolean onEGLSurfaceHolderDrawFrame(EGLSurfaceWrap eGLSurfaceWrap) {
        Object obj = eGLSurfaceWrap.window;
        if (obj == null || !this.mRendererStarted) {
            return true;
        }
        if (eGLSurfaceWrap.mWindowId != null) {
            MediaCodecSurface mediaCodecSurface = this.mMediaCodecSurface;
            if (mediaCodecSurface != null && mediaCodecSurface.getId().equals(eGLSurfaceWrap.mWindowId)) {
                this.mLocalOpenGLRenderer.renderingEncoder(mediaCodecSurface);
            }
            MediaCodecSurface mediaCodecSurface2 = this.mDualMediaCodecSurface;
            if (mediaCodecSurface2 != null && mediaCodecSurface2.getId().equals(eGLSurfaceWrap.mWindowId)) {
                this.mLocalOpenGLRenderer.renderingEncoder(mediaCodecSurface2);
            }
        } else if (obj == this.mDisplaySurfaceTexture) {
            return this.mLocalOpenGLRenderer.renderingDisplay();
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0030, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void executingEGLRendererWorking(com.wushuangtech.bean.CommonEventBean r3) {
        /*
            r2 = this;
            java.lang.Object r3 = r2.mLock
            monitor-enter(r3)
            boolean r0 = r2.mRendererStarted     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            return
        L_0x0009:
            r2.checkRotate()     // Catch:{ all -> 0x0031 }
            boolean r0 = r2.mPauseRenderer     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            return
        L_0x0012:
            com.wushuangtech.library.video.egl.EGLSurfaceHolder r0 = r2.mEGLSurfaceHolder     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x0018
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            return
        L_0x0018:
            r0 = 1
            r2.drawOpenGLForDisplay(r0)     // Catch:{ all -> 0x0031 }
            boolean r0 = r2.checkEncoderStatus()     // Catch:{ all -> 0x0031 }
            boolean r1 = r2.mEGLEncodeStop     // Catch:{ all -> 0x0031 }
            if (r1 != 0) goto L_0x002f
            if (r0 == 0) goto L_0x0027
            goto L_0x002f
        L_0x0027:
            r2.drawOpenGLForEncode()     // Catch:{ all -> 0x0031 }
            r2.drawOpenGLForDualEncode()     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            return
        L_0x002f:
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            return
        L_0x0031:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.render.LocalVideoRenderer.executingEGLRendererWorking(com.wushuangtech.bean.CommonEventBean):void");
    }

    private boolean checkEncoderStatus() {
        if (!this.mWaitingForEncoderRestart || this.mWaitStartTimestamp <= 0) {
            return false;
        }
        if (System.currentTimeMillis() - this.mWaitStartTimestamp <= 500) {
            return true;
        }
        this.mWaitStartTimestamp = 0;
        OmniLog.i(TAG, OmniLog.SCREEN_ROTATE, "Encoder restart too slow!");
        return false;
    }

    private void checkRotate() {
        try {
            if (this.mDefaultDisplay == null) {
                Display defaultDisplay = ((WindowManager) GlobalHolder.getInstance().getContext().getSystemService("window")).getDefaultDisplay();
                this.mDefaultDisplay = defaultDisplay;
                if (defaultDisplay == null) {
                    return;
                }
            }
            int rotation = this.mDefaultDisplay.getRotation();
            if (rotation != this.mLastRotation) {
                String str = TAG;
                OmniLog.i(str, OmniLog.SCREEN_ROTATE, "Check screen rotate changed, current = " + rotation + ", last = " + this.mLastRotation + ", rotate = " + this.mVideoCapRotate);
                this.mLastRotation = rotation;
                synchronized (this.mLock) {
                    this.mWaitingForEncoderRestart = true;
                    this.mWaitStartTimestamp = System.currentTimeMillis();
                }
                this.onVideoRendererAddSurfaceCallBack.onScreenRotateChanged(rotation);
            }
        } catch (Exception e) {
            String str2 = TAG;
            OmniLog.w(str2, OmniLog.SCREEN_ROTATE, "Check screen rotate exception = " + e.getLocalizedMessage());
        }
    }

    private void drawOpenGLForDisplay(boolean z) {
        if (this.mDisplayRenderSmooth == null) {
            this.mDisplayRenderSmooth = new RenderSmooth(this.mRenderFps);
        }
        if (this.mDisplayRenderSmooth.smoothTimestamp() <= 0 && z) {
            return;
        }
        if (!this.mLocalOpenGLRenderer.renderingBase()) {
            log(true, TAG, "Rendering EGLSurface failed for display failed... ");
            this.onVideoRendererAddSurfaceCallBack.onVideoFrameDrawingFailed(VideoErrorConstants.RENDER_DRAW_FAILED);
        } else if (this.mEGLSurfaceHolder != null) {
            long currentTimeMillis = System.currentTimeMillis();
            EGLSurfaceWrap eGLSurface = this.mEGLSurfaceHolder.getEGLSurface(this.mDisplaySurfaceTexture);
            if (eGLSurface == null) {
                FastLogCacheBean fastLogCacheBean = this.mRenderDisplayEGLSurfaceEmpty;
                fastLogCacheBean.mMessage = "Rendering EGLSurface failed for display failed, EGLSurfaceWrap is null! mDisplaySurfaceTexture = " + this.mDisplaySurfaceTexture;
                OmniLog.fd(this.mRenderDisplayEGLSurfaceEmpty);
            } else if (!this.mEGLSurfaceHolder.renderEGLSurface(eGLSurface)) {
                FastLogCacheBean fastLogCacheBean2 = this.mRenderDisplayEGLSurfaceFailed;
                fastLogCacheBean2.mMessage = "Rendering EGLSurface failed for display" + eGLSurface + " mDisplaySurfaceTexture = " + this.mDisplaySurfaceTexture;
                OmniLog.fd(this.mRenderDisplayEGLSurfaceFailed);
                VideoStatus.mVideoDisplayRenderErrorNum = VideoStatus.mVideoDisplayRenderErrorNum + 1;
                this.onVideoRendererAddSurfaceCallBack.onVideoFrameDrawingFailed(1501);
            } else {
                reportVideoLocalFirstFrame();
                VideoStatus.videoCapFrameEffectDisplay = (int) (System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    private void drawOpenGLForEncode() {
        if (this.mMainEncoderSmooth == null) {
            this.mMainEncoderSmooth = new RenderSmooth(this.mMainEncoderFps);
        }
        if (this.mMainEncoderSmooth.smoothTimestamp() > 0 && this.mMediaCodecSurface != null) {
            long currentTimeMillis = System.currentTimeMillis();
            EGLSurfaceWrap eGLSurface = this.mEGLSurfaceHolder.getEGLSurface(this.mMediaCodecSurface.getSurface());
            if (eGLSurface != null) {
                VideoStatus.mVideoEncodeRecvFrameTimes++;
                if (!this.mEGLSurfaceHolder.renderEGLSurface(eGLSurface)) {
                    VideoStatus.mVideoEncodeRenderErrorNum++;
                    this.onVideoRendererAddSurfaceCallBack.onVideoFrameDrawingFailed(VideoErrorConstants.RENDER_EGL_ENCODE_SURFACE_FAILED);
                    return;
                }
                VideoStatistical globalVideoStatistical = GlobalHolder.getInstance().getGlobalVideoStatistical();
                if (globalVideoStatistical != null) {
                    globalVideoStatistical.updateVideoLocalEncodeStart();
                }
                VideoStatus.videoCapFrameEffectEncoder = (int) (System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    private void drawOpenGLForDualEncode() {
        if (this.mDualEncoderSmooth == null) {
            this.mDualEncoderSmooth = new RenderSmooth(this.mDualEncoderFps);
        }
        if (this.mDualEncoderSmooth.smoothTimestamp() > 0 && this.mDualMediaCodecSurface != null) {
            long currentTimeMillis = System.currentTimeMillis();
            EGLSurfaceWrap eGLSurface = this.mEGLSurfaceHolder.getEGLSurface(this.mDualMediaCodecSurface.getSurface());
            if (eGLSurface != null) {
                VideoStatus.mVideoEncodeRecvFrameTimes++;
                if (!this.mEGLSurfaceHolder.renderEGLSurface(eGLSurface)) {
                    VideoStatus.mVideoDualEncodeRenderErrorNum++;
                } else {
                    VideoStatus.videoCapFrameEffectDualEncoder = (int) (System.currentTimeMillis() - currentTimeMillis);
                }
            }
        }
    }

    private void reportVideoLocalFirstFrame() {
        if (!this.mNotifyFirstFrameDraw && this.onVideoRendererAddSurfaceCallBack.onVideoRendererFirstFrame()) {
            this.mNotifyFirstFrameDraw = true;
        }
    }

    private void executingEGLInited(CommonEventBean commonEventBean) {
        boolean booleanValue = ((Boolean) commonEventBean.mObjects[0]).booleanValue();
        String str = TAG;
        log(false, str, "Executing start EGL init..." + booleanValue);
        if (!booleanValue) {
            this.onVideoRendererAddSurfaceCallBack.initVideoRendererResult(booleanValue);
            return;
        }
        BaseEGL baseEGL = this.mEGLEnvImpl.getBaseEGL();
        this.mLocalOpenGLRenderer.setOpenGLRendererCallBack(this);
        this.mEGLSurfaceHolder = new EGLSurfaceHolder(baseEGL, this);
        createSurfaceTexture();
        this.mLocalOpenGLRenderer.setSurfaceTexture(this.mVideoCapSurfaceTexture);
    }

    private void executingEGLunInited() {
        log(false, TAG, "Executing start destory local video renderer...");
        executingEGLRendererStop();
        EGLSurfaceHolder eGLSurfaceHolder = this.mEGLSurfaceHolder;
        if (eGLSurfaceHolder != null) {
            eGLSurfaceHolder.destroy();
            this.mEGLSurfaceHolder = null;
        }
        MediaCodecSurface mediaCodecSurface = this.mMediaCodecSurface;
        if (mediaCodecSurface != null) {
            mediaCodecSurface.release();
            this.mMediaCodecSurface = null;
        }
        MediaCodecSurface mediaCodecSurface2 = this.mDualMediaCodecSurface;
        if (mediaCodecSurface2 != null) {
            mediaCodecSurface2.release();
            this.mDualMediaCodecSurface = null;
        }
        this.onVideoRendererAddSurfaceCallBack.onVideoRendererUninit();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void executingEGLRendererStart() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.mLock
            monitor-enter(r0)
            boolean r1 = r4.mRendererStarted     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x0009:
            int r1 = r4.mCameraTextureId     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0038
            android.graphics.SurfaceTexture r1 = r4.mVideoCapSurfaceTexture     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0012
            goto L_0x0038
        L_0x0012:
            r1 = 0
            java.lang.String r2 = TAG     // Catch:{ all -> 0x003a }
            java.lang.String r3 = "Executing local video renderer start! "
            r4.log(r1, r2, r3)     // Catch:{ all -> 0x003a }
            r1 = 1
            r4.initVariables(r1)     // Catch:{ all -> 0x003a }
            com.wushuangtech.myvideoimprove.bean.LocalOpenGLRendererBean r1 = new com.wushuangtech.myvideoimprove.bean.LocalOpenGLRendererBean     // Catch:{ all -> 0x003a }
            r1.<init>()     // Catch:{ all -> 0x003a }
            int r2 = r4.mCameraTextureId     // Catch:{ all -> 0x003a }
            r1.mCameraTextureId = r2     // Catch:{ all -> 0x003a }
            android.graphics.SurfaceTexture r2 = r4.mVideoCapSurfaceTexture     // Catch:{ all -> 0x003a }
            r1.mVideoCapSurfaceTexture = r2     // Catch:{ all -> 0x003a }
            com.wushuangtech.myvideoimprove.render.LocalOpenGLRenderer r2 = r4.mLocalOpenGLRenderer     // Catch:{ all -> 0x003a }
            r2.startRendering(r1)     // Catch:{ all -> 0x003a }
            r4.drawSurfaceNow()     // Catch:{ all -> 0x003a }
            r4.startGLThread()     // Catch:{ all -> 0x003a }
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x003a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.render.LocalVideoRenderer.executingEGLRendererStart():void");
    }

    private void drawSurfaceNow() {
        CommonEventBean commonEventBean = new CommonEventBean();
        commonEventBean.mEventType = 1003;
        commonEventBean.mObjects = new Object[]{false};
        this.mEGLEnvImpl.handleRendererEvent(commonEventBean);
    }

    private void executingEGLRendererStop() {
        long currentTimeMillis = System.currentTimeMillis();
        String str = TAG;
        log(false, str, "Executing local video renderer stop! mRendererStarted: " + this.mRendererStarted);
        synchronized (this.mLock) {
            if (this.mRendererStarted) {
                initVariables(false);
                this.mLocalOpenGLRenderer.clearResource();
                int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
                releaseSurfaceTexture();
                createSurfaceTexture();
                this.mLocalOpenGLRenderer.setSurfaceTexture(this.mVideoCapSurfaceTexture);
                stopGLThread();
                int currentTimeMillis3 = (int) (System.currentTimeMillis() - currentTimeMillis);
                log(false, str, "Executing stop renderer over! time spend : " + currentTimeMillis2 + " | " + currentTimeMillis3);
            }
        }
    }

    private void executingEGLDisplaySurfaceCreate(CommonEventBean commonEventBean) {
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = commonEventBean.mObjects[0];
        Object obj2 = commonEventBean.mObjects[1];
        VideoRenderView videoRenderView = (VideoRenderView) this.mVideoRenderViewRef.get();
        String str = TAG;
        log(false, str, "Executing EGL display surface created, new : " + obj2 + " current: " + this.mDisplaySurfaceTexture + " | new: " + obj + " | current: " + videoRenderView);
        if (obj2 != null && obj != null && videoRenderView != null && videoRenderView == obj && this.mEGLSurfaceHolder != null) {
            if (this.mDisplaySurfaceTexture != null) {
                OmniLog.i(str, "releaseEGLSurface mDisplaySurfaceTexture:" + this.mDisplaySurfaceTexture);
                this.mEGLSurfaceHolder.releaseEGLSurface(this.mDisplaySurfaceTexture);
                this.mDisplaySurfaceTexture = null;
                VideoStatus.mLocalVideoEGLDisplaySurfaceNum = VideoStatus.mLocalVideoEGLDisplaySurfaceNum - 1;
                OmniLog.i("Executing display surface released over! 555 time spend : " + (System.currentTimeMillis() - currentTimeMillis) + " mLocalVideoEGLDisplaySurfaceNum:" + VideoStatus.mLocalVideoEGLDisplaySurfaceNum);
            }
            if (!this.mEGLSurfaceHolder.addEGLSurface(EGLSurfaceType.DISPLAY, obj2)) {
                this.onVideoRendererAddSurfaceCallBack.onVideoFrameDrawingFailed(VideoErrorConstants.RENDER_EGL_DISPLAY_ADD_SURFACE_FAILED);
                return;
            }
            this.mDisplaySurfaceTexture = obj2;
            OmniLog.i(str, "new mDisplaySurfaceTexture:" + this.mDisplaySurfaceTexture);
            VideoStatus.mLocalVideoEGLDisplaySurfaceNum = VideoStatus.mLocalVideoEGLDisplaySurfaceNum + 1;
            log(false, str, "Executing display surface created over! time spend : " + (System.currentTimeMillis() - currentTimeMillis) + " mLocalVideoEGLDisplaySurfaceNum:" + VideoStatus.mLocalVideoEGLDisplaySurfaceNum);
        }
    }

    private void executingEGLDisplaySurfaceRelease(CommonEventBean commonEventBean) {
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = commonEventBean.mObjects[0];
        Object obj2 = commonEventBean.mObjects[1];
        VideoRenderView videoRenderView = (VideoRenderView) this.mVideoRenderViewRef.get();
        OmniLog.i("Executing EGL display surface release, new: " + obj2 + " current: " + this.mDisplaySurfaceTexture + " | new: " + obj + " | current: " + videoRenderView);
        if (obj == null || obj2 == null || videoRenderView == null) {
            OmniLog.e(TAG, "executingEGLDisplaySurfaceRelease videoRenderView:" + obj + " recvDisplaySurfaceTexture:" + obj2 + " currentVideoRenderView:" + videoRenderView);
            return;
        }
        EGLSurfaceHolder eGLSurfaceHolder = this.mEGLSurfaceHolder;
        if (eGLSurfaceHolder != null && videoRenderView == obj) {
            eGLSurfaceHolder.releaseEGLSurface(obj2);
            this.mDisplaySurfaceTexture = null;
            VideoStatus.mLocalVideoEGLDisplaySurfaceNum--;
            OmniLog.i("Executing display surface released over! time spend : " + (System.currentTimeMillis() - currentTimeMillis) + " mLocalVideoEGLDisplaySurfaceNum:" + VideoStatus.mLocalVideoEGLDisplaySurfaceNum);
        }
    }

    private void executingEGLEncodeSurfaceCreated(CommonEventBean commonEventBean) {
        MediaCodecSurface mediaCodecSurface;
        MediaCodecSurface mediaCodecSurface2 = (MediaCodecSurface) commonEventBean.mObjects[0];
        String str = TAG;
        log(false, str, "executingEGLEncodeSurfaceCreated new surface : " + mediaCodecSurface2);
        if (mediaCodecSurface2 != null) {
            EGLSurfaceHolder eGLSurfaceHolder = this.mEGLSurfaceHolder;
            if (eGLSurfaceHolder == null) {
                logE(str, "executingEGLEncodeSurfaceCreated Executing EGL encode surface create failed! Map is null...");
                return;
            }
            int flag = mediaCodecSurface2.getFlag();
            String id = mediaCodecSurface2.getId();
            if (flag == 1) {
                mediaCodecSurface = this.mMediaCodecSurface;
            } else {
                mediaCodecSurface = this.mDualMediaCodecSurface;
            }
            if (mediaCodecSurface == null || !mediaCodecSurface.getId().equals(id)) {
                if (mediaCodecSurface != null) {
                    boolean releaseEGLSurface = eGLSurfaceHolder.releaseEGLSurface(mediaCodecSurface);
                    if (releaseEGLSurface) {
                        if (flag == 1) {
                            this.mMediaCodecSurface = null;
                        } else {
                            this.mDualMediaCodecSurface = null;
                        }
                    }
                    log(false, str, "bug1001 Executing EGL encode surface create, release old surface result : " + releaseEGLSurface);
                }
                if (!eGLSurfaceHolder.addEGLSurface(EGLSurfaceType.ENCODE, mediaCodecSurface2)) {
                    logE(str, "bug1001 Executing EGL encode surface create failed..." + mediaCodecSurface2.toString());
                    return;
                }
                if (flag == 1) {
                    this.mMediaCodecSurface = mediaCodecSurface2;
                } else {
                    this.mDualMediaCodecSurface = mediaCodecSurface2;
                }
                VideoStatus.mLocalVideoEGLEncodeSurfaceNum++;
                log(false, str, "executingEGLEncodeSurfaceCreated Executing EGL encode surface create success... " + mediaCodecSurface2.toString());
                return;
            }
            logE(str, "executingEGLEncodeSurfaceCreated oldMediaCodecSurface:" + this.mMediaCodecSurface + " mediaCodecSurface:" + mediaCodecSurface2);
        }
    }

    private void executingEGLEncodeSurfaceReleased(CommonEventBean commonEventBean) {
        MediaCodecSurface mediaCodecSurface;
        MediaCodecSurface mediaCodecSurface2 = (MediaCodecSurface) commonEventBean.mObjects[0];
        if (mediaCodecSurface2 != null) {
            String str = TAG;
            log(false, str, "executingEGLEncodeSurfaceReleased mediaCodecSurface : " + mediaCodecSurface2);
            EGLSurfaceHolder eGLSurfaceHolder = this.mEGLSurfaceHolder;
            if (eGLSurfaceHolder != null) {
                int flag = mediaCodecSurface2.getFlag();
                if (flag == 1) {
                    mediaCodecSurface = this.mMediaCodecSurface;
                } else {
                    mediaCodecSurface = this.mDualMediaCodecSurface;
                }
                if (mediaCodecSurface != null && mediaCodecSurface.getId().equals(mediaCodecSurface2.getId())) {
                    boolean releaseEGLSurface = eGLSurfaceHolder.releaseEGLSurface(mediaCodecSurface2);
                    if (flag == 1) {
                        this.mMediaCodecSurface = null;
                    } else {
                        this.mDualMediaCodecSurface = null;
                    }
                    VideoStatus.mLocalVideoEGLEncodeSurfaceNum--;
                    log(false, str, "bug1001 Executing EGL encode surface release success, result " + releaseEGLSurface + " | surface : " + mediaCodecSurface2.toString());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void log(boolean z, String str, String str2) {
        if (z) {
            OmniLog.d(OmniLog.VIDEO_RENDER_WATCH, str, str2);
        } else {
            OmniLog.i(OmniLog.VIDEO_RENDER_WATCH, str, str2);
        }
    }

    /* access modifiers changed from: protected */
    public void logE(String str, String str2) {
        OmniLog.e(OmniLog.VIDEO_RENDER_WATCH, str, str2);
    }

    private void initVariables(boolean z) {
        this.mRendererStarted = z;
        if (z) {
            VideoStatus.mEglRenderStatus = VideoStatus.OpenglESRenderStatus.RENDERING;
            this.mPauseRenderer = false;
            this.mNotifyFirstFrameDraw = false;
            this.mFirstFrameDraw = false;
            return;
        }
        VideoStatus.mEglRenderStatus = VideoStatus.OpenglESRenderStatus.STOP;
        this.mWaitingForEncoderRestart = false;
        this.mWaitStartTimestamp = 0;
        this.mLastExpectWidth = 0;
        this.mLastExpectHeight = 0;
        this.mLastPreviewWidth = 0;
        this.mLastPreviewHeight = 0;
        this.mLastPreviewRotate = 0;
        this.mLastRotation = -1;
    }

    private void createSurfaceTexture() {
        int createWhiteOESTextureId = MyGLUtils.createWhiteOESTextureId();
        this.mCameraTextureId = createWhiteOESTextureId;
        this.mLocalOpenGLRenderer.setSurfaceTextureId(createWhiteOESTextureId);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mCameraTextureId);
        this.mVideoCapSurfaceTexture = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_HEIGHT, GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_WIDTH);
    }

    private void releaseSurfaceTexture() {
        int i = this.mCameraTextureId;
        if (i != 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            this.mCameraTextureId = 0;
        }
        SurfaceTexture surfaceTexture = this.mVideoCapSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mVideoCapSurfaceTexture = null;
        }
    }

    private void startGLThread() {
        if (this.mEGLEnvImpl != null) {
            if (this.mEGLRenderRateControl == null) {
                this.mEGLRenderRateControl = new EGLRenderRateControl(this.mEGLEnvImpl, VideoStatus.THREAD_VIDEO_LOCAL_GLRATE);
            }
            CommonEventBean commonEventBean = new CommonEventBean();
            commonEventBean.mEventType = 1003;
            commonEventBean.mObjects = new Object[]{false};
            this.mEGLRenderRateControl.startGLThread(commonEventBean);
        }
    }

    private void stopGLThread() {
        EGLRenderRateControl eGLRenderRateControl = this.mEGLRenderRateControl;
        if (eGLRenderRateControl != null) {
            eGLRenderRateControl.stopGLThread();
            this.mEGLRenderRateControl = null;
        }
    }

    private int[] calcReadPixelSuitSize(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int[] adjustSizeByRotate = DeviceUtils.adjustSizeByRotate(i3, i4, i5);
        int i8 = adjustSizeByRotate[0];
        int i9 = adjustSizeByRotate[1];
        float f = ((float) i) / ((float) i2);
        float f2 = (float) i8;
        float f3 = (float) i9;
        if (f != f2 / f3) {
            i2 = (int) (f2 / f);
            if (i2 > i9) {
                i = (int) (f * f3);
                i2 = i9;
            } else {
                i = i8;
            }
        }
        int i10 = i % 8;
        if (i10 != 0) {
            i -= i10;
        }
        int i11 = i2 % 8;
        if (i11 != 0) {
            i2 -= i11;
        }
        if (i5 == 90 || i5 == 270) {
            int i12 = (i4 - i) / 2;
            i6 = (i3 - i2) / 2;
            i7 = i12;
        } else {
            i7 = (i3 - i) / 2;
            i6 = (i4 - i2) / 2;
        }
        String str = TAG;
        log(true, str, "Calc read pixel params -> adapter size : " + i + " * " + i2 + " | start location : " + i7 + " * " + i6);
        return new int[]{i7, i6, i, i2};
    }

    private boolean isMtk() {
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                int length = supportedTypes.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (supportedTypes[i2].equalsIgnoreCase("video/avc")) {
                        mediaCodecInfo = codecInfoAt;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (mediaCodecInfo != null) {
                    break;
                }
            }
        }
        if (mediaCodecInfo == null || !mediaCodecInfo.getName().contains("MTK")) {
            return false;
        }
        return true;
    }

    private void handleSyncEvent(CommonEventBean commonEventBean) {
        this.mEGLEnvImpl.handleSyncMessage(commonEventBean);
    }
}
