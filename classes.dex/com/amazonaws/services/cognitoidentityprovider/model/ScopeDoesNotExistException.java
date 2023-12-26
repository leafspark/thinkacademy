package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonServiceException;

public class ScopeDoesNotExistException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public ScopeDoesNotExistException(String str) {
        super(str);
    }
}
