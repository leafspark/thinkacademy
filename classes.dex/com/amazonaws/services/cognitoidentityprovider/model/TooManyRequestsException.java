package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonServiceException;

public class TooManyRequestsException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public TooManyRequestsException(String str) {
        super(str);
    }
}
