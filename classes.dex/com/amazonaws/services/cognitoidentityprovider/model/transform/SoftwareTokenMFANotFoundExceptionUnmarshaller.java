package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.SoftwareTokenMFANotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class SoftwareTokenMFANotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public SoftwareTokenMFANotFoundExceptionUnmarshaller() {
        super(SoftwareTokenMFANotFoundException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("SoftwareTokenMFANotFoundException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        SoftwareTokenMFANotFoundException softwareTokenMFANotFoundException = (SoftwareTokenMFANotFoundException) SoftwareTokenMFANotFoundExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        softwareTokenMFANotFoundException.setErrorCode("SoftwareTokenMFANotFoundException");
        return softwareTokenMFANotFoundException;
    }
}
