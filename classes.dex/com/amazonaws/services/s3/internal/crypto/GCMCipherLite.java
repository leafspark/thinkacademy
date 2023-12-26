package com.amazonaws.services.s3.internal.crypto;

import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;

@Deprecated
final class GCMCipherLite extends CipherLite {
    private static final int BITS = 8;
    private static final int TAG_LENGTH = (ContentCryptoScheme.AES_GCM.getTagLengthInBits() / 8);
    private CipherLite aux;
    private long currentCount;
    private boolean doneFinal;
    private byte[] finalBytes;
    private boolean invisiblyProcessed;
    private long markedCount;
    private long outputByteCount;
    private boolean securityViolated;
    private final int tagLen;

    /* access modifiers changed from: package-private */
    public boolean markSupported() {
        return true;
    }

    GCMCipherLite(Cipher cipher, SecretKey secretKey, int i) {
        super(cipher, ContentCryptoScheme.AES_GCM, secretKey, i);
        this.tagLen = i == 1 ? TAG_LENGTH : 0;
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException();
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] doFinal() throws IllegalBlockSizeException, BadPaddingException {
        if (!this.doneFinal) {
            this.doneFinal = true;
            byte[] doFinal = super.doFinal();
            this.finalBytes = doFinal;
            if (doFinal == null) {
                return null;
            }
            this.outputByteCount += (long) checkMax(doFinal.length - this.tagLen);
            return (byte[]) this.finalBytes.clone();
        } else if (!this.securityViolated) {
            byte[] bArr = this.finalBytes;
            if (bArr == null) {
                return null;
            }
            return (byte[]) bArr.clone();
        } else {
            throw new SecurityException();
        }
    }

    /* access modifiers changed from: package-private */
    public final byte[] doFinal(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException {
        return doFinal0(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: package-private */
    public final byte[] doFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        return doFinal0(bArr, i, i2);
    }

    private final byte[] doFinal0(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        if (!this.doneFinal) {
            this.doneFinal = true;
            byte[] doFinal = super.doFinal(bArr, i, i2);
            this.finalBytes = doFinal;
            if (doFinal == null) {
                return null;
            }
            this.outputByteCount += (long) checkMax(doFinal.length - this.tagLen);
            return (byte[]) this.finalBytes.clone();
        } else if (this.securityViolated) {
            throw new SecurityException();
        } else if (2 == getCipherMode()) {
            byte[] bArr2 = this.finalBytes;
            if (bArr2 == null) {
                return null;
            }
            return (byte[]) bArr2.clone();
        } else {
            byte[] bArr3 = this.finalBytes;
            int length = bArr3.length;
            int i3 = this.tagLen;
            int i4 = length - i3;
            if (i2 == i4) {
                return (byte[]) bArr3.clone();
            }
            if (i2 < i4 && ((long) i2) + this.currentCount == this.outputByteCount) {
                return Arrays.copyOfRange(bArr3, (bArr3.length - i3) - i2, bArr3.length);
            }
            throw new IllegalStateException("Inconsistent re-rencryption");
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] update(byte[] bArr, int i, int i2) {
        byte[] bArr2;
        CipherLite cipherLite = this.aux;
        boolean z = true;
        int i3 = 0;
        if (cipherLite == null) {
            bArr2 = super.update(bArr, i, i2);
            if (bArr2 == null) {
                if (bArr.length <= 0) {
                    z = false;
                }
                this.invisiblyProcessed = z;
                return null;
            }
            this.outputByteCount += (long) checkMax(bArr2.length);
            if (bArr2.length != 0 || i2 <= 0) {
                z = false;
            }
            this.invisiblyProcessed = z;
        } else {
            bArr2 = cipherLite.update(bArr, i, i2);
            if (bArr2 == null) {
                return null;
            }
            long length = this.currentCount + ((long) bArr2.length);
            this.currentCount = length;
            long j = this.outputByteCount;
            if (length == j) {
                this.aux = null;
            } else if (length > j) {
                if (1 != getCipherMode()) {
                    byte[] bArr3 = this.finalBytes;
                    if (bArr3 != null) {
                        i3 = bArr3.length;
                    }
                    long j2 = this.outputByteCount;
                    long j3 = (long) i3;
                    this.currentCount = j2 - j3;
                    this.aux = null;
                    return Arrays.copyOf(bArr2, (int) ((j2 - (this.currentCount - ((long) bArr2.length))) - j3));
                }
                throw new IllegalStateException("currentCount=" + this.currentCount + " > outputByteCount=" + this.outputByteCount);
            }
        }
        return bArr2;
    }

    private int checkMax(int i) {
        if (this.outputByteCount + ((long) i) <= 68719476704L) {
            return i;
        }
        this.securityViolated = true;
        throw new SecurityException("Number of bytes processed has exceeded the maximum allowed by AES/GCM; [outputByteCount=" + this.outputByteCount + ", delta=" + i + "]");
    }

    /* access modifiers changed from: package-private */
    public long mark() {
        long j = this.aux == null ? this.outputByteCount : this.currentCount;
        this.markedCount = j;
        return j;
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        long j = this.markedCount;
        if (j < this.outputByteCount || this.invisiblyProcessed) {
            try {
                this.aux = createAuxiliary(j);
                this.currentCount = this.markedCount;
            } catch (Exception e) {
                throw (e instanceof RuntimeException ? (RuntimeException) e : new IllegalStateException(e));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] getFinalBytes() {
        byte[] bArr = this.finalBytes;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    /* access modifiers changed from: package-private */
    public byte[] getTag() {
        byte[] bArr;
        if (getCipherMode() != 1 || (bArr = this.finalBytes) == null) {
            return null;
        }
        return Arrays.copyOfRange(bArr, bArr.length - this.tagLen, bArr.length);
    }

    /* access modifiers changed from: package-private */
    public long getOutputByteCount() {
        return this.outputByteCount;
    }

    /* access modifiers changed from: package-private */
    public long getCurrentCount() {
        return this.currentCount;
    }

    /* access modifiers changed from: package-private */
    public long getMarkedCount() {
        return this.markedCount;
    }
}
