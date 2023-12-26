package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonServiceException;

public class InvalidUserPoolConfigurationException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidUserPoolConfigurationException(String str) {
        super(str);
    }
}
