package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidSmsRoleTrustRelationshipException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidSmsRoleTrustRelationshipExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidSmsRoleTrustRelationshipExceptionUnmarshaller() {
        super(InvalidSmsRoleTrustRelationshipException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidSmsRoleTrustRelationshipException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidSmsRoleTrustRelationshipException invalidSmsRoleTrustRelationshipException = (InvalidSmsRoleTrustRelationshipException) InvalidSmsRoleTrustRelationshipExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        invalidSmsRoleTrustRelationshipException.setErrorCode("InvalidSmsRoleTrustRelationshipException");
        return invalidSmsRoleTrustRelationshipException;
    }
}
