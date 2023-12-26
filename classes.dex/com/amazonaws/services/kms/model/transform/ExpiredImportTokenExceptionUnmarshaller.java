package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.ExpiredImportTokenException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class ExpiredImportTokenExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ExpiredImportTokenExceptionUnmarshaller() {
        super(ExpiredImportTokenException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ExpiredImportTokenException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ExpiredImportTokenException expiredImportTokenException = (ExpiredImportTokenException) ExpiredImportTokenExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        expiredImportTokenException.setErrorCode("ExpiredImportTokenException");
        return expiredImportTokenException;
    }
}
