package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.AttributeKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0014\u001a\u00020\u0007*\u00020\u00062\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u0016¢\u0006\u0002\b\b\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"+\u0010\u0003\u001a\u001f\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\b\b0\u0001X\u0004¢\u0006\u0002\n\u0000\"+\u0010\t\u001a\u001f\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0002\b\b0\u0001X\u0004¢\u0006\u0002\n\u0000\"1\u0010\f\u001a%\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r¢\u0006\u0002\b\b0\u0001X\u0004¢\u0006\u0002\n\u0000\"1\u0010\u0011\u001a%\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00100\r¢\u0006\u0002\b\b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"MaxRetriesPerRequestAttributeKey", "Lio/ktor/util/AttributeKey;", "", "ModifyRequestPerRequestAttributeKey", "Lkotlin/Function2;", "Lio/ktor/client/plugins/HttpRequestRetry$ModifyRequestContext;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "Lkotlin/ExtensionFunctionType;", "RetryDelayPerRequestAttributeKey", "Lio/ktor/client/plugins/HttpRequestRetry$DelayContext;", "", "ShouldRetryOnExceptionPerRequestAttributeKey", "Lkotlin/Function3;", "Lio/ktor/client/plugins/HttpRequestRetry$ShouldRetryContext;", "", "", "ShouldRetryPerRequestAttributeKey", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/statement/HttpResponse;", "retry", "block", "Lkotlin/Function1;", "Lio/ktor/client/plugins/HttpRequestRetry$Configuration;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpRequestRetry.kt */
public final class HttpRequestRetryKt {
    /* access modifiers changed from: private */
    public static final AttributeKey<Integer> MaxRetriesPerRequestAttributeKey = new AttributeKey<>("MaxRetriesPerRequestAttributeKey");
    /* access modifiers changed from: private */
    public static final AttributeKey<Function2<HttpRequestRetry.ModifyRequestContext, HttpRequestBuilder, Unit>> ModifyRequestPerRequestAttributeKey = new AttributeKey<>("ModifyRequestPerRequestAttributeKey");
    /* access modifiers changed from: private */
    public static final AttributeKey<Function2<HttpRequestRetry.DelayContext, Integer, Long>> RetryDelayPerRequestAttributeKey = new AttributeKey<>("RetryDelayPerRequestAttributeKey");
    /* access modifiers changed from: private */
    public static final AttributeKey<Function3<HttpRequestRetry.ShouldRetryContext, HttpRequestBuilder, Throwable, Boolean>> ShouldRetryOnExceptionPerRequestAttributeKey = new AttributeKey<>("ShouldRetryOnExceptionPerRequestAttributeKey");
    /* access modifiers changed from: private */
    public static final AttributeKey<Function3<HttpRequestRetry.ShouldRetryContext, HttpRequest, HttpResponse, Boolean>> ShouldRetryPerRequestAttributeKey = new AttributeKey<>("ShouldRetryPerRequestAttributeKey");

    public static final void retry(HttpRequestBuilder httpRequestBuilder, Function1<? super HttpRequestRetry.Configuration, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        HttpRequestRetry.Configuration configuration = new HttpRequestRetry.Configuration();
        function1.invoke(configuration);
        httpRequestBuilder.getAttributes().put(ShouldRetryPerRequestAttributeKey, configuration.getShouldRetry$ktor_client_core());
        httpRequestBuilder.getAttributes().put(ShouldRetryOnExceptionPerRequestAttributeKey, configuration.getShouldRetryOnException$ktor_client_core());
        httpRequestBuilder.getAttributes().put(RetryDelayPerRequestAttributeKey, configuration.getDelayMillis$ktor_client_core());
        httpRequestBuilder.getAttributes().put(MaxRetriesPerRequestAttributeKey, Integer.valueOf(configuration.getMaxRetries()));
        httpRequestBuilder.getAttributes().put(ModifyRequestPerRequestAttributeKey, configuration.getModifyRequest$ktor_client_core());
    }
}
