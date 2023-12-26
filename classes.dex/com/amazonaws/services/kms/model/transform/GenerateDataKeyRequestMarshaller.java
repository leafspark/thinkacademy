package com.amazonaws.services.kms.model.transform;

import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.GenerateDataKeyRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

public class GenerateDataKeyRequestMarshaller implements Marshaller<Request<GenerateDataKeyRequest>, GenerateDataKeyRequest> {
    public Request<GenerateDataKeyRequest> marshall(GenerateDataKeyRequest generateDataKeyRequest) {
        if (generateDataKeyRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(generateDataKeyRequest, "AWSKMS");
            defaultRequest.addHeader("X-Amz-Target", "TrentService.GenerateDataKey");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath(ExpiryDateInput.SEPARATOR);
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (generateDataKeyRequest.getKeyId() != null) {
                    String keyId = generateDataKeyRequest.getKeyId();
                    jsonWriter.name("KeyId");
                    jsonWriter.value(keyId);
                }
                if (generateDataKeyRequest.getEncryptionContext() != null) {
                    Map<String, String> encryptionContext = generateDataKeyRequest.getEncryptionContext();
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
                if (generateDataKeyRequest.getNumberOfBytes() != null) {
                    Integer numberOfBytes = generateDataKeyRequest.getNumberOfBytes();
                    jsonWriter.name("NumberOfBytes");
                    jsonWriter.value(numberOfBytes);
                }
                if (generateDataKeyRequest.getKeySpec() != null) {
                    String keySpec = generateDataKeyRequest.getKeySpec();
                    jsonWriter.name("KeySpec");
                    jsonWriter.value(keySpec);
                }
                if (generateDataKeyRequest.getGrantTokens() != null) {
                    List<String> grantTokens = generateDataKeyRequest.getGrantTokens();
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
            throw new AmazonClientException("Invalid argument passed to marshall(GenerateDataKeyRequest)");
        }
    }
}
