package com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate;

import androidx.lifecycle.Observer;
import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentData;
import com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class GradeAggregateLeaveInfoItemSelect$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ GradeAggregateActivity f$0;
    public final /* synthetic */ BaseNodeAdapter f$1;
    public final /* synthetic */ GradeAggregateLeaveInfoItemSelect f$2;
    public final /* synthetic */ BaseViewHolder f$3;
    public final /* synthetic */ UserLeaveComponentData f$4;

    public /* synthetic */ GradeAggregateLeaveInfoItemSelect$$ExternalSyntheticLambda1(GradeAggregateActivity gradeAggregateActivity, BaseNodeAdapter baseNodeAdapter, GradeAggregateLeaveInfoItemSelect gradeAggregateLeaveInfoItemSelect, BaseViewHolder baseViewHolder, UserLeaveComponentData userLeaveComponentData) {
        this.f$0 = gradeAggregateActivity;
        this.f$1 = baseNodeAdapter;
        this.f$2 = gradeAggregateLeaveInfoItemSelect;
        this.f$3 = baseViewHolder;
        this.f$4 = userLeaveComponentData;
    }

    public final void onChanged(Object obj) {
        GradeAggregateLeaveInfoItemSelect.m222showGradeDialog$lambda2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (StateData) obj);
    }
}
