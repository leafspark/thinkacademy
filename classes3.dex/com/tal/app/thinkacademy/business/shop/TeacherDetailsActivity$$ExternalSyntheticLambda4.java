package com.tal.app.thinkacademy.business.shop;

import com.google.android.material.appbar.AppBarLayout;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class TeacherDetailsActivity$$ExternalSyntheticLambda4 implements AppBarLayout.OnOffsetChangedListener {
    public final /* synthetic */ TeacherDetailsActivity f$0;
    public final /* synthetic */ Ref.IntRef f$1;

    public /* synthetic */ TeacherDetailsActivity$$ExternalSyntheticLambda4(TeacherDetailsActivity teacherDetailsActivity, Ref.IntRef intRef) {
        this.f$0 = teacherDetailsActivity;
        this.f$1 = intRef;
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        TeacherDetailsActivity.m208initTitle$lambda5(this.f$0, this.f$1, appBarLayout, i);
    }
}
