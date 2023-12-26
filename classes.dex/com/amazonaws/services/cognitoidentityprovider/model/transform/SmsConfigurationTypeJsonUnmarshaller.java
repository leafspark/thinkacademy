package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.SmsConfigurationType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class SmsConfigurationTypeJsonUnmarshaller implements Unmarshaller<SmsConfigurationType, JsonUnmarshallerContext> {
    private static SmsConfigurationTypeJsonUnmarshaller instance;

    SmsConfigurationTypeJsonUnmarshaller() {
    }

    public SmsConfigurationType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        SmsConfigurationType smsConfigurationType = new SmsConfigurationType();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("SnsCallerArn")) {
                smsConfigurationType.setSnsCallerArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ExternalId")) {
                smsConfigurationType.setExternalId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return smsConfigurationType;
    }

    public static SmsConfigurationTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SmsConfigurationTypeJsonUnmarshaller();
        }
        return instance;
    }
}
