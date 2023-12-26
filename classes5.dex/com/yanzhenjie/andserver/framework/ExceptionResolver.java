package com.yanzhenjie.andserver.framework;

import com.yanzhenjie.andserver.error.BasicException;
import com.yanzhenjie.andserver.framework.body.StringBody;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.HttpResponse;

public interface ExceptionResolver {
    public static final ExceptionResolver DEFAULT = new ExceptionResolver() {
        public void onResolve(HttpRequest httpRequest, HttpResponse httpResponse, Throwable th) {
            if (th instanceof BasicException) {
                httpResponse.setStatus(((BasicException) th).getStatusCode());
            } else {
                httpResponse.setStatus(500);
            }
            httpResponse.setBody(new StringBody(th.getMessage()));
        }
    };

    void onResolve(HttpRequest httpRequest, HttpResponse httpResponse, Throwable th);
}
