package com.tal.app.thinkacademy.business.login.view;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class MyAccountListActivity$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ MyAccountListActivity f$0;

    public /* synthetic */ MyAccountListActivity$$ExternalSyntheticLambda1(MyAccountListActivity myAccountListActivity) {
        this.f$0 = myAccountListActivity;
    }

    public final void onChanged(Object obj) {
        MyAccountListActivity.m93startObserve$lambda2(this.f$0, (StateData) obj);
    }
}
