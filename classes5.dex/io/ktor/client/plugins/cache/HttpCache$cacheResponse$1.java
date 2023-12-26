package io.ktor.client.plugins.cache;

import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache", f = "HttpCache.kt", i = {}, l = {132}, m = "cacheResponse", n = {}, s = {})
/* compiled from: HttpCache.kt */
final class HttpCache$cacheResponse$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpCache$cacheResponse$1(HttpCache httpCache, Continuation<? super HttpCache$cacheResponse$1> continuation) {
        super(continuation);
        this.this$0 = httpCache;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.cacheResponse((HttpResponse) null, (Continuation) this);
    }
}
