package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class InvalidArnException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidArnException(String str) {
        super(str);
    }
}
