package com.amazonaws.services.s3.internal.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

@Deprecated
class AesGcm extends ContentCryptoScheme {
    private static final int DEFAULT_BLOCK_SIZE_IN_BYTES = 16;
    private static final int DEFAULT_IV_LENGTH_IN_BYTES = 12;
    private static final int DEFAULT_KEY_LENGTH_IN_BITS = 256;
    private static final int DEFAULT_TAG_LENGTH_IN_BITS = 128;

    /* access modifiers changed from: package-private */
    public int getBlockSizeInBytes() {
        return 16;
    }

    /* access modifiers changed from: package-private */
    public String getCipherAlgorithm() {
        return "AES/GCM/NoPadding";
    }

    /* access modifiers changed from: package-private */
    public int getIVLengthInBytes() {
        return 12;
    }

    /* access modifiers changed from: package-private */
    public String getKeyGeneratorAlgorithm() {
        return JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM;
    }

    /* access modifiers changed from: package-private */
    public int getKeyLengthInBits() {
        return 256;
    }

    /* access modifiers changed from: package-private */
    public long getMaxPlaintextSize() {
        return 68719476704L;
    }

    /* access modifiers changed from: package-private */
    public String getSpecificCipherProvider() {
        return "BC";
    }

    /* access modifiers changed from: package-private */
    public int getTagLengthInBits() {
        return 128;
    }

    AesGcm() {
    }

    /* access modifiers changed from: package-private */
    public CipherLite createAuxillaryCipher(SecretKey secretKey, byte[] bArr, int i, Provider provider, long j) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        return AES_CTR.createCipherLite(secretKey, AES_CTR.adjustIV(bArr, j), i, provider);
    }

    /* access modifiers changed from: protected */
    public CipherLite newCipherLite(Cipher cipher, SecretKey secretKey, int i) {
        return new GCMCipherLite(cipher, secretKey, i);
    }
}
