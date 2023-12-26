package com.tal.app.thinkacademy.live.business.allonstage;

import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;

public final /* synthetic */ class AllOnStagePluginDriver$$ExternalSyntheticLambda2 implements Observer {
    public final /* synthetic */ AllOnStagePluginDriver f$0;
    public final /* synthetic */ FrameLayout.LayoutParams f$1;

    public /* synthetic */ AllOnStagePluginDriver$$ExternalSyntheticLambda2(AllOnStagePluginDriver allOnStagePluginDriver, FrameLayout.LayoutParams layoutParams) {
        this.f$0 = allOnStagePluginDriver;
        this.f$1 = layoutParams;
    }

    public final void onChanged(Object obj) {
        AllOnStagePluginDriver.m157showPermissionWindow$lambda22$lambda21(this.f$0, this.f$1, (LiveAreaContext) obj);
    }
}
