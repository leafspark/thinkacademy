package com.tal.app.thinkacademy.live.business.drawing;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;

public final /* synthetic */ class DrawPluginDriver$$ExternalSyntheticLambda2 implements Observer {
    public final /* synthetic */ DrawPluginViewTools f$0;
    public final /* synthetic */ DrawPluginDriver f$1;

    public /* synthetic */ DrawPluginDriver$$ExternalSyntheticLambda2(DrawPluginViewTools drawPluginViewTools, DrawPluginDriver drawPluginDriver) {
        this.f$0 = drawPluginViewTools;
        this.f$1 = drawPluginDriver;
    }

    public final void onChanged(Object obj) {
        DrawPluginDriver.m209initPluginView$lambda14$lambda13$lambda12(this.f$0, this.f$1, (LiveAreaContext) obj);
    }
}
