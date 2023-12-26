package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class KeyUnavailableException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public KeyUnavailableException(String str) {
        super(str);
    }
}
