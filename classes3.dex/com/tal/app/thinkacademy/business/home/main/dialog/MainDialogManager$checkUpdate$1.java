package com.tal.app.thinkacademy.business.home.main.dialog;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000321\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005H@"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "next", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "previous", "Lkotlin/coroutines/Continuation;", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.home.main.dialog.MainDialogManager$checkUpdate$1", f = "MainDialogManager.kt", i = {0}, l = {60, 63}, m = "invokeSuspend", n = {"next"}, s = {"L$0"})
/* compiled from: MainDialogManager.kt */
final class MainDialogManager$checkUpdate$1 extends SuspendLambda implements Function3<Boolean, Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MainDialogManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainDialogManager$checkUpdate$1(MainDialogManager mainDialogManager, Continuation<? super MainDialogManager$checkUpdate$1> continuation) {
        super(3, continuation);
        this.this$0 = mainDialogManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Boolean) obj).booleanValue(), (Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object>) (Function2) obj2, (Continuation<? super Unit>) (Continuation) obj3);
    }

    public final Object invoke(boolean z, Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        MainDialogManager$checkUpdate$1 mainDialogManager$checkUpdate$1 = new MainDialogManager$checkUpdate$1(this.this$0, continuation);
        mainDialogManager$checkUpdate$1.L$0 = function2;
        return mainDialogManager$checkUpdate$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: Multi-variable type inference failed */
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
            goto L_0x008b
        L_0x0014:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001c:
            java.lang.Object r1 = r8.L$0
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x004f
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            r1 = r9
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            com.tal.app.thinkacademy.business.home.main.dialog.MainDialogManager r9 = r8.this$0
            java.lang.String r9 = r9.TAG
            java.lang.Object[] r5 = new java.lang.Object[r4]
            java.lang.String r6 = "checkUpdate start"
            r5[r3] = r6
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r9, r5)
            com.tal.app.thinkacademy.common.business.AppVersionBll$Companion r9 = com.tal.app.thinkacademy.common.business.AppVersionBll.Companion
            com.tal.app.thinkacademy.common.business.AppVersionBll r9 = r9.getInstance()
            r5 = r8
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r8.L$0 = r1
            r8.label = r4
            java.lang.Object r9 = r9.checkUpdate(r5)
            if (r9 != r0) goto L_0x004f
            return r0
        L_0x004f:
            com.tal.app.thinkacademy.common.entity.UpdateVersionEntity r9 = (com.tal.app.thinkacademy.common.entity.UpdateVersionEntity) r9
            com.tal.app.thinkacademy.common.business.AppVersionBll$Companion r5 = com.tal.app.thinkacademy.common.business.AppVersionBll.Companion
            com.tal.app.thinkacademy.common.business.AppVersionBll r5 = r5.getInstance()
            com.tal.app.thinkacademy.business.home.main.dialog.MainDialogManager r6 = r8.this$0
            com.tal.app.thinkacademy.business.home.main.MainActivity r6 = r6.activity
            android.content.Context r6 = (android.content.Context) r6
            r5.appUpdateCheck(r6, r9, r4)
            com.tal.app.thinkacademy.business.home.main.dialog.MainDialogManager r5 = r8.this$0
            java.lang.String r5 = r5.TAG
            java.lang.Object[] r6 = new java.lang.Object[r4]
            java.lang.String r7 = "checkUpdate end"
            r6[r3] = r7
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r5, r6)
            if (r9 != 0) goto L_0x0074
            goto L_0x007b
        L_0x0074:
            int r9 = r9.getNeedUpgrade()
            if (r9 != r4) goto L_0x007b
            r3 = r4
        L_0x007b:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r3 = 0
            r8.L$0 = r3
            r8.label = r2
            java.lang.Object r9 = r1.invoke(r9, r8)
            if (r9 != r0) goto L_0x008b
            return r0
        L_0x008b:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.dialog.MainDialogManager$checkUpdate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
