package com.tal.app.thinkacademy.business.login.view.devicetest;

import com.tal.app.thinkacademy.business.login.view.customview.DeviceTestStepTitle;
import com.tal.app.thinkacademy.common.widget.DeviceTesting;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkcademy.lib.commui.widget.ViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceTestActivity.kt */
final class DeviceTestActivity$initView$2$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ DeviceTestStepTitle $layoutDeviceStep;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceTestActivity$initView$2$2(DeviceTestStepTitle deviceTestStepTitle) {
        super(1);
        this.$layoutDeviceStep = deviceTestStepTitle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        XesLog.it("DeviceTest_Activity", new Object[]{Intrinsics.stringPlus("driverFinishCall ", Integer.valueOf(i))});
        if (i == 0) {
            this.$layoutDeviceStep.changeMic(ViewState.TWO);
        } else if (i == 1) {
            this.$layoutDeviceStep.changeCamera(ViewState.TWO);
        } else if (i == 2) {
            this.$layoutDeviceStep.changeVoice(ViewState.TWO);
        } else if (i == 3) {
            DeviceTesting.INSTANCE.setTestFinished();
        }
    }
}
