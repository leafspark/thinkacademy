package org.bouncycastle.pqc.crypto.gmss.util;

import org.bouncycastle.crypto.Digest;

public class WinternitzOTSignature {
    private int checksumsize;
    private GMSSRandom gmssRandom;
    private int keysize;
    private int mdsize;
    private Digest messDigestOTS;
    private int messagesize;
    private byte[][] privateKeyOTS;
    private int w;

    public WinternitzOTSignature(byte[] bArr, Digest digest, int i) {
        this.w = i;
        this.messDigestOTS = digest;
        this.gmssRandom = new GMSSRandom(digest);
        int digestSize = this.messDigestOTS.getDigestSize();
        this.mdsize = digestSize;
        int i2 = (((digestSize << 3) + i) - 1) / i;
        this.messagesize = i2;
        int log = getLog((i2 << i) + 1);
        this.checksumsize = log;
        int i3 = this.messagesize + (((log + i) - 1) / i);
        this.keysize = i3;
        this.privateKeyOTS = new byte[i3][];
        int i4 = this.mdsize;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, 0, bArr2, 0, i4);
        for (int i5 = 0; i5 < this.keysize; i5++) {
            this.privateKeyOTS[i5] = this.gmssRandom.nextSeed(bArr2);
        }
    }

    private void hashPrivateKeyBlock(int i, int i2, byte[] bArr, int i3) {
        if (i2 < 1) {
            System.arraycopy(this.privateKeyOTS[i], 0, bArr, i3, this.mdsize);
            return;
        }
        this.messDigestOTS.update(this.privateKeyOTS[i], 0, this.mdsize);
        while (true) {
            this.messDigestOTS.doFinal(bArr, i3);
            i2--;
            if (i2 > 0) {
                this.messDigestOTS.update(bArr, i3, this.mdsize);
            } else {
                return;
            }
        }
    }

    public int getLog(int i) {
        int i2 = 1;
        int i3 = 2;
        while (i3 < i) {
            i3 <<= 1;
            i2++;
        }
        return i2;
    }

    public byte[][] getPrivateKey() {
        return this.privateKeyOTS;
    }

    public byte[] getPublicKey() {
        int i = this.keysize * this.mdsize;
        byte[] bArr = new byte[i];
        int i2 = (1 << this.w) - 1;
        int i3 = 0;
        for (int i4 = 0; i4 < this.keysize; i4++) {
            hashPrivateKeyBlock(i4, i2, bArr, i3);
            i3 += this.mdsize;
        }
        this.messDigestOTS.update(bArr, 0, i);
        byte[] bArr2 = new byte[this.mdsize];
        this.messDigestOTS.doFinal(bArr2, 0);
        return bArr2;
    }

    public byte[] getSignature(byte[] bArr) {
        int i;
        byte[] bArr2 = bArr;
        int i2 = this.keysize;
        int i3 = this.mdsize;
        byte[] bArr3 = new byte[(i2 * i3)];
        byte[] bArr4 = new byte[i3];
        int i4 = 0;
        this.messDigestOTS.update(bArr2, 0, bArr2.length);
        this.messDigestOTS.doFinal(bArr4, 0);
        int i5 = this.w;
        int i6 = 8;
        if (8 % i5 == 0) {
            int i7 = 8 / i5;
            int i8 = (1 << i5) - 1;
            int i9 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < i3; i11++) {
                for (int i12 = 0; i12 < i7; i12++) {
                    byte b = bArr4[i11] & i8;
                    i9 += b;
                    hashPrivateKeyBlock(i10, b, bArr3, this.mdsize * i10);
                    bArr4[i11] = (byte) (bArr4[i11] >>> this.w);
                    i10++;
                }
            }
            int i13 = (this.messagesize << this.w) - i9;
            while (i4 < this.checksumsize) {
                hashPrivateKeyBlock(i10, i13 & i8, bArr3, this.mdsize * i10);
                int i14 = this.w;
                i13 >>>= i14;
                i10++;
                i4 += i14;
            }
        } else if (i5 < 8) {
            int i15 = this.mdsize / i5;
            int i16 = (1 << i5) - 1;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            while (i17 < i15) {
                long j = 0;
                for (int i21 = 0; i21 < this.w; i21++) {
                    j ^= (long) ((bArr4[i18] & 255) << (i21 << 3));
                    i18++;
                }
                int i22 = 0;
                long j2 = j;
                while (i22 < i6) {
                    int i23 = ((int) j2) & i16;
                    i20 += i23;
                    hashPrivateKeyBlock(i19, i23, bArr3, this.mdsize * i19);
                    j2 >>>= this.w;
                    i19++;
                    i22++;
                    i6 = 8;
                }
                i17++;
                i6 = 8;
            }
            int i24 = this.mdsize % this.w;
            long j3 = 0;
            for (int i25 = 0; i25 < i24; i25++) {
                j3 ^= (long) ((bArr4[i18] & 255) << (i25 << 3));
                i18++;
            }
            int i26 = i24 << 3;
            int i27 = 0;
            while (i27 < i26) {
                int i28 = ((int) j3) & i16;
                i20 += i28;
                hashPrivateKeyBlock(i19, i28, bArr3, this.mdsize * i19);
                int i29 = this.w;
                j3 >>>= i29;
                i19++;
                i27 += i29;
            }
            int i30 = (this.messagesize << this.w) - i20;
            while (i4 < this.checksumsize) {
                hashPrivateKeyBlock(i19, i30 & i16, bArr3, this.mdsize * i19);
                int i31 = this.w;
                i30 >>>= i31;
                i19++;
                i4 += i31;
            }
        } else if (i5 < 57) {
            int i32 = this.mdsize;
            int i33 = (i32 << 3) - i5;
            int i34 = (1 << i5) - 1;
            byte[] bArr5 = new byte[i32];
            int i35 = 0;
            int i36 = 0;
            int i37 = 0;
            while (i35 <= i33) {
                int i38 = i35 >>> 3;
                int i39 = i35 % 8;
                i35 += this.w;
                int i40 = (i35 + 7) >>> 3;
                int i41 = i4;
                long j4 = 0;
                while (i38 < i40) {
                    j4 ^= (long) ((bArr4[i38] & 255) << (i41 << 3));
                    i41++;
                    i38++;
                    bArr4 = bArr4;
                    i33 = i33;
                }
                byte[] bArr6 = bArr4;
                int i42 = i33;
                long j5 = (j4 >>> i39) & ((long) i34);
                i37 = (int) (((long) i37) + j5);
                System.arraycopy(this.privateKeyOTS[i36], 0, bArr5, 0, this.mdsize);
                while (j5 > 0) {
                    this.messDigestOTS.update(bArr5, 0, i32);
                    this.messDigestOTS.doFinal(bArr5, 0);
                    j5--;
                }
                int i43 = this.mdsize;
                System.arraycopy(bArr5, 0, bArr3, i36 * i43, i43);
                i36++;
                bArr4 = bArr6;
                i33 = i42;
                i4 = 0;
            }
            byte[] bArr7 = bArr4;
            int i44 = i35 >>> 3;
            if (i44 < this.mdsize) {
                int i45 = i35 % 8;
                int i46 = 0;
                long j6 = 0;
                while (true) {
                    i = this.mdsize;
                    if (i44 >= i) {
                        break;
                    }
                    j6 ^= (long) ((bArr7[i44] & 255) << (i46 << 3));
                    i46++;
                    i44++;
                }
                long j7 = (j6 >>> i45) & ((long) i34);
                i37 = (int) (((long) i37) + j7);
                System.arraycopy(this.privateKeyOTS[i36], 0, bArr5, 0, i);
                while (j7 > 0) {
                    this.messDigestOTS.update(bArr5, 0, i32);
                    this.messDigestOTS.doFinal(bArr5, 0);
                    j7--;
                }
                int i47 = this.mdsize;
                System.arraycopy(bArr5, 0, bArr3, i36 * i47, i47);
                i36++;
            }
            int i48 = (this.messagesize << this.w) - i37;
            int i49 = 0;
            while (i49 < this.checksumsize) {
                System.arraycopy(this.privateKeyOTS[i36], 0, bArr5, 0, this.mdsize);
                for (long j8 = (long) (i48 & i34); j8 > 0; j8--) {
                    this.messDigestOTS.update(bArr5, 0, i32);
                    this.messDigestOTS.doFinal(bArr5, 0);
                }
                int i50 = this.mdsize;
                System.arraycopy(bArr5, 0, bArr3, i36 * i50, i50);
                int i51 = this.w;
                i48 >>>= i51;
                i36++;
                i49 += i51;
            }
        }
        return bArr3;
    }
}
