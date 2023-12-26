package org.apache.httpcore.protocol;

@Deprecated
public interface HttpRequestHandlerResolver {
    HttpRequestHandler lookup(String str);
}
