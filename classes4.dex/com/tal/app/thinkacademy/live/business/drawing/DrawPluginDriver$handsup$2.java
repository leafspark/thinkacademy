package com.tal.app.thinkacademy.live.business.drawing;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver$handsup$2", f = "DrawPluginDriver.kt", i = {}, l = {498, 498}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DrawPluginDriver.kt */
final class DrawPluginDriver$handsup$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $classId;
    final /* synthetic */ String $interactId;
    final /* synthetic */ Long $planId;
    final /* synthetic */ Long $tutorId;
    Object L$0;
    int label;
    final /* synthetic */ DrawPluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawPluginDriver$handsup$2(Long l, Long l2, Long l3, String str, DrawPluginDriver drawPluginDriver, Continuation<? super DrawPluginDriver$handsup$2> continuation) {
        super(2, continuation);
        this.$planId = l;
        this.$classId = l2;
        this.$tutorId = l3;
        this.$interactId = str;
        this.this$0 = drawPluginDriver;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new DrawPluginDriver$handsup$2(this.$planId, this.$classId, this.$tutorId, this.$interactId, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r4) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x006e
        L_0x0013:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x001b:
            java.lang.Object r1 = r13.L$0
            com.tal.app.thinkacademy.common.network.NetData r1 = (com.tal.app.thinkacademy.common.network.NetData) r1
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x005e
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r14)
            com.tal.app.thinkacademy.common.imconfig.ImConfig r14 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r14 = r14.getOverseaApi()
            java.lang.String r1 = "/api/wall/v1/student/handsup"
            java.lang.String r14 = kotlin.jvm.internal.Intrinsics.stringPlus(r14, r1)
            com.tal.app.thinkacademy.live.business.drawing.ParamsBean r1 = new com.tal.app.thinkacademy.live.business.drawing.ParamsBean
            java.lang.Long r6 = r13.$planId
            java.lang.Long r7 = r13.$classId
            java.lang.Long r8 = r13.$tutorId
            java.lang.String r9 = r13.$interactId
            r11 = 722(0x2d2, float:1.012E-42)
            r12 = 0
            java.lang.String r10 = ""
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            com.tal.app.thinkacademy.common.network.NetData r5 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.live.business.drawing.DrawApi> r6 = com.tal.app.thinkacademy.live.business.drawing.DrawApi.class
            java.lang.Object r6 = com.tal.app.thinkacademy.lib.network.Api.create(r6)
            com.tal.app.thinkacademy.live.business.drawing.DrawApi r6 = (com.tal.app.thinkacademy.live.business.drawing.DrawApi) r6
            r7 = r13
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r13.L$0 = r5
            r13.label = r4
            java.lang.Object r14 = r6.handsup(r14, r1, r7)
            if (r14 != r0) goto L_0x005d
            return r0
        L_0x005d:
            r1 = r5
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r14 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r14
            r5 = r13
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r13.L$0 = r3
            r13.label = r2
            java.lang.Object r14 = r1.transform(r14, r5)
            if (r14 != r0) goto L_0x006e
            return r0
        L_0x006e:
            com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotoSubmitResult r14 = (com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotoSubmitResult) r14
            com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver r0 = r13.this$0
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r2 = 0
            java.lang.String r4 = "举手接口请求success; data = "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r14)
            r1[r2] = r4
            r0.log(r1)
            com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver r0 = r13.this$0
            com.tal.app.thinkacademy.live.business.drawing.DrawPluginViewTools r0 = r0.pluginView
            if (r0 != 0) goto L_0x0089
            goto L_0x00a3
        L_0x0089:
            if (r14 != 0) goto L_0x008d
            r1 = r3
            goto L_0x0095
        L_0x008d:
            int r1 = r14.getUserLatestCoin()
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
        L_0x0095:
            if (r14 != 0) goto L_0x0098
            goto L_0x00a0
        L_0x0098:
            int r14 = r14.getRightCoin()
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r14)
        L_0x00a0:
            r0.showHandsUpView(r1, r3)
        L_0x00a3:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver$handsup$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
