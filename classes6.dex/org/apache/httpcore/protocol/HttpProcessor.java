package org.apache.httpcore.protocol;

import org.apache.httpcore.HttpRequestInterceptor;
import org.apache.httpcore.HttpResponseInterceptor;

public interface HttpProcessor extends HttpRequestInterceptor, HttpResponseInterceptor {
}
