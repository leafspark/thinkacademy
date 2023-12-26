package com.tal.app.thinkacademy.business.shop.classdetail;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.base.XesBaseActivity;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class StudentInfo$$ExternalSyntheticLambda5 implements Observer {
    public final /* synthetic */ XesBaseActivity f$0;
    public final /* synthetic */ StudentInfo f$1;

    public /* synthetic */ StudentInfo$$ExternalSyntheticLambda5(XesBaseActivity xesBaseActivity, StudentInfo studentInfo) {
        this.f$0 = xesBaseActivity;
        this.f$1 = studentInfo;
    }

    public final void onChanged(Object obj) {
        StudentInfo.m259viewmModelObserve$lambda11$lambda7(this.f$0, this.f$1, (StateData) obj);
    }
}
