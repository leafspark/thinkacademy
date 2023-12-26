package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.ExpiredCodeException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class ExpiredCodeExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ExpiredCodeExceptionUnmarshaller() {
        super(ExpiredCodeException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ExpiredCodeException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ExpiredCodeException expiredCodeException = (ExpiredCodeException) ExpiredCodeExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        expiredCodeException.setErrorCode("ExpiredCodeException");
        return expiredCodeException;
    }
}
