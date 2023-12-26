package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonServiceException;

public class TooManyFailedAttemptsException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public TooManyFailedAttemptsException(String str) {
        super(str);
    }
}
