package com.linkedin.android.litr.utils;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import java.util.concurrent.Callable;

public final /* synthetic */ class CodecUtils$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ MediaCodecInfo f$0;

    public /* synthetic */ CodecUtils$$ExternalSyntheticLambda0(MediaCodecInfo mediaCodecInfo) {
        this.f$0 = mediaCodecInfo;
    }

    public final Object call() {
        return MediaCodec.createByCodecName(this.f$0.getName());
    }
}
