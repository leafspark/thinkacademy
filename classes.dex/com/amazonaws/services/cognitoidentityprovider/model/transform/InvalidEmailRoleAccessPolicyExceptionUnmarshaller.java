package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidEmailRoleAccessPolicyException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidEmailRoleAccessPolicyExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidEmailRoleAccessPolicyExceptionUnmarshaller() {
        super(InvalidEmailRoleAccessPolicyException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidEmailRoleAccessPolicyException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidEmailRoleAccessPolicyException invalidEmailRoleAccessPolicyException = (InvalidEmailRoleAccessPolicyException) InvalidEmailRoleAccessPolicyExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        invalidEmailRoleAccessPolicyException.setErrorCode("InvalidEmailRoleAccessPolicyException");
        return invalidEmailRoleAccessPolicyException;
    }
}
