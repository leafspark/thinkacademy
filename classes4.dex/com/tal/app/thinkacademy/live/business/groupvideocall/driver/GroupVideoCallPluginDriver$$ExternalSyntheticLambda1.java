package com.tal.app.thinkacademy.live.business.groupvideocall.driver;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;

public final /* synthetic */ class GroupVideoCallPluginDriver$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ GroupVideoCallPluginDriver f$0;

    public /* synthetic */ GroupVideoCallPluginDriver$$ExternalSyntheticLambda1(GroupVideoCallPluginDriver groupVideoCallPluginDriver) {
        this.f$0 = groupVideoCallPluginDriver;
    }

    public final void onChanged(Object obj) {
        GroupVideoCallPluginDriver.m264observerVideoMuteStatus$lambda1(this.f$0, (PluginEventData) obj);
    }
}
