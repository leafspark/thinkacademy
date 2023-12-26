package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonServiceException;

public class UnsupportedIdentityProviderException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public UnsupportedIdentityProviderException(String str) {
        super(str);
    }
}
