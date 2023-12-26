package com.tal.app.thinkacademy;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class TestActivity$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ TestActivity f$0;

    public /* synthetic */ TestActivity$$ExternalSyntheticLambda0(TestActivity testActivity) {
        this.f$0 = testActivity;
    }

    public final void onChanged(Object obj) {
        TestActivity.m15startObserve$lambda0(this.f$0, (StateData) obj);
    }
}
