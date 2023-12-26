package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.HttpCallValidator;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.AttributeKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\r\u001a\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u000f\u001a'\u0010\u0010\u001a\u00020\u0011*\u0006\u0012\u0002\b\u00030\u00122\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00110\u0014¢\u0006\u0002\b\u0016\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"(\u0010\u0006\u001a\u00020\u0002*\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00028F@FX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b*`\u0010\u0017\"-\b\u0001\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u00182-\b\u0001\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0018*\u0001\u0010\u001f\"B\b\u0001\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110!¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0 2B\b\u0001\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110!¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0 *`\u0010#\"-\b\u0001\u0012\u0013\u0012\u00110$¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u00182-\b\u0001\u0012\u0013\u0012\u00110$¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0018¨\u0006&"}, d2 = {"ExpectSuccessAttributeKey", "Lio/ktor/util/AttributeKey;", "", "getExpectSuccessAttributeKey", "()Lio/ktor/util/AttributeKey;", "value", "expectSuccess", "Lio/ktor/client/request/HttpRequestBuilder;", "getExpectSuccess", "(Lio/ktor/client/request/HttpRequestBuilder;)Z", "setExpectSuccess", "(Lio/ktor/client/request/HttpRequestBuilder;Z)V", "HttpRequest", "io/ktor/client/plugins/HttpCallValidatorKt$HttpRequest$1", "builder", "(Lio/ktor/client/request/HttpRequestBuilder;)Lio/ktor/client/plugins/HttpCallValidatorKt$HttpRequest$1;", "HttpResponseValidator", "", "Lio/ktor/client/HttpClientConfig;", "block", "Lkotlin/Function1;", "Lio/ktor/client/plugins/HttpCallValidator$Config;", "Lkotlin/ExtensionFunctionType;", "CallExceptionHandler", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/Continuation;", "", "CallRequestExceptionHandler", "Lkotlin/Function3;", "Lio/ktor/client/request/HttpRequest;", "request", "ResponseValidator", "Lio/ktor/client/statement/HttpResponse;", "response", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpCallValidator.kt */
public final class HttpCallValidatorKt {
    private static final AttributeKey<Boolean> ExpectSuccessAttributeKey = new AttributeKey<>("ExpectSuccessAttributeKey");

    /* access modifiers changed from: private */
    public static final HttpCallValidatorKt$HttpRequest$1 HttpRequest(HttpRequestBuilder httpRequestBuilder) {
        return new HttpCallValidatorKt$HttpRequest$1(httpRequestBuilder);
    }

    public static final void HttpResponseValidator(HttpClientConfig<?> httpClientConfig, Function1<? super HttpCallValidator.Config, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        httpClientConfig.install((HttpClientPlugin<? extends TBuilder, TPlugin>) HttpCallValidator.Companion, (Function1<? super TBuilder, Unit>) function1);
    }

    public static final boolean getExpectSuccess(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Boolean bool = (Boolean) httpRequestBuilder.getAttributes().getOrNull(ExpectSuccessAttributeKey);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public static final void setExpectSuccess(HttpRequestBuilder httpRequestBuilder, boolean z) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        httpRequestBuilder.getAttributes().put(ExpectSuccessAttributeKey, Boolean.valueOf(z));
    }

    public static final AttributeKey<Boolean> getExpectSuccessAttributeKey() {
        return ExpectSuccessAttributeKey;
    }
}
