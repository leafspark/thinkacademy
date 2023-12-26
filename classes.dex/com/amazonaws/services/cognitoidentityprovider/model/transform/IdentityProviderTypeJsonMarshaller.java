package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.IdentityProviderType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

class IdentityProviderTypeJsonMarshaller {
    private static IdentityProviderTypeJsonMarshaller instance;

    IdentityProviderTypeJsonMarshaller() {
    }

    public void marshall(IdentityProviderType identityProviderType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (identityProviderType.getUserPoolId() != null) {
            String userPoolId = identityProviderType.getUserPoolId();
            awsJsonWriter.name("UserPoolId");
            awsJsonWriter.value(userPoolId);
        }
        if (identityProviderType.getProviderName() != null) {
            String providerName = identityProviderType.getProviderName();
            awsJsonWriter.name("ProviderName");
            awsJsonWriter.value(providerName);
        }
        if (identityProviderType.getProviderType() != null) {
            String providerType = identityProviderType.getProviderType();
            awsJsonWriter.name("ProviderType");
            awsJsonWriter.value(providerType);
        }
        if (identityProviderType.getProviderDetails() != null) {
            Map<String, String> providerDetails = identityProviderType.getProviderDetails();
            awsJsonWriter.name("ProviderDetails");
            awsJsonWriter.beginObject();
            for (Map.Entry next : providerDetails.entrySet()) {
                String str = (String) next.getValue();
                if (str != null) {
                    awsJsonWriter.name((String) next.getKey());
                    awsJsonWriter.value(str);
                }
            }
            awsJsonWriter.endObject();
        }
        if (identityProviderType.getAttributeMapping() != null) {
            Map<String, String> attributeMapping = identityProviderType.getAttributeMapping();
            awsJsonWriter.name("AttributeMapping");
            awsJsonWriter.beginObject();
            for (Map.Entry next2 : attributeMapping.entrySet()) {
                String str2 = (String) next2.getValue();
                if (str2 != null) {
                    awsJsonWriter.name((String) next2.getKey());
                    awsJsonWriter.value(str2);
                }
            }
            awsJsonWriter.endObject();
        }
        if (identityProviderType.getIdpIdentifiers() != null) {
            List<String> idpIdentifiers = identityProviderType.getIdpIdentifiers();
            awsJsonWriter.name("IdpIdentifiers");
            awsJsonWriter.beginArray();
            for (String next3 : idpIdentifiers) {
                if (next3 != null) {
                    awsJsonWriter.value(next3);
                }
            }
            awsJsonWriter.endArray();
        }
        if (identityProviderType.getLastModifiedDate() != null) {
            Date lastModifiedDate = identityProviderType.getLastModifiedDate();
            awsJsonWriter.name("LastModifiedDate");
            awsJsonWriter.value(lastModifiedDate);
        }
        if (identityProviderType.getCreationDate() != null) {
            Date creationDate = identityProviderType.getCreationDate();
            awsJsonWriter.name("CreationDate");
            awsJsonWriter.value(creationDate);
        }
        awsJsonWriter.endObject();
    }

    public static IdentityProviderTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new IdentityProviderTypeJsonMarshaller();
        }
        return instance;
    }
}
