package com.tal.app.thinkacademy.business.study.study.dialog;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B6\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012%\b\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/dialog/CheckInDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "context", "Landroid/content/Context;", "listener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "isUseImmersive", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CheckInDialog.kt */
public final class CheckInDialog extends BaseDialog {
    public boolean isUseImmersive() {
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckInDialog(Context context, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function1);
    }

    public CheckInDialog(Context context, Function1<? super Integer, Unit> function1) {
        super(context);
        contentView(R.layout.study_dialog_checkin).layoutParams(new LinearLayout.LayoutParams(-1, -1)).dimAmount(0.2f).canceledOnTouchOutside(true);
        View findViewById = findViewById(R.id.tvChenkIn);
        if (findViewById != null) {
            findViewById.setOnClickListener(new CheckInDialog$$ExternalSyntheticLambda0(this, function1));
        }
        View findViewById2 = findViewById(R.id.ivClose);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new CheckInDialog$$ExternalSyntheticLambda1(this, function1));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m399_init_$lambda1(CheckInDialog checkInDialog, Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(checkInDialog, "this$0");
        checkInDialog.dismiss();
        if (function1 != null) {
            function1.invoke(1);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m400_init_$lambda3(CheckInDialog checkInDialog, Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(checkInDialog, "this$0");
        checkInDialog.dismiss();
        if (function1 != null) {
            function1.invoke(0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
