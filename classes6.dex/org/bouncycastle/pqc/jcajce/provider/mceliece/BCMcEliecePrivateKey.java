package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.security.PrivateKey;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class BCMcEliecePrivateKey implements CipherParameters, PrivateKey {
    private static final long serialVersionUID = 1;
    private McEliecePrivateKeyParameters params;

    public BCMcEliecePrivateKey(McEliecePrivateKeyParameters mcEliecePrivateKeyParameters) {
        this.params = mcEliecePrivateKeyParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCMcEliecePrivateKey)) {
            return false;
        }
        BCMcEliecePrivateKey bCMcEliecePrivateKey = (BCMcEliecePrivateKey) obj;
        return getN() == bCMcEliecePrivateKey.getN() && getK() == bCMcEliecePrivateKey.getK() && getField().equals(bCMcEliecePrivateKey.getField()) && getGoppaPoly().equals(bCMcEliecePrivateKey.getGoppaPoly()) && getSInv().equals(bCMcEliecePrivateKey.getSInv()) && getP1().equals(bCMcEliecePrivateKey.getP1()) && getP2().equals(bCMcEliecePrivateKey.getP2());
    }

    public String getAlgorithm() {
        return "McEliece";
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getEncoded() {
        /*
            r9 = this;
            org.bouncycastle.pqc.asn1.McEliecePrivateKey r8 = new org.bouncycastle.pqc.asn1.McEliecePrivateKey
            org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters r0 = r9.params
            int r1 = r0.getN()
            org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters r0 = r9.params
            int r2 = r0.getK()
            org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters r0 = r9.params
            org.bouncycastle.pqc.math.linearalgebra.GF2mField r3 = r0.getField()
            org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters r0 = r9.params
            org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM r4 = r0.getGoppaPoly()
            org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters r0 = r9.params
            org.bouncycastle.pqc.math.linearalgebra.Permutation r5 = r0.getP1()
            org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters r0 = r9.params
            org.bouncycastle.pqc.math.linearalgebra.Permutation r6 = r0.getP2()
            org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters r0 = r9.params
            org.bouncycastle.pqc.math.linearalgebra.GF2Matrix r7 = r0.getSInv()
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = 0
            org.bouncycastle.asn1.x509.AlgorithmIdentifier r1 = new org.bouncycastle.asn1.x509.AlgorithmIdentifier     // Catch:{ IOException -> 0x0041 }
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.pqc.asn1.PQCObjectIdentifiers.mcEliece     // Catch:{ IOException -> 0x0041 }
            r1.<init>((org.bouncycastle.asn1.ASN1ObjectIdentifier) r2)     // Catch:{ IOException -> 0x0041 }
            org.bouncycastle.asn1.pkcs.PrivateKeyInfo r2 = new org.bouncycastle.asn1.pkcs.PrivateKeyInfo     // Catch:{ IOException -> 0x0041 }
            r2.<init>(r1, r8)     // Catch:{ IOException -> 0x0041 }
            byte[] r0 = r2.getEncoded()     // Catch:{  }
        L_0x0041:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcEliecePrivateKey.getEncoded():byte[]");
    }

    public GF2mField getField() {
        return this.params.getField();
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return this.params.getGoppaPoly();
    }

    public GF2Matrix getH() {
        return this.params.getH();
    }

    public int getK() {
        return this.params.getK();
    }

    /* access modifiers changed from: package-private */
    public AsymmetricKeyParameter getKeyParams() {
        return this.params;
    }

    public int getN() {
        return this.params.getN();
    }

    public Permutation getP1() {
        return this.params.getP1();
    }

    public Permutation getP2() {
        return this.params.getP2();
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.params.getQInv();
    }

    public GF2Matrix getSInv() {
        return this.params.getSInv();
    }

    public int hashCode() {
        return (((((((((((this.params.getK() * 37) + this.params.getN()) * 37) + this.params.getField().hashCode()) * 37) + this.params.getGoppaPoly().hashCode()) * 37) + this.params.getP1().hashCode()) * 37) + this.params.getP2().hashCode()) * 37) + this.params.getSInv().hashCode();
    }
}
