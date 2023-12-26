package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

public final /* synthetic */ class GraffitiAgent$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ GraffitiAgent f$0;
    public final /* synthetic */ LiveAreaCompat.CourseRate f$1;
    public final /* synthetic */ BaseLivePluginView f$2;
    public final /* synthetic */ boolean f$3;

    public /* synthetic */ GraffitiAgent$$ExternalSyntheticLambda0(GraffitiAgent graffitiAgent, LiveAreaCompat.CourseRate courseRate, BaseLivePluginView baseLivePluginView, boolean z) {
        this.f$0 = graffitiAgent;
        this.f$1 = courseRate;
        this.f$2 = baseLivePluginView;
        this.f$3 = z;
    }

    public final void onChanged(Object obj) {
        GraffitiAgent.m184bindPluginView$lambda2(this.f$0, this.f$1, this.f$2, this.f$3, (LiveAreaContext) obj);
    }
}
