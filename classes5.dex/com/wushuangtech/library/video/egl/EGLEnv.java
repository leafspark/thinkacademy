package com.wushuangtech.library.video.egl;

import android.opengl.EGLContext;
import com.wushuangtech.library.GlobalVideoConfig;
import com.wushuangtech.utils.OmniLog;

public class EGLEnv {
    private static final int EGL_VERSION_11 = 1000;
    private static final int EGL_VERSION_14 = 1001;
    private static final String TAG = "EGLEnv";
    private BaseEGL mBaseEGL;
    private EGLSurfaceWrap mBufferEGLSurface;
    private boolean mEGLInited;

    public boolean isEGLInited() {
        return this.mEGLInited;
    }

    public boolean init() {
        return init((Object) null);
    }

    public boolean init(Object obj) {
        if (this.mEGLInited) {
            return true;
        }
        if (obj == null || (obj instanceof EGLContext)) {
            EGLSurfaceWrap eGLSurfaceWrap = new EGLSurfaceWrap();
            eGLSurfaceWrap.mEglContext14 = (EGLContext) obj;
            return executingEGLInit(1001, eGLSurfaceWrap);
        } else if (!(obj instanceof javax.microedition.khronos.egl.EGLContext)) {
            return false;
        } else {
            EGLSurfaceWrap eGLSurfaceWrap2 = new EGLSurfaceWrap();
            eGLSurfaceWrap2.mEglContext11 = (javax.microedition.khronos.egl.EGLContext) obj;
            return executingEGLInit(1000, eGLSurfaceWrap2);
        }
    }

    public void unInit() {
        if (this.mEGLInited) {
            if (this.mBaseEGL.makeCurrent(this.mBufferEGLSurface)) {
                this.mBaseEGL.destoryEGLSurface(this.mBufferEGLSurface);
                this.mBaseEGL.destoryEGL();
                this.mBaseEGL = null;
                this.mEGLInited = false;
                OmniLog.d(OmniLog.VIDEO_RENDER_WATCH, TAG, "Uninit EGL thread success!");
                return;
            }
            throw new RuntimeException("Binding buffer EGLSurface failed... uninit EGL thread");
        }
    }

    public boolean makeCurrentThread() {
        EGLSurfaceWrap eGLSurfaceWrap;
        BaseEGL baseEGL = this.mBaseEGL;
        if (baseEGL == null || (eGLSurfaceWrap = this.mBufferEGLSurface) == null || baseEGL.makeCurrent(eGLSurfaceWrap)) {
            return true;
        }
        logE("Binding buffer EGLSurface failed!");
        return false;
    }

    private boolean executingEGLInit(int i, EGLSurfaceWrap eGLSurfaceWrap) {
        BaseEGL baseEGL;
        if (i == 1000) {
            baseEGL = new BaseEGLImpl11();
        } else {
            baseEGL = new BaseEGLImpl14();
        }
        if (!baseEGL.initEGL(eGLSurfaceWrap)) {
            logE("Init EGL thread failed!");
            return false;
        }
        this.mBaseEGL = baseEGL;
        this.mBufferEGLSurface = baseEGL.createBufferEGLSurface(GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_HEIGHT, GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_WIDTH);
        this.mEGLInited = true;
        log("Init EGL thread success!");
        return true;
    }

    private void log(String str) {
        OmniLog.d(OmniLog.VIDEO_RENDER_WATCH, TAG, str);
    }

    private void logE(String str) {
        OmniLog.e(OmniLog.VIDEO_RENDER_WATCH, TAG, str);
    }

    public BaseEGL getBaseEGL() {
        return this.mBaseEGL;
    }
}
