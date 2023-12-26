package io.agora.rtc.mediaio;

public interface IVideoSink extends IVideoFrameConsumer {
    int getBufferType();

    long getEGLContextHandle();

    int getPixelFormat();

    void onDispose();

    boolean onInitialize();

    boolean onStart();

    void onStop();
}
