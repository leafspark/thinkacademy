package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class InvalidAliasNameException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidAliasNameException(String str) {
        super(str);
    }
}
