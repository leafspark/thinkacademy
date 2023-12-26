package com.tal.app.thinkacademy.business.login.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.databinding.LoginDialogChangePasswordBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SettingsActivity.kt */
final class SettingsActivity$dialogClick$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SettingsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsActivity$dialogClick$3(SettingsActivity settingsActivity) {
        super(0);
        this.this$0 = settingsActivity;
    }

    public final void invoke() {
        BaseBindDialog access$getMChangePasswordDialog$p;
        if (this.this$0.mChangePasswordDialog == null) {
            SettingsActivity settingsActivity = this.this$0;
            BaseBindDialog r1 = new BaseBindDialog<LoginDialogChangePasswordBinding>(this.this$0) {
                final /* synthetic */ SettingsActivity this$0;

                {
                    this.this$0 = r2;
                }

                /* access modifiers changed from: protected */
                public LoginDialogChangePasswordBinding createViewBinding(LayoutInflater layoutInflater) {
                    Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
                    LoginDialogChangePasswordBinding inflate = LoginDialogChangePasswordBinding.inflate(layoutInflater);
                    Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
                    return inflate;
                }
            };
            SettingsActivity settingsActivity2 = this.this$0;
            r1.gravity(80);
            r1.layoutParams(new LinearLayout.LayoutParams(-1, -2));
            r1.canceledOnTouchOutside(true);
            TextView textView = r1.binding.tvDialogTitle;
            Resources resources = settingsActivity2.getResources();
            textView.setText(resources == null ? null : resources.getText(R.string.password_change_prompt));
            RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
            TextView textView2 = r1.binding.tvCancel;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvCancel");
            rxUnDoubleUtil.setOnUnDoubleClickListener(textView2, 500, new SettingsActivity$dialogClick$3$2$1(r1));
            RxUnDoubleUtil rxUnDoubleUtil2 = RxUnDoubleUtil.INSTANCE;
            TextView textView3 = r1.binding.tvConfirm;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvConfirm");
            rxUnDoubleUtil2.setOnUnDoubleClickListener(textView3, 500, new SettingsActivity$dialogClick$3$2$2(r1, settingsActivity2));
            settingsActivity.mChangePasswordDialog = r1;
        }
        if (!this.this$0.isFinishing() && (access$getMChangePasswordDialog$p = this.this$0.mChangePasswordDialog) != null && !access$getMChangePasswordDialog$p.isShowing()) {
            access$getMChangePasswordDialog$p.show();
        }
    }
}
