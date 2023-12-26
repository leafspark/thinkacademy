package com.wushuangtech.library.video.egl;

import android.opengl.EGLContext;
import android.opengl.EGLSurface;

public class BaseEGLImpl14 extends BaseEGLImpl {
    private final EGLHelper14 mEGLHelper14 = new EGLHelper14();

    public boolean initEGL(EGLSurfaceWrap eGLSurfaceWrap) {
        EGLContext eGLContext = eGLSurfaceWrap.mEglContext14;
        if (eGLContext != null) {
            return this.mEGLHelper14.eglInit(eGLContext);
        }
        return this.mEGLHelper14.eglInit();
    }

    public boolean destoryEGL() {
        return this.mEGLHelper14.destory();
    }

    public EGLContextWrap getEglContext() {
        EGLContextWrap eGLContextWrap = new EGLContextWrap();
        eGLContextWrap.mEGLContext14 = this.mEGLHelper14.getEGLContext();
        return eGLContextWrap;
    }

    public EGLSurfaceWrap createWindowEGLSurface(Object obj) {
        EGLSurface createWindowSurface;
        if (obj == null || (createWindowSurface = this.mEGLHelper14.createWindowSurface(obj)) == null) {
            return null;
        }
        EGLSurfaceWrap eGLSurfaceWrap = new EGLSurfaceWrap();
        eGLSurfaceWrap.window = obj;
        eGLSurfaceWrap.eglSurface14 = createWindowSurface;
        return eGLSurfaceWrap;
    }

    public EGLSurfaceWrap createBufferEGLSurface(int i, int i2) {
        EGLSurface eGLSurface;
        if (i == 0 || i2 == 0) {
            eGLSurface = this.mEGLHelper14.createOffscreenSurface(0, 0);
        } else {
            eGLSurface = this.mEGLHelper14.createOffscreenSurface(i, i2);
        }
        if (eGLSurface == null) {
            return null;
        }
        EGLSurfaceWrap eGLSurfaceWrap = new EGLSurfaceWrap();
        eGLSurfaceWrap.eglSurface14 = eGLSurface;
        return eGLSurfaceWrap;
    }

    public boolean destoryEGLSurface(EGLSurfaceWrap eGLSurfaceWrap) {
        if (eGLSurfaceWrap == null || eGLSurfaceWrap.eglSurface14 == null) {
            return false;
        }
        return this.mEGLHelper14.destorySurface(eGLSurfaceWrap.eglSurface14);
    }

    public boolean makeCurrent(EGLSurfaceWrap eGLSurfaceWrap) {
        if (eGLSurfaceWrap == null) {
            return false;
        }
        return this.mEGLHelper14.makeCurrent(eGLSurfaceWrap.eglSurface14);
    }

    public boolean makeCurrent() {
        return this.mEGLHelper14.makeCurrent();
    }

    public boolean swapBuffers(EGLSurfaceWrap eGLSurfaceWrap) {
        if (eGLSurfaceWrap == null) {
            return false;
        }
        return this.mEGLHelper14.swapBuffers(eGLSurfaceWrap.eglSurface14);
    }
}
