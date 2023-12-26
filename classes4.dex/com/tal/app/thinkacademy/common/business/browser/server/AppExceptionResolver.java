package com.tal.app.thinkacademy.common.business.browser.server;

import com.yanzhenjie.andserver.error.BasicException;
import com.yanzhenjie.andserver.framework.ExceptionResolver;
import com.yanzhenjie.andserver.framework.body.JsonBody;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.HttpResponse;

public class AppExceptionResolver implements ExceptionResolver {
    public void onResolve(HttpRequest httpRequest, HttpResponse httpResponse, Throwable th) {
        th.printStackTrace();
        if (th instanceof BasicException) {
            httpResponse.setStatus(((BasicException) th).getStatusCode());
        } else {
            httpResponse.setStatus(500);
        }
        httpResponse.setBody(new JsonBody(JsonUtils.failedJson(httpResponse.getStatus(), th.getMessage())));
    }
}
