package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/Sender;", "context", "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpRedirect$Plugin$install$1", f = "HttpRedirect.kt", i = {0, 0}, l = {61, 66}, m = "invokeSuspend", n = {"$this$intercept", "context"}, s = {"L$0", "L$1"})
/* compiled from: HttpRedirect.kt */
final class HttpRedirect$Plugin$install$1 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    final /* synthetic */ HttpRedirect $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpRedirect$Plugin$install$1(HttpRedirect httpRedirect, HttpClient httpClient, Continuation<? super HttpRedirect$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = httpRedirect;
        this.$scope = httpClient;
    }

    public final Object invoke(Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        HttpRedirect$Plugin$install$1 httpRedirect$Plugin$install$1 = new HttpRedirect$Plugin$install$1(this.$plugin, this.$scope, continuation);
        httpRedirect$Plugin$install$1.L$0 = sender;
        httpRedirect$Plugin$install$1.L$1 = httpRequestBuilder;
        return httpRedirect$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        HttpRequestBuilder httpRequestBuilder;
        Sender sender;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Sender sender2 = (Sender) this.L$0;
            HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) this.L$1;
            this.L$0 = sender2;
            this.L$1 = httpRequestBuilder2;
            this.label = 1;
            Object execute = sender2.execute(httpRequestBuilder2, (Continuation) this);
            if (execute == coroutine_suspended) {
                return coroutine_suspended;
            }
            sender = sender2;
            httpRequestBuilder = httpRequestBuilder2;
            obj = execute;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            httpRequestBuilder = (HttpRequestBuilder) this.L$1;
            sender = (Sender) this.L$0;
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        HttpClientCall httpClientCall = (HttpClientCall) obj;
        if (this.$plugin.checkHttpMethod && !HttpRedirectKt.ALLOWED_FOR_REDIRECT.contains(httpClientCall.getRequest().getMethod())) {
            return httpClientCall;
        }
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        obj = HttpRedirect.Plugin.handleCall(sender, httpRequestBuilder, httpClientCall, this.$plugin.allowHttpsDowngrade, this.$scope, (Continuation) this);
        return obj == coroutine_suspended ? coroutine_suspended : obj;
    }
}
