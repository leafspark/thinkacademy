package com.tal.app.thinkacademy.live.business.function;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;

public final /* synthetic */ class FunctionPluginDriver$$ExternalSyntheticLambda4 implements Observer {
    public final /* synthetic */ FunctionPluginDriver f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ FunctionPluginDriver$$ExternalSyntheticLambda4(FunctionPluginDriver functionPluginDriver, int i) {
        this.f$0 = functionPluginDriver;
        this.f$1 = i;
    }

    public final void onChanged(Object obj) {
        FunctionPluginDriver.m249showTips$lambda19(this.f$0, this.f$1, (LiveAreaContext) obj);
    }
}
