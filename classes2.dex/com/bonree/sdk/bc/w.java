package com.bonree.sdk.bc;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

public final class w {
    private static final c a = new c(32, "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFD97", "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFD94", "A6", "1", "8D91E471E0989CDA27DF505A453F2B7635294F2DDF23E3B122ACC99C9E9F1E14", "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF6C611070995AD10045841B09B761B893");
    private static final c b = new c(32, "FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF", "FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC", "5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B", "6B17D1F2E12C4247F8BCE6E563A440F277037D812DEB33A0F4A13945D898C296", "4FE342E2FE1A7F9B8EE7EB4A7C0F9E162BCE33576B315ECECBB6406837BF51F5", "FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551");
    private static final c c = new c(48, "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF", "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC", "B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF", "AA87CA22BE8B05378EB1C71EF320AD746E1D3B628BA79B9859F741E082542A385502F25DBF55296C3A545E3872760AB7", "3617DE4A96262C6F5D9E98BF9292DC29F8F41DBD289A147CE9DA3113B5F0B8C00A60B1CE1D7E819D7A431D7C90EA0E5F", "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973");
    private static final int d = 48;
    private static final int e = 2;
    private static final int f = 20;

    public static class a {
        private static int a = 1;
        private static int b = 2;
        private static int c = 3;
        private static int d = 5;
        private static int e = 6;
        private static int f = 7;
        private static int g = 8;
        private static int h = 10;
        private static int i = 12;
        private static int j = 13;
        private static int k = 14;
        private static int l = 252;
        private static int m = 253;
        private static int n = 254;
        private static bc o;

        private a() {
        }

        static {
            bc bcVar = new bc("DNSSEC algorithm", 2);
            o = bcVar;
            bcVar.b(255);
            o.a(true);
            o.a(1, "RSAMD5");
            o.a(2, "DH");
            o.a(3, "DSA");
            o.a(5, "RSASHA1");
            o.a(6, "DSA-NSEC3-SHA1");
            o.a(7, "RSA-NSEC3-SHA1");
            o.a(8, "RSASHA256");
            o.a(10, "RSASHA512");
            o.a(12, "ECC-GOST");
            o.a(13, "ECDSAP256SHA256");
            o.a(14, "ECDSAP384SHA384");
            o.a(252, "INDIRECT");
            o.a(253, "PRIVATEDNS");
            o.a(254, "PRIVATEOID");
        }

        public static String a(int i2) {
            return o.d(i2);
        }

        public static int a(String str) {
            return o.b(str);
        }
    }

    private w() {
    }

    private static void a(v vVar, ci ciVar) {
        vVar.c(ciVar.l());
        vVar.b(ciVar.k());
        vVar.b(ciVar.j());
        vVar.a(ciVar.i());
        vVar.a(ciVar.h().getTime() / 1000);
        vVar.a(ciVar.g().getTime() / 1000);
        vVar.c(ciVar.f());
        ciVar.e().a(vVar);
    }

    private static byte[] a(bw bwVar, bx bxVar) {
        v vVar = new v();
        a(vVar, (ci) bwVar);
        int e2 = bxVar.e();
        ca[] caVarArr = new ca[e2];
        Iterator c2 = bxVar.c();
        bn o = bxVar.i().o();
        int j2 = bwVar.j() + 1;
        bn a2 = o.d() > j2 ? o.a(o.d() - j2) : null;
        int i2 = e2;
        while (c2.hasNext()) {
            i2--;
            caVarArr[i2] = (ca) c2.next();
        }
        Arrays.sort(caVarArr);
        v vVar2 = new v();
        if (a2 != null) {
            a2.a(vVar2);
        } else {
            o.a(vVar2);
        }
        vVar2.c(bxVar.i().q());
        vVar2.c(bxVar.i().r());
        vVar2.a(bwVar.i());
        for (int i3 = 0; i3 < e2; i3++) {
            vVar.a(vVar2.d());
            int a3 = vVar.a();
            vVar.c(0);
            vVar.a(caVarArr[i3].m());
            vVar.b();
            vVar.a(a3);
            vVar.c((vVar.a() - a3) - 2);
            vVar.c();
        }
        return vVar.d();
    }

