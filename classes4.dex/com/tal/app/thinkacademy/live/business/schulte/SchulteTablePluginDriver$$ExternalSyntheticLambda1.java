package com.tal.app.thinkacademy.live.business.schulte;

import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;

public final /* synthetic */ class SchulteTablePluginDriver$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ SchulteTablePluginDriver f$0;
    public final /* synthetic */ FrameLayout.LayoutParams f$1;

    public /* synthetic */ SchulteTablePluginDriver$$ExternalSyntheticLambda1(SchulteTablePluginDriver schulteTablePluginDriver, FrameLayout.LayoutParams layoutParams) {
        this.f$0 = schulteTablePluginDriver;
        this.f$1 = layoutParams;
    }

    public final void onChanged(Object obj) {
        SchulteTablePluginDriver.m421loadBaseView$lambda1$lambda0(this.f$0, this.f$1, (LiveAreaContext) obj);
    }
}
