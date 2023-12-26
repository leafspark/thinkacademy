package org.bouncycastle.pqc.crypto.lms;

import java.util.Objects;
import org.bouncycastle.crypto.Digest;

class LmsUtils {
    LmsUtils() {
    }

    static void byteArray(byte[] bArr, int i, int i2, Digest digest) {
        digest.update(bArr, i, i2);
    }

    static void byteArray(byte[] bArr, Digest digest) {
        digest.update(bArr, 0, bArr.length);
    }

    static int calculateStrength(LMSParameters lMSParameters) {
        Objects.requireNonNull(lMSParameters, "lmsParameters cannot be null");
        LMSigParameters lMSigParam = lMSParameters.getLMSigParam();
        return (1 << lMSigParam.getH()) * lMSigParam.getM();
    }

    static void u16str(short s, Digest digest) {
        digest.update((byte) (s >>> 8));
        digest.update((byte) s);
    }

    static void u32str(int i, Digest digest) {
        digest.update((byte) (i >>> 24));
        digest.update((byte) (i >>> 16));
        digest.update((byte) (i >>> 8));
        digest.update((byte) i);
    }
}
