package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.KMSInvalidStateException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class KMSInvalidStateExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public KMSInvalidStateExceptionUnmarshaller() {
        super(KMSInvalidStateException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("KMSInvalidStateException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        KMSInvalidStateException kMSInvalidStateException = (KMSInvalidStateException) KMSInvalidStateExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        kMSInvalidStateException.setErrorCode("KMSInvalidStateException");
        return kMSInvalidStateException;
    }
}
