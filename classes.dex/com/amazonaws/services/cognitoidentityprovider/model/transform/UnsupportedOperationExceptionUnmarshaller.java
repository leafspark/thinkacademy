package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UnsupportedOperationException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class UnsupportedOperationExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UnsupportedOperationExceptionUnmarshaller() {
        super(UnsupportedOperationException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UnsupportedOperationException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UnsupportedOperationException unsupportedOperationException = (UnsupportedOperationException) UnsupportedOperationExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        unsupportedOperationException.setErrorCode("UnsupportedOperationException");
        return unsupportedOperationException;
    }
}
