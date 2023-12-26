package org.apache.httpcore;

import org.apache.httpcore.protocol.HttpContext;

public interface ConnectionReuseStrategy {
    boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext);
}
