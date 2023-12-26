package com.yanzhenjie.andserver.framework;

import com.yanzhenjie.andserver.framework.handler.RequestHandler;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.HttpResponse;

public interface HandlerInterceptor {
    boolean onIntercept(HttpRequest httpRequest, HttpResponse httpResponse, RequestHandler requestHandler) throws Exception;
}
