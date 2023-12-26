package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.AlreadyExistsException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class AlreadyExistsExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public AlreadyExistsExceptionUnmarshaller() {
        super(AlreadyExistsException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("AlreadyExistsException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        AlreadyExistsException alreadyExistsException = (AlreadyExistsException) AlreadyExistsExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        alreadyExistsException.setErrorCode("AlreadyExistsException");
        return alreadyExistsException;
    }
}
