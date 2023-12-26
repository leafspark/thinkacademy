package io.ktor.client.plugins.observer;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.InternalAPI;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lio/ktor/client/plugins/observer/DelegatedResponse;", "Lio/ktor/client/statement/HttpResponse;", "call", "Lio/ktor/client/call/HttpClientCall;", "content", "Lio/ktor/utils/io/ByteReadChannel;", "origin", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/client/statement/HttpResponse;)V", "getCall", "()Lio/ktor/client/call/HttpClientCall;", "getContent", "()Lio/ktor/utils/io/ByteReadChannel;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "headers", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "requestTime", "Lio/ktor/util/date/GMTDate;", "getRequestTime", "()Lio/ktor/util/date/GMTDate;", "responseTime", "getResponseTime", "status", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "version", "Lio/ktor/http/HttpProtocolVersion;", "getVersion", "()Lio/ktor/http/HttpProtocolVersion;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@InternalAPI
/* compiled from: DelegatedCall.kt */
public final class DelegatedResponse extends HttpResponse {
    private final HttpClientCall call;
    private final ByteReadChannel content;
    private final CoroutineContext coroutineContext;
    private final HttpResponse origin;

    public HttpClientCall getCall() {
        return this.call;
    }

    public ByteReadChannel getContent() {
        return this.content;
    }

    public DelegatedResponse(HttpClientCall httpClientCall, ByteReadChannel byteReadChannel, HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpClientCall, "call");
        Intrinsics.checkNotNullParameter(byteReadChannel, "content");
        Intrinsics.checkNotNullParameter(httpResponse, "origin");
        this.call = httpClientCall;
        this.content = byteReadChannel;
        this.origin = httpResponse;
        this.coroutineContext = httpResponse.getCoroutineContext();
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public HttpStatusCode getStatus() {
        return this.origin.getStatus();
    }

    public HttpProtocolVersion getVersion() {
        return this.origin.getVersion();
    }

    public GMTDate getRequestTime() {
        return this.origin.getRequestTime();
    }

    public GMTDate getResponseTime() {
        return this.origin.getResponseTime();
    }

    public Headers getHeaders() {
        return this.origin.getHeaders();
    }
}
