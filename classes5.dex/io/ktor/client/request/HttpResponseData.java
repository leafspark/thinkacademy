package io.ktor.client.request;

import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0001\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lio/ktor/client/request/HttpResponseData;", "", "statusCode", "Lio/ktor/http/HttpStatusCode;", "requestTime", "Lio/ktor/util/date/GMTDate;", "headers", "Lio/ktor/http/Headers;", "version", "Lio/ktor/http/HttpProtocolVersion;", "body", "callContext", "Lkotlin/coroutines/CoroutineContext;", "(Lio/ktor/http/HttpStatusCode;Lio/ktor/util/date/GMTDate;Lio/ktor/http/Headers;Lio/ktor/http/HttpProtocolVersion;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "getBody", "()Ljava/lang/Object;", "getCallContext", "()Lkotlin/coroutines/CoroutineContext;", "getHeaders", "()Lio/ktor/http/Headers;", "getRequestTime", "()Lio/ktor/util/date/GMTDate;", "responseTime", "getResponseTime", "getStatusCode", "()Lio/ktor/http/HttpStatusCode;", "getVersion", "()Lio/ktor/http/HttpProtocolVersion;", "toString", "", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpRequest.kt */
public final class HttpResponseData {
    private final Object body;
    private final CoroutineContext callContext;
    private final Headers headers;
    private final GMTDate requestTime;
    private final GMTDate responseTime = DateJvmKt.GMTDate$default((Long) null, 1, (Object) null);
    private final HttpStatusCode statusCode;
    private final HttpProtocolVersion version;

    public HttpResponseData(HttpStatusCode httpStatusCode, GMTDate gMTDate, Headers headers2, HttpProtocolVersion httpProtocolVersion, Object obj, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(httpStatusCode, "statusCode");
        Intrinsics.checkNotNullParameter(gMTDate, "requestTime");
        Intrinsics.checkNotNullParameter(headers2, "headers");
        Intrinsics.checkNotNullParameter(httpProtocolVersion, "version");
        Intrinsics.checkNotNullParameter(obj, "body");
        Intrinsics.checkNotNullParameter(coroutineContext, "callContext");
        this.statusCode = httpStatusCode;
        this.requestTime = gMTDate;
        this.headers = headers2;
        this.version = httpProtocolVersion;
        this.body = obj;
        this.callContext = coroutineContext;
    }

    public final HttpStatusCode getStatusCode() {
        return this.statusCode;
    }

    public final GMTDate getRequestTime() {
        return this.requestTime;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final HttpProtocolVersion getVersion() {
        return this.version;
    }

    public final Object getBody() {
        return this.body;
    }

    public final CoroutineContext getCallContext() {
        return this.callContext;
    }

    public final GMTDate getResponseTime() {
        return this.responseTime;
    }

    public String toString() {
        return "HttpResponseData=(statusCode=" + this.statusCode + ')';
    }
}
