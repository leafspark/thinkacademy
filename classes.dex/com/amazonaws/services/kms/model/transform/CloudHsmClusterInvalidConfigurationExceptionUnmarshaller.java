package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.CloudHsmClusterInvalidConfigurationException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class CloudHsmClusterInvalidConfigurationExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CloudHsmClusterInvalidConfigurationExceptionUnmarshaller() {
        super(CloudHsmClusterInvalidConfigurationException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("CloudHsmClusterInvalidConfigurationException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        CloudHsmClusterInvalidConfigurationException cloudHsmClusterInvalidConfigurationException = (CloudHsmClusterInvalidConfigurationException) CloudHsmClusterInvalidConfigurationExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        cloudHsmClusterInvalidConfigurationException.setErrorCode("CloudHsmClusterInvalidConfigurationException");
        return cloudHsmClusterInvalidConfigurationException;
    }
}
