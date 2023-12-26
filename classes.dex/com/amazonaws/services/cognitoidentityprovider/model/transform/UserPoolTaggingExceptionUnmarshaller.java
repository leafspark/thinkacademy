package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UserPoolTaggingException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class UserPoolTaggingExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UserPoolTaggingExceptionUnmarshaller() {
        super(UserPoolTaggingException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UserPoolTaggingException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UserPoolTaggingException userPoolTaggingException = (UserPoolTaggingException) UserPoolTaggingExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        userPoolTaggingException.setErrorCode("UserPoolTaggingException");
        return userPoolTaggingException;
    }
}
