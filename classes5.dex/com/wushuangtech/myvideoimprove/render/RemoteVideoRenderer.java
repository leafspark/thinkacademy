package com.wushuangtech.myvideoimprove.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.bean.FastLogCacheBean;
import com.wushuangtech.bean.LogEvent;
import com.wushuangtech.constants.RtcEngineEvent;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.GlobalVideoConfig;
import com.wushuangtech.library.video.VideoStatistical;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.library.video.bean.VideoRemoteRawDataBean;
import com.wushuangtech.library.video.egl.EGLEnvImpl;
import com.wushuangtech.library.video.egl.EGLSurfaceHolder;
import com.wushuangtech.library.video.egl.EGLSurfaceType;
import com.wushuangtech.library.video.egl.EGLSurfaceWrap;
import com.wushuangtech.myvideoimprove.VideoRenderer;
import com.wushuangtech.myvideoimprove.bean.VideoRenderViewLifeBean;
import com.wushuangtech.myvideoimprove.render.VideoRendererImpl;
import com.wushuangtech.myvideoimprove.view.VideoRenderView;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;

public class RemoteVideoRenderer extends VideoRendererImpl {
    private static final int EGL_SET_VIDEO_SIZE = 2;
    private static final int EGL_SURFACE_DISPLAY_ADD = 3;
    private static final int EGL_SURFACE_DISPLAY_REMOVE = 4;
    private static final int RENDER_ERROR_OPENGL_FAILED = -10;
    private static final int RENDER_ERROR_SWAP_BUFFER_FAILED = -11;
    /* access modifiers changed from: private */
    public final String TAG;
    private Object mCacheDisplayWindow;
    private final String mChannelName;
    /* access modifiers changed from: private */
    public final String mDeviceId;
    private Object mDisplaySurfaceTexture;
    /* access modifiers changed from: private */
    public EGLEnvImpl mEGLEnvImpl;
    private EGLSurfaceHolder mEGLSurfaceHolder;
    /* access modifiers changed from: private */
    public volatile boolean mInited;
    protected final OnRemoteVideoRendererCallBack mOnRemoteVideoRendererCallBack;
    /* access modifiers changed from: private */
    public final RemoteOpenGLRenderer mRemoteOpenGLRenderer;
    private long mRenderErrorStartTimestamp;
    public long mRenderFailedCount;
    private int mRenderStatus;
    public long mRenderSuccessCount;
    private final FastLogCacheBean mRendingBean;
    private boolean mSizeChanged;
    private final long mUid;
    private volatile boolean mWaitForTextureUpdate;

    public interface OnRemoteVideoRendererCallBack {
        void onEGLSurfaceDisplayRenderError(String str);

        void onRenderFinish(String str);

