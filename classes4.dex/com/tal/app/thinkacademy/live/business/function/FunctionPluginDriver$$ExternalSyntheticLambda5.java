package com.tal.app.thinkacademy.live.business.function;

import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;

public final /* synthetic */ class FunctionPluginDriver$$ExternalSyntheticLambda5 implements Observer {
    public final /* synthetic */ FunctionPluginDriver f$0;
    public final /* synthetic */ FrameLayout.LayoutParams f$1;

    public /* synthetic */ FunctionPluginDriver$$ExternalSyntheticLambda5(FunctionPluginDriver functionPluginDriver, FrameLayout.LayoutParams layoutParams) {
        this.f$0 = functionPluginDriver;
        this.f$1 = layoutParams;
    }

    public final void onChanged(Object obj) {
        FunctionPluginDriver.m248showPermissionWindow$lambda24$lambda23(this.f$0, this.f$1, (LiveAreaContext) obj);
    }
}
