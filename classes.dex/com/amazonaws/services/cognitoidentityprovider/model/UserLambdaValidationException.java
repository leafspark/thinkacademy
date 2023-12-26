package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonServiceException;

public class UserLambdaValidationException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public UserLambdaValidationException(String str) {
        super(str);
    }
}
