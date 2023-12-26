package com.tal.app.thinkacademy.business.login.view;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class MyAccountListActivity$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ MyAccountListActivity f$0;

    public /* synthetic */ MyAccountListActivity$$ExternalSyntheticLambda0(MyAccountListActivity myAccountListActivity) {
        this.f$0 = myAccountListActivity;
    }

    public final void onChanged(Object obj) {
        MyAccountListActivity.m92startObserve$lambda1(this.f$0, (StateData) obj);
    }
}
