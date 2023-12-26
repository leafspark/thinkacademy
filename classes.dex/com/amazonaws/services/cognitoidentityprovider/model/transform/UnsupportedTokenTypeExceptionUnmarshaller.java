package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UnsupportedTokenTypeException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class UnsupportedTokenTypeExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UnsupportedTokenTypeExceptionUnmarshaller() {
        super(UnsupportedTokenTypeException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UnsupportedTokenTypeException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UnsupportedTokenTypeException unsupportedTokenTypeException = (UnsupportedTokenTypeException) UnsupportedTokenTypeExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        unsupportedTokenTypeException.setErrorCode("UnsupportedTokenTypeException");
        return unsupportedTokenTypeException;
    }
}
