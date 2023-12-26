package io.ktor.client.plugins.observer;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a:\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\"\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004ø\u0001\u0000¢\u0006\u0002\u0010\b*B\u0010\t\"\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00042\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"ResponseObserver", "", "Lio/ktor/client/HttpClientConfig;", "block", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/coroutines/Continuation;", "", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function2;)V", "ResponseHandler", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ResponseObserver.kt */
public final class ResponseObserverKt {
    public static final void ResponseObserver(HttpClientConfig<?> httpClientConfig, Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(function2, "block");
        httpClientConfig.install((HttpClientPlugin<? extends TBuilder, TPlugin>) ResponseObserver.Plugin, (Function1<? super TBuilder, Unit>) new ResponseObserverKt$ResponseObserver$1(function2));
    }
}
