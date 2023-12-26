package com.tal.app.thinkacademy.business.study.study.dialog;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/dialog/CheckInSuccessDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "context", "Landroid/content/Context;", "coinCount", "", "(Landroid/content/Context;Ljava/lang/Integer;)V", "isUseImmersive", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CheckInSuccessDialog.kt */
public final class CheckInSuccessDialog extends BaseDialog {
    public boolean isUseImmersive() {
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckInSuccessDialog(Context context, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? 10 : num);
    }

    public CheckInSuccessDialog(Context context, Integer num) {
        super(context);
        contentView(R.layout.study_dialog_checkinsuccess).layoutParams(new LinearLayout.LayoutParams(-1, -1)).dimAmount(0.2f).canceledOnTouchOutside(true);
        TextView textView = (TextView) findViewById(R.id.tvCoin);
        if (textView != null) {
            textView.setText(Intrinsics.stringPlus("+", num));
        }
        View findViewById = findViewById(R.id.ivClose);
        if (findViewById != null) {
            findViewById.setOnClickListener(new CheckInSuccessDialog$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m403_init_$lambda0(CheckInSuccessDialog checkInSuccessDialog, View view) {
        Intrinsics.checkNotNullParameter(checkInSuccessDialog, "this$0");
        checkInSuccessDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
