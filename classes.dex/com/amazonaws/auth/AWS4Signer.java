package com.amazonaws.auth;

import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class AWS4Signer extends AbstractAWSSigner implements ServiceAwareSigner, RegionAwareSigner, Presigner {
    protected static final String ALGORITHM = "AWS4-HMAC-SHA256";
    private static final String DATE_PATTERN = "yyyyMMdd";
    private static final long MAX_EXPIRATION_TIME_IN_SECONDS = 604800;
    private static final long MILLISEC = 1000;
    protected static final String TERMINATOR = "aws4_request";
    private static final String TIME_PATTERN = "yyyyMMdd'T'HHmmss'Z'";
    protected static final Log log = LogFactory.getLog((Class<?>) AWS4Signer.class);
    protected boolean doubleUrlEncode;
    protected Date overriddenDate;
    protected String regionName;
    protected String serviceName;

    /* access modifiers changed from: protected */
    public void processRequestPayload(Request<?> request, HeaderSigningResult headerSigningResult) {
    }

    public AWS4Signer() {
        this(true);
    }

    public AWS4Signer(boolean z) {
        this.doubleUrlEncode = z;
    }

    public void sign(Request<?> request, AWSCredentials aWSCredentials) {
        if (!(aWSCredentials instanceof AnonymousAWSCredentials)) {
            AWSCredentials sanitizeCredentials = sanitizeCredentials(aWSCredentials);
            if (sanitizeCredentials instanceof AWSSessionCredentials) {
                addSessionCredentials(request, (AWSSessionCredentials) sanitizeCredentials);
            }
            addHostHeader(request);
            long dateFromRequest = getDateFromRequest(request);
            String dateStamp = getDateStamp(dateFromRequest);
            String scope = getScope(request, dateStamp);
            String calculateContentHash = calculateContentHash(request);
            String timeStamp = getTimeStamp(dateFromRequest);
            request.addHeader("X-Amz-Date", timeStamp);
            if (request.getHeaders().get("x-amz-content-sha256") != null && "required".equals(request.getHeaders().get("x-amz-content-sha256"))) {
                request.addHeader("x-amz-content-sha256", calculateContentHash);
            }
            HeaderSigningResult computeSignature = computeSignature(request, dateStamp, timeStamp, ALGORITHM, calculateContentHash, sanitizeCredentials);
            request.addHeader("Authorization", "AWS4-HMAC-SHA256 " + ("Credential=" + (sanitizeCredentials.getAWSAccessKeyId() + ExpiryDateInput.SEPARATOR + scope)) + ", " + ("SignedHeaders=" + getSignedHeadersString(request)) + ", " + ("Signature=" + BinaryUtils.toHex(computeSignature.getSignature())));
            processRequestPayload(request, computeSignature);
        }
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    /* access modifiers changed from: protected */
    public void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.addHeader(Headers.SECURITY_TOKEN, aWSSessionCredentials.getSessionToken());
    }

    /* access modifiers changed from: protected */
    public String extractRegionName(URI uri) {
        String str = this.regionName;
        if (str != null) {
            return str;
        }
        return AwsHostNameUtils.parseRegionName(uri.getHost(), this.serviceName);
    }

    /* access modifiers changed from: protected */
    public String extractServiceName(URI uri) {
        String str = this.serviceName;
        if (str != null) {
            return str;
        }
        return AwsHostNameUtils.parseServiceName(uri);
    }

    /* access modifiers changed from: package-private */
    public void overrideDate(Date date) {
        this.overriddenDate = date;
    }

    /* access modifiers changed from: protected */
    public String getCanonicalizedHeaderString(Request<?> request) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(request.getHeaders().keySet());
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            if (needsSign(str)) {
                String replaceAll = StringUtils.lowerCase(str).replaceAll("\\s+", " ");
                String str2 = request.getHeaders().get(str);
                sb.append(replaceAll);
                sb.append(":");
                if (str2 != null) {
                    sb.append(str2.replaceAll("\\s+", " "));
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String getSignedHeadersString(Request<?> request) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(request.getHeaders().keySet());
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            if (needsSign(str)) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(StringUtils.lowerCase(str));
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String getCanonicalRequest(Request<?> request, String str) {
        String str2;
        if (request.getEncodedUriResourcePath() != null) {
            str2 = HttpUtils.appendUriEncoded(request.getEndpoint().getPath(), request.getEncodedUriResourcePath());
        } else {
            str2 = HttpUtils.appendUri(request.getEndpoint().getPath(), request.getResourcePath());
        }
        String str3 = request.getHttpMethod().toString() + "\n" + getCanonicalizedResourcePath(str2, this.doubleUrlEncode) + "\n" + getCanonicalizedQueryString(request) + "\n" + getCanonicalizedHeaderString(request) + "\n" + getSignedHeadersString(request) + "\n" + str;
        log.debug("AWS4 Canonical Request: '\"" + str3 + "\"");
        return str3;
    }

    /* access modifiers changed from: protected */
    public String getStringToSign(String str, String str2, String str3, String str4) {
        String str5 = str + "\n" + str2 + "\n" + str3 + "\n" + BinaryUtils.toHex(hash(str4));
        log.debug("AWS4 String to Sign: '\"" + str5 + "\"");
        return str5;
    }

    /* access modifiers changed from: protected */
    public final HeaderSigningResult computeSignature(Request<?> request, String str, String str2, String str3, String str4, AWSCredentials aWSCredentials) {
        String extractRegionName = extractRegionName(request.getEndpoint());
        String extractServiceName = extractServiceName(request.getEndpoint());
        String str5 = str + ExpiryDateInput.SEPARATOR + extractRegionName + ExpiryDateInput.SEPARATOR + extractServiceName + ExpiryDateInput.SEPARATOR + TERMINATOR;
        String stringToSign = getStringToSign(str3, str2, str5, getCanonicalRequest(request, str4));
        byte[] sign = sign(TERMINATOR, sign(extractServiceName, sign(extractRegionName, sign(str, ("AWS4" + aWSCredentials.getAWSSecretKey()).getBytes(StringUtils.UTF8), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256);
        return new HeaderSigningResult(str2, str5, sign, sign(stringToSign.getBytes(StringUtils.UTF8), sign, SigningAlgorithm.HmacSHA256));
    }

    /* access modifiers changed from: protected */
    public final String getTimeStamp(long j) {
        return DateUtils.format(TIME_PATTERN, new Date(j));
    }

    /* access modifiers changed from: protected */
    public final String getDateStamp(long j) {
        return DateUtils.format(DATE_PATTERN, new Date(j));
    }

    /* access modifiers changed from: protected */
    public final long getDateFromRequest(Request<?> request) {
        Date signatureDate = getSignatureDate(getTimeOffset(request));
        Date date = this.overriddenDate;
        if (date != null) {
            signatureDate = date;
        }
        return signatureDate.getTime();
    }

    /* access modifiers changed from: protected */
    public void addHostHeader(Request<?> request) {
        String host = request.getEndpoint().getHost();
        if (HttpUtils.isUsingNonDefaultPort(request.getEndpoint())) {
            host = host + ":" + request.getEndpoint().getPort();
        }
        request.addHeader("Host", host);
    }

    /* access modifiers changed from: protected */
    public String getScope(Request<?> request, String str) {
        String extractRegionName = extractRegionName(request.getEndpoint());
        String extractServiceName = extractServiceName(request.getEndpoint());
        return str + ExpiryDateInput.SEPARATOR + extractRegionName + ExpiryDateInput.SEPARATOR + extractServiceName + ExpiryDateInput.SEPARATOR + TERMINATOR;
    }

    /* access modifiers changed from: protected */
    public String calculateContentHash(Request<?> request) {
        InputStream binaryRequestPayloadStream = getBinaryRequestPayloadStream(request);
        binaryRequestPayloadStream.mark(-1);
        String hex = BinaryUtils.toHex(hash(binaryRequestPayloadStream));
        try {
            binaryRequestPayloadStream.reset();
            return hex;
        } catch (IOException e) {
            throw new AmazonClientException("Unable to reset stream after calculating AWS4 signature", e);
        }
    }

    protected static class HeaderSigningResult {
        private final String dateTime;
        private final byte[] kSigning;
        private final String scope;
        private final byte[] signature;

        public HeaderSigningResult(String str, String str2, byte[] bArr, byte[] bArr2) {
            this.dateTime = str;
            this.scope = str2;
            this.kSigning = bArr;
            this.signature = bArr2;
        }

        public String getDateTime() {
            return this.dateTime;
        }

        public String getScope() {
            return this.scope;
        }

        public byte[] getKSigning() {
            byte[] bArr = this.kSigning;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }

        public byte[] getSignature() {
            byte[] bArr = this.signature;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
    }

    public void presignRequest(Request<?> request, AWSCredentials aWSCredentials, Date date) {
        if (!(aWSCredentials instanceof AnonymousAWSCredentials)) {
            long time = date != null ? (date.getTime() - System.currentTimeMillis()) / MILLISEC : 604800;
            if (time <= MAX_EXPIRATION_TIME_IN_SECONDS) {
                addHostHeader(request);
                AWSCredentials sanitizeCredentials = sanitizeCredentials(aWSCredentials);
                if (sanitizeCredentials instanceof AWSSessionCredentials) {
                    request.addParameter("X-Amz-Security-Token", ((AWSSessionCredentials) sanitizeCredentials).getSessionToken());
                }
                long dateFromRequest = getDateFromRequest(request);
                String dateStamp = getDateStamp(dateFromRequest);
                String timeStamp = getTimeStamp(dateFromRequest);
                request.addParameter("X-Amz-Algorithm", ALGORITHM);
                request.addParameter("X-Amz-Date", timeStamp);
                request.addParameter("X-Amz-SignedHeaders", getSignedHeadersString(request));
                request.addParameter("X-Amz-Expires", Long.toString(time));
                request.addParameter("X-Amz-Credential", sanitizeCredentials.getAWSAccessKeyId() + ExpiryDateInput.SEPARATOR + getScope(request, dateStamp));
                request.addParameter("X-Amz-Signature", BinaryUtils.toHex(computeSignature(request, dateStamp, timeStamp, ALGORITHM, calculateContentHashPresign(request), sanitizeCredentials).getSignature()));
                return;
            }
            throw new AmazonClientException("Requests that are pre-signed by SigV4 algorithm are valid for at most 7 days. The expiration date set on the current request [" + getTimeStamp(date.getTime()) + "] has exceeded this limit.");
        }
    }

    /* access modifiers changed from: protected */
    public String calculateContentHashPresign(Request<?> request) {
        return calculateContentHash(request);
    }

    /* access modifiers changed from: package-private */
    public boolean needsSign(String str) {
        return "date".equalsIgnoreCase(str) || "Content-MD5".equalsIgnoreCase(str) || "host".equalsIgnoreCase(str) || str.startsWith("x-amz") || str.startsWith("X-Amz");
    }
}
