package com.tal.app.thinkacademy.business.shop.gradeaggregate;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class GradeAggregateActivity$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ GradeAggregateActivity f$0;

    public /* synthetic */ GradeAggregateActivity$$ExternalSyntheticLambda0(GradeAggregateActivity gradeAggregateActivity) {
        this.f$0 = gradeAggregateActivity;
    }

    public final void onChanged(Object obj) {
        GradeAggregateActivity.m334startObserve$lambda5(this.f$0, (StateData) obj);
    }
}
