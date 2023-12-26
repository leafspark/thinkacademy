package com.tal.app.thinkacademy.live.business.function.repository;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/repository/FunctionRepository;", "", "()V", "getEnterRoomMuteData", "Lcom/tal/app/thinkacademy/live/business/function/bean/EnterRoomMuteData;", "planId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExamInfo", "Lcom/tal/app/thinkacademy/live/business/exam/bean/ExamInfo;", "getPhotoBox", "Lcom/tal/app/thinkacademy/live/business/homework/entity/PhotoBoxEntity;", "getPhotoBoxMessage", "Lcom/tal/app/thinkacademy/live/business/homework/entity/PhotoBoxMessage;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FunctionRepository.kt */
public final class FunctionRepository {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074 A[PHI: r8 
      PHI: (r8v2 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:18:0x0071, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getPhotoBoxMessage(int r7, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.live.business.homework.entity.PhotoBoxMessage> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getPhotoBoxMessage$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getPhotoBoxMessage$1 r0 = (com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getPhotoBoxMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getPhotoBoxMessage$1 r0 = new com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getPhotoBoxMessage$1
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
            java.lang.String r2 = "/classroom-hub/wall/student/readNewMessage"
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r2)
            com.tal.app.thinkacademy.live.business.function.bean.FunctionBody r2 = new com.tal.app.thinkacademy.live.business.function.bean.FunctionBody
            r2.<init>(r7)
            com.tal.app.thinkacademy.common.network.NetData r7 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.live.business.function.api.FunctionApi> r5 = com.tal.app.thinkacademy.live.business.function.api.FunctionApi.class
            java.lang.Object r5 = com.tal.app.thinkacademy.lib.network.Api.create(r5)
            com.tal.app.thinkacademy.live.business.function.api.FunctionApi r5 = (com.tal.app.thinkacademy.live.business.function.api.FunctionApi) r5
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r5.getNewMessage(r8, r2, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository.getPhotoBoxMessage(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074 A[PHI: r8 
      PHI: (r8v2 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:18:0x0071, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getPhotoBox(int r7, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.live.business.homework.entity.PhotoBoxEntity> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getPhotoBox$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getPhotoBox$1 r0 = (com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getPhotoBox$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getPhotoBox$1 r0 = new com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getPhotoBox$1
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
            java.lang.String r2 = "/classroom-hub/wall/student/photoBox"
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r2)
            com.tal.app.thinkacademy.live.business.function.bean.FunctionBody r2 = new com.tal.app.thinkacademy.live.business.function.bean.FunctionBody
            r2.<init>(r7)
            com.tal.app.thinkacademy.common.network.NetData r7 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.live.business.function.api.FunctionApi> r5 = com.tal.app.thinkacademy.live.business.function.api.FunctionApi.class
            java.lang.Object r5 = com.tal.app.thinkacademy.lib.network.Api.create(r5)
            com.tal.app.thinkacademy.live.business.function.api.FunctionApi r5 = (com.tal.app.thinkacademy.live.business.function.api.FunctionApi) r5
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r5.getPhotoBox(r8, r2, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository.getPhotoBox(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075 A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0072, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getExamInfo(int r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.live.business.exam.bean.ExamInfo> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getExamInfo$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getExamInfo$1 r0 = (com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getExamInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getExamInfo$1 r0 = new com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getExamInfo$1
            r0.<init>(r7, r9)
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
            goto L_0x0075
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0067
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.imconfig.ImConfig r9 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r9 = r9.getOverseaApi()
            java.lang.String r2 = "/api/hub/classroom/exam/examInfo"
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r2)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.live.business.function.api.FunctionApi> r5 = com.tal.app.thinkacademy.live.business.function.api.FunctionApi.class
            java.lang.Object r5 = com.tal.app.thinkacademy.lib.network.Api.create(r5)
            com.tal.app.thinkacademy.live.business.function.api.FunctionApi r5 = (com.tal.app.thinkacademy.live.business.function.api.FunctionApi) r5
            com.tal.app.thinkacademy.live.business.exam.bean.ExamInfoBody r6 = new com.tal.app.thinkacademy.live.business.exam.bean.ExamInfoBody
            r6.<init>(r8)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r9 = r5.getExamInfo(r9, r6, r0)
            if (r9 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r8 = r2
        L_0x0067:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x0075
            return r1
        L_0x0075:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository.getExamInfo(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074 A[PHI: r8 
      PHI: (r8v2 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:18:0x0071, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getEnterRoomMuteData(int r7, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getEnterRoomMuteData$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getEnterRoomMuteData$1 r0 = (com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getEnterRoomMuteData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getEnterRoomMuteData$1 r0 = new com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository$getEnterRoomMuteData$1
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
            java.lang.String r2 = "/api/classroom/v1/getMute"
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r2)
            com.tal.app.thinkacademy.live.business.function.bean.FunctionBody r2 = new com.tal.app.thinkacademy.live.business.function.bean.FunctionBody
            r2.<init>(r7)
            com.tal.app.thinkacademy.common.network.NetData r7 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.live.business.function.api.FunctionApi> r5 = com.tal.app.thinkacademy.live.business.function.api.FunctionApi.class
            java.lang.Object r5 = com.tal.app.thinkacademy.lib.network.Api.create(r5)
            com.tal.app.thinkacademy.live.business.function.api.FunctionApi r5 = (com.tal.app.thinkacademy.live.business.function.api.FunctionApi) r5
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r5.getEnterRoomMuteData(r8, r2, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository.getEnterRoomMuteData(int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
