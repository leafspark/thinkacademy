package org.bouncycastle.crypto.macs;

import okhttp3.internal.http2.Http2Connection;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Pack;

public class Poly1305 implements Mac {
    private static final int BLOCK_SIZE = 16;
    private final BlockCipher cipher;
    private final byte[] currentBlock;
    private int currentBlockOffset;
    private int h0;
    private int h1;
    private int h2;
    private int h3;
    private int h4;
    private int k0;
    private int k1;
    private int k2;
    private int k3;
    private int r0;
    private int r1;
    private int r2;
    private int r3;
    private int r4;
    private int s1;
    private int s2;
    private int s3;
    private int s4;
    private final byte[] singleByte;

    public Poly1305() {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        this.cipher = null;
    }

    public Poly1305(BlockCipher blockCipher) {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        if (blockCipher.getBlockSize() == 16) {
            this.cipher = blockCipher;
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
    }

    private static final long mul32x32_64(int i, int i2) {
        return (((long) i) & 4294967295L) * ((long) i2);
    }

    private void processBlock() {
        int i = this.currentBlockOffset;
        if (i < 16) {
            this.currentBlock[i] = 1;
            for (int i2 = i + 1; i2 < 16; i2++) {
                this.currentBlock[i2] = 0;
            }
        }
        long littleEndianToInt = ((long) Pack.littleEndianToInt(this.currentBlock, 0)) & 4294967295L;
        long littleEndianToInt2 = ((long) Pack.littleEndianToInt(this.currentBlock, 4)) & 4294967295L;
        long littleEndianToInt3 = ((long) Pack.littleEndianToInt(this.currentBlock, 8)) & 4294967295L;
        long littleEndianToInt4 = 4294967295L & ((long) Pack.littleEndianToInt(this.currentBlock, 12));
        int i3 = (int) (((long) this.h0) + (littleEndianToInt & 67108863));
        this.h0 = i3;
        this.h1 = (int) (((long) this.h1) + ((((littleEndianToInt2 << 32) | littleEndianToInt) >>> 26) & 67108863));
        this.h2 = (int) (((long) this.h2) + (((littleEndianToInt2 | (littleEndianToInt3 << 32)) >>> 20) & 67108863));
        this.h3 = (int) (((long) this.h3) + ((((littleEndianToInt4 << 32) | littleEndianToInt3) >>> 14) & 67108863));
        int i4 = (int) (((long) this.h4) + (littleEndianToInt4 >>> 8));
        this.h4 = i4;
        if (this.currentBlockOffset == 16) {
            this.h4 = i4 + Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        long mul32x32_64 = mul32x32_64(i3, this.r0) + mul32x32_64(this.h1, this.s4) + mul32x32_64(this.h2, this.s3) + mul32x32_64(this.h3, this.s2) + mul32x32_64(this.h4, this.s1);
        long mul32x32_642 = mul32x32_64(this.h0, this.r1) + mul32x32_64(this.h1, this.r0) + mul32x32_64(this.h2, this.s4) + mul32x32_64(this.h3, this.s3) + mul32x32_64(this.h4, this.s2);
        long mul32x32_643 = mul32x32_64(this.h0, this.r2) + mul32x32_64(this.h1, this.r1) + mul32x32_64(this.h2, this.r0) + mul32x32_64(this.h3, this.s4) + mul32x32_64(this.h4, this.s3);
        long mul32x32_644 = mul32x32_64(this.h0, this.r3) + mul32x32_64(this.h1, this.r2) + mul32x32_64(this.h2, this.r1) + mul32x32_64(this.h3, this.r0) + mul32x32_64(this.h4, this.s4);
        long mul32x32_645 = mul32x32_64(this.h0, this.r4) + mul32x32_64(this.h1, this.r3) + mul32x32_64(this.h2, this.r2) + mul32x32_64(this.h3, this.r1) + mul32x32_64(this.h4, this.r0);
        int i5 = ((int) mul32x32_64) & 67108863;
        this.h0 = i5;
        long j = mul32x32_642 + (mul32x32_64 >>> 26);
        int i6 = ((int) j) & 67108863;
        this.h1 = i6;
        long j2 = mul32x32_643 + (j >>> 26);
        this.h2 = ((int) j2) & 67108863;
        long j3 = mul32x32_644 + (j2 >>> 26);
        this.h3 = ((int) j3) & 67108863;
        long j4 = mul32x32_645 + (j3 >>> 26);
        this.h4 = ((int) j4) & 67108863;
        int i7 = i5 + (((int) (j4 >>> 26)) * 5);
        this.h0 = i7;
        this.h1 = i6 + (i7 >>> 26);
        this.h0 = i7 & 67108863;
    }

    private void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            int i = 16;
            if (this.cipher == null || (bArr2 != null && bArr2.length == 16)) {
                int littleEndianToInt = Pack.littleEndianToInt(bArr, 0);
                int littleEndianToInt2 = Pack.littleEndianToInt(bArr, 4);
                int littleEndianToInt3 = Pack.littleEndianToInt(bArr, 8);
                int littleEndianToInt4 = Pack.littleEndianToInt(bArr, 12);
                this.r0 = 67108863 & littleEndianToInt;
                int i2 = ((littleEndianToInt >>> 26) | (littleEndianToInt2 << 6)) & 67108611;
                this.r1 = i2;
                int i3 = ((littleEndianToInt2 >>> 20) | (littleEndianToInt3 << 12)) & 67092735;
                this.r2 = i3;
                int i4 = ((littleEndianToInt3 >>> 14) | (littleEndianToInt4 << 18)) & 66076671;
                this.r3 = i4;
                int i5 = (littleEndianToInt4 >>> 8) & 1048575;
                this.r4 = i5;
                this.s1 = i2 * 5;
                this.s2 = i3 * 5;
                this.s3 = i4 * 5;
                this.s4 = i5 * 5;
                BlockCipher blockCipher = this.cipher;
                if (blockCipher != null) {
                    byte[] bArr3 = new byte[16];
                    blockCipher.init(true, new KeyParameter(bArr, 16, 16));
                    this.cipher.processBlock(bArr2, 0, bArr3, 0);
                    i = 0;
                    bArr = bArr3;
                }
                this.k0 = Pack.littleEndianToInt(bArr, i + 0);
                this.k1 = Pack.littleEndianToInt(bArr, i + 4);
                this.k2 = Pack.littleEndianToInt(bArr, i + 8);
                this.k3 = Pack.littleEndianToInt(bArr, i + 12);
                return;
            }
            throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
        }
        throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
    }

