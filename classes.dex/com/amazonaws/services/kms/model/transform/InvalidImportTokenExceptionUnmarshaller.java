package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.InvalidImportTokenException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidImportTokenExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidImportTokenExceptionUnmarshaller() {
        super(InvalidImportTokenException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidImportTokenException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidImportTokenException invalidImportTokenException = (InvalidImportTokenException) InvalidImportTokenExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        invalidImportTokenException.setErrorCode("InvalidImportTokenException");
        return invalidImportTokenException;
    }
}
