package io.agora.rtc.mediaio;

public interface IVideoSource {
    int getBufferType();

    int getCaptureType();

    int getContentHint();

    void onDispose();

    boolean onInitialize(IVideoFrameConsumer iVideoFrameConsumer);

    boolean onStart();

    void onStop();
}
