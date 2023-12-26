package com.tal.app.thinkacademy.business.study.study;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class LiveCoursesFragment$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ LiveCoursesFragment f$0;

    public /* synthetic */ LiveCoursesFragment$$ExternalSyntheticLambda0(LiveCoursesFragment liveCoursesFragment) {
        this.f$0 = liveCoursesFragment;
    }

    public final void onChanged(Object obj) {
        LiveCoursesFragment.m374startObserve$lambda7(this.f$0, (StateData) obj);
    }
}
