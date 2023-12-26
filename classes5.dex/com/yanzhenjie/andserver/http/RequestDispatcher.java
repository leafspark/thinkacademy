package com.yanzhenjie.andserver.http;

public interface RequestDispatcher {
    void forward(HttpRequest httpRequest, HttpResponse httpResponse);
}
