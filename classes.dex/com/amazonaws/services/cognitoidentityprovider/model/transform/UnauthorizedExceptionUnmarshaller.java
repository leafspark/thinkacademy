package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UnauthorizedException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class UnauthorizedExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UnauthorizedExceptionUnmarshaller() {
        super(UnauthorizedException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UnauthorizedException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UnauthorizedException unauthorizedException = (UnauthorizedException) UnauthorizedExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        unauthorizedException.setErrorCode("UnauthorizedException");
        return unauthorizedException;
    }
}
