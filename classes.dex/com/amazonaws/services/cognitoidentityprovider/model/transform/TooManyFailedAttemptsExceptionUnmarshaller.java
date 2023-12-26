package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.TooManyFailedAttemptsException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class TooManyFailedAttemptsExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public TooManyFailedAttemptsExceptionUnmarshaller() {
        super(TooManyFailedAttemptsException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("TooManyFailedAttemptsException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        TooManyFailedAttemptsException tooManyFailedAttemptsException = (TooManyFailedAttemptsException) TooManyFailedAttemptsExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        tooManyFailedAttemptsException.setErrorCode("TooManyFailedAttemptsException");
        return tooManyFailedAttemptsException;
    }
}
