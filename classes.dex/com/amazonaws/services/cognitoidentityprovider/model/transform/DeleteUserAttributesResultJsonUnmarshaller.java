package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DeleteUserAttributesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DeleteUserAttributesResultJsonUnmarshaller implements Unmarshaller<DeleteUserAttributesResult, JsonUnmarshallerContext> {
    private static DeleteUserAttributesResultJsonUnmarshaller instance;

    public DeleteUserAttributesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new DeleteUserAttributesResult();
    }

    public static DeleteUserAttributesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteUserAttributesResultJsonUnmarshaller();
        }
        return instance;
    }
}
