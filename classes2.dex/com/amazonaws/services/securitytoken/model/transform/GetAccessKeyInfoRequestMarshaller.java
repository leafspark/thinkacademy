package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.securitytoken.model.GetAccessKeyInfoRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class GetAccessKeyInfoRequestMarshaller implements Marshaller<Request<GetAccessKeyInfoRequest>, GetAccessKeyInfoRequest> {
    public Request<GetAccessKeyInfoRequest> marshall(GetAccessKeyInfoRequest getAccessKeyInfoRequest) {
        if (getAccessKeyInfoRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(getAccessKeyInfoRequest, "AWSSecurityTokenService");
            defaultRequest.addParameter("Action", "GetAccessKeyInfo");
            defaultRequest.addParameter("Version", "2011-06-15");
            if (getAccessKeyInfoRequest.getAccessKeyId() != null) {
                defaultRequest.addParameter("AccessKeyId", StringUtils.fromString(getAccessKeyInfoRequest.getAccessKeyId()));
            }
            return defaultRequest;
        }
        throw new AmazonClientException("Invalid argument passed to marshall(GetAccessKeyInfoRequest)");
    }
}
