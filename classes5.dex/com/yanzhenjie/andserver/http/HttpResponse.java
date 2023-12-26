package com.yanzhenjie.andserver.http;

import com.yanzhenjie.andserver.http.cookie.Cookie;
import com.yanzhenjie.andserver.util.HttpHeaders;
import com.yanzhenjie.andserver.util.StatusCode;
import java.util.List;

public interface HttpResponse extends StatusCode, HttpHeaders {
    void addCookie(Cookie cookie);

    void addDateHeader(String str, long j);

    void addHeader(String str, String str2);

    void addIntHeader(String str, int i);

    boolean containsHeader(String str);

    String getHeader(String str);

    List<String> getHeaderNames();

    List<String> getHeaders(String str);

    int getStatus();

    void sendRedirect(String str);

    void setBody(ResponseBody responseBody);

    void setDateHeader(String str, long j);

    void setHeader(String str, String str2);

    void setIntHeader(String str, int i);

    void setStatus(int i);
}
