package com.tal.app.thinkacademy.business.home.main.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/api/HomeRepository;", "", "()V", "clientLogin", "body", "Lcom/tal/app/thinkacademy/common/entity/PushRequestBean;", "(Lcom/tal/app/thinkacademy/common/entity/PushRequestBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRedDot", "Lcom/tal/app/thinkacademy/business/home/main/bean/UnPayNum;", "Lcom/tal/app/thinkacademy/business/home/main/bean/RedDotPostBody;", "(Lcom/tal/app/thinkacademy/business/home/main/bean/RedDotPostBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSchoolCode", "Lcom/tal/app/thinkacademy/business/home/main/bean/SchoolCode;", "countryCode", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendLessonReminder", "Lcom/tal/app/thinkacademy/business/home/main/bean/LessonReminderData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeRepository.kt */
public final class HomeRepository {
    public static /* synthetic */ Object getSchoolCode$default(HomeRepository homeRepository, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return homeRepository.getSchoolCode(str, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0071 A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x006e, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getSchoolCode(java.lang.String r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.home.main.bean.SchoolCode> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.home.main.api.HomeRepository$getSchoolCode$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.home.main.api.HomeRepository$getSchoolCode$1 r0 = (com.tal.app.thinkacademy.business.home.main.api.HomeRepository$getSchoolCode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.home.main.api.HomeRepository$getSchoolCode$1 r0 = new com.tal.app.thinkacademy.business.home.main.api.HomeRepository$getSchoolCode$1
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
            goto L_0x0071
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0063
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl r2 = com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.home.main.api.ApiService> r5 = com.tal.app.thinkacademy.business.home.main.api.ApiService.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.home.main.api.ApiService r2 = (com.tal.app.thinkacademy.business.home.main.api.ApiService) r2
            com.tal.app.thinkacademy.business.home.main.bean.CountryCode r5 = new com.tal.app.thinkacademy.business.home.main.bean.CountryCode
            r5.<init>(r8)
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.getSchoolCode(r5, r0)
            if (r8 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x0063:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x0071
            return r1
        L_0x0071:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.api.HomeRepository.getSchoolCode(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getRedDot(com.tal.app.thinkacademy.business.home.main.bean.RedDotPostBody r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.home.main.bean.UnPayNum> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.home.main.api.HomeRepository$getRedDot$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.home.main.api.HomeRepository$getRedDot$1 r0 = (com.tal.app.thinkacademy.business.home.main.api.HomeRepository$getRedDot$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.home.main.api.HomeRepository$getRedDot$1 r0 = new com.tal.app.thinkacademy.business.home.main.api.HomeRepository$getRedDot$1
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
            java.lang.Class<com.tal.app.thinkacademy.business.home.main.api.ApiService> r5 = com.tal.app.thinkacademy.business.home.main.api.ApiService.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.home.main.api.ApiService r2 = (com.tal.app.thinkacademy.business.home.main.api.ApiService) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.redDot(r8, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.api.HomeRepository.getRedDot(com.tal.app.thinkacademy.business.home.main.bean.RedDotPostBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object clientLogin(com.tal.app.thinkacademy.common.entity.PushRequestBean r8, kotlin.coroutines.Continuation<java.lang.Object> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.home.main.api.HomeRepository$clientLogin$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.home.main.api.HomeRepository$clientLogin$1 r0 = (com.tal.app.thinkacademy.business.home.main.api.HomeRepository$clientLogin$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.home.main.api.HomeRepository$clientLogin$1 r0 = new com.tal.app.thinkacademy.business.home.main.api.HomeRepository$clientLogin$1
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
            java.lang.Class<com.tal.app.thinkacademy.common.network.CommonApi> r5 = com.tal.app.thinkacademy.common.network.CommonApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.common.network.CommonApi r2 = (com.tal.app.thinkacademy.common.network.CommonApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.pushClientLogin(r8, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.api.HomeRepository.clientLogin(com.tal.app.thinkacademy.common.entity.PushRequestBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:18:0x006c, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object suspendLessonReminder(kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.home.main.bean.LessonReminderData> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.home.main.api.HomeRepository$suspendLessonReminder$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.home.main.api.HomeRepository$suspendLessonReminder$1 r0 = (com.tal.app.thinkacademy.business.home.main.api.HomeRepository$suspendLessonReminder$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.home.main.api.HomeRepository$suspendLessonReminder$1 r0 = new com.tal.app.thinkacademy.business.home.main.api.HomeRepository$suspendLessonReminder$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003e
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006f
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0036:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0062
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r9 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r9 = r9.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.home.main.api.ApiService> r6 = com.tal.app.thinkacademy.business.home.main.api.ApiService.class
            java.lang.Object r9 = com.tal.app.thinkacademy.lib.network.Api.create(r9, r6)
            com.tal.app.thinkacademy.business.home.main.api.ApiService r9 = (com.tal.app.thinkacademy.business.home.main.api.ApiService) r9
            com.tal.app.thinkacademy.business.home.main.bean.LessonReminderRequest r6 = new com.tal.app.thinkacademy.business.home.main.bean.LessonReminderRequest
            r7 = 3
            r6.<init>(r5, r5, r7, r5)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r9 = r9.getLessonReminder(r6, r0)
            if (r9 != r1) goto L_0x0062
            return r1
        L_0x0062:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r9 = r2.transform(r9, r0)
            if (r9 != r1) goto L_0x006f
            return r1
        L_0x006f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.api.HomeRepository.suspendLessonReminder(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
