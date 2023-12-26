package com.tal.app.thinkacademy.business.home.main.dialog;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000321\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005H@"}, d2 = {"<anonymous>", "", "previous", "", "next", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/coroutines/Continuation;", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.home.main.dialog.MainDialogManager$checkUnpay$1", f = "MainDialogManager.kt", i = {0, 0}, l = {81, 91}, m = "invokeSuspend", n = {"next", "previous"}, s = {"L$0", "Z$0"})
/* compiled from: MainDialogManager.kt */
final class MainDialogManager$checkUnpay$1 extends SuspendLambda implements Function3<Boolean, Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MainDialogManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainDialogManager$checkUnpay$1(MainDialogManager mainDialogManager, Continuation<? super MainDialogManager$checkUnpay$1> continuation) {
        super(3, continuation);
        this.this$0 = mainDialogManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Boolean) obj).booleanValue(), (Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object>) (Function2) obj2, (Continuation<? super Unit>) (Continuation) obj3);
    }

    public final Object invoke(boolean z, Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        MainDialogManager$checkUnpay$1 mainDialogManager$checkUnpay$1 = new MainDialogManager$checkUnpay$1(this.this$0, continuation);
        mainDialogManager$checkUnpay$1.Z$0 = z;
        mainDialogManager$checkUnpay$1.L$0 = function2;
        return mainDialogManager$checkUnpay$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00da A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 0
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x0028
            if (r1 == r5) goto L_0x001d
            if (r1 != r3) goto L_0x0015
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00db
        L_0x0015:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001d:
            boolean r1 = r11.Z$0
            java.lang.Object r6 = r11.L$0
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00a3
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r12)
            boolean r1 = r11.Z$0
            java.lang.Object r12 = r11.L$0
            r6 = r12
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            com.tal.app.thinkacademy.business.home.main.dialog.MainDialogManager r12 = r11.this$0
            java.lang.String r12 = r12.TAG
            java.lang.Object[] r7 = new java.lang.Object[r5]
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            java.lang.String r9 = "checkUnpay start previous "
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r8)
            r7[r4] = r8
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r12, r7)
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r12 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r12 = r12.getInstance()
            boolean r12 = r12.isGuest()
            if (r12 != 0) goto L_0x00bc
            com.tal.app.thinkacademy.business.home.main.dialog.MainDialogManager r12 = r11.this$0
            com.tal.app.thinkacademy.business.home.main.MainActivity r12 = r12.activity
            android.content.Context r12 = (android.content.Context) r12
            boolean r12 = com.tal.app.thinkacademy.common.util.PadUtils.isPad(r12)
            if (r12 != 0) goto L_0x00bc
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r12 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r12 = r12.getInstance()
            com.tal.app.thinkacademy.common.user.UserInfo r12 = r12.getUserInfoEntity()
            if (r12 != 0) goto L_0x0071
            r12 = r2
            goto L_0x0075
        L_0x0071:
            java.lang.String r12 = r12.getUid()
        L_0x0075:
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r7 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r8 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r9 = "school_code"
            java.lang.String r10 = "415"
            java.lang.String r7 = r7.getString(r9, r10, r8)
            com.tal.app.thinkacademy.business.home.main.bean.RedDotPostBody r8 = new com.tal.app.thinkacademy.business.home.main.bean.RedDotPostBody
            com.tal.app.thinkacademy.business.home.main.bean.RedDotPostParams r9 = new com.tal.app.thinkacademy.business.home.main.bean.RedDotPostParams
            r9.<init>(r7, r12)
            r8.<init>(r9)
            com.tal.app.thinkacademy.business.home.main.dialog.MainDialogManager r12 = r11.this$0
            com.tal.app.thinkacademy.business.home.main.api.HomeRepository r12 = r12.repository
            r7 = r11
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r11.L$0 = r6
            r11.Z$0 = r1
            r11.label = r5
            java.lang.Object r12 = r12.getRedDot(r8, r7)
            if (r12 != r0) goto L_0x00a3
            return r0
        L_0x00a3:
            com.tal.app.thinkacademy.business.home.main.bean.UnPayNum r12 = (com.tal.app.thinkacademy.business.home.main.bean.UnPayNum) r12
            com.tal.app.thinkacademy.business.home.main.dialog.PaymentRemindManager r7 = new com.tal.app.thinkacademy.business.home.main.dialog.PaymentRemindManager
            com.tal.app.thinkacademy.business.home.main.dialog.MainDialogManager r8 = r11.this$0
            com.tal.app.thinkacademy.business.home.main.MainActivity r8 = r8.activity
            android.content.Context r8 = (android.content.Context) r8
            r7.<init>(r8, r12)
            r7.showPoint()
            if (r1 != 0) goto L_0x00bc
            boolean r12 = r7.showDialog()
            goto L_0x00bd
        L_0x00bc:
            r12 = r4
        L_0x00bd:
            com.tal.app.thinkacademy.business.home.main.dialog.MainDialogManager r1 = r11.this$0
            java.lang.String r1 = r1.TAG
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r7 = "checkUnpay end"
            r5[r4] = r7
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r1, r5)
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)
            r11.L$0 = r2
            r11.label = r3
            java.lang.Object r12 = r6.invoke(r12, r11)
            if (r12 != r0) goto L_0x00db
            return r0
        L_0x00db:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.dialog.MainDialogManager$checkUnpay$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
