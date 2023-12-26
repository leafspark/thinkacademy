package com.tal.app.thinkacademy.live.business.interactivegames.activity;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ#\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/activity/GameRepository;", "", "()V", "submitGameClose", "Lcom/tal/app/thinkacademy/common/entity/EmptyBean;", "url", "", "body", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/OpenStatusBody;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/OpenStatusBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitGameData", "Lcom/tal/app/thinkacademy/live/business/topic/bean/AnswerBean;", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/body/SubmitGameDataBody;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/body/SubmitGameDataBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameRepository.kt */
public final class GameRepository {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066 A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0063, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object submitGameData(java.lang.String r7, com.tal.app.thinkacademy.live.business.interactivegames.bean.body.SubmitGameDataBody r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.live.business.topic.bean.AnswerBean> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.live.business.interactivegames.activity.GameRepository$submitGameData$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.live.business.interactivegames.activity.GameRepository$submitGameData$1 r0 = (com.tal.app.thinkacademy.live.business.interactivegames.activity.GameRepository$submitGameData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.live.business.interactivegames.activity.GameRepository$submitGameData$1 r0 = new com.tal.app.thinkacademy.live.business.interactivegames.activity.GameRepository$submitGameData$1
            r0.<init>(r6, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0066
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r7 = (com.tal.app.thinkacademy.common.network.NetData) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0058
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.live.business.interactivegames.api.GameApi> r2 = com.tal.app.thinkacademy.live.business.interactivegames.api.GameApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2)
            com.tal.app.thinkacademy.live.business.interactivegames.api.GameApi r2 = (com.tal.app.thinkacademy.live.business.interactivegames.api.GameApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r7 = r2.submitGameDataNew(r7, r8, r0)
            if (r7 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r5 = r9
            r9 = r7
            r7 = r5
        L_0x0058:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r8 = 0
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r9 = r7.transform(r9, r0)
            if (r9 != r1) goto L_0x0066
            return r1
        L_0x0066:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.interactivegames.activity.GameRepository.submitGameData(java.lang.String, com.tal.app.thinkacademy.live.business.interactivegames.bean.body.SubmitGameDataBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066 A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0063, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object submitGameClose(java.lang.String r7, com.tal.app.thinkacademy.live.business.photosonthewall.bean.OpenStatusBody r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.common.entity.EmptyBean> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.live.business.interactivegames.activity.GameRepository$submitGameClose$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.live.business.interactivegames.activity.GameRepository$submitGameClose$1 r0 = (com.tal.app.thinkacademy.live.business.interactivegames.activity.GameRepository$submitGameClose$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.live.business.interactivegames.activity.GameRepository$submitGameClose$1 r0 = new com.tal.app.thinkacademy.live.business.interactivegames.activity.GameRepository$submitGameClose$1
            r0.<init>(r6, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0066
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r7 = (com.tal.app.thinkacademy.common.network.NetData) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0058
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.live.business.interactivegames.api.GameApi> r2 = com.tal.app.thinkacademy.live.business.interactivegames.api.GameApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2)
            com.tal.app.thinkacademy.live.business.interactivegames.api.GameApi r2 = (com.tal.app.thinkacademy.live.business.interactivegames.api.GameApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r7 = r2.submitGameCloseNew(r7, r8, r0)
            if (r7 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r5 = r9
            r9 = r7
            r7 = r5
        L_0x0058:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r8 = 0
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r9 = r7.transform(r9, r0)
            if (r9 != r1) goto L_0x0066
            return r1
        L_0x0066:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.interactivegames.activity.GameRepository.submitGameClose(java.lang.String, com.tal.app.thinkacademy.live.business.photosonthewall.bean.OpenStatusBody, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
