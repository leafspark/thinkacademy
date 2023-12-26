package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.util.TimingInfo;

@Deprecated
public abstract class AbstractRequestHandler implements RequestHandler {
    public void afterError(Request<?> request, Exception exc) {
    }

    public void afterResponse(Request<?> request, Object obj, TimingInfo timingInfo) {
    }

    public void beforeRequest(Request<?> request) {
    }
}
