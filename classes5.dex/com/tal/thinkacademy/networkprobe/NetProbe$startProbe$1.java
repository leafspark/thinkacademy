package com.tal.thinkacademy.networkprobe;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1", f = "NetProbe.kt", i = {2, 2}, l = {92, 101, 108, 114, 122, 128, 132}, m = "invokeSuspend", n = {"key", "resultList"}, s = {"L$4", "L$5"})
/* compiled from: NetProbe.kt */
final class NetProbe$startProbe$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, List<String>> $hostGroup;
    final /* synthetic */ Map<String, String> $params;
    final /* synthetic */ String $path;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ NetProbe this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetProbe$startProbe$1(NetProbe netProbe, Map<String, ? extends List<String>> map, String str, Map<String, String> map2, Continuation<? super NetProbe$startProbe$1> continuation) {
        super(2, continuation);
        this.this$0 = netProbe;
        this.$hostGroup = map;
        this.$path = str;
        this.$params = map2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new NetProbe$startProbe$1(this.this$0, this.$hostGroup, this.$path, this.$params, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0093, code lost:
        if (r2.hasNext() == false) goto L_0x01a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0095, code lost:
        r10 = r2.next();
        r11 = (java.lang.String) r10.getKey();
        r10 = (java.util.List) r10.getValue();
        r12 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00b0, code lost:
        if (r6.isCanceled == false) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00b2, code lost:
        r6.log("NetProbe", "probe 已取消1");
        r9.L$0 = null;
        r9.L$1 = null;
        r9.L$2 = null;
        r9.L$3 = null;
        r9.label = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00cc, code lost:
        if (r6.withMainContext(new com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$1$1(r6, r10), r9) != r1) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ce, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00d1, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d2, code lost:
        r19 = r6;
        r6 = r2;
        r2 = r10.iterator();
        r10 = r9;
        r9 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00e3, code lost:
        if (r2.hasNext() == false) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e5, code lost:
        r14 = (java.lang.String) r2.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00f0, code lost:
        if (r9.isCanceled == false) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f2, code lost:
        r9.log("NetProbe", "probe 已取消2");
        r10.L$0 = null;
        r10.L$1 = null;
        r10.L$2 = null;
        r10.L$3 = null;
        r10.L$4 = null;
        r10.L$5 = null;
        r10.L$6 = null;
        r10.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0113, code lost:
        if (r9.withMainContext(new com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$1$2$1(r9, r14), r10) != r1) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0115, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0118, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0119, code lost:
        r17 = r9.mConfig.repeatCount();
        r10.L$0 = r9;
        r10.L$1 = r7;
        r10.L$2 = r8;
        r10.L$3 = r6;
        r10.L$4 = r11;
        r10.L$5 = r12;
        r10.L$6 = r2;
        r10.label = 3;
        r13 = r9.repeatRequest(r14, r7, r8, r17, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x013c, code lost:
        if (r13 != r1) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x013e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x013f, code lost:
        r12.add((com.tal.thinkacademy.networkprobe.data.NetProbeResult) r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0149, code lost:
        if (r9.isCanceled == false) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x014b, code lost:
        r9.log("NetProbe", "probe 已取消3");
        r10.L$0 = null;
        r10.L$1 = null;
        r10.L$2 = null;
        r10.L$3 = null;
        r10.L$4 = null;
        r10.L$5 = null;
        r10.L$6 = null;
        r10.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x016c, code lost:
        if (r9.withMainContext(new com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$1$3(r9), r10) != r1) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x016e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0171, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0172, code lost:
        r2 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0179, code lost:
        if (r2.size() <= 1) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x017b, code lost:
        kotlin.collections.CollectionsKt.sortWith(r2, new com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$invokeSuspend$lambda3$$inlined$sortBy$1());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0185, code lost:
        r10.L$0 = r9;
        r10.L$1 = r7;
        r10.L$2 = r8;
        r10.L$3 = r6;
        r10.L$4 = null;
        r10.L$5 = null;
        r10.L$6 = null;
        r10.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01a1, code lost:
        if (r9.withMainContext(new com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$1$5(r9, r11, r12), r10) != r1) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01a3, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01a4, code lost:
        r2 = r6;
        r6 = r9;
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01af, code lost:
        if (r9.this$0.isCanceled == false) goto L_0x01d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01b1, code lost:
        r9.this$0.log("NetProbe", "probe 已取消4");
        r2 = r9.this$0;
        r4 = r9.this$0;
        r9.L$0 = null;
        r9.L$1 = null;
        r9.L$2 = null;
        r9.L$3 = null;
        r9.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01d5, code lost:
        if (r2.withMainContext(new com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1.AnonymousClass2(), r9) != r1) goto L_0x01d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01d7, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01d8, code lost:
        r2 = r9.this$0;
        r4 = r9.this$0;
        r9.L$0 = null;
        r9.L$1 = null;
        r9.L$2 = null;
        r9.L$3 = null;
        r9.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01f5, code lost:
        if (r2.withMainContext(new com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1.AnonymousClass3(), r9) != r1) goto L_0x01f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01f7, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01fa, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "NetProbe"
            r5 = 0
            switch(r2) {
                case 0: goto L_0x0074;
                case 1: goto L_0x0070;
                case 2: goto L_0x006b;
                case 3: goto L_0x0041;
                case 4: goto L_0x003c;
                case 5: goto L_0x0022;
                case 6: goto L_0x001c;
                case 7: goto L_0x0017;
                default: goto L_0x000f;
            }
        L_0x000f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r21)
            goto L_0x01f8
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r21)
            r9 = r0
            goto L_0x01d8
        L_0x0022:
            java.lang.Object r2 = r0.L$3
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r6 = r0.L$2
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.L$0
            com.tal.thinkacademy.networkprobe.NetProbe r8 = (com.tal.thinkacademy.networkprobe.NetProbe) r8
            kotlin.ResultKt.throwOnFailure(r21)
            r9 = r0
            r19 = r8
            r8 = r6
            r6 = r19
            goto L_0x008f
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r21)
            goto L_0x016f
        L_0x0041:
            java.lang.Object r2 = r0.L$6
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r6 = r0.L$5
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            java.lang.Object r7 = r0.L$4
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.L$3
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$2
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r10 = r0.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r0.L$0
            com.tal.thinkacademy.networkprobe.NetProbe r11 = (com.tal.thinkacademy.networkprobe.NetProbe) r11
            kotlin.ResultKt.throwOnFailure(r21)
            r13 = r21
            r12 = r6
            r6 = r8
            r8 = r9
            r9 = r11
            r11 = r7
            r7 = r10
            r10 = r0
            goto L_0x013f
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r21)
            goto L_0x0116
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r21)
            goto L_0x00cf
        L_0x0074:
            kotlin.ResultKt.throwOnFailure(r21)
            com.tal.thinkacademy.networkprobe.NetProbe r2 = r0.this$0
            java.lang.String r6 = "probe start"
            r2.log(r4, r6)
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r2 = r0.$hostGroup
            com.tal.thinkacademy.networkprobe.NetProbe r6 = r0.this$0
            java.lang.String r7 = r0.$path
            java.util.Map<java.lang.String, java.lang.String> r8 = r0.$params
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
            r9 = r0
        L_0x008f:
            boolean r10 = r2.hasNext()
            if (r10 == 0) goto L_0x01a9
            java.lang.Object r10 = r2.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r11 = r10.getKey()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r10 = r10.getValue()
            java.util.List r10 = (java.util.List) r10
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            boolean r13 = r6.isCanceled
            if (r13 == 0) goto L_0x00d2
            java.lang.String r2 = "probe 已取消1"
            r6.log(r4, r2)
            com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$1$1 r2 = new com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$1$1
            r2.<init>(r6, r10)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r9.L$0 = r5
            r9.L$1 = r5
            r9.L$2 = r5
            r9.L$3 = r5
            r9.label = r3
            java.lang.Object r2 = r6.withMainContext(r2, r9)
            if (r2 != r1) goto L_0x00cf
            return r1
        L_0x00cf:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00d2:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
            r19 = r6
            r6 = r2
            r2 = r10
            r10 = r9
            r9 = r19
        L_0x00df:
            boolean r13 = r2.hasNext()
            if (r13 == 0) goto L_0x0145
            java.lang.Object r13 = r2.next()
            r14 = r13
            java.lang.String r14 = (java.lang.String) r14
            boolean r13 = r9.isCanceled
            if (r13 == 0) goto L_0x0119
            java.lang.String r2 = "probe 已取消2"
            r9.log(r4, r2)
            com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$1$2$1 r2 = new com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$1$2$1
            r2.<init>(r9, r14)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r10.L$0 = r5
            r10.L$1 = r5
            r10.L$2 = r5
            r10.L$3 = r5
            r10.L$4 = r5
            r10.L$5 = r5
            r10.L$6 = r5
            r3 = 2
            r10.label = r3
            java.lang.Object r2 = r9.withMainContext(r2, r10)
            if (r2 != r1) goto L_0x0116
            return r1
        L_0x0116:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0119:
            com.tal.thinkacademy.networkprobe.NetProbeConfig r13 = r9.mConfig
            int r17 = r13.repeatCount()
            r10.L$0 = r9
            r10.L$1 = r7
            r10.L$2 = r8
            r10.L$3 = r6
            r10.L$4 = r11
            r10.L$5 = r12
            r10.L$6 = r2
            r13 = 3
            r10.label = r13
            r13 = r9
            r15 = r7
            r16 = r8
            r18 = r10
            java.lang.Object r13 = r13.repeatRequest(r14, r15, r16, r17, r18)
            if (r13 != r1) goto L_0x013f
            return r1
        L_0x013f:
            com.tal.thinkacademy.networkprobe.data.NetProbeResult r13 = (com.tal.thinkacademy.networkprobe.data.NetProbeResult) r13
            r12.add(r13)
            goto L_0x00df
        L_0x0145:
            boolean r2 = r9.isCanceled
            if (r2 == 0) goto L_0x0172
            java.lang.String r2 = "probe 已取消3"
            r9.log(r4, r2)
            com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$1$3 r2 = new com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$1$3
            r2.<init>(r9)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r10.L$0 = r5
            r10.L$1 = r5
            r10.L$2 = r5
            r10.L$3 = r5
            r10.L$4 = r5
            r10.L$5 = r5
            r10.L$6 = r5
            r3 = 4
            r10.label = r3
            java.lang.Object r2 = r9.withMainContext(r2, r10)
            if (r2 != r1) goto L_0x016f
            return r1
        L_0x016f:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0172:
            r2 = r12
            java.util.List r2 = (java.util.List) r2
            int r13 = r2.size()
            if (r13 <= r3) goto L_0x0185
            com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$invokeSuspend$lambda-3$$inlined$sortBy$1 r13 = new com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$invokeSuspend$lambda-3$$inlined$sortBy$1
            r13.<init>()
            java.util.Comparator r13 = (java.util.Comparator) r13
            kotlin.collections.CollectionsKt.sortWith(r2, r13)
        L_0x0185:
            com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$1$5 r2 = new com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$1$5
            r2.<init>(r9, r11, r12)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r10.L$0 = r9
            r10.L$1 = r7
            r10.L$2 = r8
            r10.L$3 = r6
            r10.L$4 = r5
            r10.L$5 = r5
            r10.L$6 = r5
            r11 = 5
            r10.label = r11
            java.lang.Object r2 = r9.withMainContext(r2, r10)
            if (r2 != r1) goto L_0x01a4
            return r1
        L_0x01a4:
            r2 = r6
            r6 = r9
            r9 = r10
            goto L_0x008f
        L_0x01a9:
            com.tal.thinkacademy.networkprobe.NetProbe r2 = r9.this$0
            boolean r2 = r2.isCanceled
            if (r2 == 0) goto L_0x01d8
            com.tal.thinkacademy.networkprobe.NetProbe r2 = r9.this$0
            java.lang.String r3 = "probe 已取消4"
            r2.log(r4, r3)
            com.tal.thinkacademy.networkprobe.NetProbe r2 = r9.this$0
            com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$2 r3 = new com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$2
            com.tal.thinkacademy.networkprobe.NetProbe r4 = r9.this$0
            r3.<init>(r4)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r4 = r9
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r9.L$0 = r5
            r9.L$1 = r5
            r9.L$2 = r5
            r9.L$3 = r5
            r6 = 6
            r9.label = r6
            java.lang.Object r2 = r2.withMainContext(r3, r4)
            if (r2 != r1) goto L_0x01d8
            return r1
        L_0x01d8:
            com.tal.thinkacademy.networkprobe.NetProbe r2 = r9.this$0
            com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$3 r3 = new com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1$3
            com.tal.thinkacademy.networkprobe.NetProbe r4 = r9.this$0
            r3.<init>(r4)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r4 = r9
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r9.L$0 = r5
            r9.L$1 = r5
            r9.L$2 = r5
            r9.L$3 = r5
            r5 = 7
            r9.label = r5
            java.lang.Object r2 = r2.withMainContext(r3, r4)
            if (r2 != r1) goto L_0x01f8
            return r1
        L_0x01f8:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.thinkacademy.networkprobe.NetProbe$startProbe$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
