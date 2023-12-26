package com.tal.app.thinkacademy.business.login.view;

import android.widget.TextView;
import com.tal.app.thinkacademy.business.login.presenter.LoginViewModel;
import com.tal.app.thinkacademy.business.login.widget.LoginCountDownTimer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OtpLoginActivity.kt */
final class OtpLoginActivity$setListener$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ OtpLoginActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OtpLoginActivity$setListener$3(OtpLoginActivity otpLoginActivity) {
        super(0);
        this.this$0 = otpLoginActivity;
    }

    public final void invoke() {
        this.this$0.getBinding().etEmailAddress.clearFocus();
        if (this.this$0.mEmailTimer == null) {
            OtpLoginActivity otpLoginActivity = this.this$0;
            TextView textView = this.this$0.getBinding().tvEmailSecond;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvEmailSecond");
            otpLoginActivity.mEmailTimer = new LoginCountDownTimer(60000, 1000, textView);
            LoginCountDownTimer access$getMEmailTimer$p = this.this$0.mEmailTimer;
            if (access$getMEmailTimer$p != null) {
                access$getMEmailTimer$p.setTimerListener(this.this$0);
            }
        }
        LoginCountDownTimer access$getMEmailTimer$p2 = this.this$0.mEmailTimer;
        boolean z = true;
        if (access$getMEmailTimer$p2 == null || !access$getMEmailTimer$p2.isTick()) {
            z = false;
        }
        if (!z) {
            this.this$0.showLoading();
            this.this$0.getBinding().tvEmailSend.setEnabled(false);
            LoginViewModel.getSmsCode$default(this.this$0.getMViewModel(), StringsKt.trim(String.valueOf(this.this$0.getBinding().etEmailAddress.getText())).toString(), "", Integer.valueOf(this.this$0.mLoginType), (Integer) null, 8, (Object) null);
        }
    }
}
