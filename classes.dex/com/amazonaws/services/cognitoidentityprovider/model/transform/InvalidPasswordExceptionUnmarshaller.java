package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidPasswordException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidPasswordExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidPasswordExceptionUnmarshaller() {
        super(InvalidPasswordException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidPasswordException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidPasswordException invalidPasswordException = (InvalidPasswordException) InvalidPasswordExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        invalidPasswordException.setErrorCode("InvalidPasswordException");
        return invalidPasswordException;
    }
}
