package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.KMSInvalidSignatureException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class KMSInvalidSignatureExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public KMSInvalidSignatureExceptionUnmarshaller() {
        super(KMSInvalidSignatureException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("KMSInvalidSignatureException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        KMSInvalidSignatureException kMSInvalidSignatureException = (KMSInvalidSignatureException) KMSInvalidSignatureExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        kMSInvalidSignatureException.setErrorCode("KMSInvalidSignatureException");
        return kMSInvalidSignatureException;
    }
}
