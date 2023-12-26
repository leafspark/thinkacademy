package com.amazonaws.services.kms.model.transform;

import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.GenerateDataKeyPairRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

public class GenerateDataKeyPairRequestMarshaller implements Marshaller<Request<GenerateDataKeyPairRequest>, GenerateDataKeyPairRequest> {
    public Request<GenerateDataKeyPairRequest> marshall(GenerateDataKeyPairRequest generateDataKeyPairRequest) {
        if (generateDataKeyPairRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(generateDataKeyPairRequest, "AWSKMS");
            defaultRequest.addHeader("X-Amz-Target", "TrentService.GenerateDataKeyPair");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath(ExpiryDateInput.SEPARATOR);
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (generateDataKeyPairRequest.getEncryptionContext() != null) {
                    Map<String, String> encryptionContext = generateDataKeyPairRequest.getEncryptionContext();
                    jsonWriter.name("EncryptionContext");
                    jsonWriter.beginObject();
                    for (Map.Entry next : encryptionContext.entrySet()) {
                        String str = (String) next.getValue();
                        if (str != null) {
                            jsonWriter.name((String) next.getKey());
                            jsonWriter.value(str);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (generateDataKeyPairRequest.getKeyId() != null) {
                    String keyId = generateDataKeyPairRequest.getKeyId();
                    jsonWriter.name("KeyId");
                    jsonWriter.value(keyId);
                }
                if (generateDataKeyPairRequest.getKeyPairSpec() != null) {
                    String keyPairSpec = generateDataKeyPairRequest.getKeyPairSpec();
                    jsonWriter.name("KeyPairSpec");
                    jsonWriter.value(keyPairSpec);
                }
                if (generateDataKeyPairRequest.getGrantTokens() != null) {
                    List<String> grantTokens = generateDataKeyPairRequest.getGrantTokens();
                    jsonWriter.name("GrantTokens");
                    jsonWriter.beginArray();
                    for (String next2 : grantTokens) {
                        if (next2 != null) {
                            jsonWriter.value(next2);
                        }
                    }
                    jsonWriter.endArray();
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
            throw new AmazonClientException("Invalid argument passed to marshall(GenerateDataKeyPairRequest)");
        }
    }
}
