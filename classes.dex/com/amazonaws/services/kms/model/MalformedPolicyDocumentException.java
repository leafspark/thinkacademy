package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class MalformedPolicyDocumentException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public MalformedPolicyDocumentException(String str) {
        super(str);
    }
}
