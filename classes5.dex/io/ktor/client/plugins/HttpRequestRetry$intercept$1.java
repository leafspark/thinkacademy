package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/Sender;", "request", "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestRetry$intercept$1", f = "HttpRequestRetry.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {275, 291}, m = "invokeSuspend", n = {"$this$intercept", "request", "shouldRetry", "shouldRetryOnException", "delayMillis", "modifyRequest", "subRequest", "retryCount", "maxRetries", "$this$intercept", "request", "shouldRetry", "shouldRetryOnException", "delayMillis", "modifyRequest", "lastRetryData", "retryCount", "maxRetries"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"})
/* compiled from: HttpRequestRetry.kt */
final class HttpRequestRetry$intercept$1 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    final /* synthetic */ HttpClient $client;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ HttpRequestRetry this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpRequestRetry$intercept$1(HttpRequestRetry httpRequestRetry, HttpClient httpClient, Continuation<? super HttpRequestRetry$intercept$1> continuation) {
        super(3, continuation);
        this.this$0 = httpRequestRetry;
        this.$client = httpClient;
    }

    public final Object invoke(Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        HttpRequestRetry$intercept$1 httpRequestRetry$intercept$1 = new HttpRequestRetry$intercept$1(this.this$0, this.$client, continuation);
        httpRequestRetry$intercept$1.L$0 = sender;
        httpRequestRetry$intercept$1.L$1 = httpRequestBuilder;
        return httpRequestRetry$intercept$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: io.ktor.client.request.HttpRequestBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: kotlin.jvm.functions.Function3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: io.ktor.client.request.HttpRequestBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v30, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v9, resolved type: io.ktor.client.plugins.Sender} */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(1:(1:(2:4|65)(2:5|6))(7:7|8|9|10|48|(1:50)(5:51|52|61|(1:63)(2:64|65)|63)|50))(11:13|(1:15)|16|(1:18)|19|(1:21)(1:22)|23|(1:25)|26|(1:28)|29)|30|(4:32|33|34|35)|40|41|42|43|44|45|(1:47)|48|(0)|50) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|34|35) */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0133, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0134, code lost:
        r16 = r12;
        r17 = r13;
        r18 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x017f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x018e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0169 A[Catch:{ all -> 0x017f }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x020e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            r20 = this;
            r1 = r20
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            r3 = 2
            r5 = 1
            if (r0 == 0) goto L_0x008e
            if (r0 == r5) goto L_0x004b
            if (r0 != r3) goto L_0x0043
            int r0 = r1.I$1
            int r6 = r1.I$0
            java.lang.Object r7 = r1.L$6
            io.ktor.client.plugins.HttpRequestRetry$RetryEventData r7 = (io.ktor.client.plugins.HttpRequestRetry.RetryEventData) r7
            java.lang.Object r8 = r1.L$5
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r9 = r1.L$4
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            java.lang.Object r10 = r1.L$3
            kotlin.jvm.functions.Function3 r10 = (kotlin.jvm.functions.Function3) r10
            java.lang.Object r11 = r1.L$2
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            java.lang.Object r12 = r1.L$1
            io.ktor.client.request.HttpRequestBuilder r12 = (io.ktor.client.request.HttpRequestBuilder) r12
            java.lang.Object r13 = r1.L$0
            io.ktor.client.plugins.Sender r13 = (io.ktor.client.plugins.Sender) r13
            kotlin.ResultKt.throwOnFailure(r21)
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r1
            r19 = r3
            r3 = r0
            r0 = r7
            r7 = r6
            r6 = r19
            goto L_0x0206
        L_0x0043:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004b:
            int r6 = r1.I$1
            int r7 = r1.I$0
            java.lang.Object r0 = r1.L$6
            r8 = r0
            io.ktor.client.request.HttpRequestBuilder r8 = (io.ktor.client.request.HttpRequestBuilder) r8
            java.lang.Object r0 = r1.L$5
            r9 = r0
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            java.lang.Object r0 = r1.L$4
            r10 = r0
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            java.lang.Object r0 = r1.L$3
            r11 = r0
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            java.lang.Object r0 = r1.L$2
            r12 = r0
            kotlin.jvm.functions.Function3 r12 = (kotlin.jvm.functions.Function3) r12
            java.lang.Object r0 = r1.L$1
            r13 = r0
            io.ktor.client.request.HttpRequestBuilder r13 = (io.ktor.client.request.HttpRequestBuilder) r13
            java.lang.Object r0 = r1.L$0
            r14 = r0
            io.ktor.client.plugins.Sender r14 = (io.ktor.client.plugins.Sender) r14
            kotlin.ResultKt.throwOnFailure(r21)     // Catch:{ all -> 0x007c }
            r0 = r21
            r3 = r5
            r15 = r8
            r8 = r1
            goto L_0x015e
        L_0x007c:
            r0 = move-exception
            r3 = r5
            r15 = r8
            r16 = r12
            r17 = r13
            r18 = r14
            r12 = r9
            r13 = r10
            r14 = r11
            r9 = r0
            r11 = r1
            r0 = r6
            r10 = r7
            goto L_0x0191
        L_0x008e:
            kotlin.ResultKt.throwOnFailure(r21)
            java.lang.Object r0 = r1.L$0
            io.ktor.client.plugins.Sender r0 = (io.ktor.client.plugins.Sender) r0
            java.lang.Object r6 = r1.L$1
            io.ktor.client.request.HttpRequestBuilder r6 = (io.ktor.client.request.HttpRequestBuilder) r6
            r7 = 0
            io.ktor.util.Attributes r8 = r6.getAttributes()
            io.ktor.util.AttributeKey r9 = io.ktor.client.plugins.HttpRequestRetryKt.ShouldRetryPerRequestAttributeKey
            java.lang.Object r8 = r8.getOrNull(r9)
            kotlin.jvm.functions.Function3 r8 = (kotlin.jvm.functions.Function3) r8
            if (r8 != 0) goto L_0x00b0
            io.ktor.client.plugins.HttpRequestRetry r8 = r1.this$0
            kotlin.jvm.functions.Function3 r8 = r8.shouldRetry
        L_0x00b0:
            io.ktor.util.Attributes r9 = r6.getAttributes()
            io.ktor.util.AttributeKey r10 = io.ktor.client.plugins.HttpRequestRetryKt.ShouldRetryOnExceptionPerRequestAttributeKey
            java.lang.Object r9 = r9.getOrNull(r10)
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            if (r9 != 0) goto L_0x00c6
            io.ktor.client.plugins.HttpRequestRetry r9 = r1.this$0
            kotlin.jvm.functions.Function3 r9 = r9.shouldRetryOnException
        L_0x00c6:
            io.ktor.util.Attributes r10 = r6.getAttributes()
            io.ktor.util.AttributeKey r11 = io.ktor.client.plugins.HttpRequestRetryKt.MaxRetriesPerRequestAttributeKey
            java.lang.Object r10 = r10.getOrNull(r11)
            java.lang.Integer r10 = (java.lang.Integer) r10
            if (r10 == 0) goto L_0x00db
            int r10 = r10.intValue()
            goto L_0x00e1
        L_0x00db:
            io.ktor.client.plugins.HttpRequestRetry r10 = r1.this$0
            int r10 = r10.maxRetries
        L_0x00e1:
            io.ktor.util.Attributes r11 = r6.getAttributes()
            io.ktor.util.AttributeKey r12 = io.ktor.client.plugins.HttpRequestRetryKt.RetryDelayPerRequestAttributeKey
            java.lang.Object r11 = r11.getOrNull(r12)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            if (r11 != 0) goto L_0x00f7
            io.ktor.client.plugins.HttpRequestRetry r11 = r1.this$0
            kotlin.jvm.functions.Function2 r11 = r11.delayMillis
        L_0x00f7:
            io.ktor.util.Attributes r12 = r6.getAttributes()
            io.ktor.util.AttributeKey r13 = io.ktor.client.plugins.HttpRequestRetryKt.ModifyRequestPerRequestAttributeKey
            java.lang.Object r12 = r12.getOrNull(r13)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            if (r12 != 0) goto L_0x010d
            io.ktor.client.plugins.HttpRequestRetry r12 = r1.this$0
            kotlin.jvm.functions.Function2 r12 = r12.modifyRequest
        L_0x010d:
            r14 = r0
            r13 = r6
            r6 = r10
            r10 = r11
            r0 = 0
            r11 = r9
            r9 = r12
            r12 = r8
            r8 = r1
        L_0x0116:
            io.ktor.client.plugins.HttpRequestRetry r15 = r8.this$0
            io.ktor.client.request.HttpRequestBuilder r15 = r15.prepareRequest(r13)
            if (r0 == 0) goto L_0x013f
            io.ktor.client.plugins.HttpRequestRetry$ModifyRequestContext r3 = new io.ktor.client.plugins.HttpRequestRetry$ModifyRequestContext     // Catch:{ all -> 0x013c }
            io.ktor.client.statement.HttpResponse r4 = r0.getResponse()     // Catch:{ all -> 0x013c }
            java.lang.Throwable r5 = r0.getCause()     // Catch:{ all -> 0x0133 }
            int r0 = r0.getRetryCount()     // Catch:{ all -> 0x0133 }
            r3.<init>(r13, r4, r5, r0)     // Catch:{ all -> 0x0133 }
            r9.invoke(r3, r15)     // Catch:{ all -> 0x0133 }
            goto L_0x013f
        L_0x0133:
            r0 = move-exception
            r16 = r12
            r17 = r13
            r18 = r14
            r3 = 1
            goto L_0x0186
        L_0x013c:
            r0 = move-exception
            r3 = r5
            goto L_0x0180
        L_0x013f:
            r0 = r8
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x018e }
            r8.L$0 = r14     // Catch:{ all -> 0x018e }
            r8.L$1 = r13     // Catch:{ all -> 0x018e }
            r8.L$2 = r12     // Catch:{ all -> 0x018e }
            r8.L$3 = r11     // Catch:{ all -> 0x018e }
            r8.L$4 = r10     // Catch:{ all -> 0x018e }
            r8.L$5 = r9     // Catch:{ all -> 0x018e }
            r8.L$6 = r15     // Catch:{ all -> 0x018e }
            r8.I$0 = r7     // Catch:{ all -> 0x018e }
            r8.I$1 = r6     // Catch:{ all -> 0x018e }
            r3 = 1
            r8.label = r3     // Catch:{ all -> 0x017f }
            java.lang.Object r0 = r14.execute(r15, r0)     // Catch:{ all -> 0x017f }
            if (r0 != r2) goto L_0x015e
            return r2
        L_0x015e:
            io.ktor.client.call.HttpClientCall r0 = (io.ktor.client.call.HttpClientCall) r0     // Catch:{ all -> 0x017f }
            io.ktor.client.plugins.HttpRequestRetry r4 = r8.this$0     // Catch:{ all -> 0x017f }
            boolean r4 = r4.shouldRetry(r7, r6, r12, r0)     // Catch:{ all -> 0x017f }
            if (r4 != 0) goto L_0x0169
            return r0
        L_0x0169:
            io.ktor.client.plugins.HttpRequestRetry$RetryEventData r4 = new io.ktor.client.plugins.HttpRequestRetry$RetryEventData     // Catch:{ all -> 0x017f }
            int r7 = r7 + 1
            io.ktor.client.statement.HttpResponse r0 = r0.getResponse()     // Catch:{ all -> 0x017f }
            r5 = 0
            r4.<init>(r15, r7, r0, r5)     // Catch:{ all -> 0x017f }
            r0 = r6
            r6 = 0
            r19 = r14
            r14 = r11
            r11 = r12
            r12 = r13
            r13 = r19
            goto L_0x01b3
        L_0x017f:
            r0 = move-exception
        L_0x0180:
            r16 = r12
            r17 = r13
            r18 = r14
        L_0x0186:
            r12 = r9
            r13 = r10
            r14 = r11
            r9 = r0
            r0 = r6
            r10 = r7
            r11 = r8
            goto L_0x0191
        L_0x018e:
            r0 = move-exception
            r3 = 1
            goto L_0x0180
        L_0x0191:
            io.ktor.client.plugins.HttpRequestRetry r4 = r11.this$0
            r5 = r10
            r6 = r0
            r7 = r14
            r8 = r15
            r21 = r9
            boolean r4 = r4.shouldRetryOnException(r5, r6, r7, r8, r9)
            if (r4 == 0) goto L_0x020e
            io.ktor.client.plugins.HttpRequestRetry$RetryEventData r4 = new io.ktor.client.plugins.HttpRequestRetry$RetryEventData
            int r10 = r10 + 1
            r5 = r21
            r6 = 0
            r4.<init>(r15, r10, r6, r5)
            r7 = r10
            r8 = r11
            r9 = r12
            r10 = r13
            r11 = r16
            r12 = r17
            r13 = r18
        L_0x01b3:
            io.ktor.client.HttpClient r5 = r8.$client
            io.ktor.events.Events r5 = r5.getMonitor()
            io.ktor.client.plugins.HttpRequestRetry$Plugin r15 = io.ktor.client.plugins.HttpRequestRetry.Plugin
            io.ktor.events.EventDefinition r15 = r15.getHttpRequestRetryEvent()
            r5.raise(r15, r4)
            io.ktor.client.plugins.HttpRequestRetry$DelayContext r5 = new io.ktor.client.plugins.HttpRequestRetry$DelayContext
            io.ktor.client.request.HttpRequestBuilder r15 = r4.getRequest()
            io.ktor.client.statement.HttpResponse r3 = r4.getResponse()
            java.lang.Throwable r6 = r4.getCause()
            r5.<init>(r15, r3, r6)
            io.ktor.client.plugins.HttpRequestRetry r3 = r8.this$0
            kotlin.jvm.functions.Function2 r3 = r3.delay
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            java.lang.Object r5 = r10.invoke(r5, r6)
            r8.L$0 = r13
            r8.L$1 = r12
            r8.L$2 = r11
            r8.L$3 = r14
            r8.L$4 = r10
            r8.L$5 = r9
            r8.L$6 = r4
            r8.I$0 = r7
            r8.I$1 = r0
            r6 = 2
            r8.label = r6
            java.lang.Object r3 = r3.invoke(r5, r8)
            if (r3 != r2) goto L_0x01fd
            return r2
        L_0x01fd:
            r3 = r0
            r0 = r4
            r19 = r12
            r12 = r11
            r11 = r14
            r14 = r13
            r13 = r19
        L_0x0206:
            r5 = 1
            r19 = r6
            r6 = r3
            r3 = r19
            goto L_0x0116
        L_0x020e:
            r5 = r21
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRequestRetry$intercept$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
