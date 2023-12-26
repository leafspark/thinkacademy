package com.tal.app.thinkacademy.business.login.view.devicetest.driver;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkcademy.lib.commui.widget.CircleProgressView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/business/login/view/devicetest/driver/MicTestDriver$load$1", "Lcom/tal/app/thinkcademy/lib/commui/widget/CircleProgressView$OnProgressCallback;", "onEnd", "", "onProgress", "progress", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MicTestDriver.kt */
public final class MicTestDriver$load$1 implements CircleProgressView.OnProgressCallback {
    final /* synthetic */ MicTestDriver this$0;

    public void onProgress(float f) {
    }

    MicTestDriver$load$1(MicTestDriver micTestDriver) {
        this.this$0 = micTestDriver;
    }

    public void onEnd() {
        XesLog.it(MicTestDriver.TAG, new Object[]{"麦克风收音结束"});
        if (this.this$0.mMicMaxVolume > 50.0d) {
            Function1<Boolean, Unit> mResultCallBlock = this.this$0.getMResultCallBlock();
            if (mResultCallBlock != null) {
                mResultCallBlock.invoke(true);
            }
            this.this$0.showMicOk();
        } else {
            Function1<Boolean, Unit> mResultCallBlock2 = this.this$0.getMResultCallBlock();
            if (mResultCallBlock2 != null) {
                mResultCallBlock2.invoke(false);
            }
            this.this$0.showNoVoiceView();
        }
        this.this$0.getMDriverOwner().stopRecord();
    }
}
