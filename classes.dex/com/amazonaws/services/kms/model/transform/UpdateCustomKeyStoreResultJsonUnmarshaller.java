package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.UpdateCustomKeyStoreResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class UpdateCustomKeyStoreResultJsonUnmarshaller implements Unmarshaller<UpdateCustomKeyStoreResult, JsonUnmarshallerContext> {
    private static UpdateCustomKeyStoreResultJsonUnmarshaller instance;

    public UpdateCustomKeyStoreResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new UpdateCustomKeyStoreResult();
    }

    public static UpdateCustomKeyStoreResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateCustomKeyStoreResultJsonUnmarshaller();
        }
        return instance;
    }
}
