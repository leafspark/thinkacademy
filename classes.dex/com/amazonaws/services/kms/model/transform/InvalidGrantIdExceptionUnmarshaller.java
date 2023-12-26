package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.InvalidGrantIdException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidGrantIdExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidGrantIdExceptionUnmarshaller() {
        super(InvalidGrantIdException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidGrantIdException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidGrantIdException invalidGrantIdException = (InvalidGrantIdException) InvalidGrantIdExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        invalidGrantIdException.setErrorCode("InvalidGrantIdException");
        return invalidGrantIdException;
    }
}
