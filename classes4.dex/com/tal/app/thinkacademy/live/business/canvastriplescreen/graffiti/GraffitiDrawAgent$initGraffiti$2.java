package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiDrawAgent$initGraffiti$2", f = "GraffitiDrawAgent.kt", i = {0}, l = {60}, m = "invokeSuspend", n = {"$this$launchWithException"}, s = {"L$0"})
/* compiled from: GraffitiDrawAgent.kt */
final class GraffitiDrawAgent$initGraffiti$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GraffitiDrawAgent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraffitiDrawAgent$initGraffiti$2(GraffitiDrawAgent graffitiDrawAgent, Continuation<? super GraffitiDrawAgent$initGraffiti$2> continuation) {
        super(2, continuation);
        this.this$0 = graffitiDrawAgent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> graffitiDrawAgent$initGraffiti$2 = new GraffitiDrawAgent$initGraffiti$2(this.this$0, continuation);
        graffitiDrawAgent$initGraffiti$2.L$0 = obj;
        return (Continuation) graffitiDrawAgent$initGraffiti$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ad A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002e  */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 != r3) goto L_0x0017
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r11)
            r4 = r1
            r1 = r0
            r0 = r10
            goto L_0x0065
        L_0x0017:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            r1 = r11
            r11 = r10
        L_0x0028:
            boolean r4 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
            if (r4 == 0) goto L_0x00ad
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiDrawAgent r4 = r11.this$0
            boolean r4 = r4.isLook()
            if (r4 == 0) goto L_0x0028
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiDrawAgent r4 = r11.this$0
            kotlinx.coroutines.channels.Channel r4 = r4.mChannel
            if (r4 != 0) goto L_0x0040
        L_0x003e:
            r4 = r2
            goto L_0x0047
        L_0x0040:
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x003e
            r4 = r3
        L_0x0047:
            if (r4 == 0) goto L_0x0028
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiDrawAgent r4 = r11.this$0
            kotlinx.coroutines.channels.Channel r4 = r4.mChannel
            if (r4 != 0) goto L_0x0052
            goto L_0x0028
        L_0x0052:
            r5 = r11
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r11.L$0 = r1
            r11.label = r3
            java.lang.Object r4 = r4.receive(r5)
            if (r4 != r0) goto L_0x0060
            return r0
        L_0x0060:
            r9 = r0
            r0 = r11
            r11 = r4
            r4 = r1
            r1 = r9
        L_0x0065:
            com.xueersi.lib.graffiti.WXWBAction r11 = (com.xueersi.lib.graffiti.WXWBAction) r11
            if (r11 != 0) goto L_0x006a
            goto L_0x00a8
        L_0x006a:
            com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiDrawAgent r5 = r0.this$0
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            long r7 = r11.getMsgId()
            java.lang.Long r7 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)
            java.lang.String r8 = "发送涂鸦 msgId => "
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r7)
            r6[r2] = r7
            java.lang.String r7 = r5.getMPageKey()
            java.lang.String r8 = "dbkey => "
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r7)
            r6[r3] = r7
            r5.log(r6)
            com.tal.app.thinkacademy.live.core.interfaces.IircControllerProvider r6 = r5.mIrcControllerProvider
            if (r6 != 0) goto L_0x0095
            goto L_0x00a8
        L_0x0095:
            java.lang.String r5 = r5.getMPageKey()
            long r7 = r11.getMsgId()
            byte[] r11 = r11.getOriginData()
            boolean r11 = r6.sendRoomBinaryMessage(r5, r7, r11)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
        L_0x00a8:
            r11 = r0
            r0 = r1
            r1 = r4
            goto L_0x0028
        L_0x00ad:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiDrawAgent$initGraffiti$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
