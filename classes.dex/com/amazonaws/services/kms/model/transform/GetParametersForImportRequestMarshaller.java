package com.amazonaws.services.kms.model.transform;

import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.GetParametersForImportRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

public class GetParametersForImportRequestMarshaller implements Marshaller<Request<GetParametersForImportRequest>, GetParametersForImportRequest> {
    public Request<GetParametersForImportRequest> marshall(GetParametersForImportRequest getParametersForImportRequest) {
        if (getParametersForImportRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(getParametersForImportRequest, "AWSKMS");
            defaultRequest.addHeader("X-Amz-Target", "TrentService.GetParametersForImport");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath(ExpiryDateInput.SEPARATOR);
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (getParametersForImportRequest.getKeyId() != null) {
                    String keyId = getParametersForImportRequest.getKeyId();
                    jsonWriter.name("KeyId");
                    jsonWriter.value(keyId);
                }
                if (getParametersForImportRequest.getWrappingAlgorithm() != null) {
                    String wrappingAlgorithm = getParametersForImportRequest.getWrappingAlgorithm();
                    jsonWriter.name("WrappingAlgorithm");
                    jsonWriter.value(wrappingAlgorithm);
                }
                if (getParametersForImportRequest.getWrappingKeySpec() != null) {
                    String wrappingKeySpec = getParametersForImportRequest.getWrappingKeySpec();
                    jsonWriter.name("WrappingKeySpec");
                    jsonWriter.value(wrappingKeySpec);
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
            throw new AmazonClientException("Invalid argument passed to marshall(GetParametersForImportRequest)");
        }
    }
}
