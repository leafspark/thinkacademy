package com.tal.app.thinkacademy.business.login.view;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: IdLoginActivity.kt */
final class IdLoginActivity$showLoginDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IdLoginActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IdLoginActivity$showLoginDialog$1(IdLoginActivity idLoginActivity) {
        super(0);
        this.this$0 = idLoginActivity;
    }

    public final void invoke() {
        IdLoginActivity idLoginActivity = this.this$0;
        Intent intent = new Intent((Context) this.this$0, OtpLoginActivity.class);
        intent.putExtra(PasswordSettingsActivityKt.isAgree, this.this$0.mIsAgree);
        idLoginActivity.startActivity(intent);
        this.this$0.finish();
    }
}
