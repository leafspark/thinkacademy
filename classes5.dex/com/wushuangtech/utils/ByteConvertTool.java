package com.wushuangtech.utils;

import kotlin.UByte;

public class ByteConvertTool {
    public static byte[] getBytes(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & -16777216) >> 24)};
    }

    public static byte[] getBytes(float f) {
        return getBytes(Float.floatToIntBits(f));
    }

    public static int getInt(byte[] bArr) {
        return ((bArr[3] << 24) & UByte.MIN_VALUE) | (bArr[0] & UByte.MAX_VALUE) | ((bArr[1] << 8) & UByte.MIN_VALUE) | ((bArr[2] << 16) & UByte.MIN_VALUE);
    }

    public static float getFloat(byte[] bArr) {
        return Float.intBitsToFloat(getInt(bArr));
    }

    public static boolean memcmp(byte[] bArr, byte[] bArr2, int i) {
        if (bArr == null && bArr2 == null) {
            return true;
        }
        if (bArr == null || bArr2 == null) {
            return false;
        }
        if (bArr == bArr2) {
            return true;
        }
        int i2 = 0;
        while (i2 < bArr.length && i2 < bArr2.length && i2 < i) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
        return true;
    }
}
