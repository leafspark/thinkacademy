package org.apache.httpcore.io;

import org.apache.httpcore.HttpMessage;

public interface HttpMessageWriterFactory<T extends HttpMessage> {
    HttpMessageWriter<T> create(SessionOutputBuffer sessionOutputBuffer);
}
