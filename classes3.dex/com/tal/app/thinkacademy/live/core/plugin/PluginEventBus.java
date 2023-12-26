package com.tal.app.thinkacademy.live.core.plugin;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;

public class PluginEventBus {
    public static void register(LifecycleOwner lifecycleOwner, String str, Observer<PluginEventData> observer) {
        XesDataBus.with(str).observe(lifecycleOwner, observer);
    }

    public static void registerSticky(LifecycleOwner lifecycleOwner, String str, Observer<PluginEventData> observer) {
        XesDataBus.with(str).observerSticky(lifecycleOwner, true, observer);
    }

    public static void registerStickyForever(LifecycleOwner lifecycleOwner, String str, Observer<PluginEventData> observer) {
        XesDataBus.with(str).observeForever(lifecycleOwner, true, observer);
    }

    public static void registerForever(LifecycleOwner lifecycleOwner, String str, Observer<PluginEventData> observer) {
        XesDataBus.with(str).observeForever(lifecycleOwner, false, observer);
    }

    public static void onEvent(String str, PluginEventData pluginEventData) {
        XesDataBus.with(str).postStickyData(pluginEventData);
    }

    public static void onEventMain(String str, PluginEventData pluginEventData) {
        XesDataBus.with(str).setStickyData(pluginEventData);
    }

    public static void unregister(String str, Observer<PluginEventData> observer) {
        XesDataBus.with(str).removeObserver(observer);
    }
}
