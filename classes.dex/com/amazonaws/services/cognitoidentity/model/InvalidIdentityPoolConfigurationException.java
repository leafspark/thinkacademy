package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonServiceException;

public class InvalidIdentityPoolConfigurationException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidIdentityPoolConfigurationException(String str) {
        super(str);
    }
}
