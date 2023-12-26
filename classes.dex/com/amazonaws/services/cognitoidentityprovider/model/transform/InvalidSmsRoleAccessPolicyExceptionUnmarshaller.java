package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidSmsRoleAccessPolicyException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidSmsRoleAccessPolicyExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidSmsRoleAccessPolicyExceptionUnmarshaller() {
        super(InvalidSmsRoleAccessPolicyException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidSmsRoleAccessPolicyException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidSmsRoleAccessPolicyException invalidSmsRoleAccessPolicyException = (InvalidSmsRoleAccessPolicyException) InvalidSmsRoleAccessPolicyExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        invalidSmsRoleAccessPolicyException.setErrorCode("InvalidSmsRoleAccessPolicyException");
        return invalidSmsRoleAccessPolicyException;
    }
}
