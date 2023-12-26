package com.amazonaws.auth;

import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.internal.SdkDigestInputStream;
import com.amazonaws.util.Base64;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public abstract class AbstractAWSSigner implements Signer {
    private static final int BUFFER_SIZE_MULTIPLIER = 5;
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    public static final String EMPTY_STRING_SHA256_HEX = BinaryUtils.toHex(doHash(""));
    private static final ThreadLocal<MessageDigest> SHA256_MESSAGE_DIGEST = new ThreadLocal<MessageDigest>() {
        /* access modifiers changed from: protected */
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                throw new AmazonClientException("Unable to get SHA256 Function" + e.getMessage(), e);
            }
        }
    };
    private static final int TIME_MILLISEC = 1000;

    /* access modifiers changed from: protected */
    public abstract void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials);

    /* access modifiers changed from: protected */
    public String signAndBase64Encode(String str, String str2, SigningAlgorithm signingAlgorithm) {
        return signAndBase64Encode(str.getBytes(StringUtils.UTF8), str2, signingAlgorithm);
    }

    /* access modifiers changed from: protected */
    public String signAndBase64Encode(byte[] bArr, String str, SigningAlgorithm signingAlgorithm) {
        try {
            return Base64.encodeAsString(sign(bArr, str.getBytes(StringUtils.UTF8), signingAlgorithm));
        } catch (Exception e) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e.getMessage(), e);
        }
    }

    public byte[] sign(String str, byte[] bArr, SigningAlgorithm signingAlgorithm) {
        try {
            return sign(str.getBytes(StringUtils.UTF8), bArr, signingAlgorithm);
        } catch (Exception e) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: protected */
    public byte[] sign(byte[] bArr, byte[] bArr2, SigningAlgorithm signingAlgorithm) {
        try {
            Mac instance = Mac.getInstance(signingAlgorithm.toString());
            instance.init(new SecretKeySpec(bArr2, signingAlgorithm.toString()));
            return instance.doFinal(bArr);
        } catch (Exception e) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e.getMessage(), e);
        }
    }

    public byte[] hash(String str) {
        return doHash(str);
    }

    private static byte[] doHash(String str) {
        try {
            MessageDigest messageDigestInstance = getMessageDigestInstance();
            messageDigestInstance.update(str.getBytes(StringUtils.UTF8));
            return messageDigestInstance.digest();
        } catch (Exception e) {
            throw new AmazonClientException("Unable to compute hash while signing request: " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: protected */
    public byte[] hash(InputStream inputStream) {
        try {
            SdkDigestInputStream sdkDigestInputStream = new SdkDigestInputStream(inputStream, getMessageDigestInstance());
            while (sdkDigestInputStream.read(new byte[1024]) > -1) {
            }
            return sdkDigestInputStream.getMessageDigest().digest();
        } catch (Exception e) {
            throw new AmazonClientException("Unable to compute hash while signing request: " + e.getMessage(), e);
        }
    }

    public byte[] hash(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e) {
            throw new AmazonClientException("Unable to compute hash while signing request: " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: protected */
    public String getCanonicalizedQueryString(Map<String, String> map) {
        TreeMap treeMap = new TreeMap();
        for (Map.Entry next : map.entrySet()) {
            treeMap.put(HttpUtils.urlEncode((String) next.getKey(), false), HttpUtils.urlEncode((String) next.getValue(), false));
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = treeMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            sb.append((String) entry.getKey());
            sb.append("=");
            sb.append((String) entry.getValue());
            if (it.hasNext()) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String getCanonicalizedQueryString(Request<?> request) {
        if (HttpUtils.usePayloadForQueryParameters(request)) {
            return "";
        }
        return getCanonicalizedQueryString(request.getParameters());
    }

    /* access modifiers changed from: protected */
    public byte[] getBinaryRequestPayload(Request<?> request) {
        if (!HttpUtils.usePayloadForQueryParameters(request)) {
            return getBinaryRequestPayloadWithoutQueryParams(request);
        }
        String encodeParameters = HttpUtils.encodeParameters(request);
        if (encodeParameters == null) {
            return new byte[0];
        }
        return encodeParameters.getBytes(StringUtils.UTF8);
    }

    /* access modifiers changed from: protected */
    public String getRequestPayload(Request<?> request) {
        return newString(getBinaryRequestPayload(request));
    }

    /* access modifiers changed from: protected */
    public String getRequestPayloadWithoutQueryParams(Request<?> request) {
        return newString(getBinaryRequestPayloadWithoutQueryParams(request));
    }

    /* access modifiers changed from: protected */
    public byte[] getBinaryRequestPayloadWithoutQueryParams(Request<?> request) {
        InputStream binaryRequestPayloadStreamWithoutQueryParams = getBinaryRequestPayloadStreamWithoutQueryParams(request);
        try {
            binaryRequestPayloadStreamWithoutQueryParams.mark(-1);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[5120];
            while (true) {
                int read = binaryRequestPayloadStreamWithoutQueryParams.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.close();
                    binaryRequestPayloadStreamWithoutQueryParams.reset();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            throw new AmazonClientException("Unable to read request payload to sign request: " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: protected */
    public InputStream getBinaryRequestPayloadStream(Request<?> request) {
        if (!HttpUtils.usePayloadForQueryParameters(request)) {
            return getBinaryRequestPayloadStreamWithoutQueryParams(request);
        }
        String encodeParameters = HttpUtils.encodeParameters(request);
        if (encodeParameters == null) {
            return new ByteArrayInputStream(new byte[0]);
        }
        return new ByteArrayInputStream(encodeParameters.getBytes(StringUtils.UTF8));
    }

    /* access modifiers changed from: protected */
    public InputStream getBinaryRequestPayloadStreamWithoutQueryParams(Request<?> request) {
        try {
            InputStream content = request.getContent();
            if (content == null) {
                return new ByteArrayInputStream(new byte[0]);
            }
            if (content instanceof StringInputStream) {
                return content;
            }
            if (content.markSupported()) {
                return request.getContent();
            }
            throw new AmazonClientException("Unable to read request payload to sign request.");
        } catch (Exception e) {
            throw new AmazonClientException("Unable to read request payload to sign request: " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: protected */
    public String getCanonicalizedResourcePath(String str) {
        return getCanonicalizedResourcePath(str, true);
    }

    /* access modifiers changed from: protected */
    public String getCanonicalizedResourcePath(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return ExpiryDateInput.SEPARATOR;
        }
        if (z) {
            str = HttpUtils.urlEncode(str, true);
        }
        if (str.startsWith(ExpiryDateInput.SEPARATOR)) {
            return str;
        }
        return ExpiryDateInput.SEPARATOR.concat(str);
    }

    /* access modifiers changed from: protected */
    public String getCanonicalizedEndpoint(URI uri) {
        String lowerCase = StringUtils.lowerCase(uri.getHost());
        if (!HttpUtils.isUsingNonDefaultPort(uri)) {
            return lowerCase;
        }
        return lowerCase + ":" + uri.getPort();
    }

    /* access modifiers changed from: protected */
    public AWSCredentials sanitizeCredentials(AWSCredentials aWSCredentials) {
        String aWSAccessKeyId;
        String aWSSecretKey;
        String sessionToken;
        synchronized (aWSCredentials) {
            aWSAccessKeyId = aWSCredentials.getAWSAccessKeyId();
            aWSSecretKey = aWSCredentials.getAWSSecretKey();
            sessionToken = aWSCredentials instanceof AWSSessionCredentials ? ((AWSSessionCredentials) aWSCredentials).getSessionToken() : null;
        }
        if (aWSSecretKey != null) {
            aWSSecretKey = aWSSecretKey.trim();
        }
        if (aWSAccessKeyId != null) {
            aWSAccessKeyId = aWSAccessKeyId.trim();
        }
        if (sessionToken != null) {
            sessionToken = sessionToken.trim();
        }
        if (aWSCredentials instanceof AWSSessionCredentials) {
            return new BasicSessionCredentials(aWSAccessKeyId, aWSSecretKey, sessionToken);
        }
        return new BasicAWSCredentials(aWSAccessKeyId, aWSSecretKey);
    }

    /* access modifiers changed from: protected */
    public String newString(byte[] bArr) {
        return new String(bArr, StringUtils.UTF8);
    }

    /* access modifiers changed from: protected */
    public Date getSignatureDate(long j) {
        Date date = new Date();
        return j != 0 ? new Date(date.getTime() - (j * 1000)) : date;
    }

    /* access modifiers changed from: protected */
    public long getTimeOffset(Request<?> request) {
        return SDKGlobalConfiguration.getGlobalTimeOffset() != 0 ? SDKGlobalConfiguration.getGlobalTimeOffset() : request.getTimeOffset();
    }

    private static MessageDigest getMessageDigestInstance() {
        MessageDigest messageDigest = SHA256_MESSAGE_DIGEST.get();
        messageDigest.reset();
        return messageDigest;
    }
}
