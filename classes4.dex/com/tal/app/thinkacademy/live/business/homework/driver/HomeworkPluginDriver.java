package com.tal.app.thinkacademy.live.business.homework.driver;

import android.os.Bundle;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;

@PluginAnnotation(desc = "作业盒子", launchType = "initmodule", moduleId = "219")
public class HomeworkPluginDriver extends BaseLivePluginDriver {
    public void onDestroy() {
    }

    public void onMessage(String str, String str2) {
    }

    public HomeworkPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        eventShowHomework();
    }

    public void eventShowHomework() {
        PluginEventBus.onEvent(DataBusKey.SHOW_HOMEWORK_KEY, new PluginEventData(HomeworkPluginDriver.class, DataBusKey.SHOW_HOMEWORK_KEY, ""));
    }
}
