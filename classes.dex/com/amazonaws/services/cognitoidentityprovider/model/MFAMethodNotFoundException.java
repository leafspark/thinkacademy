package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonServiceException;

public class MFAMethodNotFoundException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public MFAMethodNotFoundException(String str) {
        super(str);
    }
}
