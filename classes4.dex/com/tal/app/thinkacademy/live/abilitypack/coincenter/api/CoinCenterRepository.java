package com.tal.app.thinkacademy.live.abilitypack.coincenter.api;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/coincenter/api/CoinCenterRepository;", "", "()V", "studentCoinAndMedal", "Lcom/tal/app/thinkacademy/live/abilitypack/coincenter/bean/CoinData;", "planId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoinCenterRepository.kt */
public final class CoinCenterRepository {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074 A[PHI: r8 
      PHI: (r8v2 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:18:0x0071, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object studentCoinAndMedal(int r7, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.live.abilitypack.coincenter.bean.CoinData> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.tal.app.thinkacademy.live.abilitypack.coincenter.api.CoinCenterRepository$studentCoinAndMedal$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.tal.app.thinkacademy.live.abilitypack.coincenter.api.CoinCenterRepository$studentCoinAndMedal$1 r0 = (com.tal.app.thinkacademy.live.abilitypack.coincenter.api.CoinCenterRepository$studentCoinAndMedal$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.live.abilitypack.coincenter.api.CoinCenterRepository$studentCoinAndMedal$1 r0 = new com.tal.app.thinkacademy.live.abilitypack.coincenter.api.CoinCenterRepository$studentCoinAndMedal$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0074
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r7 = (com.tal.app.thinkacademy.common.network.NetData) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0066
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r8)
            com.tal.app.thinkacademy.common.imconfig.ImConfig r8 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r8 = r8.getOverseaApi()
            java.lang.String r2 = "/api/hub/classroom/studentCoinAndMedal"
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r2)
            com.tal.app.thinkacademy.live.abilitypack.coincenter.bean.CoinReqBody r2 = new com.tal.app.thinkacademy.live.abilitypack.coincenter.bean.CoinReqBody
            r2.<init>(r7)
            com.tal.app.thinkacademy.common.network.NetData r7 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.live.abilitypack.coincenter.api.CoinCenterApi> r5 = com.tal.app.thinkacademy.live.abilitypack.coincenter.api.CoinCenterApi.class
            java.lang.Object r5 = com.tal.app.thinkacademy.lib.network.Api.create(r5)
            com.tal.app.thinkacademy.live.abilitypack.coincenter.api.CoinCenterApi r5 = (com.tal.app.thinkacademy.live.abilitypack.coincenter.api.CoinCenterApi) r5
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r5.studentCoinAndMedal(r8, r2, r0)
            if (r8 != r1) goto L_0x0066
            return r1
        L_0x0066:
            com.tal.app.thinkacademy.lib.restful.HiResponse r8 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r8
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = r7.transform(r8, r0)
            if (r8 != r1) goto L_0x0074
            return r1
        L_0x0074:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.coincenter.api.CoinCenterRepository.studentCoinAndMedal(int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
