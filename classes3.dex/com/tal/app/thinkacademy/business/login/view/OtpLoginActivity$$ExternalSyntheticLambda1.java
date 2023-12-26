package com.tal.app.thinkacademy.business.login.view;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class OtpLoginActivity$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ OtpLoginActivity f$0;

    public /* synthetic */ OtpLoginActivity$$ExternalSyntheticLambda1(OtpLoginActivity otpLoginActivity) {
        this.f$0 = otpLoginActivity;
    }

    public final void onChanged(Object obj) {
        OtpLoginActivity.m101startObserve$lambda7(this.f$0, (StateData) obj);
    }
}
