package com.tal.app.thinkacademy.live.business.function;

import androidx.lifecycle.Observer;

public final /* synthetic */ class FunctionPluginDriver$$ExternalSyntheticLambda2 implements Observer {
    public final /* synthetic */ FunctionPluginDriver f$0;

    public /* synthetic */ FunctionPluginDriver$$ExternalSyntheticLambda2(FunctionPluginDriver functionPluginDriver) {
        this.f$0 = functionPluginDriver;
    }

    public final void onChanged(Object obj) {
        FunctionPluginDriver.m245registerDataBus$lambda2(this.f$0, obj);
    }
}
