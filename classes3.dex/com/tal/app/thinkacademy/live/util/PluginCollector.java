package com.tal.app.thinkacademy.live.util;

import com.tal.app.thinkacademy.live.core.plugin.PluginClassWarehouse;
import com.tal.app.thinkacademy.live.core.plugin.PluginLoadHelper;

public class PluginCollector {
    public static void init() {
        PluginLoadHelper.setPluginLoader(new PluginClassWarehouse());
    }
}
