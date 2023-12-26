package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.CustomKeyStoreInvalidStateException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class CustomKeyStoreInvalidStateExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CustomKeyStoreInvalidStateExceptionUnmarshaller() {
        super(CustomKeyStoreInvalidStateException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("CustomKeyStoreInvalidStateException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        CustomKeyStoreInvalidStateException customKeyStoreInvalidStateException = (CustomKeyStoreInvalidStateException) CustomKeyStoreInvalidStateExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        customKeyStoreInvalidStateException.setErrorCode("CustomKeyStoreInvalidStateException");
        return customKeyStoreInvalidStateException;
    }
}
