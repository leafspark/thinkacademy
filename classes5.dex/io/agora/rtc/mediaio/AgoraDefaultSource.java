package io.agora.rtc.mediaio;

public class AgoraDefaultSource implements IVideoSource {
    public int getBufferType() {
        return 0;
    }

    public int getCaptureType() {
        return 0;
    }

    public int getContentHint() {
        return 0;
    }

    public void onDispose() {
    }

    public boolean onInitialize(IVideoFrameConsumer iVideoFrameConsumer) {
        return true;
    }

    public boolean onStart() {
        return true;
    }

    public void onStop() {
    }
}
