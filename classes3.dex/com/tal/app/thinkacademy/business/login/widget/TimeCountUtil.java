package com.tal.app.thinkacademy.business.login.widget;

import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.lib.language.AppUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0017J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/widget/TimeCountUtil;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "getCode", "Landroid/widget/TextView;", "(JJLandroid/widget/TextView;)V", "iTimer", "Lcom/tal/app/thinkacademy/business/login/widget/TimeCountUtil$ITimer;", "timer", "getTimer", "onFinish", "", "onTick", "millisUntilFinished", "setiTimer", "ITimer", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TimeCountUtil.kt */
public final class TimeCountUtil extends CountDownTimer {
    private TextView getCode;
    private ITimer iTimer;
    private long timer = -1;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/widget/TimeCountUtil$ITimer;", "", "finis", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TimeCountUtil.kt */
    public interface ITimer {
        void finis();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimeCountUtil(long j, long j2, TextView textView) {
        super(j, j2);
        Intrinsics.checkNotNullParameter(textView, "getCode");
        this.getCode = textView;
    }

    public void onFinish() {
        this.getCode.setText(AppUtil.getApplication().getApplicationContext().getString(R.string.login_code_resend));
        this.getCode.setTextColor(ContextCompat.getColor(AppUtil.getApplication().getApplicationContext(), R.color.color_ffaa0a));
        this.getCode.setEnabled(true);
        this.timer = -1;
        ITimer iTimer2 = this.iTimer;
        if (iTimer2 != null) {
            Intrinsics.checkNotNull(iTimer2);
            iTimer2.finis();
        }
    }

    public void onTick(long j) {
        this.timer = j;
        this.getCode.setText(AppUtil.getApplication().getApplicationContext().getString(R.string.login_code_resend_timer, new Object[]{Long.valueOf(j / ((long) 1000))}));
        this.getCode.setTextColor(ContextCompat.getColor(AppUtil.getApplication().getApplicationContext(), R.color.color_999999));
        this.getCode.setEnabled(false);
    }

    public final long getTimer() {
        return this.timer;
    }

    public final void setiTimer(ITimer iTimer2) {
        Intrinsics.checkNotNullParameter(iTimer2, "iTimer");
        this.iTimer = iTimer2;
    }
}
