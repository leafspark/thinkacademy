package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.StartUserImportJobResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class StartUserImportJobResultJsonUnmarshaller implements Unmarshaller<StartUserImportJobResult, JsonUnmarshallerContext> {
    private static StartUserImportJobResultJsonUnmarshaller instance;

    public StartUserImportJobResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        StartUserImportJobResult startUserImportJobResult = new StartUserImportJobResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("UserImportJob")) {
                startUserImportJobResult.setUserImportJob(UserImportJobTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return startUserImportJobResult;
    }

    public static StartUserImportJobResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new StartUserImportJobResultJsonUnmarshaller();
        }
        return instance;
    }
}
