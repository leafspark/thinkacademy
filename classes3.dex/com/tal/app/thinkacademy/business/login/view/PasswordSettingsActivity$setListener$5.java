package com.tal.app.thinkacademy.business.login.view;

import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.widget.PasswordUtil;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PasswordSettingsActivity.kt */
final class PasswordSettingsActivity$setListener$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PasswordSettingsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PasswordSettingsActivity$setListener$5(PasswordSettingsActivity passwordSettingsActivity) {
        super(0);
        this.this$0 = passwordSettingsActivity;
    }

    public final void invoke() {
        String valueOf = String.valueOf(this.this$0.getBinding().etPassword.getText());
        if (!Intrinsics.areEqual((Object) valueOf, (Object) String.valueOf(this.this$0.getBinding().etConfirmPassword.getText()))) {
            PasswordSettingsActivity passwordSettingsActivity = this.this$0;
            passwordSettingsActivity.showToast(passwordSettingsActivity.getString(R.string.passwords_do_not_match));
        } else if (valueOf.length() < 6 || valueOf.length() > 20) {
            PasswordSettingsActivity passwordSettingsActivity2 = this.this$0;
            passwordSettingsActivity2.showToast(passwordSettingsActivity2.getString(R.string.passwords_length_check));
        } else if (this.this$0.containSpecial(valueOf)) {
            PasswordSettingsActivity passwordSettingsActivity3 = this.this$0;
            passwordSettingsActivity3.showToast(passwordSettingsActivity3.getString(R.string.password_format_is_not_accepted));
        } else if (!this.this$0.passwordChecking(valueOf)) {
            PasswordSettingsActivity passwordSettingsActivity4 = this.this$0;
            passwordSettingsActivity4.showToast(passwordSettingsActivity4.getString(R.string.password_format_is_not_accepted));
        } else {
            this.this$0.showLoading();
            String password = PasswordUtil.INSTANCE.getPassword(valueOf);
            if (UserInfoBll.Companion.getInstance().isGuest()) {
                this.this$0.getMViewModel().setPassword(password, this.this$0.mAccountName, this.this$0.mVerificationCode, this.this$0.mCountryCallingCode, this.this$0.mType);
            } else {
                this.this$0.getMViewModel().changePassword(password);
            }
        }
    }
}
