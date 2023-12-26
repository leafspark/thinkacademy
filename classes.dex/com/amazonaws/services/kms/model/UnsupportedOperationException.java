package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class UnsupportedOperationException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public UnsupportedOperationException(String str) {
        super(str);
    }
}
