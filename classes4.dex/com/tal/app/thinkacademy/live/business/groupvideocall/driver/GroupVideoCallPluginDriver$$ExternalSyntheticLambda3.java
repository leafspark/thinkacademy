package com.tal.app.thinkacademy.live.business.groupvideocall.driver;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;

public final /* synthetic */ class GroupVideoCallPluginDriver$$ExternalSyntheticLambda3 implements Observer {
    public final /* synthetic */ GroupVideoCallPluginDriver f$0;

    public /* synthetic */ GroupVideoCallPluginDriver$$ExternalSyntheticLambda3(GroupVideoCallPluginDriver groupVideoCallPluginDriver) {
        this.f$0 = groupVideoCallPluginDriver;
    }

    public final void onChanged(Object obj) {
        GroupVideoCallPluginDriver.m262observerOtherUserLevel$lambda4(this.f$0, (PluginEventData) obj);
    }
}
