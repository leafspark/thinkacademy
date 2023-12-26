package org.bouncycastle.math.ec.rfc7748;

import java.security.SecureRandom;
import org.bouncycastle.math.ec.rfc8032.Ed448;
import org.bouncycastle.util.Arrays;

public abstract class X448 {
    private static final int C_A = 156326;
    private static final int C_A24 = 39082;
    public static final int POINT_SIZE = 56;
    public static final int SCALAR_SIZE = 56;

    private static class F extends X448Field {
        private F() {
        }
    }

    public static class Friend {
        /* access modifiers changed from: private */
        public static final Friend INSTANCE = new Friend();

        private Friend() {
        }
    }

    public static boolean calculateAgreement(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        scalarMult(bArr, i, bArr2, i2, bArr3, i3);
        return !Arrays.areAllZeroes(bArr3, i3, 56);
    }

    private static int decode32(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] << 24) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << Tnaf.POW_2_WIDTH);
    }

    private static void decodeScalar(byte[] bArr, int i, int[] iArr) {
        for (int i2 = 0; i2 < 14; i2++) {
            iArr[i2] = decode32(bArr, (i2 * 4) + i);
        }
        iArr[0] = iArr[0] & -4;
        iArr[13] = iArr[13] | Integer.MIN_VALUE;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
        bArr[0] = (byte) (bArr[0] & 252);
        bArr[55] = (byte) (bArr[55] | 128);
    }

    public static void generatePublicKey(byte[] bArr, int i, byte[] bArr2, int i2) {
        scalarMultBase(bArr, i, bArr2, i2);
    }

    private static void pointDouble(int[] iArr, int[] iArr2) {
        int[] create = F.create();
        int[] create2 = F.create();
        F.add(iArr, iArr2, create);
        F.sub(iArr, iArr2, create2);
        F.sqr(create, create);
        F.sqr(create2, create2);
        F.mul(create, create2, iArr);
        F.sub(create, create2, create);
        F.mul(create, (int) C_A24, iArr2);
        F.add(iArr2, create2, iArr2);
        F.mul(iArr2, create, iArr2);
    }

    public static void precompute() {
        Ed448.precompute();
    }

    public static void scalarMult(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        int[] iArr = new int[14];
        decodeScalar(bArr, i, iArr);
        int[] create = F.create();
        F.decode(bArr2, i2, create);
        int[] create2 = F.create();
        F.copy(create, 0, create2, 0);
        int[] create3 = F.create();
        create3[0] = 1;
        int[] create4 = F.create();
        create4[0] = 1;
        int[] create5 = F.create();
        int[] create6 = F.create();
        int[] create7 = F.create();
        int i4 = 447;
        int i5 = 1;
        while (true) {
            F.add(create4, create5, create6);
            F.sub(create4, create5, create4);
            F.add(create2, create3, create5);
            F.sub(create2, create3, create2);
            F.mul(create6, create2, create6);
            F.mul(create4, create5, create4);
            F.sqr(create5, create5);
            F.sqr(create2, create2);
            F.sub(create5, create2, create7);
            F.mul(create7, (int) C_A24, create3);
            F.add(create3, create2, create3);
            F.mul(create3, create7, create3);
            F.mul(create2, create5, create2);
            F.sub(create6, create4, create5);
            F.add(create6, create4, create4);
            F.sqr(create4, create4);
            F.sqr(create5, create5);
            F.mul(create5, create, create5);
            i4--;
            int i6 = (iArr[i4 >>> 5] >>> (i4 & 31)) & 1;
            int i7 = i5 ^ i6;
            F.cswap(i7, create2, create4);
            F.cswap(i7, create3, create5);
            if (i4 < 2) {
                break;
            }
            i5 = i6;
        }
        for (int i8 = 0; i8 < 2; i8++) {
            pointDouble(create2, create3);
        }
        F.inv(create3, create3);
        F.mul(create2, create3, create2);
        F.normalize(create2);
        F.encode(create2, bArr3, i3);
    }

    public static void scalarMultBase(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] create = F.create();
        int[] create2 = F.create();
        Ed448.scalarMultBaseXY(Friend.INSTANCE, bArr, i, create, create2);
        F.inv(create, create);
        F.mul(create, create2, create);
        F.sqr(create, create);
        F.normalize(create);
        F.encode(create, bArr2, i2);
    }
}
