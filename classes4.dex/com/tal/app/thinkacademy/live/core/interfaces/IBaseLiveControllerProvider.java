package com.tal.app.thinkacademy.live.core.interfaces;

import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.pluginconfige.PluginConfData;
import java.util.Map;

public interface IBaseLiveControllerProvider extends ILiveRoomProvider {
    Map<String, BaseLivePluginDriver> getActivePluginMap();

    Map<String, String> getAuditEnterModuleMap();

    Map<String, PluginConfData> getPluginConfDataMap();

    BaseLivePluginDriver loadPlugin(String str);

    void onMetadataRequestSuccess();
}