    private static byte[] a(cj cjVar, bb bbVar, byte[] bArr) {
        v vVar = new v();
        a(vVar, (ci) cjVar);
        if (bArr != null) {
            vVar.a(bArr);
        }
        bbVar.a(vVar);
        return vVar.d();
    }

    public static class b extends Exception {
        b(String str) {
            super(str);
        }
    }

    public static class k extends b {
        k(int i) {
            super("Unsupported algorithm: " + i);
        }
    }

    public static class f extends b {
        f(ao aoVar) {
            super("Invalid key data: " + aoVar.b());
        }
    }

    public static class e extends b {
        private ao a;
        private ci b;

        e(ao aoVar, ci ciVar) {
            super("key " + aoVar.o() + "/" + a.a(aoVar.f()) + "/" + aoVar.d() + " does not match signature " + ciVar.e() + "/" + a.a(ciVar.k()) + "/" + ciVar.f());
        }
    }

    public static class h extends b {
        private Date a;
        private Date b;

        h(Date date, Date date2) {
            super("signature expired");
            this.a = date;
            this.b = date2;
        }

        private Date a() {
            return this.a;
        }

        private Date b() {
            return this.b;
        }
    }

    public static class i extends b {
        private Date a;
        private Date b;

        i(Date date, Date date2) {
            super("signature is not yet valid");
            this.a = date;
            this.b = date2;
        }

        private Date a() {
            return this.a;
        }

        private Date b() {
            return this.b;
        }
    }

    public static class j extends b {
        j() {
            super("signature verification failed");
        }
    }

    public static class d extends IllegalArgumentException {
        d() {
            super("incompatible keys");
        }

        public d(int i) {
            super("Invalid DNS class: " + i);
        }

        public d(long j) {
            super("Invalid DNS TTL: " + j);
        }

        public d(bn bnVar) {
            super("'" + bnVar + "' is not an absolute name");
        }

        private d(String str) {
            super(str);
        }
    }

    public static class g extends b {
        g() {
            super("no signature found");
        }
    }

    private static int a(BigInteger bigInteger) {
        return (bigInteger.bitLength() + 7) / 8;
    }

    private static BigInteger a(t tVar, int i2) throws IOException {
        return new BigInteger(1, tVar.d(i2));
    }

    private static BigInteger a(t tVar) {
        return new BigInteger(1, tVar.j());
    }

    private static byte[] a(byte[] bArr) {
        if (bArr[0] != 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[(bArr.length - 1)];
        System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 1);
        return bArr2;
    }

