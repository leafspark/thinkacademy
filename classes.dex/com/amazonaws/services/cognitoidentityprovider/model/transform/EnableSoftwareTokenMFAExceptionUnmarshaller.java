package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.EnableSoftwareTokenMFAException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class EnableSoftwareTokenMFAExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public EnableSoftwareTokenMFAExceptionUnmarshaller() {
        super(EnableSoftwareTokenMFAException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("EnableSoftwareTokenMFAException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        EnableSoftwareTokenMFAException enableSoftwareTokenMFAException = (EnableSoftwareTokenMFAException) EnableSoftwareTokenMFAExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        enableSoftwareTokenMFAException.setErrorCode("EnableSoftwareTokenMFAException");
        return enableSoftwareTokenMFAException;
    }
}
