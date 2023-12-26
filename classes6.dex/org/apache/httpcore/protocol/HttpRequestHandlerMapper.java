package org.apache.httpcore.protocol;

import org.apache.httpcore.HttpRequest;

public interface HttpRequestHandlerMapper {
    HttpRequestHandler lookup(HttpRequest httpRequest);
}
