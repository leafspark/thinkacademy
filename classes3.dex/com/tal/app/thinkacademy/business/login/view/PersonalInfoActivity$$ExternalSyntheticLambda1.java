package com.tal.app.thinkacademy.business.login.view;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class PersonalInfoActivity$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ PersonalInfoActivity f$0;

    public /* synthetic */ PersonalInfoActivity$$ExternalSyntheticLambda1(PersonalInfoActivity personalInfoActivity) {
        this.f$0 = personalInfoActivity;
    }

    public final void onChanged(Object obj) {
        PersonalInfoActivity.m107startObserve$lambda2(this.f$0, (StateData) obj);
    }
}
