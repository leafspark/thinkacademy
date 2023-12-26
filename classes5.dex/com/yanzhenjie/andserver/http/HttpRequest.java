package com.yanzhenjie.andserver.http;

import com.yanzhenjie.andserver.http.cookie.Cookie;
import com.yanzhenjie.andserver.http.session.Session;
import com.yanzhenjie.andserver.util.HttpHeaders;
import com.yanzhenjie.andserver.util.MediaType;
import com.yanzhenjie.andserver.util.MultiValueMap;
import java.util.List;
import java.util.Locale;

public interface HttpRequest extends HttpContext, HttpHeaders {
    public static final String SESSION_NAME = "ASESSIONID";

    String changeSessionId();

    MediaType getAccept();

    Locale getAcceptLanguage();

    List<Locale> getAcceptLanguages();

    List<MediaType> getAccepts();

    RequestBody getBody();

    long getContentLength();

    MediaType getContentType();

    HttpContext getContext();

    Cookie getCookie(String str);

    String getCookieValue(String str);

    List<Cookie> getCookies();

    long getDateHeader(String str);

    String getHeader(String str);

    List<String> getHeaderNames();

    List<String> getHeaders(String str);

    int getIntHeader(String str);

    HttpMethod getMethod();

    MultiValueMap<String, String> getParameter();

    String getParameter(String str);

    List<String> getParameterNames();

    List<String> getParameters(String str);

    String getPath();

    List<String> getQueries(String str);

    MultiValueMap<String, String> getQuery();

    String getQuery(String str);

    List<String> getQueryNames();

    RequestDispatcher getRequestDispatcher(String str);

    Session getSession();

    String getURI();

    Session getValidSession();

    boolean isSessionValid();
}
