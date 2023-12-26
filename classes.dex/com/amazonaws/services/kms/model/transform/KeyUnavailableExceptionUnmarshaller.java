package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.KeyUnavailableException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class KeyUnavailableExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public KeyUnavailableExceptionUnmarshaller() {
        super(KeyUnavailableException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("KeyUnavailableException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        KeyUnavailableException keyUnavailableException = (KeyUnavailableException) KeyUnavailableExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        keyUnavailableException.setErrorCode("KeyUnavailableException");
        return keyUnavailableException;
    }
}
