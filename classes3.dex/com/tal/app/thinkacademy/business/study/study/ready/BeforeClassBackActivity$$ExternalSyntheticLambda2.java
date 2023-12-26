package com.tal.app.thinkacademy.business.study.study.ready;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class BeforeClassBackActivity$$ExternalSyntheticLambda2 implements Observer {
    public final /* synthetic */ BeforeClassBackActivity f$0;

    public /* synthetic */ BeforeClassBackActivity$$ExternalSyntheticLambda2(BeforeClassBackActivity beforeClassBackActivity) {
        this.f$0 = beforeClassBackActivity;
    }

    public final void onChanged(Object obj) {
        BeforeClassBackActivity.m442loadData$lambda1(this.f$0, (StateData) obj);
    }
}
