package com.tal.app.thinkacademy.business.login.view;

import com.tal.app.thinkacademy.business.login.adapter.SelectGradeAdapter;
import com.tal.app.thinkacademy.common.user.Grade;
import com.tal.app.thinkacademy.common.user.GradeStage;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectGradeActivity.kt */
final class SelectGradeActivity$showGradeDialog$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ SelectGradeActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectGradeActivity$showGradeDialog$1(SelectGradeActivity selectGradeActivity) {
        super(1);
        this.this$0 = selectGradeActivity;
    }

    public final void invoke(int i) {
        try {
            List access$getMGradeStageList$p = this.this$0.mGradeStageList;
            Intrinsics.checkNotNull(access$getMGradeStageList$p);
            Grade grade = (Grade) ((GradeStage) access$getMGradeStageList$p.get(this.this$0.mParentPosition)).getList().get(i);
            SelectGradeAdapter access$getMAdapter$p = this.this$0.mAdapter;
            Intrinsics.checkNotNull(access$getMAdapter$p);
            access$getMAdapter$p.setSubtitle(grade.getShortName(), this.this$0.mParentPosition);
            this.this$0.mGradeId = String.valueOf(grade.getValue());
            this.this$0.getBinding().tvNext.setEnabled(true);
            this.this$0.mHasChoose = true;
        } catch (Exception unused) {
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }
}
