package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.TooManyRequestsException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class TooManyRequestsExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public TooManyRequestsExceptionUnmarshaller() {
        super(TooManyRequestsException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("TooManyRequestsException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        TooManyRequestsException tooManyRequestsException = (TooManyRequestsException) TooManyRequestsExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        tooManyRequestsException.setErrorCode("TooManyRequestsException");
        return tooManyRequestsException;
    }
}
