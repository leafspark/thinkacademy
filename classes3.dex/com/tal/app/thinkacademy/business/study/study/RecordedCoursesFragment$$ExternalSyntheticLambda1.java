package com.tal.app.thinkacademy.business.study.study;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class RecordedCoursesFragment$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ RecordedCoursesFragment f$0;

    public /* synthetic */ RecordedCoursesFragment$$ExternalSyntheticLambda1(RecordedCoursesFragment recordedCoursesFragment) {
        this.f$0 = recordedCoursesFragment;
    }

    public final void onChanged(Object obj) {
        RecordedCoursesFragment.m379startObserve$lambda2(this.f$0, (StateData) obj);
    }
}
