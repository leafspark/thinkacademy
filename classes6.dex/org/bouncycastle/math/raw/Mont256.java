package org.bouncycastle.math.raw;

import org.apache.httpcore.message.TokenParser;

public abstract class Mont256 {
    private static final long M = 4294967295L;

    public static int inverse32(int i) {
        int i2 = (2 - (i * i)) * i;
        int i3 = i2 * (2 - (i * i2));
        int i4 = i3 * (2 - (i * i3));
        return i4 * (2 - (i * i4));
    }

    public static void multAdd(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i) {
        int[] iArr5 = iArr3;
        int[] iArr6 = iArr4;
        char c = 0;
        long j = ((long) iArr2[0]) & M;
        int i2 = 0;
        int i3 = 0;
        while (i2 < 8) {
            long j2 = ((long) iArr5[c]) & M;
            long j3 = ((long) iArr[i2]) & M;
            long j4 = j3 * j;
            long j5 = (j4 & M) + j2;
            long j6 = j;
            long j7 = ((long) (((int) j5) * i)) & M;
            int i4 = i2;
            int i5 = i3;
            long j8 = (((long) iArr6[c]) & M) * j7;
            char c2 = TokenParser.SP;
            long j9 = ((j5 + (j8 & M)) >>> 32) + (j4 >>> 32) + (j8 >>> 32);
            int i6 = 1;
            while (i6 < 8) {
                long j10 = (((long) iArr2[i6]) & M) * j3;
                long j11 = (((long) iArr6[i6]) & M) * j7;
                long j12 = j9 + (j10 & M) + (j11 & M) + (((long) iArr5[i6]) & M);
                iArr5[i6 - 1] = (int) j12;
                j9 = (j12 >>> 32) + (j10 >>> 32) + (j11 >>> 32);
                i6++;
                c2 = ' ';
                j7 = j7;
            }
            long j13 = j9 + (((long) i5) & M);
            iArr5[7] = (int) j13;
            i3 = (int) (j13 >>> c2);
            i2 = i4 + 1;
            j = j6;
            c = 0;
        }
        if (i3 != 0 || Nat256.gte(iArr3, iArr4)) {
            Nat256.sub(iArr5, iArr6, iArr5);
        }
    }

    public static void multAddXF(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int[] iArr5 = iArr3;
        int[] iArr6 = iArr4;
        char c = 0;
        long j = ((long) iArr2[0]) & M;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= 8) {
                break;
            }
            long j2 = ((long) iArr[i]) & M;
            long j3 = (j2 * j) + (((long) iArr5[c]) & M);
            long j4 = j3 & M;
            long j5 = (j3 >>> 32) + j4;
            int i3 = 1;
            for (int i4 = 8; i3 < i4; i4 = 8) {
                long j6 = j;
                long j7 = (((long) iArr2[i3]) & M) * j2;
                long j8 = (((long) iArr6[i3]) & M) * j4;
                long j9 = j5 + (j7 & M) + (j8 & M) + (((long) iArr5[i3]) & M);
                iArr5[i3 - 1] = (int) j9;
                j5 = (j9 >>> 32) + (j7 >>> 32) + (j8 >>> 32);
                i3++;
                j = j6;
                j2 = j2;
                j4 = j4;
            }
            long j10 = j5 + (((long) i2) & M);
            iArr5[7] = (int) j10;
            i2 = (int) (j10 >>> 32);
            i++;
            j = j;
            c = 0;
        }
        if (i2 != 0 || Nat256.gte(iArr3, iArr4)) {
            Nat256.sub(iArr5, iArr6, iArr5);
        }
    }

    public static void reduce(int[] iArr, int[] iArr2, int i) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        char c = 0;
        int i2 = 0;
        while (i2 < 8) {
            int i3 = iArr3[c];
            long j = ((long) (i3 * i)) & M;
            long j2 = (((((long) iArr4[c]) & M) * j) + (((long) i3) & M)) >>> 32;
            int i4 = 1;
            while (i4 < 8) {
                long j3 = j2 + ((((long) iArr4[i4]) & M) * j) + (((long) iArr3[i4]) & M);
                iArr3[i4 - 1] = (int) j3;
                j2 = j3 >>> 32;
                i4++;
                i2 = i2;
            }
            iArr3[7] = (int) j2;
            i2++;
            c = 0;
        }
        if (Nat256.gte(iArr, iArr2)) {
            Nat256.sub(iArr3, iArr4, iArr3);
        }
    }

    public static void reduceXF(int[] iArr, int[] iArr2) {
        for (int i = 0; i < 8; i++) {
            long j = ((long) iArr[0]) & M;
            long j2 = j;
            for (int i2 = 1; i2 < 8; i2++) {
                long j3 = j2 + ((((long) iArr2[i2]) & M) * j) + (((long) iArr[i2]) & M);
                iArr[i2 - 1] = (int) j3;
                j2 = j3 >>> 32;
            }
            iArr[7] = (int) j2;
        }
        if (Nat256.gte(iArr, iArr2)) {
            Nat256.sub(iArr, iArr2, iArr);
        }
    }
}
