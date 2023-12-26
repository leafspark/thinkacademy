package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.util.InternalAPI;
import java.io.Closeable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H@ø\u0001\u0000J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0017R\u000b\u0010\u0004\u001a\u00020\u00058BX\u0004R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lio/ktor/client/engine/HttpClientEngine;", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "closed", "", "config", "Lio/ktor/client/engine/HttpClientEngineConfig;", "getConfig", "()Lio/ktor/client/engine/HttpClientEngineConfig;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "supportedCapabilities", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "getSupportedCapabilities", "()Ljava/util/Set;", "checkExtensions", "", "requestData", "Lio/ktor/client/request/HttpRequestData;", "execute", "Lio/ktor/client/request/HttpResponseData;", "data", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeWithinCallContext", "install", "client", "Lio/ktor/client/HttpClient;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpClientEngine.kt */
public interface HttpClientEngine extends CoroutineScope, Closeable {
    @InternalAPI
    Object execute(HttpRequestData httpRequestData, Continuation<? super HttpResponseData> continuation);

    HttpClientEngineConfig getConfig();

    CoroutineDispatcher getDispatcher();

    Set<HttpClientEngineCapability<?>> getSupportedCapabilities();

    @InternalAPI
    void install(HttpClient httpClient);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpClientEngine.kt */
    public static final class DefaultImpls {
        public static Set<HttpClientEngineCapability<?>> getSupportedCapabilities(HttpClientEngine httpClientEngine) {
            return SetsKt.emptySet();
        }

        /* access modifiers changed from: private */
        public static boolean getClosed(HttpClientEngine httpClientEngine) {
            Job job = httpClientEngine.getCoroutineContext().get(Job.Key);
            return !(job != null ? job.isActive() : false);
        }

        @InternalAPI
        public static void install(HttpClientEngine httpClientEngine, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpClient, "client");
            httpClient.getSendPipeline().intercept(HttpSendPipeline.Phases.getEngine(), new HttpClientEngine$install$1(httpClient, httpClientEngine, (Continuation<? super HttpClientEngine$install$1>) null));
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: io.ktor.client.request.HttpRequestData} */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0082 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0083 A[PHI: r12 
          PHI: (r12v2 java.lang.Object) = (r12v6 java.lang.Object), (r12v1 java.lang.Object) binds: [B:18:0x0080, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.Object executeWithinCallContext(io.ktor.client.engine.HttpClientEngine r10, io.ktor.client.request.HttpRequestData r11, kotlin.coroutines.Continuation<? super io.ktor.client.request.HttpResponseData> r12) {
            /*
                boolean r0 = r12 instanceof io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1
                if (r0 == 0) goto L_0x0014
                r0 = r12
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1 r0 = (io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L_0x0014
                int r12 = r0.label
                int r12 = r12 - r2
                r0.label = r12
                goto L_0x0019
            L_0x0014:
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1 r0 = new io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1
                r0.<init>(r12)
            L_0x0019:
                java.lang.Object r12 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x0042
                if (r2 == r4) goto L_0x0035
                if (r2 != r3) goto L_0x002d
                kotlin.ResultKt.throwOnFailure(r12)
                goto L_0x0083
            L_0x002d:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L_0x0035:
                java.lang.Object r10 = r0.L$1
                r11 = r10
                io.ktor.client.request.HttpRequestData r11 = (io.ktor.client.request.HttpRequestData) r11
                java.lang.Object r10 = r0.L$0
                io.ktor.client.engine.HttpClientEngine r10 = (io.ktor.client.engine.HttpClientEngine) r10
                kotlin.ResultKt.throwOnFailure(r12)
                goto L_0x0056
            L_0x0042:
                kotlin.ResultKt.throwOnFailure(r12)
                kotlinx.coroutines.Job r12 = r11.getExecutionContext()
                r0.L$0 = r10
                r0.L$1 = r11
                r0.label = r4
                java.lang.Object r12 = io.ktor.client.engine.HttpClientEngineKt.createCallContext(r10, r12, r0)
                if (r12 != r1) goto L_0x0056
                return r1
            L_0x0056:
                kotlin.coroutines.CoroutineContext r12 = (kotlin.coroutines.CoroutineContext) r12
                io.ktor.client.engine.KtorCallContextElement r2 = new io.ktor.client.engine.KtorCallContextElement
                r2.<init>(r12)
                kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
                kotlin.coroutines.CoroutineContext r5 = r12.plus(r2)
                r4 = r10
                kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
                r6 = 0
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2 r12 = new io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2
                r2 = 0
                r12.<init>(r10, r11, r2)
                r7 = r12
                kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
                r8 = 2
                r9 = 0
                kotlinx.coroutines.Deferred r10 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r4, r5, r6, r7, r8, r9)
                r0.L$0 = r2
                r0.L$1 = r2
                r0.label = r3
                java.lang.Object r12 = r10.await(r0)
                if (r12 != r1) goto L_0x0083
                return r1
            L_0x0083:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.HttpClientEngine.DefaultImpls.executeWithinCallContext(io.ktor.client.engine.HttpClientEngine, io.ktor.client.request.HttpRequestData, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* access modifiers changed from: private */
        public static void checkExtensions(HttpClientEngine httpClientEngine, HttpRequestData httpRequestData) {
            for (HttpClientEngineCapability next : httpRequestData.getRequiredCapabilities$ktor_client_core()) {
                if (!httpClientEngine.getSupportedCapabilities().contains(next)) {
                    throw new IllegalArgumentException(("Engine doesn't support " + next).toString());
                }
            }
        }
    }
}
