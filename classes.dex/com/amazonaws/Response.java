package com.amazonaws;

import com.amazonaws.http.HttpResponse;

public final class Response<T> {
    private final HttpResponse httpResponse;
    private final T response;

    public Response(T t, HttpResponse httpResponse2) {
        this.response = t;
        this.httpResponse = httpResponse2;
    }

    public T getAwsResponse() {
        return this.response;
    }

    public HttpResponse getHttpResponse() {
        return this.httpResponse;
    }
}
