package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.LimitExceededException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class LimitExceededExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public LimitExceededExceptionUnmarshaller() {
        super(LimitExceededException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("LimitExceededException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        LimitExceededException limitExceededException = (LimitExceededException) LimitExceededExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        limitExceededException.setErrorCode("LimitExceededException");
        return limitExceededException;
    }
}
