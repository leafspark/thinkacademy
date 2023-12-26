package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat384;
import org.bouncycastle.util.Pack;

public class SecP384R1Field {
    private static final long M = 4294967295L;
    static final int[] P = {-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};
    private static final int P11 = -1;
    private static final int[] PExt = {1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};
    private static final int PExt23 = -1;
    private static final int[] PExtInv = {-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.add(12, iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && Nat.gte(12, iArr3, P))) {
            addPInvTo(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.add(24, iArr, iArr2, iArr3) != 0 || (iArr3[23] == -1 && Nat.gte(24, iArr3, PExt))) {
            int[] iArr4 = PExtInv;
            if (Nat.addTo(iArr4.length, iArr4, iArr3) != 0) {
                Nat.incAt(24, iArr3, iArr4.length);
            }
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (Nat.inc(12, iArr, iArr2) != 0 || (iArr2[11] == -1 && Nat.gte(12, iArr2, P))) {
            addPInvTo(iArr2);
        }
    }

    private static void addPInvTo(int[] iArr) {
        long j = (((long) iArr[0]) & M) + 1;
        iArr[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[1]) & M) - 1);
        iArr[1] = (int) j2;
        long j3 = j2 >> 32;
        if (j3 != 0) {
            long j4 = j3 + (((long) iArr[2]) & M);
            iArr[2] = (int) j4;
            j3 = j4 >> 32;
        }
        long j5 = j3 + (((long) iArr[3]) & M) + 1;
        iArr[3] = (int) j5;
        long j6 = (j5 >> 32) + (M & ((long) iArr[4])) + 1;
        iArr[4] = (int) j6;
        if ((j6 >> 32) != 0) {
            Nat.incAt(12, iArr, 5);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] fromBigInteger = Nat.fromBigInteger(384, bigInteger);
        if (fromBigInteger[11] == -1) {
            int[] iArr = P;
            if (Nat.gte(12, fromBigInteger, iArr)) {
                Nat.subFrom(12, iArr, fromBigInteger);
            }
        }
        return fromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            Nat.shiftDownBit(12, iArr, 0, iArr2);
        } else {
            Nat.shiftDownBit(12, iArr2, Nat.add(12, iArr, P, iArr2));
        }
    }

    public static void inv(int[] iArr, int[] iArr2) {
        Mod.checkedModOddInverse(P, iArr, iArr2);
    }

    public static int isZero(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 12; i2++) {
            i |= iArr[i2];
        }
        return (((i >>> 1) | (i & 1)) - 1) >> 31;
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = Nat.create(24);
        Nat384.mul(iArr, iArr2, create);
        reduce(create, iArr3);
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (isZero(iArr) != 0) {
            int[] iArr3 = P;
            Nat.sub(12, iArr3, iArr3, iArr2);
            return;
        }
        Nat.sub(12, P, iArr, iArr2);
    }

    public static void random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[48];
        do {
            secureRandom.nextBytes(bArr);
            Pack.littleEndianToInt(bArr, 0, iArr, 0, 12);
        } while (Nat.lessThan(12, iArr, P) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            random(secureRandom, iArr);
        } while (isZero(iArr) != 0);
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) iArr[16]) & M;
        long j2 = ((long) iArr[17]) & M;
        long j3 = ((long) iArr[18]) & M;
        long j4 = ((long) iArr[19]) & M;
        long j5 = ((long) iArr[20]) & M;
        long j6 = ((long) iArr[21]) & M;
        long j7 = j4;
        long j8 = ((long) iArr[22]) & M;
        long j9 = j3;
        long j10 = ((long) iArr[23]) & M;
        long j11 = j;
        long j12 = ((((long) iArr[12]) & M) + j5) - 1;
        long j13 = j5;
        long j14 = (((long) iArr[13]) & M) + j8;
        long j15 = (((long) iArr[14]) & M) + j8 + j10;
        long j16 = (((long) iArr[15]) & M) + j10;
        long j17 = j2 + j6;
        long j18 = j6 - j10;
        long j19 = j12 + j18;
        long j20 = j8 - j10;
        long j21 = (((long) iArr[0]) & M) + j19 + 0;
        iArr3[0] = (int) j21;
        long j22 = (j21 >> 32) + (((((long) iArr[1]) & M) + j10) - j12) + j14;
        iArr3[1] = (int) j22;
        long j23 = (j22 >> 32) + (((((long) iArr[2]) & M) - j6) - j14) + j15;
        iArr3[2] = (int) j23;
        long j24 = (j23 >> 32) + ((((long) iArr[3]) & M) - j15) + j16 + j19;
        iArr3[3] = (int) j24;
        long j25 = (j24 >> 32) + (((((((long) iArr[4]) & M) + j11) + j6) + j14) - j16) + j19;
        iArr3[4] = (int) j25;
        long j26 = (j25 >> 32) + ((((long) iArr[5]) & M) - j11) + j14 + j15 + j17;
        iArr3[5] = (int) j26;
        long j27 = (j26 >> 32) + (((((long) iArr[6]) & M) + j9) - j2) + j15 + j16;
        iArr3[6] = (int) j27;
        long j28 = (j27 >> 32) + ((((((long) iArr[7]) & M) + j11) + j7) - j9) + j16;
        iArr3[7] = (int) j28;
        long j29 = (j28 >> 32) + (((((((long) iArr[8]) & M) + j11) + j2) + j13) - j7);
        iArr3[8] = (int) j29;
        long j30 = (j29 >> 32) + (((((long) iArr[9]) & M) + j9) - j13) + j17;
        iArr3[9] = (int) j30;
        long j31 = (j30 >> 32) + ((((((long) iArr[10]) & M) + j9) + j7) - j18) + j20;
        iArr3[10] = (int) j31;
        long j32 = (j31 >> 32) + ((((((long) iArr[11]) & M) + j7) + j13) - j20);
        iArr3[11] = (int) j32;
        reduce32((int) ((j32 >> 32) + 1), iArr3);
    }

    public static void reduce32(int i, int[] iArr) {
        long j;
        if (i != 0) {
            long j2 = ((long) i) & M;
            long j3 = (((long) iArr[0]) & M) + j2 + 0;
            iArr[0] = (int) j3;
            long j4 = (j3 >> 32) + ((((long) iArr[1]) & M) - j2);
            iArr[1] = (int) j4;
            long j5 = j4 >> 32;
            if (j5 != 0) {
                long j6 = j5 + (((long) iArr[2]) & M);
                iArr[2] = (int) j6;
                j5 = j6 >> 32;
            }
            long j7 = j5 + (((long) iArr[3]) & M) + j2;
            iArr[3] = (int) j7;
            long j8 = (j7 >> 32) + (M & ((long) iArr[4])) + j2;
            iArr[4] = (int) j8;
            j = j8 >> 32;
        } else {
            j = 0;
        }
        if ((j != 0 && Nat.incAt(12, iArr, 5) != 0) || (iArr[11] == -1 && Nat.gte(12, iArr, P))) {
            addPInvTo(iArr);
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] create = Nat.create(24);
        Nat384.square(iArr, create);
        reduce(create, iArr2);
    }

    public static void squareN(int[] iArr, int i, int[] iArr2) {
        int[] create = Nat.create(24);
        Nat384.square(iArr, create);
        while (true) {
            reduce(create, iArr2);
            i--;
            if (i > 0) {
                Nat384.square(iArr2, create);
            } else {
                return;
            }
        }
    }

    private static void subPInvFrom(int[] iArr) {
        long j = (((long) iArr[0]) & M) - 1;
        iArr[0] = (int) j;
        long j2 = (j >> 32) + (((long) iArr[1]) & M) + 1;
        iArr[1] = (int) j2;
        long j3 = j2 >> 32;
        if (j3 != 0) {
            long j4 = j3 + (((long) iArr[2]) & M);
            iArr[2] = (int) j4;
            j3 = j4 >> 32;
        }
        long j5 = j3 + ((((long) iArr[3]) & M) - 1);
        iArr[3] = (int) j5;
        long j6 = (j5 >> 32) + ((M & ((long) iArr[4])) - 1);
        iArr[4] = (int) j6;
        if ((j6 >> 32) != 0) {
            Nat.decAt(12, iArr, 5);
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.sub(12, iArr, iArr2, iArr3) != 0) {
            subPInvFrom(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.sub(24, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = PExtInv;
            if (Nat.subFrom(iArr4.length, iArr4, iArr3) != 0) {
                Nat.decAt(24, iArr3, iArr4.length);
            }
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (Nat.shiftUpBit(12, iArr, 0, iArr2) != 0 || (iArr2[11] == -1 && Nat.gte(12, iArr2, P))) {
            addPInvTo(iArr2);
        }
    }
}
