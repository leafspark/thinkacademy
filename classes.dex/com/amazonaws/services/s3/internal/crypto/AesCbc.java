package com.amazonaws.services.s3.internal.crypto;

@Deprecated
class AesCbc extends ContentCryptoScheme {
    private static final int DEFAULT_BLOCK_SIZE_IN_BYTES = 16;
    private static final int DEFAULT_IV_LENGTH_IN_BYTES = 16;
    private static final int DEFAULT_KEY_LENGTH_IN_BITS = 256;

    /* access modifiers changed from: package-private */
    public int getBlockSizeInBytes() {
        return 16;
    }

    /* access modifiers changed from: package-private */
    public String getCipherAlgorithm() {
        return JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD;
    }

    /* access modifiers changed from: package-private */
    public int getIVLengthInBytes() {
        return 16;
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
        return 4503599627370496L;
    }

    AesCbc() {
    }
}
