package com.tal.app.thinkacademy.business.study.study.dialog;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.study.study.constants.TwoButtonType;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B6\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012%\b\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/dialog/EnterTipsDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "context", "Landroid/content/Context;", "listener", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/business/study/study/constants/TwoButtonType;", "Lkotlin/ParameterName;", "name", "clickType", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EnterTipsDialog.kt */
public final class EnterTipsDialog extends BaseDialog {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EnterTipsDialog(Context context, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function1);
    }

    public EnterTipsDialog(Context context, Function1<? super TwoButtonType, Unit> function1) {
        super(context, true);
        contentView(R.layout.study_dialog_enter_tips);
        canceledOnTouchOutside(false);
        layoutParams(new LinearLayout.LayoutParams(-1, -1));
        ((TextView) findViewById(R.id.tips_msg)).setText(Html.fromHtml(getContext().getString(R.string.dialog_enter_tips_msg)));
        findViewById(R.id.btn_left).setOnClickListener(new EnterTipsDialog$$ExternalSyntheticLambda0(function1, this));
        findViewById(R.id.btn_right).setOnClickListener(new EnterTipsDialog$$ExternalSyntheticLambda1(function1, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m409_init_$lambda0(Function1 function1, EnterTipsDialog enterTipsDialog, View view) {
        Intrinsics.checkNotNullParameter(enterTipsDialog, "this$0");
        if (function1 != null) {
            function1.invoke(TwoButtonType.LEFT);
        }
        enterTipsDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m410_init_$lambda1(Function1 function1, EnterTipsDialog enterTipsDialog, View view) {
        Intrinsics.checkNotNullParameter(enterTipsDialog, "this$0");
        if (function1 != null) {
            function1.invoke(TwoButtonType.RIGHT);
        }
        enterTipsDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
