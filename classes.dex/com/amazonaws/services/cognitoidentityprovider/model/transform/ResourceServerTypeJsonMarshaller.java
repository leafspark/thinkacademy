package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ResourceServerScopeType;
import com.amazonaws.services.cognitoidentityprovider.model.ResourceServerType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;

class ResourceServerTypeJsonMarshaller {
    private static ResourceServerTypeJsonMarshaller instance;

    ResourceServerTypeJsonMarshaller() {
    }

    public void marshall(ResourceServerType resourceServerType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (resourceServerType.getUserPoolId() != null) {
            String userPoolId = resourceServerType.getUserPoolId();
            awsJsonWriter.name("UserPoolId");
            awsJsonWriter.value(userPoolId);
        }
        if (resourceServerType.getIdentifier() != null) {
            String identifier = resourceServerType.getIdentifier();
            awsJsonWriter.name("Identifier");
            awsJsonWriter.value(identifier);
        }
        if (resourceServerType.getName() != null) {
            String name = resourceServerType.getName();
            awsJsonWriter.name("Name");
            awsJsonWriter.value(name);
        }
        if (resourceServerType.getScopes() != null) {
            List<ResourceServerScopeType> scopes = resourceServerType.getScopes();
            awsJsonWriter.name("Scopes");
            awsJsonWriter.beginArray();
            for (ResourceServerScopeType next : scopes) {
                if (next != null) {
                    ResourceServerScopeTypeJsonMarshaller.getInstance().marshall(next, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        awsJsonWriter.endObject();
    }

    public static ResourceServerTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ResourceServerTypeJsonMarshaller();
        }
        return instance;
    }
}
