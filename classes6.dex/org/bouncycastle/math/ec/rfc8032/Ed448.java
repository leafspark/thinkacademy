package org.bouncycastle.math.ec.rfc8032;

import java.security.SecureRandom;
import java.util.Objects;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.apache.httpcore.HttpStatus;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.math.ec.rfc7748.X448;
import org.bouncycastle.math.ec.rfc7748.X448Field;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;
import tv.danmaku.ijk.media.psplayer.IjkMediaMeta;

public abstract class Ed448 {
    private static final int[] B_x = {118276190, 40534716, 9670182, 135141552, 85017403, 259173222, 68333082, 171784774, 174973732, 15824510, 73756743, 57518561, 94773951, 248652241, 107736333, 82941708};
    private static final int[] B_y = {36764180, 8885695, 130592152, 20104429, 163904957, 30304195, 121295871, 5901357, 125344798, 171541512, 175338348, 209069246, 3626697, 38307682, 24032956, 110359655};
    private static final int COORD_INTS = 14;
    private static final int C_d = -39081;
    private static final byte[] DOM4_PREFIX = {83, 105, 103, 69, 100, 52, 52, 56};
    private static final int[] L = {-1420278541, 595116690, -1916432555, 560775794, -1361693040, -1001465015, 2093622249, -1, -1, -1, -1, -1, -1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK};
    private static final int L4_0 = 43969588;
    private static final int L4_1 = 30366549;
    private static final int L4_2 = 163752818;
    private static final int L4_3 = 258169998;
    private static final int L4_4 = 96434764;
    private static final int L4_5 = 227822194;
    private static final int L4_6 = 149865618;
    private static final int L4_7 = 550336261;
    private static final int L_0 = 78101261;
    private static final int L_1 = 141809365;
    private static final int L_2 = 175155932;
    private static final int L_3 = 64542499;
    private static final int L_4 = 158326419;
    private static final int L_5 = 191173276;
    private static final int L_6 = 104575268;
    private static final int L_7 = 137584065;
    private static final long M26L = 67108863;
    private static final long M28L = 268435455;
    private static final long M32L = 4294967295L;
    private static final int[] P = {-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};
    private static final int POINT_BYTES = 57;
    private static final int PRECOMP_BLOCKS = 5;
    private static final int PRECOMP_MASK = 15;
    private static final int PRECOMP_POINTS = 16;
    private static final int PRECOMP_SPACING = 18;
    private static final int PRECOMP_TEETH = 5;
    public static final int PREHASH_SIZE = 64;
    public static final int PUBLIC_KEY_SIZE = 57;
    private static final int SCALAR_BYTES = 57;
    private static final int SCALAR_INTS = 14;
    public static final int SECRET_KEY_SIZE = 57;
    public static final int SIGNATURE_SIZE = 114;
    private static final int WNAF_WIDTH_BASE = 7;
    private static int[] precompBase = null;
    private static PointExt[] precompBaseTable = null;
    private static final Object precompLock = new Object();

    public static final class Algorithm {
        public static final int Ed448 = 0;
        public static final int Ed448ph = 1;
    }

    private static class F extends X448Field {
        private F() {
        }
    }

    private static class PointExt {
        int[] x;
        int[] y;
        int[] z;

        private PointExt() {
            this.x = F.create();
            this.y = F.create();
            this.z = F.create();
        }
    }

    private static class PointPrecomp {
        int[] x;
        int[] y;

        private PointPrecomp() {
            this.x = F.create();
            this.y = F.create();
        }
    }

    private static byte[] calculateS(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[28];
        decodeScalar(bArr, 0, iArr);
        int[] iArr2 = new int[14];
        decodeScalar(bArr2, 0, iArr2);
        int[] iArr3 = new int[14];
        decodeScalar(bArr3, 0, iArr3);
        Nat.mulAddTo(14, iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[114];
        for (int i = 0; i < 28; i++) {
            encode32(iArr[i], bArr4, i * 4);
        }
        return reduceScalar(bArr4);
    }

    private static boolean checkContextVar(byte[] bArr) {
        return bArr != null && bArr.length < 256;
    }

    private static int checkPoint(int[] iArr, int[] iArr2) {
        int[] create = F.create();
        int[] create2 = F.create();
        int[] create3 = F.create();
        F.sqr(iArr, create2);
        F.sqr(iArr2, create3);
        F.mul(create2, create3, create);
        F.add(create2, create3, create2);
        F.mul(create, 39081, create);
        F.subOne(create);
        F.add(create, create2, create);
        F.normalize(create);
        return F.isZero(create);
    }

    private static int checkPoint(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = F.create();
        int[] create2 = F.create();
        int[] create3 = F.create();
        int[] create4 = F.create();
        F.sqr(iArr, create2);
        F.sqr(iArr2, create3);
        F.sqr(iArr3, create4);
        F.mul(create2, create3, create);
        F.add(create2, create3, create2);
        F.mul(create2, create4, create2);
        F.sqr(create4, create4);
        F.mul(create, 39081, create);
        F.sub(create, create4, create);
        F.add(create, create2, create);
        F.normalize(create);
        return F.isZero(create);
    }

    private static boolean checkPointVar(byte[] bArr) {
        if ((bArr[56] & Byte.MAX_VALUE) != 0) {
            return false;
        }
        int[] iArr = new int[14];
        decode32(bArr, 0, iArr, 0, 14);
        return !Nat.gte(14, iArr, P);
    }

    private static boolean checkScalarVar(byte[] bArr, int[] iArr) {
        if (bArr[56] != 0) {
            return false;
        }
        decodeScalar(bArr, 0, iArr);
        return !Nat.gte(14, iArr, L);
    }

    private static byte[] copy(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static Xof createPrehash() {
        return createXof();
    }

    private static Xof createXof() {
        return new SHAKEDigest(256);
    }

    private static int decode16(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    private static int decode24(byte[] bArr, int i) {
        int i2 = i + 1;
        return ((bArr[i2 + 1] & 255) << Tnaf.POW_2_WIDTH) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
    }

    private static int decode32(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] << 24) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << Tnaf.POW_2_WIDTH);
    }

