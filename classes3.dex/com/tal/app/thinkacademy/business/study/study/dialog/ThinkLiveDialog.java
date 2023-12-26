package com.tal.app.thinkacademy.business.study.study.dialog;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.study.study.entity.TheOutsideEntity;
import com.tal.app.thinkacademy.business.study.study.speaker.OutsideOfClassType;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.utils.ClipboardUtilKt;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/dialog/ThinkLiveDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "context", "Landroid/content/Context;", "entity", "Lcom/tal/app/thinkacademy/business/study/study/entity/TheOutsideEntity;", "listener", "Lkotlin/Function2;", "Lcom/tal/app/thinkacademy/business/study/study/speaker/OutsideOfClassType;", "", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/business/study/study/entity/TheOutsideEntity;Lkotlin/jvm/functions/Function2;)V", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThinkLiveDialog.kt */
public final class ThinkLiveDialog extends BaseDialog {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ThinkLiveDialog(Context context, TheOutsideEntity theOutsideEntity, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, theOutsideEntity, (i & 4) != 0 ? null : function2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThinkLiveDialog(Context context, TheOutsideEntity theOutsideEntity, Function2<? super OutsideOfClassType, ? super TheOutsideEntity, Unit> function2) {
        super(context, true);
        Intrinsics.checkNotNullParameter(theOutsideEntity, "entity");
        contentView(R.layout.study_dialog_thinklive);
        layoutParams(new LinearLayout.LayoutParams(-1, -1));
        TextView textView = (TextView) findViewById(R.id.tvThinkLive);
        if (textView != null) {
            textView.setText(theOutsideEntity.getClassroomLink());
        }
        View findViewById = findViewById(R.id.llCopyThinkLive);
        if (findViewById != null) {
            findViewById.setOnClickListener(new ThinkLiveDialog$$ExternalSyntheticLambda0(context, theOutsideEntity));
        }
        TextView textView2 = (TextView) findViewById(R.id.tvGotIt);
        if (textView2 != null) {
            textView2.setOnClickListener(new ThinkLiveDialog$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m423_init_$lambda0(Context context, TheOutsideEntity theOutsideEntity, View view) {
        Intrinsics.checkNotNullParameter(theOutsideEntity, "$entity");
        ToastUtils.showShort(R.string.copied);
        String classroomLink = theOutsideEntity.getClassroomLink();
        if (classroomLink == null) {
            classroomLink = "";
        }
        ClipboardUtilKt.copyClipboard(context, classroomLink);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m424_init_$lambda1(ThinkLiveDialog thinkLiveDialog, View view) {
        Intrinsics.checkNotNullParameter(thinkLiveDialog, "this$0");
        thinkLiveDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
