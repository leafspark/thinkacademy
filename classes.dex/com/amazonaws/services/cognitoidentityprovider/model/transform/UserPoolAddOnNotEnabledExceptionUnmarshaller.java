package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UserPoolAddOnNotEnabledException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class UserPoolAddOnNotEnabledExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UserPoolAddOnNotEnabledExceptionUnmarshaller() {
        super(UserPoolAddOnNotEnabledException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UserPoolAddOnNotEnabledException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UserPoolAddOnNotEnabledException userPoolAddOnNotEnabledException = (UserPoolAddOnNotEnabledException) UserPoolAddOnNotEnabledExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        userPoolAddOnNotEnabledException.setErrorCode("UserPoolAddOnNotEnabledException");
        return userPoolAddOnNotEnabledException;
    }
}
