package io.agora.rtc.gdp;

public class OffscreenSurface extends EglSurfaceBase {
    public OffscreenSurface(EglCore eglCore, int i, int i2) {
        super(eglCore);
        createOffscreenSurface(i, i2);
    }

    public void release() {
        releaseEglSurface();
    }
}