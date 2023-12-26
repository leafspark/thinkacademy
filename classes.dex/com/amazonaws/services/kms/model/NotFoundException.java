package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class NotFoundException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public NotFoundException(String str) {
        super(str);
    }
}
