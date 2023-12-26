package com.amazonaws.services.kms.model.transform;

import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.ReplicateKeyRequest;
import com.amazonaws.services.kms.model.Tag;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;

public class ReplicateKeyRequestMarshaller implements Marshaller<Request<ReplicateKeyRequest>, ReplicateKeyRequest> {
    public Request<ReplicateKeyRequest> marshall(ReplicateKeyRequest replicateKeyRequest) {
        if (replicateKeyRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(replicateKeyRequest, "AWSKMS");
            defaultRequest.addHeader("X-Amz-Target", "TrentService.ReplicateKey");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath(ExpiryDateInput.SEPARATOR);
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (replicateKeyRequest.getKeyId() != null) {
                    String keyId = replicateKeyRequest.getKeyId();
                    jsonWriter.name("KeyId");
                    jsonWriter.value(keyId);
                }
                if (replicateKeyRequest.getReplicaRegion() != null) {
                    String replicaRegion = replicateKeyRequest.getReplicaRegion();
                    jsonWriter.name("ReplicaRegion");
                    jsonWriter.value(replicaRegion);
                }
                if (replicateKeyRequest.getPolicy() != null) {
                    String policy = replicateKeyRequest.getPolicy();
                    jsonWriter.name("Policy");
                    jsonWriter.value(policy);
                }
                if (replicateKeyRequest.getBypassPolicyLockoutSafetyCheck() != null) {
                    Boolean bypassPolicyLockoutSafetyCheck = replicateKeyRequest.getBypassPolicyLockoutSafetyCheck();
                    jsonWriter.name("BypassPolicyLockoutSafetyCheck");
                    jsonWriter.value(bypassPolicyLockoutSafetyCheck.booleanValue());
                }
                if (replicateKeyRequest.getDescription() != null) {
                    String description = replicateKeyRequest.getDescription();
                    jsonWriter.name("Description");
                    jsonWriter.value(description);
                }
                if (replicateKeyRequest.getTags() != null) {
                    List<Tag> tags = replicateKeyRequest.getTags();
                    jsonWriter.name("Tags");
                    jsonWriter.beginArray();
                    for (Tag next : tags) {
                        if (next != null) {
                            TagJsonMarshaller.getInstance().marshall(next, jsonWriter);
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
            throw new AmazonClientException("Invalid argument passed to marshall(ReplicateKeyRequest)");
        }
    }
}
