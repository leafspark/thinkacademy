package com.wushuangtech.myvideoimprove.codec;

import com.wushuangtech.myvideoimprove.bean.CodecConfigureBean;

public interface BaseCodec {
    boolean open(CodecConfigureBean codecConfigureBean);

    boolean pause();

    boolean release();

    int restart(CodecConfigureBean codecConfigureBean);

    boolean resume();
}
