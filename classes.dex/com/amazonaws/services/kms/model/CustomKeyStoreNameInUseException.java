package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class CustomKeyStoreNameInUseException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public CustomKeyStoreNameInUseException(String str) {
        super(str);
    }
}
