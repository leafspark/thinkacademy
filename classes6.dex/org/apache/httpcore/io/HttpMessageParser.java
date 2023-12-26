package org.apache.httpcore.io;

import java.io.IOException;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpMessage;

public interface HttpMessageParser<T extends HttpMessage> {
    T parse() throws IOException, HttpException;
}
