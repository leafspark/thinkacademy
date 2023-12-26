package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.IncorrectKeyException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class IncorrectKeyExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public IncorrectKeyExceptionUnmarshaller() {
        super(IncorrectKeyException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("IncorrectKeyException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        IncorrectKeyException incorrectKeyException = (IncorrectKeyException) IncorrectKeyExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        incorrectKeyException.setErrorCode("IncorrectKeyException");
        return incorrectKeyException;
    }
}
