package com.eaydu.omni.utils;

public class DataUtils {
    public static long longFrom8Bytes(byte[] bArr, int i, boolean z) {
        long j = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = (z ? i2 : 7 - i2) << 3;
            j |= (255 << i3) & (((long) bArr[i + i2]) << i3);
        }
        return j;
    }

    public static byte[] LongToBytes(long j) {
        byte[] bArr = new byte[8];
        int i = 0;
        while (i < 8) {
            int i2 = i + 1;
            bArr[i] = (byte) ((int) ((j >> (64 - (i2 * 8))) & 255));
            i = i2;
        }
        return bArr;
    }
}
