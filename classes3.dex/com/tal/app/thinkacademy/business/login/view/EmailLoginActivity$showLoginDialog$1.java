package com.tal.app.thinkacademy.business.login.view;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmailLoginActivity.kt */
final class EmailLoginActivity$showLoginDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ EmailLoginActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EmailLoginActivity$showLoginDialog$1(EmailLoginActivity emailLoginActivity) {
        super(0);
        this.this$0 = emailLoginActivity;
    }

    public final void invoke() {
        EmailLoginActivity emailLoginActivity = this.this$0;
        Intent intent = new Intent((Context) this.this$0, OtpLoginActivity.class);
        intent.putExtra(PasswordSettingsActivityKt.isAgree, this.this$0.mIsAgree);
        intent.putExtra(PasswordSettingsActivityKt.isEmailLogin, true);
        emailLoginActivity.startActivity(intent);
        this.this$0.finish();
    }
}
