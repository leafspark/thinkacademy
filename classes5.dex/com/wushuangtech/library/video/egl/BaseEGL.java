package com.wushuangtech.library.video.egl;

public interface BaseEGL {
    EGLSurfaceWrap createBufferEGLSurface(int i, int i2);

    EGLSurfaceWrap createWindowEGLSurface(Object obj);

    boolean destoryEGL();

    boolean destoryEGLSurface(EGLSurfaceWrap eGLSurfaceWrap);

    EGLContextWrap getEglContext();

    boolean initEGL(EGLSurfaceWrap eGLSurfaceWrap);

    boolean makeCurrent();

    boolean makeCurrent(EGLSurfaceWrap eGLSurfaceWrap);

    boolean swapBuffers(EGLSurfaceWrap eGLSurfaceWrap);
}
