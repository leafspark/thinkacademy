package com.tal.app.thinkacademy.common.business;

import android.app.Activity;
import android.content.Context;
import com.tal.app.thinkacademy.common.entity.UpdateVersionEntity;

public final /* synthetic */ class AppVersionBll$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ UpdateVersionEntity f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ AppVersionBll f$2;
    public final /* synthetic */ Activity f$3;
    public final /* synthetic */ Context f$4;
    public final /* synthetic */ Context f$5;

    public /* synthetic */ AppVersionBll$$ExternalSyntheticLambda1(UpdateVersionEntity updateVersionEntity, boolean z, AppVersionBll appVersionBll, Activity activity, Context context, Context context2) {
        this.f$0 = updateVersionEntity;
        this.f$1 = z;
        this.f$2 = appVersionBll;
        this.f$3 = activity;
        this.f$4 = context;
        this.f$5 = context2;
    }

    public final void run() {
        AppVersionBll.m6appUpdateCheck$lambda2$lambda1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
