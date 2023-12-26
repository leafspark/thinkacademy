package com.tal.app.thinkacademy.business.study.study;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class RecordedCoursesFragment$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ RecordedCoursesFragment f$0;

    public /* synthetic */ RecordedCoursesFragment$$ExternalSyntheticLambda0(RecordedCoursesFragment recordedCoursesFragment) {
        this.f$0 = recordedCoursesFragment;
    }

    public final void onChanged(Object obj) {
        RecordedCoursesFragment.m380startObserve$lambda5(this.f$0, (StateData) obj);
    }
}
