package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UsernameExistsException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class UsernameExistsExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UsernameExistsExceptionUnmarshaller() {
        super(UsernameExistsException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UsernameExistsException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UsernameExistsException usernameExistsException = (UsernameExistsException) UsernameExistsExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        usernameExistsException.setErrorCode("UsernameExistsException");
        return usernameExistsException;
    }
}
