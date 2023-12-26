package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ConfirmForgotPasswordResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ConfirmForgotPasswordResultJsonUnmarshaller implements Unmarshaller<ConfirmForgotPasswordResult, JsonUnmarshallerContext> {
    private static ConfirmForgotPasswordResultJsonUnmarshaller instance;

    public ConfirmForgotPasswordResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new ConfirmForgotPasswordResult();
    }

    public static ConfirmForgotPasswordResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ConfirmForgotPasswordResultJsonUnmarshaller();
        }
        return instance;
    }
}
