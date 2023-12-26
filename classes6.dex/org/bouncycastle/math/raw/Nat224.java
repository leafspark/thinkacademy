package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

public abstract class Nat224 {
    private static final long M = 4294967295L;

    public static int add(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = (((long) iArr[i + 0]) & M) + (((long) iArr2[i2 + 0]) & M) + 0;
        iArr3[i3 + 0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[i + 1]) & M) + (((long) iArr2[i2 + 1]) & M);
        iArr3[i3 + 1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[i + 2]) & M) + (((long) iArr2[i2 + 2]) & M);
        iArr3[i3 + 2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[i + 3]) & M) + (((long) iArr2[i2 + 3]) & M);
        iArr3[i3 + 3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[i + 4]) & M) + (((long) iArr2[i2 + 4]) & M);
        iArr3[i3 + 4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[i + 5]) & M) + (((long) iArr2[i2 + 5]) & M);
        iArr3[i3 + 5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[i + 6]) & M) + (((long) iArr2[i2 + 6]) & M);
        iArr3[i3 + 6] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int add(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & M) + (((long) iArr2[0]) & M) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & M) + (((long) iArr2[1]) & M);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & M) + (((long) iArr2[2]) & M);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & M) + (((long) iArr2[3]) & M);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & M) + (((long) iArr2[4]) & M);
        iArr3[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & M) + (((long) iArr2[5]) & M);
        iArr3[5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & M) + (((long) iArr2[6]) & M);
        iArr3[6] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int addBothTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        int i4 = i3 + 0;
        long j = (((long) iArr[i + 0]) & M) + (((long) iArr2[i2 + 0]) & M) + (((long) iArr3[i4]) & M) + 0;
        iArr3[i4] = (int) j;
        int i5 = i3 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i + 1]) & M) + (((long) iArr2[i2 + 1]) & M) + (((long) iArr3[i5]) & M);
        iArr3[i5] = (int) j2;
        int i6 = i3 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i + 2]) & M) + (((long) iArr2[i2 + 2]) & M) + (((long) iArr3[i6]) & M);
        iArr3[i6] = (int) j3;
        int i7 = i3 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i + 3]) & M) + (((long) iArr2[i2 + 3]) & M) + (((long) iArr3[i7]) & M);
        iArr3[i7] = (int) j4;
        int i8 = i3 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i + 4]) & M) + (((long) iArr2[i2 + 4]) & M) + (((long) iArr3[i8]) & M);
        iArr3[i8] = (int) j5;
        int i9 = i3 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i + 5]) & M) + (((long) iArr2[i2 + 5]) & M) + (((long) iArr3[i9]) & M);
        iArr3[i9] = (int) j6;
        int i10 = i3 + 6;
        long j7 = (j6 >>> 32) + (((long) iArr[i + 6]) & M) + (((long) iArr2[i2 + 6]) & M) + (((long) iArr3[i10]) & M);
        iArr3[i10] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int addBothTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & M) + (((long) iArr2[0]) & M) + (((long) iArr3[0]) & M) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & M) + (((long) iArr2[1]) & M) + (((long) iArr3[1]) & M);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & M) + (((long) iArr2[2]) & M) + (((long) iArr3[2]) & M);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & M) + (((long) iArr2[3]) & M) + (((long) iArr3[3]) & M);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & M) + (((long) iArr2[4]) & M) + (((long) iArr3[4]) & M);
        iArr3[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & M) + (((long) iArr2[5]) & M) + (((long) iArr3[5]) & M);
        iArr3[5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & M) + (((long) iArr2[6]) & M) + (((long) iArr3[6]) & M);
        iArr3[6] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int addTo(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        int i4 = i2 + 0;
        long j = (((long) i3) & M) + (((long) iArr[i + 0]) & M) + (((long) iArr2[i4]) & M);
        iArr2[i4] = (int) j;
        int i5 = i2 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i + 1]) & M) + (((long) iArr2[i5]) & M);
        iArr2[i5] = (int) j2;
        int i6 = i2 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i + 2]) & M) + (((long) iArr2[i6]) & M);
        iArr2[i6] = (int) j3;
        int i7 = i2 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i + 3]) & M) + (((long) iArr2[i7]) & M);
        iArr2[i7] = (int) j4;
        int i8 = i2 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i + 4]) & M) + (((long) iArr2[i8]) & M);
        iArr2[i8] = (int) j5;
        int i9 = i2 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i + 5]) & M) + (((long) iArr2[i9]) & M);
        iArr2[i9] = (int) j6;
        int i10 = i2 + 6;
        long j7 = (j6 >>> 32) + (((long) iArr[i + 6]) & M) + (M & ((long) iArr2[i10]));
        iArr2[i10] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int addTo(int[] iArr, int[] iArr2) {
        long j = (((long) iArr[0]) & M) + (((long) iArr2[0]) & M) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & M) + (((long) iArr2[1]) & M);
        iArr2[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & M) + (((long) iArr2[2]) & M);
        iArr2[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & M) + (((long) iArr2[3]) & M);
        iArr2[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & M) + (((long) iArr2[4]) & M);
        iArr2[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & M) + (((long) iArr2[5]) & M);
        iArr2[5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & M) + (M & ((long) iArr2[6]));
        iArr2[6] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int addToEachOther(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = i + 0;
        int i4 = i2 + 0;
        long j = (((long) iArr[i3]) & M) + (((long) iArr2[i4]) & M) + 0;
        int i5 = (int) j;
        iArr[i3] = i5;
        iArr2[i4] = i5;
        int i6 = i + 1;
        int i7 = i2 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i6]) & M) + (((long) iArr2[i7]) & M);
        int i8 = (int) j2;
        iArr[i6] = i8;
        iArr2[i7] = i8;
        int i9 = i + 2;
        int i10 = i2 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i9]) & M) + (((long) iArr2[i10]) & M);
        int i11 = (int) j3;
        iArr[i9] = i11;
        iArr2[i10] = i11;
        int i12 = i + 3;
        int i13 = i2 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i12]) & M) + (((long) iArr2[i13]) & M);
        int i14 = (int) j4;
        iArr[i12] = i14;
        iArr2[i13] = i14;
        int i15 = i + 4;
        int i16 = i2 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i15]) & M) + (((long) iArr2[i16]) & M);
        int i17 = (int) j5;
        iArr[i15] = i17;
        iArr2[i16] = i17;
        int i18 = i + 5;
        int i19 = i2 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i18]) & M) + (((long) iArr2[i19]) & M);
        int i20 = (int) j6;
        iArr[i18] = i20;
        iArr2[i19] = i20;
        int i21 = i + 6;
        int i22 = i2 + 6;
        long j7 = (j6 >>> 32) + (((long) iArr[i21]) & M) + (M & ((long) iArr2[i22]));
        int i23 = (int) j7;
        iArr[i21] = i23;
        iArr2[i22] = i23;
        return (int) (j7 >>> 32);
    }

    public static void copy(int[] iArr, int i, int[] iArr2, int i2) {
        iArr2[i2 + 0] = iArr[i + 0];
        iArr2[i2 + 1] = iArr[i + 1];
        iArr2[i2 + 2] = iArr[i + 2];
        iArr2[i2 + 3] = iArr[i + 3];
        iArr2[i2 + 4] = iArr[i + 4];
        iArr2[i2 + 5] = iArr[i + 5];
        iArr2[i2 + 6] = iArr[i + 6];
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
        iArr2[6] = iArr[6];
    }

    public static int[] create() {
        return new int[7];
    }

    public static int[] createExt() {
        return new int[14];
    }

    public static boolean diff(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        boolean gte = gte(iArr, i, iArr2, i2);
        if (gte) {
            sub(iArr, i, iArr2, i2, iArr3, i3);
        } else {
            sub(iArr2, i2, iArr, i, iArr3, i3);
        }
        return gte;
    }

    public static boolean eq(int[] iArr, int[] iArr2) {
        for (int i = 6; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 224) {
            throw new IllegalArgumentException();
        }
        int[] create = create();
        for (int i = 0; i < 7; i++) {
            create[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return create;
    }

    public static int getBit(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else {
            int i3 = i >> 5;
            if (i3 < 0 || i3 >= 7) {
                return 0;
            }
            i2 = iArr[i3] >>> (i & 31);
        }
        return i2 & 1;
    }

    public static boolean gte(int[] iArr, int i, int[] iArr2, int i2) {
        for (int i3 = 6; i3 >= 0; i3--) {
            int i4 = iArr[i + i3] ^ Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE ^ iArr2[i2 + i3];
            if (i4 < i5) {
                return false;
            }
            if (i4 > i5) {
                return true;
            }
        }
        return true;
    }

    public static boolean gte(int[] iArr, int[] iArr2) {
        for (int i = 6; i >= 0; i--) {
            int i2 = iArr[i] ^ Integer.MIN_VALUE;
            int i3 = Integer.MIN_VALUE ^ iArr2[i];
            if (i2 < i3) {
                return false;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }

    public static boolean isOne(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 7; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i = 0; i < 7; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void mul(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((long) iArr2[i2 + 0]) & M;
        long j2 = ((long) iArr2[i2 + 1]) & M;
        long j3 = ((long) iArr2[i2 + 2]) & M;
        long j4 = ((long) iArr2[i2 + 3]) & M;
        long j5 = ((long) iArr2[i2 + 4]) & M;
        long j6 = ((long) iArr2[i2 + 5]) & M;
        long j7 = ((long) iArr2[i2 + 6]) & M;
        long j8 = ((long) iArr[i + 0]) & M;
        long j9 = (j8 * j) + 0;
        long j10 = j;
        iArr3[i3 + 0] = (int) j9;
        long j11 = (j9 >>> 32) + (j8 * j2);
        long j12 = j2;
        iArr3[i3 + 1] = (int) j11;
        long j13 = (j11 >>> 32) + (j8 * j3);
        iArr3[i3 + 2] = (int) j13;
        long j14 = (j13 >>> 32) + (j8 * j4);
        iArr3[i3 + 3] = (int) j14;
        long j15 = (j14 >>> 32) + (j8 * j5);
        iArr3[i3 + 4] = (int) j15;
        long j16 = (j15 >>> 32) + (j8 * j6);
        iArr3[i3 + 5] = (int) j16;
        long j17 = j7;
        long j18 = (j16 >>> 32) + (j8 * j17);
        iArr3[i3 + 6] = (int) j18;
        iArr3[i3 + 7] = (int) (j18 >>> 32);
        int i4 = 1;
        int i5 = i3;
        int i6 = 1;
        while (i6 < 7) {
            i5 += i4;
            long j19 = ((long) iArr[i + i6]) & M;
            int i7 = i5 + 0;
            long j20 = (j19 * j10) + (((long) iArr3[i7]) & M) + 0;
            iArr3[i7] = (int) j20;
            int i8 = i5 + 1;
            long j21 = j17;
            long j22 = (j20 >>> 32) + (j19 * j12) + (((long) iArr3[i8]) & M);
            iArr3[i8] = (int) j22;
            int i9 = i5 + 2;
            long j23 = j3;
            long j24 = (j22 >>> 32) + (j19 * j3) + (((long) iArr3[i9]) & M);
            iArr3[i9] = (int) j24;
            int i10 = i5 + 3;
            long j25 = (j24 >>> 32) + (j19 * j4) + (((long) iArr3[i10]) & M);
            iArr3[i10] = (int) j25;
            int i11 = i5 + 4;
            long j26 = (j25 >>> 32) + (j19 * j5) + (((long) iArr3[i11]) & M);
            iArr3[i11] = (int) j26;
            int i12 = i5 + 5;
            long j27 = (j26 >>> 32) + (j19 * j6) + (((long) iArr3[i12]) & M);
            iArr3[i12] = (int) j27;
            int i13 = i5 + 6;
            long j28 = (j27 >>> 32) + (j19 * j21) + (((long) iArr3[i13]) & M);
            iArr3[i13] = (int) j28;
            iArr3[i5 + 7] = (int) (j28 >>> 32);
            i6++;
            j3 = j23;
            j17 = j21;
            j4 = j4;
            i4 = 1;
        }
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & M;
        long j2 = ((long) iArr2[1]) & M;
        long j3 = ((long) iArr2[2]) & M;
        long j4 = ((long) iArr2[3]) & M;
        long j5 = ((long) iArr2[4]) & M;
        long j6 = j3;
        long j7 = ((long) iArr2[5]) & M;
        long j8 = ((long) iArr2[6]) & M;
        long j9 = ((long) iArr[0]) & M;
        long j10 = (j9 * j) + 0;
        iArr3[0] = (int) j10;
        long j11 = (j10 >>> 32) + (j9 * j2);
        iArr3[1] = (int) j11;
        long j12 = (j11 >>> 32) + (j9 * j6);
        iArr3[2] = (int) j12;
        long j13 = (j12 >>> 32) + (j9 * j4);
        iArr3[3] = (int) j13;
        long j14 = (j13 >>> 32) + (j9 * j5);
        iArr3[4] = (int) j14;
        long j15 = (j14 >>> 32) + (j9 * j7);
        iArr3[5] = (int) j15;
        long j16 = (j15 >>> 32) + (j9 * j8);
        iArr3[6] = (int) j16;
        iArr3[7] = (int) (j16 >>> 32);
        int i = 1;
        for (int i2 = 7; i < i2; i2 = 7) {
            long j17 = ((long) iArr[i]) & M;
            int i3 = i + 0;
            long j18 = (j17 * j) + (((long) iArr3[i3]) & M) + 0;
            iArr3[i3] = (int) j18;
            int i4 = i + 1;
            long j19 = j2;
            long j20 = (j18 >>> 32) + (j17 * j2) + (((long) iArr3[i4]) & M);
            iArr3[i4] = (int) j20;
            int i5 = i + 2;
            long j21 = j7;
            long j22 = (j20 >>> 32) + (j17 * j6) + (((long) iArr3[i5]) & M);
            iArr3[i5] = (int) j22;
            int i6 = i + 3;
            long j23 = (j22 >>> 32) + (j17 * j4) + (((long) iArr3[i6]) & M);
            iArr3[i6] = (int) j23;
            int i7 = i + 4;
            long j24 = (j23 >>> 32) + (j17 * j5) + (((long) iArr3[i7]) & M);
            iArr3[i7] = (int) j24;
            int i8 = i + 5;
            long j25 = (j24 >>> 32) + (j17 * j21) + (((long) iArr3[i8]) & M);
            iArr3[i8] = (int) j25;
            int i9 = i + 6;
            long j26 = (j25 >>> 32) + (j17 * j8) + (((long) iArr3[i9]) & M);
            iArr3[i9] = (int) j26;
            iArr3[i + 7] = (int) (j26 >>> 32);
            i = i4;
            j = j;
            j2 = j19;
            j7 = j21;
        }
    }

    public static long mul33Add(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = ((long) i) & M;
        long j2 = ((long) iArr[i2 + 0]) & M;
        long j3 = (j * j2) + (((long) iArr2[i3 + 0]) & M) + 0;
        iArr3[i4 + 0] = (int) j3;
        long j4 = ((long) iArr[i2 + 1]) & M;
        long j5 = (j3 >>> 32) + (j * j4) + j2 + (((long) iArr2[i3 + 1]) & M);
        iArr3[i4 + 1] = (int) j5;
        long j6 = j5 >>> 32;
        long j7 = ((long) iArr[i2 + 2]) & M;
        long j8 = j6 + (j * j7) + j4 + (((long) iArr2[i3 + 2]) & M);
        iArr3[i4 + 2] = (int) j8;
        long j9 = ((long) iArr[i2 + 3]) & M;
        long j10 = (j8 >>> 32) + (j * j9) + j7 + (((long) iArr2[i3 + 3]) & M);
        iArr3[i4 + 3] = (int) j10;
        long j11 = ((long) iArr[i2 + 4]) & M;
        long j12 = (j10 >>> 32) + (j * j11) + j9 + (((long) iArr2[i3 + 4]) & M);
        iArr3[i4 + 4] = (int) j12;
        long j13 = ((long) iArr[i2 + 5]) & M;
        long j14 = (j12 >>> 32) + (j * j13) + j11 + (((long) iArr2[i3 + 5]) & M);
        iArr3[i4 + 5] = (int) j14;
        long j15 = ((long) iArr[i2 + 6]) & M;
        long j16 = (j14 >>> 32) + (j * j15) + j13 + (M & ((long) iArr2[i3 + 6]));
        iArr3[i4 + 6] = (int) j16;
        return (j16 >>> 32) + j15;
    }

    public static int mul33DWordAdd(int i, long j, int[] iArr, int i2) {
        int[] iArr2 = iArr;
        int i3 = i2;
        long j2 = ((long) i) & M;
        long j3 = j & M;
        int i4 = i3 + 0;
        long j4 = (j2 * j3) + (((long) iArr2[i4]) & M) + 0;
        iArr2[i4] = (int) j4;
        long j5 = j >>> 32;
        long j6 = (j2 * j5) + j3;
        int i5 = i3 + 1;
        long j7 = (j4 >>> 32) + j6 + (((long) iArr2[i5]) & M);
        iArr2[i5] = (int) j7;
        int i6 = i3 + 2;
        long j8 = (j7 >>> 32) + j5 + (((long) iArr2[i6]) & M);
        iArr2[i6] = (int) j8;
        int i7 = i3 + 3;
        long j9 = (j8 >>> 32) + (M & ((long) iArr2[i7]));
        iArr2[i7] = (int) j9;
        if ((j9 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(7, iArr2, i3, 4);
    }

    public static int mul33WordAdd(int i, int i2, int[] iArr, int i3) {
        long j = ((long) i) & M;
        long j2 = ((long) i2) & M;
        int i4 = i3 + 0;
        long j3 = (j * j2) + (((long) iArr[i4]) & M) + 0;
        iArr[i4] = (int) j3;
        int i5 = i3 + 1;
        long j4 = (j3 >>> 32) + j2 + (((long) iArr[i5]) & M);
        iArr[i5] = (int) j4;
        long j5 = j4 >>> 32;
        int i6 = i3 + 2;
        long j6 = j5 + (((long) iArr[i6]) & M);
        iArr[i6] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(7, iArr, i3, 3);
    }

    public static int mulAddTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((long) iArr2[i2 + 0]) & M;
        long j2 = ((long) iArr2[i2 + 1]) & M;
        long j3 = ((long) iArr2[i2 + 2]) & M;
        long j4 = ((long) iArr2[i2 + 3]) & M;
        long j5 = ((long) iArr2[i2 + 4]) & M;
        long j6 = ((long) iArr2[i2 + 5]) & M;
        long j7 = ((long) iArr2[i2 + 6]) & M;
        long j8 = 0;
        int i4 = 0;
        int i5 = i3;
        while (i4 < 7) {
            int i6 = i4;
            long j9 = ((long) iArr[i + i4]) & M;
            int i7 = i5 + 0;
            long j10 = j;
            long j11 = (j9 * j) + (((long) iArr3[i7]) & M) + 0;
            long j12 = j7;
            iArr3[i7] = (int) j11;
            int i8 = i5 + 1;
            long j13 = (j11 >>> 32) + (j9 * j2) + (((long) iArr3[i8]) & M);
            iArr3[i8] = (int) j13;
            int i9 = i5 + 2;
            long j14 = (j13 >>> 32) + (j9 * j3) + (((long) iArr3[i9]) & M);
            iArr3[i9] = (int) j14;
            int i10 = i5 + 3;
            long j15 = (j14 >>> 32) + (j9 * j4) + (((long) iArr3[i10]) & M);
            iArr3[i10] = (int) j15;
            int i11 = i5 + 4;
            long j16 = (j15 >>> 32) + (j9 * j5) + (((long) iArr3[i11]) & M);
            iArr3[i11] = (int) j16;
            int i12 = i5 + 5;
            long j17 = (j16 >>> 32) + (j9 * j6) + (((long) iArr3[i12]) & M);
            iArr3[i12] = (int) j17;
            int i13 = i5 + 6;
            long j18 = (j17 >>> 32) + (j9 * j12) + (((long) iArr3[i13]) & M);
            iArr3[i13] = (int) j18;
            int i14 = i5 + 7;
            long j19 = (j18 >>> 32) + (((long) iArr3[i14]) & M) + j8;
            iArr3[i14] = (int) j19;
            j8 = j19 >>> 32;
            i4 = i6 + 1;
            i5 = i8;
            j7 = j12;
            j = j10;
            j2 = j2;
        }
        return (int) j8;
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & M;
        long j2 = ((long) iArr2[1]) & M;
        long j3 = ((long) iArr2[2]) & M;
        long j4 = ((long) iArr2[3]) & M;
        long j5 = ((long) iArr2[4]) & M;
        long j6 = ((long) iArr2[5]) & M;
        long j7 = j;
        long j8 = ((long) iArr2[6]) & M;
        long j9 = 0;
        int i = 0;
        while (i < 7) {
            long j10 = j8;
            long j11 = ((long) iArr[i]) & M;
            int i2 = i + 0;
            long j12 = j6;
            long j13 = (j11 * j7) + (((long) iArr3[i2]) & M) + 0;
            iArr3[i2] = (int) j13;
            int i3 = i + 1;
            long j14 = j2;
            long j15 = (j13 >>> 32) + (j11 * j2) + (((long) iArr3[i3]) & M);
            iArr3[i3] = (int) j15;
            int i4 = i + 2;
            long j16 = (j15 >>> 32) + (j11 * j3) + (((long) iArr3[i4]) & M);
            iArr3[i4] = (int) j16;
            int i5 = i + 3;
            long j17 = (j16 >>> 32) + (j11 * j4) + (((long) iArr3[i5]) & M);
            iArr3[i5] = (int) j17;
            int i6 = i + 4;
            long j18 = (j17 >>> 32) + (j11 * j5) + (((long) iArr3[i6]) & M);
            iArr3[i6] = (int) j18;
            int i7 = i + 5;
            long j19 = (j18 >>> 32) + (j11 * j12) + (((long) iArr3[i7]) & M);
            iArr3[i7] = (int) j19;
            int i8 = i + 6;
            long j20 = (j19 >>> 32) + (j11 * j10) + (((long) iArr3[i8]) & M);
            iArr3[i8] = (int) j20;
            int i9 = i + 7;
            long j21 = (j20 >>> 32) + (((long) iArr3[i9]) & M) + j9;
            iArr3[i9] = (int) j21;
            j9 = j21 >>> 32;
            i = i3;
            j8 = j10;
            j6 = j12;
            j2 = j14;
        }
        return (int) j9;
    }

    public static int mulByWord(int i, int[] iArr) {
        long j = ((long) i) & M;
        long j2 = ((((long) iArr[0]) & M) * j) + 0;
        iArr[0] = (int) j2;
        long j3 = (j2 >>> 32) + ((((long) iArr[1]) & M) * j);
        iArr[1] = (int) j3;
        long j4 = (j3 >>> 32) + ((((long) iArr[2]) & M) * j);
        iArr[2] = (int) j4;
        long j5 = (j4 >>> 32) + ((((long) iArr[3]) & M) * j);
        iArr[3] = (int) j5;
        long j6 = (j5 >>> 32) + ((((long) iArr[4]) & M) * j);
        iArr[4] = (int) j6;
        long j7 = (j6 >>> 32) + ((((long) iArr[5]) & M) * j);
        iArr[5] = (int) j7;
        long j8 = (j7 >>> 32) + (j * (M & ((long) iArr[6])));
        iArr[6] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int mulByWordAddTo(int i, int[] iArr, int[] iArr2) {
        long j = ((long) i) & M;
        long j2 = ((((long) iArr2[0]) & M) * j) + (((long) iArr[0]) & M) + 0;
        iArr2[0] = (int) j2;
        long j3 = (j2 >>> 32) + ((((long) iArr2[1]) & M) * j) + (((long) iArr[1]) & M);
        iArr2[1] = (int) j3;
        long j4 = (j3 >>> 32) + ((((long) iArr2[2]) & M) * j) + (((long) iArr[2]) & M);
        iArr2[2] = (int) j4;
        long j5 = (j4 >>> 32) + ((((long) iArr2[3]) & M) * j) + (((long) iArr[3]) & M);
        iArr2[3] = (int) j5;
        long j6 = (j5 >>> 32) + ((((long) iArr2[4]) & M) * j) + (((long) iArr[4]) & M);
        iArr2[4] = (int) j6;
        long j7 = (j6 >>> 32) + ((((long) iArr2[5]) & M) * j) + (((long) iArr[5]) & M);
        iArr2[5] = (int) j7;
        long j8 = (j7 >>> 32) + (j * (((long) iArr2[6]) & M)) + (M & ((long) iArr[6]));
        iArr2[6] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int mulWord(int i, int[] iArr, int[] iArr2, int i2) {
        long j = ((long) i) & M;
        long j2 = 0;
        int i3 = 0;
        do {
            long j3 = j2 + ((((long) iArr[i3]) & M) * j);
            iArr2[i2 + i3] = (int) j3;
            j2 = j3 >>> 32;
            i3++;
        } while (i3 < 7);
        return (int) j2;
    }

    public static int mulWordAddTo(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = ((long) i) & M;
        int i4 = i3 + 0;
        long j2 = ((((long) iArr[i2 + 0]) & M) * j) + (((long) iArr2[i4]) & M) + 0;
        iArr2[i4] = (int) j2;
        int i5 = i3 + 1;
        long j3 = (j2 >>> 32) + ((((long) iArr[i2 + 1]) & M) * j) + (((long) iArr2[i5]) & M);
        iArr2[i5] = (int) j3;
        int i6 = i3 + 2;
        long j4 = (j3 >>> 32) + ((((long) iArr[i2 + 2]) & M) * j) + (((long) iArr2[i6]) & M);
        iArr2[i6] = (int) j4;
        int i7 = i3 + 3;
        long j5 = (j4 >>> 32) + ((((long) iArr[i2 + 3]) & M) * j) + (((long) iArr2[i7]) & M);
        iArr2[i7] = (int) j5;
        int i8 = i3 + 4;
        long j6 = (j5 >>> 32) + ((((long) iArr[i2 + 4]) & M) * j) + (((long) iArr2[i8]) & M);
        iArr2[i8] = (int) j6;
        int i9 = i3 + 5;
        long j7 = (j6 >>> 32) + ((((long) iArr[i2 + 5]) & M) * j) + (((long) iArr2[i9]) & M);
        iArr2[i9] = (int) j7;
        int i10 = i3 + 6;
        long j8 = (j7 >>> 32) + (j * (((long) iArr[i2 + 6]) & M)) + (((long) iArr2[i10]) & M);
        iArr2[i10] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int mulWordDwordAdd(int i, long j, int[] iArr, int i2) {
        long j2 = ((long) i) & M;
        int i3 = i2 + 0;
        long j3 = ((j & M) * j2) + (((long) iArr[i3]) & M) + 0;
        iArr[i3] = (int) j3;
        long j4 = j2 * (j >>> 32);
        int i4 = i2 + 1;
        long j5 = (j3 >>> 32) + j4 + (((long) iArr[i4]) & M);
        iArr[i4] = (int) j5;
        int i5 = i2 + 2;
        long j6 = (j5 >>> 32) + (((long) iArr[i5]) & M);
        iArr[i5] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(7, iArr, i2, 3);
    }

    public static void square(int[] iArr, int i, int[] iArr2, int i2) {
        long j = ((long) iArr[i + 0]) & M;
        int i3 = 0;
        int i4 = 14;
        int i5 = 6;
        while (true) {
            int i6 = i5 - 1;
            long j2 = ((long) iArr[i + i5]) & M;
            long j3 = j2 * j2;
            int i7 = i4 - 1;
            iArr2[i2 + i7] = (i3 << 31) | ((int) (j3 >>> 33));
            i4 = i7 - 1;
            iArr2[i2 + i4] = (int) (j3 >>> 1);
            i3 = (int) j3;
            if (i6 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i3 << 31)) & M) | (j4 >>> 33);
                iArr2[i2 + 0] = (int) j4;
                long j6 = ((long) iArr[i + 1]) & M;
                int i8 = i2 + 2;
                long j7 = ((long) iArr2[i8]) & M;
                long j8 = j5 + (j6 * j);
                int i9 = (int) j8;
                iArr2[i2 + 1] = (i9 << 1) | (((int) (j4 >>> 32)) & 1);
                int i10 = i9 >>> 31;
                long j9 = j7 + (j8 >>> 32);
                long j10 = ((long) iArr[i + 2]) & M;
                int i11 = i2 + 3;
                long j11 = j6;
                int i12 = i2 + 4;
                long j12 = ((long) iArr2[i11]) & M;
                long j13 = ((long) iArr2[i12]) & M;
                long j14 = j9 + (j10 * j);
                int i13 = (int) j14;
                iArr2[i8] = (i13 << 1) | i10;
                int i14 = i13 >>> 31;
                long j15 = j12 + (j14 >>> 32) + (j10 * j11);
                long j16 = j13 + (j15 >>> 32);
                long j17 = j15 & M;
                long j18 = j10;
                long j19 = ((long) iArr[i + 3]) & M;
                int i15 = i2 + 5;
                long j20 = (((long) iArr2[i15]) & M) + (j16 >>> 32);
                long j21 = j16 & M;
                int i16 = i2 + 6;
                int i17 = i15;
                long j22 = (((long) iArr2[i16]) & M) + (j20 >>> 32);
                long j23 = j20 & M;
                long j24 = j17 + (j19 * j);
                int i18 = (int) j24;
                iArr2[i11] = (i18 << 1) | i14;
                long j25 = j21 + (j24 >>> 32) + (j19 * j11);
                long j26 = j23 + (j25 >>> 32) + (j19 * j18);
                long j27 = j25 & M;
                long j28 = j22 + (j26 >>> 32);
                long j29 = j26 & M;
                long j30 = ((long) iArr[i + 4]) & M;
                int i19 = i2 + 7;
                long j31 = j19;
                long j32 = (((long) iArr2[i19]) & M) + (j28 >>> 32);
                int i20 = i2 + 8;
                int i21 = i19;
                long j33 = j28 & M;
                long j34 = (((long) iArr2[i20]) & M) + (j32 >>> 32);
                long j35 = j32 & M;
                long j36 = j27 + (j30 * j);
                int i22 = (int) j36;
                iArr2[i12] = (i18 >>> 31) | (i22 << 1);
                int i23 = i22 >>> 31;
                long j37 = j29 + (j36 >>> 32) + (j30 * j11);
                long j38 = j33 + (j37 >>> 32) + (j30 * j18);
                long j39 = j37 & M;
                long j40 = j35 + (j38 >>> 32) + (j30 * j31);
                long j41 = j38 & M;
                long j42 = j34 + (j40 >>> 32);
                long j43 = j40 & M;
                long j44 = j30;
                long j45 = ((long) iArr[i + 5]) & M;
                int i24 = i2 + 9;
                long j46 = j43;
                long j47 = (((long) iArr2[i24]) & M) + (j42 >>> 32);
                long j48 = j42 & M;
                int i25 = i2 + 10;
                int i26 = i24;
                long j49 = j47 & M;
                long j50 = j39 + (j45 * j);
                int i27 = (int) j50;
                iArr2[i17] = i23 | (i27 << 1);
                int i28 = i27 >>> 31;
                long j51 = j41 + (j50 >>> 32) + (j45 * j11);
                long j52 = j46 + (j51 >>> 32) + (j45 * j18);
                long j53 = j51 & M;
                long j54 = j48 + (j52 >>> 32) + (j45 * j31);
                long j55 = j52 & M;
                long j56 = j49 + (j54 >>> 32) + (j45 * j44);
                long j57 = j54 & M;
                long j58 = (((long) iArr2[i25]) & M) + (j47 >>> 32) + (j56 >>> 32);
                long j59 = j56 & M;
                long j60 = j45;
                long j61 = ((long) iArr[i + 6]) & M;
                int i29 = i2 + 11;
                long j62 = j59;
                long j63 = (((long) iArr2[i29]) & M) + (j58 >>> 32);
                int i30 = i2 + 12;
                int i31 = i29;
                long j64 = j63 & M;
                long j65 = j53 + (j * j61);
                int i32 = (int) j65;
                iArr2[i16] = (i32 << 1) | i28;
                long j66 = j55 + (j65 >>> 32) + (j61 * j11);
                long j67 = j57 + (j66 >>> 32) + (j61 * j18);
                long j68 = j62 + (j67 >>> 32) + (j61 * j31);
                long j69 = (j58 & M) + (j68 >>> 32) + (j61 * j44);
                long j70 = j64 + (j69 >>> 32) + (j61 * j60);
                long j71 = (((long) iArr2[i30]) & M) + (j63 >>> 32) + (j70 >>> 32);
                int i33 = (int) j66;
                iArr2[i21] = (i32 >>> 31) | (i33 << 1);
                int i34 = (int) j67;
                iArr2[i20] = (i33 >>> 31) | (i34 << 1);
                int i35 = i34 >>> 31;
                int i36 = (int) j68;
                iArr2[i26] = i35 | (i36 << 1);
                int i37 = i36 >>> 31;
                int i38 = (int) j69;
                iArr2[i25] = i37 | (i38 << 1);
                int i39 = i38 >>> 31;
                int i40 = (int) j70;
                iArr2[i31] = i39 | (i40 << 1);
                int i41 = i40 >>> 31;
                int i42 = (int) j71;
                iArr2[i30] = i41 | (i42 << 1);
                int i43 = i42 >>> 31;
                int i44 = i2 + 13;
                iArr2[i44] = i43 | ((iArr2[i44] + ((int) (j71 >>> 32))) << 1);
                return;
            }
            i5 = i6;
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & M;
        int i = 14;
        int i2 = 0;
        int i3 = 6;
        while (true) {
            int i4 = i3 - 1;
            long j2 = ((long) iArr[i3]) & M;
            long j3 = j2 * j2;
            int i5 = i - 1;
            iArr2[i5] = (i2 << 31) | ((int) (j3 >>> 33));
            i = i5 - 1;
            iArr2[i] = (int) (j3 >>> 1);
            int i6 = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i6 << 31)) & M) | (j4 >>> 33);
                iArr2[0] = (int) j4;
                long j6 = ((long) iArr[1]) & M;
                long j7 = ((long) iArr2[2]) & M;
                long j8 = j5 + (j6 * j);
                int i7 = (int) j8;
                iArr2[1] = (i7 << 1) | (((int) (j4 >>> 32)) & 1);
                long j9 = j7 + (j8 >>> 32);
                long j10 = ((long) iArr[2]) & M;
                long j11 = ((long) iArr2[3]) & M;
                long j12 = ((long) iArr2[4]) & M;
                long j13 = j9 + (j10 * j);
                int i8 = (int) j13;
                iArr2[2] = (i8 << 1) | (i7 >>> 31);
                long j14 = j11 + (j13 >>> 32) + (j10 * j6);
                long j15 = j12 + (j14 >>> 32);
                long j16 = j14 & M;
                long j17 = ((long) iArr[3]) & M;
                long j18 = j10;
                long j19 = (((long) iArr2[5]) & M) + (j15 >>> 32);
                long j20 = j15 & M;
                long j21 = (((long) iArr2[6]) & M) + (j19 >>> 32);
                long j22 = j19 & M;
                long j23 = j16 + (j17 * j);
                int i9 = (int) j23;
                iArr2[3] = (i9 << 1) | (i8 >>> 31);
                long j24 = j20 + (j23 >>> 32) + (j17 * j6);
                long j25 = j22 + (j24 >>> 32) + (j17 * j18);
                long j26 = j24 & M;
                long j27 = j21 + (j25 >>> 32);
                long j28 = j25 & M;
                long j29 = j17;
                long j30 = ((long) iArr[4]) & M;
                long j31 = j28;
                long j32 = (((long) iArr2[7]) & M) + (j27 >>> 32);
                long j33 = j27 & M;
                long j34 = (((long) iArr2[8]) & M) + (j32 >>> 32);
                long j35 = j32 & M;
                long j36 = j26 + (j30 * j);
                int i10 = (int) j36;
                iArr2[4] = (i9 >>> 31) | (i10 << 1);
                long j37 = j31 + (j36 >>> 32) + (j30 * j6);
                long j38 = j33 + (j37 >>> 32) + (j30 * j18);
                long j39 = j37 & M;
                long j40 = j35 + (j38 >>> 32) + (j30 * j29);
                long j41 = j38 & M;
                long j42 = j34 + (j40 >>> 32);
                long j43 = j40 & M;
                long j44 = j30;
                long j45 = ((long) iArr[5]) & M;
                long j46 = j43;
                long j47 = (((long) iArr2[9]) & M) + (j42 >>> 32);
                long j48 = j42 & M;
                long j49 = (((long) iArr2[10]) & M) + (j47 >>> 32);
                long j50 = j47 & M;
                long j51 = j39 + (j45 * j);
                int i11 = (int) j51;
                iArr2[5] = (i11 << 1) | (i10 >>> 31);
                long j52 = j41 + (j51 >>> 32) + (j45 * j6);
                long j53 = j46 + (j52 >>> 32) + (j45 * j18);
                long j54 = j52 & M;
                long j55 = j48 + (j53 >>> 32) + (j45 * j29);
                long j56 = j53 & M;
                long j57 = j50 + (j55 >>> 32) + (j45 * j44);
                long j58 = j55 & M;
                long j59 = j49 + (j57 >>> 32);
                long j60 = j57 & M;
                long j61 = j45;
                long j62 = ((long) iArr[6]) & M;
                long j63 = j60;
                long j64 = (((long) iArr2[11]) & M) + (j59 >>> 32);
                long j65 = j64 & M;
                long j66 = j54 + (j * j62);
                int i12 = (int) j66;
                iArr2[6] = (i11 >>> 31) | (i12 << 1);
                int i13 = i12 >>> 31;
                long j67 = j56 + (j66 >>> 32) + (j6 * j62);
                long j68 = j58 + (j67 >>> 32) + (j62 * j18);
                long j69 = j63 + (j68 >>> 32) + (j62 * j29);
                long j70 = (j59 & M) + (j69 >>> 32) + (j62 * j44);
                long j71 = j65 + (j70 >>> 32) + (j62 * j61);
                long j72 = (((long) iArr2[12]) & M) + (j64 >>> 32) + (j71 >>> 32);
                int i14 = (int) j67;
                iArr2[7] = i13 | (i14 << 1);
                int i15 = (int) j68;
                iArr2[8] = (i14 >>> 31) | (i15 << 1);
                int i16 = i15 >>> 31;
                int i17 = (int) j69;
                iArr2[9] = i16 | (i17 << 1);
                int i18 = i17 >>> 31;
                int i19 = (int) j70;
                iArr2[10] = i18 | (i19 << 1);
                int i20 = i19 >>> 31;
                int i21 = (int) j71;
                iArr2[11] = i20 | (i21 << 1);
                int i22 = i21 >>> 31;
                int i23 = (int) j72;
                iArr2[12] = i22 | (i23 << 1);
                iArr2[13] = (i23 >>> 31) | ((iArr2[13] + ((int) (j72 >>> 32))) << 1);
                return;
            }
            i3 = i4;
            i2 = i6;
        }
    }

    public static int sub(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((((long) iArr[i + 0]) & M) - (((long) iArr2[i2 + 0]) & M)) + 0;
        iArr3[i3 + 0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[i + 1]) & M) - (((long) iArr2[i2 + 1]) & M));
        iArr3[i3 + 1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[i + 2]) & M) - (((long) iArr2[i2 + 2]) & M));
        iArr3[i3 + 2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[i + 3]) & M) - (((long) iArr2[i2 + 3]) & M));
        iArr3[i3 + 3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr[i + 4]) & M) - (((long) iArr2[i2 + 4]) & M));
        iArr3[i3 + 4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr[i + 5]) & M) - (((long) iArr2[i2 + 5]) & M));
        iArr3[i3 + 5] = (int) j6;
        long j7 = (j6 >> 32) + ((((long) iArr[i + 6]) & M) - (((long) iArr2[i2 + 6]) & M));
        iArr3[i3 + 6] = (int) j7;
        return (int) (j7 >> 32);
    }

    public static int sub(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & M) - (((long) iArr2[0]) & M)) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[1]) & M) - (((long) iArr2[1]) & M));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[2]) & M) - (((long) iArr2[2]) & M));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[3]) & M) - (((long) iArr2[3]) & M));
        iArr3[3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr[4]) & M) - (((long) iArr2[4]) & M));
        iArr3[4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr[5]) & M) - (((long) iArr2[5]) & M));
        iArr3[5] = (int) j6;
        long j7 = (j6 >> 32) + ((((long) iArr[6]) & M) - (((long) iArr2[6]) & M));
        iArr3[6] = (int) j7;
        return (int) (j7 >> 32);
    }

    public static int subBothFrom(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((((long) iArr3[0]) & M) - (((long) iArr[0]) & M)) - (((long) iArr2[0]) & M)) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + (((((long) iArr3[1]) & M) - (((long) iArr[1]) & M)) - (((long) iArr2[1]) & M));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + (((((long) iArr3[2]) & M) - (((long) iArr[2]) & M)) - (((long) iArr2[2]) & M));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + (((((long) iArr3[3]) & M) - (((long) iArr[3]) & M)) - (((long) iArr2[3]) & M));
        iArr3[3] = (int) j4;
        long j5 = (j4 >> 32) + (((((long) iArr3[4]) & M) - (((long) iArr[4]) & M)) - (((long) iArr2[4]) & M));
        iArr3[4] = (int) j5;
        long j6 = (j5 >> 32) + (((((long) iArr3[5]) & M) - (((long) iArr[5]) & M)) - (((long) iArr2[5]) & M));
        iArr3[5] = (int) j6;
        long j7 = (j6 >> 32) + (((((long) iArr3[6]) & M) - (((long) iArr[6]) & M)) - (((long) iArr2[6]) & M));
        iArr3[6] = (int) j7;
        return (int) (j7 >> 32);
    }

    public static int subFrom(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = i2 + 0;
        long j = ((((long) iArr2[i3]) & M) - (((long) iArr[i + 0]) & M)) + 0;
        iArr2[i3] = (int) j;
        int i4 = i2 + 1;
        long j2 = (j >> 32) + ((((long) iArr2[i4]) & M) - (((long) iArr[i + 1]) & M));
        iArr2[i4] = (int) j2;
        int i5 = i2 + 2;
        long j3 = (j2 >> 32) + ((((long) iArr2[i5]) & M) - (((long) iArr[i + 2]) & M));
        iArr2[i5] = (int) j3;
        int i6 = i2 + 3;
        long j4 = (j3 >> 32) + ((((long) iArr2[i6]) & M) - (((long) iArr[i + 3]) & M));
        iArr2[i6] = (int) j4;
        int i7 = i2 + 4;
        long j5 = (j4 >> 32) + ((((long) iArr2[i7]) & M) - (((long) iArr[i + 4]) & M));
        iArr2[i7] = (int) j5;
        int i8 = i2 + 5;
        long j6 = (j5 >> 32) + ((((long) iArr2[i8]) & M) - (((long) iArr[i + 5]) & M));
        iArr2[i8] = (int) j6;
        int i9 = i2 + 6;
        long j7 = (j6 >> 32) + ((((long) iArr2[i9]) & M) - (((long) iArr[i + 6]) & M));
        iArr2[i9] = (int) j7;
        return (int) (j7 >> 32);
    }

    public static int subFrom(int[] iArr, int[] iArr2) {
        long j = ((((long) iArr2[0]) & M) - (((long) iArr[0]) & M)) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr2[1]) & M) - (((long) iArr[1]) & M));
        iArr2[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr2[2]) & M) - (((long) iArr[2]) & M));
        iArr2[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr2[3]) & M) - (((long) iArr[3]) & M));
        iArr2[3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr2[4]) & M) - (((long) iArr[4]) & M));
        iArr2[4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr2[5]) & M) - (((long) iArr[5]) & M));
        iArr2[5] = (int) j6;
        long j7 = (j6 >> 32) + ((((long) iArr2[6]) & M) - (M & ((long) iArr[6])));
        iArr2[6] = (int) j7;
        return (int) (j7 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[28];
        for (int i = 0; i < 7; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                Pack.intToBigEndian(i2, bArr, (6 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void zero(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
        iArr[6] = 0;
    }
}
