package com.tal.thinkacademy.networkprobe.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.thinkacademy.networkprobe.cache.TraceEventCache", f = "TraceEventCache.kt", i = {0, 0, 0}, l = {57}, m = "save", n = {"id", "trace", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: TraceEventCache.kt */
final class TraceEventCache$save$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TraceEventCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TraceEventCache$save$1(TraceEventCache traceEventCache, Continuation<? super TraceEventCache$save$1> continuation) {
        super(continuation);
        this.this$0 = traceEventCache;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.save((String) null, (NetworkTraceCache) null, (Continuation) this);
    }
}
