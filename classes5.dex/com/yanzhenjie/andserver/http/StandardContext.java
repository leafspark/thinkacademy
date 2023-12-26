package com.yanzhenjie.andserver.http;

import org.apache.httpcore.protocol.HttpContext;

public class StandardContext implements HttpContext {
    private HttpContext mContext;

    public StandardContext(HttpContext httpContext) {
        this.mContext = httpContext;
    }

    public Object getAttribute(String str) {
        return this.mContext.getAttribute(str);
    }

    public void setAttribute(String str, Object obj) {
        this.mContext.setAttribute(str, obj);
    }

    public Object removeAttribute(String str) {
        return this.mContext.removeAttribute(str);
    }
}
