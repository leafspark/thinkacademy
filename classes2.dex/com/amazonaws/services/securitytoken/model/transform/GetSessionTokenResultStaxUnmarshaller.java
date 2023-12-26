package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.GetSessionTokenResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class GetSessionTokenResultStaxUnmarshaller implements Unmarshaller<GetSessionTokenResult, StaxUnmarshallerContext> {
    private static GetSessionTokenResultStaxUnmarshaller instance;

    public GetSessionTokenResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        GetSessionTokenResult getSessionTokenResult = new GetSessionTokenResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            int nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent != 1) {
                if (nextEvent != 2) {
                    if (nextEvent == 3 && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                        break;
                    }
                } else if (staxUnmarshallerContext.testExpression("Credentials", i)) {
                    getSessionTokenResult.setCredentials(CredentialsStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else {
                break;
            }
        }
        return getSessionTokenResult;
    }

    public static GetSessionTokenResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetSessionTokenResultStaxUnmarshaller();
        }
        return instance;
    }
}
