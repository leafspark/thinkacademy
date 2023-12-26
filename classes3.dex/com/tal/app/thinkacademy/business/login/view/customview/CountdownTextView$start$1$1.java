package com.tal.app.thinkacademy.business.login.view.customview;

import android.os.CountDownTimer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/business/login/view/customview/CountdownTextView$start$1$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CountdownTextView.kt */
public final class CountdownTextView$start$1$1 extends CountDownTimer {
    final /* synthetic */ long $total;
    final /* synthetic */ long $unity;
    final /* synthetic */ CountdownTextView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CountdownTextView$start$1$1(long j, long j2, CountdownTextView countdownTextView) {
        super(j, j2);
        this.$total = j;
        this.$unity = j2;
        this.this$0 = countdownTextView;
    }

    public void onTick(long j) {
        Function1 access$getMBlock$p = this.this$0.mBlock;
        if (access$getMBlock$p != null) {
            access$getMBlock$p.invoke(Long.valueOf(j));
        }
    }

    public void onFinish() {
        Function1 access$getMBlock$p = this.this$0.mBlock;
        if (access$getMBlock$p != null) {
            access$getMBlock$p.invoke(0L);
        }
    }
}
