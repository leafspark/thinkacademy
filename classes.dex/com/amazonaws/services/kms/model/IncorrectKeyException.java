package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class IncorrectKeyException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public IncorrectKeyException(String str) {
        super(str);
    }
}
