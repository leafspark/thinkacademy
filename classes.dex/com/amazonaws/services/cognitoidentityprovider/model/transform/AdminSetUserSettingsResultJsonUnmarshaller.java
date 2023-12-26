package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserSettingsResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AdminSetUserSettingsResultJsonUnmarshaller implements Unmarshaller<AdminSetUserSettingsResult, JsonUnmarshallerContext> {
    private static AdminSetUserSettingsResultJsonUnmarshaller instance;

    public AdminSetUserSettingsResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminSetUserSettingsResult();
    }

    public static AdminSetUserSettingsResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminSetUserSettingsResultJsonUnmarshaller();
        }
        return instance;
    }
}
