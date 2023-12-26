package com.eaydu.omni.utils;

import com.eaydu.omni.net.okhttp3.OkHttpClient;
import java.util.concurrent.TimeUnit;

public class HttpUtils {
    private static OkHttpClient sHttpClient;
    private static Object sHttpClientLock = new Object();

    public static OkHttpClient getHttpClient() {
        if (sHttpClient == null) {
            synchronized (sHttpClientLock) {
                if (sHttpClient == null) {
                    OkHttpClient build = new OkHttpClient().newBuilder().pingInterval(20000, TimeUnit.SECONDS).connectTimeout(5000, TimeUnit.SECONDS).retryOnConnectionFailure(true).build();
                    sHttpClient = build;
                    build.dispatcher().setMaxRequestsPerHost(2);
                }
            }
        }
        return sHttpClient;
    }
}
