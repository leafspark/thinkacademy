package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.util.Date;
import java.util.Enumeration;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.util.Arrays;

class X509CertificateObject extends X509CertificateImpl implements PKCS12BagAttributeCarrier {
    private PKCS12BagAttributeCarrier attrCarrier = new PKCS12BagAttributeCarrierImpl();
    private final Object cacheLock = new Object();
    private volatile int hashValue;
    private volatile boolean hashValueSet;
    private X509CertificateInternal internalCertificateValue;
    private X500Principal issuerValue;
    private PublicKey publicKeyValue;
    private X500Principal subjectValue;
    private long[] validityValues;

    private static class X509CertificateEncodingException extends CertificateEncodingException {
        private final Throwable cause;

        X509CertificateEncodingException(Throwable th) {
            this.cause = th;
        }

        public Throwable getCause() {
            return this.cause;
        }
    }

    X509CertificateObject(JcaJceHelper jcaJceHelper, Certificate certificate) throws CertificateParsingException {
        super(jcaJceHelper, certificate, createBasicConstraints(certificate), createKeyUsage(certificate), createSigAlgName(certificate), createSigAlgParams(certificate));
    }

    private static BasicConstraints createBasicConstraints(Certificate certificate) throws CertificateParsingException {
        try {
            byte[] extensionOctets = getExtensionOctets(certificate, "2.5.29.19");
            if (extensionOctets == null) {
                return null;
            }
            return BasicConstraints.getInstance(ASN1Primitive.fromByteArray(extensionOctets));
        } catch (Exception e) {
            throw new CertificateParsingException("cannot construct BasicConstraints: " + e);
        }
    }

    private static boolean[] createKeyUsage(Certificate certificate) throws CertificateParsingException {
        try {
            byte[] extensionOctets = getExtensionOctets(certificate, "2.5.29.15");
            if (extensionOctets == null) {
                return null;
            }
            DERBitString instance = DERBitString.getInstance(ASN1Primitive.fromByteArray(extensionOctets));
            byte[] bytes = instance.getBytes();
            int length = (bytes.length * 8) - instance.getPadBits();
            int i = 9;
            if (length >= 9) {
                i = length;
            }
            boolean[] zArr = new boolean[i];
            for (int i2 = 0; i2 != length; i2++) {
                zArr[i2] = (bytes[i2 / 8] & (128 >>> (i2 % 8))) != 0;
            }
            return zArr;
        } catch (Exception e) {
            throw new CertificateParsingException("cannot construct KeyUsage: " + e);
        }
    }

    private static String createSigAlgName(Certificate certificate) throws CertificateParsingException {
        try {
            return X509SignatureUtil.getSignatureName(certificate.getSignatureAlgorithm());
        } catch (Exception e) {
            throw new CertificateParsingException("cannot construct SigAlgName: " + e);
        }
    }

