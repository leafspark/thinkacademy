package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class CloudHsmClusterInUseException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public CloudHsmClusterInUseException(String str) {
        super(str);
    }
}
