package com.wushuangtech.myvideoimprove.codec.encoder;

public interface BaseEncoder {
    void destroyEncoder();

    boolean initEncoder(String str);

    boolean isHardwareEncoder();

    void receiveVideoData(byte[] bArr, int i, int i2, int i3, long j, int i4);

    void requestIFrame();

    void setDualEncoder(boolean z);

    void setDynamicBitrate(int i);

    void setEncoderParams(int i, int i2, int i3);
}
