package com.tal.app.thinkacademy.business.home.main.dialog;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "code", "", "msg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MainDialogManager.kt */
final class MainDialogManager$startChain$1 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ MainDialogManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainDialogManager$startChain$1(MainDialogManager mainDialogManager) {
        super(2);
        this.this$0 = mainDialogManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, String str) {
        String access$getTAG$p = this.this$0.TAG;
        XesLog.dt(access$getTAG$p, new Object[]{"launchWithException code = " + i + " ; msg = " + str});
        this.this$0.startChain();
    }
}
