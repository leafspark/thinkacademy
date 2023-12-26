package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UnsupportedIdentityProviderException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class UnsupportedIdentityProviderExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UnsupportedIdentityProviderExceptionUnmarshaller() {
        super(UnsupportedIdentityProviderException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UnsupportedIdentityProviderException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UnsupportedIdentityProviderException unsupportedIdentityProviderException = (UnsupportedIdentityProviderException) UnsupportedIdentityProviderExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        unsupportedIdentityProviderException.setErrorCode("UnsupportedIdentityProviderException");
        return unsupportedIdentityProviderException;
    }
}
