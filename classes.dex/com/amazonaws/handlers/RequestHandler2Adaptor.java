package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.TimingInfo;

final class RequestHandler2Adaptor extends RequestHandler2 {
    private final RequestHandler old;

    RequestHandler2Adaptor(RequestHandler requestHandler) {
        if (requestHandler != null) {
            this.old = requestHandler;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void beforeRequest(Request<?> request) {
        this.old.beforeRequest(request);
    }

    public void afterResponse(Request<?> request, Response<?> response) {
        Object obj;
        TimingInfo timingInfo = null;
        AWSRequestMetrics aWSRequestMetrics = request == null ? null : request.getAWSRequestMetrics();
        if (response == null) {
            obj = null;
        } else {
            obj = response.getAwsResponse();
        }
        if (aWSRequestMetrics != null) {
            timingInfo = aWSRequestMetrics.getTimingInfo();
        }
        this.old.afterResponse(request, obj, timingInfo);
    }

    public void afterError(Request<?> request, Response<?> response, Exception exc) {
        this.old.afterError(request, exc);
    }

    public int hashCode() {
        return this.old.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RequestHandler2Adaptor)) {
            return false;
        }
        return this.old.equals(((RequestHandler2Adaptor) obj).old);
    }
}
