package com.tal.app.thinkacademy.business.login.view.devicetest;

import android.view.View;
import com.tal.app.thinkacademy.lib.commui.widget.bar.OnTitleBarListener;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/business/login/view/devicetest/DeviceTestActivity$initView$1", "Lcom/tal/app/thinkacademy/lib/commui/widget/bar/OnTitleBarListener;", "onLeftClick", "", "v", "Landroid/view/View;", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceTestActivity.kt */
public final class DeviceTestActivity$initView$1 extends OnTitleBarListener {
    final /* synthetic */ DeviceTestActivity this$0;

    DeviceTestActivity$initView$1(DeviceTestActivity deviceTestActivity) {
        this.this$0 = deviceTestActivity;
    }

    public void onLeftClick(View view) {
        XesLog.it("DeviceTest_Activity", new Object[]{"点击TitleBar返回按钮退出页面"});
        this.this$0.finish();
    }
}
