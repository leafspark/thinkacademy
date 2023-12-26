package com.tal.app.thinkacademy.business.login.view.devicetest;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.business.login.entity.NetTestBean;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class DeviceTestActivity$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ DeviceTestActivity$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onChanged(Object obj) {
        DeviceTestActivity.m141addNetCallback$lambda9(this.f$0, (NetTestBean) obj);
    }
}
