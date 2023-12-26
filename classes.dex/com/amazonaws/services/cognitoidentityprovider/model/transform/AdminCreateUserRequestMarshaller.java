package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AdminCreateUserRequest;
import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

public class AdminCreateUserRequestMarshaller implements Marshaller<Request<AdminCreateUserRequest>, AdminCreateUserRequest> {
    public Request<AdminCreateUserRequest> marshall(AdminCreateUserRequest adminCreateUserRequest) {
        if (adminCreateUserRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(adminCreateUserRequest, "AmazonCognitoIdentityProvider");
            defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.AdminCreateUser");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath(ExpiryDateInput.SEPARATOR);
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (adminCreateUserRequest.getUserPoolId() != null) {
                    String userPoolId = adminCreateUserRequest.getUserPoolId();
                    jsonWriter.name("UserPoolId");
                    jsonWriter.value(userPoolId);
                }
                if (adminCreateUserRequest.getUsername() != null) {
                    String username = adminCreateUserRequest.getUsername();
                    jsonWriter.name("Username");
                    jsonWriter.value(username);
                }
                if (adminCreateUserRequest.getUserAttributes() != null) {
                    List<AttributeType> userAttributes = adminCreateUserRequest.getUserAttributes();
                    jsonWriter.name("UserAttributes");
                    jsonWriter.beginArray();
                    for (AttributeType next : userAttributes) {
                        if (next != null) {
                            AttributeTypeJsonMarshaller.getInstance().marshall(next, jsonWriter);
                        }
                    }
                    jsonWriter.endArray();
                }
                if (adminCreateUserRequest.getValidationData() != null) {
                    List<AttributeType> validationData = adminCreateUserRequest.getValidationData();
                    jsonWriter.name("ValidationData");
                    jsonWriter.beginArray();
                    for (AttributeType next2 : validationData) {
                        if (next2 != null) {
                            AttributeTypeJsonMarshaller.getInstance().marshall(next2, jsonWriter);
                        }
                    }
                    jsonWriter.endArray();
                }
                if (adminCreateUserRequest.getTemporaryPassword() != null) {
                    String temporaryPassword = adminCreateUserRequest.getTemporaryPassword();
                    jsonWriter.name("TemporaryPassword");
                    jsonWriter.value(temporaryPassword);
                }
                if (adminCreateUserRequest.getForceAliasCreation() != null) {
                    Boolean forceAliasCreation = adminCreateUserRequest.getForceAliasCreation();
                    jsonWriter.name("ForceAliasCreation");
                    jsonWriter.value(forceAliasCreation.booleanValue());
                }
                if (adminCreateUserRequest.getMessageAction() != null) {
                    String messageAction = adminCreateUserRequest.getMessageAction();
                    jsonWriter.name("MessageAction");
                    jsonWriter.value(messageAction);
                }
                if (adminCreateUserRequest.getDesiredDeliveryMediums() != null) {
                    List<String> desiredDeliveryMediums = adminCreateUserRequest.getDesiredDeliveryMediums();
                    jsonWriter.name("DesiredDeliveryMediums");
                    jsonWriter.beginArray();
                    for (String next3 : desiredDeliveryMediums) {
                        if (next3 != null) {
                            jsonWriter.value(next3);
                        }
                    }
                    jsonWriter.endArray();
                }
                if (adminCreateUserRequest.getClientMetadata() != null) {
                    Map<String, String> clientMetadata = adminCreateUserRequest.getClientMetadata();
                    jsonWriter.name("ClientMetadata");
                    jsonWriter.beginObject();
                    for (Map.Entry next4 : clientMetadata.entrySet()) {
                        String str = (String) next4.getValue();
                        if (str != null) {
                            jsonWriter.name((String) next4.getKey());
                            jsonWriter.value(str);
                        }
                    }
                    jsonWriter.endObject();
                }
                jsonWriter.endObject();
                jsonWriter.close();
                String stringWriter2 = stringWriter.toString();
                byte[] bytes = stringWriter2.getBytes(StringUtils.UTF8);
                defaultRequest.setContent(new StringInputStream(stringWriter2));
                defaultRequest.addHeader("Content-Length", Integer.toString(bytes.length));
                if (!defaultRequest.getHeaders().containsKey("Content-Type")) {
                    defaultRequest.addHeader("Content-Type", "application/x-amz-json-1.1");
                }
                return defaultRequest;
            } catch (Throwable th) {
                throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
            }
        } else {
            throw new AmazonClientException("Invalid argument passed to marshall(AdminCreateUserRequest)");
        }
    }
}
