package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class KMSInternalException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public KMSInternalException(String str) {
        super(str);
    }
}
