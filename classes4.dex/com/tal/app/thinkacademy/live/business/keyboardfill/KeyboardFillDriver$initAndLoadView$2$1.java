package com.tal.app.thinkacademy.live.business.keyboardfill;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.abilitypack.keyboardfill.KeyboardFillViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardFillDriver.kt */
final class KeyboardFillDriver$initAndLoadView$2$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ KeyboardFillDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KeyboardFillDriver$initAndLoadView$2$1(KeyboardFillDriver keyboardFillDriver) {
        super(1);
        this.this$0 = keyboardFillDriver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        XesLog.a(KeyboardFillDriver.TAG, Intrinsics.stringPlus("用户主动提交：", str));
        KeyboardFillViewModel access$getMKeyboardFillViewModel$p = this.this$0.mKeyboardFillViewModel;
        if (access$getMKeyboardFillViewModel$p != null && access$getMKeyboardFillViewModel$p.isSubmitPosting()) {
            XesLog.a(KeyboardFillDriver.TAG, Intrinsics.stringPlus("数据提交中 ：", str));
        } else {
            this.this$0.commitResult(str, CommitScene.UserCommit);
        }
    }
}
