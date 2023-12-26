package com.tal.app.thinkacademy.business.shop.gradeaggregate;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class GradeAggregateP$$ExternalSyntheticLambda12 implements Observer {
    public final /* synthetic */ GradeAggregateActivity f$0;
    public final /* synthetic */ GradeAggregateP f$1;

    public /* synthetic */ GradeAggregateP$$ExternalSyntheticLambda12(GradeAggregateActivity gradeAggregateActivity, GradeAggregateP gradeAggregateP) {
        this.f$0 = gradeAggregateActivity;
        this.f$1 = gradeAggregateP;
    }

    public final void onChanged(Object obj) {
        GradeAggregateP.m353viewmModelObserve$lambda2$lambda1(this.f$0, this.f$1, (StateData) obj);
    }
}
