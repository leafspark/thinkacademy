package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.services.s3.model.AmazonS3Exception;

public class CompleteMultipartUploadRetryCondition implements RetryPolicy.RetryCondition {
    private static final String ERROR_CODE = "InternalError";
    private static final int MAX_RETRY_ATTEMPTS = 3;
    private static final String RETYABLE_ERROR_MESSAGE = "Please try again.";
    private final int maxCompleteMultipartUploadRetries;

    public CompleteMultipartUploadRetryCondition() {
        this(3);
    }

    CompleteMultipartUploadRetryCondition(int i) {
        this.maxCompleteMultipartUploadRetries = i;
    }

    public boolean shouldRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i) {
        if (!(amazonClientException instanceof AmazonS3Exception) || !test((AmazonS3Exception) amazonClientException) || i >= this.maxCompleteMultipartUploadRetries) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean test(AmazonS3Exception amazonS3Exception) {
        if (amazonS3Exception == null || amazonS3Exception.getErrorCode() == null || amazonS3Exception.getErrorMessage() == null || !amazonS3Exception.getErrorCode().contains(ERROR_CODE) || !amazonS3Exception.getErrorMessage().contains(RETYABLE_ERROR_MESSAGE)) {
            return false;
        }
        return true;
    }
}
