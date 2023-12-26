package org.bouncycastle.pqc.crypto.lms;

import java.io.IOException;
import java.util.Arrays;
import org.bouncycastle.util.Encodable;

class LMOtsSignature implements Encodable {
    private final byte[] C;
    private final LMOtsParameters type;
    private final byte[] y;

    public LMOtsSignature(LMOtsParameters lMOtsParameters, byte[] bArr, byte[] bArr2) {
        this.type = lMOtsParameters;
        this.C = bArr;
        this.y = bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.bouncycastle.pqc.crypto.lms.LMOtsSignature getInstance(java.lang.Object r4) throws java.io.IOException {
        /*
            boolean r0 = r4 instanceof org.bouncycastle.pqc.crypto.lms.LMOtsSignature
            if (r0 == 0) goto L_0x0007
            org.bouncycastle.pqc.crypto.lms.LMOtsSignature r4 = (org.bouncycastle.pqc.crypto.lms.LMOtsSignature) r4
            return r4
        L_0x0007:
            boolean r0 = r4 instanceof java.io.DataInputStream
            if (r0 == 0) goto L_0x0032
            java.io.DataInputStream r4 = (java.io.DataInputStream) r4
            int r0 = r4.readInt()
            org.bouncycastle.pqc.crypto.lms.LMOtsParameters r0 = org.bouncycastle.pqc.crypto.lms.LMOtsParameters.getParametersForType(r0)
            int r1 = r0.getN()
            byte[] r1 = new byte[r1]
            r4.readFully(r1)
            int r2 = r0.getP()
            int r3 = r0.getN()
            int r2 = r2 * r3
            byte[] r2 = new byte[r2]
            r4.readFully(r2)
            org.bouncycastle.pqc.crypto.lms.LMOtsSignature r4 = new org.bouncycastle.pqc.crypto.lms.LMOtsSignature
            r4.<init>(r0, r1, r2)
            return r4
        L_0x0032:
            boolean r0 = r4 instanceof byte[]
            if (r0 == 0) goto L_0x0057
            r0 = 0
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch:{ all -> 0x0050 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0050 }
            byte[] r4 = (byte[]) r4     // Catch:{ all -> 0x0050 }
            byte[] r4 = (byte[]) r4     // Catch:{ all -> 0x0050 }
            r2.<init>(r4)     // Catch:{ all -> 0x0050 }
            r1.<init>(r2)     // Catch:{ all -> 0x0050 }
            org.bouncycastle.pqc.crypto.lms.LMOtsSignature r4 = getInstance(r1)     // Catch:{ all -> 0x004d }
            r1.close()
            return r4
        L_0x004d:
            r4 = move-exception
            r0 = r1
            goto L_0x0051
        L_0x0050:
            r4 = move-exception
        L_0x0051:
            if (r0 == 0) goto L_0x0056
            r0.close()
        L_0x0056:
            throw r4
        L_0x0057:
            boolean r0 = r4 instanceof java.io.InputStream
            if (r0 == 0) goto L_0x0066
            java.io.InputStream r4 = (java.io.InputStream) r4
            byte[] r4 = org.bouncycastle.util.io.Streams.readAll(r4)
            org.bouncycastle.pqc.crypto.lms.LMOtsSignature r4 = getInstance(r4)
            return r4
        L_0x0066:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cannot parse "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.crypto.lms.LMOtsSignature.getInstance(java.lang.Object):org.bouncycastle.pqc.crypto.lms.LMOtsSignature");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LMOtsSignature lMOtsSignature = (LMOtsSignature) obj;
        LMOtsParameters lMOtsParameters = this.type;
        if (lMOtsParameters == null ? lMOtsSignature.type != null : !lMOtsParameters.equals(lMOtsSignature.type)) {
            return false;
        }
        if (!Arrays.equals(this.C, lMOtsSignature.C)) {
            return false;
        }
        return Arrays.equals(this.y, lMOtsSignature.y);
    }

    public byte[] getC() {
        return this.C;
    }

    public byte[] getEncoded() throws IOException {
        return Composer.compose().u32str(this.type.getType()).bytes(this.C).bytes(this.y).build();
    }

    public LMOtsParameters getType() {
        return this.type;
    }

    public byte[] getY() {
        return this.y;
    }

    public int hashCode() {
        LMOtsParameters lMOtsParameters = this.type;
        return ((((lMOtsParameters != null ? lMOtsParameters.hashCode() : 0) * 31) + Arrays.hashCode(this.C)) * 31) + Arrays.hashCode(this.y);
    }
}
