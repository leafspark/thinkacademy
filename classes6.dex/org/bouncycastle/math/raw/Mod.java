package org.bouncycastle.math.raw;

import java.util.Random;
import org.bouncycastle.util.Integers;

public abstract class Mod {
    private static final int M30 = 1073741823;
    private static final long M32L = 4294967295L;

    public static void add(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int length = iArr.length;
        if (Nat.add(length, iArr2, iArr3, iArr4) != 0) {
            Nat.subFrom(length, iArr, iArr4);
        }
    }

    private static int add30(int i, int[] iArr, int[] iArr2) {
        int i2 = i - 1;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i3 + iArr[i4] + iArr2[i4];
            iArr[i4] = 1073741823 & i5;
            i3 = i5 >> 30;
        }
        int i6 = i3 + iArr[i2] + iArr2[i2];
        iArr[i2] = i6;
        return i6 >> 30;
    }

    public static void checkedModOddInverse(int[] iArr, int[] iArr2, int[] iArr3) {
        if (modOddInverse(iArr, iArr2, iArr3) == 0) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    public static void checkedModOddInverseVar(int[] iArr, int[] iArr2, int[] iArr3) {
        if (!modOddInverseVar(iArr, iArr2, iArr3)) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    private static void cnegate30(int i, int i2, int[] iArr) {
        int i3 = i - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i4 + ((iArr[i5] ^ i2) - i2);
            iArr[i5] = 1073741823 & i6;
            i4 = i6 >> 30;
        }
        iArr[i3] = i4 + ((iArr[i3] ^ i2) - i2);
    }

    private static void cnormalize30(int i, int i2, int[] iArr, int[] iArr2) {
        int i3 = i - 1;
        int i4 = iArr[i3] >> 31;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = i5 + (((iArr[i6] + (iArr2[i6] & i4)) ^ i2) - i2);
            iArr[i6] = 1073741823 & i7;
            i5 = i7 >> 30;
        }
        iArr[i3] = i5 + (((iArr[i3] + (i4 & iArr2[i3])) ^ i2) - i2);
        int i8 = iArr[i3] >> 31;
        int i9 = 0;
        for (int i10 = 0; i10 < i3; i10++) {
            int i11 = i9 + iArr[i10] + (iArr2[i10] & i8);
            iArr[i10] = i11 & 1073741823;
            i9 = i11 >> 30;
        }
        iArr[i3] = i9 + iArr[i3] + (i8 & iArr2[i3]);
    }

    private static void decode30(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = 0;
        long j = 0;
        while (i > 0) {
            while (i4 < Math.min(32, i)) {
                j |= ((long) iArr[i2]) << i4;
                i4 += 30;
                i2++;
            }
            iArr2[i3] = (int) j;
            j >>>= 32;
            i4 -= 32;
            i -= 32;
            i3++;
        }
    }

    private static int divsteps30(int i, int i2, int i3, int[] iArr) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        int i7 = 1;
        for (int i8 = 0; i8 < 30; i8++) {
            int i9 = i >> 31;
            int i10 = -(i3 & 1);
            int i11 = i3 + (((i2 ^ i9) - i9) & i10);
            i5 += ((i6 ^ i9) - i9) & i10;
            i7 += ((i4 ^ i9) - i9) & i10;
            int i12 = i9 & i10;
            i = (i ^ i12) - (i12 + 1);
            i2 += i11 & i12;
            i3 = i11 >> 1;
            i6 = (i6 + (i5 & i12)) << 1;
            i4 = (i4 + (i12 & i7)) << 1;
        }
        iArr[0] = i6;
        iArr[1] = i4;
        iArr[2] = i5;
        iArr[3] = i7;
        return i;
    }

    private static int divsteps30Var(int i, int i2, int i3, int[] iArr) {
        int i4;
        int i5 = i2;
        int i6 = i3;
        int i7 = 0;
        int i8 = 0;
        int i9 = 1;
        int i10 = 1;
        int i11 = 30;
        int i12 = i;
        while (true) {
            int numberOfTrailingZeros = Integers.numberOfTrailingZeros((-1 << i11) | i6);
            int i13 = i6 >> numberOfTrailingZeros;
            i9 <<= numberOfTrailingZeros;
            i7 <<= numberOfTrailingZeros;
            i12 -= numberOfTrailingZeros;
            i11 -= numberOfTrailingZeros;
            if (i11 <= 0) {
                iArr[0] = i9;
                iArr[1] = i7;
                iArr[2] = i8;
                iArr[3] = i10;
                return i12;
            }
            if (i12 < 0) {
                i12 = -i12;
                int i14 = -i5;
                int i15 = -i9;
                int i16 = -i7;
                int i17 = i12 + 1;
                if (i17 > i11) {
                    i17 = i11;
                }
                i4 = (-1 >>> (32 - i17)) & 63 & (i13 * i14 * ((i13 * i13) - 2));
                int i18 = i13;
                i13 = i14;
                i5 = i18;
                int i19 = i8;
                i8 = i15;
                i9 = i19;
                int i20 = i10;
                i10 = i16;
                i7 = i20;
            } else {
                int i21 = i12 + 1;
                if (i21 > i11) {
                    i21 = i11;
                }
                i4 = (-1 >>> (32 - i21)) & 15 & ((-((((i5 + 1) & 4) << 1) + i5)) * i13);
            }
            i6 = i13 + (i5 * i4);
            i8 += i9 * i4;
            i10 += i4 * i7;
        }
    }

    private static void encode30(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = 0;
        long j = 0;
        while (i > 0) {
            if (i4 < Math.min(30, i)) {
                j |= (((long) iArr[i2]) & M32L) << i4;
                i4 += 32;
                i2++;
            }
            iArr2[i3] = ((int) j) & 1073741823;
            j >>>= 30;
            i4 -= 30;
            i -= 30;
            i3++;
        }
    }

    private static int getMaximumDivsteps(int i) {
        return ((i * 49) + (i < 46 ? 80 : 47)) / 17;
    }

    public static int inverse32(int i) {
        int i2 = (2 - (i * i)) * i;
        int i3 = i2 * (2 - (i * i2));
        int i4 = i3 * (2 - (i * i3));
        return i4 * (2 - (i * i4));
    }

    public static void invert(int[] iArr, int[] iArr2, int[] iArr3) {
        checkedModOddInverseVar(iArr, iArr2, iArr3);
    }

    public static int modOddInverse(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = iArr;
        int length = iArr4.length;
        int numberOfLeadingZeros = (length << 5) - Integers.numberOfLeadingZeros(iArr4[length - 1]);
        int i = (numberOfLeadingZeros + 29) / 30;
        int[] iArr5 = new int[4];
        int[] iArr6 = new int[i];
        int[] iArr7 = new int[i];
        int[] iArr8 = new int[i];
        int[] iArr9 = new int[i];
        int[] iArr10 = new int[i];
        int i2 = 0;
        iArr7[0] = 1;
        encode30(numberOfLeadingZeros, iArr2, 0, iArr9, 0);
        encode30(numberOfLeadingZeros, iArr4, 0, iArr10, 0);
        System.arraycopy(iArr10, 0, iArr8, 0, i);
        int inverse32 = inverse32(iArr10[0]);
        int i3 = -1;
        int i4 = 0;
        for (int maximumDivsteps = getMaximumDivsteps(numberOfLeadingZeros); i4 < maximumDivsteps; maximumDivsteps = maximumDivsteps) {
            int divsteps30 = divsteps30(i3, iArr8[i2], iArr9[i2], iArr5);
            updateDE30(i, iArr6, iArr7, iArr5, inverse32, iArr10);
            updateFG30(i, iArr8, iArr9, iArr5);
            i4 += 30;
            i2 = i2;
            i3 = divsteps30;
        }
        int i5 = i2;
        int i6 = iArr8[i - 1] >> 31;
        cnegate30(i, i6, iArr8);
        cnormalize30(i, i6, iArr6, iArr10);
        decode30(numberOfLeadingZeros, iArr6, i5, iArr3, i5);
        return Nat.equalTo(i, iArr8, 1) & Nat.equalToZero(i, iArr9);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r9v3 */
    public static boolean modOddInverseVar(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = iArr;
        int length = iArr4.length;
        int numberOfLeadingZeros = (length << 5) - Integers.numberOfLeadingZeros(iArr4[length - 1]);
        int i = (numberOfLeadingZeros + 29) / 30;
        int[] iArr5 = new int[4];
        int[] iArr6 = new int[i];
        int[] iArr7 = new int[i];
        int[] iArr8 = new int[i];
        int[] iArr9 = new int[i];
        int[] iArr10 = new int[i];
        ? r9 = 0;
        iArr7[0] = 1;
        encode30(numberOfLeadingZeros, iArr2, 0, iArr9, 0);
        encode30(numberOfLeadingZeros, iArr4, 0, iArr10, 0);
        System.arraycopy(iArr10, 0, iArr8, 0, i);
        int i2 = i - 1;
        int numberOfLeadingZeros2 = -1 - (Integers.numberOfLeadingZeros(iArr9[i2] | 1) - (((i * 30) + 2) - numberOfLeadingZeros));
        int inverse32 = inverse32(iArr10[0]);
        int maximumDivsteps = getMaximumDivsteps(numberOfLeadingZeros);
        int i3 = i;
        int i4 = 0;
        while (!Nat.isZero(i3, iArr9)) {
            if (i4 >= maximumDivsteps) {
                return r9;
            }
            int i5 = i4 + 30;
            int divsteps30Var = divsteps30Var(numberOfLeadingZeros2, iArr8[r9], iArr9[r9], iArr5);
            int i6 = i3;
            int i7 = maximumDivsteps;
            int[] iArr11 = iArr7;
            boolean z = r9;
            updateDE30(i, iArr6, iArr7, iArr5, inverse32, iArr10);
            updateFG30(i6, iArr8, iArr9, iArr5);
            int i8 = i6 - 1;
            int i9 = iArr8[i8];
            int i10 = iArr9[i8];
            int i11 = i6 - 2;
            if (((i11 >> 31) | ((i9 >> 31) ^ i9) | ((i10 >> 31) ^ i10)) == 0) {
                iArr8[i11] = (i9 << 30) | iArr8[i11];
                iArr9[i11] = iArr9[i11] | (i10 << 30);
                i3 = i6 - 1;
            } else {
                i3 = i6;
            }
            r9 = z;
            i4 = i5;
            numberOfLeadingZeros2 = divsteps30Var;
            maximumDivsteps = i7;
            iArr7 = iArr11;
        }
        int i12 = i3;
        boolean z2 = r9;
        int i13 = iArr8[i12 - 1] >> 31;
        int i14 = iArr6[i2] >> 31;
        if (i14 < 0) {
            i14 = add30(i, iArr6, iArr10);
        }
        if (i13 < 0) {
            i14 = negate30(i, iArr6);
            negate30(i12, iArr8);
        }
        if (!Nat.isOne(i12, iArr8)) {
            return z2;
        }
        if (i14 < 0) {
            add30(i, iArr6, iArr10);
        }
        decode30(numberOfLeadingZeros, iArr6, z2 ? 1 : 0, iArr3, z2);
        return true;
    }

    private static int negate30(int i, int[] iArr) {
        int i2 = i - 1;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i3 - iArr[i4];
            iArr[i4] = 1073741823 & i5;
            i3 = i5 >> 30;
        }
        int i6 = i3 - iArr[i2];
        iArr[i2] = i6;
        return i6 >> 30;
    }

    public static int[] random(int[] iArr) {
        int length = iArr.length;
        Random random = new Random();
        int[] create = Nat.create(length);
        int i = length - 1;
        int i2 = iArr[i];
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        int i7 = i6 | (i6 >>> 16);
        do {
            for (int i8 = 0; i8 != length; i8++) {
                create[i8] = random.nextInt();
            }
            create[i] = create[i] & i7;
        } while (Nat.gte(length, create, iArr));
        return create;
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int length = iArr.length;
        if (Nat.sub(length, iArr2, iArr3, iArr4) != 0) {
            Nat.addTo(length, iArr, iArr4);
        }
    }

    private static void updateDE30(int i, int[] iArr, int[] iArr2, int[] iArr3, int i2, int[] iArr4) {
        int i3 = i;
        int i4 = iArr3[0];
        int i5 = iArr3[1];
        int i6 = iArr3[2];
        int i7 = iArr3[3];
        int i8 = i3 - 1;
        int i9 = iArr[i8] >> 31;
        int i10 = iArr2[i8] >> 31;
        int i11 = (i4 & i9) + (i5 & i10);
        int i12 = (i9 & i6) + (i10 & i7);
        int i13 = iArr4[0];
        long j = (long) i4;
        long j2 = (long) iArr[0];
        long j3 = (long) i5;
        long j4 = (long) iArr2[0];
        long j5 = j3;
        long j6 = (j * j2) + (j3 * j4);
        long j7 = j;
        long j8 = (long) i6;
        long j9 = (long) i7;
        long j10 = (j2 * j8) + (j4 * j9);
        long j11 = (long) i13;
        long j12 = (long) (i11 - (((((int) j6) * i2) + i11) & 1073741823));
        int i14 = i8;
        long j13 = (long) (i12 - (((((int) j10) * i2) + i12) & 1073741823));
        long j14 = (j10 + (j11 * j13)) >> 30;
        long j15 = (j6 + (j11 * j12)) >> 30;
        int i15 = 1;
        while (i15 < i3) {
            int i16 = iArr4[i15];
            long j16 = j14;
            long j17 = (long) iArr[i15];
            int i17 = i15;
            long j18 = (long) iArr2[i15];
            long j19 = j13;
            long j20 = (long) i16;
            long j21 = j15 + (j7 * j17) + (j5 * j18) + (j20 * j12);
            long j22 = j16 + (j17 * j8) + (j18 * j9) + (j20 * j19);
            int i18 = i17 - 1;
            iArr[i18] = ((int) j21) & 1073741823;
            j15 = j21 >> 30;
            iArr2[i18] = ((int) j22) & 1073741823;
            j14 = j22 >> 30;
            i15 = i17 + 1;
            i3 = i;
            i14 = i14;
            j13 = j19;
        }
        int i19 = i14;
        long j23 = j14;
        iArr[i19] = (int) j15;
        iArr2[i19] = (int) j14;
    }

    private static void updateFG30(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        int i2 = i;
        int i3 = iArr3[0];
        int i4 = 1;
        int i5 = iArr3[1];
        int i6 = iArr3[2];
        int i7 = iArr3[3];
        long j = (long) i3;
        long j2 = (long) iArr[0];
        long j3 = (long) i5;
        long j4 = (long) iArr2[0];
        long j5 = (long) i6;
        long j6 = (long) i7;
        long j7 = ((j * j2) + (j3 * j4)) >> 30;
        long j8 = ((j2 * j5) + (j4 * j6)) >> 30;
        int i8 = 1;
        while (i8 < i2) {
            int i9 = iArr[i8];
            int i10 = iArr2[i8];
            int i11 = i8;
            long j9 = (long) i9;
            long j10 = j * j9;
            long j11 = j;
            long j12 = (long) i10;
            long j13 = j7 + j10 + (j3 * j12);
            long j14 = j8 + (j9 * j5) + (j12 * j6);
            int i12 = i11 - 1;
            iArr[i12] = ((int) j13) & 1073741823;
            j7 = j13 >> 30;
            iArr2[i12] = 1073741823 & ((int) j14);
            j8 = j14 >> 30;
            i8 = i11 + 1;
            j = j11;
            i4 = 1;
        }
        int i13 = i2 - i4;
        iArr[i13] = (int) j7;
        iArr2[i13] = (int) j8;
    }
}
