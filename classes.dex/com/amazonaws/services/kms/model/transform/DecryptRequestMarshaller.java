package com.amazonaws.services.kms.model.transform;

import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public class DecryptRequestMarshaller implements Marshaller<Request<DecryptRequest>, DecryptRequest> {
    public Request<DecryptRequest> marshall(DecryptRequest decryptRequest) {
        if (decryptRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(decryptRequest, "AWSKMS");
            defaultRequest.addHeader("X-Amz-Target", "TrentService.Decrypt");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath(ExpiryDateInput.SEPARATOR);
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (decryptRequest.getCiphertextBlob() != null) {
                    ByteBuffer ciphertextBlob = decryptRequest.getCiphertextBlob();
                    jsonWriter.name("CiphertextBlob");
                    jsonWriter.value(ciphertextBlob);
                }
                if (decryptRequest.getEncryptionContext() != null) {
                    Map<String, String> encryptionContext = decryptRequest.getEncryptionContext();
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
                if (decryptRequest.getGrantTokens() != null) {
                    List<String> grantTokens = decryptRequest.getGrantTokens();
                    jsonWriter.name("GrantTokens");
                    jsonWriter.beginArray();
                    for (String next2 : grantTokens) {
                        if (next2 != null) {
                            jsonWriter.value(next2);
                        }
                    }
                    jsonWriter.endArray();
                }
                if (decryptRequest.getKeyId() != null) {
                    String keyId = decryptRequest.getKeyId();
                    jsonWriter.name("KeyId");
                    jsonWriter.value(keyId);
                }
                if (decryptRequest.getEncryptionAlgorithm() != null) {
                    String encryptionAlgorithm = decryptRequest.getEncryptionAlgorithm();
                    jsonWriter.name("EncryptionAlgorithm");
                    jsonWriter.value(encryptionAlgorithm);
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
            throw new AmazonClientException("Invalid argument passed to marshall(DecryptRequest)");
        }
    }
}
