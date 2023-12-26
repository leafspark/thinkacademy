package io.ktor.client.plugins.cookies;

import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies", f = "HttpCookies.kt", i = {0}, l = {55}, m = "sendCookiesWith$ktor_client_core", n = {"builder"}, s = {"L$0"})
/* compiled from: HttpCookies.kt */
final class HttpCookies$sendCookiesWith$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpCookies this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpCookies$sendCookiesWith$1(HttpCookies httpCookies, Continuation<? super HttpCookies$sendCookiesWith$1> continuation) {
        super(continuation);
        this.this$0 = httpCookies;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendCookiesWith$ktor_client_core((HttpRequestBuilder) null, (Continuation) this);
    }
}
