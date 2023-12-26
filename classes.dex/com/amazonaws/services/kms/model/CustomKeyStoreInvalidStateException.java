package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class CustomKeyStoreInvalidStateException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public CustomKeyStoreInvalidStateException(String str) {
        super(str);
    }
}
