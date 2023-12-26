package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.MappingRule;
import com.amazonaws.services.cognitoidentity.model.RulesConfigurationType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;

class RulesConfigurationTypeJsonMarshaller {
    private static RulesConfigurationTypeJsonMarshaller instance;

    RulesConfigurationTypeJsonMarshaller() {
    }

    public void marshall(RulesConfigurationType rulesConfigurationType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (rulesConfigurationType.getRules() != null) {
            List<MappingRule> rules = rulesConfigurationType.getRules();
            awsJsonWriter.name("Rules");
            awsJsonWriter.beginArray();
            for (MappingRule next : rules) {
                if (next != null) {
                    MappingRuleJsonMarshaller.getInstance().marshall(next, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        awsJsonWriter.endObject();
    }

    public static RulesConfigurationTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new RulesConfigurationTypeJsonMarshaller();
        }
        return instance;
    }
}
