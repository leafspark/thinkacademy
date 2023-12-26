package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.InvalidAliasNameException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidAliasNameExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidAliasNameExceptionUnmarshaller() {
        super(InvalidAliasNameException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidAliasNameException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidAliasNameException invalidAliasNameException = (InvalidAliasNameException) InvalidAliasNameExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        invalidAliasNameException.setErrorCode("InvalidAliasNameException");
        return invalidAliasNameException;
    }
}
