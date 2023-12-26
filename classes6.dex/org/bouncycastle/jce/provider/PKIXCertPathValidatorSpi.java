package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.TBSCertificate;
import org.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.jcajce.interfaces.BCX509Certificate;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.x509.ExtendedPKIXParameters;

public class PKIXCertPathValidatorSpi extends CertPathValidatorSpi {
    private final JcaJceHelper helper;
    private final boolean isForCRLCheck;

    public PKIXCertPathValidatorSpi() {
        this(false);
    }

    public PKIXCertPathValidatorSpi(boolean z) {
        this.helper = new BCJcaJceHelper();
        this.isForCRLCheck = z;
    }

    static void checkCertificate(X509Certificate x509Certificate) throws AnnotatedException {
        if (x509Certificate instanceof BCX509Certificate) {
            RuntimeException runtimeException = null;
            try {
                if (((BCX509Certificate) x509Certificate).getTBSCertificateNative() != null) {
                    return;
                }
            } catch (RuntimeException e) {
                runtimeException = e;
            }
            throw new AnnotatedException("unable to process TBSCertificate", runtimeException);
        }
        try {
            TBSCertificate.getInstance(x509Certificate.getTBSCertificate());
        } catch (CertificateEncodingException e2) {
            throw new AnnotatedException("unable to process TBSCertificate", e2);
        } catch (IllegalArgumentException e3) {
            throw new AnnotatedException(e3.getMessage());
        }
    }

    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        PKIXExtendedParameters pKIXExtendedParameters;
        List<? extends Certificate> list;
        int i;
        PublicKey publicKey;
        X500Name x500Name;
        HashSet hashSet;
        List list2;
        int i2;
        int i3;
        ArrayList[] arrayListArr;
        HashSet hashSet2;
        CertPath certPath2 = certPath;
        CertPathParameters certPathParameters2 = certPathParameters;
        if (certPathParameters2 instanceof PKIXParameters) {
            PKIXExtendedParameters.Builder builder = new PKIXExtendedParameters.Builder((PKIXParameters) certPathParameters2);
            if (certPathParameters2 instanceof ExtendedPKIXParameters) {
                ExtendedPKIXParameters extendedPKIXParameters = (ExtendedPKIXParameters) certPathParameters2;
                builder.setUseDeltasEnabled(extendedPKIXParameters.isUseDeltasEnabled());
                builder.setValidityModel(extendedPKIXParameters.getValidityModel());
            }
            pKIXExtendedParameters = builder.build();
        } else if (certPathParameters2 instanceof PKIXExtendedBuilderParameters) {
            pKIXExtendedParameters = ((PKIXExtendedBuilderParameters) certPathParameters2).getBaseParameters();
        } else if (certPathParameters2 instanceof PKIXExtendedParameters) {
            pKIXExtendedParameters = (PKIXExtendedParameters) certPathParameters2;
        } else {
            throw new InvalidAlgorithmParameterException("Parameters must be a " + PKIXParameters.class.getName() + " instance.");
        }
        if (pKIXExtendedParameters.getTrustAnchors() != null) {
            List<? extends Certificate> certificates = certPath.getCertificates();
            int size = certificates.size();
            if (!certificates.isEmpty()) {
                Date validityDate = CertPathValidatorUtilities.getValidityDate(pKIXExtendedParameters, new Date());
                Set initialPolicies = pKIXExtendedParameters.getInitialPolicies();
                try {
                    TrustAnchor findTrustAnchor = CertPathValidatorUtilities.findTrustAnchor((X509Certificate) certificates.get(certificates.size() - 1), pKIXExtendedParameters.getTrustAnchors(), pKIXExtendedParameters.getSigProvider());
                    if (findTrustAnchor != null) {
                        checkCertificate(findTrustAnchor.getTrustedCert());
                        PKIXExtendedParameters build = new PKIXExtendedParameters.Builder(pKIXExtendedParameters).setTrustAnchor(findTrustAnchor).build();
                        int i4 = size + 1;
                        ArrayList[] arrayListArr2 = new ArrayList[i4];
                        for (int i5 = 0; i5 < i4; i5++) {
                            arrayListArr2[i5] = new ArrayList();
                        }
                        HashSet hashSet3 = new HashSet();
                        hashSet3.add(RFC3280CertPathUtilities.ANY_POLICY);
                        PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), 0, hashSet3, (PolicyNode) null, new HashSet(), RFC3280CertPathUtilities.ANY_POLICY, false);
                        arrayListArr2[0].add(pKIXPolicyNode);
                        PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
                        HashSet hashSet4 = new HashSet();
                        int i6 = build.isExplicitPolicyRequired() ? 0 : i4;
                        int i7 = build.isAnyPolicyInhibited() ? 0 : i4;
                        if (build.isPolicyMappingInhibited()) {
                            i4 = 0;
                        }
                        X509Certificate trustedCert = findTrustAnchor.getTrustedCert();
                        if (trustedCert != null) {
                            try {
                                x500Name = PrincipalUtils.getSubjectPrincipal(trustedCert);
                                publicKey = trustedCert.getPublicKey();
                            } catch (RuntimeException e) {
                                throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", e, certPath2, -1);
                            }
                        } else {
                            x500Name = PrincipalUtils.getCA(findTrustAnchor);
                            publicKey = findTrustAnchor.getCAPublicKey();
                        }
                        try {
                            AlgorithmIdentifier algorithmIdentifier = CertPathValidatorUtilities.getAlgorithmIdentifier(publicKey);
                            algorithmIdentifier.getAlgorithm();
                            algorithmIdentifier.getParameters();
                            if (build.getTargetConstraints() == null || build.getTargetConstraints().match((Certificate) (X509Certificate) certificates.get(0))) {
                                List<PKIXCertPathChecker> certPathCheckers = build.getCertPathCheckers();
                                for (PKIXCertPathChecker init : certPathCheckers) {
                                    init.init(false);
                                }
                                ProvCrlRevocationChecker provCrlRevocationChecker = build.isRevocationEnabled() ? new ProvCrlRevocationChecker(this.helper) : null;
                                boolean z = true;
                                TrustAnchor trustAnchor = findTrustAnchor;
                                int i8 = size;
                                X509Certificate x509Certificate = null;
                                int i9 = i4;
                                int i10 = i7;
                                PKIXPolicyNode pKIXPolicyNode2 = pKIXPolicyNode;
                                int i11 = i6;
                                int size2 = certificates.size() - 1;
                                int i12 = i11;
                                while (size2 >= 0) {
                                    int i13 = size - size2;
                                    int i14 = size;
                                    X509Certificate x509Certificate2 = (X509Certificate) certificates.get(size2);
                                    boolean z2 = size2 == certificates.size() + -1 ? z : false;
                                    try {
                                        checkCertificate(x509Certificate2);
                                        List<? extends Certificate> list3 = certificates;
                                        int i15 = i12;
                                        int i16 = size2;
                                        Date date = validityDate;
                                        Date date2 = validityDate;
                                        int i17 = i9;
                                        ProvCrlRevocationChecker provCrlRevocationChecker2 = provCrlRevocationChecker;
                                        ProvCrlRevocationChecker provCrlRevocationChecker3 = provCrlRevocationChecker;
                                        PKIXNameConstraintValidator pKIXNameConstraintValidator2 = pKIXNameConstraintValidator;
                                        int i18 = i10;
                                        ArrayList[] arrayListArr3 = arrayListArr2;
                                        boolean z3 = z2;
                                        TrustAnchor trustAnchor2 = trustAnchor;
                                        PKIXExtendedParameters pKIXExtendedParameters2 = build;
                                        int i19 = i13;
                                        List list4 = certPathCheckers;
                                        boolean z4 = z;
                                        int i20 = i17;
                                        boolean z5 = z4;
                                        RFC3280CertPathUtilities.processCertA(certPath, build, date, provCrlRevocationChecker2, i16, publicKey, z3, x500Name, trustedCert);
                                        int i21 = i16;
                                        RFC3280CertPathUtilities.processCertBC(certPath2, i21, pKIXNameConstraintValidator2, this.isForCRLCheck);
                                        PKIXPolicyNode processCertE = RFC3280CertPathUtilities.processCertE(certPath2, i21, RFC3280CertPathUtilities.processCertD(certPath, i21, hashSet4, pKIXPolicyNode2, arrayListArr3, i18, this.isForCRLCheck));
                                        RFC3280CertPathUtilities.processCertF(certPath2, i21, processCertE, i15);
                                        int i22 = i14;
                                        if (i19 != i22) {
                                            if (x509Certificate2 == null || x509Certificate2.getVersion() != z5) {
                                                RFC3280CertPathUtilities.prepareNextCertA(certPath2, i21);
                                                int i23 = i20;
                                                arrayListArr = arrayListArr3;
                                                PKIXPolicyNode prepareCertB = RFC3280CertPathUtilities.prepareCertB(certPath2, i21, arrayListArr, processCertE, i23);
                                                RFC3280CertPathUtilities.prepareNextCertG(certPath2, i21, pKIXNameConstraintValidator2);
                                                int prepareNextCertH1 = RFC3280CertPathUtilities.prepareNextCertH1(certPath2, i21, i15);
                                                int prepareNextCertH2 = RFC3280CertPathUtilities.prepareNextCertH2(certPath2, i21, i23);
                                                int prepareNextCertH3 = RFC3280CertPathUtilities.prepareNextCertH3(certPath2, i21, i18);
                                                i2 = RFC3280CertPathUtilities.prepareNextCertI1(certPath2, i21, prepareNextCertH1);
                                                i3 = RFC3280CertPathUtilities.prepareNextCertI2(certPath2, i21, prepareNextCertH2);
                                                int prepareNextCertJ = RFC3280CertPathUtilities.prepareNextCertJ(certPath2, i21, prepareNextCertH3);
                                                RFC3280CertPathUtilities.prepareNextCertK(certPath2, i21);
                                                i8 = RFC3280CertPathUtilities.prepareNextCertM(certPath2, i21, RFC3280CertPathUtilities.prepareNextCertL(certPath2, i21, i8));
                                                RFC3280CertPathUtilities.prepareNextCertN(certPath2, i21);
                                                Set criticalExtensionOIDs = x509Certificate2.getCriticalExtensionOIDs();
                                                if (criticalExtensionOIDs != null) {
                                                    hashSet2.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                                    hashSet2.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                                    hashSet2.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                                    hashSet2.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                                    hashSet2.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                                    hashSet2.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                                    hashSet2.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                                    hashSet2.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                                    hashSet2.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                                    hashSet2.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                                } else {
                                                    hashSet2 = new HashSet();
                                                }
                                                list2 = list4;
                                                RFC3280CertPathUtilities.prepareNextCertO(certPath2, i21, hashSet2, list2);
                                                X500Name subjectPrincipal = PrincipalUtils.getSubjectPrincipal(x509Certificate2);
                                                try {
                                                    PublicKey nextWorkingKey = CertPathValidatorUtilities.getNextWorkingKey(certPath.getCertificates(), i21, this.helper);
                                                    AlgorithmIdentifier algorithmIdentifier2 = CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey);
                                                    algorithmIdentifier2.getAlgorithm();
                                                    algorithmIdentifier2.getParameters();
                                                    pKIXPolicyNode2 = prepareCertB;
                                                    i10 = prepareNextCertJ;
                                                    x500Name = subjectPrincipal;
                                                    publicKey = nextWorkingKey;
                                                    trustedCert = x509Certificate2;
                                                    int i24 = i21 - 1;
                                                    arrayListArr2 = arrayListArr;
                                                    certPathCheckers = list2;
                                                    x509Certificate = x509Certificate2;
                                                    z = z5;
                                                    certificates = list3;
                                                    validityDate = date2;
                                                    build = pKIXExtendedParameters2;
                                                    size = i22;
                                                    i12 = i2;
                                                    trustAnchor = trustAnchor2;
                                                    i9 = i3;
                                                    size2 = i24;
                                                    pKIXNameConstraintValidator = pKIXNameConstraintValidator2;
                                                    provCrlRevocationChecker = provCrlRevocationChecker3;
                                                } catch (CertPathValidatorException e2) {
                                                    throw new CertPathValidatorException("Next working key could not be retrieved.", e2, certPath2, i21);
                                                }
                                            } else if (i19 != z5 || !x509Certificate2.equals(trustAnchor2.getTrustedCert())) {
                                                throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", (Throwable) null, certPath2, i21);
                                            }
                                        }
                                        i3 = i20;
                                        arrayListArr = arrayListArr3;
                                        list2 = list4;
                                        pKIXPolicyNode2 = processCertE;
                                        i10 = i18;
                                        i8 = i8;
                                        i2 = i15;
                                        int i242 = i21 - 1;
                                        arrayListArr2 = arrayListArr;
                                        certPathCheckers = list2;
                                        x509Certificate = x509Certificate2;
                                        z = z5;
                                        certificates = list3;
                                        validityDate = date2;
                                        build = pKIXExtendedParameters2;
                                        size = i22;
                                        i12 = i2;
                                        trustAnchor = trustAnchor2;
                                        i9 = i3;
                                        size2 = i242;
                                        pKIXNameConstraintValidator = pKIXNameConstraintValidator2;
                                        provCrlRevocationChecker = provCrlRevocationChecker3;
                                    } catch (AnnotatedException e3) {
                                        AnnotatedException annotatedException = e3;
                                        throw new CertPathValidatorException(annotatedException.getMessage(), annotatedException.getUnderlyingException(), certPath2, size2);
                                    }
                                }
                                TrustAnchor trustAnchor3 = trustAnchor;
                                PKIXExtendedParameters pKIXExtendedParameters3 = build;
                                ArrayList[] arrayListArr4 = arrayListArr2;
                                List list5 = certPathCheckers;
                                int i25 = size2;
                                int i26 = i25 + 1;
                                int wrapupCertB = RFC3280CertPathUtilities.wrapupCertB(certPath2, i26, RFC3280CertPathUtilities.wrapupCertA(i12, x509Certificate));
                                Set criticalExtensionOIDs2 = x509Certificate.getCriticalExtensionOIDs();
                                if (criticalExtensionOIDs2 != null) {
                                    hashSet.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                    hashSet.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                    hashSet.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                    hashSet.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                    hashSet.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                    hashSet.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                    hashSet.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                    hashSet.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                    hashSet.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                    hashSet.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                    hashSet.remove(RFC3280CertPathUtilities.CRL_DISTRIBUTION_POINTS);
                                    hashSet.remove(Extension.extendedKeyUsage.getId());
                                } else {
                                    hashSet = new HashSet();
                                }
                                RFC3280CertPathUtilities.wrapupCertF(certPath2, i26, list5, hashSet);
                                PKIXPolicyNode wrapupCertG = RFC3280CertPathUtilities.wrapupCertG(certPath, pKIXExtendedParameters3, initialPolicies, i26, arrayListArr4, pKIXPolicyNode2, hashSet4);
                                if (wrapupCertB > 0 || wrapupCertG != null) {
                                    return new PKIXCertPathValidatorResult(trustAnchor3, wrapupCertG, x509Certificate.getPublicKey());
                                }
                                throw new CertPathValidatorException("Path processing failed on policy.", (Throwable) null, certPath2, i25);
                            }
                            throw new ExtCertPathValidatorException("Target certificate in certification path does not match targetConstraints.", (Throwable) null, certPath2, 0);
                        } catch (CertPathValidatorException e4) {
                            throw new ExtCertPathValidatorException("Algorithm identifier of public key of trust anchor could not be read.", e4, certPath2, -1);
                        }
                    } else {
                        i = 1;
                        list = certificates;
                        try {
                            throw new CertPathValidatorException("Trust anchor for certification path not found.", (Throwable) null, certPath2, -1);
                        } catch (AnnotatedException e5) {
                            e = e5;
                            throw new CertPathValidatorException(e.getMessage(), e.getUnderlyingException(), certPath2, list.size() - i);
                        }
                    }
                } catch (AnnotatedException e6) {
                    e = e6;
                    i = 1;
                    list = certificates;
                    throw new CertPathValidatorException(e.getMessage(), e.getUnderlyingException(), certPath2, list.size() - i);
                }
            } else {
                throw new CertPathValidatorException("Certification path is empty.", (Throwable) null, certPath2, -1);
            }
        } else {
            throw new InvalidAlgorithmParameterException("trustAnchors is null, this is not allowed for certification path validation.");
        }
    }
}
