package com.yanzhenjie.andserver.http;

public interface HttpContext {
    public static final String ANDROID_CONTEXT = "android.context";
    public static final String HTTP_MESSAGE_CONVERTER = "http.message.converter";
    public static final String REQUEST_CREATED_SESSION = "http.request.Session";
    public static final String RESPONSE_PRODUCE_TYPE = "http.response.Produce";

    Object getAttribute(String str);

    Object removeAttribute(String str);

    void setAttribute(String str, Object obj);
}
