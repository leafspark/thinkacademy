package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentity.model.DeveloperUserAlreadyRegisteredException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class DeveloperUserAlreadyRegisteredExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public DeveloperUserAlreadyRegisteredExceptionUnmarshaller() {
        super(DeveloperUserAlreadyRegisteredException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("DeveloperUserAlreadyRegisteredException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        DeveloperUserAlreadyRegisteredException developerUserAlreadyRegisteredException = (DeveloperUserAlreadyRegisteredException) DeveloperUserAlreadyRegisteredExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        developerUserAlreadyRegisteredException.setErrorCode("DeveloperUserAlreadyRegisteredException");
        return developerUserAlreadyRegisteredException;
    }
}
