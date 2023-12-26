package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UnexpectedLambdaException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class UnexpectedLambdaExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UnexpectedLambdaExceptionUnmarshaller() {
        super(UnexpectedLambdaException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UnexpectedLambdaException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UnexpectedLambdaException unexpectedLambdaException = (UnexpectedLambdaException) UnexpectedLambdaExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        unexpectedLambdaException.setErrorCode("UnexpectedLambdaException");
        return unexpectedLambdaException;
    }
}
