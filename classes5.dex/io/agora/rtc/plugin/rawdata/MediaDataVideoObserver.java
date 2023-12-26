package io.agora.rtc.plugin.rawdata;

public interface MediaDataVideoObserver {
    void onCaptureVideoFrame(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j);

    void onRenderVideoFrame(int i, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j);
}
