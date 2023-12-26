package org.apache.httpcore.entity;

import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpMessage;

public interface ContentLengthStrategy {
    public static final int CHUNKED = -2;
    public static final int IDENTITY = -1;

    long determineLength(HttpMessage httpMessage) throws HttpException;
}
