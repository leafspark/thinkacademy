package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.internal.S3VersionResult;

public class S3VersionHeaderHandler<T extends S3VersionResult> implements HeaderHandler<T> {
    public void handle(T t, HttpResponse httpResponse) {
        t.setVersionId(httpResponse.getHeaders().get(Headers.S3_VERSION_ID));
    }
}
