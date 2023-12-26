package com.tal.app.thinkacademy.business.shop.gradeaggregate;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class GradeAggregateActivity$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ GradeAggregateActivity f$0;

    public /* synthetic */ GradeAggregateActivity$$ExternalSyntheticLambda1(GradeAggregateActivity gradeAggregateActivity) {
        this.f$0 = gradeAggregateActivity;
    }

    public final void onChanged(Object obj) {
        GradeAggregateActivity.m332startObserve$lambda2(this.f$0, (StateData) obj);
    }
}
