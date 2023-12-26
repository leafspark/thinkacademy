package org.apache.httpcore;

import java.io.IOException;
import org.apache.httpcore.protocol.HttpContext;

public interface HttpResponseInterceptor {
    void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException;
}
