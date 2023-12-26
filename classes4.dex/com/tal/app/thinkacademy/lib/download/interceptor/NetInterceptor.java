package com.tal.app.thinkacademy.lib.download.interceptor;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

public class NetInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().addHeader("Connection", "close").build());
    }
}
