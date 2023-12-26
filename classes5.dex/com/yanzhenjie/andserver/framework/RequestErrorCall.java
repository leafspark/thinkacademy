package com.yanzhenjie.andserver.framework;

import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.HttpResponse;

public interface RequestErrorCall {
    void onRequestError(int i, HttpRequest httpRequest, HttpResponse httpResponse) throws Exception;
}
