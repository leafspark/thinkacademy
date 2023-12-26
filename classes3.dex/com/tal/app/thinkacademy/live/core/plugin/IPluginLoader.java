package com.tal.app.thinkacademy.live.core.plugin;

import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.pluginconfige.PluginConfData;

public interface IPluginLoader {
    void init();

    BaseLivePluginDriver loadPlugin(ILiveRoomProvider iLiveRoomProvider, PluginConfData pluginConfData, String str);
}
