package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class DisabledException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public DisabledException(String str) {
        super(str);
    }
}
