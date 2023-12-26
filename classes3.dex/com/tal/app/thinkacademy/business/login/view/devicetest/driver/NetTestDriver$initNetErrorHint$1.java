package com.tal.app.thinkacademy.business.login.view.devicetest.driver;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.view.devicetest.DeviceNetHintDialog;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/business/login/view/devicetest/driver/NetTestDriver$initNetErrorHint$1", "Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/NTClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetTestDriver.kt */
public final class NetTestDriver$initNetErrorHint$1 extends NTClickableSpan {
    final /* synthetic */ NetTestDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetTestDriver$initNetErrorHint$1(NetTestDriver netTestDriver, int i) {
        super(i);
        this.this$0 = netTestDriver;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        XesLog.it("DeviceTest_NetTest", new Object[]{"网络异常提示点击"});
        NetTestDriver netTestDriver = this.this$0;
        NetTestDriver$initNetErrorHint$1 netTestDriver$initNetErrorHint$1 = this;
        DeviceNetHintDialog access$getMNetErrorHintDialog$p = netTestDriver.mNetErrorHintDialog;
        if (access$getMNetErrorHintDialog$p == null) {
            access$getMNetErrorHintDialog$p = new DeviceNetHintDialog(netTestDriver.getMDriverOwner().getContext());
            netTestDriver.mNetErrorHintDialog = access$getMNetErrorHintDialog$p;
        }
        access$getMNetErrorHintDialog$p.show();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
