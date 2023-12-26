package com.tal.app.thinkacademy.live.business.function;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;

public final /* synthetic */ class FunctionPluginDriver$$ExternalSyntheticLambda6 implements Observer {
    public final /* synthetic */ FunctionPluginDriver f$0;
    public final /* synthetic */ ILiveRoomProvider f$1;

    public /* synthetic */ FunctionPluginDriver$$ExternalSyntheticLambda6(FunctionPluginDriver functionPluginDriver, ILiveRoomProvider iLiveRoomProvider) {
        this.f$0 = functionPluginDriver;
        this.f$1 = iLiveRoomProvider;
    }

    public final void onChanged(Object obj) {
        FunctionPluginDriver.m239observerFeedback$lambda8(this.f$0, this.f$1, (PluginEventData) obj);
    }
}
