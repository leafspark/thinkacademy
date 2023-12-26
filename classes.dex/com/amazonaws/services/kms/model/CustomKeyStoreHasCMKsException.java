package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class CustomKeyStoreHasCMKsException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public CustomKeyStoreHasCMKsException(String str) {
        super(str);
    }
}
