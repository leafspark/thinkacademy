package com.tal.app.thinkacademy.live.business.groupvideocall.driver;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;

public final /* synthetic */ class GroupVideoCallPluginDriver$$ExternalSyntheticLambda4 implements Observer {
    public final /* synthetic */ GroupVideoCallPluginDriver f$0;

    public /* synthetic */ GroupVideoCallPluginDriver$$ExternalSyntheticLambda4(GroupVideoCallPluginDriver groupVideoCallPluginDriver) {
        this.f$0 = groupVideoCallPluginDriver;
    }

    public final void onChanged(Object obj) {
        GroupVideoCallPluginDriver.m260observerEmoji$lambda5(this.f$0, (PluginEventData) obj);
    }
}
