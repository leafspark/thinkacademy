package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpResponseData;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.InternalAPI;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lio/ktor/client/statement/DefaultHttpResponse;", "Lio/ktor/client/statement/HttpResponse;", "call", "Lio/ktor/client/call/HttpClientCall;", "responseData", "Lio/ktor/client/request/HttpResponseData;", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/client/request/HttpResponseData;)V", "getCall", "()Lio/ktor/client/call/HttpClientCall;", "content", "Lio/ktor/utils/io/ByteReadChannel;", "getContent", "()Lio/ktor/utils/io/ByteReadChannel;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "headers", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "requestTime", "Lio/ktor/util/date/GMTDate;", "getRequestTime", "()Lio/ktor/util/date/GMTDate;", "responseTime", "getResponseTime", "status", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "version", "Lio/ktor/http/HttpProtocolVersion;", "getVersion", "()Lio/ktor/http/HttpProtocolVersion;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@InternalAPI
/* compiled from: DefaultHttpResponse.kt */
public final class DefaultHttpResponse extends HttpResponse {
    private final HttpClientCall call;
    private final ByteReadChannel content;
    private final CoroutineContext coroutineContext;
    private final Headers headers;
    private final GMTDate requestTime;
    private final GMTDate responseTime;
    private final HttpStatusCode status;
    private final HttpProtocolVersion version;

    public HttpClientCall getCall() {
        return this.call;
    }

    public DefaultHttpResponse(HttpClientCall httpClientCall, HttpResponseData httpResponseData) {
        Intrinsics.checkNotNullParameter(httpClientCall, "call");
        Intrinsics.checkNotNullParameter(httpResponseData, "responseData");
        this.call = httpClientCall;
        this.coroutineContext = httpResponseData.getCallContext();
        this.status = httpResponseData.getStatusCode();
        this.version = httpResponseData.getVersion();
        this.requestTime = httpResponseData.getRequestTime();
        this.responseTime = httpResponseData.getResponseTime();
        Object body = httpResponseData.getBody();
        ByteReadChannel byteReadChannel = body instanceof ByteReadChannel ? (ByteReadChannel) body : null;
        this.content = byteReadChannel == null ? ByteReadChannel.Companion.getEmpty() : byteReadChannel;
        this.headers = httpResponseData.getHeaders();
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public HttpStatusCode getStatus() {
        return this.status;
    }

    public HttpProtocolVersion getVersion() {
        return this.version;
    }

    public GMTDate getRequestTime() {
        return this.requestTime;
    }

    public GMTDate getResponseTime() {
        return this.responseTime;
    }

    public ByteReadChannel getContent() {
        return this.content;
    }

    public Headers getHeaders() {
        return this.headers;
    }
}
