package com.tal.app.thinkacademy.common.network;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@¨\u0006\u0005"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.common.network.NetData$transform$$inlined$transform$1", f = "NetData.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Emitters.kt */
public final class NetData$transform$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetData$transform$$inlined$transform$1(Flow flow, Continuation continuation) {
        super(2, continuation);
        this.$this_transform = flow;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> netData$transform$$inlined$transform$1 = new NetData$transform$$inlined$transform$1(this.$this_transform, continuation);
        netData$transform$$inlined$transform$1.L$0 = obj;
        return (Continuation) netData$transform$$inlined$transform$1;
    }

    public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final FlowCollector flowCollector = (FlowCollector) this.L$0;
            this.label = 1;
            if (this.$this_transform.collect(new FlowCollector() {
                /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(T r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.tal.app.thinkacademy.common.network.NetData$transform$$inlined$transform$1.AnonymousClass1.AnonymousClass1
                        if (r0 == 0) goto L_0x0014
                        r0 = r7
                        com.tal.app.thinkacademy.common.network.NetData$transform$$inlined$transform$1$1$1 r0 = (com.tal.app.thinkacademy.common.network.NetData$transform$$inlined$transform$1.AnonymousClass1.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L_0x0014
                        int r7 = r0.label
                        int r7 = r7 - r2
                        r0.label = r7
                        goto L_0x0019
                    L_0x0014:
                        com.tal.app.thinkacademy.common.network.NetData$transform$$inlined$transform$1$1$1 r0 = new com.tal.app.thinkacademy.common.network.NetData$transform$$inlined$transform$1$1$1
                        r0.<init>(r5, r7)
                    L_0x0019:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L_0x0033
                        if (r2 != r3) goto L_0x002b
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L_0x00a9
                    L_0x002b:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L_0x0033:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector<T> r7 = r5
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        com.tal.app.thinkacademy.lib.restful.HiResponse r6 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r6
                        java.io.PrintStream r2 = java.lang.System.out
                        java.lang.Thread r4 = java.lang.Thread.currentThread()
                        java.lang.String r4 = r4.getName()
                        r2.println(r4)
                        boolean r2 = r6.successful()
                        if (r2 == 0) goto L_0x00ac
                        int r2 = r6.getCode()
                        if (r2 == 0) goto L_0x009c
                        r7 = 9
                        if (r2 == r7) goto L_0x006d
                        com.tal.app.thinkacademy.lib.network.exception.HandlerException$BusinessThrowable r7 = new com.tal.app.thinkacademy.lib.network.exception.HandlerException$BusinessThrowable
                        com.tal.app.thinkacademy.lib.network.exception.HandlerException r0 = new com.tal.app.thinkacademy.lib.network.exception.HandlerException
                        r0.<init>()
                        int r1 = r6.getCode()
                        java.lang.String r6 = r6.getMsg()
                        r7.<init>(r0, r1, r6)
                        throw r7
                    L_0x006d:
                        android.os.Bundle r7 = new android.os.Bundle
                        r7.<init>()
                        java.lang.String r0 = "isToken"
                        r7.putBoolean(r0, r3)
                        java.lang.String r0 = r6.getMsg()
                        java.lang.String r1 = "message"
                        r7.putString(r1, r0)
                        com.tal.app.thinkacademy.lib.route.XesRoute r0 = com.tal.app.thinkacademy.lib.route.XesRoute.getInstance()
                        java.lang.String r1 = "/home/main_activity"
                        r0.navigation(r1, r7)
                        com.tal.app.thinkacademy.lib.network.exception.HandlerException$BusinessThrowable r7 = new com.tal.app.thinkacademy.lib.network.exception.HandlerException$BusinessThrowable
                        com.tal.app.thinkacademy.lib.network.exception.HandlerException r0 = new com.tal.app.thinkacademy.lib.network.exception.HandlerException
                        r0.<init>()
                        int r1 = r6.getCode()
                        java.lang.String r6 = r6.getMsg()
                        r7.<init>(r0, r1, r6)
                        throw r7
                    L_0x009c:
                        java.lang.Object r6 = r6.getData()
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L_0x00a9
                        return r1
                    L_0x00a9:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    L_0x00ac:
                        com.tal.app.thinkacademy.lib.network.exception.HandlerException$BusinessThrowable r7 = new com.tal.app.thinkacademy.lib.network.exception.HandlerException$BusinessThrowable
                        com.tal.app.thinkacademy.lib.network.exception.HandlerException r0 = new com.tal.app.thinkacademy.lib.network.exception.HandlerException
                        r0.<init>()
                        int r1 = r6.getCode()
                        java.lang.String r6 = r6.getMsg()
                        r7.<init>(r0, r1, r6)
                        throw r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.network.NetData$transform$$inlined$transform$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }, (Continuation) this) == coroutine_suspended) {
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
