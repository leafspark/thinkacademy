package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Extension;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.fileupload.FileUploadBase;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.ocsp.BasicOCSPResponse;
import org.bouncycastle.asn1.ocsp.CertID;
import org.bouncycastle.asn1.ocsp.OCSPObjectIdentifiers;
import org.bouncycastle.asn1.ocsp.OCSPRequest;
import org.bouncycastle.asn1.ocsp.OCSPResponse;
import org.bouncycastle.asn1.ocsp.Request;
import org.bouncycastle.asn1.ocsp.ResponseBytes;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.bouncycastle.asn1.ocsp.Signature;
import org.bouncycastle.asn1.ocsp.SingleResponse;
import org.bouncycastle.asn1.ocsp.TBSRequest;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.jcajce.PKIXCertRevocationCheckerParameters;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.util.io.Streams;

class OcspCache {
    private static final int DEFAULT_MAX_RESPONSE_SIZE = 32768;
    private static final int DEFAULT_TIMEOUT = 15000;
    private static Map<URI, WeakReference<Map<CertID, OCSPResponse>>> cache = Collections.synchronizedMap(new WeakHashMap());

    OcspCache() {
    }

    static OCSPResponse getOcspResponse(CertID certID, PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters, URI uri, X509Certificate x509Certificate, List<Extension> list, JcaJceHelper jcaJceHelper) throws CertPathValidatorException {
        OCSPResponse oCSPResponse;
        ASN1GeneralizedTime nextUpdate;
        CertID certID2 = certID;
        URI uri2 = uri;
        WeakReference weakReference = cache.get(uri2);
        Map map = weakReference != null ? (Map) weakReference.get() : null;
        boolean z = false;
        if (!(map == null || (oCSPResponse = (OCSPResponse) map.get(certID2)) == null)) {
            ASN1Sequence responses = ResponseData.getInstance(BasicOCSPResponse.getInstance(ASN1OctetString.getInstance(oCSPResponse.getResponseBytes().getResponse()).getOctets()).getTbsResponseData()).getResponses();
            for (int i = 0; i != responses.size(); i++) {
                SingleResponse instance = SingleResponse.getInstance(responses.getObjectAt(i));
                if (certID2.equals(instance.getCertID()) && (nextUpdate = instance.getNextUpdate()) != null) {
                    try {
                        if (pKIXCertRevocationCheckerParameters.getValidDate().after(nextUpdate.getDate())) {
                            map.remove(certID2);
                            oCSPResponse = null;
                        }
                    } catch (ParseException unused) {
                        map.remove(certID2);
                    }
                }
            }
            if (oCSPResponse != null) {
                return oCSPResponse;
            }
        }
        try {
            URL url = uri.toURL();
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.add(new Request(certID2, (Extensions) null));
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            byte[] bArr = null;
            for (int i2 = 0; i2 != list.size(); i2++) {
                Extension extension = list.get(i2);
                byte[] value = extension.getValue();
                if (OCSPObjectIdentifiers.id_pkix_ocsp_nonce.getId().equals(extension.getId())) {
                    bArr = value;
                }
                aSN1EncodableVector2.add(new org.bouncycastle.asn1.x509.Extension(new ASN1ObjectIdentifier(extension.getId()), extension.isCritical(), value));
            }
            try {
                byte[] encoded = new OCSPRequest(new TBSRequest((GeneralName) null, (ASN1Sequence) new DERSequence(aSN1EncodableVector), Extensions.getInstance(new DERSequence(aSN1EncodableVector2))), (Signature) null).getEncoded();
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(DEFAULT_TIMEOUT);
                httpURLConnection.setReadTimeout(DEFAULT_TIMEOUT);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(FileUploadBase.CONTENT_TYPE, "application/ocsp-request");
                httpURLConnection.setRequestProperty(FileUploadBase.CONTENT_LENGTH, String.valueOf(encoded.length));
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(encoded);
                outputStream.flush();
                InputStream inputStream = httpURLConnection.getInputStream();
                int contentLength = httpURLConnection.getContentLength();
                if (contentLength < 0) {
                    contentLength = 32768;
                }
                OCSPResponse instance2 = OCSPResponse.getInstance(Streams.readAllLimited(inputStream, contentLength));
                if (instance2.getResponseStatus().getIntValue() == 0) {
                    ResponseBytes instance3 = ResponseBytes.getInstance(instance2.getResponseBytes());
                    if (instance3.getResponseType().equals((ASN1Primitive) OCSPObjectIdentifiers.id_pkix_ocsp_basic)) {
                        try {
                            z = ProvOcspRevocationChecker.validatedOcspResponse(BasicOCSPResponse.getInstance(instance3.getResponse().getOctets()), pKIXCertRevocationCheckerParameters, bArr, x509Certificate, jcaJceHelper);
                        } catch (IOException e) {
                            e = e;
                            throw new CertPathValidatorException("configuration error: " + e.getMessage(), e, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
                        }
                    } else {
                        PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters2 = pKIXCertRevocationCheckerParameters;
                    }
                    if (z) {
                        WeakReference weakReference2 = cache.get(uri2);
                        if (weakReference2 != null) {
                            ((Map) weakReference2.get()).put(certID2, instance2);
                        } else {
                            HashMap hashMap = new HashMap();
                            hashMap.put(certID2, instance2);
                            cache.put(uri2, new WeakReference(hashMap));
                        }
                        return instance2;
                    }
                    throw new CertPathValidatorException("OCSP response failed to validate", (Throwable) null, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
                }
                PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters3 = pKIXCertRevocationCheckerParameters;
                throw new CertPathValidatorException("OCSP responder failed: " + instance2.getResponseStatus().getValue(), (Throwable) null, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
            } catch (IOException e2) {
                e = e2;
                PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters4 = pKIXCertRevocationCheckerParameters;
                throw new CertPathValidatorException("configuration error: " + e.getMessage(), e, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
            }
        } catch (MalformedURLException e3) {
            PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters5 = pKIXCertRevocationCheckerParameters;
            MalformedURLException malformedURLException = e3;
            throw new CertPathValidatorException("configuration error: " + malformedURLException.getMessage(), malformedURLException, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
        }
    }
}
