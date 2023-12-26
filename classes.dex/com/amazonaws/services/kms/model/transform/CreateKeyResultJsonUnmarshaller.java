package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.CreateKeyResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class CreateKeyResultJsonUnmarshaller implements Unmarshaller<CreateKeyResult, JsonUnmarshallerContext> {
    private static CreateKeyResultJsonUnmarshaller instance;

    public CreateKeyResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        CreateKeyResult createKeyResult = new CreateKeyResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("KeyMetadata")) {
                createKeyResult.setKeyMetadata(KeyMetadataJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return createKeyResult;
    }

    public static CreateKeyResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateKeyResultJsonUnmarshaller();
        }
        return instance;
    }
}
