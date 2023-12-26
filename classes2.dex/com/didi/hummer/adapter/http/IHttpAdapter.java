package com.didi.hummer.adapter.http;

import java.lang.reflect.Type;
import java.util.Map;

public interface IHttpAdapter {
    public static final String METHOD_CONNECT = "CONNECT";
    public static final String METHOD_DELETE = "DELETE";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_OPTIONS = "OPTIONS";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    public static final String METHOD_TRACE = "TRACE";

    String onUrlIntercept(String str);

    <T> void request(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, HttpCallback<T> httpCallback, Type type);
}
