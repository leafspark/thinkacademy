package com.tal.app.thinkacademy.common.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/MkAiSoundSizeUtil;", "", "()V", "calculateHighVolume", "", "vol", "calculateRealVolume", "buffer", "", "readSize", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AudioRecordHelper.kt */
public final class MkAiSoundSizeUtil {
    public static final MkAiSoundSizeUtil INSTANCE = new MkAiSoundSizeUtil();

    public final double calculateHighVolume(double d) {
        double d2;
        double d3;
        if (d < 40.0d) {
            d = 40.0d;
        }
        double d4 = d / ((double) 100.0f);
        if (d4 > 0.6d) {
            d2 = (d4 - 0.6d) * 2.5d;
            d3 = 0.3d;
        } else {
            d3 = 0.1d;
            d2 = (d4 - 0.4d) * 0.5d;
        }
        double d5 = d2 + d3;
        if (d5 <= 0.0d) {
            d5 = 0.0d;
        }
        if (d5 > 1.0d) {
            return 1.0d;
        }
        return d5;
    }

    private MkAiSoundSizeUtil() {
    }

    public final double calculateRealVolume(short[] sArr, int i) {
        Intrinsics.checkNotNullParameter(sArr, "buffer");
        double d = 0.0d;
        for (int i2 = 0; i2 < i; i2++) {
            d += (double) (sArr[i2] * sArr[i2]);
        }
        if (i <= 0) {
            return 0.0d;
        }
        double log10 = ((double) 10) * Math.log10(d / ((double) i));
        if (log10 < 0.0d) {
            return -1.0d;
        }
        return log10;
    }
}
