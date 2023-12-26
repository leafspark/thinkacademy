package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Integers;

public final class XMSSParameters {
    private static final Map<Integer, XMSSParameters> paramsLookupTable;
    private final int height;
    private final int k;
    private final XMSSOid oid;
    private final String treeDigest;
    private final ASN1ObjectIdentifier treeDigestOID;
    private final int treeDigestSize;
    private final int winternitzParameter;
    private final WOTSPlusParameters wotsPlusParams;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Integers.valueOf(1), new XMSSParameters(10, NISTObjectIdentifiers.id_sha256));
        hashMap.put(Integers.valueOf(2), new XMSSParameters(16, NISTObjectIdentifiers.id_sha256));
        hashMap.put(Integers.valueOf(3), new XMSSParameters(20, NISTObjectIdentifiers.id_sha256));
        hashMap.put(Integers.valueOf(4), new XMSSParameters(10, NISTObjectIdentifiers.id_sha512));
        hashMap.put(Integers.valueOf(5), new XMSSParameters(16, NISTObjectIdentifiers.id_sha512));
        hashMap.put(Integers.valueOf(6), new XMSSParameters(20, NISTObjectIdentifiers.id_sha512));
        hashMap.put(Integers.valueOf(7), new XMSSParameters(10, NISTObjectIdentifiers.id_shake128));
        hashMap.put(Integers.valueOf(8), new XMSSParameters(16, NISTObjectIdentifiers.id_shake128));
        hashMap.put(Integers.valueOf(9), new XMSSParameters(20, NISTObjectIdentifiers.id_shake128));
        hashMap.put(Integers.valueOf(10), new XMSSParameters(10, NISTObjectIdentifiers.id_shake256));
        hashMap.put(Integers.valueOf(11), new XMSSParameters(16, NISTObjectIdentifiers.id_shake256));
        hashMap.put(Integers.valueOf(12), new XMSSParameters(20, NISTObjectIdentifiers.id_shake256));
        paramsLookupTable = Collections.unmodifiableMap(hashMap);
    }

    public XMSSParameters(int i, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (i >= 2) {
            Objects.requireNonNull(aSN1ObjectIdentifier, "digest == null");
            this.height = i;
            this.k = determineMinK();
            String digestName = DigestUtil.getDigestName(aSN1ObjectIdentifier);
            this.treeDigest = digestName;
            this.treeDigestOID = aSN1ObjectIdentifier;
            WOTSPlusParameters wOTSPlusParameters = new WOTSPlusParameters(aSN1ObjectIdentifier);
            this.wotsPlusParams = wOTSPlusParameters;
            int treeDigestSize2 = wOTSPlusParameters.getTreeDigestSize();
            this.treeDigestSize = treeDigestSize2;
            int winternitzParameter2 = wOTSPlusParameters.getWinternitzParameter();
            this.winternitzParameter = winternitzParameter2;
            this.oid = DefaultXMSSOid.lookup(digestName, treeDigestSize2, winternitzParameter2, wOTSPlusParameters.getLen(), i);
            return;
        }
        throw new IllegalArgumentException("height must be >= 2");
    }

    public XMSSParameters(int i, Digest digest) {
        this(i, DigestUtil.getDigestOID(digest.getAlgorithmName()));
    }

    private int determineMinK() {
        int i = 2;
        while (true) {
            int i2 = this.height;
            if (i > i2) {
                throw new IllegalStateException("should never happen...");
            } else if ((i2 - i) % 2 == 0) {
                return i;
            } else {
                i++;
            }
        }
    }

    public static XMSSParameters lookupByOID(int i) {
        return paramsLookupTable.get(Integers.valueOf(i));
    }

    public int getHeight() {
        return this.height;
    }

    /* access modifiers changed from: package-private */
    public int getK() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public int getLen() {
        return this.wotsPlusParams.getLen();
    }

    /* access modifiers changed from: package-private */
    public XMSSOid getOid() {
        return this.oid;
    }

    /* access modifiers changed from: package-private */
    public String getTreeDigest() {
        return this.treeDigest;
    }

    public ASN1ObjectIdentifier getTreeDigestOID() {
        return this.treeDigestOID;
    }

    public int getTreeDigestSize() {
        return this.treeDigestSize;
    }

    /* access modifiers changed from: package-private */
    public WOTSPlus getWOTSPlus() {
        return new WOTSPlus(this.wotsPlusParams);
    }

    /* access modifiers changed from: package-private */
    public int getWinternitzParameter() {
        return this.winternitzParameter;
    }
}
