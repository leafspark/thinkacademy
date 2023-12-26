package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentity.model.ResourceConflictException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class ResourceConflictExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ResourceConflictExceptionUnmarshaller() {
        super(ResourceConflictException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ResourceConflictException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ResourceConflictException resourceConflictException = (ResourceConflictException) ResourceConflictExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        resourceConflictException.setErrorCode("ResourceConflictException");
        return resourceConflictException;
    }
}
