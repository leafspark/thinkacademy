package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class InvalidMarkerException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidMarkerException(String str) {
        super(str);
    }
}
