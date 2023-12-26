package io.ktor.client.plugins.websocket;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.websocket.BuildersKt", f = "builders.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4}, l = {241, 244, 101, 103, 103, 250, 250}, m = "webSocket", n = {"block", "this_$iv", "block", "this_$iv", "response$iv", "this_$iv", "response$iv", "it", "this_$iv", "response$iv", "this_$iv", "response$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1"})
/* compiled from: builders.kt */
final class BuildersKt$webSocket$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    BuildersKt$webSocket$1(Continuation<? super BuildersKt$webSocket$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return BuildersKt.webSocket((HttpClient) null, (Function1<? super HttpRequestBuilder, Unit>) null, (Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object>) null, (Continuation) this);
    }
}
