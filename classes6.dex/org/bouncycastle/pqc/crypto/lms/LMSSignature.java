package org.bouncycastle.pqc.crypto.lms;

import java.io.IOException;
import java.util.Arrays;
import org.bouncycastle.util.Encodable;

class LMSSignature implements Encodable {
    private final LMOtsSignature otsSignature;
    private final LMSigParameters parameter;
    private final int q;
    private final byte[][] y;

    public LMSSignature(int i, LMOtsSignature lMOtsSignature, LMSigParameters lMSigParameters, byte[][] bArr) {
        this.q = i;
        this.otsSignature = lMOtsSignature;
        this.parameter = lMSigParameters;
        this.y = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.bouncycastle.pqc.crypto.lms.LMSSignature getInstance(java.lang.Object r7) throws java.io.IOException {
        /*
            boolean r0 = r7 instanceof org.bouncycastle.pqc.crypto.lms.LMSSignature
            if (r0 == 0) goto L_0x0007
            org.bouncycastle.pqc.crypto.lms.LMSSignature r7 = (org.bouncycastle.pqc.crypto.lms.LMSSignature) r7
            return r7
        L_0x0007:
            boolean r0 = r7 instanceof java.io.DataInputStream
            if (r0 == 0) goto L_0x003d
            r0 = r7
            java.io.DataInputStream r0 = (java.io.DataInputStream) r0
            int r1 = r0.readInt()
            org.bouncycastle.pqc.crypto.lms.LMOtsSignature r7 = org.bouncycastle.pqc.crypto.lms.LMOtsSignature.getInstance(r7)
            int r2 = r0.readInt()
            org.bouncycastle.pqc.crypto.lms.LMSigParameters r2 = org.bouncycastle.pqc.crypto.lms.LMSigParameters.getParametersForType(r2)
            int r3 = r2.getH()
            byte[][] r4 = new byte[r3][]
            r5 = 0
        L_0x0025:
            if (r5 >= r3) goto L_0x0037
            int r6 = r2.getM()
            byte[] r6 = new byte[r6]
            r4[r5] = r6
            r6 = r4[r5]
            r0.readFully(r6)
            int r5 = r5 + 1
            goto L_0x0025
        L_0x0037:
            org.bouncycastle.pqc.crypto.lms.LMSSignature r0 = new org.bouncycastle.pqc.crypto.lms.LMSSignature
            r0.<init>(r1, r7, r2, r4)
            return r0
        L_0x003d:
            boolean r0 = r7 instanceof byte[]
            if (r0 == 0) goto L_0x0062
            r0 = 0
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch:{ all -> 0x005b }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x005b }
            byte[] r7 = (byte[]) r7     // Catch:{ all -> 0x005b }
            byte[] r7 = (byte[]) r7     // Catch:{ all -> 0x005b }
            r2.<init>(r7)     // Catch:{ all -> 0x005b }
            r1.<init>(r2)     // Catch:{ all -> 0x005b }
            org.bouncycastle.pqc.crypto.lms.LMSSignature r7 = getInstance(r1)     // Catch:{ all -> 0x0058 }
            r1.close()
            return r7
        L_0x0058:
            r7 = move-exception
            r0 = r1
            goto L_0x005c
        L_0x005b:
            r7 = move-exception
        L_0x005c:
            if (r0 == 0) goto L_0x0061
            r0.close()
        L_0x0061:
            throw r7
        L_0x0062:
            boolean r0 = r7 instanceof java.io.InputStream
            if (r0 == 0) goto L_0x0071
            java.io.InputStream r7 = (java.io.InputStream) r7
            byte[] r7 = org.bouncycastle.util.io.Streams.readAll(r7)
            org.bouncycastle.pqc.crypto.lms.LMSSignature r7 = getInstance(r7)
            return r7
        L_0x0071:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cannot parse "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.crypto.lms.LMSSignature.getInstance(java.lang.Object):org.bouncycastle.pqc.crypto.lms.LMSSignature");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LMSSignature lMSSignature = (LMSSignature) obj;
        if (this.q != lMSSignature.q) {
            return false;
        }
        LMOtsSignature lMOtsSignature = this.otsSignature;
        if (lMOtsSignature == null ? lMSSignature.otsSignature != null : !lMOtsSignature.equals(lMSSignature.otsSignature)) {
            return false;
        }
        LMSigParameters lMSigParameters = this.parameter;
        if (lMSigParameters == null ? lMSSignature.parameter == null : lMSigParameters.equals(lMSSignature.parameter)) {
            return Arrays.deepEquals(this.y, lMSSignature.y);
        }
        return false;
    }

    public byte[] getEncoded() throws IOException {
        return Composer.compose().u32str(this.q).bytes(this.otsSignature.getEncoded()).u32str(this.parameter.getType()).bytes(this.y).build();
    }

    public LMOtsSignature getOtsSignature() {
        return this.otsSignature;
    }

    public LMSigParameters getParameter() {
        return this.parameter;
    }

    public int getQ() {
        return this.q;
    }

    public byte[][] getY() {
        return this.y;
    }

    public int hashCode() {
        int i = this.q * 31;
        LMOtsSignature lMOtsSignature = this.otsSignature;
        int i2 = 0;
        int hashCode = (i + (lMOtsSignature != null ? lMOtsSignature.hashCode() : 0)) * 31;
        LMSigParameters lMSigParameters = this.parameter;
        if (lMSigParameters != null) {
            i2 = lMSigParameters.hashCode();
        }
        return ((hashCode + i2) * 31) + Arrays.deepHashCode(this.y);
    }
}
