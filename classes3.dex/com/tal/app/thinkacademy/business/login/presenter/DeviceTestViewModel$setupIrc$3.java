package com.tal.app.thinkacademy.business.login.presenter;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.login.entity.NetTestState;
import com.tal.app.thinkacademy.lib.irc.IrcEngine;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "success", "", "result", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceTestViewModel.kt */
final class DeviceTestViewModel$setupIrc$3 extends Lambda implements Function2<Boolean, String, Unit> {
    final /* synthetic */ DeviceTestViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceTestViewModel$setupIrc$3(DeviceTestViewModel deviceTestViewModel) {
        super(2);
        this.this$0 = deviceTestViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Boolean) obj).booleanValue(), (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, DbParams.KEY_CHANNEL_RESULT);
        if (z) {
            DeviceTestViewModel deviceTestViewModel = this.this$0;
            deviceTestViewModel.mIrcRecvCount = deviceTestViewModel.mIrcRecvCount + 1;
            if (this.this$0.mIrcRecvCount >= 19) {
                int access$getMIrcRecvCount$p = this.this$0.mIrcRecvCount;
                this.this$0.mIrcRecvCount = 0;
                XesLog.it("DeviceTest_VM", new Object[]{Intrinsics.stringPlus("setIrcMsgSendResult success, ", Integer.valueOf(access$getMIrcRecvCount$p))});
                this.this$0.mHandler.removeCallbacks(this.this$0.mIrcTimer);
                this.this$0.mIrcTesting = false;
                this.this$0.mIsIrcInit = false;
                IrcEngine access$getMIrcEngine$p = this.this$0.mIrcEngine;
                if (access$getMIrcEngine$p != null) {
                    access$getMIrcEngine$p.release();
                }
                this.this$0.getMNetTestState().postStickyData(NetTestState.INSTANCE.createIrcBean(access$getMIrcRecvCount$p));
                return;
            }
            return;
        }
        XesLog.it("DeviceTest_VM", new Object[]{Intrinsics.stringPlus("setIrcMsgSendResult fail, ", str)});
    }
}
