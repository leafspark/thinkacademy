package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DecodeAuthorizationMessageRequestMarshaller implements Marshaller<Request<DecodeAuthorizationMessageRequest>, DecodeAuthorizationMessageRequest> {
    public Request<DecodeAuthorizationMessageRequest> marshall(DecodeAuthorizationMessageRequest decodeAuthorizationMessageRequest) {
        if (decodeAuthorizationMessageRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(decodeAuthorizationMessageRequest, "AWSSecurityTokenService");
            defaultRequest.addParameter("Action", "DecodeAuthorizationMessage");
            defaultRequest.addParameter("Version", "2011-06-15");
            if (decodeAuthorizationMessageRequest.getEncodedMessage() != null) {
                defaultRequest.addParameter("EncodedMessage", StringUtils.fromString(decodeAuthorizationMessageRequest.getEncodedMessage()));
            }
            return defaultRequest;
        }
        throw new AmazonClientException("Invalid argument passed to marshall(DecodeAuthorizationMessageRequest)");
    }
}