    private static void decode32(byte[] bArr, int i, int[] iArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i2 + i4] = decode32(bArr, (i4 * 4) + i);
        }
    }

    private static boolean decodePointVar(byte[] bArr, int i, boolean z, PointExt pointExt) {
        byte[] copy = copy(bArr, i, 57);
        boolean z2 = false;
        if (!checkPointVar(copy)) {
            return false;
        }
        int i2 = (copy[56] & 128) >>> 7;
        copy[56] = (byte) (copy[56] & Byte.MAX_VALUE);
        F.decode(copy, 0, pointExt.y);
        int[] create = F.create();
        int[] create2 = F.create();
        F.sqr(pointExt.y, create);
        F.mul(create, 39081, create2);
        F.negate(create, create);
        F.addOne(create);
        F.addOne(create2);
        if (!F.sqrtRatioVar(create, create2, pointExt.x)) {
            return false;
        }
        F.normalize(pointExt.x);
        if (i2 == 1 && F.isZeroVar(pointExt.x)) {
            return false;
        }
        if (i2 != (pointExt.x[0] & 1)) {
            z2 = true;
        }
        if (z ^ z2) {
            F.negate(pointExt.x, pointExt.x);
        }
        pointExtendXY(pointExt);
        return true;
    }

    private static void decodeScalar(byte[] bArr, int i, int[] iArr) {
        decode32(bArr, i, iArr, 0, 14);
    }

    private static void dom4(Xof xof, byte b, byte[] bArr) {
        byte[] bArr2 = DOM4_PREFIX;
        int length = bArr2.length;
        int i = length + 2;
        int length2 = bArr.length + i;
        byte[] bArr3 = new byte[length2];
        System.arraycopy(bArr2, 0, bArr3, 0, length);
        bArr3[length] = b;
        bArr3[length + 1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr3, i, bArr.length);
        xof.update(bArr3, 0, length2);
    }

    private static void encode24(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 8);
        bArr[i3 + 1] = (byte) (i >>> 16);
    }

    private static void encode32(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 8);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 16);
        bArr[i4 + 1] = (byte) (i >>> 24);
    }

    private static void encode56(long j, byte[] bArr, int i) {
        encode32((int) j, bArr, i);
        encode24((int) (j >>> 32), bArr, i + 4);
    }

    private static int encodePoint(PointExt pointExt, byte[] bArr, int i) {
        int[] create = F.create();
        int[] create2 = F.create();
        F.inv(pointExt.z, create2);
        F.mul(pointExt.x, create2, create);
        F.mul(pointExt.y, create2, create2);
        F.normalize(create);
        F.normalize(create2);
        int checkPoint = checkPoint(create, create2);
        F.encode(create2, bArr, i);
        bArr[(i + 57) - 1] = (byte) ((create[0] & 1) << 7);
        return checkPoint;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
    }

    public static void generatePublicKey(byte[] bArr, int i, byte[] bArr2, int i2) {
        Xof createXof = createXof();
        byte[] bArr3 = new byte[114];
        createXof.update(bArr, i, 57);
        createXof.doFinal(bArr3, 0, 114);
        byte[] bArr4 = new byte[57];
        pruneScalar(bArr3, 0, bArr4);
        scalarMultBaseEncoded(bArr4, bArr2, i2);
    }

    private static int getWindow4(int[] iArr, int i) {
        return (iArr[i >>> 3] >>> ((i & 7) << 2)) & 15;
    }

    private static byte[] getWnafVar(int[] iArr, int i) {
        int i2;
        int[] iArr2 = new int[28];
        int i3 = 0;
        int i4 = 14;
        int i5 = 28;
        int i6 = 0;
        while (true) {
            i4--;
            if (i4 < 0) {
                break;
            }
            int i7 = iArr[i4];
            int i8 = i5 - 1;
            iArr2[i8] = (i6 << 16) | (i7 >>> 16);
            i5 = i8 - 1;
            iArr2[i5] = i7;
            i6 = i7;
        }
        byte[] bArr = new byte[447];
        int i9 = 32 - i;
        int i10 = 0;
        int i11 = 0;
        while (i3 < 28) {
            int i12 = iArr2[i3];
            while (i2 < 16) {
                int i13 = i12 >>> i2;
                if ((i13 & 1) == i11) {
                    i2++;
                } else {
                    int i14 = (i13 | 1) << i9;
                    bArr[(i3 << 4) + i2] = (byte) (i14 >> i9);
                    i2 += i;
                    i11 = i14 >>> 31;
                }
            }
            i3++;
            i10 = i2 - 16;
        }
        return bArr;
    }

    private static void implSign(Xof xof, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte b, byte[] bArr5, int i2, int i3, byte[] bArr6, int i4) {
        dom4(xof, b, bArr4);
        xof.update(bArr, 57, 57);
        xof.update(bArr5, i2, i3);
        xof.doFinal(bArr, 0, bArr.length);
        byte[] reduceScalar = reduceScalar(bArr);
        byte[] bArr7 = new byte[57];
        scalarMultBaseEncoded(reduceScalar, bArr7, 0);
        dom4(xof, b, bArr4);
        xof.update(bArr7, 0, 57);
        xof.update(bArr3, i, 57);
        xof.update(bArr5, i2, i3);
        xof.doFinal(bArr, 0, bArr.length);
        byte[] calculateS = calculateS(reduceScalar, reduceScalar(bArr), bArr2);
        System.arraycopy(bArr7, 0, bArr6, i4, 57);
        System.arraycopy(calculateS, 0, bArr6, i4 + 57, 57);
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, byte b, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        if (checkContextVar(bArr2)) {
            Xof createXof = createXof();
            byte[] bArr5 = new byte[114];
            byte[] bArr6 = bArr;
            int i5 = i;
            createXof.update(bArr, i, 57);
            createXof.doFinal(bArr5, 0, 114);
            byte[] bArr7 = new byte[57];
            pruneScalar(bArr5, 0, bArr7);
            byte[] bArr8 = new byte[57];
            scalarMultBaseEncoded(bArr7, bArr8, 0);
            implSign(createXof, bArr5, bArr7, bArr8, 0, bArr2, b, bArr3, i2, i3, bArr4, i4);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        if (checkContextVar(bArr3)) {
            Xof createXof = createXof();
            byte[] bArr6 = new byte[114];
            byte[] bArr7 = bArr;
            int i6 = i;
            createXof.update(bArr, i, 57);
            createXof.doFinal(bArr6, 0, 114);
            byte[] bArr8 = new byte[57];
            pruneScalar(bArr6, 0, bArr8);
            implSign(createXof, bArr6, bArr8, bArr2, i2, bArr3, b, bArr4, i3, i4, bArr5, i5);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }

    private static boolean implVerify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4) {
        byte[] bArr5 = bArr;
        int i5 = i;
        byte[] bArr6 = bArr2;
        int i6 = i2;
        if (checkContextVar(bArr3)) {
            byte[] copy = copy(bArr, i5, 57);
            byte[] copy2 = copy(bArr, i5 + 57, 57);
            if (!checkPointVar(copy)) {
                return false;
            }
            int[] iArr = new int[14];
            if (!checkScalarVar(copy2, iArr)) {
                return false;
            }
            PointExt pointExt = new PointExt();
            if (!decodePointVar(bArr6, i6, true, pointExt)) {
                return false;
            }
            Xof createXof = createXof();
            byte[] bArr7 = new byte[114];
            dom4(createXof, b, bArr3);
            createXof.update(copy, 0, 57);
            createXof.update(bArr6, i6, 57);
            createXof.update(bArr4, i3, i4);
            createXof.doFinal(bArr7, 0, 114);
            int[] iArr2 = new int[14];
            decodeScalar(reduceScalar(bArr7), 0, iArr2);
            PointExt pointExt2 = new PointExt();
            scalarMultStrausVar(iArr, iArr2, pointExt, pointExt2);
            byte[] bArr8 = new byte[57];
            return encodePoint(pointExt2, bArr8, 0) != 0 && Arrays.areEqual(bArr8, copy);
        }
        throw new IllegalArgumentException("ctx");
    }

    private static boolean isNeutralElementVar(int[] iArr, int[] iArr2, int[] iArr3) {
        return F.isZeroVar(iArr) && F.areEqualVar(iArr2, iArr3);
    }

    private static void pointAdd(PointExt pointExt, PointExt pointExt2) {
        int[] create = F.create();
        int[] create2 = F.create();
        int[] create3 = F.create();
        int[] create4 = F.create();
        int[] create5 = F.create();
        int[] create6 = F.create();
        int[] create7 = F.create();
        int[] create8 = F.create();
        F.mul(pointExt.z, pointExt2.z, create);
        F.sqr(create, create2);
        F.mul(pointExt.x, pointExt2.x, create3);
        F.mul(pointExt.y, pointExt2.y, create4);
        F.mul(create3, create4, create5);
        F.mul(create5, 39081, create5);
        F.add(create2, create5, create6);
        F.sub(create2, create5, create7);
        F.add(pointExt.x, pointExt.y, create2);
        F.add(pointExt2.x, pointExt2.y, create5);
        F.mul(create2, create5, create8);
        F.add(create4, create3, create2);
        F.sub(create4, create3, create5);
        F.carry(create2);
        F.sub(create8, create2, create8);
        F.mul(create8, create, create8);
        F.mul(create5, create, create5);
        F.mul(create6, create8, pointExt2.x);
        F.mul(create5, create7, pointExt2.y);
        F.mul(create6, create7, pointExt2.z);
    }

    private static void pointAddPrecomp(PointPrecomp pointPrecomp, PointExt pointExt) {
        int[] create = F.create();
        int[] create2 = F.create();
        int[] create3 = F.create();
        int[] create4 = F.create();
        int[] create5 = F.create();
        int[] create6 = F.create();
        int[] create7 = F.create();
        F.sqr(pointExt.z, create);
        F.mul(pointPrecomp.x, pointExt.x, create2);
        F.mul(pointPrecomp.y, pointExt.y, create3);
        F.mul(create2, create3, create4);
        F.mul(create4, 39081, create4);
        F.add(create, create4, create5);
        F.sub(create, create4, create6);
        F.add(pointPrecomp.x, pointPrecomp.y, create);
        F.add(pointExt.x, pointExt.y, create4);
        F.mul(create, create4, create7);
        F.add(create3, create2, create);
        F.sub(create3, create2, create4);
        F.carry(create);
        F.sub(create7, create, create7);
        F.mul(create7, pointExt.z, create7);
        F.mul(create4, pointExt.z, create4);
        F.mul(create5, create7, pointExt.x);
        F.mul(create4, create6, pointExt.y);
        F.mul(create5, create6, pointExt.z);
    }

    private static void pointAddVar(boolean z, PointExt pointExt, PointExt pointExt2) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] create = F.create();
        int[] create2 = F.create();
        int[] create3 = F.create();
        int[] create4 = F.create();
        int[] create5 = F.create();
        int[] create6 = F.create();
        int[] create7 = F.create();
        int[] create8 = F.create();
        if (z) {
            F.sub(pointExt.y, pointExt.x, create8);
            iArr2 = create2;
            iArr3 = create5;
            iArr4 = create6;
            iArr = create7;
        } else {
            F.add(pointExt.y, pointExt.x, create8);
            iArr3 = create2;
            iArr2 = create5;
            iArr = create6;
            iArr4 = create7;
        }
        F.mul(pointExt.z, pointExt2.z, create);
        F.sqr(create, create2);
        F.mul(pointExt.x, pointExt2.x, create3);
        F.mul(pointExt.y, pointExt2.y, create4);
        F.mul(create3, create4, create5);
        F.mul(create5, 39081, create5);
        F.add(create2, create5, iArr);
        F.sub(create2, create5, iArr4);
        F.add(pointExt2.x, pointExt2.y, create5);
        F.mul(create8, create5, create8);
        F.add(create4, create3, iArr3);
        F.sub(create4, create3, iArr2);
        F.carry(iArr3);
        F.sub(create8, create2, create8);
        F.mul(create8, create, create8);
        F.mul(create5, create, create5);
        F.mul(create6, create8, pointExt2.x);
        F.mul(create5, create7, pointExt2.y);
        F.mul(create6, create7, pointExt2.z);
    }

    private static PointExt pointCopy(PointExt pointExt) {
        PointExt pointExt2 = new PointExt();
        pointCopy(pointExt, pointExt2);
        return pointExt2;
    }

    private static void pointCopy(PointExt pointExt, PointExt pointExt2) {
        F.copy(pointExt.x, 0, pointExt2.x, 0);
        F.copy(pointExt.y, 0, pointExt2.y, 0);
        F.copy(pointExt.z, 0, pointExt2.z, 0);
    }

    private static void pointDouble(PointExt pointExt) {
        int[] create = F.create();
        int[] create2 = F.create();
        int[] create3 = F.create();
        int[] create4 = F.create();
        int[] create5 = F.create();
        int[] create6 = F.create();
        F.add(pointExt.x, pointExt.y, create);
        F.sqr(create, create);
        F.sqr(pointExt.x, create2);
        F.sqr(pointExt.y, create3);
        F.add(create2, create3, create4);
        F.carry(create4);
        F.sqr(pointExt.z, create5);
        F.add(create5, create5, create5);
        F.carry(create5);
        F.sub(create4, create5, create6);
        F.sub(create, create4, create);
        F.sub(create2, create3, create2);
        F.mul(create, create6, pointExt.x);
        F.mul(create4, create2, pointExt.y);
        F.mul(create4, create6, pointExt.z);
    }

    private static void pointExtendXY(PointExt pointExt) {
        F.one(pointExt.z);
    }

    private static void pointLookup(int i, int i2, PointPrecomp pointPrecomp) {
        int i3 = i * 16 * 2 * 16;
        for (int i4 = 0; i4 < 16; i4++) {
            int i5 = ((i4 ^ i2) - 1) >> 31;
            F.cmov(i5, precompBase, i3, pointPrecomp.x, 0);
            int i6 = i3 + 16;
            F.cmov(i5, precompBase, i6, pointPrecomp.y, 0);
            i3 = i6 + 16;
        }
    }

    private static void pointLookup(int[] iArr, int i, int[] iArr2, PointExt pointExt) {
        int window4 = getWindow4(iArr, i);
        int i2 = (window4 >>> 3) ^ 1;
        int i3 = (window4 ^ (-i2)) & 7;
        int i4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            int i6 = ((i5 ^ i3) - 1) >> 31;
            F.cmov(i6, iArr2, i4, pointExt.x, 0);
            int i7 = i4 + 16;
            F.cmov(i6, iArr2, i7, pointExt.y, 0);
            int i8 = i7 + 16;
            F.cmov(i6, iArr2, i8, pointExt.z, 0);
            i4 = i8 + 16;
        }
        F.cnegate(i2, pointExt.x);
    }

    private static int[] pointPrecompute(PointExt pointExt, int i) {
        PointExt pointCopy = pointCopy(pointExt);
        PointExt pointCopy2 = pointCopy(pointCopy);
        pointDouble(pointCopy2);
        int[] createTable = F.createTable(i * 3);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            F.copy(pointCopy.x, 0, createTable, i2);
            int i4 = i2 + 16;
            F.copy(pointCopy.y, 0, createTable, i4);
            int i5 = i4 + 16;
            F.copy(pointCopy.z, 0, createTable, i5);
            i2 = i5 + 16;
            i3++;
            if (i3 == i) {
                return createTable;
            }
            pointAdd(pointCopy2, pointCopy);
        }
    }

    private static PointExt[] pointPrecomputeVar(PointExt pointExt, int i) {
        PointExt pointCopy = pointCopy(pointExt);
        pointDouble(pointCopy);
        PointExt[] pointExtArr = new PointExt[i];
        pointExtArr[0] = pointCopy(pointExt);
        for (int i2 = 1; i2 < i; i2++) {
            pointExtArr[i2] = pointCopy(pointExtArr[i2 - 1]);
            pointAddVar(false, pointCopy, pointExtArr[i2]);
        }
        return pointExtArr;
    }

    private static void pointSetNeutral(PointExt pointExt) {
        F.zero(pointExt.x);
        F.one(pointExt.y);
        F.one(pointExt.z);
    }

    public static void precompute() {
        synchronized (precompLock) {
            if (precompBase == null) {
                PointExt pointExt = new PointExt();
                F.copy(B_x, 0, pointExt.x, 0);
                F.copy(B_y, 0, pointExt.y, 0);
                pointExtendXY(pointExt);
                precompBaseTable = pointPrecomputeVar(pointExt, 32);
                precompBase = F.createTable(160);
                int i = 0;
                for (int i2 = 0; i2 < 5; i2++) {
                    PointExt[] pointExtArr = new PointExt[5];
                    PointExt pointExt2 = new PointExt();
                    pointSetNeutral(pointExt2);
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 5) {
                            break;
                        }
                        pointAddVar(true, pointExt, pointExt2);
                        pointDouble(pointExt);
                        pointExtArr[i3] = pointCopy(pointExt);
                        if (i2 + i3 != 8) {
                            for (int i4 = 1; i4 < 18; i4++) {
                                pointDouble(pointExt);
                            }
                        }
                        i3++;
                    }
                    PointExt[] pointExtArr2 = new PointExt[16];
                    pointExtArr2[0] = pointExt2;
                    int i5 = 1;
                    for (int i6 = 0; i6 < 4; i6++) {
                        int i7 = 1 << i6;
                        int i8 = 0;
                        while (i8 < i7) {
                            pointExtArr2[i5] = pointCopy(pointExtArr2[i5 - i7]);
                            pointAddVar(false, pointExtArr[i6], pointExtArr2[i5]);
                            i8++;
                            i5++;
                        }
                    }
                    int[] createTable = F.createTable(16);
                    int[] create = F.create();
                    F.copy(pointExtArr2[0].z, 0, create, 0);
                    F.copy(create, 0, createTable, 0);
                    int i9 = 0;
                    while (true) {
                        i9++;
                        if (i9 >= 16) {
                            break;
                        }
                        F.mul(create, pointExtArr2[i9].z, create);
                        F.copy(create, 0, createTable, i9 * 16);
                    }
                    F.invVar(create, create);
                    int i10 = i9 - 1;
                    int[] create2 = F.create();
                    while (i10 > 0) {
                        int i11 = i10 - 1;
                        F.copy(createTable, i11 * 16, create2, 0);
                        F.mul(create2, create, create2);
                        F.copy(create2, 0, createTable, i10 * 16);
                        F.mul(create, pointExtArr2[i10].z, create);
                        i10 = i11;
                    }
                    F.copy(create, 0, createTable, 0);
                    for (int i12 = 0; i12 < 16; i12++) {
                        PointExt pointExt3 = pointExtArr2[i12];
                        F.copy(createTable, i12 * 16, pointExt3.z, 0);
                        F.mul(pointExt3.x, pointExt3.z, pointExt3.x);
                        F.mul(pointExt3.y, pointExt3.z, pointExt3.y);
                        F.copy(pointExt3.x, 0, precompBase, i);
                        int i13 = i + 16;
                        F.copy(pointExt3.y, 0, precompBase, i13);
                        i = i13 + 16;
                    }
                }
            }
        }
    }

    private static void pruneScalar(byte[] bArr, int i, byte[] bArr2) {
        System.arraycopy(bArr, i, bArr2, 0, 56);
        bArr2[0] = (byte) (bArr2[0] & 252);
        bArr2[55] = (byte) (bArr2[55] | 128);
        bArr2[56] = 0;
    }

    private static byte[] reduceScalar(byte[] bArr) {
        byte[] bArr2 = bArr;
        long decode32 = ((long) decode32(bArr2, 0)) & M32L;
        long decode24 = ((long) (decode24(bArr2, 4) << 4)) & M32L;
        long decode322 = ((long) decode32(bArr2, 7)) & M32L;
        long decode242 = ((long) (decode24(bArr2, 11) << 4)) & M32L;
        long decode323 = ((long) decode32(bArr2, 14)) & M32L;
        long decode243 = ((long) (decode24(bArr2, 18) << 4)) & M32L;
        long j = decode24;
        long decode324 = ((long) decode32(bArr2, 21)) & M32L;
        long j2 = decode322;
        long decode244 = ((long) (decode24(bArr2, 25) << 4)) & M32L;
        long decode325 = ((long) decode32(bArr2, 28)) & M32L;
        long j3 = decode242;
        long decode245 = ((long) (decode24(bArr2, 32) << 4)) & M32L;
        long j4 = decode323;
        long decode326 = ((long) decode32(bArr2, 35)) & M32L;
        long j5 = decode243;
        long decode246 = ((long) (decode24(bArr2, 39) << 4)) & M32L;
        long j6 = decode324;
        long decode327 = ((long) decode32(bArr2, 42)) & M32L;
        long j7 = decode244;
        long decode247 = ((long) (decode24(bArr2, 46) << 4)) & M32L;
        long j8 = decode325;
        long decode328 = ((long) decode32(bArr2, 49)) & M32L;
        long j9 = decode245;
        long decode248 = ((long) (decode24(bArr2, 53) << 4)) & M32L;
        long j10 = decode326;
        long decode329 = ((long) decode32(bArr2, 56)) & M32L;
        long j11 = decode246;
        long decode249 = ((long) (decode24(bArr2, 60) << 4)) & M32L;
        long j12 = decode327;
        long decode3210 = ((long) decode32(bArr2, 63)) & M32L;
        long j13 = decode247;
        long decode2410 = ((long) (decode24(bArr2, 67) << 4)) & M32L;
        long j14 = decode328;
        long decode3211 = ((long) decode32(bArr2, 70)) & M32L;
        long j15 = decode248;
        long decode2411 = ((long) (decode24(bArr2, 74) << 4)) & M32L;
        long decode3212 = ((long) decode32(bArr2, 77)) & M32L;
        long decode2412 = ((long) (decode24(bArr2, 81) << 4)) & M32L;
        long decode3213 = ((long) decode32(bArr2, 84)) & M32L;
        long decode2413 = ((long) (decode24(bArr2, 88) << 4)) & M32L;
        long decode3214 = ((long) decode32(bArr2, 91)) & M32L;
        long decode2414 = ((long) (decode24(bArr2, 95) << 4)) & M32L;
        long decode3215 = ((long) decode32(bArr2, 98)) & M32L;
        long decode2415 = ((long) (decode24(bArr2, HttpStatus.SC_PROCESSING) << 4)) & M32L;
        long decode3216 = ((long) decode32(bArr2, 105)) & M32L;
        long decode16 = ((long) decode16(bArr2, 112)) & M32L;
        long j16 = decode2412 + (decode16 * 550336261);
        long decode2416 = (((long) (decode24(bArr2, 109) << 4)) & M32L) + (decode3216 >>> 28);
        long j17 = decode3216 & M28L;
        long j18 = decode3212 + (decode16 * 149865618) + (decode2416 * 550336261);
        long j19 = decode2415 + (decode3215 >>> 28);
        long j20 = decode3215 & M28L;
        long j21 = decode3211 + (decode16 * 96434764) + (decode2416 * 227822194) + (j17 * 149865618) + (j19 * 550336261);
        long j22 = decode2414 + (decode3214 >>> 28);
        long j23 = decode3214 & M28L;
        long j24 = decode3210 + (decode16 * 163752818) + (decode2416 * 258169998) + (j17 * 96434764) + (j19 * 227822194) + (j20 * 149865618) + (j22 * 550336261);
        long j25 = decode249 + (decode16 * 30366549) + (decode2416 * 163752818) + (j17 * 258169998) + (j19 * 96434764) + (j20 * 227822194) + (j22 * 149865618) + (j23 * 550336261);
        long j26 = decode2413 + (decode3213 >>> 28);
        long j27 = decode3213 & M28L;
        long j28 = decode2411 + (decode16 * 227822194) + (decode2416 * 149865618) + (j17 * 550336261) + (j21 >>> 28);
        long j29 = j21 & M28L;
        long j30 = j18 + (j28 >>> 28);
        long j31 = j28 & M28L;
        long j32 = j16 + (j30 >>> 28);
        long j33 = j30 & M28L;
        long j34 = j27 + (j32 >>> 28);
        long j35 = j32 & M28L;
        long j36 = j7 + (j35 * 43969588);
        long j37 = j8 + (j34 * 43969588) + (j35 * 30366549);
        long j38 = j9 + (j26 * 43969588) + (j34 * 30366549) + (j35 * 163752818);
        long j39 = j10 + (j23 * 43969588) + (j26 * 30366549) + (j34 * 163752818) + (j35 * 258169998);
        long j40 = j11 + (j22 * 43969588) + (j23 * 30366549) + (j26 * 163752818) + (j34 * 258169998) + (j35 * 96434764);
        long j41 = j12 + (j20 * 43969588) + (j22 * 30366549) + (j23 * 163752818) + (j26 * 258169998) + (j34 * 96434764) + (j35 * 227822194);
        long j42 = j14 + (j17 * 43969588) + (j19 * 30366549) + (j20 * 163752818) + (j22 * 258169998) + (j23 * 96434764) + (j26 * 227822194) + (j34 * 149865618) + (j35 * 550336261);
        long j43 = j24 + (j25 >>> 28);
        long j44 = j25 & M28L;
        long j45 = decode2410 + (decode16 * 258169998) + (decode2416 * 96434764) + (j17 * 227822194) + (j19 * 149865618) + (j20 * 550336261) + (j43 >>> 28);
        long j46 = j43 & M28L;
        long j47 = j29 + (j45 >>> 28);
        long j48 = j45 & M28L;
        long j49 = j31 + (j47 >>> 28);
        long j50 = j47 & M28L;
        long j51 = j4 + (j50 * 43969588);
        long j52 = j5 + (j49 * 43969588) + (j50 * 30366549);
        long j53 = j6 + (j33 * 43969588) + (j49 * 30366549) + (j50 * 163752818);
        long j54 = j36 + (j33 * 30366549) + (j49 * 163752818) + (j50 * 258169998);
        long j55 = j37 + (j33 * 163752818) + (j49 * 258169998) + (j50 * 96434764);
        long j56 = j38 + (j33 * 258169998) + (j49 * 96434764) + (j50 * 227822194);
        long j57 = j40 + (j33 * 227822194) + (j49 * 149865618) + (j50 * 550336261);
        long j58 = j3 + (j48 * 43969588);
        long j59 = j51 + (j48 * 30366549);
        long j60 = j52 + (j48 * 163752818);
        long j61 = j53 + (j48 * 258169998);
        long j62 = j54 + (j48 * 96434764);
        long j63 = j55 + (j48 * 227822194);
        long j64 = j56 + (j48 * 149865618);
        long j65 = j39 + (j33 * 96434764) + (j49 * 227822194) + (j50 * 149865618) + (j48 * 550336261);
        long j66 = j15 + (decode2416 * 43969588) + (j17 * 30366549) + (j19 * 163752818) + (j20 * 258169998) + (j22 * 96434764) + (j23 * 227822194) + (j26 * 149865618) + (j34 * 550336261) + (j42 >>> 28);
        long j67 = j42 & M28L;
        long j68 = decode329 + (decode16 * 43969588) + (decode2416 * 30366549) + (j17 * 163752818) + (j19 * 258169998) + (j20 * 96434764) + (j22 * 227822194) + (j23 * 149865618) + (j26 * 550336261) + (j66 >>> 28);
        long j69 = j66 & M28L;
        long j70 = j44 + (j68 >>> 28);
        long j71 = j68 & M28L;
        long j72 = j46 + (j70 >>> 28);
        long j73 = j70 & M28L;
        long j74 = j2 + (j72 * 43969588);
        long j75 = j58 + (j72 * 30366549);
        long j76 = j59 + (j72 * 163752818);
        long j77 = j60 + (j72 * 258169998);
        long j78 = j61 + (j72 * 96434764);
        long j79 = j62 + (j72 * 227822194);
        long j80 = j64 + (j72 * 550336261);
        long j81 = j69 & M26L;
        long j82 = (j71 * 4) + (j69 >>> 26) + 1;
        long j83 = decode32 + (78101261 * j82);
        long j84 = j74 + (30366549 * j73) + (175155932 * j82);
        long j85 = j75 + (163752818 * j73) + (64542499 * j82);
        long j86 = j76 + (258169998 * j73) + (158326419 * j82);
        long j87 = j77 + (96434764 * j73) + (191173276 * j82);
        long j88 = j79 + (149865618 * j73) + (j82 * 137584065);
        long j89 = j + (43969588 * j73) + (141809365 * j82) + (j83 >>> 28);
        long j90 = j83 & M28L;
        long j91 = j84 + (j89 >>> 28);
        long j92 = j89 & M28L;
        long j93 = j85 + (j91 >>> 28);
        long j94 = j91 & M28L;
        long j95 = j86 + (j93 >>> 28);
        long j96 = j93 & M28L;
        long j97 = j87 + (j95 >>> 28);
        long j98 = j95 & M28L;
        long j99 = j78 + (227822194 * j73) + (104575268 * j82) + (j97 >>> 28);
        long j100 = j97 & M28L;
        long j101 = j88 + (j99 >>> 28);
        long j102 = j99 & M28L;
        long j103 = j63 + (j72 * 149865618) + (j73 * 550336261) + (j101 >>> 28);
        long j104 = j101 & M28L;
        long j105 = j80 + (j103 >>> 28);
        long j106 = j103 & M28L;
        long j107 = j65 + (j105 >>> 28);
        long j108 = j105 & M28L;
        long j109 = j57 + (j107 >>> 28);
        long j110 = j107 & M28L;
        long j111 = j41 + (j33 * 149865618) + (j49 * 550336261) + (j109 >>> 28);
        long j112 = j109 & M28L;
        long j113 = j13 + (j19 * 43969588) + (j20 * 30366549) + (j22 * 163752818) + (j23 * 258169998) + (j26 * 96434764) + (j34 * 227822194) + (j35 * 149865618) + (j33 * 550336261) + (j111 >>> 28);
        long j114 = j111 & M28L;
        long j115 = j67 + (j113 >>> 28);
        long j116 = j113 & M28L;
        long j117 = j81 + (j115 >>> 28);
        long j118 = j115 & M28L;
        long j119 = j117 & M26L;
        long j120 = (j117 >>> 26) - 1;
        long j121 = j90 - (j120 & 78101261);
        long j122 = (j92 - (j120 & 141809365)) + (j121 >> 28);
        long j123 = j121 & M28L;
        long j124 = (j94 - (j120 & 175155932)) + (j122 >> 28);
        long j125 = j122 & M28L;
        long j126 = (j96 - (j120 & 64542499)) + (j124 >> 28);
        long j127 = j124 & M28L;
        long j128 = (j98 - (j120 & 158326419)) + (j126 >> 28);
        long j129 = j126 & M28L;
        long j130 = (j100 - (j120 & 191173276)) + (j128 >> 28);
        long j131 = j128 & M28L;
        long j132 = (j102 - (j120 & 104575268)) + (j130 >> 28);
        long j133 = j130 & M28L;
        long j134 = (j104 - (j120 & 137584065)) + (j132 >> 28);
        long j135 = j132 & M28L;
        long j136 = j106 + (j134 >> 28);
        long j137 = j134 & M28L;
        long j138 = j108 + (j136 >> 28);
        long j139 = j136 & M28L;
        long j140 = j110 + (j138 >> 28);
        long j141 = j138 & M28L;
        long j142 = j112 + (j140 >> 28);
        long j143 = j140 & M28L;
        long j144 = j114 + (j142 >> 28);
        long j145 = j142 & M28L;
        long j146 = j116 + (j144 >> 28);
        long j147 = j144 & M28L;
        long j148 = j118 + (j146 >> 28);
        long j149 = j146 & M28L;
        long j150 = j148 & M28L;
        byte[] bArr3 = new byte[57];
        encode56((j125 << 28) | j123, bArr3, 0);
        encode56((j129 << 28) | j127, bArr3, 7);
        encode56(j131 | (j133 << 28), bArr3, 14);
        encode56(j135 | (j137 << 28), bArr3, 21);
        encode56(j139 | (j141 << 28), bArr3, 28);
        encode56(j143 | (j145 << 28), bArr3, 35);
        encode56(j147 | (j149 << 28), bArr3, 42);
        encode56(((j119 + (j148 >> 28)) << 28) | j150, bArr3, 49);
        return bArr3;
    }

    private static void scalarMult(byte[] bArr, PointExt pointExt, PointExt pointExt2) {
        int[] iArr = new int[14];
        decodeScalar(bArr, 0, iArr);
        Nat.shiftDownBits(14, iArr, 2, 0);
        Nat.cadd(14, (~iArr[0]) & 1, iArr, L, iArr);
        Nat.shiftDownBit(14, iArr, 1);
        int[] pointPrecompute = pointPrecompute(pointExt, 8);
        PointExt pointExt3 = new PointExt();
        pointLookup(iArr, 111, pointPrecompute, pointExt2);
        for (int i = IjkMediaMeta.FF_PROFILE_H264_HIGH_10; i >= 0; i--) {
            for (int i2 = 0; i2 < 4; i2++) {
                pointDouble(pointExt2);
            }
            pointLookup(iArr, i, pointPrecompute, pointExt3);
            pointAdd(pointExt3, pointExt2);
        }
        for (int i3 = 0; i3 < 2; i3++) {
            pointDouble(pointExt2);
        }
    }

    private static void scalarMultBase(byte[] bArr, PointExt pointExt) {
        precompute();
        int[] iArr = new int[15];
        decodeScalar(bArr, 0, iArr);
        iArr[14] = Nat.cadd(14, (~iArr[0]) & 1, iArr, L, iArr) + 4;
        Nat.shiftDownBit(15, iArr, 0);
        PointPrecomp pointPrecomp = new PointPrecomp();
        pointSetNeutral(pointExt);
        int i = 17;
        while (true) {
            int i2 = i;
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = 0;
                for (int i5 = 0; i5 < 5; i5++) {
                    i4 = (i4 & (~(1 << i5))) ^ ((iArr[i2 >>> 5] >>> (i2 & 31)) << i5);
                    i2 += 18;
                }
                int i6 = (i4 >>> 4) & 1;
                pointLookup(i3, ((-i6) ^ i4) & 15, pointPrecomp);
                F.cnegate(i6, pointPrecomp.x);
                pointAddPrecomp(pointPrecomp, pointExt);
            }
            i--;
            if (i >= 0) {
                pointDouble(pointExt);
            } else {
                return;
            }
        }
    }

    private static void scalarMultBaseEncoded(byte[] bArr, byte[] bArr2, int i) {
        PointExt pointExt = new PointExt();
        scalarMultBase(bArr, pointExt);
        if (encodePoint(pointExt, bArr2, i) == 0) {
            throw new IllegalStateException();
        }
    }

    public static void scalarMultBaseXY(X448.Friend friend, byte[] bArr, int i, int[] iArr, int[] iArr2) {
        Objects.requireNonNull(friend, "This method is only for use by X448");
        byte[] bArr2 = new byte[57];
        pruneScalar(bArr, i, bArr2);
        PointExt pointExt = new PointExt();
        scalarMultBase(bArr2, pointExt);
        if (checkPoint(pointExt.x, pointExt.y, pointExt.z) != 0) {
            F.copy(pointExt.x, 0, iArr, 0);
            F.copy(pointExt.y, 0, iArr2, 0);
            return;
        }
        throw new IllegalStateException();
    }

    private static void scalarMultOrderVar(PointExt pointExt, PointExt pointExt2) {
        byte[] wnafVar = getWnafVar(L, 5);
        PointExt[] pointPrecomputeVar = pointPrecomputeVar(pointExt, 8);
        pointSetNeutral(pointExt2);
        int i = 446;
        while (true) {
            byte b = wnafVar[i];
            if (b != 0) {
                int i2 = b >> 31;
                boolean z = true;
                int i3 = (b ^ i2) >>> 1;
                if (i2 == 0) {
                    z = false;
                }
                pointAddVar(z, pointPrecomputeVar[i3], pointExt2);
            }
            i--;
            if (i >= 0) {
                pointDouble(pointExt2);
            } else {
                return;
            }
        }
    }

    private static void scalarMultStrausVar(int[] iArr, int[] iArr2, PointExt pointExt, PointExt pointExt2) {
        precompute();
        byte[] wnafVar = getWnafVar(iArr, 7);
        byte[] wnafVar2 = getWnafVar(iArr2, 5);
        PointExt[] pointPrecomputeVar = pointPrecomputeVar(pointExt, 8);
        pointSetNeutral(pointExt2);
        int i = 446;
        while (true) {
            byte b = wnafVar[i];
            boolean z = false;
            if (b != 0) {
                int i2 = b >> 31;
                pointAddVar(i2 != 0, precompBaseTable[(b ^ i2) >>> 1], pointExt2);
            }
            byte b2 = wnafVar2[i];
            if (b2 != 0) {
                int i3 = b2 >> 31;
                int i4 = (b2 ^ i3) >>> 1;
                if (i3 != 0) {
                    z = true;
                }
                pointAddVar(z, pointPrecomputeVar[i4], pointExt2);
            }
            i--;
            if (i >= 0) {
                pointDouble(pointExt2);
            } else {
                return;
            }
        }
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4, bArr5, i5);
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        implSign(bArr, i, bArr2, (byte) 0, bArr3, i2, i3, bArr4, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, Xof xof, byte[] bArr4, int i3) {
        byte[] bArr5 = new byte[64];
        if (64 == xof.doFinal(bArr5, 0, 64)) {
            implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr5, 0, 64, bArr4, i3);
            return;
        }
        throw new IllegalArgumentException("ph");
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, byte[] bArr5, int i4) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64, bArr5, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, Xof xof, byte[] bArr3, int i2) {
        byte[] bArr4 = new byte[64];
        if (64 == xof.doFinal(bArr4, 0, 64)) {
            implSign(bArr, i, bArr2, (byte) 1, bArr4, 0, 64, bArr3, i2);
            return;
        }
        throw new IllegalArgumentException("ph");
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, byte[] bArr4, int i3) {
        implSign(bArr, i, bArr2, (byte) 1, bArr3, i2, 64, bArr4, i3);
    }

    public static boolean validatePublicKeyFull(byte[] bArr, int i) {
        PointExt pointExt = new PointExt();
        if (!decodePointVar(bArr, i, false, pointExt)) {
            return false;
        }
        F.normalize(pointExt.x);
        F.normalize(pointExt.y);
        F.normalize(pointExt.z);
        if (isNeutralElementVar(pointExt.x, pointExt.y, pointExt.z)) {
            return false;
        }
        PointExt pointExt2 = new PointExt();
        scalarMultOrderVar(pointExt, pointExt2);
        F.normalize(pointExt2.x);
        F.normalize(pointExt2.y);
        F.normalize(pointExt2.z);
        return isNeutralElementVar(pointExt2.x, pointExt2.y, pointExt2.z);
    }

    public static boolean validatePublicKeyPartial(byte[] bArr, int i) {
        return decodePointVar(bArr, i, false, new PointExt());
    }

    public static boolean verify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, Xof xof) {
        byte[] bArr4 = new byte[64];
        if (64 == xof.doFinal(bArr4, 0, 64)) {
            return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, 0, 64);
        }
        throw new IllegalArgumentException("ph");
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64);
    }
}
