package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonServiceException;

public class InvalidPasswordException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidPasswordException(String str) {
        super(str);
    }
}
