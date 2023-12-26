package com.tal.app.thinkacademy.business.study.study;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class LiveCoursesFragment$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ LiveCoursesFragment f$0;

    public /* synthetic */ LiveCoursesFragment$$ExternalSyntheticLambda1(LiveCoursesFragment liveCoursesFragment) {
        this.f$0 = liveCoursesFragment;
    }

    public final void onChanged(Object obj) {
        LiveCoursesFragment.m373startObserve$lambda4(this.f$0, (StateData) obj);
    }
}
