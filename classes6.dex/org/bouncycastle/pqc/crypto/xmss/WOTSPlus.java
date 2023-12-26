package org.bouncycastle.pqc.crypto.xmss;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.OTSHashAddress;
import org.bouncycastle.util.Arrays;

final class WOTSPlus {
    private final KeyedHashFunctions khf;
    private final WOTSPlusParameters params;
    private byte[] publicSeed;
    private byte[] secretKeySeed;

    WOTSPlus(WOTSPlusParameters wOTSPlusParameters) {
        Objects.requireNonNull(wOTSPlusParameters, "params == null");
        this.params = wOTSPlusParameters;
        int treeDigestSize = wOTSPlusParameters.getTreeDigestSize();
        this.khf = new KeyedHashFunctions(wOTSPlusParameters.getTreeDigest(), treeDigestSize);
        this.secretKeySeed = new byte[treeDigestSize];
        this.publicSeed = new byte[treeDigestSize];
    }

    private byte[] chain(byte[] bArr, int i, int i2, OTSHashAddress oTSHashAddress) {
        int treeDigestSize = this.params.getTreeDigestSize();
        Objects.requireNonNull(bArr, "startHash == null");
        if (bArr.length == treeDigestSize) {
            Objects.requireNonNull(oTSHashAddress, "otsHashAddress == null");
            Objects.requireNonNull(oTSHashAddress.toByteArray(), "otsHashAddress byte array == null");
            int i3 = i + i2;
            if (i3 > this.params.getWinternitzParameter() - 1) {
                throw new IllegalArgumentException("max chain length must not be greater than w");
            } else if (i2 == 0) {
                return bArr;
            } else {
                byte[] chain = chain(bArr, i, i2 - 1, oTSHashAddress);
                OTSHashAddress oTSHashAddress2 = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(oTSHashAddress.getOTSAddress()).withChainAddress(oTSHashAddress.getChainAddress()).withHashAddress(i3 - 1).withKeyAndMask(0)).build();
                byte[] PRF = this.khf.PRF(this.publicSeed, oTSHashAddress2.toByteArray());
                byte[] PRF2 = this.khf.PRF(this.publicSeed, ((OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress2.getLayerAddress())).withTreeAddress(oTSHashAddress2.getTreeAddress())).withOTSAddress(oTSHashAddress2.getOTSAddress()).withChainAddress(oTSHashAddress2.getChainAddress()).withHashAddress(oTSHashAddress2.getHashAddress()).withKeyAndMask(1)).build()).toByteArray());
                byte[] bArr2 = new byte[treeDigestSize];
                for (int i4 = 0; i4 < treeDigestSize; i4++) {
                    bArr2[i4] = (byte) (chain[i4] ^ PRF2[i4]);
                }
                return this.khf.F(PRF, bArr2);
            }
        } else {
            throw new IllegalArgumentException("startHash needs to be " + treeDigestSize + "bytes");
        }
    }

    private List<Integer> convertToBaseW(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "msg == null");
        if (i == 4 || i == 16) {
            int log2 = XMSSUtil.log2(i);
            if (i2 <= (bArr.length * 8) / log2) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    for (int i4 = 8 - log2; i4 >= 0; i4 -= log2) {
                        arrayList.add(Integer.valueOf((bArr[i3] >> i4) & (i - 1)));
                        if (arrayList.size() == i2) {
                            return arrayList;
                        }
                    }
                }
                return arrayList;
            }
            throw new IllegalArgumentException("outLength too big");
        }
        throw new IllegalArgumentException("w needs to be 4 or 16");
    }

    private byte[] expandSecretKeySeed(int i) {
        if (i >= 0 && i < this.params.getLen()) {
            return this.khf.PRF(this.secretKeySeed, XMSSUtil.toBytesBigEndian((long) i, 32));
        }
        throw new IllegalArgumentException("index out of bounds");
    }

    /* access modifiers changed from: protected */
    public KeyedHashFunctions getKhf() {
        return this.khf;
    }

    /* access modifiers changed from: protected */
    public WOTSPlusParameters getParams() {
        return this.params;
    }

    /* access modifiers changed from: protected */
    public WOTSPlusPrivateKeyParameters getPrivateKey() {
        int len = this.params.getLen();
        byte[][] bArr = new byte[len][];
        for (int i = 0; i < len; i++) {
            bArr[i] = expandSecretKeySeed(i);
        }
        return new WOTSPlusPrivateKeyParameters(this.params, bArr);
    }

    /* access modifiers changed from: package-private */
    public WOTSPlusPublicKeyParameters getPublicKey(OTSHashAddress oTSHashAddress) {
        Objects.requireNonNull(oTSHashAddress, "otsHashAddress == null");
        byte[][] bArr = new byte[this.params.getLen()][];
        for (int i = 0; i < this.params.getLen(); i++) {
            oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(oTSHashAddress.getOTSAddress()).withChainAddress(i).withHashAddress(oTSHashAddress.getHashAddress()).withKeyAndMask(oTSHashAddress.getKeyAndMask())).build();
            bArr[i] = chain(expandSecretKeySeed(i), 0, this.params.getWinternitzParameter() - 1, oTSHashAddress);
        }
        return new WOTSPlusPublicKeyParameters(this.params, bArr);
    }

    /* access modifiers changed from: package-private */
    public WOTSPlusPublicKeyParameters getPublicKeyFromSignature(byte[] bArr, WOTSPlusSignature wOTSPlusSignature, OTSHashAddress oTSHashAddress) {
        Objects.requireNonNull(bArr, "messageDigest == null");
        if (bArr.length == this.params.getTreeDigestSize()) {
            Objects.requireNonNull(wOTSPlusSignature, "signature == null");
            Objects.requireNonNull(oTSHashAddress, "otsHashAddress == null");
            List<Integer> convertToBaseW = convertToBaseW(bArr, this.params.getWinternitzParameter(), this.params.getLen1());
            int i = 0;
            for (int i2 = 0; i2 < this.params.getLen1(); i2++) {
                i += (this.params.getWinternitzParameter() - 1) - convertToBaseW.get(i2).intValue();
            }
            convertToBaseW.addAll(convertToBaseW(XMSSUtil.toBytesBigEndian((long) (i << (8 - ((this.params.getLen2() * XMSSUtil.log2(this.params.getWinternitzParameter())) % 8))), (int) Math.ceil(((double) (this.params.getLen2() * XMSSUtil.log2(this.params.getWinternitzParameter()))) / 8.0d)), this.params.getWinternitzParameter(), this.params.getLen2()));
            byte[][] bArr2 = new byte[this.params.getLen()][];
            for (int i3 = 0; i3 < this.params.getLen(); i3++) {
                oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(oTSHashAddress.getOTSAddress()).withChainAddress(i3).withHashAddress(oTSHashAddress.getHashAddress()).withKeyAndMask(oTSHashAddress.getKeyAndMask())).build();
                bArr2[i3] = chain(wOTSPlusSignature.toByteArray()[i3], convertToBaseW.get(i3).intValue(), (this.params.getWinternitzParameter() - 1) - convertToBaseW.get(i3).intValue(), oTSHashAddress);
            }
            return new WOTSPlusPublicKeyParameters(this.params, bArr2);
        }
        throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
    }

    /* access modifiers changed from: protected */
    public byte[] getPublicSeed() {
        return Arrays.clone(this.publicSeed);
    }

    /* access modifiers changed from: protected */
    public byte[] getSecretKeySeed() {
        return Arrays.clone(this.secretKeySeed);
    }

    /* access modifiers changed from: protected */
    public byte[] getWOTSPlusSecretKey(byte[] bArr, OTSHashAddress oTSHashAddress) {
        return this.khf.PRF(bArr, ((OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(oTSHashAddress.getOTSAddress()).build()).toByteArray());
    }

    /* access modifiers changed from: package-private */
    public void importKeys(byte[] bArr, byte[] bArr2) {
        Objects.requireNonNull(bArr, "secretKeySeed == null");
        if (bArr.length == this.params.getTreeDigestSize()) {
            Objects.requireNonNull(bArr2, "publicSeed == null");
            if (bArr2.length == this.params.getTreeDigestSize()) {
                this.secretKeySeed = bArr;
                this.publicSeed = bArr2;
                return;
            }
            throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
        }
        throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
    }

    /* access modifiers changed from: package-private */
    public WOTSPlusSignature sign(byte[] bArr, OTSHashAddress oTSHashAddress) {
        Objects.requireNonNull(bArr, "messageDigest == null");
        if (bArr.length == this.params.getTreeDigestSize()) {
            Objects.requireNonNull(oTSHashAddress, "otsHashAddress == null");
            List<Integer> convertToBaseW = convertToBaseW(bArr, this.params.getWinternitzParameter(), this.params.getLen1());
            int i = 0;
            for (int i2 = 0; i2 < this.params.getLen1(); i2++) {
                i += (this.params.getWinternitzParameter() - 1) - convertToBaseW.get(i2).intValue();
            }
            convertToBaseW.addAll(convertToBaseW(XMSSUtil.toBytesBigEndian((long) (i << (8 - ((this.params.getLen2() * XMSSUtil.log2(this.params.getWinternitzParameter())) % 8))), (int) Math.ceil(((double) (this.params.getLen2() * XMSSUtil.log2(this.params.getWinternitzParameter()))) / 8.0d)), this.params.getWinternitzParameter(), this.params.getLen2()));
            byte[][] bArr2 = new byte[this.params.getLen()][];
            for (int i3 = 0; i3 < this.params.getLen(); i3++) {
                oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(oTSHashAddress.getOTSAddress()).withChainAddress(i3).withHashAddress(oTSHashAddress.getHashAddress()).withKeyAndMask(oTSHashAddress.getKeyAndMask())).build();
                bArr2[i3] = chain(expandSecretKeySeed(i3), 0, convertToBaseW.get(i3).intValue(), oTSHashAddress);
            }
            return new WOTSPlusSignature(this.params, bArr2);
        }
        throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
    }
}
