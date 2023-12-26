package com.tal.app.thinkacademy.common.aws;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\bH@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/common/aws/AwsRepository;", "", "()V", "getSTSToken", "Lcom/tal/app/thinkacademy/common/entity/STSToken;", "scene", "", "filePaths", "", "(Ljava/lang/String;[Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AwsRepository.kt */
public final class AwsRepository {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e A[PHI: r8 
      PHI: (r8v2 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:18:0x006b, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getSTSToken(java.lang.String r6, java.lang.String[] r7, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.common.entity.STSToken> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.tal.app.thinkacademy.common.aws.AwsRepository$getSTSToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.tal.app.thinkacademy.common.aws.AwsRepository$getSTSToken$1 r0 = (com.tal.app.thinkacademy.common.aws.AwsRepository$getSTSToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.common.aws.AwsRepository$getSTSToken$1 r0 = new com.tal.app.thinkacademy.common.aws.AwsRepository$getSTSToken$1
            r0.<init>(r5, r8)
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
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r6 = (com.tal.app.thinkacademy.common.network.NetData) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0060
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r8)
            com.tal.app.thinkacademy.common.entity.S3Body r8 = new com.tal.app.thinkacademy.common.entity.S3Body
            r8.<init>(r6, r7)
            com.tal.app.thinkacademy.common.network.NetData r6 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl r7 = com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl.INSTANCE
            java.lang.String r7 = r7.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.common.imconfig.ImConfigApi> r2 = com.tal.app.thinkacademy.common.imconfig.ImConfigApi.class
            java.lang.Object r7 = com.tal.app.thinkacademy.lib.network.Api.create(r7, r2)
            com.tal.app.thinkacademy.common.imconfig.ImConfigApi r7 = (com.tal.app.thinkacademy.common.imconfig.ImConfigApi) r7
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r8 = r7.getSTSToken(r8, r0)
            if (r8 != r1) goto L_0x0060
            return r1
        L_0x0060:
            com.tal.app.thinkacademy.lib.restful.HiResponse r8 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r8
            r7 = 0
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r6.transform(r8, r0)
            if (r8 != r1) goto L_0x006e
            return r1
        L_0x006e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.aws.AwsRepository.getSTSToken(java.lang.String, java.lang.String[], kotlin.coroutines.Continuation):java.lang.Object");
    }
}
