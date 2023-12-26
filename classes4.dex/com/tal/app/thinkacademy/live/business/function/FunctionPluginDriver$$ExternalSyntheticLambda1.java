package com.tal.app.thinkacademy.live.business.function;

import androidx.lifecycle.Observer;

public final /* synthetic */ class FunctionPluginDriver$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ FunctionPluginDriver f$0;

    public /* synthetic */ FunctionPluginDriver$$ExternalSyntheticLambda1(FunctionPluginDriver functionPluginDriver) {
        this.f$0 = functionPluginDriver;
    }

    public final void onChanged(Object obj) {
        FunctionPluginDriver.m247registerPermission$lambda4(this.f$0, obj);
    }
}
