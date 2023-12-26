package com.tal.app.thinkacademy.business.study.study.materials.network;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a/\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u001a\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00030\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"getMaterialsList", "Lcom/tal/app/thinkacademy/business/study/study/entity/LearnMaterialsEntity;", "planId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportMaterialsDownload", "Lcom/tal/app/thinkacademy/common/entity/EmptyBean;", "materialIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_study_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MaterialsRepository.kt */
public final class MaterialsRepositoryKt {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0080 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0081 A[PHI: r11 
      PHI: (r11v2 java.lang.Object) = (r11v5 java.lang.Object), (r11v1 java.lang.Object) binds: [B:26:0x007e, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getMaterialsList(java.lang.String r10, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.study.study.entity.LearnMaterialsEntity> r11) {
        /*
            boolean r0 = r11 instanceof com.tal.app.thinkacademy.business.study.study.materials.network.MaterialsRepositoryKt$getMaterialsList$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.tal.app.thinkacademy.business.study.study.materials.network.MaterialsRepositoryKt$getMaterialsList$1 r0 = (com.tal.app.thinkacademy.business.study.study.materials.network.MaterialsRepositoryKt$getMaterialsList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.materials.network.MaterialsRepositoryKt$getMaterialsList$1 r0 = new com.tal.app.thinkacademy.business.study.study.materials.network.MaterialsRepositoryKt$getMaterialsList$1
            r0.<init>(r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r5) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0081
        L_0x002e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0036:
            java.lang.Object r10 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r10 = (com.tal.app.thinkacademy.common.network.NetData) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0074
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r11)
            com.tal.app.thinkacademy.common.network.NetData r11 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ImConfig r2 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r2 = r2.getOverseaApi()
            if (r2 != 0) goto L_0x004d
            java.lang.String r2 = ""
        L_0x004d:
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r6 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r6)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            com.tal.app.thinkacademy.common.entity.BaseRequestBean r6 = new com.tal.app.thinkacademy.common.entity.BaseRequestBean
            if (r10 != 0) goto L_0x005b
            r10 = r3
            goto L_0x0063
        L_0x005b:
            long r7 = java.lang.Long.parseLong(r10)
            java.lang.Long r10 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)
        L_0x0063:
            r6.<init>(r10)
            r0.L$0 = r11
            r0.label = r5
            java.lang.Object r10 = r2.getMaterialsList(r6, r0)
            if (r10 != r1) goto L_0x0071
            return r1
        L_0x0071:
            r9 = r11
            r11 = r10
            r10 = r9
        L_0x0074:
            com.tal.app.thinkacademy.lib.restful.HiResponse r11 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r11
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r11 = r10.transform(r11, r0)
            if (r11 != r1) goto L_0x0081
            return r1
        L_0x0081:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.materials.network.MaterialsRepositoryKt.getMaterialsList(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0074 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075 A[PHI: r8 
      PHI: (r8v2 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:22:0x0072, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object reportMaterialsDownload(java.util.ArrayList<java.lang.String> r7, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.common.entity.EmptyBean> r8) {
        /*
            boolean r0 = r8 instanceof com.tal.app.thinkacademy.business.study.study.materials.network.MaterialsRepositoryKt$reportMaterialsDownload$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.tal.app.thinkacademy.business.study.study.materials.network.MaterialsRepositoryKt$reportMaterialsDownload$1 r0 = (com.tal.app.thinkacademy.business.study.study.materials.network.MaterialsRepositoryKt$reportMaterialsDownload$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.study.study.materials.network.MaterialsRepositoryKt$reportMaterialsDownload$1 r0 = new com.tal.app.thinkacademy.business.study.study.materials.network.MaterialsRepositoryKt$reportMaterialsDownload$1
            r0.<init>(r8)
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
            goto L_0x0075
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r7 = (com.tal.app.thinkacademy.common.network.NetData) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0067
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r8)
            com.tal.app.thinkacademy.common.network.NetData r8 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ImConfig r2 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r2 = r2.getOverseaApi()
            if (r2 != 0) goto L_0x004c
            java.lang.String r2 = ""
        L_0x004c:
            java.lang.Class<com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi> r5 = com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi r2 = (com.tal.app.thinkacademy.business.study.study.api.StudyCenterApi) r2
            com.tal.app.thinkacademy.business.study.study.entity.request.MaterialsReportRequest r5 = new com.tal.app.thinkacademy.business.study.study.entity.request.MaterialsReportRequest
            r5.<init>(r7)
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r7 = r2.reportMaterialsDownload(r5, r0)
            if (r7 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x0067:
            com.tal.app.thinkacademy.lib.restful.HiResponse r8 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r8
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = r7.transform(r8, r0)
            if (r8 != r1) goto L_0x0075
            return r1
        L_0x0075:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.materials.network.MaterialsRepositoryKt.reportMaterialsDownload(java.util.ArrayList, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
