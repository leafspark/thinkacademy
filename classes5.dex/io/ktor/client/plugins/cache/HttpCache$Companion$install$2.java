package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "response"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache$Companion$install$2", f = "HttpCache.kt", i = {0}, l = {105, 106, 116}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
/* compiled from: HttpCache.kt */
final class HttpCache$Companion$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpCache $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpCache$Companion$install$2(HttpCache httpCache, HttpClient httpClient, Continuation<? super HttpCache$Companion$install$2> continuation) {
        super(3, continuation);
        this.$plugin = httpCache;
        this.$scope = httpClient;
    }

    public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        HttpCache$Companion$install$2 httpCache$Companion$install$2 = new HttpCache$Companion$install$2(this.$plugin, this.$scope, continuation);
        httpCache$Companion$install$2.L$0 = pipelineContext;
        httpCache$Companion$install$2.L$1 = httpResponse;
        return httpCache$Companion$install$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: io.ktor.util.pipeline.PipelineContext} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x002b
            if (r1 == r5) goto L_0x0023
            if (r1 == r4) goto L_0x001f
            if (r1 != r3) goto L_0x0017
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00d1
        L_0x0017:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x007c
        L_0x0023:
            java.lang.Object r1 = r8.L$0
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006c
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            r1 = r9
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            java.lang.Object r9 = r8.L$1
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            io.ktor.client.call.HttpClientCall r6 = r9.getCall()
            io.ktor.client.request.HttpRequest r6 = r6.getRequest()
            io.ktor.http.HttpMethod r6 = r6.getMethod()
            io.ktor.http.HttpMethod$Companion r7 = io.ktor.http.HttpMethod.Companion
            io.ktor.http.HttpMethod r7 = r7.getGet()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            if (r6 != 0) goto L_0x0052
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0052:
            io.ktor.http.HttpStatusCode r6 = r9.getStatus()
            boolean r6 = io.ktor.http.HttpStatusCodeKt.isSuccess(r6)
            if (r6 == 0) goto L_0x007f
            io.ktor.client.plugins.cache.HttpCache r3 = r8.$plugin
            r6 = r8
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r8.L$0 = r1
            r8.label = r5
            java.lang.Object r9 = r3.cacheResponse(r9, r6)
            if (r9 != r0) goto L_0x006c
            return r0
        L_0x006c:
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            r3 = r8
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r8.L$0 = r2
            r8.label = r4
            java.lang.Object r9 = r1.proceedWith(r9, r3)
            if (r9 != r0) goto L_0x007c
            return r0
        L_0x007c:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x007f:
            io.ktor.http.HttpStatusCode r4 = r9.getStatus()
            io.ktor.http.HttpStatusCode$Companion r5 = io.ktor.http.HttpStatusCode.Companion
            io.ktor.http.HttpStatusCode r5 = r5.getNotModified()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 == 0) goto L_0x00d1
            io.ktor.client.statement.HttpResponseKt.complete(r9)
            io.ktor.client.plugins.cache.HttpCache r4 = r8.$plugin
            io.ktor.client.call.HttpClientCall r5 = r9.getCall()
            io.ktor.client.request.HttpRequest r5 = r5.getRequest()
            io.ktor.client.statement.HttpResponse r4 = r4.findAndRefresh(r5, r9)
            if (r4 == 0) goto L_0x00bf
            io.ktor.client.HttpClient r9 = r8.$scope
            io.ktor.events.Events r9 = r9.getMonitor()
            io.ktor.client.plugins.cache.HttpCache$Companion r5 = io.ktor.client.plugins.cache.HttpCache.Companion
            io.ktor.events.EventDefinition r5 = r5.getHttpResponseFromCache()
            r9.raise(r5, r4)
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r8.L$0 = r2
            r8.label = r3
            java.lang.Object r9 = r1.proceedWith(r4, r9)
            if (r9 != r0) goto L_0x00d1
            return r0
        L_0x00bf:
            io.ktor.client.plugins.cache.InvalidCacheStateException r0 = new io.ktor.client.plugins.cache.InvalidCacheStateException
            io.ktor.client.call.HttpClientCall r9 = r9.getCall()
            io.ktor.client.request.HttpRequest r9 = r9.getRequest()
            io.ktor.http.Url r9 = r9.getUrl()
            r0.<init>(r9)
            throw r0
        L_0x00d1:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache$Companion$install$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
