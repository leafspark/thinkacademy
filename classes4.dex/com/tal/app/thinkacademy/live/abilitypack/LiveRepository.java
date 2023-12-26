package com.tal.app.thinkacademy.live.abilitypack;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/LiveRepository;", "", "()V", "check", "Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillResult;", "body", "Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillBody;", "(Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/bean/KeyboardFillBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commit", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveRepository.kt */
public final class LiveRepository {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070 A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:22:0x006d, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object check(com.tal.app.thinkacademy.live.abilitypack.keyboardfill.bean.KeyboardFillBody r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.live.abilitypack.keyboardfill.bean.KeyboardFillResult> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.live.abilitypack.LiveRepository$check$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.live.abilitypack.LiveRepository$check$1 r0 = (com.tal.app.thinkacademy.live.abilitypack.LiveRepository$check$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.live.abilitypack.LiveRepository$check$1 r0 = new com.tal.app.thinkacademy.live.abilitypack.LiveRepository$check$1
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
            goto L_0x0070
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0062
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ImConfig r2 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r2 = r2.getOverseaApi()
            if (r2 != 0) goto L_0x004c
            java.lang.String r2 = ""
        L_0x004c:
            java.lang.Class<com.tal.app.thinkacademy.live.abilitypack.keyboardfill.api.KeyboardFillApi> r5 = com.tal.app.thinkacademy.live.abilitypack.keyboardfill.api.KeyboardFillApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.live.abilitypack.keyboardfill.api.KeyboardFillApi r2 = (com.tal.app.thinkacademy.live.abilitypack.keyboardfill.api.KeyboardFillApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.check(r8, r0)
            if (r8 != r1) goto L_0x005f
            return r1
        L_0x005f:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x0062:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x0070
            return r1
        L_0x0070:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.LiveRepository.check(com.tal.app.thinkacademy.live.abilitypack.keyboardfill.bean.KeyboardFillBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070 A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:22:0x006d, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object commit(com.tal.app.thinkacademy.live.abilitypack.keyboardfill.bean.KeyboardFillBody r8, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.live.abilitypack.keyboardfill.bean.KeyboardFillResult> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.live.abilitypack.LiveRepository$commit$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.live.abilitypack.LiveRepository$commit$1 r0 = (com.tal.app.thinkacademy.live.abilitypack.LiveRepository$commit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.live.abilitypack.LiveRepository$commit$1 r0 = new com.tal.app.thinkacademy.live.abilitypack.LiveRepository$commit$1
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
            goto L_0x0070
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0062
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.imconfig.ImConfig r2 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r2 = r2.getOverseaApi()
            if (r2 != 0) goto L_0x004c
            java.lang.String r2 = ""
        L_0x004c:
            java.lang.Class<com.tal.app.thinkacademy.live.abilitypack.keyboardfill.api.KeyboardFillApi> r5 = com.tal.app.thinkacademy.live.abilitypack.keyboardfill.api.KeyboardFillApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.live.abilitypack.keyboardfill.api.KeyboardFillApi r2 = (com.tal.app.thinkacademy.live.abilitypack.keyboardfill.api.KeyboardFillApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.commit(r8, r0)
            if (r8 != r1) goto L_0x005f
            return r1
        L_0x005f:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x0062:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x0070
            return r1
        L_0x0070:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.LiveRepository.commit(com.tal.app.thinkacademy.live.abilitypack.keyboardfill.bean.KeyboardFillBody, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
