package org.apache.httpcore;

public interface HttpRequest extends HttpMessage {
    RequestLine getRequestLine();
}
