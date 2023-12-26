package com.wushuangtech.library.video.egl;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLSurface;

public class BaseEGLImpl11 extends BaseEGLImpl {
    private EGLHelper mEGLHelper = new EGLHelper();

    BaseEGLImpl11() {
    }

    public boolean initEGL(EGLSurfaceWrap eGLSurfaceWrap) {
        return this.mEGLHelper.eglInit(EGL10.EGL_NO_CONTEXT);
    }

    public boolean destoryEGL() {
        return this.mEGLHelper.destory();
    }

    public EGLContextWrap getEglContext() {
        EGLContextWrap eGLContextWrap = new EGLContextWrap();
        eGLContextWrap.mEGLContext11 = this.mEGLHelper.getEglContext();
        return eGLContextWrap;
    }

    public EGLSurfaceWrap createWindowEGLSurface(Object obj) {
        EGLSurface createWindowSurface;
        if (obj == null || (createWindowSurface = this.mEGLHelper.createWindowSurface(obj)) == null) {
            return null;
        }
        EGLSurfaceWrap eGLSurfaceWrap = new EGLSurfaceWrap();
        eGLSurfaceWrap.window = obj;
        eGLSurfaceWrap.eglSurface11 = createWindowSurface;
        return eGLSurfaceWrap;
    }

    public EGLSurfaceWrap createBufferEGLSurface(int i, int i2) {
        EGLSurface eGLSurface;
        if (i == 0 || i2 == 0) {
            eGLSurface = this.mEGLHelper.createOffScreenSurface(0, 0);
        } else {
            eGLSurface = this.mEGLHelper.createOffScreenSurface(i, i2);
        }
        if (eGLSurface == null) {
            return null;
        }
        EGLSurfaceWrap eGLSurfaceWrap = new EGLSurfaceWrap();
        eGLSurfaceWrap.eglSurface11 = eGLSurface;
        return eGLSurfaceWrap;
    }

    public boolean destoryEGLSurface(EGLSurfaceWrap eGLSurfaceWrap) {
        return this.mEGLHelper.destorySurface(eGLSurfaceWrap.eglSurface11);
    }

    public boolean makeCurrent() {
        return this.mEGLHelper.makeCurrent();
    }

    public boolean makeCurrent(EGLSurfaceWrap eGLSurfaceWrap) {
        return this.mEGLHelper.makeCurrent(eGLSurfaceWrap.eglSurface11);
    }

    public boolean swapBuffers(EGLSurfaceWrap eGLSurfaceWrap) {
        return this.mEGLHelper.swapBuffers(eGLSurfaceWrap.eglSurface11);
    }
}
