package io.ktor.client.engine.okhttp;

import io.ktor.client.request.HttpRequestData;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpCallback;", "Lokhttp3/Callback;", "requestData", "Lio/ktor/client/request/HttpRequestData;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Lokhttp3/Response;", "(Lio/ktor/client/request/HttpRequestData;Lkotlinx/coroutines/CancellableContinuation;)V", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "ktor-client-okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkUtils.kt */
final class OkHttpCallback implements Callback {
    private final CancellableContinuation<Response> continuation;
    private final HttpRequestData requestData;

    public OkHttpCallback(HttpRequestData httpRequestData, CancellableContinuation<? super Response> cancellableContinuation) {
        Intrinsics.checkNotNullParameter(httpRequestData, "requestData");
        Intrinsics.checkNotNullParameter(cancellableContinuation, "continuation");
        this.requestData = httpRequestData;
        this.continuation = cancellableContinuation;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(iOException, "e");
        if (!this.continuation.isCancelled()) {
            Result.Companion companion = Result.Companion;
            this.continuation.resumeWith(Result.m320constructorimpl(ResultKt.createFailure(OkUtilsKt.mapOkHttpException(this.requestData, iOException))));
        }
    }

    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (!call.isCanceled()) {
            Result.Companion companion = Result.Companion;
            this.continuation.resumeWith(Result.m320constructorimpl(response));
        }
    }
}
