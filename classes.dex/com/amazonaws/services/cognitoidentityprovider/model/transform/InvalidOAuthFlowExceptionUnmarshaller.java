package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidOAuthFlowException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidOAuthFlowExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidOAuthFlowExceptionUnmarshaller() {
        super(InvalidOAuthFlowException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidOAuthFlowException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidOAuthFlowException invalidOAuthFlowException = (InvalidOAuthFlowException) InvalidOAuthFlowExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        invalidOAuthFlowException.setErrorCode("InvalidOAuthFlowException");
        return invalidOAuthFlowException;
    }
}
