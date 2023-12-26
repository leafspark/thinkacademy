package io.ktor.client;

import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.engine.HttpClientEngineFactory;
import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001b\u0010\u0004\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0007\u001aA\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\u001f\b\u0002\u0010\u0004\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0007¨\u0006\r"}, d2 = {"HttpClient", "Lio/ktor/client/HttpClient;", "engine", "Lio/ktor/client/engine/HttpClientEngine;", "block", "Lkotlin/Function1;", "Lio/ktor/client/HttpClientConfig;", "", "Lkotlin/ExtensionFunctionType;", "T", "Lio/ktor/client/engine/HttpClientEngineConfig;", "engineFactory", "Lio/ktor/client/engine/HttpClientEngineFactory;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpClient.kt */
public final class HttpClientKt {
    public static /* synthetic */ HttpClient HttpClient$default(HttpClientEngineFactory httpClientEngineFactory, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) HttpClientKt$HttpClient$1.INSTANCE;
        }
        return HttpClient(httpClientEngineFactory, function1);
    }

    @KtorDsl
    public static final <T extends HttpClientEngineConfig> HttpClient HttpClient(HttpClientEngineFactory<? extends T> httpClientEngineFactory, Function1<? super HttpClientConfig<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpClientEngineFactory, "engineFactory");
        Intrinsics.checkNotNullParameter(function1, "block");
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        function1.invoke(httpClientConfig);
        HttpClientEngine create = httpClientEngineFactory.create(httpClientConfig.getEngineConfig$ktor_client_core());
        HttpClient httpClient = new HttpClient(create, httpClientConfig, true);
        Job job = httpClient.getCoroutineContext().get(Job.Key);
        Intrinsics.checkNotNull(job);
        job.invokeOnCompletion(new HttpClientKt$HttpClient$2(create));
        return httpClient;
    }

    @KtorDsl
    public static final HttpClient HttpClient(HttpClientEngine httpClientEngine, Function1<? super HttpClientConfig<?>, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpClientEngine, "engine");
        Intrinsics.checkNotNullParameter(function1, "block");
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        function1.invoke(httpClientConfig);
        return new HttpClient(httpClientEngine, httpClientConfig, false);
    }
}
