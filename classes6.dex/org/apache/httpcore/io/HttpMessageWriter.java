package org.apache.httpcore.io;

import java.io.IOException;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpMessage;

public interface HttpMessageWriter<T extends HttpMessage> {
    void write(T t) throws IOException, HttpException;
}
