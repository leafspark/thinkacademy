package com.tal.app.thinkacademy.business.login.view.devicetest.driver;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "current", "", "max", "min", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VoiceTestDriver.kt */
final class VoiceTestDriver$load$1 extends Lambda implements Function3<Integer, Integer, Integer, Unit> {
    final /* synthetic */ VoiceTestDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VoiceTestDriver$load$1(VoiceTestDriver voiceTestDriver) {
        super(3);
        this.this$0 = voiceTestDriver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2, int i3) {
        int i4;
        if (i == -1 || i2 == -1) {
            i4 = 0;
        } else {
            i4 = Float.valueOf((((float) (i - i3)) * 100.0f) / ((float) (i2 - i3)));
        }
        int intValue = i4.intValue();
        XesLog.it(VoiceTestDriver.TAG, new Object[]{"当前设备媒体音量 " + i + ", max=" + i2 + ", min=" + i3 + ", percent=" + intValue});
        ProgressBar access$getMProgressVoice$p = this.this$0.mProgressVoice;
        if (access$getMProgressVoice$p != null) {
            access$getMProgressVoice$p.setProgress(intValue);
        }
        TextView access$getMTvVoiceSize$p = this.this$0.mTvVoiceSize;
        if (access$getMTvVoiceSize$p != null) {
            access$getMTvVoiceSize$p.setText(this.this$0.getMDriverOwner().getContext().getString(R.string.volume) + ": " + intValue + '%');
        }
    }
}
