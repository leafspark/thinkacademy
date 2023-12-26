package com.tal.app.thinkacademy.business.study.study.dialog;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/dialog/PhoneSecondaryConfirmationDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhoneSecondaryConfirmationDialog.kt */
public final class PhoneSecondaryConfirmationDialog extends BaseDialog {
    public PhoneSecondaryConfirmationDialog(Context context) {
        super(context, true);
        contentView(R.layout.study_dialog_phone_secondary_confirmation);
        layoutParams(new LinearLayout.LayoutParams(-1, -1));
        TextView textView = (TextView) findViewById(R.id.tvOK);
        if (textView != null) {
            textView.setOnClickListener(new PhoneSecondaryConfirmationDialog$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m416_init_$lambda0(PhoneSecondaryConfirmationDialog phoneSecondaryConfirmationDialog, View view) {
        Intrinsics.checkNotNullParameter(phoneSecondaryConfirmationDialog, "this$0");
        phoneSecondaryConfirmationDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
