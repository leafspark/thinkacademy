package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.Polynomial;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.util.Arrays;

public class EC5Util {
    private static Map customCurves = new HashMap();

    static {
        Enumeration names = CustomNamedCurves.getNames();
        while (names.hasMoreElements()) {
            String str = (String) names.nextElement();
            X9ECParameters byName = ECNamedCurveTable.getByName(str);
            if (byName != null) {
                customCurves.put(byName.getCurve(), CustomNamedCurves.getByName(str).getCurve());
            }
        }
        ECCurve curve = CustomNamedCurves.getByName("Curve25519").getCurve();
        customCurves.put(new ECCurve.Fp(curve.getField().getCharacteristic(), curve.getA().toBigInteger(), curve.getB().toBigInteger(), curve.getOrder(), curve.getCofactor()), curve);
    }

    public static EllipticCurve convertCurve(ECCurve eCCurve, byte[] bArr) {
        return new EllipticCurve(convertField(eCCurve.getField()), eCCurve.getA().toBigInteger(), eCCurve.getB().toBigInteger(), (byte[]) null);
    }

    public static ECCurve convertCurve(EllipticCurve ellipticCurve) {
        ECField field = ellipticCurve.getField();
        BigInteger a = ellipticCurve.getA();
        BigInteger b = ellipticCurve.getB();
        if (field instanceof ECFieldFp) {
            ECCurve.Fp fp = new ECCurve.Fp(((ECFieldFp) field).getP(), a, b);
            return customCurves.containsKey(fp) ? (ECCurve) customCurves.get(fp) : fp;
        }
        ECFieldF2m eCFieldF2m = (ECFieldF2m) field;
        int m = eCFieldF2m.getM();
        int[] convertMidTerms = ECUtil.convertMidTerms(eCFieldF2m.getMidTermsOfReductionPolynomial());
        return new ECCurve.F2m(m, convertMidTerms[0], convertMidTerms[1], convertMidTerms[2], a, b);
    }

    public static ECField convertField(FiniteField finiteField) {
        if (ECAlgorithms.isFpField(finiteField)) {
            return new ECFieldFp(finiteField.getCharacteristic());
        }
        Polynomial minimalPolynomial = ((PolynomialExtensionField) finiteField).getMinimalPolynomial();
        int[] exponentsPresent = minimalPolynomial.getExponentsPresent();
        return new ECFieldF2m(minimalPolynomial.getDegree(), Arrays.reverseInPlace(Arrays.copyOfRange(exponentsPresent, 1, exponentsPresent.length - 1)));
    }

    public static ECPoint convertPoint(org.bouncycastle.math.ec.ECPoint eCPoint) {
        org.bouncycastle.math.ec.ECPoint normalize = eCPoint.normalize();
        return new ECPoint(normalize.getAffineXCoord().toBigInteger(), normalize.getAffineYCoord().toBigInteger());
    }

    public static org.bouncycastle.math.ec.ECPoint convertPoint(ECParameterSpec eCParameterSpec, ECPoint eCPoint) {
        return convertPoint(convertCurve(eCParameterSpec.getCurve()), eCPoint);
    }

    public static org.bouncycastle.math.ec.ECPoint convertPoint(ECCurve eCCurve, ECPoint eCPoint) {
        return eCCurve.createPoint(eCPoint.getAffineX(), eCPoint.getAffineY());
    }

    public static ECParameterSpec convertSpec(EllipticCurve ellipticCurve, org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECPoint convertPoint = convertPoint(eCParameterSpec.getG());
        if (!(eCParameterSpec instanceof ECNamedCurveParameterSpec)) {
            return new ECParameterSpec(ellipticCurve, convertPoint, eCParameterSpec.getN(), eCParameterSpec.getH().intValue());
        }
        return new ECNamedCurveSpec(((ECNamedCurveParameterSpec) eCParameterSpec).getName(), ellipticCurve, convertPoint, eCParameterSpec.getN(), eCParameterSpec.getH());
    }

