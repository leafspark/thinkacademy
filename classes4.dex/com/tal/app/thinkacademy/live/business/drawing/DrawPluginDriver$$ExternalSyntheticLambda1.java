package com.tal.app.thinkacademy.live.business.drawing;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;

public final /* synthetic */ class DrawPluginDriver$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ DrawPluginView f$0;
    public final /* synthetic */ DrawPluginDriver f$1;

    public /* synthetic */ DrawPluginDriver$$ExternalSyntheticLambda1(DrawPluginView drawPluginView, DrawPluginDriver drawPluginDriver) {
        this.f$0 = drawPluginView;
        this.f$1 = drawPluginDriver;
    }

    public final void onChanged(Object obj) {
        DrawPluginDriver.m210initPluginView$lambda14$lambda9$lambda8(this.f$0, this.f$1, (LiveAreaContext) obj);
    }
}
