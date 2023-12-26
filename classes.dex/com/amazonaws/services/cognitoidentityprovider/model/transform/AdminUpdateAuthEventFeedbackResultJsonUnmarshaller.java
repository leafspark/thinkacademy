package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateAuthEventFeedbackResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AdminUpdateAuthEventFeedbackResultJsonUnmarshaller implements Unmarshaller<AdminUpdateAuthEventFeedbackResult, JsonUnmarshallerContext> {
    private static AdminUpdateAuthEventFeedbackResultJsonUnmarshaller instance;

    public AdminUpdateAuthEventFeedbackResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminUpdateAuthEventFeedbackResult();
    }

    public static AdminUpdateAuthEventFeedbackResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminUpdateAuthEventFeedbackResultJsonUnmarshaller();
        }
        return instance;
    }
}
