package io.ktor.client.call;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lio/ktor/client/call/SavedHttpCall;", "Lio/ktor/client/call/HttpClientCall;", "client", "Lio/ktor/client/HttpClient;", "request", "Lio/ktor/client/request/HttpRequest;", "response", "Lio/ktor/client/statement/HttpResponse;", "responseBody", "", "(Lio/ktor/client/HttpClient;Lio/ktor/client/request/HttpRequest;Lio/ktor/client/statement/HttpResponse;[B)V", "allowDoubleReceive", "", "getAllowDoubleReceive", "()Z", "getResponseContent", "Lio/ktor/utils/io/ByteReadChannel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SavedCall.kt */
public final class SavedHttpCall extends HttpClientCall {
    private final boolean allowDoubleReceive = true;
    private final byte[] responseBody;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SavedHttpCall(HttpClient httpClient, HttpRequest httpRequest, HttpResponse httpResponse, byte[] bArr) {
        super(httpClient);
        Intrinsics.checkNotNullParameter(httpClient, "client");
        Intrinsics.checkNotNullParameter(httpRequest, "request");
        Intrinsics.checkNotNullParameter(httpResponse, "response");
        Intrinsics.checkNotNullParameter(bArr, "responseBody");
        this.responseBody = bArr;
        setRequest(new SavedHttpRequest(this, httpRequest));
        setResponse(new SavedHttpResponse(this, bArr, httpResponse));
    }

    /* access modifiers changed from: protected */
    public Object getResponseContent(Continuation<? super ByteReadChannel> continuation) {
        return ByteChannelCtorKt.ByteReadChannel(this.responseBody);
    }

    /* access modifiers changed from: protected */
    public boolean getAllowDoubleReceive() {
        return this.allowDoubleReceive;
    }
}
