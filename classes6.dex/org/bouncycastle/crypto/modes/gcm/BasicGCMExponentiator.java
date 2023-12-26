package org.bouncycastle.crypto.modes.gcm;

public class BasicGCMExponentiator implements GCMExponentiator {
    private long[] x;

    public void exponentiateX(long j, byte[] bArr) {
        long[] oneAsLongs = GCMUtil.oneAsLongs();
        if (j > 0) {
            long[] jArr = new long[2];
            GCMUtil.copy(this.x, jArr);
            do {
                if ((1 & j) != 0) {
                    GCMUtil.multiply(oneAsLongs, jArr);
                }
                GCMUtil.square(jArr, jArr);
                j >>>= 1;
            } while (j > 0);
        }
        GCMUtil.asBytes(oneAsLongs, bArr);
    }

    public void init(byte[] bArr) {
        this.x = GCMUtil.asLongs(bArr);
    }
}
