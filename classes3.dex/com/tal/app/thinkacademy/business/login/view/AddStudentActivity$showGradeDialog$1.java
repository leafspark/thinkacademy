package com.tal.app.thinkacademy.business.login.view;

import com.tal.app.thinkacademy.common.user.Grade;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddStudentActivity.kt */
final class AddStudentActivity$showGradeDialog$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ AddStudentActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddStudentActivity$showGradeDialog$1(AddStudentActivity addStudentActivity) {
        super(1);
        this.this$0 = addStudentActivity;
    }

    public final void invoke(int i) {
        this.this$0.getBinding().tvGrade.setText(((Grade) this.this$0.mGradeList.get(i)).getName());
        this.this$0.mGradePosition = i;
        AddStudentActivity addStudentActivity = this.this$0;
        addStudentActivity.mGradeId = Integer.valueOf(((Grade) addStudentActivity.mGradeList.get(i)).getValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }
}
