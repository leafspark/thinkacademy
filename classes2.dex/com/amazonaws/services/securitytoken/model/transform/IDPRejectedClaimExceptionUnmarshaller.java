package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.securitytoken.model.IDPRejectedClaimException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class IDPRejectedClaimExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public IDPRejectedClaimExceptionUnmarshaller() {
        super(IDPRejectedClaimException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("IDPRejectedClaim")) {
            return null;
        }
        return super.unmarshall(node);
    }
}
