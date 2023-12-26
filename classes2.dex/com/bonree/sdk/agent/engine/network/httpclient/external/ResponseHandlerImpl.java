package com.bonree.sdk.agent.engine.network.httpclient.external;

import com.bonree.sdk.n.b;
import com.bonree.sdk.o.a;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.protocol.HttpContext;

public final class ResponseHandlerImpl<T> implements ResponseHandler<T> {
    private final ResponseHandler<T> a;
    private final b b;

    private ResponseHandlerImpl(ResponseHandler<T> responseHandler, b bVar) {
        this.a = responseHandler;
        this.b = bVar;
    }

    public final T handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
        a.a(this.b, httpResponse, (HttpContext) null);
        return this.a.handleResponse(httpResponse);
    }

    public static <T> ResponseHandler<? extends T> wrap(ResponseHandler<? extends T> responseHandler, b bVar) {
        return new ResponseHandlerImpl(responseHandler, bVar);
    }
}
