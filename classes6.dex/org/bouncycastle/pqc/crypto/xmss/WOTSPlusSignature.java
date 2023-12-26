package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;

final class WOTSPlusSignature {
    private byte[][] signature;

    protected WOTSPlusSignature(WOTSPlusParameters wOTSPlusParameters, byte[][] bArr) {
        Objects.requireNonNull(wOTSPlusParameters, "params == null");
        Objects.requireNonNull(bArr, "signature == null");
        if (XMSSUtil.hasNullPointer(bArr)) {
            throw new NullPointerException("signature byte array == null");
        } else if (bArr.length == wOTSPlusParameters.getLen()) {
            int i = 0;
            while (i < bArr.length) {
                if (bArr[i].length == wOTSPlusParameters.getTreeDigestSize()) {
                    i++;
                } else {
                    throw new IllegalArgumentException("wrong signature format");
                }
            }
            this.signature = XMSSUtil.cloneArray(bArr);
        } else {
            throw new IllegalArgumentException("wrong signature size");
        }
    }

    public byte[][] toByteArray() {
        return XMSSUtil.cloneArray(this.signature);
    }
}
