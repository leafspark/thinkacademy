package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonServiceException;

public class InvalidOAuthFlowException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidOAuthFlowException(String str) {
        super(str);
    }
}
