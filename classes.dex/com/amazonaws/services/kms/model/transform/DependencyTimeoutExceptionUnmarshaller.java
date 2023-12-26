package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.DependencyTimeoutException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class DependencyTimeoutExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public DependencyTimeoutExceptionUnmarshaller() {
        super(DependencyTimeoutException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("DependencyTimeoutException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        DependencyTimeoutException dependencyTimeoutException = (DependencyTimeoutException) DependencyTimeoutExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        dependencyTimeoutException.setErrorCode("DependencyTimeoutException");
        return dependencyTimeoutException;
    }
}
