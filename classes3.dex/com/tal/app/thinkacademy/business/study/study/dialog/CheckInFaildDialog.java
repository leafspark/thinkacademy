package com.tal.app.thinkacademy.business.study.study.dialog;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/dialog/CheckInFaildDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isUseImmersive", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CheckInFaildDialog.kt */
public final class CheckInFaildDialog extends BaseDialog {
    public boolean isUseImmersive() {
        return true;
    }

    public CheckInFaildDialog(Context context) {
        super(context);
        contentView(R.layout.study_dialog_checkinfaild).layoutParams(new LinearLayout.LayoutParams(-1, -1)).dimAmount(0.2f).canceledOnTouchOutside(true);
        View findViewById = findViewById(R.id.ivClose);
        if (findViewById != null) {
            findViewById.setOnClickListener(new CheckInFaildDialog$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m401_init_$lambda0(CheckInFaildDialog checkInFaildDialog, View view) {
        Intrinsics.checkNotNullParameter(checkInFaildDialog, "this$0");
        checkInFaildDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
