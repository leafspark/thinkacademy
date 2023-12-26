package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.ScopeDoesNotExistException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class ScopeDoesNotExistExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ScopeDoesNotExistExceptionUnmarshaller() {
        super(ScopeDoesNotExistException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ScopeDoesNotExistException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ScopeDoesNotExistException scopeDoesNotExistException = (ScopeDoesNotExistException) ScopeDoesNotExistExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        scopeDoesNotExistException.setErrorCode("ScopeDoesNotExistException");
        return scopeDoesNotExistException;
    }
}
