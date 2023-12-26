package com.tal.app.thinkacademy.common.dialog;

import com.tal.app.thinkacademy.lib.commui.wheel.listener.OnItemSelectedListener;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class SchoolChooseDialog$$ExternalSyntheticLambda2 implements OnItemSelectedListener {
    public final /* synthetic */ Ref.IntRef f$0;

    public /* synthetic */ SchoolChooseDialog$$ExternalSyntheticLambda2(Ref.IntRef intRef) {
        this.f$0 = intRef;
    }

    public final void onItemSelected(int i) {
        SchoolChooseDialog.m43showSchool$lambda7$lambda4(this.f$0, i);
    }
}
