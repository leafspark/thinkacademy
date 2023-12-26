package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

public class NoekeonEngine implements BlockCipher {
    private static final int SIZE = 16;
    private static final byte[] roundConstants = {Byte.MIN_VALUE, 27, 54, 108, -40, -85, 77, -102, 47, 94, PSSSigner.TRAILER_IMPLICIT, 99, -58, -105, 53, 106, -44};
    private boolean _forEncryption;
    private boolean _initialised = false;
    private final int[] k = new int[4];

    private int decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int i3 = i2;
        int bigEndianToInt = Pack.bigEndianToInt(bArr, i);
        int bigEndianToInt2 = Pack.bigEndianToInt(bArr3, i + 4);
        int bigEndianToInt3 = Pack.bigEndianToInt(bArr3, i + 8);
        int bigEndianToInt4 = Pack.bigEndianToInt(bArr3, i + 12);
        int[] iArr = this.k;
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = iArr[2];
        int i7 = iArr[3];
        int i8 = 16;
        while (true) {
            byte b = bigEndianToInt ^ bigEndianToInt3;
            byte rotateLeft = b ^ (Integers.rotateLeft(b, 8) ^ Integers.rotateLeft(b, 24));
            byte b2 = bigEndianToInt2 ^ i5;
            byte b3 = bigEndianToInt4 ^ i7;
            byte b4 = b2 ^ b3;
            byte rotateLeft2 = (Integers.rotateLeft(b4, 24) ^ Integers.rotateLeft(b4, 8)) ^ b4;
            byte b5 = b2 ^ rotateLeft;
            byte b6 = (bigEndianToInt3 ^ i6) ^ rotateLeft2;
            byte b7 = b3 ^ rotateLeft;
            byte b8 = ((bigEndianToInt ^ i4) ^ rotateLeft2) ^ (roundConstants[i8] & 255);
            i8--;
            if (i8 < 0) {
                Pack.intToBigEndian((int) b8, bArr4, i3);
                Pack.intToBigEndian((int) b5, bArr4, i3 + 4);
                Pack.intToBigEndian((int) b6, bArr4, i3 + 8);
                Pack.intToBigEndian((int) b7, bArr4, i3 + 12);
                return 16;
            }
            int rotateLeft3 = Integers.rotateLeft(b5, 1);
            int rotateLeft4 = Integers.rotateLeft(b6, 5);
            int rotateLeft5 = Integers.rotateLeft(b7, 2);
            byte b9 = rotateLeft3 ^ (rotateLeft5 | rotateLeft4);
            int i9 = ~b9;
            byte b10 = b8 ^ (rotateLeft4 & i9);
            byte b11 = (rotateLeft4 ^ (i9 ^ rotateLeft5)) ^ b10;
            byte b12 = b9 ^ (b10 | b11);
            bigEndianToInt2 = Integers.rotateLeft(b12, 31);
            bigEndianToInt3 = Integers.rotateLeft(b11, 27);
            int rotateLeft6 = Integers.rotateLeft(b10, 30);
            bigEndianToInt = rotateLeft5 ^ (b11 & b12);
            bigEndianToInt4 = rotateLeft6;
        }
    }

    private int encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int i3 = i2;
        int bigEndianToInt = Pack.bigEndianToInt(bArr, i);
        int bigEndianToInt2 = Pack.bigEndianToInt(bArr3, i + 4);
        int bigEndianToInt3 = Pack.bigEndianToInt(bArr3, i + 8);
        int bigEndianToInt4 = Pack.bigEndianToInt(bArr3, i + 12);
        int[] iArr = this.k;
        int i4 = 0;
        int i5 = iArr[0];
        int i6 = iArr[1];
        int i7 = iArr[2];
        int i8 = iArr[3];
        while (true) {
            byte b = bigEndianToInt ^ (roundConstants[i4] & 255);
            byte b2 = b ^ bigEndianToInt3;
            byte rotateLeft = b2 ^ (Integers.rotateLeft(b2, 8) ^ Integers.rotateLeft(b2, 24));
            byte b3 = bigEndianToInt2 ^ i6;
            byte b4 = bigEndianToInt4 ^ i8;
            byte b5 = b3 ^ b4;
            byte rotateLeft2 = b5 ^ (Integers.rotateLeft(b5, 24) ^ Integers.rotateLeft(b5, 8));
            byte b6 = (b ^ i5) ^ rotateLeft2;
            byte b7 = b3 ^ rotateLeft;
            byte b8 = (bigEndianToInt3 ^ i7) ^ rotateLeft2;
            byte b9 = b4 ^ rotateLeft;
            i4++;
            if (i4 > 16) {
                Pack.intToBigEndian((int) b6, bArr4, i3);
                Pack.intToBigEndian((int) b7, bArr4, i3 + 4);
                Pack.intToBigEndian((int) b8, bArr4, i3 + 8);
                Pack.intToBigEndian((int) b9, bArr4, i3 + 12);
                return 16;
            }
            int rotateLeft3 = Integers.rotateLeft(b7, 1);
            int rotateLeft4 = Integers.rotateLeft(b8, 5);
            int rotateLeft5 = Integers.rotateLeft(b9, 2);
            byte b10 = rotateLeft3 ^ (rotateLeft5 | rotateLeft4);
            int i9 = ~b10;
            byte b11 = b6 ^ (rotateLeft4 & i9);
            byte b12 = (rotateLeft4 ^ (i9 ^ rotateLeft5)) ^ b11;
            byte b13 = b10 ^ (b11 | b12);
            bigEndianToInt2 = Integers.rotateLeft(b13, 31);
            bigEndianToInt3 = Integers.rotateLeft(b12, 27);
            int rotateLeft6 = Integers.rotateLeft(b11, 30);
            bigEndianToInt = rotateLeft5 ^ (b12 & b13);
            bigEndianToInt4 = rotateLeft6;
        }
    }

    public String getAlgorithmName() {
        return "Noekeon";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            if (key.length == 16) {
                Pack.bigEndianToInt(key, 0, this.k, 0, 4);
                if (!z) {
                    int[] iArr = this.k;
                    int i = iArr[0];
                    int i2 = iArr[1];
                    int i3 = iArr[2];
                    int i4 = iArr[3];
                    int i5 = i ^ i3;
                    int rotateLeft = i5 ^ (Integers.rotateLeft(i5, 8) ^ Integers.rotateLeft(i5, 24));
                    int i6 = i2 ^ i4;
                    int rotateLeft2 = (Integers.rotateLeft(i6, 8) ^ Integers.rotateLeft(i6, 24)) ^ i6;
                    int i7 = i2 ^ rotateLeft;
                    int i8 = i4 ^ rotateLeft;
                    int[] iArr2 = this.k;
                    iArr2[0] = i ^ rotateLeft2;
                    iArr2[1] = i7;
                    iArr2[2] = i3 ^ rotateLeft2;
                    iArr2[3] = i8;
                }
                this._forEncryption = z;
                this._initialised = true;
                return;
            }
            throw new IllegalArgumentException("Key length not 128 bits.");
        }
        throw new IllegalArgumentException("invalid parameter passed to Noekeon init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (!this._initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i > bArr.length - 16) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 <= bArr2.length - 16) {
            return this._forEncryption ? encryptBlock(bArr, i, bArr2, i2) : decryptBlock(bArr, i, bArr2, i2);
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
