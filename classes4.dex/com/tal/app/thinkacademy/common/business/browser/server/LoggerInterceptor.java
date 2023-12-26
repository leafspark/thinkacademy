package com.tal.app.thinkacademy.common.business.browser.server;

import com.yanzhenjie.andserver.framework.HandlerInterceptor;
import com.yanzhenjie.andserver.framework.handler.RequestHandler;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.HttpResponse;

public class LoggerInterceptor implements HandlerInterceptor {
    public boolean onIntercept(HttpRequest httpRequest, HttpResponse httpResponse, RequestHandler requestHandler) {
        httpRequest.getPath();
        httpRequest.getMethod();
        httpRequest.getParameter();
        return false;
    }
}
