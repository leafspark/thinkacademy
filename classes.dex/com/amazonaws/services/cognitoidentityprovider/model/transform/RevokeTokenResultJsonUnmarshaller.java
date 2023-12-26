package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.RevokeTokenResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class RevokeTokenResultJsonUnmarshaller implements Unmarshaller<RevokeTokenResult, JsonUnmarshallerContext> {
    private static RevokeTokenResultJsonUnmarshaller instance;

    public RevokeTokenResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new RevokeTokenResult();
    }

    public static RevokeTokenResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new RevokeTokenResultJsonUnmarshaller();
        }
        return instance;
    }
}
