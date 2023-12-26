package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.RiskExceptionConfigurationType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;

class RiskExceptionConfigurationTypeJsonMarshaller {
    private static RiskExceptionConfigurationTypeJsonMarshaller instance;

    RiskExceptionConfigurationTypeJsonMarshaller() {
    }

    public void marshall(RiskExceptionConfigurationType riskExceptionConfigurationType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (riskExceptionConfigurationType.getBlockedIPRangeList() != null) {
            List<String> blockedIPRangeList = riskExceptionConfigurationType.getBlockedIPRangeList();
            awsJsonWriter.name("BlockedIPRangeList");
            awsJsonWriter.beginArray();
            for (String next : blockedIPRangeList) {
                if (next != null) {
                    awsJsonWriter.value(next);
                }
            }
            awsJsonWriter.endArray();
        }
        if (riskExceptionConfigurationType.getSkippedIPRangeList() != null) {
            List<String> skippedIPRangeList = riskExceptionConfigurationType.getSkippedIPRangeList();
            awsJsonWriter.name("SkippedIPRangeList");
            awsJsonWriter.beginArray();
            for (String next2 : skippedIPRangeList) {
                if (next2 != null) {
                    awsJsonWriter.value(next2);
                }
            }
            awsJsonWriter.endArray();
        }
        awsJsonWriter.endObject();
    }

    public static RiskExceptionConfigurationTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new RiskExceptionConfigurationTypeJsonMarshaller();
        }
        return instance;
    }
}
