package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateDeviceStatusResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AdminUpdateDeviceStatusResultJsonUnmarshaller implements Unmarshaller<AdminUpdateDeviceStatusResult, JsonUnmarshallerContext> {
    private static AdminUpdateDeviceStatusResultJsonUnmarshaller instance;

    public AdminUpdateDeviceStatusResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminUpdateDeviceStatusResult();
    }

    public static AdminUpdateDeviceStatusResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminUpdateDeviceStatusResultJsonUnmarshaller();
        }
        return instance;
    }
}