        void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, String str);
    }

    public void destroyVideoRenderer() {
    }

    /* access modifiers changed from: protected */
    public void handleEGLRenderError(int i) {
    }

    public void pauseRender() {
    }

    public void resumeRender() {
    }

    public boolean startRender() {
        return false;
    }

    public void stopRender() {
    }

    public RemoteVideoRenderer(String str, long j, String str2, OnRemoteVideoRendererCallBack onRemoteVideoRendererCallBack) {
        super((VideoRenderer.OnVideoRendererAddSurfaceCallBack) null);
        this.mChannelName = str;
        this.mUid = j;
        this.mDeviceId = str2;
        this.mOnRemoteVideoRendererCallBack = onRemoteVideoRendererCallBack;
        RemoteOpenGLRenderer remoteOpenGLRenderer = new RemoteOpenGLRenderer(str2, this);
        this.mRemoteOpenGLRenderer = remoteOpenGLRenderer;
        String str3 = "RemoteVideoRenderer<" + str2 + ">";
        this.TAG = str3;
        remoteOpenGLRenderer.setTAG(str3);
        FastLogCacheBean fastLogCacheBean = new FastLogCacheBean("RemoteVideoRenderer-handleEGLEventForRending-" + str2, "RVW", str3, 4);
        this.mRendingBean = fastLogCacheBean;
        fastLogCacheBean.mInterval = RtcEngineEvent.AudioEvent.EVENT_AUDIO_START_POINT;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mRemoteOpenGLRenderer.getSurfaceTexture();
    }

    public void setVideoSize(int i, int i2) {
        EGLEnvImpl eGLEnvImpl = this.mEGLEnvImpl;
        if (eGLEnvImpl != null) {
            CommonEventBean commonEventBean = new CommonEventBean();
            commonEventBean.mEventType = 2;
            commonEventBean.mObject = this.mDeviceId;
            commonEventBean.mObjects = new Object[]{Integer.valueOf(i), Integer.valueOf(i2)};
            eGLEnvImpl.handleRendererEventUrgent(commonEventBean);
        }
    }

    public void setRenderMode(int i) {
        this.mRemoteOpenGLRenderer.setRenderMode(i);
    }

    public void setMirrorMode(int i) {
        this.mRemoteOpenGLRenderer.setMirrorMode(i);
    }

    public void setViewSize(int i, int i2) {
        this.mRemoteOpenGLRenderer.setPreviewSize(i, i2);
    }

    public void requestRender(VideoRemoteRawDataBean videoRemoteRawDataBean) {
        EGLEnvImpl eGLEnvImpl = this.mEGLEnvImpl;
        if (eGLEnvImpl != null) {
            CommonEventBean commonEventBean = new CommonEventBean();
            commonEventBean.mObject = videoRemoteRawDataBean;
            commonEventBean.mEventType = 1003;
            eGLEnvImpl.handleRendererEvent(commonEventBean);
        }
    }

    public void waitForTextureUpdate() {
        this.mWaitForTextureUpdate = true;
    }

    public void stopWiatForTextureUpdate() {
        this.mWaitForTextureUpdate = false;
    }

    public void initRenderer() {
        if (this.mEGLEnvImpl == null) {
            EGLEnvImpl eGLEnvImpl = new EGLEnvImpl(VideoStatus.THREAD_VIDEO_REMOTE_GLENV, new VideoRendererImpl.LocalEGLEventCallBackImpl(this));
            this.mEGLEnvImpl = eGLEnvImpl;
            eGLEnvImpl.setIgnoreInitCheck(true);
            this.mEGLEnvImpl.setTAG(this.TAG);
            this.mEGLEnvImpl.setLogFlag(2);
            this.mEGLEnvImpl.initEGL14((EGLContext) null);
        }
    }

    public void setVideoRenderView(VideoRenderView videoRenderView) {
        super.setVideoRenderView(videoRenderView);
        videoRenderView.setVideoRenderViewCallBack(new LocalVideoRenderViewCallBackImpl(this));
        int[] viewSize = videoRenderView.getViewSize();
        if (viewSize != null) {
            setViewSize(viewSize[0], viewSize[1]);
        }
        EGLEnvImpl eGLEnvImpl = this.mEGLEnvImpl;
        Object nativeWindow = videoRenderView.getNativeWindow();
        if (nativeWindow != null && eGLEnvImpl != null) {
            CommonEventBean commonEventBean = new CommonEventBean();
            commonEventBean.mEventType = 3;
            commonEventBean.mObject = nativeWindow;
            eGLEnvImpl.handleRendererEventUrgent(commonEventBean);
        }
    }

    public void unInitVideoRenderer() {
        EGLEnvImpl eGLEnvImpl = this.mEGLEnvImpl;
        if (eGLEnvImpl != null) {
            eGLEnvImpl.unInitEGL();
            this.mEGLEnvImpl.destroyEGLThread();
            this.mEGLEnvImpl = null;
            String str = this.TAG;
            log(str, "Destroy EGL thread work over... " + this.mDeviceId);
        }
    }

    /* access modifiers changed from: protected */
    public void handleEGLRenderEvent(CommonEventBean commonEventBean) {
        int i = commonEventBean.mEventType;
        if (i == 2) {
            handleEGLEventForSetVideoSize(commonEventBean);
        } else if (i == 3) {
            handleEGLEventForDisplayViewAdd(commonEventBean);
        } else if (i == 4) {
            handleEGLEventForDisplayViewRemove(commonEventBean);
        } else if (i == 1000) {
            handleEGLEventForInit();
        } else if (i == 1001) {
            handleEGLEventForUnInit();
        } else if (i == 1003) {
            handleEGLEventForRending((VideoRemoteRawDataBean) commonEventBean.mObject);
        }
    }

    private void handleEGLEventForInit() {
        EGLEnvImpl eGLEnvImpl = this.mEGLEnvImpl;
        if (!this.mInited && eGLEnvImpl != null) {
            this.mRemoteOpenGLRenderer.initRenderer();
            this.mEGLSurfaceHolder = new EGLSurfaceHolder(eGLEnvImpl.getBaseEGL(), new LocalEGLSurfaceHolderCallBackImpl(this));
            this.mInited = true;
            String str = this.TAG;
            log(str, "EGL init over, cache windows=" + this.mCacheDisplayWindow);
            if (this.mCacheDisplayWindow != null) {
                CommonEventBean commonEventBean = new CommonEventBean();
                commonEventBean.mEventType = 3;
                commonEventBean.mObject = this.mCacheDisplayWindow;
                handleEGLEventForDisplayViewAdd(commonEventBean);
                this.mCacheDisplayWindow = null;
            }
        }
    }

    private void handleEGLEventForUnInit() {
        if (this.mInited) {
            this.mInited = false;
            this.mRemoteOpenGLRenderer.clearResource();
            this.mEGLSurfaceHolder.destroy();
            this.mDisplaySurfaceTexture = null;
            log(this.TAG, "EGL destroy over...");
        }
    }

    private void handleEGLEventForRending(VideoRemoteRawDataBean videoRemoteRawDataBean) {
        long currentTimeMillis = System.currentTimeMillis();
        int executingRender = executingRender(videoRemoteRawDataBean);
        if (executingRender == 0) {
            calcVideoCaton(currentTimeMillis);
            VideoStatistical globalVideoStatistical = GlobalHolder.getInstance().getGlobalVideoStatistical();
            if (globalVideoStatistical != null) {
                globalVideoStatistical.updateVideoRemoteRenderCount(this.mUid);
            }
        }
        if (executingRender == RENDER_ERROR_OPENGL_FAILED || executingRender == RENDER_ERROR_SWAP_BUFFER_FAILED) {
            this.mRenderFailedCount++;
        } else {
            this.mRenderSuccessCount++;
        }
        if (recordRenderStatus(executingRender)) {
            this.mOnRemoteVideoRendererCallBack.onEGLSurfaceDisplayRenderError(this.mDeviceId);
        }
        this.mRendingBean.mMessage = "OpenGL rending, success=" + this.mRenderSuccessCount + ", failed=" + this.mRenderFailedCount + ", result=" + executingRender;
        OmniLog.fd(this.mRendingBean);
    }

    private void handleEGLEventForDisplayViewAdd(CommonEventBean commonEventBean) {
        if (commonEventBean.mObject == null) {
            logE(this.TAG, "EGLSurface create failed! args error!");
            return;
        }
        Object obj = commonEventBean.mObject;
        if (!this.mInited) {
            String str = this.TAG;
            logE(str, "EGLSurface create failed! not init! add cache=" + obj);
            this.mCacheDisplayWindow = obj;
            return;
        }
        Object obj2 = this.mDisplaySurfaceTexture;
        this.mDisplaySurfaceTexture = null;
        if (obj2 != null && !this.mEGLSurfaceHolder.releaseEGLSurface(obj2)) {
            String str2 = this.TAG;
            logE(str2, "EGLSurface release failed! old window=" + obj2 + ", new=" + obj);
            this.mOnRemoteVideoRendererCallBack.onEGLSurfaceDisplayRenderError(this.mDeviceId);
        } else if (!this.mEGLSurfaceHolder.addEGLSurface(EGLSurfaceType.DISPLAY, obj)) {
            String str3 = this.TAG;
            logE(str3, "EGLSurface create failed! window=" + obj);
            this.mOnRemoteVideoRendererCallBack.onEGLSurfaceDisplayRenderError(this.mDeviceId);
        } else {
            this.mDisplaySurfaceTexture = obj;
            String str4 = this.TAG;
            log(str4, "EGLSurface create success! " + this.mDisplaySurfaceTexture);
        }
    }

    private void handleEGLEventForDisplayViewRemove(CommonEventBean commonEventBean) {
        if (commonEventBean.mObject == null) {
            logE(this.TAG, "EGLSurface release failed! args error!");
            return;
        }
        Object obj = commonEventBean.mObject;
        if (!this.mInited) {
            String str = this.TAG;
            logE(str, "EGLSurface release failed! not init! try remove cache!, new=" + obj + ", cache=" + this.mCacheDisplayWindow);
            Object obj2 = this.mCacheDisplayWindow;
            if (obj2 != null && obj2 == obj) {
                this.mCacheDisplayWindow = null;
                return;
            }
            return;
        }
        if (!this.mEGLSurfaceHolder.releaseEGLSurface(obj)) {
            String str2 = this.TAG;
            logE(str2, "EGLSurface release failed! window=" + obj);
        } else {
            String str3 = this.TAG;
            log(str3, "EGLSurface release success! window=" + obj);
        }
        this.mDisplaySurfaceTexture = null;
    }

    private void handleEGLEventForSetVideoSize(CommonEventBean commonEventBean) {
        int intValue = ((Integer) commonEventBean.mObjects[0]).intValue();
        int intValue2 = ((Integer) commonEventBean.mObjects[1]).intValue();
        String str = this.TAG;
        log(str, "Handle video size, videoWidth=" + intValue + ", videoHeight=" + intValue2);
        this.mRemoteOpenGLRenderer.setRenderSize(intValue, intValue2);
        this.mSizeChanged = true;
    }

    private int executingRender(VideoRemoteRawDataBean videoRemoteRawDataBean) {
        if (!this.mInited) {
            return -1;
        }
        if (videoRemoteRawDataBean.mData == null && this.mWaitForTextureUpdate) {
            return -2;
        }
        EGLSurfaceWrap eGLSurface = this.mEGLSurfaceHolder.getEGLSurface(this.mDisplaySurfaceTexture);
        if (eGLSurface == null) {
            return -3;
        }
        if (!this.mRemoteOpenGLRenderer.drawFrame(videoRemoteRawDataBean)) {
            return RENDER_ERROR_OPENGL_FAILED;
        }
        if (this.mSizeChanged) {
            this.mEGLSurfaceHolder.renderEGLSurface(eGLSurface, false);
            this.mSizeChanged = false;
            return -4;
        } else if (!this.mEGLSurfaceHolder.renderEGLSurface(eGLSurface, true)) {
            return RENDER_ERROR_SWAP_BUFFER_FAILED;
        } else {
            return 0;
        }
    }

    private void calcVideoCaton(long j) {
        int currentTimeMillis = (int) (System.currentTimeMillis() - j);
        if (currentTimeMillis >= 500) {
            GlobalHolder.getInstance().handleRtcEventReport(this.mChannelName, LogEvent.VIDEO_LOCAL_DOWNSTREAM_STUCK, this.mDeviceId, 4, Integer.valueOf(currentTimeMillis));
            GlobalVideoConfig globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig();
            if (globalVideoConfig != null) {
                globalVideoConfig.addVideoRemoteRenderCaton(this.mChannelName, this.mUid);
            }
        }
    }

    private boolean recordRenderStatus(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRenderStatus != i) {
            this.mRenderErrorStartTimestamp = currentTimeMillis;
            this.mRenderStatus = i;
        }
        int i2 = this.mRenderStatus;
        if ((i2 != RENDER_ERROR_OPENGL_FAILED && i2 != RENDER_ERROR_SWAP_BUFFER_FAILED) || currentTimeMillis - this.mRenderErrorStartTimestamp <= 3000) {
            return false;
        }
        this.mRenderErrorStartTimestamp = currentTimeMillis;
        String str = this.TAG;
        logE(str, "Render OpenGL Error! " + this.mRenderStatus);
        return true;
    }

    private void log(String str, String str2) {
        OmniLog.i("RVW", str, str2);
    }

    private void logE(String str, String str2) {
        OmniLog.e("RVW", str, str2);
    }

    private static class LocalVideoRenderViewCallBackImpl implements VideoRenderView.OnVideoRenderViewCallBack {
        private final WeakReference<RemoteVideoRenderer> mOutReference;

        public void onViewRenderAttachedToWindow(VideoRenderView videoRenderView) {
        }

        public void onViewRenderDetachedFromWindow(VideoRenderView videoRenderView) {
        }

        public LocalVideoRenderViewCallBackImpl(RemoteVideoRenderer remoteVideoRenderer) {
            this.mOutReference = new WeakReference<>(remoteVideoRenderer);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
            if (r7.mWidth == 0) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
            if (r7.mHeight == 0) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
            r0.setViewSize(r7.mWidth, r7.mHeight);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
            if (r7.mSurface != null) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x005c, code lost:
            com.wushuangtech.utils.OmniLog.e("RVW", com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer.access$000(r0), "onVideoRenderSurfaceAvailable... VideoRenderViewLifeBean surface is null...");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0067, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0068, code lost:
            r1 = com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer.access$100(r0);
            r3 = com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer.access$000(r0);
            com.wushuangtech.utils.OmniLog.i("RVW", r3, "onVideoRenderSurfaceAvailable... init=" + com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer.access$200(r0) + ", eglEnv=" + r1 + ", deviceId=" + com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer.access$300(r0) + ", bean=" + r7.toString());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00aa, code lost:
            if (r1 != null) goto L_0x00ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ac, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ad, code lost:
            r0 = new com.wushuangtech.bean.CommonEventBean();
            r0.mEventType = 3;
            r0.mObject = r7.mSurface;
            r1.handleRendererEventUrgent(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bc, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onVideoRenderSurfaceAvailable(com.wushuangtech.myvideoimprove.bean.VideoRenderViewLifeBean r7) {
            /*
                r6 = this;
                if (r7 != 0) goto L_0x0003
                return
            L_0x0003:
                java.lang.ref.WeakReference<com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer> r0 = r6.mOutReference
                java.lang.Object r0 = r0.get()
                com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer r0 = (com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer) r0
                if (r0 != 0) goto L_0x000e
                return
            L_0x000e:
                r1 = 0
                java.lang.ref.WeakReference r2 = r0.mVideoRenderViewRef
                if (r2 == 0) goto L_0x001b
                java.lang.ref.WeakReference r1 = r0.mVideoRenderViewRef
                java.lang.Object r1 = r1.get()
                com.wushuangtech.myvideoimprove.view.VideoRenderView r1 = (com.wushuangtech.myvideoimprove.view.VideoRenderView) r1
            L_0x001b:
                java.lang.Object r2 = r0.mViewLock
                monitor-enter(r2)
                java.lang.Object r3 = r7.mRenderView     // Catch:{ all -> 0x00bd }
                if (r1 == r3) goto L_0x0048
                java.lang.String r3 = "RVW"
                java.lang.String r0 = r0.TAG     // Catch:{ all -> 0x00bd }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
                r4.<init>()     // Catch:{ all -> 0x00bd }
                java.lang.String r5 = "onVideoRenderSurfaceAvailable... view not same! "
                r4.append(r5)     // Catch:{ all -> 0x00bd }
                r4.append(r1)     // Catch:{ all -> 0x00bd }
                java.lang.String r1 = " | bean : "
                r4.append(r1)     // Catch:{ all -> 0x00bd }
                java.lang.Object r7 = r7.mRenderView     // Catch:{ all -> 0x00bd }
                r4.append(r7)     // Catch:{ all -> 0x00bd }
                java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x00bd }
                com.wushuangtech.utils.OmniLog.e((java.lang.String) r3, (java.lang.String) r0, (java.lang.String) r7)     // Catch:{ all -> 0x00bd }
                monitor-exit(r2)     // Catch:{ all -> 0x00bd }
                return
            L_0x0048:
                monitor-exit(r2)     // Catch:{ all -> 0x00bd }
                int r1 = r7.mWidth
                if (r1 == 0) goto L_0x0058
                int r1 = r7.mHeight
                if (r1 == 0) goto L_0x0058
                int r1 = r7.mWidth
                int r2 = r7.mHeight
                r0.setViewSize(r1, r2)
            L_0x0058:
                java.lang.Object r1 = r7.mSurface
                if (r1 != 0) goto L_0x0068
                java.lang.String r7 = "RVW"
                java.lang.String r0 = r0.TAG
                java.lang.String r1 = "onVideoRenderSurfaceAvailable... VideoRenderViewLifeBean surface is null..."
                com.wushuangtech.utils.OmniLog.e((java.lang.String) r7, (java.lang.String) r0, (java.lang.String) r1)
                return
            L_0x0068:
                com.wushuangtech.library.video.egl.EGLEnvImpl r1 = r0.mEGLEnvImpl
                java.lang.String r2 = "RVW"
                java.lang.String r3 = r0.TAG
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "onVideoRenderSurfaceAvailable... init="
                r4.append(r5)
                boolean r5 = r0.mInited
                r4.append(r5)
                java.lang.String r5 = ", eglEnv="
                r4.append(r5)
                r4.append(r1)
                java.lang.String r5 = ", deviceId="
                r4.append(r5)
                java.lang.String r0 = r0.mDeviceId
                r4.append(r0)
                java.lang.String r0 = ", bean="
                r4.append(r0)
                java.lang.String r0 = r7.toString()
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                com.wushuangtech.utils.OmniLog.i(r2, r3, r0)
                if (r1 != 0) goto L_0x00ad
                return
            L_0x00ad:
                com.wushuangtech.bean.CommonEventBean r0 = new com.wushuangtech.bean.CommonEventBean
                r0.<init>()
                r2 = 3
                r0.mEventType = r2
                java.lang.Object r7 = r7.mSurface
                r0.mObject = r7
                r1.handleRendererEventUrgent(r0)
                return
            L_0x00bd:
                r7 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x00bd }
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer.LocalVideoRenderViewCallBackImpl.onVideoRenderSurfaceAvailable(com.wushuangtech.myvideoimprove.bean.VideoRenderViewLifeBean):void");
        }

        public void onVideoRenderSurfaceSizeChanged(VideoRenderViewLifeBean videoRenderViewLifeBean) {
            RemoteVideoRenderer remoteVideoRenderer;
            if (videoRenderViewLifeBean != null && (remoteVideoRenderer = (RemoteVideoRenderer) this.mOutReference.get()) != null) {
                VideoRenderView videoRenderView = null;
                if (remoteVideoRenderer.mVideoRenderViewRef != null) {
                    videoRenderView = (VideoRenderView) remoteVideoRenderer.mVideoRenderViewRef.get();
                }
                synchronized (remoteVideoRenderer.mViewLock) {
                    if (videoRenderView != videoRenderViewLifeBean.mRenderView) {
                        String access$000 = remoteVideoRenderer.TAG;
                        OmniLog.e("RVW", access$000, "onVideoRenderSurfaceSizeChanged... view not same! " + videoRenderView + " | bean : " + videoRenderViewLifeBean.mRenderView);
                        return;
                    }
                    String access$0002 = remoteVideoRenderer.TAG;
                    OmniLog.i("RVW", access$0002, "onVideoRenderSurfaceSizeChanged... init=" + remoteVideoRenderer.mInited + ", eglEnv=" + remoteVideoRenderer.mEGLEnvImpl + ", deviceId=" + remoteVideoRenderer.mDeviceId + ", bean=" + videoRenderViewLifeBean.toString());
                    remoteVideoRenderer.setViewSize(videoRenderViewLifeBean.mWidth, videoRenderViewLifeBean.mHeight);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
            r1 = com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer.access$100(r0);
            r3 = com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer.access$000(r0);
            com.wushuangtech.utils.OmniLog.i("RVW", r3, "onVideoRenderSurfaceDestroyed... " + com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer.access$300(r0) + " | bean : " + r7.toString());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0077, code lost:
            if (r1 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x007b, code lost:
            if (r7.mSurface != null) goto L_0x007e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x007e, code lost:
            r0 = new com.wushuangtech.bean.CommonEventBean();
            r0.mEventType = 4;
            r0.mObject = r7.mSurface;
            r1.handleRendererEventUrgent(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onVideoRenderSurfaceDestroyed(com.wushuangtech.myvideoimprove.bean.VideoRenderViewLifeBean r7) {
            /*
                r6 = this;
                if (r7 != 0) goto L_0x0003
                return
            L_0x0003:
                java.lang.ref.WeakReference<com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer> r0 = r6.mOutReference
                java.lang.Object r0 = r0.get()
                com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer r0 = (com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer) r0
                if (r0 != 0) goto L_0x000e
                return
            L_0x000e:
                r1 = 0
                java.lang.ref.WeakReference r2 = r0.mVideoRenderViewRef
                if (r2 == 0) goto L_0x001b
                java.lang.ref.WeakReference r1 = r0.mVideoRenderViewRef
                java.lang.Object r1 = r1.get()
                com.wushuangtech.myvideoimprove.view.VideoRenderView r1 = (com.wushuangtech.myvideoimprove.view.VideoRenderView) r1
            L_0x001b:
                java.lang.Object r2 = r0.mViewLock
                monitor-enter(r2)
                java.lang.Object r3 = r7.mRenderView     // Catch:{ all -> 0x008e }
                if (r1 == r3) goto L_0x0048
                java.lang.String r3 = "RVW"
                java.lang.String r0 = r0.TAG     // Catch:{ all -> 0x008e }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
                r4.<init>()     // Catch:{ all -> 0x008e }
                java.lang.String r5 = "onVideoRenderSurfaceDestroyed... view not same! "
                r4.append(r5)     // Catch:{ all -> 0x008e }
                r4.append(r1)     // Catch:{ all -> 0x008e }
                java.lang.String r1 = " | bean : "
                r4.append(r1)     // Catch:{ all -> 0x008e }
                java.lang.Object r7 = r7.mRenderView     // Catch:{ all -> 0x008e }
                r4.append(r7)     // Catch:{ all -> 0x008e }
                java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x008e }
                com.wushuangtech.utils.OmniLog.e((java.lang.String) r3, (java.lang.String) r0, (java.lang.String) r7)     // Catch:{ all -> 0x008e }
                monitor-exit(r2)     // Catch:{ all -> 0x008e }
                return
            L_0x0048:
                monitor-exit(r2)     // Catch:{ all -> 0x008e }
                com.wushuangtech.library.video.egl.EGLEnvImpl r1 = r0.mEGLEnvImpl
                java.lang.String r2 = "RVW"
                java.lang.String r3 = r0.TAG
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "onVideoRenderSurfaceDestroyed... "
                r4.append(r5)
                java.lang.String r0 = r0.mDeviceId
                r4.append(r0)
                java.lang.String r0 = " | bean : "
                r4.append(r0)
                java.lang.String r0 = r7.toString()
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                com.wushuangtech.utils.OmniLog.i(r2, r3, r0)
                if (r1 == 0) goto L_0x008d
                java.lang.Object r0 = r7.mSurface
                if (r0 != 0) goto L_0x007e
                goto L_0x008d
            L_0x007e:
                com.wushuangtech.bean.CommonEventBean r0 = new com.wushuangtech.bean.CommonEventBean
                r0.<init>()
                r2 = 4
                r0.mEventType = r2
                java.lang.Object r7 = r7.mSurface
                r0.mObject = r7
                r1.handleRendererEventUrgent(r0)
            L_0x008d:
                return
            L_0x008e:
                r7 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x008e }
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer.LocalVideoRenderViewCallBackImpl.onVideoRenderSurfaceDestroyed(com.wushuangtech.myvideoimprove.bean.VideoRenderViewLifeBean):void");
        }
    }

    private static class LocalEGLSurfaceHolderCallBackImpl implements EGLSurfaceHolder.OnEGLSurfaceHolderCallBack {
        private final WeakReference<RemoteVideoRenderer> mOutReference;

        public LocalEGLSurfaceHolderCallBackImpl(RemoteVideoRenderer remoteVideoRenderer) {
            this.mOutReference = new WeakReference<>(remoteVideoRenderer);
        }

        public boolean onEGLSurfaceHolderDrawFrame(EGLSurfaceWrap eGLSurfaceWrap) {
            RemoteVideoRenderer remoteVideoRenderer = (RemoteVideoRenderer) this.mOutReference.get();
            if (remoteVideoRenderer == null) {
                return true;
            }
            return remoteVideoRenderer.mRemoteOpenGLRenderer.drawDisplayWindow();
        }
    }
}
