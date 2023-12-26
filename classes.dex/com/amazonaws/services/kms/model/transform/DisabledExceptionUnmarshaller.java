package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.DisabledException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class DisabledExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public DisabledExceptionUnmarshaller() {
        super(DisabledException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("DisabledException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        DisabledException disabledException = (DisabledException) DisabledExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        disabledException.setErrorCode("DisabledException");
        return disabledException;
    }
}
