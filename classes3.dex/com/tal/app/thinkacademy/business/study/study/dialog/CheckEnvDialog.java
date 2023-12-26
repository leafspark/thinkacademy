package com.tal.app.thinkacademy.business.study.study.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.studycenter.databinding.DialogEnvCheckBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0014J$\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rJ\u0010\u0010\u0010\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0011\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u000b¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/dialog/CheckEnvDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/DialogEnvCheckBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "setCancelButton", "res", "", "callback", "Lkotlin/Function0;", "", "setConfirmButton", "setMessageText", "setTitleText", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CheckEnvDialog.kt */
public final class CheckEnvDialog extends BaseBindDialog<DialogEnvCheckBinding> {
    public CheckEnvDialog(Context context) {
        super(context);
        layoutParams(new LinearLayout.LayoutParams(SizeUtils.dp2px(343.0f), -2));
        setCanceledOnTouchOutside(false);
    }

    /* access modifiers changed from: protected */
    public DialogEnvCheckBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogEnvCheckBinding inflate = DialogEnvCheckBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    public final CheckEnvDialog setTitleText(int i) {
        this.binding.tvDialogTitle.setText(i);
        return this;
    }

    public final CheckEnvDialog setMessageText(int i) {
        this.binding.tvDialogSubtitle.setText(i);
        return this;
    }

    public static /* synthetic */ CheckEnvDialog setCancelButton$default(CheckEnvDialog checkEnvDialog, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function0 = null;
        }
        return checkEnvDialog.setCancelButton(i, function0);
    }

    public final CheckEnvDialog setCancelButton(int i, Function0<Unit> function0) {
        this.binding.tvCancel.setVisibility(0);
        this.binding.tvCancel.setText(i);
        this.binding.tvCancel.setOnClickListener(new CheckEnvDialog$$ExternalSyntheticLambda0(this, function0));
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: setCancelButton$lambda-0  reason: not valid java name */
    public static final void m397setCancelButton$lambda0(CheckEnvDialog checkEnvDialog, Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(checkEnvDialog, "this$0");
        checkEnvDialog.dismiss();
        if (function0 != null) {
            Unit unit = (Unit) function0.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ CheckEnvDialog setConfirmButton$default(CheckEnvDialog checkEnvDialog, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function0 = null;
        }
        return checkEnvDialog.setConfirmButton(i, function0);
    }

    public final CheckEnvDialog setConfirmButton(int i, Function0<Unit> function0) {
        this.binding.tvConfirm.setVisibility(0);
        this.binding.tvConfirm.setText(i);
        this.binding.tvConfirm.setOnClickListener(new CheckEnvDialog$$ExternalSyntheticLambda1(this, function0));
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: setConfirmButton$lambda-1  reason: not valid java name */
    public static final void m398setConfirmButton$lambda1(CheckEnvDialog checkEnvDialog, Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(checkEnvDialog, "this$0");
        checkEnvDialog.dismiss();
        if (function0 != null) {
            Unit unit = (Unit) function0.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
