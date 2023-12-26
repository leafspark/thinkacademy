package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.digests.Blake3Digest;
import org.bouncycastle.crypto.params.Blake3Parameters;
import org.bouncycastle.crypto.params.KeyParameter;

public class Blake3Mac implements Mac {
    private final Blake3Digest theDigest;

    public Blake3Mac(Blake3Digest blake3Digest) {
        this.theDigest = blake3Digest;
    }

    public int doFinal(byte[] bArr, int i) {
        return this.theDigest.doFinal(bArr, i);
    }

    public String getAlgorithmName() {
        return this.theDigest.getAlgorithmName() + "Mac";
    }

    public int getMacSize() {
        return this.theDigest.getDigestSize();
    }

    public void init(CipherParameters cipherParameters) {
        CipherParameters key = cipherParameters instanceof KeyParameter ? Blake3Parameters.key(((KeyParameter) cipherParameters).getKey()) : cipherParameters;
        if (key instanceof Blake3Parameters) {
            Blake3Parameters blake3Parameters = (Blake3Parameters) key;
            if (blake3Parameters.getKey() != null) {
                this.theDigest.init(blake3Parameters);
                return;
            }
            throw new IllegalArgumentException("Blake3Mac requires a key parameter.");
        }
        throw new IllegalArgumentException("Invalid parameter passed to Blake3Mac init - " + cipherParameters.getClass().getName());
    }

    public void reset() {
        this.theDigest.reset();
    }

    public void update(byte b) {
        this.theDigest.update(b);
    }

    public void update(byte[] bArr, int i, int i2) {
        this.theDigest.update(bArr, i, i2);
    }
}
