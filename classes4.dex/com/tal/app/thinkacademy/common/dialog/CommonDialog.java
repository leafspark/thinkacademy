package com.tal.app.thinkacademy.common.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ\"\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\"\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/common/dialog/CommonDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBtnCancel", "Landroid/widget/TextView;", "mBtnConfirm", "mSpack", "Landroid/view/View;", "mTvMsg", "mTvTitle", "setButtons", "confirm", "", "cancel", "setCancelClick", "strId", "", "listener", "Lkotlin/Function0;", "", "setConfirmClick", "setMsgText", "setTitleText", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonDialog.kt */
public final class CommonDialog extends BaseDialog {
    private final TextView mBtnCancel;
    private final TextView mBtnConfirm;
    private final View mSpack;
    private final TextView mTvMsg;
    private final TextView mTvTitle;

    public CommonDialog(Context context) {
        super(context);
        contentView(R.layout.dialog_common);
        canceledOnTouchOutside(false);
        View findViewById = findViewById(R.id.dialog_common_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.dialog_common_title)");
        this.mTvTitle = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.dialog_common_msg);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.dialog_common_msg)");
        this.mTvMsg = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.dialog_common_btn_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.dialog_common_btn_confirm)");
        this.mBtnConfirm = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.dialog_common_btn_cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.dialog_common_btn_cancel)");
        this.mBtnCancel = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.dialog_common_btn_space);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.dialog_common_btn_space)");
        this.mSpack = findViewById5;
        setCancelClick$default(this, 0, AnonymousClass1.INSTANCE, 1, (Object) null);
    }

    public final CommonDialog setTitleText(int i) {
        this.mTvTitle.setText(i);
        return this;
    }

    public final CommonDialog setMsgText(int i) {
        this.mTvMsg.setText(i);
        return this;
    }

    public static /* synthetic */ CommonDialog setConfirmClick$default(CommonDialog commonDialog, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = R.string.tv_confirm;
        }
        if ((i2 & 2) != 0) {
            function0 = null;
        }
        return commonDialog.setConfirmClick(i, function0);
    }

    public final CommonDialog setConfirmClick(int i, Function0<Unit> function0) {
        this.mBtnConfirm.setText(i);
        if (function0 != null) {
            this.mBtnConfirm.setOnClickListener(new CommonDialog$$ExternalSyntheticLambda0(this, function0));
        }
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: setConfirmClick$lambda-1$lambda-0  reason: not valid java name */
    public static final void m41setConfirmClick$lambda1$lambda0(CommonDialog commonDialog, Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(commonDialog, "this$0");
        Intrinsics.checkNotNullParameter(function0, "$l");
        commonDialog.dismiss();
        function0.invoke();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ CommonDialog setCancelClick$default(CommonDialog commonDialog, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = R.string.tv_cancel;
        }
        if ((i2 & 2) != 0) {
            function0 = null;
        }
        return commonDialog.setCancelClick(i, function0);
    }

    public final CommonDialog setCancelClick(int i, Function0<Unit> function0) {
        this.mBtnCancel.setText(i);
        if (function0 != null) {
            this.mBtnCancel.setOnClickListener(new CommonDialog$$ExternalSyntheticLambda1(this, function0));
        }
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: setCancelClick$lambda-3$lambda-2  reason: not valid java name */
    public static final void m40setCancelClick$lambda3$lambda2(CommonDialog commonDialog, Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(commonDialog, "this$0");
        Intrinsics.checkNotNullParameter(function0, "$l");
        commonDialog.dismiss();
        function0.invoke();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ CommonDialog setButtons$default(CommonDialog commonDialog, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return commonDialog.setButtons(z, z2);
    }

    public final CommonDialog setButtons(boolean z, boolean z2) {
        if (z) {
            this.mBtnConfirm.setVisibility(0);
        } else {
            this.mBtnConfirm.setVisibility(8);
        }
        if (z2) {
            this.mBtnCancel.setVisibility(0);
        } else {
            this.mBtnCancel.setVisibility(8);
        }
        if (!z || !z2) {
            this.mSpack.setVisibility(8);
        } else {
            this.mSpack.setVisibility(0);
        }
        return this;
    }
}
