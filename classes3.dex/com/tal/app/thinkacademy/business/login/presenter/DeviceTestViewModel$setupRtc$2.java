package com.tal.app.thinkacademy.business.login.presenter;

import com.tal.app.thinkacademy.business.login.entity.NetTestState;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.widget.RtcNetTestCallback;
import com.tal.app.thinkacademy.lib.player.widget.RtcTest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/business/login/presenter/DeviceTestViewModel$setupRtc$2", "Lcom/tal/app/thinkacademy/lib/player/widget/RtcNetTestCallback;", "onRtcOnceLastMileQuality", "", "quality", "", "type", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceTestViewModel.kt */
public final class DeviceTestViewModel$setupRtc$2 implements RtcNetTestCallback {
    final /* synthetic */ DeviceTestViewModel this$0;

    DeviceTestViewModel$setupRtc$2(DeviceTestViewModel deviceTestViewModel) {
        this.this$0 = deviceTestViewModel;
    }

    public void onRtcOnceLastMileQuality(int i, String str) {
        Intrinsics.checkNotNullParameter(str, ClassParamsKt.TYPE);
        if (!this.this$0.mEnableRtcTest) {
            XesLog.it("DeviceTest_VM", new Object[]{"rtc网络状态回调，rtc网络测试结束"});
            return;
        }
        DeviceTestViewModel deviceTestViewModel = this.this$0;
        deviceTestViewModel.mRtcNetCheckCount = deviceTestViewModel.mRtcNetCheckCount + 1;
        DeviceTestViewModel deviceTestViewModel2 = this.this$0;
        deviceTestViewModel2.mRtcMaxQuality = (i == 8 || i <= deviceTestViewModel2.mRtcMaxQuality) ? this.this$0.mRtcMaxQuality : i;
        XesLog.it("DeviceTest_VM", new Object[]{"Rtc网络检测结果 count=" + this.this$0.mRtcNetCheckCount + " quality=" + i + " resultMaxQuality=" + this.this$0.mRtcMaxQuality});
        if (this.this$0.mRtcNetCheckCount >= 3) {
            XesLog.it("DeviceTest_VM", new Object[]{Intrinsics.stringPlus("rtc网络状态回调，测试结束 ,maxQuality:", Integer.valueOf(i))});
            this.this$0.mEnableRtcTest = false;
            this.this$0.mHandler.removeCallbacks(this.this$0.mRtcTimer);
            RtcTest access$getMRtcTest$p = this.this$0.mRtcTest;
            if (access$getMRtcTest$p != null) {
                access$getMRtcTest$p.disableLastMileProbeTest();
            }
            this.this$0.getMNetTestState().postStickyData(NetTestState.INSTANCE.createRtcBean(i));
            this.this$0.mRtcMaxQuality = 0;
            this.this$0.mRtcNetCheckCount = 0;
        }
    }
}
