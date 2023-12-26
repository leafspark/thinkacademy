package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.request.HttpRequestBuilder;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/HttpRequestRetry$ShouldRetryContext;", "<anonymous parameter 0>", "Lio/ktor/client/request/HttpRequestBuilder;", "cause", "", "invoke", "(Lio/ktor/client/plugins/HttpRequestRetry$ShouldRetryContext;Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/Throwable;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpRequestRetry.kt */
final class HttpRequestRetry$Configuration$retryOnException$1 extends Lambda implements Function3<HttpRequestRetry.ShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> {
    public static final HttpRequestRetry$Configuration$retryOnException$1 INSTANCE = new HttpRequestRetry$Configuration$retryOnException$1();

    HttpRequestRetry$Configuration$retryOnException$1() {
        super(3);
    }

    public final Boolean invoke(HttpRequestRetry.ShouldRetryContext shouldRetryContext, HttpRequestBuilder httpRequestBuilder, Throwable th) {
        Intrinsics.checkNotNullParameter(shouldRetryContext, "$this$retryOnExceptionIf");
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(th, "cause");
        return Boolean.valueOf(!(th instanceof CancellationException));
    }
}
