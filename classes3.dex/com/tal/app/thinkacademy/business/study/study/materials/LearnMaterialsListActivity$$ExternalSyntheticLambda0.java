package com.tal.app.thinkacademy.business.study.study.materials;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class LearnMaterialsListActivity$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ LearnMaterialsListActivity f$0;

    public /* synthetic */ LearnMaterialsListActivity$$ExternalSyntheticLambda0(LearnMaterialsListActivity learnMaterialsListActivity) {
        this.f$0 = learnMaterialsListActivity;
    }

    public final void onChanged(Object obj) {
        LearnMaterialsListActivity.m441initData$lambda3(this.f$0, (StateData) obj);
    }
}
