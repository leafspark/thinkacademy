package com.tal.app.thinkacademy.business.login.view;

import android.widget.TextView;
import com.tal.app.thinkacademy.business.login.presenter.LoginViewModel;
import com.tal.app.thinkacademy.business.login.widget.LoginCountDownTimer;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OtpLoginActivity.kt */
final class OtpLoginActivity$setListener$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ OtpLoginActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OtpLoginActivity$setListener$2(OtpLoginActivity otpLoginActivity) {
        super(0);
        this.this$0 = otpLoginActivity;
    }

    public final void invoke() {
        OtpLoginActivity otpLoginActivity = this.this$0;
        otpLoginActivity.changeStatus(otpLoginActivity.mPhoneLengthMax, this.this$0.mPhoneLengthMin);
        this.this$0.getBinding().etPhoneNumber.clearFocus();
        if (this.this$0.isRightPhoneNumber) {
            if (this.this$0.mSmsTimer == null) {
                OtpLoginActivity otpLoginActivity2 = this.this$0;
                TextView textView = this.this$0.getBinding().tvSmsSecond;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tvSmsSecond");
                otpLoginActivity2.mSmsTimer = new LoginCountDownTimer(60000, 1000, textView);
                LoginCountDownTimer access$getMSmsTimer$p = this.this$0.mSmsTimer;
                if (access$getMSmsTimer$p != null) {
                    access$getMSmsTimer$p.setTimerListener(this.this$0);
                }
            }
            LoginCountDownTimer access$getMSmsTimer$p2 = this.this$0.mSmsTimer;
            if (!(access$getMSmsTimer$p2 != null && access$getMSmsTimer$p2.isTick())) {
                this.this$0.showLoading();
                this.this$0.getBinding().tvSmsSend.setEnabled(false);
                String obj = StringsKt.trim(String.valueOf(this.this$0.getBinding().etPhoneNumber.getText())).toString();
                CharSequence text = this.this$0.getBinding().tvCountryCode.getText();
                Intrinsics.checkNotNullExpressionValue(text, "binding.tvCountryCode.text");
                String obj2 = StringsKt.trim(text.subSequence(1, text.length()).toString()).toString();
                LoginViewModel.getSmsCode$default(this.this$0.getMViewModel(), obj, obj2, Integer.valueOf(this.this$0.mLoginType), (Integer) null, 8, (Object) null);
                HashMap hashMap = new HashMap();
                Map map = hashMap;
                map.put("phone", obj);
                map.put("phone_calling_code", obj2);
                LeanplumUtil.commonTrack("click_send_otp", hashMap);
            }
        }
    }
}
