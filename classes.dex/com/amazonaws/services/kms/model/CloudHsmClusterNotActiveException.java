package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class CloudHsmClusterNotActiveException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public CloudHsmClusterNotActiveException(String str) {
        super(str);
    }
}
