package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public final class Kangaroo {
    private static final int DIGESTLEN = 32;

    static abstract class KangarooBase implements ExtendedDigest, Xof {
        private static final int BLKSIZE = 8192;
        private static final byte[] FINAL = {-1, -1, 6};
        private static final byte[] FIRST = {3, 0, 0, 0, 0, 0, 0, 0};
        private static final byte[] INTERMEDIATE = {11};
        private static final byte[] SINGLE = {7};
        private final byte[] singleByte = new byte[1];
        private boolean squeezing;
        private final int theChainLen;
        private int theCurrNode;
        private final KangarooSponge theLeaf;
        private byte[] thePersonal;
        private int theProcessed;
        private final KangarooSponge theTree;
        private long theXofLen;
        private long theXofRemaining;

        KangarooBase(int i, int i2, int i3) {
            this.theTree = new KangarooSponge(i, i2);
            this.theLeaf = new KangarooSponge(i, i2);
            this.theChainLen = i >> 2;
            this.theXofLen = (long) i3;
            this.theXofRemaining = -1;
            buildPersonal((byte[]) null);
        }

        private void buildPersonal(byte[] bArr) {
            int length = bArr == null ? 0 : bArr.length;
            byte[] lengthEncode = lengthEncode((long) length);
            byte[] copyOf = bArr == null ? new byte[(lengthEncode.length + length)] : Arrays.copyOf(bArr, lengthEncode.length + length);
            this.thePersonal = copyOf;
            System.arraycopy(lengthEncode, 0, copyOf, length, lengthEncode.length);
        }

        private static byte[] lengthEncode(long j) {
            byte b;
            if (j != 0) {
                long j2 = j;
                b = 1;
                while (true) {
                    j2 >>= 8;
                    if (j2 == 0) {
                        break;
                    }
                    b = (byte) (b + 1);
                }
            } else {
                b = 0;
            }
            byte[] bArr = new byte[(b + 1)];
            bArr[b] = b;
            for (int i = 0; i < b; i++) {
                bArr[i] = (byte) ((int) (j >> (((b - i) - 1) * 8)));
            }
            return bArr;
        }

        private void processData(byte[] bArr, int i, int i2) {
            if (!this.squeezing) {
                KangarooSponge kangarooSponge = this.theCurrNode == 0 ? this.theTree : this.theLeaf;
                int i3 = 8192 - this.theProcessed;
                if (i3 >= i2) {
                    kangarooSponge.absorb(bArr, i, i2);
                    this.theProcessed += i2;
                    return;
                }
                if (i3 > 0) {
                    kangarooSponge.absorb(bArr, i, i3);
                    this.theProcessed += i3;
                }
                while (i3 < i2) {
                    if (this.theProcessed == 8192) {
                        switchLeaf(true);
                    }
                    int min = Math.min(i2 - i3, 8192);
                    this.theLeaf.absorb(bArr, i + i3, min);
                    this.theProcessed += min;
                    i3 += min;
                }
                return;
            }
            throw new IllegalStateException("attempt to absorb while squeezing");
        }

        private void switchFinal() {
            switchLeaf(false);
            byte[] lengthEncode = lengthEncode((long) this.theCurrNode);
            this.theTree.absorb(lengthEncode, 0, lengthEncode.length);
            KangarooSponge kangarooSponge = this.theTree;
            byte[] bArr = FINAL;
            kangarooSponge.absorb(bArr, 0, bArr.length);
            this.theTree.padAndSwitchToSqueezingPhase();
        }

        private void switchLeaf(boolean z) {
            if (this.theCurrNode == 0) {
                KangarooSponge kangarooSponge = this.theTree;
                byte[] bArr = FIRST;
                kangarooSponge.absorb(bArr, 0, bArr.length);
            } else {
                KangarooSponge kangarooSponge2 = this.theLeaf;
                byte[] bArr2 = INTERMEDIATE;
                kangarooSponge2.absorb(bArr2, 0, bArr2.length);
                int i = this.theChainLen;
                byte[] bArr3 = new byte[i];
                this.theLeaf.squeeze(bArr3, 0, i);
                this.theTree.absorb(bArr3, 0, this.theChainLen);
                this.theLeaf.initSponge();
            }
            if (z) {
                this.theCurrNode++;
            }
            this.theProcessed = 0;
        }

        private void switchSingle() {
            this.theTree.absorb(SINGLE, 0, 1);
            this.theTree.padAndSwitchToSqueezingPhase();
        }

        private void switchToSqueezing() {
            byte[] bArr = this.thePersonal;
            processData(bArr, 0, bArr.length);
            if (this.theCurrNode == 0) {
                switchSingle();
            } else {
                switchFinal();
            }
            long j = this.theXofLen;
            if (j == 0) {
                j = (long) getDigestSize();
            } else if (j == -1) {
                j = -2;
            }
            this.theXofRemaining = j;
        }

        public int doFinal(byte[] bArr, int i) {
            if (getDigestSize() != -1) {
                return doFinal(bArr, i, getDigestSize());
            }
            throw new IllegalStateException("No defined output length");
        }

        public int doFinal(byte[] bArr, int i, int i2) {
            if (!this.squeezing) {
                int doOutput = doOutput(bArr, i, i2);
                reset();
                return doOutput;
            }
            throw new IllegalStateException("Already outputting");
        }

        public int doOutput(byte[] bArr, int i, int i2) {
            if (!this.squeezing) {
                switchToSqueezing();
            }
            if (i2 >= 0) {
                long j = this.theXofRemaining;
                if (j <= 0 || ((long) i2) <= j) {
                    this.theTree.squeeze(bArr, i, i2);
                    return i2;
                }
            }
            throw new IllegalArgumentException("Insufficient bytes remaining");
        }

        public int getByteLength() {
            return this.theTree.theRateBytes;
        }

        public int getDigestSize() {
            long j = this.theXofLen;
            return j == 0 ? this.theChainLen >> 1 : (int) j;
        }

        public void init(KangarooParameters kangarooParameters) {
            buildPersonal(kangarooParameters.getPersonalisation());
            long maxOutputLength = kangarooParameters.getMaxOutputLength();
            if (maxOutputLength >= -1) {
                this.theXofLen = maxOutputLength;
                reset();
                return;
            }
            throw new IllegalArgumentException("Invalid output length");
        }

        public void reset() {
            this.theTree.initSponge();
            this.theLeaf.initSponge();
            this.theCurrNode = 0;
            this.theProcessed = 0;
            this.theXofRemaining = -1;
            this.squeezing = false;
        }

        public void update(byte b) {
            byte[] bArr = this.singleByte;
            bArr[0] = b;
            update(bArr, 0, 1);
        }

        public void update(byte[] bArr, int i, int i2) {
            processData(bArr, i, i2);
        }
    }

    public static class KangarooParameters implements CipherParameters {
        /* access modifiers changed from: private */
        public long theMaxXofLen;
        /* access modifiers changed from: private */
        public byte[] thePersonal;

        public static class Builder {
            private long theMaxXofLen;
            private byte[] thePersonal;

            public KangarooParameters build() {
                KangarooParameters kangarooParameters = new KangarooParameters();
                byte[] bArr = this.thePersonal;
                if (bArr != null) {
                    byte[] unused = kangarooParameters.thePersonal = bArr;
                }
                long unused2 = kangarooParameters.theMaxXofLen = this.theMaxXofLen;
                return kangarooParameters;
            }

            public Builder setMaxOutputLen(long j) {
                this.theMaxXofLen = j;
                return this;
            }

            public Builder setPersonalisation(byte[] bArr) {
                this.thePersonal = Arrays.clone(bArr);
                return this;
            }
        }

        public long getMaxOutputLength() {
            return this.theMaxXofLen;
        }

        public byte[] getPersonalisation() {
            return Arrays.clone(this.thePersonal);
        }
    }

    private static class KangarooSponge {
        private static long[] KeccakRoundConstants = {1, 32898, -9223372036854742902L, -9223372034707259392L, 32907, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138, 136, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L};
        private int bytesInQueue;
        private boolean squeezing;
        private final byte[] theQueue;
        /* access modifiers changed from: private */
        public final int theRateBytes;
        private final int theRounds;
        private final long[] theState = new long[25];

        KangarooSponge(int i, int i2) {
            int i3 = (1600 - (i << 1)) >> 3;
            this.theRateBytes = i3;
            this.theRounds = i2;
            this.theQueue = new byte[i3];
            initSponge();
        }

        private void KangarooAbsorb(byte[] bArr, int i) {
            int i2 = this.theRateBytes >> 3;
            for (int i3 = 0; i3 < i2; i3++) {
                long[] jArr = this.theState;
                jArr[i3] = jArr[i3] ^ Pack.littleEndianToLong(bArr, i);
                i += 8;
            }
            KangarooPermutation();
        }

        private void KangarooExtract() {
            Pack.longToLittleEndian(this.theState, 0, this.theRateBytes >> 3, this.theQueue, 0);
        }

        private void KangarooPermutation() {
            KangarooSponge kangarooSponge = this;
            long[] jArr = kangarooSponge.theState;
            long j = jArr[0];
            boolean z = true;
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            long j5 = jArr[4];
            long j6 = jArr[5];
            long j7 = jArr[6];
            long j8 = jArr[7];
            long j9 = jArr[8];
            long j10 = jArr[9];
            long j11 = jArr[10];
            long j12 = jArr[11];
            long j13 = jArr[12];
            long j14 = jArr[13];
            long j15 = jArr[14];
            long j16 = jArr[15];
            long j17 = jArr[16];
            long j18 = jArr[17];
            long j19 = jArr[18];
            long j20 = jArr[19];
            long j21 = jArr[20];
            long j22 = jArr[21];
            long j23 = jArr[22];
            long j24 = jArr[23];
            long j25 = jArr[24];
            int length = KeccakRoundConstants.length - kangarooSponge.theRounds;
            int i = 0;
            while (i < kangarooSponge.theRounds) {
                long j26 = (((j ^ j6) ^ j11) ^ j16) ^ j21;
                long j27 = (((j2 ^ j7) ^ j12) ^ j17) ^ j22;
                long j28 = (((j3 ^ j8) ^ j13) ^ j18) ^ j23;
                long j29 = (((j4 ^ j9) ^ j14) ^ j19) ^ j24;
                long j30 = (((j5 ^ j10) ^ j15) ^ j20) ^ j25;
                long j31 = ((j27 << (z ? 1 : 0)) | (j27 >>> -1)) ^ j30;
                long j32 = ((j28 << z) | (j28 >>> -1)) ^ j26;
                long j33 = ((j29 << z) | (j29 >>> -1)) ^ j27;
                long j34 = ((j30 << z) | (j30 >>> -1)) ^ j28;
                long j35 = ((j26 << z) | (j26 >>> -1)) ^ j29;
                long j36 = j ^ j31;
                long j37 = j6 ^ j31;
                long j38 = j11 ^ j31;
                long j39 = j16 ^ j31;
                long j40 = j21 ^ j31;
                long j41 = j2 ^ j32;
                long j42 = j7 ^ j32;
                long j43 = j12 ^ j32;
                long j44 = j17 ^ j32;
                long j45 = j22 ^ j32;
                long j46 = j3 ^ j33;
                long j47 = j8 ^ j33;
                long j48 = j13 ^ j33;
                long j49 = j18 ^ j33;
                long j50 = j23 ^ j33;
                long j51 = j9 ^ j34;
                long j52 = j14 ^ j34;
                long j53 = j19 ^ j34;
                long j54 = j24 ^ j34;
                long j55 = j5 ^ j35;
                long j56 = j10 ^ j35;
                long j57 = j15 ^ j35;
                long j58 = j20 ^ j35;
                long j59 = j25 ^ j35;
                long j60 = (j41 << z) | (j41 >>> 63);
                long j61 = (j42 << 44) | (j42 >>> 20);
                long j62 = j4 ^ j34;
                long j63 = (j56 << 20) | (j56 >>> 44);
                int i2 = length;
                long j64 = (j57 << 39) | (j57 >>> 25);
                long j65 = (j48 << 43) | (j48 >>> 21);
                long j66 = (j46 << 62) | (j46 >>> 2);
                long j67 = (j52 << 25) | (j52 >>> 39);
                long j68 = (j40 << 18) | (j40 >>> 46);
                long j69 = (j58 << 8) | (j58 >>> 56);
                long j70 = j39 << 41;
                long j71 = j39 >>> 23;
                long j72 = (j54 << 56) | (j54 >>> 8);
                long j73 = j70 | j71;
                long j74 = (j55 << 27) | (j55 >>> 37);
                long j75 = (j59 << 14) | (j59 >>> 50);
                long j76 = j45 << 2;
                long j77 = j45 >>> 62;
                long j78 = j67;
                long j79 = j76 | j77;
                long j80 = j51 << 55;
                long j81 = j51 >>> 9;
                long j82 = j79;
                long j83 = j80 | j81;
                long j84 = j44 << 45;
                long j85 = j44 >>> 19;
                long j86 = j83;
                long j87 = j84 | j85;
                long j88 = (j50 << 61) | (j50 >>> 3);
                long j89 = (j37 << 36) | (j37 >>> 28);
                long j90 = j53 << 21;
                long j91 = j53 >>> 43;
                long j92 = j87;
                long j93 = j90 | j91;
                long j94 = j49 << 15;
                long j95 = j49 >>> 49;
                long j96 = (j62 << 28) | (j62 >>> 36);
                long j97 = j94 | j95;
                long j98 = j43 << 10;
                long j99 = j43 >>> 54;
                long j100 = j97;
                long j101 = j98 | j99;
                long j102 = j47 << 6;
                long j103 = j47 >>> 58;
                long j104 = j101;
                long j105 = j102 | j103;
                long j106 = j38 << 3;
                long j107 = j38 >>> 61;
                long j108 = j105;
                long j109 = j106 | j107;
                long j110 = ((~j61) & j65) ^ j36;
                long j111 = ((~j65) & j93) ^ j61;
                j3 = j65 ^ ((~j93) & j75);
                long j112 = ((~j75) & j36) ^ j93;
                long j113 = ((~j36) & j61) ^ j75;
                long j114 = j96 ^ ((~j63) & j109);
                long j115 = j109;
                long j116 = ((~j115) & j92) ^ j63;
                long j117 = j112;
                long j118 = j92;
                long j119 = j113;
                long j120 = ((~j118) & j88) ^ j115;
                long j121 = j88;
                long j122 = j120;
                long j123 = j118 ^ ((~j121) & j96);
                long j124 = ((~j96) & j63) ^ j121;
                long j125 = j108;
                j11 = j60 ^ ((~j125) & j78);
                long j126 = j123;
                long j127 = j78;
                long j128 = ((~j127) & j69) ^ j125;
                long j129 = j69;
                long j130 = j124;
                long j131 = ((~j129) & j68) ^ j127;
                long j132 = j68;
                long j133 = j131;
                long j134 = j129 ^ ((~j132) & j60);
                long j135 = ((~j60) & j125) ^ j132;
                long j136 = j89;
                long j137 = j74 ^ ((~j136) & j104);
                long j138 = j134;
                long j139 = j104;
                long j140 = j135;
                long j141 = ((~j139) & j100) ^ j136;
                long j142 = j100;
                long j143 = j114;
                long j144 = j72;
                long j145 = j139 ^ ((~j142) & j72);
                long j146 = ((~j144) & j74) ^ j142;
                long j147 = ((~j74) & j136) ^ j144;
                long j148 = j86;
                j21 = j66 ^ ((~j148) & j64);
                long j149 = j64;
                long j150 = j146;
                long j151 = ((~j149) & j73) ^ j148;
                long j152 = j73;
                long j153 = j147;
                long j154 = ((~j152) & j82) ^ j149;
                long j155 = j82;
                long j156 = j152 ^ ((~j155) & j66);
                long j157 = j110 ^ KeccakRoundConstants[i2 + i];
                i++;
                j6 = j143;
                j13 = j133;
                j12 = j128;
                j14 = j138;
                j23 = j154;
                j22 = j151;
                j9 = j126;
                j17 = j141;
                j25 = ((~j66) & j148) ^ j155;
                j = j157;
                j18 = j145;
                j2 = j111;
                z = true;
                j24 = j156;
                j16 = j137;
                jArr = jArr;
                kangarooSponge = this;
                length = i2;
                j4 = j117;
                j5 = j119;
                j19 = j150;
                j15 = j140;
                j8 = j122;
                j7 = j116;
                long j158 = j153;
                j10 = j130;
                j20 = j158;
            }
            long[] jArr2 = jArr;
            jArr2[0] = j;
            jArr2[1] = j2;
            jArr2[2] = j3;
            jArr2[3] = j4;
            jArr2[4] = j5;
            jArr2[5] = j6;
            jArr2[6] = j7;
            jArr2[7] = j8;
            jArr2[8] = j9;
            jArr2[9] = j10;
            jArr2[10] = j11;
            jArr2[11] = j12;
            jArr2[12] = j13;
            jArr2[13] = j14;
            jArr2[14] = j15;
            jArr2[15] = j16;
            jArr2[16] = j17;
            jArr2[17] = j18;
            jArr2[18] = j19;
            jArr2[19] = j20;
            jArr2[20] = j21;
            jArr2[21] = j22;
            jArr2[22] = j23;
            jArr2[23] = j24;
            jArr2[24] = j25;
        }

        /* access modifiers changed from: private */
        public void absorb(byte[] bArr, int i, int i2) {
            int i3;
            if (!this.squeezing) {
                int i4 = 0;
                while (i4 < i2) {
                    int i5 = this.bytesInQueue;
                    if (i5 != 0 || i4 > i2 - this.theRateBytes) {
                        int min = Math.min(this.theRateBytes - i5, i2 - i4);
                        System.arraycopy(bArr, i + i4, this.theQueue, this.bytesInQueue, min);
                        int i6 = this.bytesInQueue + min;
                        this.bytesInQueue = i6;
                        i4 += min;
                        if (i6 == this.theRateBytes) {
                            KangarooAbsorb(this.theQueue, 0);
                            this.bytesInQueue = 0;
                        }
                    } else {
                        do {
                            KangarooAbsorb(bArr, i + i4);
                            i3 = this.theRateBytes;
                            i4 += i3;
                        } while (i4 <= i2 - i3);
                    }
                }
                return;
            }
            throw new IllegalStateException("attempt to absorb while squeezing");
        }

        /* access modifiers changed from: private */
        public void initSponge() {
            Arrays.fill(this.theState, 0);
            Arrays.fill(this.theQueue, (byte) 0);
            this.bytesInQueue = 0;
            this.squeezing = false;
        }

        /* access modifiers changed from: private */
        public void padAndSwitchToSqueezingPhase() {
            int i = this.bytesInQueue;
            while (true) {
                int i2 = this.theRateBytes;
                if (i < i2) {
                    this.theQueue[i] = 0;
                    i++;
                } else {
                    byte[] bArr = this.theQueue;
                    int i3 = i2 - 1;
                    bArr[i3] = (byte) (bArr[i3] ^ 128);
                    KangarooAbsorb(bArr, 0);
                    KangarooExtract();
                    this.bytesInQueue = this.theRateBytes;
                    this.squeezing = true;
                    return;
                }
            }
        }

        /* access modifiers changed from: private */
        public void squeeze(byte[] bArr, int i, int i2) {
            if (!this.squeezing) {
                padAndSwitchToSqueezingPhase();
            }
            int i3 = 0;
            while (i3 < i2) {
                if (this.bytesInQueue == 0) {
                    KangarooPermutation();
                    KangarooExtract();
                    this.bytesInQueue = this.theRateBytes;
                }
                int min = Math.min(this.bytesInQueue, i2 - i3);
                System.arraycopy(this.theQueue, this.theRateBytes - this.bytesInQueue, bArr, i + i3, min);
                this.bytesInQueue -= min;
                i3 += min;
            }
        }
    }

    public static class KangarooTwelve extends KangarooBase {
        public KangarooTwelve() {
            this(32);
        }

        public KangarooTwelve(int i) {
            super(128, 12, i);
        }

        public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i) {
            return super.doFinal(bArr, i);
        }

        public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i, int i2) {
            return super.doFinal(bArr, i, i2);
        }

        public /* bridge */ /* synthetic */ int doOutput(byte[] bArr, int i, int i2) {
            return super.doOutput(bArr, i, i2);
        }

        public String getAlgorithmName() {
            return "KangarooTwelve";
        }

        public /* bridge */ /* synthetic */ int getByteLength() {
            return super.getByteLength();
        }

        public /* bridge */ /* synthetic */ int getDigestSize() {
            return super.getDigestSize();
        }

        public /* bridge */ /* synthetic */ void init(KangarooParameters kangarooParameters) {
            super.init(kangarooParameters);
        }

        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        public /* bridge */ /* synthetic */ void update(byte b) {
            super.update(b);
        }

        public /* bridge */ /* synthetic */ void update(byte[] bArr, int i, int i2) {
            super.update(bArr, i, i2);
        }
    }

    public static class MarsupilamiFourteen extends KangarooBase {
        public MarsupilamiFourteen() {
            this(32);
        }

        public MarsupilamiFourteen(int i) {
            super(256, 14, i);
        }

        public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i) {
            return super.doFinal(bArr, i);
        }

        public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i, int i2) {
            return super.doFinal(bArr, i, i2);
        }

        public /* bridge */ /* synthetic */ int doOutput(byte[] bArr, int i, int i2) {
            return super.doOutput(bArr, i, i2);
        }

        public String getAlgorithmName() {
            return "MarsupilamiFourteen";
        }

        public /* bridge */ /* synthetic */ int getByteLength() {
            return super.getByteLength();
        }

        public /* bridge */ /* synthetic */ int getDigestSize() {
            return super.getDigestSize();
        }

        public /* bridge */ /* synthetic */ void init(KangarooParameters kangarooParameters) {
            super.init(kangarooParameters);
        }

        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        public /* bridge */ /* synthetic */ void update(byte b) {
            super.update(b);
        }

        public /* bridge */ /* synthetic */ void update(byte[] bArr, int i, int i2) {
            super.update(bArr, i, i2);
        }
    }
}
