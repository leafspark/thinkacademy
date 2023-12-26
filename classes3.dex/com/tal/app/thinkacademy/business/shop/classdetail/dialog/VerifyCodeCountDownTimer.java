package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import android.os.CountDownTimer;
import android.text.TextUtils;
import android.widget.TextView;
import com.tal.app.thinkacademy.business.login.widget.LoginCountDownTimer;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000bR\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/VerifyCodeCountDownTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "tvSecond", "Landroid/widget/TextView;", "(JJLandroid/widget/TextView;)V", "TAG", "", "mTimeListener", "Lcom/tal/app/thinkacademy/business/login/widget/LoginCountDownTimer$ITimerListener;", "remainingMillis", "getTimer", "isTick", "", "onFinish", "", "onTick", "millisUntilFinished", "reset", "setTimerListener", "listener", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VerifyCodeCountDownTimer.kt */
public final class VerifyCodeCountDownTimer extends CountDownTimer {
    private final String TAG = "VerifyCodeCountDownTimer";
    private LoginCountDownTimer.ITimerListener mTimeListener;
    private long remainingMillis = -1;
    private TextView tvSecond;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerifyCodeCountDownTimer(long j, long j2, TextView textView) {
        super(j, j2);
        Intrinsics.checkNotNullParameter(textView, "tvSecond");
        this.tvSecond = textView;
    }

    public void onFinish() {
        this.remainingMillis = -1;
        LoginCountDownTimer.ITimerListener iTimerListener = this.mTimeListener;
        if (iTimerListener != null && iTimerListener != null) {
            iTimerListener.onFinish();
        }
    }

    public void onTick(long j) {
        this.remainingMillis = j;
        XesLog.dt(this.TAG, new Object[]{Intrinsics.stringPlus("millisUntilFinished = ", Long.valueOf(j))});
        this.tvSecond.setText(TextUtils.concat(new CharSequence[]{String.valueOf(j / ((long) 1000)), "S"}));
    }

    public final long getTimer() {
        return this.remainingMillis;
    }

    public final boolean isTick() {
        return this.remainingMillis > 0;
    }

    public final void reset() {
        this.remainingMillis = -1;
        cancel();
    }

    public final void setTimerListener(LoginCountDownTimer.ITimerListener iTimerListener) {
        Intrinsics.checkNotNullParameter(iTimerListener, "listener");
        this.mTimeListener = iTimerListener;
    }
}
