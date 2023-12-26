package org.apache.httpcore.io;

import org.apache.httpcore.HttpMessage;
import org.apache.httpcore.config.MessageConstraints;

public interface HttpMessageParserFactory<T extends HttpMessage> {
    HttpMessageParser<T> create(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints);
}
