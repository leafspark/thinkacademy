package com.wushuangtech.myvideoimprove.screen;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.library.video.bean.MediaCodecSurface;
import com.wushuangtech.library.video.egl.EGLEnv;
import com.wushuangtech.library.video.egl.EGLSurfaceHolder;
import com.wushuangtech.library.video.egl.EGLSurfaceType;
import com.wushuangtech.library.video.egl.EGLSurfaceWrap;
import com.wushuangtech.library.video.opengles.output.HandleDataOutput;
import com.wushuangtech.library.video.opengles.output.ScreenEndpoint;
import com.wushuangtech.myvideoimprove.bean.ScreenCaptureConfig;
import com.wushuangtech.utils.MyGLUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ScreenOpenGLRender {
    private static final int EVENT_ADD_ENCODE_SURFACE = 2;
    private static final int EVENT_INIT = 1;
    private static final int EVENT_REMOVE_ENCODE_SURFACE = 3;
    private static final int EVENT_RENDER = 4;
    private static final int EVENT_SET_PARAMS = 5;
    private EGLEnv mEGLEnv;
    private EGLSurfaceHolder mEGLSurfaceHolder;
    private Thread mEGLThread;
    private HandleDataOutput mHandleDataOutput;
    private MediaCodecSurface mMediaCodecSurface;
    private EGLSurfaceHolder.OnEGLSurfaceHolderCallBack mOnEGLSurfaceHolderCallBack;
    private LocalRunnable mRunnable;
    private ScreenEndpoint mScreenEndpoint;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private boolean mTextureCreated;
    private int mTextureId;

    private boolean drawOpenGL(EGLSurfaceWrap eGLSurfaceWrap, boolean z) {
        return false;
    }

    public void unInit() {
    }

    ScreenOpenGLRender() {
    }

    public void init() {
        this.mEGLEnv = new EGLEnv();
        this.mRunnable = new LocalRunnable();
        Thread thread = new Thread(this.mRunnable);
        this.mEGLThread = thread;
        if (!(thread instanceof Thread)) {
            thread.start();
        } else {
            AsynchronousInstrumentation.threadStart(thread);
        }
        CommonEventBean commonEventBean = new CommonEventBean();
        commonEventBean.mEventType = 1;
        this.mRunnable.addEvent(commonEventBean);
    }

    public void setParams(ScreenCaptureConfig screenCaptureConfig) {
        CommonEventBean commonEventBean = new CommonEventBean();
        commonEventBean.mEventType = 5;
        commonEventBean.mObject = screenCaptureConfig;
        this.mRunnable.addEvent(commonEventBean);
    }

    public void addEncodeSurfaceWindow(Object obj) {
        CommonEventBean commonEventBean = new CommonEventBean();
        commonEventBean.mEventType = 2;
        this.mRunnable.addEvent(commonEventBean);
    }

    public void removeEncodeSurfaceWindow(Object obj) {
        CommonEventBean commonEventBean = new CommonEventBean();
        commonEventBean.mEventType = 3;
        this.mRunnable.addEvent(commonEventBean);
    }

    public void startRending() {
        CommonEventBean commonEventBean = new CommonEventBean();
        commonEventBean.mEventType = 4;
        this.mRunnable.addEvent(commonEventBean);
    }

    private void createSurfaceTexture(int i, int i2) {
        this.mTextureId = MyGLUtils.createWhiteOESTextureId();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureId);
        this.mSurfaceTexture = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(i, i2);
        this.mSurface = new Surface(this.mSurfaceTexture);
    }

    /* access modifiers changed from: private */
    public void handleEGLRenderEvent(CommonEventBean commonEventBean) {
        int i = commonEventBean.mEventType;
        if (i == 1) {
            this.mEGLEnv.init();
            this.mEGLEnv.makeCurrentThread();
            this.mOnEGLSurfaceHolderCallBack = new EGLSurfaceHolderCallBackImpl(this);
            this.mEGLSurfaceHolder = new EGLSurfaceHolder(this.mEGLEnv.getBaseEGL(), this.mOnEGLSurfaceHolderCallBack);
            initOpenGL();
        } else if (i == 2) {
            MediaCodecSurface mediaCodecSurface = (MediaCodecSurface) commonEventBean.mObject;
            MediaCodecSurface mediaCodecSurface2 = this.mMediaCodecSurface;
            if ((mediaCodecSurface2 == null || mediaCodecSurface2 != mediaCodecSurface) && this.mEGLSurfaceHolder.addEGLSurface(EGLSurfaceType.ENCODE, mediaCodecSurface)) {
                this.mMediaCodecSurface = mediaCodecSurface;
            }
        } else if (i == 3) {
            MediaCodecSurface mediaCodecSurface3 = (MediaCodecSurface) commonEventBean.mObject;
            MediaCodecSurface mediaCodecSurface4 = this.mMediaCodecSurface;
            if (mediaCodecSurface4 != null && mediaCodecSurface4 == mediaCodecSurface3) {
                this.mEGLSurfaceHolder.releaseEGLSurface(mediaCodecSurface3);
                this.mMediaCodecSurface = null;
            }
        } else if (i == 4) {
            CommonEventBean commonEventBean2 = new CommonEventBean();
            commonEventBean2.mEventType = 4;
            this.mRunnable.addEvent(commonEventBean2);
        } else if (i == 5) {
            ScreenCaptureConfig screenCaptureConfig = (ScreenCaptureConfig) commonEventBean.mObject;
            int i2 = screenCaptureConfig.mWidth;
            int i3 = screenCaptureConfig.mHeight;
            if (!this.mTextureCreated) {
                createSurfaceTexture(i2, i3);
                this.mTextureCreated = true;
            }
            this.mHandleDataOutput.setTextureId(this.mTextureId);
            this.mHandleDataOutput.setRenderSize(i2, i3);
            this.mScreenEndpoint.setViewSize(i2, i3);
            this.mScreenEndpoint.setEncodeSize(i2, i3);
        }
    }

    private void initOpenGL() {
        this.mHandleDataOutput = new HandleDataOutput();
        this.mScreenEndpoint = new ScreenEndpoint();
    }

    private class LocalRunnable implements Runnable {
        private volatile boolean mDestroyed;
        private BlockingQueue<CommonEventBean> mQueue = new LinkedBlockingQueue();

        public LocalRunnable() {
        }

        public void addEvent(CommonEventBean commonEventBean) {
            try {
                this.mQueue.put(commonEventBean);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void destroy() {
            this.mDestroyed = true;
            BlockingQueue<CommonEventBean> blockingQueue = this.mQueue;
            if (blockingQueue != null) {
                blockingQueue.clear();
                this.mQueue = null;
            }
        }

        public void run() {
            BlockingQueue<CommonEventBean> blockingQueue;
            while (!this.mDestroyed && (blockingQueue = this.mQueue) != null) {
                CommonEventBean commonEventBean = null;
                try {
                    commonEventBean = blockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (commonEventBean != null) {
                    ScreenOpenGLRender.this.handleEGLRenderEvent(commonEventBean);
                }
            }
        }
    }

    private static class EGLSurfaceHolderCallBackImpl implements EGLSurfaceHolder.OnEGLSurfaceHolderCallBack {
        private final WeakReference<ScreenOpenGLRender> outReference;

        EGLSurfaceHolderCallBackImpl(ScreenOpenGLRender screenOpenGLRender) {
            this.outReference = new WeakReference<>(screenOpenGLRender);
        }

        public boolean onEGLSurfaceHolderDrawFrame(EGLSurfaceWrap eGLSurfaceWrap) {
            ScreenOpenGLRender screenOpenGLRender = (ScreenOpenGLRender) this.outReference.get();
            if (screenOpenGLRender == null) {
                return true;
            }
            return screenOpenGLRender.drawEGLSurface(eGLSurfaceWrap);
        }
    }

    /* access modifiers changed from: private */
    public boolean drawEGLSurface(EGLSurfaceWrap eGLSurfaceWrap) {
        if (eGLSurfaceWrap.mWindowId == null) {
            return false;
        }
        MediaCodecSurface mediaCodecSurface = this.mMediaCodecSurface;
        if (mediaCodecSurface == null || !mediaCodecSurface.getId().equals(eGLSurfaceWrap.mWindowId)) {
            return true;
        }
        int frameBufferTextureId = this.mHandleDataOutput.getFrameBufferTextureId();
        if (frameBufferTextureId == 0) {
            return false;
        }
        ScreenEndpoint screenEndpoint = this.mScreenEndpoint;
        if (screenEndpoint == null) {
            return true;
        }
        screenEndpoint.newTextureReady(frameBufferTextureId, this.mHandleDataOutput, false);
        return true;
    }
}
