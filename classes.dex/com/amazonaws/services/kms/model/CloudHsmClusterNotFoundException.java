package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class CloudHsmClusterNotFoundException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public CloudHsmClusterNotFoundException(String str) {
        super(str);
    }
}
