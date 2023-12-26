package com.tal.app.thinkacademy.common.business;

import android.content.DialogInterface;

public final /* synthetic */ class AppVersionBll$$ExternalSyntheticLambda0 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ AppVersionBll f$0;

    public /* synthetic */ AppVersionBll$$ExternalSyntheticLambda0(AppVersionBll appVersionBll) {
        this.f$0 = appVersionBll;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        AppVersionBll.m7showUpdateDialog$lambda3(this.f$0, dialogInterface);
    }
}