    public static org.bouncycastle.jce.spec.ECParameterSpec convertSpec(ECParameterSpec eCParameterSpec) {
        ECCurve convertCurve = convertCurve(eCParameterSpec.getCurve());
        org.bouncycastle.math.ec.ECPoint convertPoint = convertPoint(convertCurve, eCParameterSpec.getGenerator());
        BigInteger order = eCParameterSpec.getOrder();
        BigInteger valueOf = BigInteger.valueOf((long) eCParameterSpec.getCofactor());
        byte[] seed = eCParameterSpec.getCurve().getSeed();
        return eCParameterSpec instanceof ECNamedCurveSpec ? new ECNamedCurveParameterSpec(((ECNamedCurveSpec) eCParameterSpec).getName(), convertCurve, convertPoint, order, valueOf, seed) : new org.bouncycastle.jce.spec.ECParameterSpec(convertCurve, convertPoint, order, valueOf, seed);
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [java.security.spec.ECParameterSpec] */
    /* JADX WARNING: type inference failed for: r0v9, types: [java.security.spec.ECParameterSpec] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.spec.ECParameterSpec convertToSpec(org.bouncycastle.asn1.x9.X962Parameters r8, org.bouncycastle.math.ec.ECCurve r9) {
        /*
            boolean r0 = r8.isNamedCurve()
            if (r0 == 0) goto L_0x0048
            org.bouncycastle.asn1.ASN1Primitive r8 = r8.getParameters()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r8 = (org.bouncycastle.asn1.ASN1ObjectIdentifier) r8
            org.bouncycastle.asn1.x9.X9ECParameters r0 = org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getNamedCurveByOid(r8)
            if (r0 != 0) goto L_0x0024
            org.bouncycastle.jcajce.provider.config.ProviderConfiguration r1 = org.bouncycastle.jce.provider.BouncyCastleProvider.CONFIGURATION
            java.util.Map r1 = r1.getAdditionalECParameters()
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x0024
            java.lang.Object r0 = r1.get(r8)
            org.bouncycastle.asn1.x9.X9ECParameters r0 = (org.bouncycastle.asn1.x9.X9ECParameters) r0
        L_0x0024:
            byte[] r1 = r0.getSeed()
            java.security.spec.EllipticCurve r4 = convertCurve(r9, r1)
            org.bouncycastle.jce.spec.ECNamedCurveSpec r9 = new org.bouncycastle.jce.spec.ECNamedCurveSpec
            java.lang.String r3 = org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getCurveName(r8)
            org.bouncycastle.math.ec.ECPoint r8 = r0.getG()
            java.security.spec.ECPoint r5 = convertPoint(r8)
            java.math.BigInteger r6 = r0.getN()
            java.math.BigInteger r7 = r0.getH()
            r2 = r9
            r2.<init>((java.lang.String) r3, (java.security.spec.EllipticCurve) r4, (java.security.spec.ECPoint) r5, (java.math.BigInteger) r6, (java.math.BigInteger) r7)
            goto L_0x00da
        L_0x0048:
            boolean r0 = r8.isImplicitlyCA()
            if (r0 == 0) goto L_0x0051
            r9 = 0
            goto L_0x00da
        L_0x0051:
            org.bouncycastle.asn1.ASN1Primitive r8 = r8.getParameters()
            org.bouncycastle.asn1.ASN1Sequence r8 = org.bouncycastle.asn1.ASN1Sequence.getInstance(r8)
            int r0 = r8.size()
            r1 = 3
            if (r0 <= r1) goto L_0x009f
            org.bouncycastle.asn1.x9.X9ECParameters r8 = org.bouncycastle.asn1.x9.X9ECParameters.getInstance(r8)
            byte[] r0 = r8.getSeed()
            java.security.spec.EllipticCurve r9 = convertCurve(r9, r0)
            java.math.BigInteger r0 = r8.getH()
            if (r0 == 0) goto L_0x008c
            java.security.spec.ECParameterSpec r0 = new java.security.spec.ECParameterSpec
            org.bouncycastle.math.ec.ECPoint r1 = r8.getG()
            java.security.spec.ECPoint r1 = convertPoint(r1)
            java.math.BigInteger r2 = r8.getN()
            java.math.BigInteger r8 = r8.getH()
            int r8 = r8.intValue()
            r0.<init>(r9, r1, r2, r8)
            goto L_0x00d9
        L_0x008c:
            java.security.spec.ECParameterSpec r0 = new java.security.spec.ECParameterSpec
            org.bouncycastle.math.ec.ECPoint r1 = r8.getG()
            java.security.spec.ECPoint r1 = convertPoint(r1)
            java.math.BigInteger r8 = r8.getN()
            r2 = 1
            r0.<init>(r9, r1, r8, r2)
            goto L_0x00d9
        L_0x009f:
            org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r8 = org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters.getInstance(r8)
            org.bouncycastle.asn1.ASN1ObjectIdentifier r9 = r8.getPublicKeyParamSet()
            java.lang.String r9 = org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves.getName(r9)
            org.bouncycastle.jce.spec.ECNamedCurveParameterSpec r9 = org.bouncycastle.jce.ECGOST3410NamedCurveTable.getParameterSpec(r9)
            org.bouncycastle.math.ec.ECCurve r0 = r9.getCurve()
            byte[] r1 = r9.getSeed()
            java.security.spec.EllipticCurve r4 = convertCurve(r0, r1)
            org.bouncycastle.jce.spec.ECNamedCurveSpec r0 = new org.bouncycastle.jce.spec.ECNamedCurveSpec
            org.bouncycastle.asn1.ASN1ObjectIdentifier r8 = r8.getPublicKeyParamSet()
            java.lang.String r3 = org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves.getName(r8)
            org.bouncycastle.math.ec.ECPoint r8 = r9.getG()
            java.security.spec.ECPoint r5 = convertPoint(r8)
            java.math.BigInteger r6 = r9.getN()
            java.math.BigInteger r7 = r9.getH()
            r2 = r0
            r2.<init>((java.lang.String) r3, (java.security.spec.EllipticCurve) r4, (java.security.spec.ECPoint) r5, (java.math.BigInteger) r6, (java.math.BigInteger) r7)
        L_0x00d9:
            r9 = r0
        L_0x00da:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertToSpec(org.bouncycastle.asn1.x9.X962Parameters, org.bouncycastle.math.ec.ECCurve):java.security.spec.ECParameterSpec");
    }

    public static ECParameterSpec convertToSpec(X9ECParameters x9ECParameters) {
        return new ECParameterSpec(convertCurve(x9ECParameters.getCurve(), (byte[]) null), convertPoint(x9ECParameters.getG()), x9ECParameters.getN(), x9ECParameters.getH().intValue());
    }

    public static ECParameterSpec convertToSpec(ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(convertCurve(eCDomainParameters.getCurve(), (byte[]) null), convertPoint(eCDomainParameters.getG()), eCDomainParameters.getN(), eCDomainParameters.getH().intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: org.bouncycastle.asn1.x9.X9ECParameters} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.bouncycastle.math.ec.ECCurve getCurve(org.bouncycastle.jcajce.provider.config.ProviderConfiguration r2, org.bouncycastle.asn1.x9.X962Parameters r3) {
        /*
            java.util.Set r0 = r2.getAcceptableNamedCurves()
            boolean r1 = r3.isNamedCurve()
            if (r1 == 0) goto L_0x003d
            org.bouncycastle.asn1.ASN1Primitive r3 = r3.getParameters()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r3 = org.bouncycastle.asn1.ASN1ObjectIdentifier.getInstance(r3)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0027
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L_0x001f
            goto L_0x0027
        L_0x001f:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "named curve not acceptable"
            r2.<init>(r3)
            throw r2
        L_0x0027:
            org.bouncycastle.asn1.x9.X9ECParameters r0 = org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getNamedCurveByOid(r3)
            if (r0 != 0) goto L_0x0038
            java.util.Map r2 = r2.getAdditionalECParameters()
            java.lang.Object r2 = r2.get(r3)
            r0 = r2
            org.bouncycastle.asn1.x9.X9ECParameters r0 = (org.bouncycastle.asn1.x9.X9ECParameters) r0
        L_0x0038:
            org.bouncycastle.math.ec.ECCurve r2 = r0.getCurve()
            goto L_0x0077
        L_0x003d:
            boolean r1 = r3.isImplicitlyCA()
            if (r1 == 0) goto L_0x004c
            org.bouncycastle.jce.spec.ECParameterSpec r2 = r2.getEcImplicitlyCa()
            org.bouncycastle.math.ec.ECCurve r2 = r2.getCurve()
            goto L_0x0077
        L_0x004c:
            org.bouncycastle.asn1.ASN1Primitive r2 = r3.getParameters()
            org.bouncycastle.asn1.ASN1Sequence r2 = org.bouncycastle.asn1.ASN1Sequence.getInstance(r2)
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x0078
            int r3 = r2.size()
            r0 = 3
            if (r3 <= r0) goto L_0x0066
            org.bouncycastle.asn1.x9.X9ECParameters r2 = org.bouncycastle.asn1.x9.X9ECParameters.getInstance(r2)
            goto L_0x0073
        L_0x0066:
            r3 = 0
            org.bouncycastle.asn1.ASN1Encodable r2 = r2.getObjectAt(r3)
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.asn1.ASN1ObjectIdentifier.getInstance(r2)
            org.bouncycastle.asn1.x9.X9ECParameters r2 = org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves.getByOIDX9(r2)
        L_0x0073:
            org.bouncycastle.math.ec.ECCurve r2 = r2.getCurve()
        L_0x0077:
            return r2
        L_0x0078:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "encoded parameters not acceptable"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.getCurve(org.bouncycastle.jcajce.provider.config.ProviderConfiguration, org.bouncycastle.asn1.x9.X962Parameters):org.bouncycastle.math.ec.ECCurve");
    }

    public static ECDomainParameters getDomainParameters(ProviderConfiguration providerConfiguration, ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec != null) {
            return ECUtil.getDomainParameters(providerConfiguration, convertSpec(eCParameterSpec));
        }
        org.bouncycastle.jce.spec.ECParameterSpec ecImplicitlyCa = providerConfiguration.getEcImplicitlyCa();
        return new ECDomainParameters(ecImplicitlyCa.getCurve(), ecImplicitlyCa.getG(), ecImplicitlyCa.getN(), ecImplicitlyCa.getH(), ecImplicitlyCa.getSeed());
    }
}
