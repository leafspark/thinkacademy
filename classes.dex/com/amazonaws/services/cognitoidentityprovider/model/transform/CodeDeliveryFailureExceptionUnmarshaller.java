package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.CodeDeliveryFailureException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class CodeDeliveryFailureExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CodeDeliveryFailureExceptionUnmarshaller() {
        super(CodeDeliveryFailureException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("CodeDeliveryFailureException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        CodeDeliveryFailureException codeDeliveryFailureException = (CodeDeliveryFailureException) CodeDeliveryFailureExceptionUnmarshaller.super.unmarshall(jsonErrorResponse);
        codeDeliveryFailureException.setErrorCode("CodeDeliveryFailureException");
        return codeDeliveryFailureException;
    }
}
