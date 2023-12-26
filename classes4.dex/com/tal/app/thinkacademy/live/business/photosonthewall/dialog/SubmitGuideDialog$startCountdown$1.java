package com.tal.app.thinkacademy.live.business.photosonthewall.dialog;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.tal.app.thinkacademy.live.business.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/business/photosonthewall/dialog/SubmitGuideDialog$startCountdown$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubmitGuideDialog.kt */
public final class SubmitGuideDialog$startCountdown$1 extends CountDownTimer {
    final /* synthetic */ long $mDuration;
    final /* synthetic */ SubmitGuideDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubmitGuideDialog$startCountdown$1(long j, SubmitGuideDialog submitGuideDialog) {
        super(j, 1000);
        this.$mDuration = j;
        this.this$0 = submitGuideDialog;
    }

    public void onTick(long j) {
        long j2 = (long) 1000;
        int i = (int) (((j + j2) / j2) % ((long) 60));
        TextView textView = this.this$0.binding.tvSubmit;
        if (textView != null) {
            textView.setText(this.this$0.getContext().getString(R.string.Yes) + " (" + i + "S)");
        }
    }

    public void onFinish() {
        TextView textView = this.this$0.binding.tvSubmit;
        if (textView != null) {
            textView.setText(Intrinsics.stringPlus(this.this$0.getContext().getString(R.string.Yes), " (0S)"));
        }
        this.this$0.dismiss();
        Function1 access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            access$getListener$p.invoke(SubmitGuideOperating.TimeEnds);
        }
    }
}
