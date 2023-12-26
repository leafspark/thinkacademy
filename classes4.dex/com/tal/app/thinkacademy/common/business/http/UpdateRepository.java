package com.tal.app.thinkacademy.common.business.http;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/http/UpdateRepository;", "", "()V", "newCheckUpdate", "Lcom/tal/app/thinkacademy/common/entity/UpdateVersionEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UpdateRepository.kt */
public final class UpdateRepository {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069 A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:18:0x0066, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object newCheckUpdate(kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.common.entity.UpdateVersionEntity> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.tal.app.thinkacademy.common.business.http.UpdateRepository$newCheckUpdate$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.tal.app.thinkacademy.common.business.http.UpdateRepository$newCheckUpdate$1 r0 = (com.tal.app.thinkacademy.common.business.http.UpdateRepository$newCheckUpdate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.common.business.http.UpdateRepository$newCheckUpdate$1 r0 = new com.tal.app.thinkacademy.common.business.http.UpdateRepository$newCheckUpdate$1
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
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r2 = (com.tal.app.thinkacademy.common.network.NetData) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005b
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.tal.app.thinkacademy.common.network.NetData r2 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl r7 = com.tal.app.thinkacademy.common.imconfig.ServerConfigUrl.INSTANCE
            java.lang.String r7 = r7.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.common.business.http.UpdateApi> r5 = com.tal.app.thinkacademy.common.business.http.UpdateApi.class
            java.lang.Object r7 = com.tal.app.thinkacademy.lib.network.Api.create(r7, r5)
            com.tal.app.thinkacademy.common.business.http.UpdateApi r7 = (com.tal.app.thinkacademy.common.business.http.UpdateApi) r7
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.newCheckUpdate(r0)
            if (r7 != r1) goto L_0x005b
            return r1
        L_0x005b:
            com.tal.app.thinkacademy.lib.restful.HiResponse r7 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r7
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r2.transform(r7, r0)
            if (r7 != r1) goto L_0x0069
            return r1
        L_0x0069:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.business.http.UpdateRepository.newCheckUpdate(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
