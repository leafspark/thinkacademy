package com.eaydu.omni.net.okhttp3.internal.cache;

import com.eaydu.omni.net.okio.Sink;
import java.io.IOException;

public interface CacheRequest {
    void abort();

    Sink body() throws IOException;
}
