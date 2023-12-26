package com.wushuangtech.myvideoimprove.codec;

import com.wushuangtech.myvideoimprove.bean.CodecConfigureBean;

public interface OnCodecLifeListener {
    CodecConfigureBean onCodecConfiguring(CodecConfigureBean codecConfigureBean);

    boolean onCodecReleasing(CodecConfigureBean codecConfigureBean);

    void onCodecStartFinish(CodecConfigureBean codecConfigureBean);

    void onSyncCodecAssignment(CodecConfigureBean codecConfigureBean);

    CodecConfigureBean onSyncCodecPrepareRelease();

    void onSyncCodecReleasing(CodecConfigureBean codecConfigureBean);

    boolean onSyncCodecStart(CodecConfigureBean codecConfigureBean);

    boolean onSyncCodecStartCheck();

    CodecConfigureBean onSyncCodecStartConfigure(int i, int i2);
}