    private static byte[] createSigAlgParams(Certificate certificate) throws CertificateParsingException {
        try {
            ASN1Encodable parameters = certificate.getSignatureAlgorithm().getParameters();
            if (parameters == null) {
                return null;
            }
            return parameters.toASN1Primitive().getEncoded(ASN1Encoding.DER);
        } catch (Exception e) {
            throw new CertificateParsingException("cannot construct SigAlgParams: " + e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        r11 = null;
        r10 = r12.c.getEncoded(org.bouncycastle.asn1.ASN1Encoding.DER);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        r10 = null;
        r11 = new org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.X509CertificateEncodingException(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateInternal getInternalCertificate() {
        /*
            r12 = this;
            java.lang.Object r0 = r12.cacheLock
            monitor-enter(r0)
            org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateInternal r1 = r12.internalCertificateValue     // Catch:{ all -> 0x0040 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            return r1
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            r0 = 0
            org.bouncycastle.asn1.x509.Certificate r1 = r12.c     // Catch:{ IOException -> 0x0016 }
            java.lang.String r2 = "DER"
            byte[] r1 = r1.getEncoded(r2)     // Catch:{ IOException -> 0x0016 }
            r11 = r0
            r10 = r1
            goto L_0x001e
        L_0x0016:
            r1 = move-exception
            org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateObject$X509CertificateEncodingException r2 = new org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateObject$X509CertificateEncodingException
            r2.<init>(r1)
            r10 = r0
            r11 = r2
        L_0x001e:
            org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateInternal r0 = new org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateInternal
            org.bouncycastle.jcajce.util.JcaJceHelper r4 = r12.bcHelper
            org.bouncycastle.asn1.x509.Certificate r5 = r12.c
            org.bouncycastle.asn1.x509.BasicConstraints r6 = r12.basicConstraints
            boolean[] r7 = r12.keyUsage
            java.lang.String r8 = r12.sigAlgName
            byte[] r9 = r12.sigAlgParams
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            java.lang.Object r1 = r12.cacheLock
            monitor-enter(r1)
            org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateInternal r2 = r12.internalCertificateValue     // Catch:{ all -> 0x003d }
            if (r2 != 0) goto L_0x0039
            r12.internalCertificateValue = r0     // Catch:{ all -> 0x003d }
        L_0x0039:
            org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateInternal r0 = r12.internalCertificateValue     // Catch:{ all -> 0x003d }
            monitor-exit(r1)     // Catch:{ all -> 0x003d }
            return r0
        L_0x003d:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003d }
            throw r0
        L_0x0040:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.getInternalCertificate():org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateInternal");
    }

    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        long time = date.getTime();
        long[] validityValues2 = getValidityValues();
        if (time > validityValues2[1]) {
            throw new CertificateExpiredException("certificate expired on " + this.c.getEndDate().getTime());
        } else if (time < validityValues2[0]) {
            throw new CertificateNotYetValidException("certificate not valid till " + this.c.getStartDate().getTime());
        }
    }

    public boolean equals(Object obj) {
        X509CertificateInternal internalCertificate;
        DERBitString signature;
        if (obj == this) {
            return true;
        }
        if (obj instanceof X509CertificateObject) {
            X509CertificateObject x509CertificateObject = (X509CertificateObject) obj;
            if (!this.hashValueSet || !x509CertificateObject.hashValueSet) {
                if ((this.internalCertificateValue == null || x509CertificateObject.internalCertificateValue == null) && (signature = this.c.getSignature()) != null && !signature.equals((ASN1Primitive) x509CertificateObject.c.getSignature())) {
                    return false;
                }
            } else if (this.hashValue != x509CertificateObject.hashValue) {
                return false;
            }
            internalCertificate = getInternalCertificate();
            obj = x509CertificateObject.getInternalCertificate();
        } else {
            internalCertificate = getInternalCertificate();
        }
        return internalCertificate.equals(obj);
    }

    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.attrCarrier.getBagAttribute(aSN1ObjectIdentifier);
    }

    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        return Arrays.clone(getInternalCertificate().getEncoded());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        if (r3.issuerValue != null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
        r3.issuerValue = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0017, code lost:
        r0 = r3.issuerValue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0019, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000a, code lost:
        r0 = super.getIssuerX500Principal();
        r1 = r3.cacheLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        monitor-enter(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.security.auth.x500.X500Principal getIssuerX500Principal() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.cacheLock
            monitor-enter(r0)
            javax.security.auth.x500.X500Principal r1 = r3.issuerValue     // Catch:{ all -> 0x001e }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return r1
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            javax.security.auth.x500.X500Principal r0 = super.getIssuerX500Principal()
            java.lang.Object r1 = r3.cacheLock
            monitor-enter(r1)
            javax.security.auth.x500.X500Principal r2 = r3.issuerValue     // Catch:{ all -> 0x001b }
            if (r2 != 0) goto L_0x0017
            r3.issuerValue = r0     // Catch:{ all -> 0x001b }
        L_0x0017:
            javax.security.auth.x500.X500Principal r0 = r3.issuerValue     // Catch:{ all -> 0x001b }
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return r0
        L_0x001b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r0
        L_0x001e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.getIssuerX500Principal():javax.security.auth.x500.X500Principal");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        r1 = r3.cacheLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0017, code lost:
        if (r3.publicKeyValue != null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0019, code lost:
        r3.publicKeyValue = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001b, code lost:
        r0 = r3.publicKeyValue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001d, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x001e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000a, code lost:
        r0 = super.getPublicKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000e, code lost:
        if (r0 != null) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.PublicKey getPublicKey() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.cacheLock
            monitor-enter(r0)
            java.security.PublicKey r1 = r3.publicKeyValue     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            java.security.PublicKey r0 = super.getPublicKey()
            if (r0 != 0) goto L_0x0012
            r0 = 0
            return r0
        L_0x0012:
            java.lang.Object r1 = r3.cacheLock
            monitor-enter(r1)
            java.security.PublicKey r2 = r3.publicKeyValue     // Catch:{ all -> 0x001f }
            if (r2 != 0) goto L_0x001b
            r3.publicKeyValue = r0     // Catch:{ all -> 0x001f }
        L_0x001b:
            java.security.PublicKey r0 = r3.publicKeyValue     // Catch:{ all -> 0x001f }
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            return r0
        L_0x001f:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            throw r0
        L_0x0022:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.getPublicKey():java.security.PublicKey");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        if (r3.subjectValue != null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
        r3.subjectValue = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0017, code lost:
        r0 = r3.subjectValue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0019, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000a, code lost:
        r0 = super.getSubjectX500Principal();
        r1 = r3.cacheLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        monitor-enter(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.security.auth.x500.X500Principal getSubjectX500Principal() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.cacheLock
            monitor-enter(r0)
            javax.security.auth.x500.X500Principal r1 = r3.subjectValue     // Catch:{ all -> 0x001e }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return r1
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            javax.security.auth.x500.X500Principal r0 = super.getSubjectX500Principal()
            java.lang.Object r1 = r3.cacheLock
            monitor-enter(r1)
            javax.security.auth.x500.X500Principal r2 = r3.subjectValue     // Catch:{ all -> 0x001b }
            if (r2 != 0) goto L_0x0017
            r3.subjectValue = r0     // Catch:{ all -> 0x001b }
        L_0x0017:
            javax.security.auth.x500.X500Principal r0 = r3.subjectValue     // Catch:{ all -> 0x001b }
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return r0
        L_0x001b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r0
        L_0x001e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.getSubjectX500Principal():javax.security.auth.x500.X500Principal");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r4.validityValues != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        r4.validityValues = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        r0 = r4.validityValues;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000a, code lost:
        r0 = new long[]{super.getNotBefore().getTime(), super.getNotAfter().getTime()};
        r1 = r4.cacheLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        monitor-enter(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long[] getValidityValues() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.cacheLock
            monitor-enter(r0)
            long[] r1 = r4.validityValues     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return r1
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            r0 = 2
            long[] r0 = new long[r0]
            r1 = 0
            java.util.Date r2 = super.getNotBefore()
            long r2 = r2.getTime()
            r0[r1] = r2
            r1 = 1
            java.util.Date r2 = super.getNotAfter()
            long r2 = r2.getTime()
            r0[r1] = r2
            java.lang.Object r1 = r4.cacheLock
            monitor-enter(r1)
            long[] r2 = r4.validityValues     // Catch:{ all -> 0x0030 }
            if (r2 != 0) goto L_0x002c
            r4.validityValues = r0     // Catch:{ all -> 0x0030 }
        L_0x002c:
            long[] r0 = r4.validityValues     // Catch:{ all -> 0x0030 }
            monitor-exit(r1)     // Catch:{ all -> 0x0030 }
            return r0
        L_0x0030:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0030 }
            throw r0
        L_0x0033:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.getValidityValues():long[]");
    }

    public int hashCode() {
        if (!this.hashValueSet) {
            this.hashValue = getInternalCertificate().hashCode();
            this.hashValueSet = true;
        }
        return this.hashValue;
    }

    public int originalHashCode() {
        try {
            byte[] encoded = getInternalCertificate().getEncoded();
            int i = 0;
            for (int i2 = 1; i2 < encoded.length; i2++) {
                i += encoded[i2] * i2;
            }
            return i;
        } catch (CertificateEncodingException unused) {
            return 0;
        }
    }

    public void setBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.attrCarrier.setBagAttribute(aSN1ObjectIdentifier, aSN1Encodable);
    }
}
