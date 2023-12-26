package com.amazonaws.services.kms.model.transform;

import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.PutKeyPolicyRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

public class PutKeyPolicyRequestMarshaller implements Marshaller<Request<PutKeyPolicyRequest>, PutKeyPolicyRequest> {
    public Request<PutKeyPolicyRequest> marshall(PutKeyPolicyRequest putKeyPolicyRequest) {
        if (putKeyPolicyRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(putKeyPolicyRequest, "AWSKMS");
            defaultRequest.addHeader("X-Amz-Target", "TrentService.PutKeyPolicy");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath(ExpiryDateInput.SEPARATOR);
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (putKeyPolicyRequest.getKeyId() != null) {
                    String keyId = putKeyPolicyRequest.getKeyId();
                    jsonWriter.name("KeyId");
                    jsonWriter.value(keyId);
                }
                if (putKeyPolicyRequest.getPolicyName() != null) {
                    String policyName = putKeyPolicyRequest.getPolicyName();
                    jsonWriter.name("PolicyName");
                    jsonWriter.value(policyName);
                }
                if (putKeyPolicyRequest.getPolicy() != null) {
                    String policy = putKeyPolicyRequest.getPolicy();
                    jsonWriter.name("Policy");
                    jsonWriter.value(policy);
                }
                if (putKeyPolicyRequest.getBypassPolicyLockoutSafetyCheck() != null) {
                    Boolean bypassPolicyLockoutSafetyCheck = putKeyPolicyRequest.getBypassPolicyLockoutSafetyCheck();
                    jsonWriter.name("BypassPolicyLockoutSafetyCheck");
                    jsonWriter.value(bypassPolicyLockoutSafetyCheck.booleanValue());
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
            throw new AmazonClientException("Invalid argument passed to marshall(PutKeyPolicyRequest)");
        }
    }
}
