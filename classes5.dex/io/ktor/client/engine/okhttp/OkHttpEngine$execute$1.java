package io.ktor.client.engine.okhttp;

import io.ktor.client.request.HttpRequestData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", i = {0, 0}, l = {71, 78, 80}, m = "execute", n = {"this", "data"}, s = {"L$0", "L$1"})
/* compiled from: OkHttpEngine.kt */
final class OkHttpEngine$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OkHttpEngine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkHttpEngine$execute$1(OkHttpEngine okHttpEngine, Continuation<? super OkHttpEngine$execute$1> continuation) {
        super(continuation);
        this.this$0 = okHttpEngine;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute((HttpRequestData) null, (Continuation) this);
    }
}
