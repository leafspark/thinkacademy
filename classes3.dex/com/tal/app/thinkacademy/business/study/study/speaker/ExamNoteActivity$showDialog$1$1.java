package com.tal.app.thinkacademy.business.study.study.speaker;

import android.content.Context;
import android.view.LayoutInflater;
import com.tal.app.thinkacademy.business.studycenter.databinding.DialogStartExamBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/business/study/study/speaker/ExamNoteActivity$showDialog$1$1", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/DialogStartExamBinding;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExamNoteActivity.kt */
public final class ExamNoteActivity$showDialog$1$1 extends BaseBindDialog<DialogStartExamBinding> {
    final /* synthetic */ ExamNoteActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExamNoteActivity$showDialog$1$1(ExamNoteActivity examNoteActivity) {
        super((Context) examNoteActivity, true);
        this.this$0 = examNoteActivity;
    }

    /* access modifiers changed from: protected */
    public DialogStartExamBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogStartExamBinding inflate = DialogStartExamBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
