package com.tal.app.thinkacademy.business.login.config;

import com.tal.app.thinkacademy.common.network.ENVIRONMENTAL;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/config/TempClassRepository;", "", "()V", "getNickname", "Lcom/tal/app/thinkacademy/business/login/entity/NicknameBean;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStudentCurriculumList", "Lcom/tal/app/thinkacademy/business/login/entity/ClassListEntity;", "data", "Lcom/tal/app/thinkacademy/business/login/entity/CurriculumListData;", "(Lcom/tal/app/thinkacademy/business/login/entity/CurriculumListData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TempClassRepository.kt */
public final class TempClassRepository {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TempClassRepository.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ENVIRONMENTAL.values().length];
            iArr[ENVIRONMENTAL.ONLINE.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0078 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0079 A[PHI: r8 
      PHI: (r8v2 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:23:0x0076, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getStudentCurriculumList(com.tal.app.thinkacademy.business.login.entity.CurriculumListData r7, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.login.entity.ClassListEntity> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.tal.app.thinkacademy.business.login.config.TempClassRepository$getStudentCurriculumList$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.tal.app.thinkacademy.business.login.config.TempClassRepository$getStudentCurriculumList$1 r0 = (com.tal.app.thinkacademy.business.login.config.TempClassRepository$getStudentCurriculumList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.TempClassRepository$getStudentCurriculumList$1 r0 = new com.tal.app.thinkacademy.business.login.config.TempClassRepository$getStudentCurriculumList$1
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
            goto L_0x0079
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r7 = (com.tal.app.thinkacademy.common.network.NetData) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006b
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r8)
            com.tal.app.thinkacademy.common.network.BaseUrlEx$Companion r8 = com.tal.app.thinkacademy.common.network.BaseUrlEx.Companion
            com.tal.app.thinkacademy.common.network.ENVIRONMENTAL r8 = r8.getEnvironment()
            int[] r2 = com.tal.app.thinkacademy.business.login.config.TempClassRepository.WhenMappings.$EnumSwitchMapping$0
            int r8 = r8.ordinal()
            r8 = r2[r8]
            if (r8 != r4) goto L_0x0053
            java.lang.String r8 = "https://one.thethinkacademy.com/api/education/student/curriculumList"
            goto L_0x0055
        L_0x0053:
            java.lang.String r8 = "https://beta-one.thethinkacademy.com/api/education/student/curriculumList"
        L_0x0055:
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r5 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r5 = com.tal.app.thinkacademy.lib.network.Api.create(r5)
            com.tal.app.thinkacademy.business.login.config.ApiService r5 = (com.tal.app.thinkacademy.business.login.config.ApiService) r5
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r8 = r5.getStudentCurriculumList(r8, r7, r0)
            if (r8 != r1) goto L_0x006a
            return r1
        L_0x006a:
            r7 = r2
        L_0x006b:
            com.tal.app.thinkacademy.lib.restful.HiResponse r8 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r8
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = r7.transform(r8, r0)
            if (r8 != r1) goto L_0x0079
            return r1
        L_0x0079:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.TempClassRepository.getStudentCurriculumList(com.tal.app.thinkacademy.business.login.entity.CurriculumListData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:18:0x0068, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getNickname(kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.login.entity.NicknameBean> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.tal.app.thinkacademy.business.login.config.TempClassRepository$getNickname$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.tal.app.thinkacademy.business.login.config.TempClassRepository$getNickname$1 r0 = (com.tal.app.thinkacademy.business.login.config.TempClassRepository$getNickname$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.login.config.TempClassRepository$getNickname$1 r0 = new com.tal.app.thinkacademy.business.login.config.TempClassRepository$getNickname$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006b
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005d
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r7 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r7 = r7.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r5 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r7 = com.tal.app.thinkacademy.lib.network.Api.create(r7, r5)
            com.tal.app.thinkacademy.business.login.config.ApiService r7 = (com.tal.app.thinkacademy.business.login.config.ApiService) r7
            r0.L$0 = r2
            r0.label = r4
            java.lang.String r4 = "{}"
            java.lang.Object r7 = r7.getNickname(r4, r0)
            if (r7 != r1) goto L_0x005d
            return r1
        L_0x005d:
            com.tal.app.thinkacademy.lib.restful.HiResponse r7 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r7
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r2.transform(r7, r0)
            if (r7 != r1) goto L_0x006b
            return r1
        L_0x006b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.config.TempClassRepository.getNickname(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
