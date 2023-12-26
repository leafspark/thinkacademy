package com.tal.app.thinkacademy.live.business.common.bridges;

import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import org.json.JSONException;
import org.json.JSONObject;

public class PlayerActionBridge {
    /* access modifiers changed from: package-private */
    public void changeLOrP() {
    }

    /* access modifiers changed from: package-private */
    public void next() {
    }

    public static void play(Class cls) {
        PluginEventBus.onEvent("media_player", PluginEventData.obtainData(cls, "player_play"));
    }

    public static void pause(Class cls) {
        PluginEventBus.onEvent("media_player", PluginEventData.obtainData(cls, "player_pause"));
    }

    public static void toggle(Class cls) {
        PluginEventBus.onEvent("media_player", PluginEventData.obtainData(cls, "player_toggle"));
    }

    public static void stop(Class cls) {
        PluginEventBus.onEvent("media_player", PluginEventData.obtainData(cls, "player_stop"));
    }

    public static void seekTo(Class cls, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("position", j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        PluginEventBus.onEvent("media_player", PluginEventData.obtainData(cls, "player_change_progress", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)));
    }

    public static void changeSpeed(Class cls, float f) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("speed", (double) f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        PluginEventBus.onEvent("media_player", PluginEventData.obtainData(cls, "player_change_speed", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)));
    }

    public static void changeMode(Class cls, String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("streamId", str);
            jSONObject.put("protocol", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        PluginEventBus.onEvent("media_player", PluginEventData.obtainData(cls, "player_change_mode", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)));
    }

    public static void removeLoading(Class cls) {
        PluginEventBus.onEvent("media_player", PluginEventData.obtainData(cls, Keys.PLAYER_REMOVE_LOADING));
    }

    static class Keys {
        public static final String DATA_BUS_KEY = "media_player";
        public static final String PLAYER_CHANGE_MODE = "player_change_mode";
        public static final String PLAYER_CHANGE_SPEED = "player_change_speed";
        public static final String PLAYER_PAUSE = "player_pause";
        public static final String PLAYER_PLAY = "player_play";
        public static final String PLAYER_REMOVE_LOADING = "remove_loading";
        public static final String PLAYER_SEEK_TO = "player_change_progress";
        public static final String PLAYER_SET_VOLUME = "player_set_volume";
        public static final String PLAYER_STOP = "player_stop";
        public static final String PLAYER_TOGGLE = "player_toggle";

        Keys() {
        }
    }
}
