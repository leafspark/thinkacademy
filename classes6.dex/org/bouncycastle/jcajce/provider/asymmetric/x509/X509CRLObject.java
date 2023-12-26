package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.security.cert.CRLException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.util.Arrays;

class X509CRLObject extends X509CRLImpl {
    private final Object cacheLock = new Object();
    private volatile int hashValue;
    private volatile boolean hashValueSet;
    private X509CRLInternal internalCRLValue;

    private static class X509CRLException extends CRLException {
        private final Throwable cause;

        X509CRLException(String str, Throwable th) {
            super(str);
            this.cause = th;
        }

        X509CRLException(Throwable th) {
            this.cause = th;
        }

        public Throwable getCause() {
            return this.cause;
        }
    }

    X509CRLObject(JcaJceHelper jcaJceHelper, CertificateList certificateList) throws CRLException {
        super(jcaJceHelper, certificateList, createSigAlgName(certificateList), createSigAlgParams(certificateList), isIndirectCRL(certificateList));
    }

    private static String createSigAlgName(CertificateList certificateList) throws CRLException {
        try {
            return X509SignatureUtil.getSignatureName(certificateList.getSignatureAlgorithm());
        } catch (Exception e) {
            throw new X509CRLException("CRL contents invalid: " + e.getMessage(), e);
        }
    }

    private static byte[] createSigAlgParams(CertificateList certificateList) throws CRLException {
        try {
            ASN1Encodable parameters = certificateList.getSignatureAlgorithm().getParameters();
            if (parameters == null) {
                return null;
            }
            return parameters.toASN1Primitive().getEncoded(ASN1Encoding.DER);
        } catch (Exception e) {
            throw new CRLException("CRL contents invalid: " + e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        r10 = null;
        r9 = r11.c.getEncoded(org.bouncycastle.asn1.ASN1Encoding.DER);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        r9 = null;
        r10 = new org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLObject.X509CRLException(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLInternal getInternalCRL() {
        /*
            r11 = this;
            java.lang.Object r0 = r11.cacheLock
            monitor-enter(r0)
            org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLInternal r1 = r11.internalCRLValue     // Catch:{ all -> 0x003e }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return r1
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            r0 = 0
            org.bouncycastle.asn1.x509.CertificateList r1 = r11.c     // Catch:{ IOException -> 0x0016 }
            java.lang.String r2 = "DER"
            byte[] r1 = r1.getEncoded(r2)     // Catch:{ IOException -> 0x0016 }
            r10 = r0
            r9 = r1
            goto L_0x001e
        L_0x0016:
            r1 = move-exception
            org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLObject$X509CRLException r2 = new org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLObject$X509CRLException
            r2.<init>(r1)
            r9 = r0
            r10 = r2
        L_0x001e:
            org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLInternal r0 = new org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLInternal
            org.bouncycastle.jcajce.util.JcaJceHelper r4 = r11.bcHelper
            org.bouncycastle.asn1.x509.CertificateList r5 = r11.c
            java.lang.String r6 = r11.sigAlgName
            byte[] r7 = r11.sigAlgParams
            boolean r8 = r11.isIndirect
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            java.lang.Object r1 = r11.cacheLock
            monitor-enter(r1)
            org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLInternal r2 = r11.internalCRLValue     // Catch:{ all -> 0x003b }
            if (r2 != 0) goto L_0x0037
            r11.internalCRLValue = r0     // Catch:{ all -> 0x003b }
        L_0x0037:
            org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLInternal r0 = r11.internalCRLValue     // Catch:{ all -> 0x003b }
            monitor-exit(r1)     // Catch:{ all -> 0x003b }
            return r0
        L_0x003b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003b }
            throw r0
        L_0x003e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLObject.getInternalCRL():org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLInternal");
    }

    private static boolean isIndirectCRL(CertificateList certificateList) throws CRLException {
        try {
            byte[] extensionOctets = getExtensionOctets(certificateList, Extension.issuingDistributionPoint.getId());
            if (extensionOctets == null) {
                return false;
            }
            return IssuingDistributionPoint.getInstance(extensionOctets).isIndirectCRL();
        } catch (Exception e) {
            throw new ExtCRLException("Exception reading IssuingDistributionPoint", e);
        }
    }

    public boolean equals(Object obj) {
        X509CRLInternal internalCRL;
        DERBitString signature;
        if (this == obj) {
            return true;
        }
        if (obj instanceof X509CRLObject) {
            X509CRLObject x509CRLObject = (X509CRLObject) obj;
            if (!this.hashValueSet || !x509CRLObject.hashValueSet) {
                if ((this.internalCRLValue == null || x509CRLObject.internalCRLValue == null) && (signature = this.c.getSignature()) != null && !signature.equals((ASN1Primitive) x509CRLObject.c.getSignature())) {
                    return false;
                }
            } else if (this.hashValue != x509CRLObject.hashValue) {
                return false;
            }
            internalCRL = getInternalCRL();
            obj = x509CRLObject.getInternalCRL();
        } else {
            internalCRL = getInternalCRL();
        }
        return internalCRL.equals(obj);
    }

    public byte[] getEncoded() throws CRLException {
        return Arrays.clone(getInternalCRL().getEncoded());
    }

    public int hashCode() {
        if (!this.hashValueSet) {
            this.hashValue = getInternalCRL().hashCode();
            this.hashValueSet = true;
        }
        return this.hashValue;
    }
}
