package io.ktor.client.engine.okhttp;

import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\u0016¨\u0006\n"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttp;", "Lio/ktor/client/engine/HttpClientEngineFactory;", "Lio/ktor/client/engine/okhttp/OkHttpConfig;", "()V", "create", "Lio/ktor/client/engine/HttpClientEngine;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "ktor-client-okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttp.kt */
public final class OkHttp implements HttpClientEngineFactory<OkHttpConfig> {
    public static final OkHttp INSTANCE = new OkHttp();

    private OkHttp() {
    }

    public HttpClientEngine create(Function1<? super OkHttpConfig, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        OkHttpConfig okHttpConfig = new OkHttpConfig();
        function1.invoke(okHttpConfig);
        return new OkHttpEngine(okHttpConfig);
    }
}