    public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        if (i + 16 <= bArr.length) {
            if (this.currentBlockOffset > 0) {
                processBlock();
            }
            int i2 = this.h1;
            int i3 = this.h0;
            int i4 = i2 + (i3 >>> 26);
            this.h1 = i4;
            int i5 = i3 & 67108863;
            this.h0 = i5;
            int i6 = this.h2 + (i4 >>> 26);
            this.h2 = i6;
            int i7 = i4 & 67108863;
            this.h1 = i7;
            int i8 = this.h3 + (i6 >>> 26);
            this.h3 = i8;
            int i9 = i6 & 67108863;
            this.h2 = i9;
            int i10 = this.h4 + (i8 >>> 26);
            this.h4 = i10;
            int i11 = i8 & 67108863;
            this.h3 = i11;
            int i12 = i5 + ((i10 >>> 26) * 5);
            this.h0 = i12;
            int i13 = i10 & 67108863;
            this.h4 = i13;
            int i14 = i7 + (i12 >>> 26);
            this.h1 = i14;
            int i15 = i12 & 67108863;
            this.h0 = i15;
            int i16 = i15 + 5;
            int i17 = (i16 >>> 26) + i14;
            int i18 = (i17 >>> 26) + i9;
            int i19 = (i18 >>> 26) + i11;
            int i20 = 67108863 & i19;
            int i21 = ((i19 >>> 26) + i13) - 67108864;
            int i22 = (i21 >>> 31) - 1;
            int i23 = ~i22;
            int i24 = (i15 & i23) | (i16 & 67108863 & i22);
            this.h0 = i24;
            int i25 = (i14 & i23) | (i17 & 67108863 & i22);
            this.h1 = i25;
            int i26 = (i9 & i23) | (i18 & 67108863 & i22);
            this.h2 = i26;
            int i27 = (i20 & i22) | (i11 & i23);
            this.h3 = i27;
            int i28 = (i13 & i23) | (i21 & i22);
            this.h4 = i28;
            long j = (((long) (i24 | (i25 << 26))) & 4294967295L) + (((long) this.k0) & 4294967295L);
            long j2 = (((long) ((i25 >>> 6) | (i26 << 20))) & 4294967295L) + (((long) this.k1) & 4294967295L);
            long j3 = (((long) ((i26 >>> 12) | (i27 << 14))) & 4294967295L) + (((long) this.k2) & 4294967295L);
            Pack.intToLittleEndian((int) j, bArr, i);
            long j4 = j2 + (j >>> 32);
            Pack.intToLittleEndian((int) j4, bArr, i + 4);
            long j5 = j3 + (j4 >>> 32);
            Pack.intToLittleEndian((int) j5, bArr, i + 8);
            Pack.intToLittleEndian((int) ((((long) ((i27 >>> 18) | (i28 << 8))) & 4294967295L) + (4294967295L & ((long) this.k3)) + (j5 >>> 32)), bArr, i + 12);
            reset();
            return 16;
        }
        throw new OutputLengthException("Output buffer is too short.");
    }

    public String getAlgorithmName() {
        if (this.cipher == null) {
            return "Poly1305";
        }
        return "Poly1305-" + this.cipher.getAlgorithmName();
    }

    public int getMacSize() {
        return 16;
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        byte[] bArr;
        if (this.cipher == null) {
            bArr = null;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.getIV();
            cipherParameters = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
        }
        if (cipherParameters instanceof KeyParameter) {
            setKey(((KeyParameter) cipherParameters).getKey(), bArr);
            reset();
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a key.");
    }

    public void reset() {
        this.currentBlockOffset = 0;
        this.h4 = 0;
        this.h3 = 0;
        this.h2 = 0;
        this.h1 = 0;
        this.h0 = 0;
    }

    public void update(byte b) throws IllegalStateException {
        byte[] bArr = this.singleByte;
        bArr[0] = b;
        update(bArr, 0, 1);
    }

    public void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
        int i3 = 0;
        while (i2 > i3) {
            if (this.currentBlockOffset == 16) {
                processBlock();
                this.currentBlockOffset = 0;
            }
            int min = Math.min(i2 - i3, 16 - this.currentBlockOffset);
            System.arraycopy(bArr, i3 + i, this.currentBlock, this.currentBlockOffset, min);
            i3 += min;
            this.currentBlockOffset += min;
        }
    }
}
