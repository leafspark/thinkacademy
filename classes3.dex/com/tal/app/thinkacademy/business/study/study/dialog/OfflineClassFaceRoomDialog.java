package com.tal.app.thinkacademy.business.study.study.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.study.study.entity.TheOutsideEntity;
import com.tal.app.thinkacademy.business.studycenter.databinding.StudyDialogOfflineFaceClassroomBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/dialog/OfflineClassFaceRoomDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/StudyDialogOfflineFaceClassroomBinding;", "context", "Landroid/content/Context;", "entity", "Lcom/tal/app/thinkacademy/business/study/study/entity/TheOutsideEntity;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/business/study/study/entity/TheOutsideEntity;)V", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OfflineClassFaceRoomDialog.kt */
public final class OfflineClassFaceRoomDialog extends BaseBindDialog<StudyDialogOfflineFaceClassroomBinding> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfflineClassFaceRoomDialog(Context context, TheOutsideEntity theOutsideEntity) {
        super(context, true);
        Intrinsics.checkNotNullParameter(theOutsideEntity, "entity");
        layoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.binding.tvLocationContent.setText(String.valueOf(theOutsideEntity.getClassRoomName()));
        this.binding.tvNumberContent.setText(String.valueOf(theOutsideEntity.getPhone()));
        this.binding.tvGotIt.setOnClickListener(new OfflineClassFaceRoomDialog$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: protected */
    public StudyDialogOfflineFaceClassroomBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        StudyDialogOfflineFaceClassroomBinding inflate = StudyDialogOfflineFaceClassroomBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m413_init_$lambda0(OfflineClassFaceRoomDialog offlineClassFaceRoomDialog, View view) {
        Intrinsics.checkNotNullParameter(offlineClassFaceRoomDialog, "this$0");
        offlineClassFaceRoomDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
