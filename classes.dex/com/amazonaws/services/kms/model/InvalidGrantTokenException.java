package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class InvalidGrantTokenException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidGrantTokenException(String str) {
        super(str);
    }
}
