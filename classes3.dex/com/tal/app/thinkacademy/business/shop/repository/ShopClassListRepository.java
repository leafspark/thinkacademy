package com.tal.app.thinkacademy.business.shop.repository;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0019\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ!\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010!JO\u0010\"\u001a\u0004\u0018\u00010\u00012\b\u0010#\u001a\u0004\u0018\u00010\r2\b\u0010$\u001a\u0004\u0018\u00010\r2\b\u0010%\u001a\u0004\u0018\u00010\r2\b\u0010&\u001a\u0004\u0018\u00010\r2\b\u0010'\u001a\u0004\u0018\u00010\r2\b\u0010(\u001a\u0004\u0018\u00010\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010)\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/repository/ShopClassListRepository;", "", "()V", "getClassList", "Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateClassListData;", "courseIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGradeAggregateInfo", "Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateDetailInfo;", "pageId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGradeStageList", "Lcom/tal/app/thinkacademy/common/user/GradeStageList;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTeacherDetailsHeader", "Lcom/tal/app/thinkacademy/business/shop/bean/TeacherDetailsHeader;", "teacherId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTeacherDetailsList", "Lcom/tal/app/thinkacademy/business/shop/bean/request/TeacherDetailsList;", "postLeaveInfo", "data", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/LeaveInfoPostBodyData;", "(Lcom/tal/app/thinkacademy/business/home/main/shop/bean/LeaveInfoPostBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryClazzByCourseId", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassData;", "body", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopRequestCommonBody;", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassListRequestData;", "(Lcom/tal/app/thinkacademy/business/shop/bean/ShopRequestCommonBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitIntention", "yearGroup", "day", "time", "email", "name", "subStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassListRepository.kt */
public final class ShopClassListRepository {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object queryClazzByCourseId(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody<com.tal.app.thinkacademy.business.shop.bean.ShopClassListRequestData> r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.shop.bean.ShopClassData> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$queryClazzByCourseId$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$queryClazzByCourseId$1 r0 = (com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$queryClazzByCourseId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$queryClazzByCourseId$1 r0 = new com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$queryClazzByCourseId$1
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
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r5 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.queryClazzByCourseId(r8, r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x006c
            return r1
        L_0x006c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository.queryClazzByCourseId(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b A[PHI: r12 
      PHI: (r12v2 java.lang.Object) = (r12v5 java.lang.Object), (r12v1 java.lang.Object) binds: [B:19:0x0078, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getTeacherDetailsHeader(int r11, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.shop.bean.TeacherDetailsHeader> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getTeacherDetailsHeader$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getTeacherDetailsHeader$1 r0 = (com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getTeacherDetailsHeader$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getTeacherDetailsHeader$1 r0 = new com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getTeacherDetailsHeader$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003e
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x007b
        L_0x002e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0036:
            java.lang.Object r11 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r11 = (com.tal.app.thinkacademy.common.network.NetData) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x006e
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r12)
            com.tal.app.thinkacademy.common.network.NetData r12 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r6 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r6)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            com.tal.app.thinkacademy.business.shop.bean.request.TeacherDeatilsRequest r6 = new com.tal.app.thinkacademy.business.shop.bean.request.TeacherDeatilsRequest
            com.tal.app.thinkacademy.business.shop.bean.request.Header r7 = new com.tal.app.thinkacademy.business.shop.bean.request.Header
            r7.<init>(r5, r4, r5)
            com.tal.app.thinkacademy.business.shop.bean.request.Data r8 = new com.tal.app.thinkacademy.business.shop.bean.request.Data
            r8.<init>(r11, r5, r3, r5)
            r6.<init>(r7, r8)
            r0.L$0 = r12
            r0.label = r4
            java.lang.Object r11 = r2.getTeacherDetailsHeader(r6, r0)
            if (r11 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r9 = r12
            r12 = r11
            r11 = r9
        L_0x006e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r12 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r12
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r12 = r11.transform(r12, r0)
            if (r12 != r1) goto L_0x007b
            return r1
        L_0x007b:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository.getTeacherDetailsHeader(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b A[PHI: r12 
      PHI: (r12v2 java.lang.Object) = (r12v5 java.lang.Object), (r12v1 java.lang.Object) binds: [B:19:0x0078, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getTeacherDetailsList(int r11, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.shop.bean.request.TeacherDetailsList> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getTeacherDetailsList$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getTeacherDetailsList$1 r0 = (com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getTeacherDetailsList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getTeacherDetailsList$1 r0 = new com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getTeacherDetailsList$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003e
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x007b
        L_0x002e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0036:
            java.lang.Object r11 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r11 = (com.tal.app.thinkacademy.common.network.NetData) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x006e
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r12)
            com.tal.app.thinkacademy.common.network.NetData r12 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r6 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r6)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            com.tal.app.thinkacademy.business.shop.bean.request.TeacherDeatilsRequest r6 = new com.tal.app.thinkacademy.business.shop.bean.request.TeacherDeatilsRequest
            com.tal.app.thinkacademy.business.shop.bean.request.Header r7 = new com.tal.app.thinkacademy.business.shop.bean.request.Header
            r7.<init>(r5, r4, r5)
            com.tal.app.thinkacademy.business.shop.bean.request.Data r8 = new com.tal.app.thinkacademy.business.shop.bean.request.Data
            r8.<init>(r11, r5, r3, r5)
            r6.<init>(r7, r8)
            r0.L$0 = r12
            r0.label = r4
            java.lang.Object r11 = r2.getTeacherDetailsList(r6, r0)
            if (r11 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r9 = r12
            r12 = r11
            r11 = r9
        L_0x006e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r12 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r12
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r12 = r11.transform(r12, r0)
            if (r12 != r1) goto L_0x007b
            return r1
        L_0x007b:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository.getTeacherDetailsList(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0087 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0088 A[PHI: r0 
      PHI: (r0v2 java.lang.Object) = (r0v5 java.lang.Object), (r0v1 java.lang.Object) binds: [B:18:0x0085, B:10:0x0030] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object submitIntention(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.Integer r22, kotlin.coroutines.Continuation<java.lang.Object> r23) {
        /*
            r16 = this;
            r0 = r23
            boolean r1 = r0 instanceof com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$submitIntention$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$submitIntention$1 r1 = (com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$submitIntention$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r16
            goto L_0x001f
        L_0x0018:
            com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$submitIntention$1 r1 = new com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$submitIntention$1
            r2 = r16
            r1.<init>(r2, r0)
        L_0x001f:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 1
            r6 = 0
            r7 = 2
            if (r4 == 0) goto L_0x0044
            if (r4 == r5) goto L_0x003c
            if (r4 != r7) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0088
        L_0x0034:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003c:
            java.lang.Object r4 = r1.L$0
            com.tal.app.thinkacademy.common.network.NetData r4 = (com.tal.app.thinkacademy.common.network.NetData) r4
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x007b
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r0)
            com.tal.app.thinkacademy.common.network.NetData r4 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r0 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r0 = r0.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r8 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r0 = com.tal.app.thinkacademy.lib.network.Api.create(r0, r8)
            com.tal.app.thinkacademy.business.shop.ShopApi r0 = (com.tal.app.thinkacademy.business.shop.ShopApi) r0
            com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody r8 = new com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody
            com.tal.app.thinkacademy.business.shop.bean.request.SubmitIntentionRequestData r15 = new com.tal.app.thinkacademy.business.shop.bean.request.SubmitIntentionRequestData
            r9 = r15
            r10 = r17
            r11 = r18
            r12 = r19
            r13 = r20
            r14 = r21
            r5 = r15
            r15 = r22
            r9.<init>(r10, r11, r12, r13, r14, r15)
            r8.<init>(r5, r6, r7, r6)
            r1.L$0 = r4
            r5 = 1
            r1.label = r5
            java.lang.Object r0 = r0.submitIntention(r8, r1)
            if (r0 != r3) goto L_0x007b
            return r3
        L_0x007b:
            com.tal.app.thinkacademy.lib.restful.HiResponse r0 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r0
            r1.L$0 = r6
            r1.label = r7
            java.lang.Object r0 = r4.transform(r0, r1)
            if (r0 != r3) goto L_0x0088
            return r3
        L_0x0088:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository.submitIntention(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074 A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:18:0x0071, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getGradeStageList(kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.common.user.GradeStageList> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getGradeStageList$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getGradeStageList$1 r0 = (com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getGradeStageList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getGradeStageList$1 r0 = new com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getGradeStageList$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003e
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0074
        L_0x002e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0036:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0067
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r10 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r10 = r10.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r6 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r10 = com.tal.app.thinkacademy.lib.network.Api.create(r10, r6)
            com.tal.app.thinkacademy.business.shop.ShopApi r10 = (com.tal.app.thinkacademy.business.shop.ShopApi) r10
            com.tal.app.thinkacademy.business.shop.bean.request.UserInfoRequest r6 = new com.tal.app.thinkacademy.business.shop.bean.request.UserInfoRequest
            com.tal.app.thinkacademy.business.shop.bean.request.Headers r7 = new com.tal.app.thinkacademy.business.shop.bean.request.Headers
            r8 = 3
            r7.<init>(r5, r5, r8, r5)
            r6.<init>(r7)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r10 = r10.getGradeStageList(r6, r0)
            if (r10 != r1) goto L_0x0067
            return r1
        L_0x0067:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r10 = r2.transform(r10, r0)
            if (r10 != r1) goto L_0x0074
            return r1
        L_0x0074:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository.getGradeStageList(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0084 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0085 A[PHI: r0 
      PHI: (r0v2 java.lang.Object) = (r0v5 java.lang.Object), (r0v1 java.lang.Object) binds: [B:18:0x0082, B:10:0x0030] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getClassList(java.util.ArrayList<java.lang.Integer> r17, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.shop.bean.GradeAggregateClassListData> r18) {
        /*
            r16 = this;
            r0 = r18
            boolean r1 = r0 instanceof com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getClassList$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getClassList$1 r1 = (com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getClassList$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r16
            goto L_0x001f
        L_0x0018:
            com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getClassList$1 r1 = new com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getClassList$1
            r2 = r16
            r1.<init>(r2, r0)
        L_0x001f:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 2
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x0044
            if (r4 == r6) goto L_0x003c
            if (r4 != r5) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0085
        L_0x0034:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003c:
            java.lang.Object r4 = r1.L$0
            com.tal.app.thinkacademy.common.network.NetData r4 = (com.tal.app.thinkacademy.common.network.NetData) r4
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0078
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r0)
            com.tal.app.thinkacademy.common.network.NetData r4 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r0 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r0 = r0.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r8 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r0 = com.tal.app.thinkacademy.lib.network.Api.create(r0, r8)
            com.tal.app.thinkacademy.business.shop.ShopApi r0 = (com.tal.app.thinkacademy.business.shop.ShopApi) r0
            com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody r8 = new com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody
            com.tal.app.thinkacademy.business.shop.bean.request.ClassListDataRequest r15 = new com.tal.app.thinkacademy.business.shop.bean.request.ClassListDataRequest
            r10 = 0
            r12 = 0
            r13 = 5
            r14 = 0
            r9 = r15
            r11 = r17
            r9.<init>(r10, r11, r12, r13, r14)
            com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonHeader r9 = new com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonHeader
            r9.<init>(r7, r7, r6, r7)
            r8.<init>(r15, r9)
            r1.L$0 = r4
            r1.label = r6
            java.lang.Object r0 = r0.getClassList(r8, r1)
            if (r0 != r3) goto L_0x0078
            return r3
        L_0x0078:
            com.tal.app.thinkacademy.lib.restful.HiResponse r0 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r0
            r1.L$0 = r7
            r1.label = r5
            java.lang.Object r0 = r4.transform(r0, r1)
            if (r0 != r3) goto L_0x0085
            return r3
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository.getClassList(java.util.ArrayList, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a1 A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:22:0x009e, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getGradeAggregateInfo(java.lang.String r9, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getGradeAggregateInfo$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getGradeAggregateInfo$1 r0 = (com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getGradeAggregateInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getGradeAggregateInfo$1 r0 = new com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$getGradeAggregateInfo$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r5) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00a1
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            java.lang.Object r9 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r9 = (com.tal.app.thinkacademy.common.network.NetData) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0094
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r10 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r6 = "school_code"
            java.lang.String r7 = "415"
            java.lang.String r10 = r10.getString(r6, r7, r2)
            java.lang.String r2 = "getInstance()\n          …ager.SHAREDATA_NOT_CLEAR)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r2 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r2 = r2.getInstance()
            com.tal.app.thinkacademy.common.entity.ChannelSaveData r2 = r2.getSelectedChannel()
            if (r2 != 0) goto L_0x0062
            r2 = r3
            goto L_0x0066
        L_0x0062:
            java.lang.Integer r2 = r2.getId()
        L_0x0066:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonHeader r6 = new com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonHeader
            r6.<init>(r10, r2)
            com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody r10 = new com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody
            com.tal.app.thinkacademy.business.shop.bean.request.GradeAggregateRequestHead r2 = new com.tal.app.thinkacademy.business.shop.bean.request.GradeAggregateRequestHead
            r2.<init>(r9)
            r10.<init>(r2, r6)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r6 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r6)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r10 = r2.getShopGoodsApiMallPage(r10, r0)
            if (r10 != r1) goto L_0x0094
            return r1
        L_0x0094:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r10 = r9.transform(r10, r0)
            if (r10 != r1) goto L_0x00a1
            return r1
        L_0x00a1:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository.getGradeAggregateInfo(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e A[PHI: r8 
      PHI: (r8v2 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:18:0x006b, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object postLeaveInfo(com.tal.app.thinkacademy.business.home.main.shop.bean.LeaveInfoPostBodyData r7, kotlin.coroutines.Continuation<java.lang.Object> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$postLeaveInfo$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$postLeaveInfo$1 r0 = (com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$postLeaveInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$postLeaveInfo$1 r0 = new com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository$postLeaveInfo$1
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
            goto L_0x006e
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r7 = (com.tal.app.thinkacademy.common.network.NetData) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0060
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r8)
            com.tal.app.thinkacademy.business.home.main.shop.bean.LeaveInfoPostBody r8 = new com.tal.app.thinkacademy.business.home.main.shop.bean.LeaveInfoPostBody
            r8.<init>(r7)
            com.tal.app.thinkacademy.common.network.NetData r7 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r5 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r2.postLeaveInfo(r8, r0)
            if (r8 != r1) goto L_0x0060
            return r1
        L_0x0060:
            com.tal.app.thinkacademy.lib.restful.HiResponse r8 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r8
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = r7.transform(r8, r0)
            if (r8 != r1) goto L_0x006e
            return r1
        L_0x006e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository.postLeaveInfo(com.tal.app.thinkacademy.business.home.main.shop.bean.LeaveInfoPostBodyData, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
