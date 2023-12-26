package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class DependencyTimeoutException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public DependencyTimeoutException(String str) {
        super(str);
    }
}
