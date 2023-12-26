package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonServiceException;

public class LimitExceededException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public LimitExceededException(String str) {
        super(str);
    }
}
