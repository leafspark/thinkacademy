package com.tal.app.thinkacademy.live.util;

import kotlin.jvm.internal.ByteCompanionObject;

public class VideoFrameToRgbaUtils {
    public static int[] yuvI420toARGB(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (((i4 / i) / 2) * (i / 2)) + ((i4 % i) / 2);
            double d = (double) (bArr[i4] & 255);
            double d2 = (double) ((bArr[i3 + i5] & 255) + ByteCompanionObject.MIN_VALUE);
            int i6 = (int) ((1.8556d * d2) + d);
            double d3 = (double) ((bArr[(i3 / 4) + i3 + i5] & 255) + ByteCompanionObject.MIN_VALUE);
            int i7 = (int) (d - ((0.4681d * d3) + (d2 * 0.1872d)));
            int i8 = (int) (d + (d3 * 1.5748d));
            if (i6 > 255) {
                i6 = 255;
            } else if (i6 < 0) {
                i6 = 0;
            }
            if (i7 > 255) {
                i7 = 255;
            } else if (i7 < 0) {
                i7 = 0;
            }
            if (i8 > 255) {
                i8 = 255;
            } else if (i8 < 0) {
                i8 = 0;
            }
            iArr[i4] = ((i7 << 8) & 65280) | ((i8 << 16) & 16711680) | -16777216 | (i6 & 255);
        }
        return iArr;
    }
}
