package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import com.amazonaws.services.cognitoidentityprovider.model.InitiateAuthRequest;
import com.amazonaws.services.cognitoidentityprovider.model.UserContextDataType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.Map;

public class InitiateAuthRequestMarshaller implements Marshaller<Request<InitiateAuthRequest>, InitiateAuthRequest> {
    public Request<InitiateAuthRequest> marshall(InitiateAuthRequest initiateAuthRequest) {
        if (initiateAuthRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(initiateAuthRequest, "AmazonCognitoIdentityProvider");
            defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.InitiateAuth");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath(ExpiryDateInput.SEPARATOR);
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (initiateAuthRequest.getAuthFlow() != null) {
                    String authFlow = initiateAuthRequest.getAuthFlow();
                    jsonWriter.name("AuthFlow");
                    jsonWriter.value(authFlow);
                }
                if (initiateAuthRequest.getAuthParameters() != null) {
                    Map<String, String> authParameters = initiateAuthRequest.getAuthParameters();
                    jsonWriter.name("AuthParameters");
                    jsonWriter.beginObject();
                    for (Map.Entry next : authParameters.entrySet()) {
                        String str = (String) next.getValue();
                        if (str != null) {
                            jsonWriter.name((String) next.getKey());
                            jsonWriter.value(str);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (initiateAuthRequest.getClientMetadata() != null) {
                    Map<String, String> clientMetadata = initiateAuthRequest.getClientMetadata();
                    jsonWriter.name("ClientMetadata");
                    jsonWriter.beginObject();
                    for (Map.Entry next2 : clientMetadata.entrySet()) {
                        String str2 = (String) next2.getValue();
                        if (str2 != null) {
                            jsonWriter.name((String) next2.getKey());
                            jsonWriter.value(str2);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (initiateAuthRequest.getClientId() != null) {
                    String clientId = initiateAuthRequest.getClientId();
                    jsonWriter.name("ClientId");
                    jsonWriter.value(clientId);
                }
                if (initiateAuthRequest.getAnalyticsMetadata() != null) {
                    AnalyticsMetadataType analyticsMetadata = initiateAuthRequest.getAnalyticsMetadata();
                    jsonWriter.name("AnalyticsMetadata");
                    AnalyticsMetadataTypeJsonMarshaller.getInstance().marshall(analyticsMetadata, jsonWriter);
                }
                if (initiateAuthRequest.getUserContextData() != null) {
                    UserContextDataType userContextData = initiateAuthRequest.getUserContextData();
                    jsonWriter.name("UserContextData");
                    UserContextDataTypeJsonMarshaller.getInstance().marshall(userContextData, jsonWriter);
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
            throw new AmazonClientException("Invalid argument passed to marshall(InitiateAuthRequest)");
        }
    }
}
