package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonServiceException;

public class UserNotConfirmedException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public UserNotConfirmedException(String str) {
        super(str);
    }
}
