package com.tal.app.thinkacademy.common.dialog;

import android.view.View;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class SchoolChooseDialog$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ BaseDialog f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Ref.ObjectRef f$2;
    public final /* synthetic */ Ref.IntRef f$3;
    public final /* synthetic */ Function2 f$4;

    public /* synthetic */ SchoolChooseDialog$$ExternalSyntheticLambda1(BaseDialog baseDialog, int i, Ref.ObjectRef objectRef, Ref.IntRef intRef, Function2 function2) {
        this.f$0 = baseDialog;
        this.f$1 = i;
        this.f$2 = objectRef;
        this.f$3 = intRef;
        this.f$4 = function2;
    }

    public final void onClick(View view) {
        SchoolChooseDialog.m45showSchool$lambda7$lambda6(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, view);
    }
}
