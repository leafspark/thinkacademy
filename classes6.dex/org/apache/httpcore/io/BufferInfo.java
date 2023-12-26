package org.apache.httpcore.io;

public interface BufferInfo {
    int available();

    int capacity();

    int length();
}
