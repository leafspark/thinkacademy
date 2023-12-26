package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.CustomKeyStoreNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class CustomKeyStoreNotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CustomKeyStoreNotFoundExceptionUnmarshaller() {
        super(CustomKeyStoreNotFoundException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("CustomKeyStoreNotFoundException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        CustomKeyStoreNotFoundException customKeyStoreNotFoundException = (CustomKeyStoreNotFoundException) CustomKeyStoreNotFoundExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        customKeyStoreNotFoundException.setErrorCode("CustomKeyStoreNotFoundException");
        return customKeyStoreNotFoundException;
    }
}
