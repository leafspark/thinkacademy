package com.tal.app.thinkacademy.live.business.common.bridges;

import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;

public class MediaControlActionBridge {
    public static void show(Class cls) {
        PluginEventBus.onEvent(Keys.DATA_BUS_KEY, PluginEventData.obtainData(cls, Keys.MEDIA_CONTROLLER_SHOW));
    }

    public static void showLong(Class cls) {
        PluginEventBus.onEvent(Keys.DATA_BUS_KEY, PluginEventData.obtainData(cls, Keys.MEDIA_CONTROLLER_SHOW_LONG));
    }

    public static void hide(Class cls) {
        PluginEventBus.onEvent(Keys.DATA_BUS_KEY, PluginEventData.obtainData(cls, Keys.MEDIA_CONTROLLER_HIDE));
    }

    public static void toggle(Class cls) {
        PluginEventBus.onEvent(Keys.DATA_BUS_KEY, PluginEventData.obtainData(cls, Keys.MEDIA_CONTROLLER_TOGGLE));
    }

    public static void intercept(Class cls, boolean z) {
        PluginEventBus.onEvent(Keys.DATA_BUS_KEY, PluginEventData.obtainData(cls, Keys.MEDIA_CONTROLLER_INTERCEPT, String.valueOf(z)));
    }

    static class Keys {
        public static final String DATA_BUS_KEY = "media_controller";
        public static final String MEDIA_CONTROLLER_HIDE = "media_controller_hide";
        public static final String MEDIA_CONTROLLER_INTERCEPT = "media_controller_intercept";
        public static final String MEDIA_CONTROLLER_SHOW = "media_controller_show";
        public static final String MEDIA_CONTROLLER_SHOW_LONG = "media_controller_show_long";
        public static final String MEDIA_CONTROLLER_TOGGLE = "media_controller_toggle";

        Keys() {
        }
    }
}
