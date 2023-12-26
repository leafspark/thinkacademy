package com.amazonaws.services.cognitoidentity.model.transform;

import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentity.model.CognitoIdentityProvider;
import com.amazonaws.services.cognitoidentity.model.CreateIdentityPoolRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

public class CreateIdentityPoolRequestMarshaller implements Marshaller<Request<CreateIdentityPoolRequest>, CreateIdentityPoolRequest> {
    public Request<CreateIdentityPoolRequest> marshall(CreateIdentityPoolRequest createIdentityPoolRequest) {
        if (createIdentityPoolRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(createIdentityPoolRequest, "AmazonCognitoIdentity");
            defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityService.CreateIdentityPool");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath(ExpiryDateInput.SEPARATOR);
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (createIdentityPoolRequest.getIdentityPoolName() != null) {
                    String identityPoolName = createIdentityPoolRequest.getIdentityPoolName();
                    jsonWriter.name("IdentityPoolName");
                    jsonWriter.value(identityPoolName);
                }
                if (createIdentityPoolRequest.getAllowUnauthenticatedIdentities() != null) {
                    Boolean allowUnauthenticatedIdentities = createIdentityPoolRequest.getAllowUnauthenticatedIdentities();
                    jsonWriter.name("AllowUnauthenticatedIdentities");
                    jsonWriter.value(allowUnauthenticatedIdentities.booleanValue());
                }
                if (createIdentityPoolRequest.getAllowClassicFlow() != null) {
                    Boolean allowClassicFlow = createIdentityPoolRequest.getAllowClassicFlow();
                    jsonWriter.name("AllowClassicFlow");
                    jsonWriter.value(allowClassicFlow.booleanValue());
                }
                if (createIdentityPoolRequest.getSupportedLoginProviders() != null) {
                    Map<String, String> supportedLoginProviders = createIdentityPoolRequest.getSupportedLoginProviders();
                    jsonWriter.name("SupportedLoginProviders");
                    jsonWriter.beginObject();
                    for (Map.Entry next : supportedLoginProviders.entrySet()) {
                        String str = (String) next.getValue();
                        if (str != null) {
                            jsonWriter.name((String) next.getKey());
                            jsonWriter.value(str);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (createIdentityPoolRequest.getDeveloperProviderName() != null) {
                    String developerProviderName = createIdentityPoolRequest.getDeveloperProviderName();
                    jsonWriter.name("DeveloperProviderName");
                    jsonWriter.value(developerProviderName);
                }
                if (createIdentityPoolRequest.getOpenIdConnectProviderARNs() != null) {
                    List<String> openIdConnectProviderARNs = createIdentityPoolRequest.getOpenIdConnectProviderARNs();
                    jsonWriter.name("OpenIdConnectProviderARNs");
                    jsonWriter.beginArray();
                    for (String next2 : openIdConnectProviderARNs) {
                        if (next2 != null) {
                            jsonWriter.value(next2);
                        }
                    }
                    jsonWriter.endArray();
                }
                if (createIdentityPoolRequest.getCognitoIdentityProviders() != null) {
                    List<CognitoIdentityProvider> cognitoIdentityProviders = createIdentityPoolRequest.getCognitoIdentityProviders();
                    jsonWriter.name("CognitoIdentityProviders");
                    jsonWriter.beginArray();
                    for (CognitoIdentityProvider next3 : cognitoIdentityProviders) {
                        if (next3 != null) {
                            CognitoIdentityProviderJsonMarshaller.getInstance().marshall(next3, jsonWriter);
                        }
                    }
                    jsonWriter.endArray();
                }
                if (createIdentityPoolRequest.getSamlProviderARNs() != null) {
                    List<String> samlProviderARNs = createIdentityPoolRequest.getSamlProviderARNs();
                    jsonWriter.name("SamlProviderARNs");
                    jsonWriter.beginArray();
                    for (String next4 : samlProviderARNs) {
                        if (next4 != null) {
                            jsonWriter.value(next4);
                        }
                    }
                    jsonWriter.endArray();
                }
                if (createIdentityPoolRequest.getIdentityPoolTags() != null) {
                    Map<String, String> identityPoolTags = createIdentityPoolRequest.getIdentityPoolTags();
                    jsonWriter.name("IdentityPoolTags");
                    jsonWriter.beginObject();
                    for (Map.Entry next5 : identityPoolTags.entrySet()) {
                        String str2 = (String) next5.getValue();
                        if (str2 != null) {
                            jsonWriter.name((String) next5.getKey());
                            jsonWriter.value(str2);
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
            throw new AmazonClientException("Invalid argument passed to marshall(CreateIdentityPoolRequest)");
        }
    }
}
