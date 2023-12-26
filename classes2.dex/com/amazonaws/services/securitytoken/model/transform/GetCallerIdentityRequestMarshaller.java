package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.securitytoken.model.GetCallerIdentityRequest;
import com.amazonaws.transform.Marshaller;

public class GetCallerIdentityRequestMarshaller implements Marshaller<Request<GetCallerIdentityRequest>, GetCallerIdentityRequest> {
    public Request<GetCallerIdentityRequest> marshall(GetCallerIdentityRequest getCallerIdentityRequest) {
        if (getCallerIdentityRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(getCallerIdentityRequest, "AWSSecurityTokenService");
            defaultRequest.addParameter("Action", "GetCallerIdentity");
            defaultRequest.addParameter("Version", "2011-06-15");
            return defaultRequest;
        }
        throw new AmazonClientException("Invalid argument passed to marshall(GetCallerIdentityRequest)");
    }
}
