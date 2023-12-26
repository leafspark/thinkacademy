package org.apache.httpcore.protocol;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.httpcore.util.Args;

public class BasicHttpContext implements HttpContext {
    private final Map<String, Object> map;
    private final HttpContext parentContext;

    public BasicHttpContext() {
        this((HttpContext) null);
    }

    public BasicHttpContext(HttpContext httpContext) {
        this.map = new ConcurrentHashMap();
        this.parentContext = httpContext;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = r2.parentContext;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getAttribute(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = "Id"
            org.apache.httpcore.util.Args.notNull(r3, r0)
            java.util.Map<java.lang.String, java.lang.Object> r0 = r2.map
            java.lang.Object r0 = r0.get(r3)
            if (r0 != 0) goto L_0x0015
            org.apache.httpcore.protocol.HttpContext r1 = r2.parentContext
            if (r1 == 0) goto L_0x0015
            java.lang.Object r0 = r1.getAttribute(r3)
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.httpcore.protocol.BasicHttpContext.getAttribute(java.lang.String):java.lang.Object");
    }

    public void setAttribute(String str, Object obj) {
        Args.notNull(str, "Id");
        if (obj != null) {
            this.map.put(str, obj);
        } else {
            this.map.remove(str);
        }
    }

    public Object removeAttribute(String str) {
        Args.notNull(str, "Id");
        return this.map.remove(str);
    }

    public void clear() {
        this.map.clear();
    }

    public String toString() {
        return this.map.toString();
    }
}