    private static void b(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length / 2; i2++) {
            int length = (bArr.length - i2) - 1;
            byte b2 = bArr[i2];
            bArr[i2] = bArr[length];
            bArr[length] = b2;
        }
    }

    private static BigInteger b(t tVar, int i2) throws IOException {
        byte[] d2 = tVar.d(i2);
        b(d2);
        return new BigInteger(1, d2);
    }

    private static void a(v vVar, BigInteger bigInteger) {
        vVar.a(a(bigInteger.toByteArray()));
    }

    private static void a(v vVar, BigInteger bigInteger, int i2) {
        byte[] a2 = a(bigInteger.toByteArray());
        if (a2.length <= i2) {
            if (a2.length < i2) {
                vVar.a(new byte[(i2 - a2.length)]);
            }
            vVar.a(a2);
            return;
        }
        throw new IllegalArgumentException();
    }

    private static void b(v vVar, BigInteger bigInteger, int i2) {
        byte[] a2 = a(bigInteger.toByteArray());
        if (a2.length <= i2) {
            b(a2);
            vVar.a(a2);
            if (a2.length < i2) {
                vVar.a(new byte[(i2 - a2.length)]);
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    private static PublicKey b(ao aoVar) throws IOException, GeneralSecurityException {
        t tVar = new t(aoVar.e());
        int g2 = tVar.g();
        if (g2 == 0) {
            g2 = tVar.h();
        }
        BigInteger a2 = a(tVar, g2);
        return KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, tVar.j()), a2));
    }

    private static PublicKey c(ao aoVar) throws IOException, GeneralSecurityException, f {
        t tVar = new t(aoVar.e());
        int g2 = tVar.g();
        if (g2 <= 8) {
            BigInteger a2 = a(tVar, 20);
            int i2 = (g2 << 3) + 64;
            BigInteger a3 = a(tVar, i2);
            BigInteger a4 = a(tVar, i2);
            return KeyFactory.getInstance("DSA").generatePublic(new DSAPublicKeySpec(a(tVar, i2), a3, a2, a4));
        }
        throw new f(aoVar);
    }

    static class c {
        int a;
        ECParameterSpec b = new ECParameterSpec(this.i, new ECPoint(this.f, this.g), this.h, 1);
        private BigInteger c;
        private BigInteger d;
        private BigInteger e;
        private BigInteger f;
        private BigInteger g;
        private BigInteger h;
        private EllipticCurve i = new EllipticCurve(new ECFieldFp(this.c), this.d, this.e);

        c(int i2, String str, String str2, String str3, String str4, String str5, String str6) {
            this.a = i2;
            this.c = new BigInteger(str, 16);
            this.d = new BigInteger(str2, 16);
            this.e = new BigInteger(str3, 16);
            this.f = new BigInteger(str4, 16);
            this.g = new BigInteger(str5, 16);
            this.h = new BigInteger(str6, 16);
        }
    }

    private static PublicKey a(ao aoVar, c cVar) throws IOException, GeneralSecurityException, f {
        t tVar = new t(aoVar.e());
        return KeyFactory.getInstance("ECGOST3410").generatePublic(new ECPublicKeySpec(new ECPoint(b(tVar, cVar.a), b(tVar, cVar.a)), cVar.b));
    }

    private static PublicKey b(ao aoVar, c cVar) throws IOException, GeneralSecurityException, f {
        t tVar = new t(aoVar.e());
        return KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(new ECPoint(a(tVar, cVar.a), a(tVar, cVar.a)), cVar.b));
    }

    static PublicKey a(ao aoVar) throws b {
        int f2 = aoVar.f();
        switch (f2) {
            case 1:
            case 5:
            case 7:
            case 8:
            case 10:
                t tVar = new t(aoVar.e());
                int g2 = tVar.g();
                if (g2 == 0) {
                    g2 = tVar.h();
                }
                BigInteger a2 = a(tVar, g2);
                return KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, tVar.j()), a2));
            case 3:
            case 6:
                t tVar2 = new t(aoVar.e());
                int g3 = tVar2.g();
                if (g3 <= 8) {
                    BigInteger a3 = a(tVar2, 20);
                    int i2 = (g3 << 3) + 64;
                    BigInteger a4 = a(tVar2, i2);
                    BigInteger a5 = a(tVar2, i2);
                    return KeyFactory.getInstance("DSA").generatePublic(new DSAPublicKeySpec(a(tVar2, i2), a4, a3, a5));
                }
                throw new f(aoVar);
            case 12:
                return a(aoVar, a);
            case 13:
                return b(aoVar, b);
            case 14:
                return b(aoVar, c);
            default:
                try {
                    throw new k(f2);
                } catch (IOException unused) {
                    throw new f(aoVar);
                } catch (GeneralSecurityException e2) {
                    throw new b(e2.toString());
                }
        }
    }

    private static byte[] a(RSAPublicKey rSAPublicKey) {
        v vVar = new v();
        BigInteger publicExponent = rSAPublicKey.getPublicExponent();
        BigInteger modulus = rSAPublicKey.getModulus();
        int a2 = a(publicExponent);
        if (a2 < 256) {
            vVar.b(a2);
        } else {
            vVar.b(0);
            vVar.c(a2);
        }
        a(vVar, publicExponent);
        a(vVar, modulus);
        return vVar.d();
    }

    private static byte[] a(DSAPublicKey dSAPublicKey) {
        v vVar = new v();
        BigInteger q = dSAPublicKey.getParams().getQ();
        BigInteger p = dSAPublicKey.getParams().getP();
        BigInteger g2 = dSAPublicKey.getParams().getG();
        BigInteger y = dSAPublicKey.getY();
        int length = (p.toByteArray().length - 64) / 8;
        vVar.b(length);
        a(vVar, q);
        a(vVar, p);
        int i2 = (length * 8) + 64;
        a(vVar, g2, i2);
        a(vVar, y, i2);
        return vVar.d();
    }

    private static byte[] a(ECPublicKey eCPublicKey, c cVar) {
        v vVar = new v();
        BigInteger affineX = eCPublicKey.getW().getAffineX();
        BigInteger affineY = eCPublicKey.getW().getAffineY();
        b(vVar, affineX, cVar.a);
        b(vVar, affineY, cVar.a);
        return vVar.d();
    }

    private static byte[] b(ECPublicKey eCPublicKey, c cVar) {
        v vVar = new v();
        BigInteger affineX = eCPublicKey.getW().getAffineX();
        BigInteger affineY = eCPublicKey.getW().getAffineY();
        a(vVar, affineX, cVar.a);
        a(vVar, affineY, cVar.a);
        return vVar.d();
    }

    static byte[] a(PublicKey publicKey, int i2) throws b {
        switch (i2) {
            case 1:
            case 5:
            case 7:
            case 8:
            case 10:
                if (publicKey instanceof RSAPublicKey) {
                    RSAPublicKey rSAPublicKey = (RSAPublicKey) publicKey;
                    v vVar = new v();
                    BigInteger publicExponent = rSAPublicKey.getPublicExponent();
                    BigInteger modulus = rSAPublicKey.getModulus();
                    int a2 = a(publicExponent);
                    if (a2 < 256) {
                        vVar.b(a2);
                    } else {
                        vVar.b(0);
                        vVar.c(a2);
                    }
                    a(vVar, publicExponent);
                    a(vVar, modulus);
                    return vVar.d();
                }
                throw new d();
            case 3:
            case 6:
                if (publicKey instanceof DSAPublicKey) {
                    DSAPublicKey dSAPublicKey = (DSAPublicKey) publicKey;
                    v vVar2 = new v();
                    BigInteger q = dSAPublicKey.getParams().getQ();
                    BigInteger p = dSAPublicKey.getParams().getP();
                    BigInteger g2 = dSAPublicKey.getParams().getG();
                    BigInteger y = dSAPublicKey.getY();
                    int length = (p.toByteArray().length - 64) / 8;
                    vVar2.b(length);
                    a(vVar2, q);
                    a(vVar2, p);
                    int i3 = (length * 8) + 64;
                    a(vVar2, g2, i3);
                    a(vVar2, y, i3);
                    return vVar2.d();
                }
                throw new d();
            case 12:
                if (publicKey instanceof ECPublicKey) {
                    ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
                    c cVar = a;
                    v vVar3 = new v();
                    BigInteger affineX = eCPublicKey.getW().getAffineX();
                    BigInteger affineY = eCPublicKey.getW().getAffineY();
                    b(vVar3, affineX, cVar.a);
                    b(vVar3, affineY, cVar.a);
                    return vVar3.d();
                }
                throw new d();
            case 13:
                if (publicKey instanceof ECPublicKey) {
                    return b((ECPublicKey) publicKey, b);
                }
                throw new d();
            case 14:
                if (publicKey instanceof ECPublicKey) {
                    return b((ECPublicKey) publicKey, c);
                }
                throw new d();
            default:
                throw new k(i2);
        }
    }

    private static String a(int i2) throws k {
        switch (i2) {
            case 1:
                return "MD5withRSA";
            case 3:
            case 6:
                return "SHA1withDSA";
            case 5:
            case 7:
                return "SHA1withRSA";
            case 8:
                return "SHA256withRSA";
            case 10:
                return "SHA512withRSA";
            case 12:
                return "GOST3411withECGOST3410";
            case 13:
                return "SHA256withECDSA";
            case 14:
                return "SHA384withECDSA";
            default:
                throw new k(i2);
        }
    }

    private static byte[] c(byte[] bArr) throws b, IOException {
        if (bArr.length == 41) {
            t tVar = new t(bArr);
            v vVar = new v();
            tVar.g();
            byte[] d2 = tVar.d(20);
            int i2 = 21;
            int i3 = d2[0] < 0 ? 21 : 20;
            byte[] d3 = tVar.d(20);
            if (d3[0] >= 0) {
                i2 = 20;
            }
            vVar.b(48);
            vVar.b(i3 + i2 + 4);
            vVar.b(2);
            vVar.b(i3);
            if (i3 > 20) {
                vVar.b(0);
            }
            vVar.a(d2);
            vVar.b(2);
            vVar.b(i2);
            if (i2 > 20) {
                vVar.b(0);
            }
            vVar.a(d3);
            return vVar.d();
        }
        throw new j();
    }

    private static byte[] a(byte[] bArr, int i2) throws IOException {
        t tVar = new t(bArr);
        v vVar = new v();
        vVar.b(i2);
        if (tVar.g() == 48) {
            tVar.g();
            if (tVar.g() == 2) {
                int g2 = tVar.g();
                if (g2 == 21) {
                    if (tVar.g() != 0) {
                        throw new IOException();
                    }
                } else if (g2 != 20) {
                    throw new IOException();
                }
                vVar.a(tVar.d(20));
                if (tVar.g() == 2) {
                    int g3 = tVar.g();
                    if (g3 == 21) {
                        if (tVar.g() != 0) {
                            throw new IOException();
                        }
                    } else if (g3 != 20) {
                        throw new IOException();
                    }
                    vVar.a(tVar.d(20));
                    return vVar.d();
                }
                throw new IOException();
            }
            throw new IOException();
        }
        throw new IOException();
    }

    private static byte[] a(byte[] bArr, c cVar) throws b, IOException {
        if (bArr.length == (cVar.a << 1)) {
            return bArr;
        }
        throw new j();
    }

    private static byte[] b(byte[] bArr, c cVar) throws b, IOException {
        if (bArr.length == (cVar.a << 1)) {
            t tVar = new t(bArr);
            v vVar = new v();
            byte[] d2 = tVar.d(cVar.a);
            int i2 = cVar.a;
            if (d2[0] < 0) {
                i2++;
            }
            byte[] d3 = tVar.d(cVar.a);
            int i3 = cVar.a;
            if (d3[0] < 0) {
                i3++;
            }
            vVar.b(48);
            vVar.b(i2 + i3 + 4);
            vVar.b(2);
            vVar.b(i2);
            if (i2 > cVar.a) {
                vVar.b(0);
            }
            vVar.a(d2);
            vVar.b(2);
            vVar.b(i3);
            if (i3 > cVar.a) {
                vVar.b(0);
            }
            vVar.a(d3);
            return vVar.d();
        }
        throw new j();
    }

    private static byte[] c(byte[] bArr, c cVar) throws IOException {
        t tVar = new t(bArr);
        v vVar = new v();
        if (tVar.g() == 48) {
            tVar.g();
            if (tVar.g() == 2) {
                int g2 = tVar.g();
                if (g2 == cVar.a + 1) {
                    if (tVar.g() != 0) {
                        throw new IOException();
                    }
                } else if (g2 != cVar.a) {
                    throw new IOException();
                }
                vVar.a(tVar.d(cVar.a));
                if (tVar.g() == 2) {
                    int g3 = tVar.g();
                    if (g3 == cVar.a + 1) {
                        if (tVar.g() != 0) {
                            throw new IOException();
                        }
                    } else if (g3 != cVar.a) {
                        throw new IOException();
                    }
                    vVar.a(tVar.d(cVar.a));
                    return vVar.d();
                }
                throw new IOException();
            }
            throw new IOException();
        }
        throw new IOException();
    }

    private static void a(PublicKey publicKey, int i2, byte[] bArr, byte[] bArr2) throws b {
        if (publicKey instanceof DSAPublicKey) {
            try {
                if (bArr2.length == 41) {
                    t tVar = new t(bArr2);
                    v vVar = new v();
                    tVar.g();
                    byte[] d2 = tVar.d(20);
                    int i3 = 21;
                    int i4 = d2[0] < 0 ? 21 : 20;
                    byte[] d3 = tVar.d(20);
                    if (d3[0] >= 0) {
                        i3 = 20;
                    }
                    vVar.b(48);
                    vVar.b(i4 + i3 + 4);
                    vVar.b(2);
                    vVar.b(i4);
                    if (i4 > 20) {
                        vVar.b(0);
                    }
                    vVar.a(d2);
                    vVar.b(2);
                    vVar.b(i3);
                    if (i3 > 20) {
                        vVar.b(0);
                    }
                    vVar.a(d3);
                    bArr2 = vVar.d();
                } else {
                    throw new j();
                }
            } catch (IOException unused) {
                throw new IllegalStateException();
            }
        } else if (publicKey instanceof ECPublicKey) {
            switch (i2) {
                case 12:
                    if (bArr2.length == (a.a << 1)) {
                        break;
                    } else {
                        throw new j();
                    }
                case 13:
                    bArr2 = b(bArr2, b);
                    break;
                case 14:
                    bArr2 = b(bArr2, c);
                    break;
                default:
                    try {
                        throw new k(i2);
                    } catch (IOException unused2) {
                        throw new IllegalStateException();
                    }
            }
        }
        try {
            Signature instance = Signature.getInstance(a(i2));
            instance.initVerify(publicKey);
            instance.update(bArr);
            if (!instance.verify(bArr2)) {
                throw new j();
            }
        } catch (GeneralSecurityException e2) {
            throw new b(e2.toString());
        }
    }

    private static boolean a(ci ciVar, ao aoVar) {
        return aoVar.f() == ciVar.k() && aoVar.d() == ciVar.f() && aoVar.o().equals(ciVar.e());
    }

    private static void a(bx bxVar, bw bwVar, u uVar) throws b {
        if (a((ci) bwVar, (ao) uVar)) {
            Date date = new Date();
            if (date.compareTo(bwVar.h()) > 0) {
                throw new h(bwVar.h(), date);
            } else if (date.compareTo(bwVar.g()) >= 0) {
                a(uVar.f_(), bwVar.k(), a(bwVar, bxVar), bwVar.d());
            } else {
                throw new i(bwVar.g(), date);
            }
        } else {
            throw new e(uVar, bwVar);
        }
    }

    private static byte[] a(PrivateKey privateKey, PublicKey publicKey, int i2, byte[] bArr, String str) throws b {
        Signature signature;
        if (str != null) {
            try {
                signature = Signature.getInstance(a(i2), str);
            } catch (GeneralSecurityException e2) {
                throw new b(e2.toString());
            }
        } else {
            signature = Signature.getInstance(a(i2));
        }
        signature.initSign(privateKey);
        signature.update(bArr);
        byte[] sign = signature.sign();
        if (publicKey instanceof DSAPublicKey) {
            try {
                t tVar = new t(sign);
                v vVar = new v();
                vVar.b((a(((DSAPublicKey) publicKey).getParams().getP()) - 64) / 8);
                if (tVar.g() == 48) {
                    tVar.g();
                    if (tVar.g() == 2) {
                        int g2 = tVar.g();
                        if (g2 == 21) {
                            if (tVar.g() != 0) {
                                throw new IOException();
                            }
                        } else if (g2 != 20) {
                            throw new IOException();
                        }
                        vVar.a(tVar.d(20));
                        if (tVar.g() == 2) {
                            int g3 = tVar.g();
                            if (g3 == 21) {
                                if (tVar.g() != 0) {
                                    throw new IOException();
                                }
                            } else if (g3 != 20) {
                                throw new IOException();
                            }
                            vVar.a(tVar.d(20));
                            return vVar.d();
                        }
                        throw new IOException();
                    }
                    throw new IOException();
                }
                throw new IOException();
            } catch (IOException unused) {
                throw new IllegalStateException();
            }
        } else if (!(publicKey instanceof ECPublicKey)) {
            return sign;
        } else {
            switch (i2) {
                case 12:
                    return sign;
                case 13:
                    return c(sign, b);
                case 14:
                    return c(sign, c);
                default:
                    try {
                        throw new k(i2);
                    } catch (IOException unused2) {
                        throw new IllegalStateException();
                    }
            }
        }
    }

    private static void a(PrivateKey privateKey, int i2) throws k {
        switch (i2) {
            case 1:
            case 5:
            case 7:
            case 8:
            case 10:
                if (!(privateKey instanceof RSAPrivateKey)) {
                    throw new d();
                }
                return;
            case 3:
            case 6:
                if (!(privateKey instanceof DSAPrivateKey)) {
                    throw new d();
                }
                return;
            case 12:
            case 13:
            case 14:
                if (!(privateKey instanceof ECPrivateKey)) {
                    throw new d();
                }
                return;
            default:
                throw new k(i2);
        }
    }

    private static bw a(bx bxVar, u uVar, PrivateKey privateKey, Date date, Date date2, String str) throws b {
        int f2 = uVar.f();
        a(privateKey, f2);
        bw bwVar = r1;
        bw bwVar2 = new bw(bxVar.i().o(), bxVar.i().r(), bxVar.h(), bxVar.i().q(), f2, bxVar.h(), date2, date, uVar.d(), uVar.o(), (byte[]) null);
        bw bwVar3 = bwVar;
        bwVar3.b(a(privateKey, uVar.f_(), f2, a(bwVar, bxVar), (String) null));
        return bwVar3;
    }

    static cj a(bb bbVar, cj cjVar, ap apVar, PrivateKey privateKey, Date date, Date date2) throws b {
        int f2 = apVar.f();
        a(privateKey, f2);
        cj cjVar2 = r1;
        cj cjVar3 = new cj(bn.a, 255, 0, 0, f2, 0, date2, date, apVar.d(), apVar.o(), (byte[]) null);
        v vVar = new v();
        a(vVar, (ci) cjVar2);
        if (cjVar != null) {
            vVar.a(cjVar.d());
        }
        vVar.a(bbVar.g());
        cj cjVar4 = cjVar2;
        cjVar4.b(a(privateKey, apVar.f_(), f2, vVar.d(), (String) null));
        return cjVar4;
    }

    static void a(bb bbVar, byte[] bArr, cj cjVar, cj cjVar2, ap apVar) throws b {
        if (bbVar.c == 0) {
            throw new g();
        } else if (a((ci) cjVar, (ao) apVar)) {
            Date date = new Date();
            if (date.compareTo(cjVar.h()) > 0) {
                throw new h(cjVar.h(), date);
            } else if (date.compareTo(cjVar.g()) >= 0) {
                v vVar = new v();
                a(vVar, (ci) cjVar);
                if (cjVar2 != null) {
                    vVar.a(cjVar2.d());
                }
                ai aiVar = (ai) bbVar.a().clone();
                aiVar.e(3);
                vVar.a(aiVar.a());
                vVar.a(bArr, 12, bbVar.c - 12);
                a(apVar.f_(), cjVar.k(), vVar.d(), cjVar.d());
            } else {
                throw new i(cjVar.g(), date);
            }
        } else {
            throw new e(apVar, cjVar);
        }
    }

    static byte[] a(u uVar, int i2) {
        MessageDigest messageDigest;
        if (i2 == 1) {
            messageDigest = MessageDigest.getInstance("sha-1");
        } else if (i2 == 2) {
            messageDigest = MessageDigest.getInstance("sha-256");
        } else if (i2 == 3) {
            messageDigest = MessageDigest.getInstance("GOST3411");
        } else if (i2 == 4) {
            try {
                messageDigest = MessageDigest.getInstance("sha-384");
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("no message digest support");
            }
        } else {
            throw new IllegalArgumentException("unknown DS digest type " + i2);
        }
        messageDigest.update(uVar.o().e());
        messageDigest.update(uVar.m());
        return messageDigest.digest();
    }

    private static bw a(bx bxVar, u uVar, PrivateKey privateKey, Date date, Date date2) throws b {
        int f2 = uVar.f();
        a(privateKey, f2);
        bw bwVar = r1;
        bw bwVar2 = new bw(bxVar.i().o(), bxVar.i().r(), bxVar.h(), bxVar.i().q(), f2, bxVar.h(), date2, date, uVar.d(), uVar.o(), (byte[]) null);
        bw bwVar3 = bwVar;
        bwVar3.b(a(privateKey, uVar.f_(), f2, a(bwVar, bxVar), (String) null));
        return bwVar3;
    }
}
