package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class VerifySoftwareTokenResultJsonUnmarshaller implements Unmarshaller<VerifySoftwareTokenResult, JsonUnmarshallerContext> {
    private static VerifySoftwareTokenResultJsonUnmarshaller instance;

    public VerifySoftwareTokenResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        VerifySoftwareTokenResult verifySoftwareTokenResult = new VerifySoftwareTokenResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Status")) {
                verifySoftwareTokenResult.setStatus(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Session")) {
                verifySoftwareTokenResult.setSession(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return verifySoftwareTokenResult;
    }

    public static VerifySoftwareTokenResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new VerifySoftwareTokenResultJsonUnmarshaller();
        }
        return instance;
    }
}
