package com.tal.app.thinkacademy.live.business.photosonthewall.ui;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.tal.app.thinkacademy.lib.util.constant.TimeConstants;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/business/photosonthewall/ui/TakePhotoActivity$startCountdown$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TakePhotoActivity.kt */
public final class TakePhotoActivity$startCountdown$1 extends CountDownTimer {
    final /* synthetic */ long $mDuration;
    final /* synthetic */ TakePhotoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TakePhotoActivity$startCountdown$1(long j, TakePhotoActivity takePhotoActivity) {
        super(j, 1000);
        this.$mDuration = j;
        this.this$0 = takePhotoActivity;
    }

    public void onTick(long j) {
        long j2 = (long) 1000;
        long j3 = j + j2;
        int i = (int) (j3 / ((long) TimeConstants.MIN));
        int i2 = (int) ((j3 / j2) % ((long) 60));
        String stringPlus = i < 10 ? Intrinsics.stringPlus(EnterRoomMuteData.STATUS_UN_MUTE, Integer.valueOf(i)) : String.valueOf(i);
        String stringPlus2 = i2 < 10 ? Intrinsics.stringPlus(EnterRoomMuteData.STATUS_UN_MUTE, Integer.valueOf(i2)) : String.valueOf(i2);
        TextView textView = this.this$0.getBinding().tvCountdown;
        textView.setText(stringPlus + ':' + stringPlus2);
    }

    public void onFinish() {
        this.this$0.getBinding().tvCountdown.setText("00:00");
    }
}
