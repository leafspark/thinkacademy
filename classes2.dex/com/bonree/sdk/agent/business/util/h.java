package com.bonree.sdk.agent.business.util;

import com.bonree.sdk.d.a;

public final class h {
    private static byte[] a(int i) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) i;
        bArr[2] = (byte) (i >> 8);
        bArr[1] = (byte) (i >> 16);
        bArr[0] = (byte) (i >>> 24);
        return bArr;
    }

    private static int a(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        int length = bArr.length - 1;
        int i = 3;
        while (i >= 0) {
            if (length >= 0) {
                bArr2[i] = bArr[length];
            } else {
                bArr2[i] = 0;
            }
            i--;
            length--;
        }
        return ((bArr2[0] & 255) << 24) + ((bArr2[1] & 255) << 16) + ((bArr2[2] & 255) << 8) + (bArr2[3] & 255);
    }

    private static byte[] a(long j) {
        byte[] bArr = new byte[8];
        int i = 0;
        while (i < 8) {
            int i2 = i + 1;
            bArr[i] = (byte) ((int) ((j >> (64 - (i2 << 3))) & 255));
            i = i2;
        }
        return bArr;
    }

    private static long b(byte[] bArr) {
        if (bArr == null || bArr.length < 8) {
            a.a.a("b == null || b.length < 8", new Object[0]);
            return -1;
        }
        long j = 0;
        for (int i = 0; i < 8; i++) {
            j = (j << 8) | ((long) (bArr[i] & 255));
        }
        return j;
    }
}
