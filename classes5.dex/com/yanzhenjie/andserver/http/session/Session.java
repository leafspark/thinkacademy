package com.yanzhenjie.andserver.http.session;

import java.util.Enumeration;

public interface Session {
    Object getAttribute(String str);

    Enumeration<String> getAttributeNames();

    long getCreatedTime();

    String getId();

    long getLastAccessedTime();

    int getMaxInactiveInterval();

    void invalidate();

    boolean isNew();

    boolean isValid();

    void removeAttribute(String str);

    void setAttribute(String str, Object obj);

    void setMaxInactiveInterval(int i);
}
