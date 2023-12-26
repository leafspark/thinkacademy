package com.tal.app.thinkacademy.business.study.study.dialog;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/dialog/AssignmentDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "context", "Landroid/content/Context;", "listener", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AssignmentDialog.kt */
public final class AssignmentDialog extends BaseDialog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AssignmentDialog(Context context, Function0<Unit> function0) {
        super(context, true);
        Intrinsics.checkNotNullParameter(context, "context");
        contentView(R.layout.study_dialog_assignment);
        layoutParams(new LinearLayout.LayoutParams(-1, -1));
        findViewById(R.id.tvGotIt).setOnClickListener(new AssignmentDialog$$ExternalSyntheticLambda1(this, function0));
        findViewById(R.id.tvCancel).setOnClickListener(new AssignmentDialog$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AssignmentDialog(Context context, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function0);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m390_init_$lambda1(AssignmentDialog assignmentDialog, Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(assignmentDialog, "this$0");
        assignmentDialog.dismiss();
        if (function0 != null) {
            function0.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m391_init_$lambda2(AssignmentDialog assignmentDialog, View view) {
        Intrinsics.checkNotNullParameter(assignmentDialog, "this$0");
        assignmentDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
