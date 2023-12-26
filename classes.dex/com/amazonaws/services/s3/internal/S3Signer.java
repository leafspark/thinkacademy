package com.amazonaws.services.s3.internal;

import com.amazonaws.Request;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AbstractAWSSigner;
import com.amazonaws.auth.SigningAlgorithm;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.util.HttpUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class S3Signer extends AbstractAWSSigner {
    private static final Log log = LogFactory.getLog((Class<?>) S3Signer.class);
    private final Set<String> additionalQueryParamsToSign;
    private final String httpVerb;
    private final String resourcePath;

    public S3Signer() {
        this.httpVerb = null;
        this.resourcePath = null;
        this.additionalQueryParamsToSign = null;
    }

    public S3Signer(String str, String str2) {
        this(str, str2, (Collection<String>) null);
    }

    public S3Signer(String str, String str2, Collection<String> collection) {
        Set<String> set;
        if (str2 != null) {
            this.httpVerb = str;
            this.resourcePath = str2;
            if (collection == null) {
                set = null;
            } else {
                set = Collections.unmodifiableSet(new HashSet(collection));
            }
            this.additionalQueryParamsToSign = set;
            return;
        }
        throw new IllegalArgumentException("Parameter resourcePath is empty");
    }

    /* access modifiers changed from: package-private */
    public void sign(Request<?> request, AWSCredentials aWSCredentials, Date date) {
        if (this.resourcePath == null) {
            throw new UnsupportedOperationException("Cannot sign a request using a dummy S3Signer instance with no resource path");
        } else if (aWSCredentials == null || aWSCredentials.getAWSSecretKey() == null) {
            log.debug("Canonical string will not be signed, as no AWS Secret Key was provided");
        } else {
            AWSCredentials sanitizeCredentials = sanitizeCredentials(aWSCredentials);
            if (sanitizeCredentials instanceof AWSSessionCredentials) {
                addSessionCredentials(request, (AWSSessionCredentials) sanitizeCredentials);
            }
            String appendUri = HttpUtils.appendUri(request.getEndpoint().getPath(), this.resourcePath, true);
            Date signatureDate = getSignatureDate(getTimeOffset(request));
            if (date == null) {
                date = signatureDate;
            }
            request.addHeader("Date", ServiceUtils.formatRfc822Date(date));
            String makeS3CanonicalString = RestUtils.makeS3CanonicalString(this.httpVerb, appendUri, request, (String) null, this.additionalQueryParamsToSign);
            Log log2 = log;
            log2.debug("Calculated string to sign:\n\"" + makeS3CanonicalString + "\"");
            String signAndBase64Encode = super.signAndBase64Encode(makeS3CanonicalString, sanitizeCredentials.getAWSSecretKey(), SigningAlgorithm.HmacSHA1);
            request.addHeader("Authorization", "AWS " + sanitizeCredentials.getAWSAccessKeyId() + ":" + signAndBase64Encode);
        }
    }

    public void sign(Request<?> request, AWSCredentials aWSCredentials) {
        sign(request, aWSCredentials, (Date) null);
    }

    /* access modifiers changed from: protected */
    public void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.addHeader(Headers.SECURITY_TOKEN, aWSSessionCredentials.getSessionToken());
    }
}
