package com.didi.hummer.utils;

import com.didi.hummer.adapter.HummerAdapter;
import com.didi.hummer.adapter.http.HttpCallback;
import com.didi.hummer.adapter.http.IHttpAdapter;
import java.lang.reflect.Type;
import java.util.Map;

public class NetworkUtil {
    public static <T> void httpGet(String str, HttpCallback<T> httpCallback) {
        httpGet(str, 10000, httpCallback);
    }

    public static <T> void httpGet(String str, int i, HttpCallback<T> httpCallback) {
        HummerAdapter.getHttpAdapter().request(str, IHttpAdapter.METHOD_GET, i, (Map<String, Object>) null, (Map<String, Object>) null, httpCallback, (Type) null);
    }

    public static <T> void httpGet(String str, HttpCallback<T> httpCallback, Type type) {
        httpGet(str, 10000, httpCallback, type);
    }

    public static <T> void httpGet(String str, int i, HttpCallback<T> httpCallback, Type type) {
        HummerAdapter.getHttpAdapter().request(str, IHttpAdapter.METHOD_GET, i, (Map<String, Object>) null, (Map<String, Object>) null, httpCallback, type);
    }
}
