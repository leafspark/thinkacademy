package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpRedirect;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpRedirect$Plugin", f = "HttpRedirect.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {107}, m = "handleCall", n = {"this", "$this$handleCall", "client", "call", "requestBuilder", "originProtocol", "originAuthority", "allowHttpsDowngrade"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"})
/* compiled from: HttpRedirect.kt */
final class HttpRedirect$Plugin$handleCall$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpRedirect.Plugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpRedirect$Plugin$handleCall$1(HttpRedirect.Plugin plugin, Continuation<? super HttpRedirect$Plugin$handleCall$1> continuation) {
        super(continuation);
        this.this$0 = plugin;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handleCall((Sender) null, (HttpRequestBuilder) null, (HttpClientCall) null, false, (HttpClient) null, (Continuation) this);
    }
}
