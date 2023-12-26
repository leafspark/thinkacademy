package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.CustomKeyStoreNameInUseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class CustomKeyStoreNameInUseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CustomKeyStoreNameInUseExceptionUnmarshaller() {
        super(CustomKeyStoreNameInUseException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("CustomKeyStoreNameInUseException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        CustomKeyStoreNameInUseException customKeyStoreNameInUseException = (CustomKeyStoreNameInUseException) CustomKeyStoreNameInUseExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        customKeyStoreNameInUseException.setErrorCode("CustomKeyStoreNameInUseException");
        return customKeyStoreNameInUseException;
    }
}
