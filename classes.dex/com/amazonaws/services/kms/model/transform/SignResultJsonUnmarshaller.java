package com.amazonaws.services.kms.model.transform;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.amazonaws.services.kms.model.SignResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class SignResultJsonUnmarshaller implements Unmarshaller<SignResult, JsonUnmarshallerContext> {
    private static SignResultJsonUnmarshaller instance;

    public SignResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        SignResult signResult = new SignResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("KeyId")) {
                signResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals(RequestParameters.SIGNATURE)) {
                signResult.setSignature(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("SigningAlgorithm")) {
                signResult.setSigningAlgorithm(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return signResult;
    }

    public static SignResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SignResultJsonUnmarshaller();
        }
        return instance;
    }
}
