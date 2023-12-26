package com.yanzhenjie.andserver.framework;

import android.util.Log;
import com.yanzhenjie.andserver.AndServer;
import com.yanzhenjie.andserver.framework.handler.RequestHandler;
import com.yanzhenjie.andserver.http.HttpMethod;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.HttpResponse;
import com.yanzhenjie.andserver.http.Modified;

public class ModifiedInterceptor implements HandlerInterceptor {
    public boolean onIntercept(HttpRequest httpRequest, HttpResponse httpResponse, RequestHandler requestHandler) {
        HttpMethod method = httpRequest.getMethod();
        if (method != HttpMethod.GET && method != HttpMethod.HEAD) {
            return false;
        }
        String str = null;
        try {
            str = requestHandler.getETag(httpRequest);
        } catch (Throwable th) {
            Log.w(AndServer.TAG, th);
        }
        long j = -1;
        try {
            j = requestHandler.getLastModified(httpRequest);
        } catch (Throwable th2) {
            Log.w(AndServer.TAG, th2);
        }
        return new Modified(httpRequest, httpResponse).process(str, j);
    }
}
