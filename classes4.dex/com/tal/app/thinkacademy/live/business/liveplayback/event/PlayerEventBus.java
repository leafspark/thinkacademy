package com.tal.app.thinkacademy.live.business.liveplayback.event;

import com.tal.app.thinkacademy.live.business.mediacontroller.event.MediaControllerPrivateKeys;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;

public class PlayerEventBus {
    public static void playerOnStart(Class cls) {
        PluginEventBus.onEvent("player_status", PluginEventData.obtainData(cls, "player_status_play"));
    }

    public static void playerOnPause(Class cls) {
        PluginEventBus.onEvent("player_status", PluginEventData.obtainData(cls, "player_status_pause"));
    }

    public static void playerOnStop(Class cls) {
        PluginEventBus.onEvent("player_status", PluginEventData.obtainData(cls, "player_status_stop"));
    }

    public static void playerOnComplete(Class cls) {
        PluginEventBus.onEvent("player_status", PluginEventData.obtainData(cls, "player_status_complete"));
    }

    public static void playerOnError(Class cls) {
        PluginEventBus.onEvent("player_status", PluginEventData.obtainData(cls, MediaControllerPrivateKeys.PLAYER_STATUS.ON_ERROR));
    }

    public static void playerOnStartToPlay(Class cls) {
        PluginEventBus.onEvent("player_status", PluginEventData.obtainData(cls, MediaControllerPrivateKeys.PLAYER_STATUS.ON_START_TO_PLAY));
    }
}
