package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GrantConstraints;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.Map;

class GrantConstraintsJsonMarshaller {
    private static GrantConstraintsJsonMarshaller instance;

    GrantConstraintsJsonMarshaller() {
    }

    public void marshall(GrantConstraints grantConstraints, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (grantConstraints.getEncryptionContextSubset() != null) {
            Map<String, String> encryptionContextSubset = grantConstraints.getEncryptionContextSubset();
            awsJsonWriter.name("EncryptionContextSubset");
            awsJsonWriter.beginObject();
            for (Map.Entry next : encryptionContextSubset.entrySet()) {
                String str = (String) next.getValue();
                if (str != null) {
                    awsJsonWriter.name((String) next.getKey());
                    awsJsonWriter.value(str);
                }
            }
            awsJsonWriter.endObject();
        }
        if (grantConstraints.getEncryptionContextEquals() != null) {
            Map<String, String> encryptionContextEquals = grantConstraints.getEncryptionContextEquals();
            awsJsonWriter.name("EncryptionContextEquals");
            awsJsonWriter.beginObject();
            for (Map.Entry next2 : encryptionContextEquals.entrySet()) {
                String str2 = (String) next2.getValue();
                if (str2 != null) {
                    awsJsonWriter.name((String) next2.getKey());
                    awsJsonWriter.value(str2);
                }
            }
            awsJsonWriter.endObject();
        }
        awsJsonWriter.endObject();
    }

    public static GrantConstraintsJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new GrantConstraintsJsonMarshaller();
        }
        return instance;
    }
}
