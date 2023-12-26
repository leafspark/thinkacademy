package org.bouncycastle.pqc.crypto.lms;

import java.io.IOException;
import java.util.Arrays;
import org.bouncycastle.util.Encodable;

public class HSSSignature implements Encodable {
    private final int lMinus1;
    private final LMSSignature signature;
    private final LMSSignedPubKey[] signedPubKey;

    public HSSSignature(int i, LMSSignedPubKey[] lMSSignedPubKeyArr, LMSSignature lMSSignature) {
        this.lMinus1 = i;
        this.signedPubKey = lMSSignedPubKeyArr;
        this.signature = lMSSignature;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.bouncycastle.pqc.crypto.lms.HSSSignature getInstance(java.lang.Object r5, int r6) throws java.io.IOException {
        /*
            boolean r0 = r5 instanceof org.bouncycastle.pqc.crypto.lms.HSSSignature
            if (r0 == 0) goto L_0x0007
            org.bouncycastle.pqc.crypto.lms.HSSSignature r5 = (org.bouncycastle.pqc.crypto.lms.HSSSignature) r5
            return r5
        L_0x0007:
            boolean r0 = r5 instanceof java.io.DataInputStream
            if (r0 == 0) goto L_0x0041
            r0 = r5
            java.io.DataInputStream r0 = (java.io.DataInputStream) r0
            int r0 = r0.readInt()
            int r6 = r6 + -1
            if (r0 != r6) goto L_0x0039
            org.bouncycastle.pqc.crypto.lms.LMSSignedPubKey[] r6 = new org.bouncycastle.pqc.crypto.lms.LMSSignedPubKey[r0]
            if (r0 == 0) goto L_0x002f
            r1 = 0
        L_0x001b:
            if (r1 >= r0) goto L_0x002f
            org.bouncycastle.pqc.crypto.lms.LMSSignedPubKey r2 = new org.bouncycastle.pqc.crypto.lms.LMSSignedPubKey
            org.bouncycastle.pqc.crypto.lms.LMSSignature r3 = org.bouncycastle.pqc.crypto.lms.LMSSignature.getInstance(r5)
            org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters r4 = org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters.getInstance(r5)
            r2.<init>(r3, r4)
            r6[r1] = r2
            int r1 = r1 + 1
            goto L_0x001b
        L_0x002f:
            org.bouncycastle.pqc.crypto.lms.LMSSignature r5 = org.bouncycastle.pqc.crypto.lms.LMSSignature.getInstance(r5)
            org.bouncycastle.pqc.crypto.lms.HSSSignature r1 = new org.bouncycastle.pqc.crypto.lms.HSSSignature
            r1.<init>(r0, r6, r5)
            return r1
        L_0x0039:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "nspk exceeded maxNspk"
            r5.<init>(r6)
            throw r5
        L_0x0041:
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L_0x0066
            r0 = 0
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch:{ all -> 0x005f }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x005f }
            byte[] r5 = (byte[]) r5     // Catch:{ all -> 0x005f }
            byte[] r5 = (byte[]) r5     // Catch:{ all -> 0x005f }
            r2.<init>(r5)     // Catch:{ all -> 0x005f }
            r1.<init>(r2)     // Catch:{ all -> 0x005f }
            org.bouncycastle.pqc.crypto.lms.HSSSignature r5 = getInstance(r1, r6)     // Catch:{ all -> 0x005c }
            r1.close()
            return r5
        L_0x005c:
            r5 = move-exception
            r0 = r1
            goto L_0x0060
        L_0x005f:
            r5 = move-exception
        L_0x0060:
            if (r0 == 0) goto L_0x0065
            r0.close()
        L_0x0065:
            throw r5
        L_0x0066:
            boolean r0 = r5 instanceof java.io.InputStream
            if (r0 == 0) goto L_0x0075
            java.io.InputStream r5 = (java.io.InputStream) r5
            byte[] r5 = org.bouncycastle.util.io.Streams.readAll(r5)
            org.bouncycastle.pqc.crypto.lms.HSSSignature r5 = getInstance(r5, r6)
            return r5
        L_0x0075:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "cannot parse "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.crypto.lms.HSSSignature.getInstance(java.lang.Object, int):org.bouncycastle.pqc.crypto.lms.HSSSignature");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HSSSignature hSSSignature = (HSSSignature) obj;
        if (this.lMinus1 != hSSSignature.lMinus1 || this.signedPubKey.length != hSSSignature.signedPubKey.length) {
            return false;
        }
        int i = 0;
        while (true) {
            LMSSignedPubKey[] lMSSignedPubKeyArr = this.signedPubKey;
            if (i >= lMSSignedPubKeyArr.length) {
                LMSSignature lMSSignature = this.signature;
                LMSSignature lMSSignature2 = hSSSignature.signature;
                return lMSSignature != null ? lMSSignature.equals(lMSSignature2) : lMSSignature2 == null;
            } else if (!lMSSignedPubKeyArr[i].equals(hSSSignature.signedPubKey[i])) {
                return false;
            } else {
                i++;
            }
        }
    }

    public byte[] getEncoded() throws IOException {
        Composer compose = Composer.compose();
        compose.u32str(this.lMinus1);
        LMSSignedPubKey[] lMSSignedPubKeyArr = this.signedPubKey;
        if (lMSSignedPubKeyArr != null) {
            for (LMSSignedPubKey bytes : lMSSignedPubKeyArr) {
                compose.bytes((Encodable) bytes);
            }
        }
        compose.bytes((Encodable) this.signature);
        return compose.build();
    }

    public LMSSignature getSignature() {
        return this.signature;
    }

    public LMSSignedPubKey[] getSignedPubKey() {
        return this.signedPubKey;
    }

    public int getlMinus1() {
        return this.lMinus1;
    }

    public int hashCode() {
        int hashCode = ((this.lMinus1 * 31) + Arrays.hashCode(this.signedPubKey)) * 31;
        LMSSignature lMSSignature = this.signature;
        return hashCode + (lMSSignature != null ? lMSSignature.hashCode() : 0);
    }
}
