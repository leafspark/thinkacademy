package com.tal.app.thinkacademy.common.network;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/common/network/NetData;", "", "()V", "transform", "T", "response", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "(Lcom/tal/app/thinkacademy/lib/restful/HiResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetData.kt */
public final class NetData {
    public static final NetData INSTANCE = new NetData();

    private NetData() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.lang.Object transform(com.tal.app.thinkacademy.lib.restful.HiResponse<T> r6, kotlin.coroutines.Continuation<? super T> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.tal.app.thinkacademy.common.network.NetData$transform$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.tal.app.thinkacademy.common.network.NetData$transform$1 r0 = (com.tal.app.thinkacademy.common.network.NetData$transform$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.common.network.NetData$transform$1 r0 = new com.tal.app.thinkacademy.common.network.NetData$transform$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r6 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0068
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            com.tal.app.thinkacademy.common.network.NetData$transform$2 r2 = new com.tal.app.thinkacademy.common.network.NetData$transform$2
            r4 = 0
            r2.<init>(r6, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.flow(r2)
            com.tal.app.thinkacademy.common.network.NetData$transform$$inlined$transform$1 r2 = new com.tal.app.thinkacademy.common.network.NetData$transform$$inlined$transform$1
            r2.<init>(r6, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.flow(r2)
            com.tal.app.thinkacademy.common.network.NetData$transform$4 r2 = new com.tal.app.thinkacademy.common.network.NetData$transform$4
            r2.<init>(r7)
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r6 = r6.collect(r2, r0)
            if (r6 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r6 = r7
        L_0x0068:
            java.lang.Object r6 = r6.element
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.network.NetData.transform(com.tal.app.thinkacademy.lib.restful.HiResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
