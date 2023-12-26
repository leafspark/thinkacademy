package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentity.model.InternalErrorException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InternalErrorExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InternalErrorExceptionUnmarshaller() {
        super(InternalErrorException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InternalErrorException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InternalErrorException internalErrorException = (InternalErrorException) InternalErrorExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        internalErrorException.setErrorCode("InternalErrorException");
        return internalErrorException;
    }
}
