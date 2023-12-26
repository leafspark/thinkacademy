package io.ktor.client.engine;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0016¨\u0006\b"}, d2 = {"io/ktor/client/engine/HttpClientEngineKt$config$1", "Lio/ktor/client/engine/HttpClientEngineFactory;", "create", "Lio/ktor/client/engine/HttpClientEngine;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpClientEngine.kt */
public final class HttpClientEngineKt$config$1 implements HttpClientEngineFactory<T> {
    final /* synthetic */ Function1<T, Unit> $nested;
    final /* synthetic */ HttpClientEngineFactory<T> $parent;

    HttpClientEngineKt$config$1(HttpClientEngineFactory<? extends T> httpClientEngineFactory, Function1<? super T, Unit> function1) {
        this.$parent = httpClientEngineFactory;
        this.$nested = function1;
    }

    public HttpClientEngine create(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        return this.$parent.create(new HttpClientEngineKt$config$1$create$1(this.$nested, function1));
    }
}
