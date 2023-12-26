package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent$requestHistoryMsg$2", f = "GraffitiAgent.kt", i = {}, l = {299}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GraffitiAgent.kt */
final class GraffitiAgent$requestHistoryMsg$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $pageId;
    final /* synthetic */ Map<String, Long> $params;
    int label;
    final /* synthetic */ GraffitiAgent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraffitiAgent$requestHistoryMsg$2(GraffitiAgent graffitiAgent, String str, Map<String, Long> map, Continuation<? super GraffitiAgent$requestHistoryMsg$2> continuation) {
        super(2, continuation);
        this.this$0 = graffitiAgent;
        this.$pageId = str;
        this.$params = map;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new GraffitiAgent$requestHistoryMsg$2(this.this$0, this.$pageId, this.$params, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent$requestHistoryMsg$2$1", f = "GraffitiAgent.kt", i = {0, 0, 0}, l = {313, 340}, m = "invokeSuspend", n = {"allList", "key", "loadHistoryTime"}, s = {"L$0", "L$4", "J$0"})
    /* renamed from: com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent$requestHistoryMsg$2$1  reason: invalid class name */
    /* compiled from: GraffitiAgent.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> r0 = new AnonymousClass1(graffitiAgent, str, map, continuation);
            r0.L$0 = obj;
            return (Continuation) r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v5, resolved type: kotlin.coroutines.Continuation} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: kotlin.coroutines.Continuation} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: java.util.Iterator} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.util.Vector} */
        /* JADX WARNING: Can't wrap try/catch for region: R(15:7|(3:8|9|10)|(1:26)|27|(7:36|37|38|39|40|41|57)(4:29|40|41|57)|30|32|34|36|37|38|39|40|41|57) */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0188, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0189, code lost:
            r14 = r30;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00eb  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0124 A[Catch:{ all -> 0x018c }] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x014d A[Catch:{ all -> 0x018c }] */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x019d  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0220  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x022f  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x025b A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r30) {
            /*
                r29 = this;
                r1 = r29
                java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r1.label
                r3 = 2
                r4 = 0
                r5 = 1
                if (r0 == 0) goto L_0x0045
                if (r0 == r5) goto L_0x001e
                if (r0 != r3) goto L_0x0016
                kotlin.ResultKt.throwOnFailure(r30)
                goto L_0x025c
            L_0x0016:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x001e:
                long r6 = r1.J$0
                java.lang.Object r0 = r1.L$4
                r8 = r0
                java.lang.String r8 = (java.lang.String) r8
                java.lang.Object r0 = r1.L$3
                r9 = r0
                java.util.Iterator r9 = (java.util.Iterator) r9
                java.lang.Object r0 = r1.L$2
                r10 = r0
                java.lang.String r10 = (java.lang.String) r10
                java.lang.Object r0 = r1.L$1
                r11 = r0
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent r11 = (com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent) r11
                java.lang.Object r0 = r1.L$0
                r12 = r0
                java.util.Vector r12 = (java.util.Vector) r12
                kotlin.ResultKt.throwOnFailure(r30)     // Catch:{ all -> 0x0041 }
                r0 = r30
                r14 = r1
                goto L_0x011a
            L_0x0041:
                r0 = move-exception
                r14 = r1
                goto L_0x0199
            L_0x0045:
                kotlin.ResultKt.throwOnFailure(r30)
                java.lang.Object r0 = r1.L$0
                kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent r6 = r1
                java.lang.Object[] r7 = new java.lang.Object[r5]
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = "增量查询当前页所有相关的dbkey涂鸦，pageId = "
                r8.append(r9)
                java.lang.String r9 = r3
                r8.append(r9)
                java.lang.String r9 = " , params = "
                r8.append(r9)
                java.util.Map<java.lang.String, java.lang.Long> r9 = r4
                r8.append(r9)
                java.lang.String r8 = r8.toString()
                r7[r4] = r8
                r6.log(r7)
                long r12 = android.os.SystemClock.elapsedRealtime()
                java.util.Vector r14 = new java.util.Vector
                r14.<init>()
                java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
                r6.<init>()
                r15 = r6
                java.util.Map r15 = (java.util.Map) r15
                java.util.Map<java.lang.String, java.lang.Long> r6 = r4
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent r11 = r1
                java.util.Set r6 = r6.entrySet()
                java.util.Iterator r22 = r6.iterator()
            L_0x008f:
                boolean r6 = r22.hasNext()
                if (r6 == 0) goto L_0x00d5
                java.lang.Object r6 = r22.next()
                java.util.Map$Entry r6 = (java.util.Map.Entry) r6
                java.lang.Object r7 = r6.getKey()
                r10 = r7
                java.lang.String r10 = (java.lang.String) r10
                java.lang.Object r6 = r6.getValue()
                java.lang.Number r6 = (java.lang.Number) r6
                long r19 = r6.longValue()
                r7 = 0
                r8 = 0
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent$requestHistoryMsg$2$1$1$task$1 r6 = new com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent$requestHistoryMsg$2$1$1$task$1
                r21 = 0
                r16 = r6
                r17 = r11
                r18 = r10
                r16.<init>(r17, r18, r19, r21)
                r9 = r6
                kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
                r16 = 3
                r17 = 0
                r6 = r0
                r3 = r10
                r10 = r16
                r16 = r11
                r11 = r17
                kotlinx.coroutines.Deferred r6 = kotlinx.coroutines.BuildersKt.async$default(r6, r7, r8, r9, r10, r11)
                r15.put(r3, r6)
                r11 = r16
                r3 = 2
                goto L_0x008f
            L_0x00d5:
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent r0 = r1
                java.lang.String r3 = r3
                java.util.Set r6 = r15.entrySet()
                java.util.Iterator r6 = r6.iterator()
                r7 = r0
                r9 = r12
                r11 = r14
                r14 = r1
            L_0x00e5:
                boolean r0 = r6.hasNext()
                if (r0 == 0) goto L_0x022f
                java.lang.Object r0 = r6.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r8 = r0.getKey()
                java.lang.String r8 = (java.lang.String) r8
                java.lang.Object r0 = r0.getValue()
                kotlinx.coroutines.Deferred r0 = (kotlinx.coroutines.Deferred) r0
                r14.L$0 = r11     // Catch:{ all -> 0x0190 }
                r14.L$1 = r7     // Catch:{ all -> 0x0190 }
                r14.L$2 = r3     // Catch:{ all -> 0x0190 }
                r14.L$3 = r6     // Catch:{ all -> 0x0190 }
                r14.L$4 = r8     // Catch:{ all -> 0x0190 }
                r14.J$0 = r9     // Catch:{ all -> 0x0190 }
                r14.label = r5     // Catch:{ all -> 0x0190 }
                java.lang.Object r0 = r0.await(r14)     // Catch:{ all -> 0x0190 }
                if (r0 != r2) goto L_0x0112
                return r2
            L_0x0112:
                r12 = r11
                r11 = r7
                r27 = r9
                r10 = r3
                r9 = r6
                r6 = r27
            L_0x011a:
                java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x018c }
                java.lang.Object r3 = kotlin.collections.CollectionsKt.lastOrNull(r0)     // Catch:{ all -> 0x018c }
                com.xueersi.lib.graffiti.WXWBAction r3 = (com.xueersi.lib.graffiti.WXWBAction) r3     // Catch:{ all -> 0x018c }
                if (r3 != 0) goto L_0x0127
            L_0x0124:
                r30 = r14
                goto L_0x0179
            L_0x0127:
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.Mode r13 = r11.mMode     // Catch:{ all -> 0x018c }
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.Mode r15 = com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.Mode.PLAYBACK     // Catch:{ all -> 0x018c }
                if (r13 == r15) goto L_0x0124
                java.lang.String r13 = r11.getMUid()     // Catch:{ all -> 0x018c }
                java.lang.CharSequence r13 = (java.lang.CharSequence) r13     // Catch:{ all -> 0x018c }
                java.lang.String r15 = r3.getUid()     // Catch:{ all -> 0x018c }
                java.lang.CharSequence r15 = (java.lang.CharSequence) r15     // Catch:{ all -> 0x018c }
                boolean r13 = android.text.TextUtils.equals(r13, r15)     // Catch:{ all -> 0x018c }
                if (r13 == 0) goto L_0x0124
                long r15 = r3.getMsgId()     // Catch:{ all -> 0x018c }
                long r19 = r11.getMLastSendMsgId()     // Catch:{ all -> 0x018c }
                int r13 = (r15 > r19 ? 1 : (r15 == r19 ? 0 : -1))
                if (r13 < 0) goto L_0x0124
                long r4 = r3.getMsgId()     // Catch:{ all -> 0x018c }
                r11.setMLastSendMsgId(r4)     // Catch:{ all -> 0x018c }
                r3 = 1
                java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x018c }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x018c }
                r3.<init>()     // Catch:{ all -> 0x018c }
                java.lang.String r5 = "更新 最后一次发送的msgIg是 "
                r3.append(r5)     // Catch:{ all -> 0x018c }
                r30 = r14
                long r13 = r11.getMLastSendMsgId()     // Catch:{ all -> 0x0188 }
                r3.append(r13)     // Catch:{ all -> 0x0188 }
                java.lang.String r13 = " , -1表示未发送过"
                r3.append(r13)     // Catch:{ all -> 0x0188 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0188 }
                r5 = 0
                r4[r5] = r3     // Catch:{ all -> 0x0188 }
                r11.log(r4)     // Catch:{ all -> 0x0188 }
            L_0x0179:
                java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x0188 }
                r12.addAll(r0)     // Catch:{ all -> 0x0188 }
                r14 = r30
                r4 = r6
                r6 = r9
                r7 = r11
                r11 = r12
                r3 = 1
                r8 = 0
                goto L_0x0226
            L_0x0188:
                r0 = move-exception
                r14 = r30
                goto L_0x0199
            L_0x018c:
                r0 = move-exception
                r30 = r14
                goto L_0x0199
            L_0x0190:
                r0 = move-exception
                r12 = r11
                r11 = r7
                r27 = r9
                r10 = r3
                r9 = r6
                r6 = r27
            L_0x0199:
                boolean r3 = r0 instanceof java.util.concurrent.CancellationException
                if (r3 != 0) goto L_0x0220
                boolean r3 = r0 instanceof com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.HistoryLoadException
                java.lang.String r4 = "获取历史数据异常 dbkey = "
                if (r3 == 0) goto L_0x01e3
                r3 = r0
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.HistoryLoadException r3 = (com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.HistoryLoadException) r3
                java.lang.String r22 = r3.getInfo()
                java.lang.String r23 = r3.getUrl()
                java.lang.String r24 = r3.getParams()
                r19 = r11
                r20 = r10
                r21 = r8
                r19.upLoadHistoryException(r20, r21, r22, r23, r24)
                r5 = 1
                java.lang.Object[] r15 = new java.lang.Object[r5]
                r5 = r15
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                r13.append(r4)
                r13.append(r8)
                java.lang.String r4 = " , info = "
                r13.append(r4)
                java.lang.String r3 = r3.getInfo()
                r13.append(r3)
                java.lang.String r3 = r13.toString()
                r4 = 0
                r5[r4] = r3
                r11.log(r5)
                r3 = 1
                r8 = 0
                goto L_0x021c
            L_0x01e3:
                java.lang.String r22 = r0.getMessage()
                r23 = 0
                r24 = 0
                r25 = 24
                r26 = 0
                r19 = r11
                r20 = r10
                r21 = r8
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent.upLoadHistoryException$default(r19, r20, r21, r22, r23, r24, r25, r26)
                r3 = 1
                java.lang.Object[] r5 = new java.lang.Object[r3]
                java.lang.StringBuilder r15 = new java.lang.StringBuilder
                r15.<init>()
                r15.append(r4)
                r15.append(r8)
                java.lang.String r4 = " , msg = "
                r15.append(r4)
                java.lang.String r4 = r0.getMessage()
                r15.append(r4)
                java.lang.String r4 = r15.toString()
                r8 = 0
                r5[r8] = r4
                r11.log(r5)
            L_0x021c:
                r0.printStackTrace()
                goto L_0x0222
            L_0x0220:
                r3 = 1
                r8 = 0
            L_0x0222:
                r4 = r6
                r6 = r9
                r7 = r11
                r11 = r12
            L_0x0226:
                r27 = r4
                r5 = r3
                r4 = r8
                r3 = r10
                r9 = r27
                goto L_0x00e5
            L_0x022f:
                kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent$requestHistoryMsg$2$1$3 r3 = new com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent$requestHistoryMsg$2$1$3
                java.lang.String r7 = r3
                com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent r8 = r1
                java.util.Map<java.lang.String, java.lang.Long> r12 = r4
                r13 = 0
                r6 = r3
                r6.<init>(r7, r8, r9, r11, r12, r13)
                kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                r4 = r14
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r5 = 0
                r14.L$0 = r5
                r14.L$1 = r5
                r14.L$2 = r5
                r14.L$3 = r5
                r14.L$4 = r5
                r5 = 2
                r14.label = r5
                java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r0, r3, r4)
                if (r0 != r2) goto L_0x025c
                return r2
            L_0x025c:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent$requestHistoryMsg$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final GraffitiAgent graffitiAgent = this.this$0;
            final String str = this.$pageId;
            final Map<String, Long> map = this.$params;
            this.label = 1;
            if (SupervisorKt.supervisorScope(new AnonymousClass1((Continuation<? super AnonymousClass1>) null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
