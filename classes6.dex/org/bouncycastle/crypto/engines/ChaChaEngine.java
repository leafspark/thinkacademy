package org.bouncycastle.crypto.engines;

import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

public class ChaChaEngine extends Salsa20Engine {
    public ChaChaEngine() {
    }

    public ChaChaEngine(int i) {
        super(i);
    }

    public static void chachaCore(int i, int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int i2 = 16;
        if (iArr3.length != 16) {
            throw new IllegalArgumentException();
        } else if (iArr4.length != 16) {
            throw new IllegalArgumentException();
        } else if (i % 2 == 0) {
            char c = 0;
            int i3 = iArr3[0];
            int i4 = iArr3[1];
            int i5 = iArr3[2];
            int i6 = iArr3[3];
            int i7 = iArr3[4];
            int i8 = iArr3[5];
            int i9 = iArr3[6];
            int i10 = 7;
            int i11 = iArr3[7];
            int i12 = 8;
            int i13 = iArr3[8];
            int i14 = iArr3[9];
            int i15 = iArr3[10];
            int i16 = iArr3[11];
            int i17 = 12;
            int i18 = iArr3[12];
            int i19 = iArr3[13];
            int i20 = iArr3[14];
            int i21 = iArr3[15];
            int i22 = i20;
            int i23 = i19;
            int i24 = i18;
            int i25 = i16;
            int i26 = i15;
            int i27 = i14;
            int i28 = i13;
            int i29 = i11;
            int i30 = i9;
            int i31 = i8;
            int i32 = i7;
            int i33 = i6;
            int i34 = i5;
            int i35 = i4;
            int i36 = i3;
            int i37 = i;
            while (i37 > 0) {
                int i38 = i36 + i32;
                int rotateLeft = Integers.rotateLeft(i24 ^ i38, i2);
                int i39 = i28 + rotateLeft;
                int rotateLeft2 = Integers.rotateLeft(i32 ^ i39, i17);
                int i40 = i38 + rotateLeft2;
                int rotateLeft3 = Integers.rotateLeft(rotateLeft ^ i40, i12);
                int i41 = i39 + rotateLeft3;
                int rotateLeft4 = Integers.rotateLeft(rotateLeft2 ^ i41, i10);
                int i42 = i35 + i31;
                int rotateLeft5 = Integers.rotateLeft(i23 ^ i42, i2);
                int i43 = i27 + rotateLeft5;
                int rotateLeft6 = Integers.rotateLeft(i31 ^ i43, i17);
                int i44 = i42 + rotateLeft6;
                int rotateLeft7 = Integers.rotateLeft(rotateLeft5 ^ i44, i12);
                int i45 = i43 + rotateLeft7;
                int rotateLeft8 = Integers.rotateLeft(rotateLeft6 ^ i45, i10);
                int i46 = i34 + i30;
                int rotateLeft9 = Integers.rotateLeft(i22 ^ i46, i2);
                int i47 = i26 + rotateLeft9;
                int rotateLeft10 = Integers.rotateLeft(i30 ^ i47, i17);
                int i48 = i46 + rotateLeft10;
                int rotateLeft11 = Integers.rotateLeft(rotateLeft9 ^ i48, i12);
                int i49 = i47 + rotateLeft11;
                int rotateLeft12 = Integers.rotateLeft(rotateLeft10 ^ i49, i10);
                int i50 = i33 + i29;
                int rotateLeft13 = Integers.rotateLeft(i21 ^ i50, 16);
                int i51 = i25 + rotateLeft13;
                int rotateLeft14 = Integers.rotateLeft(i29 ^ i51, i17);
                int i52 = i50 + rotateLeft14;
                int rotateLeft15 = Integers.rotateLeft(rotateLeft13 ^ i52, 8);
                int i53 = i51 + rotateLeft15;
                int rotateLeft16 = Integers.rotateLeft(rotateLeft14 ^ i53, 7);
                int i54 = i40 + rotateLeft8;
                int rotateLeft17 = Integers.rotateLeft(rotateLeft15 ^ i54, 16);
                int i55 = i49 + rotateLeft17;
                int rotateLeft18 = Integers.rotateLeft(rotateLeft8 ^ i55, 12);
                i36 = i54 + rotateLeft18;
                i21 = Integers.rotateLeft(rotateLeft17 ^ i36, 8);
                i26 = i55 + i21;
                i31 = Integers.rotateLeft(rotateLeft18 ^ i26, 7);
                int i56 = i44 + rotateLeft12;
                int rotateLeft19 = Integers.rotateLeft(rotateLeft3 ^ i56, 16);
                int i57 = i53 + rotateLeft19;
                int rotateLeft20 = Integers.rotateLeft(rotateLeft12 ^ i57, 12);
                i35 = i56 + rotateLeft20;
                i24 = Integers.rotateLeft(rotateLeft19 ^ i35, 8);
                i25 = i57 + i24;
                i30 = Integers.rotateLeft(rotateLeft20 ^ i25, 7);
                int i58 = i48 + rotateLeft16;
                int rotateLeft21 = Integers.rotateLeft(rotateLeft7 ^ i58, 16);
                int i59 = i41 + rotateLeft21;
                int rotateLeft22 = Integers.rotateLeft(rotateLeft16 ^ i59, 12);
                i34 = i58 + rotateLeft22;
                i23 = Integers.rotateLeft(rotateLeft21 ^ i34, 8);
                i28 = i59 + i23;
                i29 = Integers.rotateLeft(rotateLeft22 ^ i28, 7);
                int i60 = i52 + rotateLeft4;
                i2 = 16;
                int rotateLeft23 = Integers.rotateLeft(rotateLeft11 ^ i60, 16);
                int i61 = i45 + rotateLeft23;
                int rotateLeft24 = Integers.rotateLeft(rotateLeft4 ^ i61, 12);
                i33 = i60 + rotateLeft24;
                i22 = Integers.rotateLeft(rotateLeft23 ^ i33, 8);
                i27 = i61 + i22;
                i32 = Integers.rotateLeft(rotateLeft24 ^ i27, 7);
                i37 -= 2;
                c = 0;
                i17 = 12;
                i12 = 8;
                i10 = 7;
            }
            iArr4[c] = i36 + iArr3[c];
            iArr4[1] = i35 + iArr3[1];
            iArr4[2] = i34 + iArr3[2];
            iArr4[3] = i33 + iArr3[3];
            iArr4[4] = i32 + iArr3[4];
            iArr4[5] = i31 + iArr3[5];
            iArr4[6] = i30 + iArr3[6];
            iArr4[7] = i29 + iArr3[7];
            iArr4[8] = i28 + iArr3[8];
            iArr4[9] = i27 + iArr3[9];
            iArr4[10] = i26 + iArr3[10];
            iArr4[11] = i25 + iArr3[11];
            iArr4[12] = i24 + iArr3[12];
            iArr4[13] = i23 + iArr3[13];
            iArr4[14] = i22 + iArr3[14];
            iArr4[15] = i21 + iArr3[15];
        } else {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
    }

    /* access modifiers changed from: protected */
    public void advanceCounter() {
        int[] iArr = this.engineState;
        int i = iArr[12] + 1;
        iArr[12] = i;
        if (i == 0) {
            int[] iArr2 = this.engineState;
            iArr2[13] = iArr2[13] + 1;
        }
    }

    /* access modifiers changed from: protected */
    public void advanceCounter(long j) {
        int i = (int) (j >>> 32);
        int i2 = (int) j;
        if (i > 0) {
            int[] iArr = this.engineState;
            iArr[13] = iArr[13] + i;
        }
        int i3 = this.engineState[12];
        int[] iArr2 = this.engineState;
        iArr2[12] = iArr2[12] + i2;
        if (i3 != 0 && this.engineState[12] < i3) {
            int[] iArr3 = this.engineState;
            iArr3[13] = iArr3[13] + 1;
        }
    }

    /* access modifiers changed from: protected */
    public void generateKeyStream(byte[] bArr) {
        chachaCore(this.rounds, this.engineState, this.x);
        Pack.intToLittleEndian(this.x, bArr, 0);
    }

    public String getAlgorithmName() {
        return "ChaCha" + this.rounds;
    }

    /* access modifiers changed from: protected */
    public long getCounter() {
        return (((long) this.engineState[13]) << 32) | (((long) this.engineState[12]) & 4294967295L);
    }

    /* access modifiers changed from: protected */
    public void resetCounter() {
        int[] iArr = this.engineState;
        this.engineState[13] = 0;
        iArr[12] = 0;
    }

    /* access modifiers changed from: protected */
    public void retreatCounter() {
        if (this.engineState[12] == 0 && this.engineState[13] == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        int[] iArr = this.engineState;
        int i = iArr[12] - 1;
        iArr[12] = i;
        if (i == -1) {
            int[] iArr2 = this.engineState;
            iArr2[13] = iArr2[13] - 1;
        }
    }

    /* access modifiers changed from: protected */
    public void retreatCounter(long j) {
        int i = (int) (j >>> 32);
        int i2 = (int) j;
        if (i != 0) {
            if ((((long) this.engineState[13]) & 4294967295L) >= (((long) i) & 4294967295L)) {
                int[] iArr = this.engineState;
                iArr[13] = iArr[13] - i;
            } else {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
        }
        if ((((long) this.engineState[12]) & 4294967295L) >= (4294967295L & ((long) i2))) {
            int[] iArr2 = this.engineState;
            iArr2[12] = iArr2[12] - i2;
        } else if (this.engineState[13] != 0) {
            int[] iArr3 = this.engineState;
            iArr3[13] = iArr3[13] - 1;
            int[] iArr4 = this.engineState;
            iArr4[12] = iArr4[12] - i2;
        } else {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
    }

    /* access modifiers changed from: protected */
    public void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length == 16 || bArr.length == 32) {
                packTauOrSigma(bArr.length, this.engineState, 0);
                Pack.littleEndianToInt(bArr, 0, this.engineState, 4, 4);
                Pack.littleEndianToInt(bArr, bArr.length - 16, this.engineState, 8, 4);
            } else {
                throw new IllegalArgumentException(getAlgorithmName() + " requires 128 bit or 256 bit key");
            }
        }
        Pack.littleEndianToInt(bArr2, 0, this.engineState, 14, 2);
    }
}
