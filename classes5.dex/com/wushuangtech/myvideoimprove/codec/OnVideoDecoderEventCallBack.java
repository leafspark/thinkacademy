package com.wushuangtech.myvideoimprove.codec;

public interface OnVideoDecoderEventCallBack {
    void onVideoFirstFrameDecoded(int i, int i2);

    void onVideoFirstFrameDrawn(int i, int i2);
}
