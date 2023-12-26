package com.tal.app.thinkacademy.live.business.ranking;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/ranking/RankingRepository;", "", "()V", "getRankingList", "", "Lcom/tal/app/thinkacademy/live/business/ranking/RankingBean;", "planId", "", "classId", "(Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RankingRepository.kt */
public final class RankingRepository {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0098 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0099 A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:19:0x0096, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getRankingList(java.lang.Integer r8, java.lang.Integer r9, kotlin.coroutines.Continuation<? super java.util.List<com.tal.app.thinkacademy.live.business.ranking.RankingBean>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.live.business.ranking.RankingRepository$getRankingList$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.tal.app.thinkacademy.live.business.ranking.RankingRepository$getRankingList$1 r0 = (com.tal.app.thinkacademy.live.business.ranking.RankingRepository$getRankingList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.live.business.ranking.RankingRepository$getRankingList$1 r0 = new com.tal.app.thinkacademy.live.business.ranking.RankingRepository$getRankingList$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0099
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x008b
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.common.imconfig.ImConfig r10 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r10 = r10.getOverseaApi()
            java.lang.String r2 = "/classroom-hub/classRanking/student/rankingList"
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r10, r2)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r5 = r2
            java.util.Map r5 = (java.util.Map) r5
            java.lang.String r6 = "planId"
            r5.put(r6, r8)
            java.lang.String r8 = "classId"
            r5.put(r8, r9)
            okhttp3.RequestBody$Companion r8 = okhttp3.RequestBody.Companion
            java.lang.String r9 = com.tal.app.thinkacademy.lib.util.GsonUtils.toJson(r2)
            java.lang.String r2 = "toJson(paramsMap)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
            okhttp3.MediaType$Companion r2 = okhttp3.MediaType.Companion
            java.lang.String r5 = "application/json;charset=UTF-8"
            okhttp3.MediaType r2 = r2.parse(r5)
            okhttp3.RequestBody r8 = r8.create(r9, r2)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.live.business.ranking.RankingApi> r2 = com.tal.app.thinkacademy.live.business.ranking.RankingApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2)
            com.tal.app.thinkacademy.live.business.ranking.RankingApi r2 = (com.tal.app.thinkacademy.live.business.ranking.RankingApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r10 = r2.getRankingList(r10, r8, r0)
            if (r10 != r1) goto L_0x008a
            return r1
        L_0x008a:
            r8 = r9
        L_0x008b:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r9 = 0
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r10 = r8.transform(r10, r0)
            if (r10 != r1) goto L_0x0099
            return r1
        L_0x0099:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.ranking.RankingRepository.getRankingList(java.lang.Integer, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
