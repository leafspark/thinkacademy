package com.amazonaws.services.s3.internal.crypto;

@Deprecated
class AesCtr extends ContentCryptoScheme {
    private static final int DEFAULT_IV_LENGTH_IN_BYTES = 16;
    private static final int SUPPORTED_IV_LENGTH = 12;

    /* access modifiers changed from: package-private */
    public String getCipherAlgorithm() {
        return "AES/CTR/NoPadding";
    }

    /* access modifiers changed from: package-private */
    public int getIVLengthInBytes() {
        return 16;
    }

    /* access modifiers changed from: package-private */
    public long getMaxPlaintextSize() {
        return -1;
    }

    AesCtr() {
    }

    /* access modifiers changed from: package-private */
    public String getKeyGeneratorAlgorithm() {
        return AES_GCM.getKeyGeneratorAlgorithm();
    }

    /* access modifiers changed from: package-private */
    public int getKeyLengthInBits() {
        return AES_GCM.getKeyLengthInBits();
    }

    /* access modifiers changed from: package-private */
    public int getBlockSizeInBytes() {
        return AES_GCM.getBlockSizeInBytes();
    }

    /* access modifiers changed from: package-private */
    public byte[] adjustIV(byte[] bArr, long j) {
        if (bArr.length == 12) {
            int blockSizeInBytes = getBlockSizeInBytes();
            long j2 = (long) blockSizeInBytes;
            long j3 = j / j2;
            if (j2 * j3 == j) {
                return incrementBlocks(computeJ0(bArr), j3);
            }
            throw new IllegalArgumentException("Expecting byteOffset to be multiple of 16, but got blockOffset=" + j3 + ", blockSize=" + blockSizeInBytes + ", byteOffset=" + j);
        }
        throw new UnsupportedOperationException();
    }

    private byte[] computeJ0(byte[] bArr) {
        int blockSizeInBytes = getBlockSizeInBytes();
        byte[] bArr2 = new byte[blockSizeInBytes];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        bArr2[blockSizeInBytes - 1] = 1;
        return incrementBlocks(bArr2, 1);
    }
}
