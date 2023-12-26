package com.didi.hummer.adapter.http;

public interface HttpCallback<T> {
    void onResult(HttpResponse<T> httpResponse);
}
