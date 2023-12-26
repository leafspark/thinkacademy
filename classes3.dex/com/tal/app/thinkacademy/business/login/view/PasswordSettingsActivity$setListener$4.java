package com.tal.app.thinkacademy.business.login.view;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import com.tal.app.thinkacademy.business.login.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PasswordSettingsActivity.kt */
final class PasswordSettingsActivity$setListener$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PasswordSettingsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PasswordSettingsActivity$setListener$4(PasswordSettingsActivity passwordSettingsActivity) {
        super(0);
        this.this$0 = passwordSettingsActivity;
    }

    public final void invoke() {
        PasswordSettingsActivity passwordSettingsActivity = this.this$0;
        passwordSettingsActivity.mIvConfirmPasswordShow = !passwordSettingsActivity.mIvConfirmPasswordShow;
        if (this.this$0.mIvConfirmPasswordShow) {
            this.this$0.getBinding().etConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.this$0.getBinding().ivConfirmPasswordShow.setImageResource(R.drawable.password_icon_eye_open);
        } else {
            this.this$0.getBinding().etConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.this$0.getBinding().ivConfirmPasswordShow.setImageResource(R.drawable.password_icon_eye_close);
        }
        this.this$0.getBinding().etConfirmPassword.setSelection(this.this$0.getBinding().etConfirmPassword.length());
    }
}
