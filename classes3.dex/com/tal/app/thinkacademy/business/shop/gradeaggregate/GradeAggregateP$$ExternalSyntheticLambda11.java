package com.tal.app.thinkacademy.business.shop.gradeaggregate;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class GradeAggregateP$$ExternalSyntheticLambda11 implements Observer {
    public final /* synthetic */ GradeAggregateActivity f$0;
    public final /* synthetic */ GradeAggregateP f$1;

    public /* synthetic */ GradeAggregateP$$ExternalSyntheticLambda11(GradeAggregateActivity gradeAggregateActivity, GradeAggregateP gradeAggregateP) {
        this.f$0 = gradeAggregateActivity;
        this.f$1 = gradeAggregateP;
    }

    public final void onChanged(Object obj) {
        GradeAggregateP.m352viewmModelObserve$lambda2$lambda0(this.f$0, this.f$1, (StateData) obj);
    }
}
