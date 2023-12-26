package io.agora.rtc.mediaio;

import java.nio.ByteBuffer;

public class AgoraDefaultRender implements IVideoSink {
    public void consumeByteArrayFrame(byte[] bArr, int i, int i2, int i3, int i4, long j) {
    }

    public void consumeByteBufferFrame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, long j) {
    }

    public void consumeTextureFrame(int i, int i2, int i3, int i4, int i5, long j, float[] fArr) {
    }

    public int getBufferType() {
        return 0;
    }

    public long getEGLContextHandle() {
        return 0;
    }

    public int getPixelFormat() {
        return 0;
    }

    public void onDispose() {
    }

    public boolean onInitialize() {
        return true;
    }

    public boolean onStart() {
        return true;
    }

    public void onStop() {
    }
}
