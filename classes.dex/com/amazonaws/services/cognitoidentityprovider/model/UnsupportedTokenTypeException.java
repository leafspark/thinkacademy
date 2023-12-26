package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonServiceException;

public class UnsupportedTokenTypeException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public UnsupportedTokenTypeException(String str) {
        super(str);
    }
}
