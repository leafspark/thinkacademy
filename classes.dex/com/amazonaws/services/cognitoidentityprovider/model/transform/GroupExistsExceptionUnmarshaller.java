package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.GroupExistsException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class GroupExistsExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public GroupExistsExceptionUnmarshaller() {
        super(GroupExistsException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("GroupExistsException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        GroupExistsException groupExistsException = (GroupExistsException) GroupExistsExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        groupExistsException.setErrorCode("GroupExistsException");
        return groupExistsException;
    }
}
