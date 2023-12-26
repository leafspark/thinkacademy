package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class InvalidCiphertextException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidCiphertextException(String str) {
        super(str);
    }
}
