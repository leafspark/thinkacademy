package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class IncorrectTrustAnchorException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public IncorrectTrustAnchorException(String str) {
        super(str);
    }
}
