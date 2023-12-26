package org.apache.httpcore.io;

public interface HttpTransportMetrics {
    long getBytesTransferred();

    void reset();
}
