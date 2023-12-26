package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;

final class WOTSPlusPrivateKeyParameters {
    private final byte[][] privateKey;

    protected WOTSPlusPrivateKeyParameters(WOTSPlusParameters wOTSPlusParameters, byte[][] bArr) {
        Objects.requireNonNull(wOTSPlusParameters, "params == null");
        Objects.requireNonNull(bArr, "privateKey == null");
        if (XMSSUtil.hasNullPointer(bArr)) {
            throw new NullPointerException("privateKey byte array == null");
        } else if (bArr.length == wOTSPlusParameters.getLen()) {
            int i = 0;
            while (i < bArr.length) {
                if (bArr[i].length == wOTSPlusParameters.getTreeDigestSize()) {
                    i++;
                } else {
                    throw new IllegalArgumentException("wrong privateKey format");
                }
            }
            this.privateKey = XMSSUtil.cloneArray(bArr);
        } else {
            throw new IllegalArgumentException("wrong privateKey format");
        }
    }

    /* access modifiers changed from: protected */
    public byte[][] toByteArray() {
        return XMSSUtil.cloneArray(this.privateKey);
    }
}
