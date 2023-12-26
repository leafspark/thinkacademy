package io.ktor.client.plugins.observer;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0002\r\u000eBD\u0012\"\u0010\u0002\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R/\u0010\u0002\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/observer/ResponseObserver;", "", "responseHandler", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/coroutines/Continuation;", "", "filter", "Lkotlin/Function1;", "Lio/ktor/client/call/HttpClientCall;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function2;", "Config", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ResponseObserver.kt */
public final class ResponseObserver {
    public static final Plugin Plugin = new Plugin((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AttributeKey<ResponseObserver> key = new AttributeKey<>("BodyInterceptor");
    /* access modifiers changed from: private */
    public final Function1<HttpClientCall, Boolean> filter;
    /* access modifiers changed from: private */
    public final Function2<HttpResponse, Continuation<? super Unit>, Object> responseHandler;

    public ResponseObserver(Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> function2, Function1<? super HttpClientCall, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function2, "responseHandler");
        this.responseHandler = function2;
        this.filter = function1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResponseObserver(Function2 function2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2, (i & 2) != 0 ? null : function1);
    }

    @KtorDsl
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u000f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J2\u0010\u0016\u001a\u00020\u000f2\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fø\u0001\u0000¢\u0006\u0002\u0010\u0013R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR;\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fX\u000eø\u0001\u0000¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lio/ktor/client/plugins/observer/ResponseObserver$Config;", "", "()V", "filter", "Lkotlin/Function1;", "Lio/ktor/client/call/HttpClientCall;", "", "getFilter$ktor_client_core", "()Lkotlin/jvm/functions/Function1;", "setFilter$ktor_client_core", "(Lkotlin/jvm/functions/Function1;)V", "responseHandler", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/coroutines/Continuation;", "", "getResponseHandler$ktor_client_core", "()Lkotlin/jvm/functions/Function2;", "setResponseHandler$ktor_client_core", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "block", "onResponse", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ResponseObserver.kt */
    public static final class Config {
        private Function1<? super HttpClientCall, Boolean> filter;
        private Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> responseHandler = ((Function2) new ResponseObserver$Config$responseHandler$1((Continuation<? super ResponseObserver$Config$responseHandler$1>) null));

        public final Function2<HttpResponse, Continuation<? super Unit>, Object> getResponseHandler$ktor_client_core() {
            return this.responseHandler;
        }

        public final void setResponseHandler$ktor_client_core(Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.responseHandler = function2;
        }

        public final Function1<HttpClientCall, Boolean> getFilter$ktor_client_core() {
            return this.filter;
        }

        public final void setFilter$ktor_client_core(Function1<? super HttpClientCall, Boolean> function1) {
            this.filter = function1;
        }

        public final void onResponse(Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> function2) {
            Intrinsics.checkNotNullParameter(function2, "block");
            this.responseHandler = function2;
        }

        public final void filter(Function1<? super HttpClientCall, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            this.filter = function1;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J!\u0010\u000e\u001a\u00020\u00032\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0002\b\u0011H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/observer/ResponseObserver$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/observer/ResponseObserver$Config;", "Lio/ktor/client/plugins/observer/ResponseObserver;", "()V", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "", "plugin", "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ResponseObserver.kt */
    public static final class Plugin implements HttpClientPlugin<Config, ResponseObserver> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Plugin() {
        }

        public AttributeKey<ResponseObserver> getKey() {
            return ResponseObserver.key;
        }

        public ResponseObserver prepare(Function1<? super Config, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config();
            function1.invoke(config);
            return new ResponseObserver(config.getResponseHandler$ktor_client_core(), config.getFilter$ktor_client_core());
        }

        public void install(ResponseObserver responseObserver, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(responseObserver, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            httpClient.getReceivePipeline().intercept(HttpReceivePipeline.Phases.getAfter(), new ResponseObserver$Plugin$install$1(responseObserver, httpClient, (Continuation<? super ResponseObserver$Plugin$install$1>) null));
        }
    }
}
