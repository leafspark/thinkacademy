package com.tal.app.thinkacademy.business.login.view;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class PhoneLoginActivity$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ PhoneLoginActivity f$0;

    public /* synthetic */ PhoneLoginActivity$$ExternalSyntheticLambda0(PhoneLoginActivity phoneLoginActivity) {
        this.f$0 = phoneLoginActivity;
    }

    public final void onChanged(Object obj) {
        PhoneLoginActivity.m111startObserve$lambda0(this.f$0, (StateData) obj);
    }
}
