package com.tal.app.thinkacademy.business.login.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.databinding.DialogOtpLoginBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/widget/OtpLoginDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/login/databinding/DialogOtpLoginBinding;", "context", "Landroid/content/Context;", "loginBlock", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "show", "msg", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OtpLoginDialog.kt */
public final class OtpLoginDialog extends BaseBindDialog<DialogOtpLoginBinding> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OtpLoginDialog(Context context, Function0<Unit> function0) {
        super(context, true);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "loginBlock");
        gravity(80);
        layoutParams(new ViewGroup.LayoutParams(-1, -2));
        canceledOnTouchOutside(true);
        this.binding.tvCancel.setOnClickListener(new OtpLoginDialog$$ExternalSyntheticLambda0(this));
        this.binding.tvLogin.setOnClickListener(new OtpLoginDialog$$ExternalSyntheticLambda1(this, function0));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m174_init_$lambda0(OtpLoginDialog otpLoginDialog, View view) {
        Intrinsics.checkNotNullParameter(otpLoginDialog, "this$0");
        otpLoginDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m175_init_$lambda1(OtpLoginDialog otpLoginDialog, Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(otpLoginDialog, "this$0");
        Intrinsics.checkNotNullParameter(function0, "$loginBlock");
        otpLoginDialog.dismiss();
        function0.invoke();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void show(String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        this.binding.tvDialogTitle.setText(str);
        OtpLoginDialog.super.show();
    }

    /* access modifiers changed from: protected */
    public DialogOtpLoginBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogOtpLoginBinding inflate = DialogOtpLoginBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
