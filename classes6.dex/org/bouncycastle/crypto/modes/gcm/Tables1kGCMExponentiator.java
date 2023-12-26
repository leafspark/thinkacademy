package org.bouncycastle.crypto.modes.gcm;

import java.util.Vector;

public class Tables1kGCMExponentiator implements GCMExponentiator {
    private Vector lookupPowX2;

    private void ensureAvailable(int i) {
        int size = this.lookupPowX2.size() - 1;
        if (size < i) {
            long[] jArr = (long[]) this.lookupPowX2.elementAt(size);
            while (true) {
                long[] jArr2 = new long[2];
                GCMUtil.square(jArr, jArr2);
                this.lookupPowX2.addElement(jArr2);
                size++;
                if (size < i) {
                    jArr = jArr2;
                } else {
                    return;
                }
            }
        }
    }

    public void exponentiateX(long j, byte[] bArr) {
        long[] oneAsLongs = GCMUtil.oneAsLongs();
        int i = 0;
        while (j > 0) {
            if ((1 & j) != 0) {
                ensureAvailable(i);
                GCMUtil.multiply(oneAsLongs, (long[]) this.lookupPowX2.elementAt(i));
            }
            i++;
            j >>>= 1;
        }
        GCMUtil.asBytes(oneAsLongs, bArr);
    }

    public void init(byte[] bArr) {
        long[] asLongs = GCMUtil.asLongs(bArr);
        Vector vector = this.lookupPowX2;
        if (vector == null || 0 == GCMUtil.areEqual(asLongs, (long[]) vector.elementAt(0))) {
            Vector vector2 = new Vector(8);
            this.lookupPowX2 = vector2;
            vector2.addElement(asLongs);
        }
    }
}
