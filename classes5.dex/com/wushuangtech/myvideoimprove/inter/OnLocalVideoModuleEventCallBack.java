package com.wushuangtech.myvideoimprove.inter;

public interface OnLocalVideoModuleEventCallBack {
    void onVideoCameraError(int i);

    void onVideoCameraSuccess(int i, int i2, int i3);

    void onVideoEncodeError(int i);

    void onVideoEncodedDataReport(boolean z, byte[] bArr, int i, int i2, int i3, long j);

    void onVideoFirstLocalVideoFrame(int i, int i2);

    void onVideoNV21FrameReport(byte[] bArr, int i, int i2, int i3, long j);

    void onVideoRenderError(int i);

    int onVideoTextureFrameReport(int i, byte[] bArr, int i2, int i3, int i4, long j);
}
