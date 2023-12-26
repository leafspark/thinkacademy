package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminLinkProviderForUserResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AdminLinkProviderForUserResultJsonUnmarshaller implements Unmarshaller<AdminLinkProviderForUserResult, JsonUnmarshallerContext> {
    private static AdminLinkProviderForUserResultJsonUnmarshaller instance;

    public AdminLinkProviderForUserResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminLinkProviderForUserResult();
    }

    public static AdminLinkProviderForUserResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminLinkProviderForUserResultJsonUnmarshaller();
        }
        return instance;
    }
}
