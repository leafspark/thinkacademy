package com.yanzhenjie.andserver.http;

import com.yanzhenjie.andserver.http.cookie.Cookie;
import java.util.List;

public class ResponseWrapper implements HttpResponse {
    private HttpResponse mResponse;

    public ResponseWrapper(HttpResponse httpResponse) {
        this.mResponse = httpResponse;
    }

    public HttpResponse getResponse() {
        return this.mResponse;
    }

    public void setStatus(int i) {
        this.mResponse.setStatus(i);
    }

    public int getStatus() {
        return this.mResponse.getStatus();
    }

    public void setHeader(String str, String str2) {
        this.mResponse.setHeader(str, str2);
    }

    public void addHeader(String str, String str2) {
        this.mResponse.addHeader(str, str2);
    }

    public String getHeader(String str) {
        return this.mResponse.getHeader(str);
    }

    public void setDateHeader(String str, long j) {
        this.mResponse.setDateHeader(str, j);
    }

    public void addDateHeader(String str, long j) {
        this.mResponse.addDateHeader(str, j);
    }

    public void setIntHeader(String str, int i) {
        this.mResponse.setIntHeader(str, i);
    }

    public void addIntHeader(String str, int i) {
        this.mResponse.addIntHeader(str, i);
    }

    public boolean containsHeader(String str) {
        return this.mResponse.containsHeader(str);
    }

    public List<String> getHeaders(String str) {
        return this.mResponse.getHeaders(str);
    }

    public List<String> getHeaderNames() {
        return this.mResponse.getHeaderNames();
    }

    public void addCookie(Cookie cookie) {
        this.mResponse.addCookie(cookie);
    }

    public void sendRedirect(String str) {
        this.mResponse.sendRedirect(str);
    }

    public void setBody(ResponseBody responseBody) {
        this.mResponse.setBody(responseBody);
    }
}
