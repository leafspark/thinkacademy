package org.bouncycastle.pqc.crypto.lms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.bouncycastle.util.Encodable;

public class HSSPrivateKeyParameters extends LMSKeyParameters implements LMSContextBasedSigner {
    private long index = 0;
    private final long indexLimit;
    private final boolean isShard;
    private List<LMSPrivateKeyParameters> keys;
    private final int l;
    private HSSPublicKeyParameters publicKey;
    private List<LMSSignature> sig;

    public HSSPrivateKeyParameters(int i, List<LMSPrivateKeyParameters> list, List<LMSSignature> list2, long j, long j2) {
        super(true);
        this.l = i;
        this.keys = Collections.unmodifiableList(list);
        this.sig = Collections.unmodifiableList(list2);
        this.index = j;
        this.indexLimit = j2;
        this.isShard = false;
        resetKeyToIndex();
    }

    private HSSPrivateKeyParameters(int i, List<LMSPrivateKeyParameters> list, List<LMSSignature> list2, long j, long j2, boolean z) {
        super(true);
        this.l = i;
        this.keys = Collections.unmodifiableList(list);
        this.sig = Collections.unmodifiableList(list2);
        this.index = j;
        this.indexLimit = j2;
        this.isShard = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters getInstance(java.lang.Object r11) throws java.io.IOException {
        /*
            boolean r0 = r11 instanceof org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters
            if (r0 == 0) goto L_0x0007
            org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters r11 = (org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters) r11
            return r11
        L_0x0007:
            boolean r0 = r11 instanceof java.io.DataInputStream
            if (r0 == 0) goto L_0x0059
            r0 = r11
            java.io.DataInputStream r0 = (java.io.DataInputStream) r0
            int r1 = r0.readInt()
            if (r1 != 0) goto L_0x0051
            int r3 = r0.readInt()
            long r6 = r0.readLong()
            long r8 = r0.readLong()
            boolean r10 = r0.readBoolean()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r0 = 0
            r1 = r0
        L_0x0030:
            if (r1 >= r3) goto L_0x003c
            org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters r2 = org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters.getInstance(r11)
            r4.add(r2)
            int r1 = r1 + 1
            goto L_0x0030
        L_0x003c:
            int r1 = r3 + -1
            if (r0 >= r1) goto L_0x004a
            org.bouncycastle.pqc.crypto.lms.LMSSignature r1 = org.bouncycastle.pqc.crypto.lms.LMSSignature.getInstance(r11)
            r5.add(r1)
            int r0 = r0 + 1
            goto L_0x003c
        L_0x004a:
            org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters r11 = new org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r8, r10)
            return r11
        L_0x0051:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "unknown version for hss private key"
            r11.<init>(r0)
            throw r11
        L_0x0059:
            boolean r0 = r11 instanceof byte[]
            if (r0 == 0) goto L_0x007e
            r0 = 0
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch:{ all -> 0x0077 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0077 }
            byte[] r11 = (byte[]) r11     // Catch:{ all -> 0x0077 }
            byte[] r11 = (byte[]) r11     // Catch:{ all -> 0x0077 }
            r2.<init>(r11)     // Catch:{ all -> 0x0077 }
            r1.<init>(r2)     // Catch:{ all -> 0x0077 }
            org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters r11 = getInstance(r1)     // Catch:{ all -> 0x0074 }
            r1.close()
            return r11
        L_0x0074:
            r11 = move-exception
            r0 = r1
            goto L_0x0078
        L_0x0077:
            r11 = move-exception
        L_0x0078:
            if (r0 == 0) goto L_0x007d
            r0.close()
        L_0x007d:
            throw r11
        L_0x007e:
            boolean r0 = r11 instanceof java.io.InputStream
            if (r0 == 0) goto L_0x008d
            java.io.InputStream r11 = (java.io.InputStream) r11
            byte[] r11 = org.bouncycastle.util.io.Streams.readAll(r11)
            org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters r11 = getInstance(r11)
            return r11
        L_0x008d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cannot parse "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters.getInstance(java.lang.Object):org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters");
    }

    public static HSSPrivateKeyParameters getInstance(byte[] bArr, byte[] bArr2) throws IOException {
        HSSPrivateKeyParameters instance = getInstance(bArr);
        instance.publicKey = HSSPublicKeyParameters.getInstance(bArr2);
        return instance;
    }

    private static HSSPrivateKeyParameters makeCopy(HSSPrivateKeyParameters hSSPrivateKeyParameters) {
        try {
            return getInstance(hSSPrivateKeyParameters.getEncoded());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        return makeCopy(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HSSPrivateKeyParameters hSSPrivateKeyParameters = (HSSPrivateKeyParameters) obj;
        if (this.l == hSSPrivateKeyParameters.l && this.isShard == hSSPrivateKeyParameters.isShard && this.indexLimit == hSSPrivateKeyParameters.indexLimit && this.index == hSSPrivateKeyParameters.index && this.keys.equals(hSSPrivateKeyParameters.keys)) {
            return this.sig.equals(hSSPrivateKeyParameters.sig);
        }
        return false;
    }

    public HSSPrivateKeyParameters extractKeyShard(int i) {
        HSSPrivateKeyParameters makeCopy;
        synchronized (this) {
            long j = (long) i;
            if (getUsagesRemaining() >= j) {
                long j2 = this.index;
                this.index = j + j2;
                ArrayList arrayList = new ArrayList(getKeys());
                ArrayList arrayList2 = new ArrayList(getSig());
                makeCopy = makeCopy(new HSSPrivateKeyParameters(this.l, arrayList, arrayList2, j2, j2 + j, true));
                resetKeyToIndex();
            } else {
                throw new IllegalArgumentException("usageCount exceeds usages remaining in current leaf");
            }
        }
        return makeCopy;
    }

    public LMSContext generateLMSContext() {
        LMSPrivateKeyParameters lMSPrivateKeyParameters;
        LMSSignedPubKey[] lMSSignedPubKeyArr;
        int l2 = getL();
        synchronized (this) {
            HSS.rangeTestKeys(this);
            List<LMSPrivateKeyParameters> keys2 = getKeys();
            List<LMSSignature> sig2 = getSig();
            int i = l2 - 1;
            lMSPrivateKeyParameters = getKeys().get(i);
            int i2 = 0;
            lMSSignedPubKeyArr = new LMSSignedPubKey[i];
            while (i2 < i) {
                int i3 = i2 + 1;
                lMSSignedPubKeyArr[i2] = new LMSSignedPubKey(sig2.get(i2), keys2.get(i3).getPublicKey());
                i2 = i3;
            }
            incIndex();
        }
        return lMSPrivateKeyParameters.generateLMSContext().withSignedPublicKeys(lMSSignedPubKeyArr);
    }

    public byte[] generateSignature(LMSContext lMSContext) {
        try {
            return HSS.generateSignature(getL(), lMSContext).getEncoded();
        } catch (IOException e) {
            throw new IllegalStateException("unable to encode signature: " + e.getMessage(), e);
        }
    }

    public synchronized byte[] getEncoded() throws IOException {
        Composer bool;
        bool = Composer.compose().u32str(0).u32str(this.l).u64str(this.index).u64str(this.indexLimit).bool(this.isShard);
        for (LMSPrivateKeyParameters bytes : this.keys) {
            bool.bytes((Encodable) bytes);
        }
        for (LMSSignature bytes2 : this.sig) {
            bool.bytes((Encodable) bytes2);
        }
        return bool.build();
    }

    public synchronized long getIndex() {
        return this.index;
    }

    /* access modifiers changed from: package-private */
    public long getIndexLimit() {
        return this.indexLimit;
    }

    /* access modifiers changed from: package-private */
    public synchronized List<LMSPrivateKeyParameters> getKeys() {
        return this.keys;
    }

    public int getL() {
        return this.l;
    }

    public synchronized LMSParameters[] getLMSParameters() {
        LMSParameters[] lMSParametersArr;
        int size = this.keys.size();
        lMSParametersArr = new LMSParameters[size];
        for (int i = 0; i < size; i++) {
            LMSPrivateKeyParameters lMSPrivateKeyParameters = this.keys.get(i);
            lMSParametersArr[i] = new LMSParameters(lMSPrivateKeyParameters.getSigParameters(), lMSPrivateKeyParameters.getOtsParameters());
        }
        return lMSParametersArr;
    }

    public synchronized HSSPublicKeyParameters getPublicKey() {
        return new HSSPublicKeyParameters(this.l, getRootKey().getPublicKey());
    }

    /* access modifiers changed from: package-private */
    public LMSPrivateKeyParameters getRootKey() {
        return this.keys.get(0);
    }

    /* access modifiers changed from: package-private */
    public synchronized List<LMSSignature> getSig() {
        return this.sig;
    }

    public long getUsagesRemaining() {
        return this.indexLimit - this.index;
    }

    public int hashCode() {
        long j = this.indexLimit;
        long j2 = this.index;
        return (((((((((this.l * 31) + (this.isShard ? 1 : 0)) * 31) + this.keys.hashCode()) * 31) + this.sig.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    /* access modifiers changed from: package-private */
    public synchronized void incIndex() {
        this.index++;
    }

    /* access modifiers changed from: package-private */
    public boolean isShard() {
        return this.isShard;
    }

    /* access modifiers changed from: package-private */
    public void replaceConsumedKey(int i) {
        int i2 = i - 1;
        SeedDerive derivationFunction = this.keys.get(i2).getCurrentOTSKey().getDerivationFunction();
        derivationFunction.setJ(-2);
        byte[] bArr = new byte[32];
        derivationFunction.deriveSeed(bArr, true);
        byte[] bArr2 = new byte[32];
        derivationFunction.deriveSeed(bArr2, false);
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr2, 0, bArr3, 0, 16);
        ArrayList arrayList = new ArrayList(this.keys);
        LMSPrivateKeyParameters lMSPrivateKeyParameters = this.keys.get(i);
        arrayList.set(i, LMS.generateKeys(lMSPrivateKeyParameters.getSigParameters(), lMSPrivateKeyParameters.getOtsParameters(), 0, bArr3, bArr));
        ArrayList arrayList2 = new ArrayList(this.sig);
        arrayList2.set(i2, LMS.generateSign((LMSPrivateKeyParameters) arrayList.get(i2), ((LMSPrivateKeyParameters) arrayList.get(i)).getPublicKey().toByteArray()));
        this.keys = Collections.unmodifiableList(arrayList);
        this.sig = Collections.unmodifiableList(arrayList2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00d1, code lost:
        if (r3[r9] == ((long) (r4[r9].getIndex() - 1))) goto L_0x00e1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0132  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void resetKeyToIndex() {
        /*
            r18 = this;
            r0 = r18
            java.util.List r1 = r18.getKeys()
            int r2 = r1.size()
            long[] r3 = new long[r2]
            long r4 = r18.getIndex()
            int r6 = r1.size()
            r7 = 1
            int r6 = r6 - r7
        L_0x0016:
            if (r6 < 0) goto L_0x0035
            java.lang.Object r8 = r1.get(r6)
            org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters r8 = (org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters) r8
            org.bouncycastle.pqc.crypto.lms.LMSigParameters r8 = r8.getSigParameters()
            int r9 = r8.getH()
            int r9 = r7 << r9
            int r9 = r9 - r7
            long r9 = (long) r9
            long r9 = r9 & r4
            r3[r6] = r9
            int r8 = r8.getH()
            long r4 = r4 >>> r8
            int r6 = r6 + -1
            goto L_0x0016
        L_0x0035:
            int r4 = r1.size()
            org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters[] r4 = new org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters[r4]
            java.lang.Object[] r4 = r1.toArray(r4)
            org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters[] r4 = (org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters[]) r4
            java.util.List<org.bouncycastle.pqc.crypto.lms.LMSSignature> r5 = r0.sig
            int r6 = r5.size()
            org.bouncycastle.pqc.crypto.lms.LMSSignature[] r6 = new org.bouncycastle.pqc.crypto.lms.LMSSignature[r6]
            java.lang.Object[] r5 = r5.toArray(r6)
            org.bouncycastle.pqc.crypto.lms.LMSSignature[] r5 = (org.bouncycastle.pqc.crypto.lms.LMSSignature[]) r5
            org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters r6 = r18.getRootKey()
            r8 = 0
            r9 = r4[r8]
            int r9 = r9.getIndex()
            int r9 = r9 - r7
            long r9 = (long) r9
            r11 = r3[r8]
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 == 0) goto L_0x007d
            org.bouncycastle.pqc.crypto.lms.LMSigParameters r9 = r6.getSigParameters()
            org.bouncycastle.pqc.crypto.lms.LMOtsParameters r10 = r6.getOtsParameters()
            r11 = r3[r8]
            int r11 = (int) r11
            byte[] r12 = r6.getI()
            byte[] r6 = r6.getMasterSecret()
            org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters r6 = org.bouncycastle.pqc.crypto.lms.LMS.generateKeys(r9, r10, r11, r12, r6)
            r4[r8] = r6
            r6 = r7
            goto L_0x007e
        L_0x007d:
            r6 = r8
        L_0x007e:
            r9 = r7
        L_0x007f:
            if (r9 >= r2) goto L_0x0158
            int r10 = r9 + -1
            r11 = r4[r10]
            r12 = 16
            byte[] r13 = new byte[r12]
            r14 = 32
            byte[] r15 = new byte[r14]
            org.bouncycastle.pqc.crypto.lms.SeedDerive r12 = new org.bouncycastle.pqc.crypto.lms.SeedDerive
            byte[] r8 = r11.getI()
            byte[] r14 = r11.getMasterSecret()
            org.bouncycastle.pqc.crypto.lms.LMOtsParameters r11 = r11.getOtsParameters()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r11 = r11.getDigestOID()
            org.bouncycastle.crypto.Digest r11 = org.bouncycastle.pqc.crypto.lms.DigestUtil.getDigest(r11)
            r12.<init>(r8, r14, r11)
            r7 = r3[r10]
            int r7 = (int) r7
            r12.setQ(r7)
            r7 = -2
            r12.setJ(r7)
            r7 = 1
            r12.deriveSeed((byte[]) r15, (boolean) r7)
            r8 = 32
            byte[] r8 = new byte[r8]
            r11 = 0
            r12.deriveSeed((byte[]) r8, (boolean) r11)
            r12 = 16
            java.lang.System.arraycopy(r8, r11, r13, r11, r12)
            int r8 = r2 + -1
            if (r9 >= r8) goto L_0x00d4
            r16 = r3[r9]
            r8 = r4[r9]
            int r8 = r8.getIndex()
            int r8 = r8 - r7
            long r7 = (long) r8
            int r7 = (r16 > r7 ? 1 : (r16 == r7 ? 0 : -1))
            if (r7 != 0) goto L_0x00e4
            goto L_0x00e1
        L_0x00d4:
            r7 = r3[r9]
            r14 = r4[r9]
            int r14 = r14.getIndex()
            long r11 = (long) r14
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x00e3
        L_0x00e1:
            r11 = 1
            goto L_0x00e4
        L_0x00e3:
            r11 = 0
        L_0x00e4:
            r7 = r4[r9]
            byte[] r7 = r7.getI()
            boolean r7 = org.bouncycastle.util.Arrays.areEqual((byte[]) r13, (byte[]) r7)
            if (r7 == 0) goto L_0x00fe
            r7 = r4[r9]
            byte[] r7 = r7.getMasterSecret()
            boolean r7 = org.bouncycastle.util.Arrays.areEqual((byte[]) r15, (byte[]) r7)
            if (r7 == 0) goto L_0x00fe
            r7 = 1
            goto L_0x00ff
        L_0x00fe:
            r7 = 0
        L_0x00ff:
            if (r7 != 0) goto L_0x0132
            java.lang.Object r6 = r1.get(r9)
            org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters r6 = (org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters) r6
            org.bouncycastle.pqc.crypto.lms.LMSigParameters r6 = r6.getSigParameters()
            java.lang.Object r7 = r1.get(r9)
            org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters r7 = (org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters) r7
            org.bouncycastle.pqc.crypto.lms.LMOtsParameters r7 = r7.getOtsParameters()
            r11 = r3[r9]
            int r8 = (int) r11
            org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters r6 = org.bouncycastle.pqc.crypto.lms.LMS.generateKeys(r6, r7, r8, r13, r15)
            r4[r9] = r6
            r6 = r4[r10]
            r7 = r4[r9]
            org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters r7 = r7.getPublicKey()
            byte[] r7 = r7.toByteArray()
            org.bouncycastle.pqc.crypto.lms.LMSSignature r6 = org.bouncycastle.pqc.crypto.lms.LMS.generateSign(r6, r7)
            r5[r10] = r6
        L_0x0130:
            r6 = 1
            goto L_0x0152
        L_0x0132:
            if (r11 != 0) goto L_0x0152
            java.lang.Object r6 = r1.get(r9)
            org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters r6 = (org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters) r6
            org.bouncycastle.pqc.crypto.lms.LMSigParameters r6 = r6.getSigParameters()
            java.lang.Object r7 = r1.get(r9)
            org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters r7 = (org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters) r7
            org.bouncycastle.pqc.crypto.lms.LMOtsParameters r7 = r7.getOtsParameters()
            r10 = r3[r9]
            int r8 = (int) r10
            org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters r6 = org.bouncycastle.pqc.crypto.lms.LMS.generateKeys(r6, r7, r8, r13, r15)
            r4[r9] = r6
            goto L_0x0130
        L_0x0152:
            int r9 = r9 + 1
            r7 = 1
            r8 = 0
            goto L_0x007f
        L_0x0158:
            if (r6 == 0) goto L_0x015d
            r0.updateHierarchy(r4, r5)
        L_0x015d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters.resetKeyToIndex():void");
    }

    /* access modifiers changed from: protected */
    public void updateHierarchy(LMSPrivateKeyParameters[] lMSPrivateKeyParametersArr, LMSSignature[] lMSSignatureArr) {
        synchronized (this) {
            this.keys = Collections.unmodifiableList(Arrays.asList(lMSPrivateKeyParametersArr));
            this.sig = Collections.unmodifiableList(Arrays.asList(lMSSignatureArr));
        }
    }
}
