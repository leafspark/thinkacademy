package org.bouncycastle.pqc.crypto.lms;

import java.io.IOException;
import org.bouncycastle.util.Arrays;

public class LMSPublicKeyParameters extends LMSKeyParameters implements LMSContextBasedVerifier {
    private final byte[] I;
    private final byte[] T1;
    private final LMOtsParameters lmOtsType;
    private final LMSigParameters parameterSet;

    public LMSPublicKeyParameters(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters, byte[] bArr, byte[] bArr2) {
        super(false);
        this.parameterSet = lMSigParameters;
        this.lmOtsType = lMOtsParameters;
        this.I = Arrays.clone(bArr2);
        this.T1 = Arrays.clone(bArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters getInstance(java.lang.Object r4) throws java.io.IOException {
        /*
            boolean r0 = r4 instanceof org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters
            if (r0 == 0) goto L_0x0007
            org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters r4 = (org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters) r4
            return r4
        L_0x0007:
            boolean r0 = r4 instanceof java.io.DataInputStream
            if (r0 == 0) goto L_0x0033
            java.io.DataInputStream r4 = (java.io.DataInputStream) r4
            int r0 = r4.readInt()
            org.bouncycastle.pqc.crypto.lms.LMSigParameters r0 = org.bouncycastle.pqc.crypto.lms.LMSigParameters.getParametersForType(r0)
            int r1 = r4.readInt()
            org.bouncycastle.pqc.crypto.lms.LMOtsParameters r1 = org.bouncycastle.pqc.crypto.lms.LMOtsParameters.getParametersForType(r1)
            r2 = 16
            byte[] r2 = new byte[r2]
            r4.readFully(r2)
            int r3 = r0.getM()
            byte[] r3 = new byte[r3]
            r4.readFully(r3)
            org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters r4 = new org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters
            r4.<init>(r0, r1, r3, r2)
            return r4
        L_0x0033:
            boolean r0 = r4 instanceof byte[]
            if (r0 == 0) goto L_0x0058
            r0 = 0
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch:{ all -> 0x0051 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0051 }
            byte[] r4 = (byte[]) r4     // Catch:{ all -> 0x0051 }
            byte[] r4 = (byte[]) r4     // Catch:{ all -> 0x0051 }
            r2.<init>(r4)     // Catch:{ all -> 0x0051 }
            r1.<init>(r2)     // Catch:{ all -> 0x0051 }
            org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters r4 = getInstance(r1)     // Catch:{ all -> 0x004e }
            r1.close()
            return r4
        L_0x004e:
            r4 = move-exception
            r0 = r1
            goto L_0x0052
        L_0x0051:
            r4 = move-exception
        L_0x0052:
            if (r0 == 0) goto L_0x0057
            r0.close()
        L_0x0057:
            throw r4
        L_0x0058:
            boolean r0 = r4 instanceof java.io.InputStream
            if (r0 == 0) goto L_0x0067
            java.io.InputStream r4 = (java.io.InputStream) r4
            byte[] r4 = org.bouncycastle.util.io.Streams.readAll(r4)
            org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters r4 = getInstance(r4)
            return r4
        L_0x0067:
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
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters.getInstance(java.lang.Object):org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LMSPublicKeyParameters lMSPublicKeyParameters = (LMSPublicKeyParameters) obj;
        if (this.parameterSet.equals(lMSPublicKeyParameters.parameterSet) && this.lmOtsType.equals(lMSPublicKeyParameters.lmOtsType) && Arrays.areEqual(this.I, lMSPublicKeyParameters.I)) {
            return Arrays.areEqual(this.T1, lMSPublicKeyParameters.T1);
        }
        return false;
    }

    public LMSContext generateLMSContext(byte[] bArr) {
        try {
            return generateOtsContext(LMSSignature.getInstance(bArr));
        } catch (IOException e) {
            throw new IllegalStateException("cannot parse signature: " + e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public LMSContext generateOtsContext(LMSSignature lMSSignature) {
        int type = getOtsParameters().getType();
        if (lMSSignature.getOtsSignature().getType().getType() == type) {
            return new LMOtsPublicKey(LMOtsParameters.getParametersForType(type), this.I, lMSSignature.getQ(), (byte[]) null).createOtsContext(lMSSignature);
        }
        throw new IllegalArgumentException("ots type from lsm signature does not match ots signature type from embedded ots signature");
    }

    public byte[] getEncoded() throws IOException {
        return toByteArray();
    }

    public byte[] getI() {
        return Arrays.clone(this.I);
    }

    public LMSParameters getLMSParameters() {
        return new LMSParameters(getSigParameters(), getOtsParameters());
    }

    public LMOtsParameters getOtsParameters() {
        return this.lmOtsType;
    }

    public LMSigParameters getSigParameters() {
        return this.parameterSet;
    }

    public byte[] getT1() {
        return Arrays.clone(this.T1);
    }

    public int hashCode() {
        return (((((this.parameterSet.hashCode() * 31) + this.lmOtsType.hashCode()) * 31) + Arrays.hashCode(this.I)) * 31) + Arrays.hashCode(this.T1);
    }

    /* access modifiers changed from: package-private */
    public boolean matchesT1(byte[] bArr) {
        return Arrays.constantTimeAreEqual(this.T1, bArr);
    }

    /* access modifiers changed from: package-private */
    public byte[] refI() {
        return this.I;
    }

    /* access modifiers changed from: package-private */
    public byte[] toByteArray() {
        return Composer.compose().u32str(this.parameterSet.getType()).u32str(this.lmOtsType.getType()).bytes(this.I).bytes(this.T1).build();
    }

    public boolean verify(LMSContext lMSContext) {
        return LMS.verifySignature(this, lMSContext);
    }
}
