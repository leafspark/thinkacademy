package org.bouncycastle.jcajce.provider.digest;

import java.security.DigestException;
import java.security.MessageDigest;
import org.bouncycastle.crypto.Digest;

public class BCMessageDigest extends MessageDigest {
    protected Digest digest;
    protected int digestSize;

    protected BCMessageDigest(Digest digest2) {
        super(digest2.getAlgorithmName());
        this.digest = digest2;
        this.digestSize = digest2.getDigestSize();
    }

    public int engineDigest(byte[] bArr, int i, int i2) throws DigestException {
        int i3 = this.digestSize;
        if (i2 < i3) {
            throw new DigestException("partial digests not returned");
        } else if (bArr.length - i >= i3) {
            this.digest.doFinal(bArr, i);
            return this.digestSize;
        } else {
            throw new DigestException("insufficient space in the output buffer to store the digest");
        }
    }

    public byte[] engineDigest() {
        byte[] bArr = new byte[this.digestSize];
        this.digest.doFinal(bArr, 0);
        return bArr;
    }

    public int engineGetDigestLength() {
        return this.digestSize;
    }

    public void engineReset() {
        this.digest.reset();
    }

    public void engineUpdate(byte b) {
        this.digest.update(b);
    }

    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
    }
}
