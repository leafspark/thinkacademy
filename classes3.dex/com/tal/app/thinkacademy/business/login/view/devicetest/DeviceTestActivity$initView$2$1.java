package com.tal.app.thinkacademy.business.login.view.devicetest;

import com.tal.app.thinkacademy.business.login.view.customview.DeviceTestStepTitle;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkcademy.lib.commui.widget.ViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "index", "", "result", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceTestActivity.kt */
final class DeviceTestActivity$initView$2$1 extends Lambda implements Function2<Integer, Boolean, Unit> {
    final /* synthetic */ DeviceTestStepTitle $layoutDeviceStep;
    final /* synthetic */ DeviceTestActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceTestActivity$initView$2$1(DeviceTestActivity deviceTestActivity, DeviceTestStepTitle deviceTestStepTitle) {
        super(2);
        this.this$0 = deviceTestActivity;
        this.$layoutDeviceStep = deviceTestStepTitle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, boolean z) {
        ViewState viewState;
        XesLog.it("DeviceTest_Activity", new Object[]{"driverResultCall " + i + ' ' + z});
        if (z) {
            viewState = ViewState.THREE;
        } else {
            viewState = ViewState.FOUR;
        }
        if (i == 0) {
            this.this$0.mDeviceTestResult.setNetwork(z);
            this.$layoutDeviceStep.changeNet(viewState);
        } else if (i == 1) {
            this.this$0.mDeviceTestResult.setMic(z);
            this.$layoutDeviceStep.changeMic(viewState);
        } else if (i == 2) {
            this.this$0.mDeviceTestResult.setCamera(z);
            this.$layoutDeviceStep.changeCamera(viewState);
        } else if (i == 3) {
            this.this$0.mDeviceTestResult.setVoice(z);
            this.$layoutDeviceStep.changeVoice(viewState);
        }
    }
}
