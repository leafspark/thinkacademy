package com.tal.app.thinkacademy.business.study.study.speaker;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class RecordedCalendarActivity$$ExternalSyntheticLambda2 implements Observer {
    public final /* synthetic */ RecordedCalendarActivity f$0;

    public /* synthetic */ RecordedCalendarActivity$$ExternalSyntheticLambda2(RecordedCalendarActivity recordedCalendarActivity) {
        this.f$0 = recordedCalendarActivity;
    }

    public final void onChanged(Object obj) {
        RecordedCalendarActivity.m487startObserve$lambda10(this.f$0, (StateData) obj);
    }
}
