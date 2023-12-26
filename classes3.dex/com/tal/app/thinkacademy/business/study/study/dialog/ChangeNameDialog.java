package com.tal.app.thinkacademy.business.study.study.dialog;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.study.study.ready.LimitInputTextWatcher;
import com.tal.app.thinkacademy.business.studycenter.databinding.DialogReadyNicknameBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B<\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\u0005\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0014¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/dialog/ChangeNameDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/DialogReadyNicknameBinding;", "context", "Landroid/content/Context;", "name", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChangeNameDialog.kt */
public final class ChangeNameDialog extends BaseBindDialog<DialogReadyNicknameBinding> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChangeNameDialog(Context context, String str, Function1<? super String, Unit> function1) {
        super(context);
        Intrinsics.checkNotNullParameter(function1, "callback");
        layoutParams(new LinearLayout.LayoutParams(SizeUtils.dp2px(343.0f), -2));
        setCanceledOnTouchOutside(false);
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            this.binding.tvConfirm.setAlpha(0.5f);
            this.binding.tvConfirm.setEnabled(false);
            this.binding.btnClearName.setVisibility(4);
        } else {
            this.binding.etNickName.setText(charSequence);
            this.binding.tvConfirm.setAlpha(1.0f);
            this.binding.tvConfirm.setEnabled(true);
            this.binding.btnClearName.setVisibility(0);
        }
        this.binding.etNickName.addTextChangedListener(new LimitInputTextWatcher(this.binding.etNickName, this.binding.tvConfirm, this.binding.btnClearName));
        this.binding.etNickName.setOnEditorActionListener(new ChangeNameDialog$$ExternalSyntheticLambda3(this));
        this.binding.tvConfirm.setOnClickListener(new ChangeNameDialog$$ExternalSyntheticLambda2(function1, this));
        this.binding.btnClearName.setOnClickListener(new ChangeNameDialog$$ExternalSyntheticLambda1(this));
        this.binding.tvCancel.setOnClickListener(new ChangeNameDialog$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: protected */
    public DialogReadyNicknameBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogReadyNicknameBinding inflate = DialogReadyNicknameBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final boolean m393_init_$lambda0(ChangeNameDialog changeNameDialog, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(changeNameDialog, "this$0");
        if (i != 6 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        Object systemService = changeNameDialog.getContext().getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(changeNameDialog.binding.etNickName.getWindowToken(), 0);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m394_init_$lambda1(Function1 function1, ChangeNameDialog changeNameDialog, View view) {
        Intrinsics.checkNotNullParameter(function1, "$callback");
        Intrinsics.checkNotNullParameter(changeNameDialog, "this$0");
        function1.invoke(changeNameDialog.binding.etNickName.getText().toString());
        changeNameDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m395_init_$lambda2(ChangeNameDialog changeNameDialog, View view) {
        Intrinsics.checkNotNullParameter(changeNameDialog, "this$0");
        changeNameDialog.binding.etNickName.setText("");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m396_init_$lambda3(ChangeNameDialog changeNameDialog, View view) {
        Intrinsics.checkNotNullParameter(changeNameDialog, "this$0");
        changeNameDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
