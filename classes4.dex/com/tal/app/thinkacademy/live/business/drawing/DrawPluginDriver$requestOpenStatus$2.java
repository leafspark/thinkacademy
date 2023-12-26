package com.tal.app.thinkacademy.live.business.drawing;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver$requestOpenStatus$2", f = "DrawPluginDriver.kt", i = {}, l = {190, 189}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DrawPluginDriver.kt */
final class DrawPluginDriver$requestOpenStatus$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DrawPluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawPluginDriver$requestOpenStatus$2(DrawPluginDriver drawPluginDriver, Continuation<? super DrawPluginDriver$requestOpenStatus$2> continuation) {
        super(2, continuation);
        this.this$0 = drawPluginDriver;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new DrawPluginDriver$requestOpenStatus$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0024
            if (r1 == r4) goto L_0x001c
            if (r1 != r2) goto L_0x0014
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0086
        L_0x0014:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001c:
            java.lang.Object r1 = r8.L$0
            com.tal.app.thinkacademy.common.network.NetData r1 = (com.tal.app.thinkacademy.common.network.NetData) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0076
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.imconfig.ImConfig r9 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r9 = r9.getOverseaApi()
            java.lang.String r1 = "/classroom-hub/wall/student/status"
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r1)
            com.tal.app.thinkacademy.live.business.drawing.StatusBean r1 = new com.tal.app.thinkacademy.live.business.drawing.StatusBean
            com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver r5 = r8.this$0
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r5 = r5.courseInfo
            if (r5 != 0) goto L_0x003f
            r5 = r3
            goto L_0x0048
        L_0x003f:
            int r5 = r5.getPlanId()
            long r5 = (long) r5
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)
        L_0x0048:
            com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver r6 = r8.this$0
            com.tal.app.thinkacademy.live.business.drawing.GraffitiBean r6 = r6.graffitiBean
            if (r6 != 0) goto L_0x0056
            java.lang.String r6 = "graffitiBean"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r6 = r3
        L_0x0056:
            java.lang.String r6 = r6.getInteractId()
            r1.<init>(r5, r6)
            com.tal.app.thinkacademy.common.network.NetData r5 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            java.lang.Class<com.tal.app.thinkacademy.live.business.drawing.DrawApi> r6 = com.tal.app.thinkacademy.live.business.drawing.DrawApi.class
            java.lang.Object r6 = com.tal.app.thinkacademy.lib.network.Api.create(r6)
            com.tal.app.thinkacademy.live.business.drawing.DrawApi r6 = (com.tal.app.thinkacademy.live.business.drawing.DrawApi) r6
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r8.L$0 = r5
            r8.label = r4
            java.lang.Object r9 = r6.requestOpenStatus(r9, r1, r7)
            if (r9 != r0) goto L_0x0075
            return r0
        L_0x0075:
            r1 = r5
        L_0x0076:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r5 = r8
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r8.L$0 = r3
            r8.label = r2
            java.lang.Object r9 = r1.transform(r9, r5)
            if (r9 != r0) goto L_0x0086
            return r0
        L_0x0086:
            com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosOnTheWallState r9 = (com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosOnTheWallState) r9
            if (r9 != 0) goto L_0x008b
            goto L_0x009b
        L_0x008b:
            java.lang.Boolean r0 = r9.isSubmit()
            if (r0 != 0) goto L_0x0092
            goto L_0x009b
        L_0x0092:
            com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver r1 = r8.this$0
            boolean r0 = r0.booleanValue()
            r1.isSubmit = r0
        L_0x009b:
            if (r9 != 0) goto L_0x009e
            goto L_0x00ae
        L_0x009e:
            java.lang.Boolean r0 = r9.getIsHandUp()
            if (r0 != 0) goto L_0x00a5
            goto L_0x00ae
        L_0x00a5:
            com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver r1 = r8.this$0
            boolean r0 = r0.booleanValue()
            r1.isHandUp = r0
        L_0x00ae:
            r0 = 0
            if (r9 != 0) goto L_0x00b3
        L_0x00b1:
            r1 = r0
            goto L_0x00c2
        L_0x00b3:
            java.lang.Integer r1 = r9.getInteractStatus()
            r2 = 3
            if (r1 != 0) goto L_0x00bb
            goto L_0x00b1
        L_0x00bb:
            int r1 = r1.intValue()
            if (r1 != r2) goto L_0x00b1
            r1 = r4
        L_0x00c2:
            if (r1 != 0) goto L_0x00e5
            if (r9 != 0) goto L_0x00c7
            goto L_0x00d3
        L_0x00c7:
            java.lang.Boolean r9 = r9.isSubmit()
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r0)
        L_0x00d3:
            if (r0 == 0) goto L_0x00e5
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r9 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r0 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_CAN_CLEAR
            java.lang.String r1 = "is_take_draw"
            r9.put((java.lang.String) r1, (boolean) r4, (int) r0)
            com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver r9 = r8.this$0
            r9.pubPlugin()
        L_0x00e5:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver$requestOpenStatus$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
