package com.eaydu.omni.net.okhttp3.internal.http;

import com.eaydu.omni.net.okhttp3.Request;
import com.eaydu.omni.net.okhttp3.Response;
import com.eaydu.omni.net.okhttp3.ResponseBody;
import com.eaydu.omni.net.okio.Sink;
import java.io.IOException;

public interface HttpCodec {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void cancel();

    Sink createRequestBody(Request request, long j);

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    ResponseBody openResponseBody(Response response) throws IOException;

    Response.Builder readResponseHeaders(boolean z) throws IOException;

    void writeRequestHeaders(Request request) throws IOException;
}
