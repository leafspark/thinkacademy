package com.tal.app.thinkacademy.live.core.plugin.pluginconfige;

import android.content.Context;
import com.google.gson.reflect.TypeToken;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import java.util.List;

public class PluginConfHelp {
    public static List<PluginConfData> parsePluginConf(Context context, String str) {
        return (List) GsonUtils.fromJson(PluginConfUtils.loadAssetsString(context, str), new TypeToken<List<PluginConfData>>() {
        }.getType());
    }
}
