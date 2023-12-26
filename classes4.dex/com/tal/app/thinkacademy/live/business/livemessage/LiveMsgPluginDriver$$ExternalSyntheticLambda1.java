package com.tal.app.thinkacademy.live.business.livemessage;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;

public final /* synthetic */ class LiveMsgPluginDriver$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ LiveMsgPluginDriver f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ LiveMsgPluginDriver$$ExternalSyntheticLambda1(LiveMsgPluginDriver liveMsgPluginDriver, int i) {
        this.f$0 = liveMsgPluginDriver;
        this.f$1 = i;
    }

    public final void onChanged(Object obj) {
        this.f$0.lambda$initLiveMsgView$0$LiveMsgPluginDriver(this.f$1, (LiveAreaContext) obj);
    }
}
