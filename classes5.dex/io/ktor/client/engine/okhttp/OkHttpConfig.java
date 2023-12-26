package io.ktor.client.engine.okhttp;

import io.ktor.client.engine.HttpClientEngineConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.WebSocket;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 J\u001f\u0010\t\u001a\u00020\f2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR+\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpConfig;", "Lio/ktor/client/engine/HttpClientEngineConfig;", "()V", "clientCacheSize", "", "getClientCacheSize", "()I", "setClientCacheSize", "(I)V", "config", "Lkotlin/Function1;", "Lokhttp3/OkHttpClient$Builder;", "", "Lkotlin/ExtensionFunctionType;", "getConfig$ktor_client_okhttp", "()Lkotlin/jvm/functions/Function1;", "setConfig$ktor_client_okhttp", "(Lkotlin/jvm/functions/Function1;)V", "preconfigured", "Lokhttp3/OkHttpClient;", "getPreconfigured", "()Lokhttp3/OkHttpClient;", "setPreconfigured", "(Lokhttp3/OkHttpClient;)V", "webSocketFactory", "Lokhttp3/WebSocket$Factory;", "getWebSocketFactory", "()Lokhttp3/WebSocket$Factory;", "setWebSocketFactory", "(Lokhttp3/WebSocket$Factory;)V", "addInterceptor", "interceptor", "Lokhttp3/Interceptor;", "addNetworkInterceptor", "block", "ktor-client-okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpConfig.kt */
public final class OkHttpConfig extends HttpClientEngineConfig {
    private int clientCacheSize = 10;
    private Function1<? super OkHttpClient.Builder, Unit> config = ((Function1) OkHttpConfig$config$1.INSTANCE);
    private OkHttpClient preconfigured;
    private WebSocket.Factory webSocketFactory;

    public final Function1<OkHttpClient.Builder, Unit> getConfig$ktor_client_okhttp() {
        return this.config;
    }

    public final void setConfig$ktor_client_okhttp(Function1<? super OkHttpClient.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.config = function1;
    }

    public final OkHttpClient getPreconfigured() {
        return this.preconfigured;
    }

    public final void setPreconfigured(OkHttpClient okHttpClient) {
        this.preconfigured = okHttpClient;
    }

    public final int getClientCacheSize() {
        return this.clientCacheSize;
    }

    public final void setClientCacheSize(int i) {
        this.clientCacheSize = i;
    }

    public final WebSocket.Factory getWebSocketFactory() {
        return this.webSocketFactory;
    }

    public final void setWebSocketFactory(WebSocket.Factory factory) {
        this.webSocketFactory = factory;
    }

    public final void config(Function1<? super OkHttpClient.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.config = (Function1) new OkHttpConfig$config$2(this.config, function1);
    }

    public final void addInterceptor(Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        config(new OkHttpConfig$addInterceptor$1(interceptor));
    }

    public final void addNetworkInterceptor(Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        config(new OkHttpConfig$addNetworkInterceptor$1(interceptor));
    }
}
