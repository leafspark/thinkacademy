package com.tal.app.thinkacademy.business.login.view;

import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.util.RegexUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BindEmailActivity.kt */
final class BindEmailActivity$setListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BindEmailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BindEmailActivity$setListener$1(BindEmailActivity bindEmailActivity) {
        super(0);
        this.this$0 = bindEmailActivity;
    }

    public final void invoke() {
        this.this$0.getBinding().etEmail.clearFocus();
        String obj = StringsKt.trim(String.valueOf(this.this$0.getBinding().etEmail.getText())).toString();
        boolean z = false;
        if (RegexUtils.isEmail(obj)) {
            this.this$0.getMViewModel().bindEmail(obj);
            CharSequence access$getMFromPath$p = this.this$0.mFromPath;
            if (access$getMFromPath$p == null || access$getMFromPath$p.length() == 0) {
                z = true;
            }
            LeanplumUtil.longTrack$default("school_selection_pv", (String) null, (String) null, (String) null, (String) null, (String) null, z ? "others" : this.this$0.mFromPath, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16318, (Object) null);
            return;
        }
        this.this$0.getBinding().groupWarning.setVisibility(0);
    }
}
