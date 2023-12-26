package com.tal.app.thinkacademy.business.login.view.devicetest.driver;

import android.graphics.drawable.Drawable;
import com.tal.app.thinkacademy.common.utils.MkAiSoundSizeUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkcademy.lib.commui.widget.StateImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MicTestDriver.kt */
final class MicTestDriver$startInputTest$1 extends Lambda implements Function1<Double, Unit> {
    final /* synthetic */ MicTestDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MicTestDriver$startInputTest$1(MicTestDriver micTestDriver) {
        super(1);
        this.this$0 = micTestDriver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).doubleValue());
        return Unit.INSTANCE;
    }

    public final void invoke(double d) {
        double calculateHighVolume = MkAiSoundSizeUtil.INSTANCE.calculateHighVolume(d);
        StateImageView access$getMIvMicState$p = this.this$0.mIvMicState;
        Drawable drawable = access$getMIvMicState$p == null ? null : access$getMIvMicState$p.getDrawable();
        if (drawable != null) {
            drawable.setLevel((int) (((double) 10000) * calculateHighVolume));
        }
        MicTestDriver micTestDriver = this.this$0;
        micTestDriver.mMicMaxVolume = micTestDriver.mMicMaxVolume < d ? d : this.this$0.mMicMaxVolume;
        XesLog.it(MicTestDriver.TAG, new Object[]{"麦克风收音大小: " + d + "，UI值：" + calculateHighVolume + "，最大分贝: " + this.this$0.mMicMaxVolume});
    }
}
