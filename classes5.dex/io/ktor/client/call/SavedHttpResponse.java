package io.ktor.client.call;

import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lio/ktor/client/call/SavedHttpResponse;", "Lio/ktor/client/statement/HttpResponse;", "call", "Lio/ktor/client/call/SavedHttpCall;", "body", "", "origin", "(Lio/ktor/client/call/SavedHttpCall;[BLio/ktor/client/statement/HttpResponse;)V", "getCall", "()Lio/ktor/client/call/SavedHttpCall;", "content", "Lio/ktor/utils/io/ByteReadChannel;", "getContent$annotations", "()V", "getContent", "()Lio/ktor/utils/io/ByteReadChannel;", "context", "Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "headers", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "requestTime", "Lio/ktor/util/date/GMTDate;", "getRequestTime", "()Lio/ktor/util/date/GMTDate;", "responseTime", "getResponseTime", "status", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "version", "Lio/ktor/http/HttpProtocolVersion;", "getVersion", "()Lio/ktor/http/HttpProtocolVersion;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SavedCall.kt */
public final class SavedHttpResponse extends HttpResponse {
    private final SavedHttpCall call;
    private final ByteReadChannel content;
    private final CompletableJob context;
    private final CoroutineContext coroutineContext;
    private final Headers headers;
    private final GMTDate requestTime;
    private final GMTDate responseTime;
    private final HttpStatusCode status;
    private final HttpProtocolVersion version;

    public static /* synthetic */ void getContent$annotations() {
    }

    public SavedHttpCall getCall() {
        return this.call;
    }

    public SavedHttpResponse(SavedHttpCall savedHttpCall, byte[] bArr, HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(savedHttpCall, "call");
        Intrinsics.checkNotNullParameter(bArr, "body");
        Intrinsics.checkNotNullParameter(httpResponse, "origin");
        this.call = savedHttpCall;
        CoroutineContext Job$default = JobKt.Job$default((Job) null, 1, (Object) null);
        this.context = Job$default;
        this.status = httpResponse.getStatus();
        this.version = httpResponse.getVersion();
        this.requestTime = httpResponse.getRequestTime();
        this.responseTime = httpResponse.getResponseTime();
        this.headers = httpResponse.getHeaders();
        this.coroutineContext = httpResponse.getCoroutineContext().plus(Job$default);
        this.content = ByteChannelCtorKt.ByteReadChannel(bArr);
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

    public Headers getHeaders() {
        return this.headers;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public ByteReadChannel getContent() {
        return this.content;
    }
}
