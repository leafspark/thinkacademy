package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class InvalidKeyUsageException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidKeyUsageException(String str) {
        super(str);
    }
}
