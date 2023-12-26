package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminDeleteUserAttributesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AdminDeleteUserAttributesResultJsonUnmarshaller implements Unmarshaller<AdminDeleteUserAttributesResult, JsonUnmarshallerContext> {
    private static AdminDeleteUserAttributesResultJsonUnmarshaller instance;

    public AdminDeleteUserAttributesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminDeleteUserAttributesResult();
    }

    public static AdminDeleteUserAttributesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminDeleteUserAttributesResultJsonUnmarshaller();
        }
        return instance;
    }
}
