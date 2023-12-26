package com.tal.app.thinkacademy.business.login.presenter;

import android.os.Handler;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "key", "", "data", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceTestViewModel.kt */
final class DeviceTestViewModel$setupIrc$2 extends Lambda implements Function2<String, String, Unit> {
    final /* synthetic */ DeviceTestViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceTestViewModel$setupIrc$2(DeviceTestViewModel deviceTestViewModel) {
        super(2);
        this.this$0 = deviceTestViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, DbParams.KEY_DATA);
        if (Intrinsics.areEqual((Object) str, (Object) LocalBusinessKey.LOCAL_JOIN_ROOM)) {
            XesLog.it("DeviceTest_VM", new Object[]{"setIrcDispatch irc 加入教室成功"});
            if (this.this$0.mIrcTesting) {
                XesLog.it("DeviceTest_VM", new Object[]{"startItcCheck irc 执行Irc发送20条消息测试"});
                Handler access$getMHandler$p = this.this$0.mHandler;
                Runnable access$getMIrcSendRunnable$p = this.this$0.mIrcSendRunnable;
                if (!(access$getMHandler$p instanceof Handler)) {
                    access$getMHandler$p.post(access$getMIrcSendRunnable$p);
                } else {
                    AsynchronousInstrumentation.handlerPost(access$getMHandler$p, access$getMIrcSendRunnable$p);
                }
            }
        }
    }
}
