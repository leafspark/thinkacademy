package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.PasswordResetRequiredException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class PasswordResetRequiredExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public PasswordResetRequiredExceptionUnmarshaller() {
        super(PasswordResetRequiredException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("PasswordResetRequiredException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        PasswordResetRequiredException passwordResetRequiredException = (PasswordResetRequiredException) PasswordResetRequiredExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        passwordResetRequiredException.setErrorCode("PasswordResetRequiredException");
        return passwordResetRequiredException;
    }
}
