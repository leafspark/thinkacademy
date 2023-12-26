package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.IncorrectKeyMaterialException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class IncorrectKeyMaterialExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public IncorrectKeyMaterialExceptionUnmarshaller() {
        super(IncorrectKeyMaterialException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("IncorrectKeyMaterialException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        IncorrectKeyMaterialException incorrectKeyMaterialException = (IncorrectKeyMaterialException) IncorrectKeyMaterialExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        incorrectKeyMaterialException.setErrorCode("IncorrectKeyMaterialException");
        return incorrectKeyMaterialException;
    }
}
