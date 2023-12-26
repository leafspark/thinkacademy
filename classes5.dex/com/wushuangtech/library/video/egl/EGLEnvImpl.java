package com.wushuangtech.library.video.egl;

import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.library.GlobalVideoConfig;
import com.wushuangtech.library.HandlerSyncExtend;
import com.wushuangtech.library.HandlerUrgentQueue;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class EGLEnvImpl {
    public static final int EGL_INIT = 1000;
    private static final int EGL_RENDERER_EVENT = 1050;
    public static final int EGL_RENDERER_WORKING = 1003;
    public static final int EGL_UNINIT = 1001;
    private static final int EGL_VERSION_11 = 1010;
    private static final int EGL_VERSION_14 = 1011;
    private String TAG = "EGLEnvImpl";
    private BaseEGL mBaseEGL;
    private EGLSurfaceWrap mBufferEGLSurface;
    private final HashMap<String, OnEGLEventCallBack> mCallBacks = new HashMap<>();
    private final OnEGLEventCallBack mEGLEnvImplCallBack;
    private boolean mEGLInited;
    /* access modifiers changed from: private */
    public HandlerSyncExtend mHandlerSyncExtend;
    private HandlerUrgentQueue mHandlerUrgentQueue;
    private boolean mIgnoreInitCheck;
    private HandlerThread mLocalHandlerThread;
    private LocalHandlerThreadHandler mLocalHandlerThreadHandler;
    private int mLogFlag;

    public EGLEnvImpl(String str, OnEGLEventCallBack onEGLEventCallBack) {
        this.mEGLEnvImplCallBack = onEGLEventCallBack;
        createThread(str);
    }

    public void setTAG(String str) {
        this.TAG = str + "::" + this.TAG;
    }

    public void setIgnoreInitCheck(boolean z) {
        this.mIgnoreInitCheck = z;
    }

    public void setLogFlag(int i) {
        this.mLogFlag = i;
    }

    public BaseEGL getBaseEGL() {
        return this.mBaseEGL;
    }

    public void initEGL14(EGLContext eGLContext) {
        LocalHandlerThreadHandler localHandlerThreadHandler = this.mLocalHandlerThreadHandler;
        if (localHandlerThreadHandler != null) {
            CommonEventBean commonEventBean = new CommonEventBean();
            commonEventBean.mEventType = 1000;
            commonEventBean.mObject = eGLContext;
            Message.obtain(localHandlerThreadHandler, commonEventBean.mEventType, commonEventBean).sendToTarget();
        }
    }

    public void initEGL11Sync(javax.microedition.khronos.egl.EGLContext eGLContext) {
        CommonEventBean commonEventBean = new CommonEventBean();
        commonEventBean.mEventType = 1000;
        commonEventBean.mObject = eGLContext;
        HandlerSyncExtend handlerSyncExtend = this.mHandlerSyncExtend;
        if (handlerSyncExtend != null) {
            handlerSyncExtend.handleSyncMessage(this.mLocalHandlerThreadHandler, commonEventBean);
        }
    }

    public void initEGL14Sync(EGLContext eGLContext) {
        CommonEventBean commonEventBean = new CommonEventBean();
        commonEventBean.mEventType = 1000;
        commonEventBean.mObject = eGLContext;
        HandlerSyncExtend handlerSyncExtend = this.mHandlerSyncExtend;
        if (handlerSyncExtend != null) {
            handlerSyncExtend.handleSyncMessage(this.mLocalHandlerThreadHandler, commonEventBean);
        }
    }

    public void unInitEGL() {
        LocalHandlerThreadHandler localHandlerThreadHandler = this.mLocalHandlerThreadHandler;
        if (localHandlerThreadHandler != null) {
            CommonEventBean commonEventBean = new CommonEventBean();
            commonEventBean.mEventType = 1001;
            Message.obtain(localHandlerThreadHandler, commonEventBean.mEventType, commonEventBean).sendToTarget();
        }
    }

    public void unInitEGLSync() {
        unInitEGLSync((Object) null);
    }

    public void unInitEGLSync(Object obj) {
        LocalHandlerThreadHandler localHandlerThreadHandler = this.mLocalHandlerThreadHandler;
        if (localHandlerThreadHandler != null && this.mHandlerSyncExtend != null) {
            localHandlerThreadHandler.removeMessages(1003);
            this.mHandlerSyncExtend.handleSyncMessage((Handler) this.mLocalHandlerThreadHandler, 1001, obj);
        }
    }

    public void destroyEGLThread() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mCallBacks.clear();
        HandlerUrgentQueue handlerUrgentQueue = this.mHandlerUrgentQueue;
        if (handlerUrgentQueue != null) {
            handlerUrgentQueue.destroyQueue();
            this.mHandlerUrgentQueue = null;
        }
        HandlerThread handlerThread = this.mLocalHandlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.mLocalHandlerThread = null;
        }
        HandlerSyncExtend handlerSyncExtend = this.mHandlerSyncExtend;
        if (handlerSyncExtend != null) {
            handlerSyncExtend.clearResource();
            this.mHandlerSyncExtend = null;
        }
        logI("Destroy video decoder thread... " + (System.currentTimeMillis() - currentTimeMillis) + " | thread size : " + Thread.activeCount());
    }

    public void addCallBack(String str, OnEGLEventCallBack onEGLEventCallBack) {
        this.mCallBacks.put(str, onEGLEventCallBack);
    }

    public void removeCallBack(String str) {
        this.mCallBacks.remove(str);
    }

    /* access modifiers changed from: package-private */
    public boolean checkEventExist(int i) {
        LocalHandlerThreadHandler localHandlerThreadHandler = this.mLocalHandlerThreadHandler;
        if (localHandlerThreadHandler == null) {
            return true;
        }
        return localHandlerThreadHandler.hasMessages(i);
    }

    public void handleRendererEvent(CommonEventBean commonEventBean) {
        LocalHandlerThreadHandler localHandlerThreadHandler = this.mLocalHandlerThreadHandler;
        if (localHandlerThreadHandler != null && !localHandlerThreadHandler.hasMessages(EGL_RENDERER_EVENT)) {
            Message.obtain(localHandlerThreadHandler, EGL_RENDERER_EVENT, commonEventBean).sendToTarget();
        }
    }

    public void handleRendererEventUrgent(CommonEventBean commonEventBean) {
        LocalHandlerThreadHandler localHandlerThreadHandler = this.mLocalHandlerThreadHandler;
        if (commonEventBean != null && localHandlerThreadHandler != null && this.mHandlerUrgentQueue != null) {
            if (!this.mHandlerUrgentQueue.executeUrgentMsg(localHandlerThreadHandler, Message.obtain(localHandlerThreadHandler, EGL_RENDERER_EVENT, commonEventBean))) {
                logE("Executing urgent message failed! " + commonEventBean.toString());
            }
        }
    }

    public void handleSyncMessage(CommonEventBean commonEventBean) {
        HandlerSyncExtend handlerSyncExtend;
        LocalHandlerThreadHandler localHandlerThreadHandler;
        if (commonEventBean != null && (handlerSyncExtend = this.mHandlerSyncExtend) != null && (localHandlerThreadHandler = this.mLocalHandlerThreadHandler) != null) {
            handlerSyncExtend.handleSyncMessage((Handler) localHandlerThreadHandler, (int) EGL_RENDERER_EVENT, commonEventBean);
        }
    }

    private void createThread(String str) {
        HandlerThread handlerThread = new HandlerThread("GLThread-" + str);
        this.mLocalHandlerThread = handlerThread;
        handlerThread.start();
        this.mLocalHandlerThreadHandler = new LocalHandlerThreadHandler(this.mLocalHandlerThread.getLooper(), this);
        this.mHandlerUrgentQueue = new HandlerUrgentQueue(str);
        this.mHandlerSyncExtend = new HandlerSyncExtend("EGLEnvImpl");
    }

    /* access modifiers changed from: private */
    public void receiveMessage(Message message) {
        HandlerUrgentQueue handlerUrgentQueue;
        LocalHandlerThreadHandler localHandlerThreadHandler;
        if (!(message.arg1 != 1 || (handlerUrgentQueue = this.mHandlerUrgentQueue) == null || (localHandlerThreadHandler = this.mLocalHandlerThreadHandler) == null)) {
            handlerUrgentQueue.onUrgentMessageExecuteFinish(localHandlerThreadHandler, message.what);
        }
        if (this.mIgnoreInitCheck || message.what == 1000 || this.mEGLInited) {
            int i = message.what;
            if (i == 1000) {
                executeInitEGL(message);
            } else if (i == 1001) {
                executeUninitEGL(message);
            } else if (i == EGL_RENDERER_EVENT) {
                executeRenderEvent(message);
            }
        }
    }

    private void executeInitEGL(Message message) {
        boolean z;
        if (!this.mEGLInited) {
            CommonEventBean commonEventBean = (CommonEventBean) message.obj;
            Object obj = commonEventBean.mObject;
            if (obj == null || (obj instanceof EGLContext)) {
                EGLSurfaceWrap eGLSurfaceWrap = new EGLSurfaceWrap();
                eGLSurfaceWrap.mEglContext14 = (EGLContext) obj;
                z = executingEGLInit(1011, eGLSurfaceWrap);
            } else if (obj instanceof javax.microedition.khronos.egl.EGLContext) {
                EGLSurfaceWrap eGLSurfaceWrap2 = new EGLSurfaceWrap();
                eGLSurfaceWrap2.mEglContext11 = (javax.microedition.khronos.egl.EGLContext) obj;
                z = executingEGLInit(1010, eGLSurfaceWrap2);
            } else {
                return;
            }
            this.mEGLInited = z;
            commonEventBean.mObjects = new Object[]{Boolean.valueOf(z)};
            sendCallBack(commonEventBean);
        }
    }

    private void executeUninitEGL(Message message) {
        if (this.mEGLInited) {
            this.mEGLInited = false;
            CommonEventBean commonEventBean = (CommonEventBean) message.obj;
            if (!this.mBaseEGL.makeCurrent(this.mBufferEGLSurface)) {
                logE("Executing unInit EGL failed! Binding buffer EGLSurface failed!");
            }
            sendCallBack(commonEventBean);
            this.mBaseEGL.destoryEGLSurface(this.mBufferEGLSurface);
            this.mBaseEGL.destoryEGL();
            logI("UnInit EGL thread success!");
        }
    }

    private void executeRenderEvent(Message message) {
        CommonEventBean commonEventBean = (CommonEventBean) message.obj;
        if (!this.mEGLInited || this.mBaseEGL.makeCurrent(this.mBufferEGLSurface)) {
            sendCallBack(commonEventBean);
            return;
        }
        logE("Execute event failed! Binding buffer EGLSurface failed!");
        sendCallBack(commonEventBean, 1000);
    }

    private boolean executingEGLInit(int i, EGLSurfaceWrap eGLSurfaceWrap) {
        BaseEGL baseEGL;
        if (this.mBaseEGL == null) {
            if (i == 1010) {
                baseEGL = new BaseEGLImpl11();
            } else {
                baseEGL = new BaseEGLImpl14();
            }
            if (!baseEGL.initEGL(eGLSurfaceWrap)) {
                OmniLog.e(OmniLog.VIDEO_RENDER_WATCH, this.TAG, "Init EGL thread failed!");
                return false;
            }
            this.mBaseEGL = baseEGL;
        }
        if (this.mBufferEGLSurface == null) {
            this.mBufferEGLSurface = this.mBaseEGL.createBufferEGLSurface(GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_HEIGHT, GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_WIDTH);
        }
        if (!makeCurrentForInit()) {
            logE("Init EGL Thread failed! Binding buffer EGLSurface failed!");
            return false;
        }
        logI("Init EGL thread success!");
        return true;
    }

    private boolean makeCurrentForInit() {
        if (!this.mBaseEGL.makeCurrent(this.mBufferEGLSurface)) {
            return this.mBaseEGL.makeCurrent();
        }
        return true;
    }

    private void sendCallBack(CommonEventBean commonEventBean) {
        sendCallBack(commonEventBean, 0);
    }

    private void sendCallBack(CommonEventBean commonEventBean, int i) {
        OnEGLEventCallBack onEGLEventCallBack;
        OnEGLEventCallBack onEGLEventCallBack2 = this.mEGLEnvImplCallBack;
        if (onEGLEventCallBack2 != null) {
            if (i == 0) {
                onEGLEventCallBack2.onEGLRendererEvent(commonEventBean);
            } else {
                onEGLEventCallBack2.onEGLRendererError(i);
            }
        } else if (commonEventBean.mObject != null && (onEGLEventCallBack = this.mCallBacks.get((String) commonEventBean.mObject)) != null) {
            if (i == 0) {
                onEGLEventCallBack.onEGLRendererEvent(commonEventBean);
            } else {
                onEGLEventCallBack.onEGLRendererError(i);
            }
        }
    }

    public void removeMessage(int i) {
        LocalHandlerThreadHandler localHandlerThreadHandler = this.mLocalHandlerThreadHandler;
        if (localHandlerThreadHandler != null) {
            localHandlerThreadHandler.removeMessages(i);
        }
    }

    private void logI(String str) {
        int i = this.mLogFlag;
        if (i == 1) {
            OmniLog.i(OmniLog.VIDEO_RENDER_WATCH, this.TAG, str);
        } else if (i != 2) {
            OmniLog.i(this.TAG, str);
        } else {
            OmniLog.i("RVW", this.TAG, str);
        }
    }

    private void logE(String str) {
        int i = this.mLogFlag;
        if (i == 1) {
            OmniLog.e(OmniLog.VIDEO_RENDER_WATCH, this.TAG, str);
        } else if (i != 2) {
            OmniLog.e(this.TAG, str);
        } else {
            OmniLog.e("RVW", this.TAG, str);
        }
    }

    private static class LocalHandlerThreadHandler extends Handler {
        private final WeakReference<EGLEnvImpl> mOutReference;

        LocalHandlerThreadHandler(Looper looper, EGLEnvImpl eGLEnvImpl) {
            super(looper);
            this.mOutReference = new WeakReference<>(eGLEnvImpl);
        }

        /* access modifiers changed from: package-private */
        public void removeRef() {
            this.mOutReference.clear();
        }

        public void handleMessage(Message message) {
            int i;
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            EGLEnvImpl eGLEnvImpl = (EGLEnvImpl) this.mOutReference.get();
            if (eGLEnvImpl == null) {
                AsynchronousInstrumentation.handlerMessageEnd();
                return;
            }
            Object obj = message.obj;
            CommonEventBean commonEventBean = null;
            if (obj != null) {
                commonEventBean = (CommonEventBean) obj;
                i = commonEventBean.mEventType;
            } else {
                i = -1;
            }
            HandlerSyncExtend access$000 = eGLEnvImpl.mHandlerSyncExtend;
            try {
                eGLEnvImpl.receiveMessage(message);
            } finally {
                if (!(i == -1 || i == 1003 || access$000 == null)) {
                    access$000.notifyEvent(commonEventBean);
                }
                AsynchronousInstrumentation.handlerMessageEnd();
            }
        }
    }
}
