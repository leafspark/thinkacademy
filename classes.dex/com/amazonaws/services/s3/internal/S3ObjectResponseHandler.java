package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

public class S3ObjectResponseHandler extends AbstractS3ResponseHandler<S3Object> {
    public boolean needsConnectionLeftOpen() {
        return true;
    }

    public AmazonWebServiceResponse<S3Object> handle(HttpResponse httpResponse) throws Exception {
        S3Object s3Object = new S3Object();
        AmazonWebServiceResponse<S3Object> parseResponseMetadata = parseResponseMetadata(httpResponse);
        if (httpResponse.getHeaders().get(Headers.REDIRECT_LOCATION) != null) {
            s3Object.setRedirectLocation(httpResponse.getHeaders().get(Headers.REDIRECT_LOCATION));
        }
        if (httpResponse.getHeaders().get(Headers.REQUESTER_CHARGED_HEADER) != null) {
            s3Object.setRequesterCharged(true);
        }
        if (httpResponse.getHeaders().get(Headers.S3_TAGGING_COUNT) != null) {
            s3Object.setTaggingCount(Integer.valueOf(Integer.parseInt(httpResponse.getHeaders().get(Headers.S3_TAGGING_COUNT))));
        }
        populateObjectMetadata(httpResponse, s3Object.getObjectMetadata());
        s3Object.setObjectContent(new S3ObjectInputStream(httpResponse.getContent()));
        parseResponseMetadata.setResult(s3Object);
        return parseResponseMetadata;
    }
}
