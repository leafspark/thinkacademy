package com.tal.app.thinkacademy.business.login.view.devicetest.driver;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MicTestDriver.kt */
final class MicTestDriver$load$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ MicTestDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MicTestDriver$load$2(MicTestDriver micTestDriver) {
        super(1);
        this.this$0 = micTestDriver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        XesLog.it(MicTestDriver.TAG, new Object[]{Intrinsics.stringPlus("麦克风权限请求 garden=", Boolean.valueOf(z))});
        if (z) {
            this.this$0.startInputTest();
            return;
        }
        Function1<Boolean, Unit> mResultCallBlock = this.this$0.getMResultCallBlock();
        if (mResultCallBlock != null) {
            mResultCallBlock.invoke(false);
        }
        this.this$0.showNoPermissionView();
    }
}
