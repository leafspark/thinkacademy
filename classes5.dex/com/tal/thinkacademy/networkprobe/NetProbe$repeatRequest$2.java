package com.tal.thinkacademy.networkprobe;

import com.tal.thinkacademy.networkprobe.data.NetProbeResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/tal/thinkacademy/networkprobe/data/NetProbeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.thinkacademy.networkprobe.NetProbe$repeatRequest$2", f = "NetProbe.kt", i = {0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6}, l = {150, 165, 288, 173, 179, 188, 196}, m = "invokeSuspend", n = {"$this$supervisorScope", "probeResult", "index$iv", "probeResult", "result", "$this$withLock_u24default$iv", "index$iv", "probeResult", "$this$withLock_u24default$iv", "status", "id", "index$iv", "probeResult", "$this$withLock_u24default$iv", "index$iv", "totalTime", "probeResult", "index$iv", "probeResult"}, s = {"L$0", "L$0", "I$0", "L$0", "L$4", "L$5", "I$0", "L$0", "L$4", "L$5", "L$6", "I$0", "L$0", "L$4", "I$0", "J$0", "L$0", "I$0", "L$0"})
/* compiled from: NetProbe.kt */
final class NetProbe$repeatRequest$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super NetProbeResult>, Object> {
    final /* synthetic */ String $host;
    final /* synthetic */ Map<String, String> $params;
    final /* synthetic */ String $path;
    final /* synthetic */ int $repeatCount;
    int I$0;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ NetProbe this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetProbe$repeatRequest$2(NetProbe netProbe, int i, String str, String str2, Map<String, String> map, Continuation<? super NetProbe$repeatRequest$2> continuation) {
        super(2, continuation);
        this.this$0 = netProbe;
        this.$repeatCount = i;
        this.$host = str;
        this.$path = str2;
        this.$params = map;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> netProbe$repeatRequest$2 = new NetProbe$repeatRequest$2(this.this$0, this.$repeatCount, this.$host, this.$path, this.$params, continuation);
        netProbe$repeatRequest$2.L$0 = obj;
        return (Continuation) netProbe$repeatRequest$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super NetProbeResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v49, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v23, resolved type: java.util.Iterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v50, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v29, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v51, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: com.tal.thinkacademy.networkprobe.NetProbe} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v36, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v31, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v37, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v22, resolved type: java.util.Iterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v38, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v39, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: com.tal.thinkacademy.networkprobe.NetProbe} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v40, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: com.tal.thinkacademy.networkprobe.data.NetProbeResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v63, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v33, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v64, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v25, resolved type: java.util.Iterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v65, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v25, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v66, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: com.tal.thinkacademy.networkprobe.NetProbe} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v67, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v16, resolved type: com.tal.thinkacademy.networkprobe.data.NetProbeResult} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Region traversal failed: Recursive call in traverseIterativeStepInternal method
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0355  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0372 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0373  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0334 A[RETURN] */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            r25 = this;
            r1 = r25
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            r3 = 0
            java.lang.String r4 = "NetProbe"
            r5 = 0
            switch(r0) {
                case 0: goto L_0x00f2;
                case 1: goto L_0x00ea;
                case 2: goto L_0x00be;
                case 3: goto L_0x0090;
                case 4: goto L_0x005f;
                case 5: goto L_0x0038;
                case 6: goto L_0x0020;
                case 7: goto L_0x0017;
                default: goto L_0x000f;
            }
        L_0x000f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0017:
            java.lang.Object r0 = r1.L$0
            com.tal.thinkacademy.networkprobe.data.NetProbeResult r0 = (com.tal.thinkacademy.networkprobe.data.NetProbeResult) r0
            kotlin.ResultKt.throwOnFailure(r26)
            goto L_0x0374
        L_0x0020:
            int r0 = r1.I$0
            java.lang.Object r3 = r1.L$3
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r6 = r1.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r1.L$1
            com.tal.thinkacademy.networkprobe.NetProbe r7 = (com.tal.thinkacademy.networkprobe.NetProbe) r7
            java.lang.Object r8 = r1.L$0
            com.tal.thinkacademy.networkprobe.data.NetProbeResult r8 = (com.tal.thinkacademy.networkprobe.data.NetProbeResult) r8
            kotlin.ResultKt.throwOnFailure(r26)
            r9 = r1
            goto L_0x0335
        L_0x0038:
            long r6 = r1.J$0
            int r3 = r1.I$0
            java.lang.Object r0 = r1.L$4
            r8 = r0
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r0 = r1.L$3
            r9 = r0
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r0 = r1.L$2
            r10 = r0
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r0 = r1.L$1
            r11 = r0
            com.tal.thinkacademy.networkprobe.NetProbe r11 = (com.tal.thinkacademy.networkprobe.NetProbe) r11
            java.lang.Object r0 = r1.L$0
            r12 = r0
            com.tal.thinkacademy.networkprobe.data.NetProbeResult r12 = (com.tal.thinkacademy.networkprobe.data.NetProbeResult) r12
            kotlin.ResultKt.throwOnFailure(r26)     // Catch:{ all -> 0x008b }
            r23 = r9
            r9 = r1
            r1 = r23
            goto L_0x02bc
        L_0x005f:
            int r3 = r1.I$0
            java.lang.Object r0 = r1.L$6
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r6 = r1.L$5
            io.ktor.http.HttpStatusCode r6 = (io.ktor.http.HttpStatusCode) r6
            java.lang.Object r7 = r1.L$4
            r8 = r7
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r7 = r1.L$3
            r9 = r7
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r7 = r1.L$2
            r10 = r7
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r7 = r1.L$1
            r11 = r7
            com.tal.thinkacademy.networkprobe.NetProbe r11 = (com.tal.thinkacademy.networkprobe.NetProbe) r11
            java.lang.Object r7 = r1.L$0
            r12 = r7
            com.tal.thinkacademy.networkprobe.data.NetProbeResult r12 = (com.tal.thinkacademy.networkprobe.data.NetProbeResult) r12
            kotlin.ResultKt.throwOnFailure(r26)     // Catch:{ all -> 0x008b }
            r13 = r26
            r7 = r9
            r9 = r1
            goto L_0x0257
        L_0x008b:
            r0 = move-exception
            r7 = r9
            r9 = r1
            goto L_0x02dc
        L_0x0090:
            int r3 = r1.I$0
            java.lang.Object r0 = r1.L$5
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            java.lang.Object r6 = r1.L$4
            io.ktor.client.statement.HttpResponse r6 = (io.ktor.client.statement.HttpResponse) r6
            java.lang.Object r7 = r1.L$3
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r8 = r1.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r1.L$1
            com.tal.thinkacademy.networkprobe.NetProbe r9 = (com.tal.thinkacademy.networkprobe.NetProbe) r9
            java.lang.Object r10 = r1.L$0
            com.tal.thinkacademy.networkprobe.data.NetProbeResult r10 = (com.tal.thinkacademy.networkprobe.data.NetProbeResult) r10
            kotlin.ResultKt.throwOnFailure(r26)     // Catch:{ Exception -> 0x00b4 }
            r11 = r9
            r12 = r10
            r9 = r1
            r10 = r8
            r8 = r0
            goto L_0x020a
        L_0x00b4:
            r0 = move-exception
            r6 = r8
            r8 = r10
            r23 = r1
            r1 = r0
            r0 = r3
            r3 = r7
            r7 = r9
            goto L_0x00e6
        L_0x00be:
            int r3 = r1.I$0
            java.lang.Object r0 = r1.L$3
            r6 = r0
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r0 = r1.L$2
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r0 = r1.L$1
            r8 = r0
            com.tal.thinkacademy.networkprobe.NetProbe r8 = (com.tal.thinkacademy.networkprobe.NetProbe) r8
            java.lang.Object r0 = r1.L$0
            r9 = r0
            com.tal.thinkacademy.networkprobe.data.NetProbeResult r9 = (com.tal.thinkacademy.networkprobe.data.NetProbeResult) r9
            kotlin.ResultKt.throwOnFailure(r26)     // Catch:{ Exception -> 0x00dd }
            r0 = r26
            r10 = r9
            r9 = r1
            goto L_0x01e3
        L_0x00dd:
            r0 = move-exception
            r23 = r1
            r1 = r0
            r0 = r3
            r3 = r6
            r6 = r7
            r7 = r8
            r8 = r9
        L_0x00e6:
            r9 = r23
            goto L_0x02fc
        L_0x00ea:
            java.lang.Object r0 = r1.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r26)
            goto L_0x0111
        L_0x00f2:
            kotlin.ResultKt.throwOnFailure(r26)
            java.lang.Object r0 = r1.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            com.tal.thinkacademy.networkprobe.NetProbe r6 = r1.this$0
            java.lang.String r7 = "repeatRequest start"
            r6.log(r4, r7)
            com.tal.thinkacademy.networkprobe.cache.TraceEventCache r6 = com.tal.thinkacademy.networkprobe.cache.TraceEventCache.INSTANCE
            r7 = r1
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r1.L$0 = r0
            r8 = 1
            r1.label = r8
            java.lang.Object r6 = r6.clear(r7)
            if (r6 != r2) goto L_0x0111
            return r2
        L_0x0111:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            int r13 = r1.$repeatCount
            com.tal.thinkacademy.networkprobe.NetProbe r14 = r1.this$0
            java.lang.String r15 = r1.$host
            java.lang.String r12 = r1.$path
            java.util.Map<java.lang.String, java.lang.String> r11 = r1.$params
            r10 = r3
        L_0x0121:
            if (r10 >= r13) goto L_0x015a
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getDefault()
            r16 = r7
            kotlin.coroutines.CoroutineContext r16 = (kotlin.coroutines.CoroutineContext) r16
            r17 = 0
            com.tal.thinkacademy.networkprobe.NetProbe$repeatRequest$2$1$1 r18 = new com.tal.thinkacademy.networkprobe.NetProbe$repeatRequest$2$1$1
            r19 = 0
            r7 = r18
            r8 = r14
            r9 = r15
            r20 = r10
            r10 = r12
            r21 = r11
            r22 = r12
            r12 = r19
            r7.<init>(r8, r9, r10, r11, r12)
            r10 = r18
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r11 = 2
            r12 = 0
            r7 = r0
            r8 = r16
            r9 = r17
            kotlinx.coroutines.Deferred r7 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r7, r8, r9, r10, r11, r12)
            r6.add(r7)
            int r10 = r20 + 1
            r11 = r21
            r12 = r22
            goto L_0x0121
        L_0x015a:
            com.tal.thinkacademy.networkprobe.data.NetProbeResult r0 = new com.tal.thinkacademy.networkprobe.data.NetProbeResult
            java.lang.String r7 = r1.$host
            int r8 = r1.$repeatCount
            r0.<init>(r7, r8)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            com.tal.thinkacademy.networkprobe.NetProbe r7 = r1.this$0
            java.lang.String r8 = r1.$host
            java.util.Iterator r6 = r6.iterator()
            r9 = r1
            r23 = r2
            r2 = r0
            r0 = r3
            r3 = r23
            r24 = r8
            r8 = r7
            r7 = r24
        L_0x0179:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto L_0x0355
            java.lang.Object r10 = r6.next()
            int r11 = r0 + 1
            if (r0 >= 0) goto L_0x018a
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x018a:
            kotlinx.coroutines.Deferred r10 = (kotlinx.coroutines.Deferred) r10
            boolean r0 = r8.isCanceled
            if (r0 == 0) goto L_0x01c6
            java.lang.String r0 = "repeat 已取消: "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r7)
            r8.log(r4, r0)
            com.tal.thinkacademy.networkprobe.NetProbe$CallHolder r0 = r8.mHolder
            if (r0 != 0) goto L_0x01a2
            goto L_0x01c5
        L_0x01a2:
            kotlin.jvm.functions.Function1 r0 = r0.getMCancelBlock$networkprobe_release()
            if (r0 != 0) goto L_0x01a9
            goto L_0x01c5
        L_0x01a9:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "重复执行 次数"
            r3.append(r4)
            r3.append(r11)
            r4 = 32
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r0.invoke(r3)
        L_0x01c5:
            return r2
        L_0x01c6:
            r9.L$0 = r2     // Catch:{ Exception -> 0x02f1 }
            r9.L$1 = r8     // Catch:{ Exception -> 0x02f1 }
            r9.L$2 = r7     // Catch:{ Exception -> 0x02f1 }
            r9.L$3 = r6     // Catch:{ Exception -> 0x02f1 }
            r9.L$4 = r5     // Catch:{ Exception -> 0x02f1 }
            r9.L$5 = r5     // Catch:{ Exception -> 0x02f1 }
            r9.L$6 = r5     // Catch:{ Exception -> 0x02f1 }
            r9.I$0 = r11     // Catch:{ Exception -> 0x02f1 }
            r0 = 2
            r9.label = r0     // Catch:{ Exception -> 0x02f1 }
            java.lang.Object r0 = r10.await(r9)     // Catch:{ Exception -> 0x02f1 }
            if (r0 != r3) goto L_0x01e0
            return r3
        L_0x01e0:
            r10 = r2
            r2 = r3
            r3 = r11
        L_0x01e3:
            io.ktor.client.statement.HttpResponse r0 = (io.ktor.client.statement.HttpResponse) r0     // Catch:{ Exception -> 0x02e9 }
            kotlinx.coroutines.sync.Mutex r11 = r8.mutex     // Catch:{ Exception -> 0x02e9 }
            r9.L$0 = r10     // Catch:{ Exception -> 0x02e9 }
            r9.L$1 = r8     // Catch:{ Exception -> 0x02e9 }
            r9.L$2 = r7     // Catch:{ Exception -> 0x02e9 }
            r9.L$3 = r6     // Catch:{ Exception -> 0x02e9 }
            r9.L$4 = r0     // Catch:{ Exception -> 0x02e9 }
            r9.L$5 = r11     // Catch:{ Exception -> 0x02e9 }
            r9.I$0 = r3     // Catch:{ Exception -> 0x02e9 }
            r12 = 3
            r9.label = r12     // Catch:{ Exception -> 0x02e9 }
            java.lang.Object r12 = r11.lock(r5, r9)     // Catch:{ Exception -> 0x02e9 }
            if (r12 != r2) goto L_0x0201
            return r2
        L_0x0201:
            r12 = r10
            r10 = r7
            r7 = r6
            r6 = r0
            r23 = r11
            r11 = r8
            r8 = r23
        L_0x020a:
            io.ktor.client.request.HttpRequest r0 = io.ktor.client.statement.HttpResponseKt.getRequest(r6)     // Catch:{ all -> 0x02db }
            io.ktor.http.Url r0 = r0.getUrl()     // Catch:{ all -> 0x02db }
            io.ktor.http.Parameters r0 = r0.getParameters()     // Catch:{ all -> 0x02db }
            java.lang.String r13 = "x-tal-trace-id"
            java.lang.String r0 = r0.get(r13)     // Catch:{ all -> 0x02db }
            if (r0 != 0) goto L_0x0220
            java.lang.String r0 = "-1"
        L_0x0220:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x02db }
            r13.<init>()     // Catch:{ all -> 0x02db }
            r13.append(r10)     // Catch:{ all -> 0x02db }
            java.lang.String r14 = ", requestId: "
            r13.append(r14)     // Catch:{ all -> 0x02db }
            r13.append(r0)     // Catch:{ all -> 0x02db }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x02db }
            r11.log(r4, r13)     // Catch:{ all -> 0x02db }
            io.ktor.http.HttpStatusCode r6 = r6.getStatus()     // Catch:{ all -> 0x02db }
            com.tal.thinkacademy.networkprobe.cache.TraceEventCache r13 = com.tal.thinkacademy.networkprobe.cache.TraceEventCache.INSTANCE     // Catch:{ all -> 0x02db }
            r9.L$0 = r12     // Catch:{ all -> 0x02db }
            r9.L$1 = r11     // Catch:{ all -> 0x02db }
            r9.L$2 = r10     // Catch:{ all -> 0x02db }
            r9.L$3 = r7     // Catch:{ all -> 0x02db }
            r9.L$4 = r8     // Catch:{ all -> 0x02db }
            r9.L$5 = r6     // Catch:{ all -> 0x02db }
            r9.L$6 = r0     // Catch:{ all -> 0x02db }
            r9.I$0 = r3     // Catch:{ all -> 0x02db }
            r14 = 4
            r9.label = r14     // Catch:{ all -> 0x02db }
            java.lang.Object r13 = r13.get(r0, r9)     // Catch:{ all -> 0x02db }
            if (r13 != r2) goto L_0x0257
            return r2
        L_0x0257:
            com.tal.thinkacademy.networkprobe.cache.NetworkTraceCache r13 = (com.tal.thinkacademy.networkprobe.cache.NetworkTraceCache) r13     // Catch:{ all -> 0x02db }
            if (r13 != 0) goto L_0x025c
            goto L_0x02cc
        L_0x025c:
            boolean r14 = r13.getSuccess()     // Catch:{ all -> 0x02db }
            if (r14 == 0) goto L_0x0267
            long r14 = r13.totalTime()     // Catch:{ all -> 0x02db }
            goto L_0x026f
        L_0x0267:
            com.tal.thinkacademy.networkprobe.NetProbeConfig r14 = r11.mConfig     // Catch:{ all -> 0x02db }
            long r14 = r14.errorTimeMillis()     // Catch:{ all -> 0x02db }
        L_0x026f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x02db }
            r5.<init>()     // Catch:{ all -> 0x02db }
            java.lang.String r1 = "requestId: "
            r5.append(r1)     // Catch:{ all -> 0x02db }
            r5.append(r0)     // Catch:{ all -> 0x02db }
            java.lang.String r0 = ", totalTime: "
            r5.append(r0)     // Catch:{ all -> 0x02db }
            r5.append(r14)     // Catch:{ all -> 0x02db }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x02db }
            r11.log(r4, r0)     // Catch:{ all -> 0x02db }
            com.tal.thinkacademy.networkprobe.data.NetProbeData r0 = r13.createData()     // Catch:{ all -> 0x02db }
            java.lang.String r1 = r6.getDescription()     // Catch:{ all -> 0x02db }
            r0.setErrorMsg(r1)     // Catch:{ all -> 0x02db }
            com.tal.thinkacademy.networkprobe.NetProbe$repeatRequest$2$2$1$1$1$1 r1 = new com.tal.thinkacademy.networkprobe.NetProbe$repeatRequest$2$2$1$1$1$1     // Catch:{ all -> 0x02db }
            r1.<init>(r11, r0)     // Catch:{ all -> 0x02db }
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1     // Catch:{ all -> 0x02db }
            r9.L$0 = r12     // Catch:{ all -> 0x02db }
            r9.L$1 = r11     // Catch:{ all -> 0x02db }
            r9.L$2 = r10     // Catch:{ all -> 0x02db }
            r9.L$3 = r7     // Catch:{ all -> 0x02db }
            r9.L$4 = r8     // Catch:{ all -> 0x02db }
            r5 = 0
            r9.L$5 = r5     // Catch:{ all -> 0x02db }
            r9.L$6 = r5     // Catch:{ all -> 0x02db }
            r9.I$0 = r3     // Catch:{ all -> 0x02db }
            r9.J$0 = r14     // Catch:{ all -> 0x02db }
            r0 = 5
            r9.label = r0     // Catch:{ all -> 0x02db }
            java.lang.Object r0 = r11.withMainContext(r1, r9)     // Catch:{ all -> 0x02db }
            if (r0 != r2) goto L_0x02ba
            return r2
        L_0x02ba:
            r1 = r7
            r6 = r14
        L_0x02bc:
            java.util.ArrayList r0 = r12.getDurationArray()     // Catch:{ all -> 0x02d8 }
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)     // Catch:{ all -> 0x02d8 }
            boolean r0 = r0.add(r5)     // Catch:{ all -> 0x02d8 }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch:{ all -> 0x02d8 }
            r7 = r1
        L_0x02cc:
            r1 = 0
            r8.unlock(r1)     // Catch:{ Exception -> 0x02e1 }
            r0 = r3
            r6 = r7
            r7 = r10
            r8 = r11
            r3 = r2
            r2 = r12
            goto L_0x0350
        L_0x02d8:
            r0 = move-exception
            r7 = r1
            goto L_0x02dc
        L_0x02db:
            r0 = move-exception
        L_0x02dc:
            r1 = 0
            r8.unlock(r1)     // Catch:{ Exception -> 0x02e1 }
            throw r0     // Catch:{ Exception -> 0x02e1 }
        L_0x02e1:
            r0 = move-exception
            r1 = r0
            r0 = r3
            r3 = r7
            r6 = r10
            r7 = r11
            r8 = r12
            goto L_0x02fc
        L_0x02e9:
            r0 = move-exception
            r1 = r0
            r0 = r3
            r3 = r6
            r6 = r7
            r7 = r8
            r8 = r10
            goto L_0x02fc
        L_0x02f1:
            r0 = move-exception
            r1 = r0
            r0 = r11
            r23 = r8
            r8 = r2
            r2 = r3
            r3 = r6
            r6 = r7
            r7 = r23
        L_0x02fc:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r6)
            java.lang.String r10 = ", 接口异常: "
            r5.append(r10)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            r7.log(r4, r5)
            com.tal.thinkacademy.networkprobe.NetProbe$repeatRequest$2$2$2 r5 = new com.tal.thinkacademy.networkprobe.NetProbe$repeatRequest$2$2$2
            r5.<init>(r7, r6, r1)
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r9.L$0 = r8
            r9.L$1 = r7
            r9.L$2 = r6
            r9.L$3 = r3
            r1 = 0
            r9.L$4 = r1
            r9.L$5 = r1
            r9.L$6 = r1
            r9.I$0 = r0
            r1 = 6
            r9.label = r1
            java.lang.Object r1 = r7.withMainContext(r5, r9)
            if (r1 != r2) goto L_0x0335
            return r2
        L_0x0335:
            java.util.ArrayList r1 = r8.getDurationArray()
            com.tal.thinkacademy.networkprobe.NetProbeConfig r5 = r7.mConfig
            long r10 = r5.errorTimeMillis()
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r10)
            r1.add(r5)
            r23 = r3
            r3 = r2
            r2 = r8
            r8 = r7
            r7 = r6
            r6 = r23
        L_0x0350:
            r1 = r25
            r5 = 0
            goto L_0x0179
        L_0x0355:
            com.tal.thinkacademy.networkprobe.cache.TraceEventCache r0 = com.tal.thinkacademy.networkprobe.cache.TraceEventCache.INSTANCE
            r1 = r9
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r9.L$0 = r2
            r4 = 0
            r9.L$1 = r4
            r9.L$2 = r4
            r9.L$3 = r4
            r9.L$4 = r4
            r9.L$5 = r4
            r9.L$6 = r4
            r4 = 7
            r9.label = r4
            java.lang.Object r0 = r0.clear(r1)
            if (r0 != r3) goto L_0x0373
            return r3
        L_0x0373:
            r0 = r2
        L_0x0374:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.thinkacademy.networkprobe.NetProbe$repeatRequest$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
