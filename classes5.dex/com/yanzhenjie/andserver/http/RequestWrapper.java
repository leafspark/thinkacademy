package com.yanzhenjie.andserver.http;

import com.yanzhenjie.andserver.http.cookie.Cookie;
import com.yanzhenjie.andserver.http.session.Session;
import com.yanzhenjie.andserver.util.MediaType;
import com.yanzhenjie.andserver.util.MultiValueMap;
import java.util.List;
import java.util.Locale;

public class RequestWrapper implements HttpRequest {
    private HttpRequest mRequest;

    public RequestWrapper(HttpRequest httpRequest) {
        this.mRequest = httpRequest;
    }

    public HttpRequest getRequest() {
        return this.mRequest;
    }

    public HttpMethod getMethod() {
        return this.mRequest.getMethod();
    }

    public String getURI() {
        return this.mRequest.getURI();
    }

    public String getPath() {
        return this.mRequest.getPath();
    }

    public List<String> getQueryNames() {
        return this.mRequest.getQueryNames();
    }

    public String getQuery(String str) {
        return this.mRequest.getQuery(str);
    }

    public List<String> getQueries(String str) {
        return this.mRequest.getQueries(str);
    }

    public MultiValueMap<String, String> getQuery() {
        return this.mRequest.getQuery();
    }

    public List<String> getHeaderNames() {
        return this.mRequest.getHeaderNames();
    }

    public String getHeader(String str) {
        return this.mRequest.getHeader(str);
    }

    public List<String> getHeaders(String str) {
        return this.mRequest.getHeaders(str);
    }

    public long getDateHeader(String str) {
        return this.mRequest.getDateHeader(str);
    }

    public int getIntHeader(String str) {
        return this.mRequest.getIntHeader(str);
    }

    public MediaType getAccept() {
        return this.mRequest.getAccept();
    }

    public List<MediaType> getAccepts() {
        return this.mRequest.getAccepts();
    }

    public Locale getAcceptLanguage() {
        return this.mRequest.getAcceptLanguage();
    }

    public List<Locale> getAcceptLanguages() {
        return this.mRequest.getAcceptLanguages();
    }

    public String getCookieValue(String str) {
        return this.mRequest.getCookieValue(str);
    }

    public Cookie getCookie(String str) {
        return this.mRequest.getCookie(str);
    }

    public List<Cookie> getCookies() {
        return this.mRequest.getCookies();
    }

    public long getContentLength() {
        return this.mRequest.getContentLength();
    }

    public MediaType getContentType() {
        return this.mRequest.getContentType();
    }

    public List<String> getParameterNames() {
        return this.mRequest.getParameterNames();
    }

    public String getParameter(String str) {
        return this.mRequest.getParameter(str);
    }

    public List<String> getParameters(String str) {
        return this.mRequest.getParameters(str);
    }

    public MultiValueMap<String, String> getParameter() {
        return this.mRequest.getParameter();
    }

    public RequestBody getBody() throws UnsupportedOperationException {
        return this.mRequest.getBody();
    }

    public Session getValidSession() {
        return this.mRequest.getValidSession();
    }

    public Session getSession() {
        return this.mRequest.getSession();
    }

    public String changeSessionId() {
        return this.mRequest.changeSessionId();
    }

    public boolean isSessionValid() {
        return this.mRequest.isSessionValid();
    }

    public RequestDispatcher getRequestDispatcher(String str) {
        return this.mRequest.getRequestDispatcher(str);
    }

    public HttpContext getContext() {
        return this.mRequest.getContext();
    }

    public Object getAttribute(String str) {
        return this.mRequest.getAttribute(str);
    }

    public void setAttribute(String str, Object obj) {
        this.mRequest.setAttribute(str, obj);
    }

    public Object removeAttribute(String str) {
        return this.mRequest.removeAttribute(str);
    }
}
