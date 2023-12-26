package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.DuplicateProviderException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class DuplicateProviderExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public DuplicateProviderExceptionUnmarshaller() {
        super(DuplicateProviderException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("DuplicateProviderException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        DuplicateProviderException duplicateProviderException = (DuplicateProviderException) DuplicateProviderExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        duplicateProviderException.setErrorCode("DuplicateProviderException");
        return duplicateProviderException;
    }
}
