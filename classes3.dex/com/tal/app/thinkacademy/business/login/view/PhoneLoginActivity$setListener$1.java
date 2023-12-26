package com.tal.app.thinkacademy.business.login.view;

import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhoneLoginActivity.kt */
final class PhoneLoginActivity$setListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PhoneLoginActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PhoneLoginActivity$setListener$1(PhoneLoginActivity phoneLoginActivity) {
        super(0);
        this.this$0 = phoneLoginActivity;
    }

    public final void invoke() {
        Collection access$getInternationalList = this.this$0.getInternationalList();
        if (access$getInternationalList == null || access$getInternationalList.isEmpty()) {
            ImConfig.INSTANCE.getConfigInfo();
            return;
        }
        this.this$0.getBinding().etPhoneNumber.clearFocus();
        this.this$0.showWheelDialog();
    }
}
