package com.tal.app.thinkacademy.business.study.study.dialog;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.study.study.entity.TheOutsideEntity;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/dialog/OfflineClassRoomDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "context", "Landroid/content/Context;", "entity", "Lcom/tal/app/thinkacademy/business/study/study/entity/TheOutsideEntity;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/business/study/study/entity/TheOutsideEntity;)V", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OfflineClassRoomDialog.kt */
public final class OfflineClassRoomDialog extends BaseDialog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfflineClassRoomDialog(Context context, TheOutsideEntity theOutsideEntity) {
        super(context, true);
        Intrinsics.checkNotNullParameter(theOutsideEntity, "entity");
        contentView(R.layout.study_dialog_offline_classroom);
        layoutParams(new LinearLayout.LayoutParams(-1, -1));
        TextView textView = (TextView) findViewById(R.id.tvLocationContent);
        if (textView != null) {
            textView.setText(theOutsideEntity.getClassRoomName() + ", " + theOutsideEntity.getClassCenterName());
        }
        TextView textView2 = (TextView) findViewById(R.id.tvGotIt);
        if (textView2 != null) {
            textView2.setOnClickListener(new OfflineClassRoomDialog$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m415_init_$lambda0(OfflineClassRoomDialog offlineClassRoomDialog, View view) {
        Intrinsics.checkNotNullParameter(offlineClassRoomDialog, "this$0");
        offlineClassRoomDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
