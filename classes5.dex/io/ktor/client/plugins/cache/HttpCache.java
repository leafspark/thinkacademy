package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.cache.storage.HttpCacheStorage;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import io.ktor.util.pipeline.PipelinePhase;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001a\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J6\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache;", "", "publicStorage", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "privateStorage", "(Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;)V", "getPrivateStorage", "()Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "getPublicStorage", "cacheResponse", "Lio/ktor/client/statement/HttpResponse;", "response", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findAndRefresh", "request", "Lio/ktor/client/request/HttpRequest;", "findResponse", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "storage", "varyKeys", "", "", "url", "Lio/ktor/http/Url;", "context", "Lio/ktor/client/request/HttpRequestBuilder;", "content", "Lio/ktor/http/content/OutgoingContent;", "Companion", "Config", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpCache.kt */
public final class HttpCache {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final EventDefinition<HttpResponse> HttpResponseFromCache = new EventDefinition<>();
    /* access modifiers changed from: private */
    public static final AttributeKey<HttpCache> key = new AttributeKey<>("HttpCache");
    private final HttpCacheStorage privateStorage;
    private final HttpCacheStorage publicStorage;

    public /* synthetic */ HttpCache(HttpCacheStorage httpCacheStorage, HttpCacheStorage httpCacheStorage2, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpCacheStorage, httpCacheStorage2);
    }

    private HttpCache(HttpCacheStorage httpCacheStorage, HttpCacheStorage httpCacheStorage2) {
        this.publicStorage = httpCacheStorage;
        this.privateStorage = httpCacheStorage2;
    }

    public final HttpCacheStorage getPublicStorage() {
        return this.publicStorage;
    }

    public final HttpCacheStorage getPrivateStorage() {
        return this.privateStorage;
    }

    @KtorDsl
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache$Config;", "", "()V", "privateStorage", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "getPrivateStorage", "()Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "setPrivateStorage", "(Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;)V", "publicStorage", "getPublicStorage", "setPublicStorage", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpCache.kt */
    public static final class Config {
        private HttpCacheStorage privateStorage = ((HttpCacheStorage) HttpCacheStorage.Companion.getUnlimited().invoke());
        private HttpCacheStorage publicStorage = ((HttpCacheStorage) HttpCacheStorage.Companion.getUnlimited().invoke());

        public final HttpCacheStorage getPublicStorage() {
            return this.publicStorage;
        }

        public final void setPublicStorage(HttpCacheStorage httpCacheStorage) {
            Intrinsics.checkNotNullParameter(httpCacheStorage, "<set-?>");
            this.publicStorage = httpCacheStorage;
        }

        public final HttpCacheStorage getPrivateStorage() {
            return this.privateStorage;
        }

        public final void setPrivateStorage(HttpCacheStorage httpCacheStorage) {
            Intrinsics.checkNotNullParameter(httpCacheStorage, "<set-?>");
            this.privateStorage = httpCacheStorage;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J!\u0010\u0013\u001a\u00020\u00032\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\u0002\b\u0016H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache$Companion;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/cache/HttpCache$Config;", "Lio/ktor/client/plugins/cache/HttpCache;", "()V", "HttpResponseFromCache", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/statement/HttpResponse;", "getHttpResponseFromCache", "()Lio/ktor/events/EventDefinition;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "", "plugin", "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpCache.kt */
    public static final class Companion implements HttpClientPlugin<Config, HttpCache> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public AttributeKey<HttpCache> getKey() {
            return HttpCache.key;
        }

        public final EventDefinition<HttpResponse> getHttpResponseFromCache() {
            return HttpCache.HttpResponseFromCache;
        }

        public HttpCache prepare(Function1<? super Config, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config();
            function1.invoke(config);
            return new HttpCache(config.getPublicStorage(), config.getPrivateStorage(), (DefaultConstructorMarker) null);
        }

        public void install(HttpCache httpCache, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpCache, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            PipelinePhase pipelinePhase = new PipelinePhase("Cache");
            httpClient.getSendPipeline().insertPhaseAfter(HttpSendPipeline.Phases.getState(), pipelinePhase);
            httpClient.getSendPipeline().intercept(pipelinePhase, new HttpCache$Companion$install$1(httpCache, httpClient, (Continuation<? super HttpCache$Companion$install$1>) null));
            httpClient.getReceivePipeline().intercept(HttpReceivePipeline.Phases.getState(), new HttpCache$Companion$install$2(httpCache, httpClient, (Continuation<? super HttpCache$Companion$install$2>) null));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object cacheResponse(io.ktor.client.statement.HttpResponse r7, kotlin.coroutines.Continuation<? super io.ktor.client.statement.HttpResponse> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.client.plugins.cache.HttpCache$cacheResponse$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.client.plugins.cache.HttpCache$cacheResponse$1 r0 = (io.ktor.client.plugins.cache.HttpCache$cacheResponse$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.client.plugins.cache.HttpCache$cacheResponse$1 r0 = new io.ktor.client.plugins.cache.HttpCache$cacheResponse$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006f
        L_0x002a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            io.ktor.client.call.HttpClientCall r8 = r7.getCall()
            io.ktor.client.request.HttpRequest r8 = r8.getRequest()
            r2 = r7
            io.ktor.http.HttpMessage r2 = (io.ktor.http.HttpMessage) r2
            java.util.List r2 = io.ktor.http.HttpMessagePropertiesKt.cacheControl(r2)
            io.ktor.client.plugins.cache.CacheControl r4 = io.ktor.client.plugins.cache.CacheControl.INSTANCE
            io.ktor.http.HeaderValue r4 = r4.getPRIVATE$ktor_client_core()
            boolean r4 = r2.contains(r4)
            if (r4 == 0) goto L_0x0053
            io.ktor.client.plugins.cache.storage.HttpCacheStorage r4 = r6.privateStorage
            goto L_0x0055
        L_0x0053:
            io.ktor.client.plugins.cache.storage.HttpCacheStorage r4 = r6.publicStorage
        L_0x0055:
            io.ktor.client.plugins.cache.CacheControl r5 = io.ktor.client.plugins.cache.CacheControl.INSTANCE
            io.ktor.http.HeaderValue r5 = r5.getNO_STORE$ktor_client_core()
            boolean r2 = r2.contains(r5)
            if (r2 == 0) goto L_0x0062
            return r7
        L_0x0062:
            io.ktor.http.Url r8 = r8.getUrl()
            r0.label = r3
            java.lang.Object r8 = io.ktor.client.plugins.cache.storage.HttpCacheStorageKt.store(r4, r8, r7, r0)
            if (r8 != r1) goto L_0x006f
            return r1
        L_0x006f:
            io.ktor.client.plugins.cache.HttpCacheEntry r8 = (io.ktor.client.plugins.cache.HttpCacheEntry) r8
            io.ktor.client.statement.HttpResponse r7 = r8.produceResponse$ktor_client_core()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache.cacheResponse(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final HttpResponse findAndRefresh(HttpRequest httpRequest, HttpResponse httpResponse) {
        Url url = httpResponse.getCall().getRequest().getUrl();
        HttpCacheStorage httpCacheStorage = HttpMessagePropertiesKt.cacheControl(httpResponse).contains(CacheControl.INSTANCE.getPRIVATE$ktor_client_core()) ? this.privateStorage : this.publicStorage;
        Map<String, String> varyKeys = HttpCacheEntryKt.varyKeys(httpResponse);
        HttpCacheEntry findResponse = findResponse(httpCacheStorage, varyKeys, url, httpRequest);
        if (findResponse == null) {
            return null;
        }
        if (varyKeys.isEmpty()) {
            varyKeys = findResponse.getVaryKeys();
        }
        httpCacheStorage.store(url, new HttpCacheEntry(HttpCacheEntryKt.cacheExpires$default(httpResponse, (Function0) null, 1, (Object) null), varyKeys, findResponse.getResponse(), findResponse.getBody()));
        return findResponse.produceResponse$ktor_client_core();
    }

    private final HttpCacheEntry findResponse(HttpCacheStorage httpCacheStorage, Map<String, String> map, Url url, HttpRequest httpRequest) {
        Object obj;
        boolean z;
        if (!map.isEmpty()) {
            return httpCacheStorage.find(url, map);
        }
        Function1 access$mergedHeadersLookup = HttpCacheKt.mergedHeadersLookup(httpRequest.getContent(), new HttpCache$findResponse$requestHeaders$1(httpRequest.getHeaders()), new HttpCache$findResponse$requestHeaders$2(httpRequest.getHeaders()));
        Iterator it = CollectionsKt.sortedWith(httpCacheStorage.findByUrl(url), new HttpCache$findResponse$$inlined$sortedByDescending$1()).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Map<String, String> varyKeys = ((HttpCacheEntry) obj).getVaryKeys();
            if (!varyKeys.isEmpty()) {
                Iterator<Map.Entry<String, String>> it2 = varyKeys.entrySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Map.Entry next = it2.next();
                    if (!Intrinsics.areEqual(access$mergedHeadersLookup.invoke((String) next.getKey()), (String) next.getValue())) {
                        z = false;
                        continue;
                        break;
                    }
                }
            }
            z = true;
            continue;
            if (z) {
                break;
            }
        }
        return (HttpCacheEntry) obj;
    }

    /* access modifiers changed from: private */
    public final HttpCacheEntry findResponse(HttpRequestBuilder httpRequestBuilder, OutgoingContent outgoingContent) {
        Url Url = URLUtilsKt.Url(httpRequestBuilder.getUrl());
        Function1 access$mergedHeadersLookup = HttpCacheKt.mergedHeadersLookup(outgoingContent, new HttpCache$findResponse$lookup$1(httpRequestBuilder.getHeaders()), new HttpCache$findResponse$lookup$2(httpRequestBuilder.getHeaders()));
        for (HttpCacheEntry httpCacheEntry : SetsKt.plus(this.privateStorage.findByUrl(Url), this.publicStorage.findByUrl(Url))) {
            Map<String, String> varyKeys = httpCacheEntry.getVaryKeys();
            if (!varyKeys.isEmpty()) {
                boolean z = true;
                if (!varyKeys.isEmpty()) {
                    Iterator<Map.Entry<String, String>> it = varyKeys.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            continue;
                            break;
                        }
                        Map.Entry next = it.next();
                        if (!Intrinsics.areEqual(access$mergedHeadersLookup.invoke((String) next.getKey()), (String) next.getValue())) {
                            z = false;
                            continue;
                            break;
                        }
                    }
                }
                if (z) {
                }
            }
            return httpCacheEntry;
        }
        return null;
    }
}
