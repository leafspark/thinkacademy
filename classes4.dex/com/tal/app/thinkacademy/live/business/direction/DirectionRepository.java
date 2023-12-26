package com.tal.app.thinkacademy.live.business.direction;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/direction/DirectionRepository;", "", "()V", "getDirectionGold", "Lcom/tal/app/thinkacademy/live/business/direction/DirectionBean;", "planId", "", "interactId", "", "interactType", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DirectionRepository.kt */
public final class DirectionRepository {
    public static /* synthetic */ Object getDirectionGold$default(DirectionRepository directionRepository, Integer num, String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        return directionRepository.getDirectionGold(num, str, str2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c1 A[PHI: r11 
      PHI: (r11v2 java.lang.Object) = (r11v5 java.lang.Object), (r11v1 java.lang.Object) binds: [B:31:0x00be, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getDirectionGold(java.lang.Integer r8, java.lang.String r9, java.lang.String r10, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.live.business.direction.DirectionBean> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.tal.app.thinkacademy.live.business.direction.DirectionRepository$getDirectionGold$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.tal.app.thinkacademy.live.business.direction.DirectionRepository$getDirectionGold$1 r0 = (com.tal.app.thinkacademy.live.business.direction.DirectionRepository$getDirectionGold$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.live.business.direction.DirectionRepository$getDirectionGold$1 r0 = new com.tal.app.thinkacademy.live.business.direction.DirectionRepository$getDirectionGold$1
            r0.<init>(r7, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c1
        L_0x002e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0036:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00b3
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r11)
            com.tal.app.thinkacademy.common.imconfig.ImConfig r11 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r11 = r11.getOverseaApi()
            java.lang.String r2 = "/api/classroom/v1/student/getSendToTargetUserCoinInfo"
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r11, r2)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r5 = r2
            java.util.Map r5 = (java.util.Map) r5
            java.lang.String r6 = "planId"
            r5.put(r6, r8)
            java.lang.String r8 = "interactId"
            r5.put(r8, r9)
            r8 = r10
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x006e
            int r8 = r8.length()
            if (r8 != 0) goto L_0x006c
            goto L_0x006e
        L_0x006c:
            r8 = 0
            goto L_0x006f
        L_0x006e:
            r8 = r4
        L_0x006f:
            if (r8 != 0) goto L_0x0076
            java.lang.String r8 = "interactType"
            r5.put(r8, r10)
        L_0x0076:
            okhttp3.RequestBody$Companion r8 = okhttp3.RequestBody.Companion
            okhttp3.MediaType$Companion r9 = okhttp3.MediaType.Companion
            java.lang.String r10 = "application/json;charset=UTF-8"
            okhttp3.MediaType r9 = r9.parse(r10)
            com.google.gson.Gson r10 = new com.google.gson.Gson
            r10.<init>()
            boolean r5 = r10 instanceof com.google.gson.Gson
            if (r5 != 0) goto L_0x008e
            java.lang.String r10 = r10.toJson(r2)
            goto L_0x0094
        L_0x008e:
            com.google.gson.Gson r10 = (com.google.gson.Gson) r10
            java.lang.String r10 = com.bonree.sdk.agent.engine.external.GsonInstrumentation.toJson(r10, r2)
        L_0x0094:
            java.lang.String r2 = "Gson().toJson(paramsMap)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)
            okhttp3.RequestBody r8 = r8.create(r9, r10)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.live.business.direction.DirectionApi> r10 = com.tal.app.thinkacademy.live.business.direction.DirectionApi.class
            java.lang.Object r10 = com.tal.app.thinkacademy.lib.network.Api.create(r10)
            com.tal.app.thinkacademy.live.business.direction.DirectionApi r10 = (com.tal.app.thinkacademy.live.business.direction.DirectionApi) r10
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r11 = r10.getDirectionGold(r11, r8, r0)
            if (r11 != r1) goto L_0x00b2
            return r1
        L_0x00b2:
            r8 = r9
        L_0x00b3:
            com.tal.app.thinkacademy.lib.restful.HiResponse r11 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r11
            r9 = 0
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r11 = r8.transform(r11, r0)
            if (r11 != r1) goto L_0x00c1
            return r1
        L_0x00c1:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.direction.DirectionRepository.getDirectionGold(java.lang.Integer, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
