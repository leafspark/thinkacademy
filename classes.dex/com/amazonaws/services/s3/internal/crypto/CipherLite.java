package com.amazonaws.services.s3.internal.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.NullCipher;
import javax.crypto.SecretKey;

@Deprecated
class CipherLite {
    static final CipherLite NULL = new CipherLite() {
        /* access modifiers changed from: package-private */
        public CipherLite createAuxiliary(long j) {
            return this;
        }

        /* access modifiers changed from: package-private */
        public CipherLite createInverse() {
            return this;
        }
    };
    private final Cipher cipher;
    private final int cipherMode;
    private final ContentCryptoScheme scheme;
    private final SecretKey secreteKey;

    /* access modifiers changed from: package-private */
    public long mark() {
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean markSupported() {
        return false;
    }

    private CipherLite() {
        this.cipher = new NullCipher();
        this.scheme = null;
        this.secreteKey = null;
        this.cipherMode = -1;
    }

    CipherLite(Cipher cipher2, ContentCryptoScheme contentCryptoScheme, SecretKey secretKey, int i) {
        this.cipher = cipher2;
        this.scheme = contentCryptoScheme;
        this.secreteKey = secretKey;
        this.cipherMode = i;
    }

    /* access modifiers changed from: package-private */
    public CipherLite recreate() {
        return this.scheme.createCipherLite(this.secreteKey, this.cipher.getIV(), this.cipherMode, this.cipher.getProvider());
    }

    /* access modifiers changed from: package-private */
    public CipherLite createUsingIV(byte[] bArr) {
        return this.scheme.createCipherLite(this.secreteKey, bArr, this.cipherMode, this.cipher.getProvider());
    }

    /* access modifiers changed from: package-private */
    public CipherLite createAuxiliary(long j) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        return this.scheme.createAuxillaryCipher(this.secreteKey, this.cipher.getIV(), this.cipherMode, this.cipher.getProvider(), j);
    }

    /* access modifiers changed from: package-private */
    public CipherLite createInverse() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        int i = this.cipherMode;
        int i2 = 1;
        if (i != 2) {
            if (i == 1) {
                i2 = 2;
            } else {
                throw new UnsupportedOperationException();
            }
        }
        return this.scheme.createCipherLite(this.secreteKey, this.cipher.getIV(), i2, this.cipher.getProvider());
    }

    /* access modifiers changed from: package-private */
    public byte[] doFinal() throws IllegalBlockSizeException, BadPaddingException {
        return this.cipher.doFinal();
    }

    /* access modifiers changed from: package-private */
    public byte[] doFinal(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException {
        return this.cipher.doFinal(bArr);
    }

    /* access modifiers changed from: package-private */
    public byte[] doFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        return this.cipher.doFinal(bArr, i, i2);
    }

    /* access modifiers changed from: package-private */
    public byte[] update(byte[] bArr, int i, int i2) {
        return this.cipher.update(bArr, i, i2);
    }

    /* access modifiers changed from: package-private */
    public final String getCipherAlgorithm() {
        return this.cipher.getAlgorithm();
    }

    /* access modifiers changed from: package-private */
    public final Provider getCipherProvider() {
        return this.cipher.getProvider();
    }

    /* access modifiers changed from: package-private */
    public final String getSecretKeyAlgorithm() {
        return this.secreteKey.getAlgorithm();
    }

    /* access modifiers changed from: package-private */
    public final Cipher getCipher() {
        return this.cipher;
    }

    /* access modifiers changed from: package-private */
    public final ContentCryptoScheme getContentCryptoScheme() {
        return this.scheme;
    }

    /* access modifiers changed from: package-private */
    public final byte[] getIV() {
        return this.cipher.getIV();
    }

    /* access modifiers changed from: package-private */
    public final int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    /* access modifiers changed from: package-private */
    public final int getCipherMode() {
        return this.cipherMode;
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        throw new IllegalStateException("mark/reset not supported");
    }

    /* access modifiers changed from: package-private */
    public int getOutputSize(int i) {
        return this.cipher.getOutputSize(i);
    }
}
