package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class ExpiredImportTokenException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public ExpiredImportTokenException(String str) {
        super(str);
    }
}
