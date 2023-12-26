package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.InvalidArnException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidArnExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidArnExceptionUnmarshaller() {
        super(InvalidArnException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidArnException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidArnException invalidArnException = (InvalidArnException) InvalidArnExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        invalidArnException.setErrorCode("InvalidArnException");
        return invalidArnException;
    }
}
