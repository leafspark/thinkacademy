package com.tal.app.thinkacademy.live.business.nps;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;

public final /* synthetic */ class NpsPluginDriver$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ ILiveRoomProvider f$0;
    public final /* synthetic */ NpsPluginDriver f$1;

    public /* synthetic */ NpsPluginDriver$$ExternalSyntheticLambda0(ILiveRoomProvider iLiveRoomProvider, NpsPluginDriver npsPluginDriver) {
        this.f$0 = iLiveRoomProvider;
        this.f$1 = npsPluginDriver;
    }

    public final void onChanged(Object obj) {
        NpsPluginDriver.m341observeNpsState$lambda0(this.f$0, this.f$1, (PluginEventData) obj);
    }
}
