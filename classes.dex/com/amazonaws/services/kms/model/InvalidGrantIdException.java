package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class InvalidGrantIdException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidGrantIdException(String str) {
        super(str);
    }
}
