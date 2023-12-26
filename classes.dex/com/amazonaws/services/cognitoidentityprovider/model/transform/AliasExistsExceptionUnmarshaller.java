package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.AliasExistsException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class AliasExistsExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public AliasExistsExceptionUnmarshaller() {
        super(AliasExistsException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("AliasExistsException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        AliasExistsException aliasExistsException = (AliasExistsException) AliasExistsExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        aliasExistsException.setErrorCode("AliasExistsException");
        return aliasExistsException;
    }
}
