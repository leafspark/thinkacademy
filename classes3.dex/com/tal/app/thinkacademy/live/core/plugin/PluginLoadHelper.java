package com.tal.app.thinkacademy.live.core.plugin;

import android.util.Log;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.ktx.ExceptionKtxKt;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.pluginconfige.PluginConfData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PluginLoadHelper {
    private static final String TAG = "PluginLoadHelper";
    private static IPluginLoader mLoader;
    private static List<Class<? extends BaseLivePluginDriver>> mPluginClass;

    public static void setPluginClass(List<Class<? extends BaseLivePluginDriver>> list) {
        mPluginClass = list;
    }

    public static void setPluginLoader(IPluginLoader iPluginLoader) {
        mLoader = iPluginLoader;
        iPluginLoader.init();
    }

    public static BaseLivePluginDriver loadPlugin(ILiveRoomProvider iLiveRoomProvider, PluginConfData pluginConfData, String str) {
        IPluginLoader iPluginLoader = mLoader;
        if (iPluginLoader == null) {
            return null;
        }
        try {
            return iPluginLoader.loadPlugin(iLiveRoomProvider, pluginConfData, str);
        } catch (Exception e) {
            ExceptionKtxKt.throwInDebug(e);
            return null;
        }
    }

    public static BaseLivePluginDriver loadPlugin(ILiveRoomProvider iLiveRoomProvider, PluginConfData pluginConfData) {
        return loadPlugin(iLiveRoomProvider, pluginConfData, (String) null);
    }

    public static List<PluginConfData> parsePluginConf(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        List<Class<? extends BaseLivePluginDriver>> list = mPluginClass;
        if (list == null || list.size() == 0) {
            XesLog.dt(TAG, new Object[]{"getPluginConf  mPluginClass is empty "});
            return arrayList;
        }
        for (Class next : mPluginClass) {
            PluginConfData pluginConfData = new PluginConfData();
            PluginAnnotation pluginAnnotation = (PluginAnnotation) next.getAnnotation(PluginAnnotation.class);
            if (pluginAnnotation != null) {
                if (!(i2 == 0 && pluginAnnotation.liveType() == 1) && (!(i2 == 1 && pluginAnnotation.liveType() == 0) && (!(i == 0 && pluginAnnotation.classType() == 1) && (!(i == 1 && pluginAnnotation.classType() == 0) && ((!PadUtils.isPad(Utils.getApp()) || pluginAnnotation.deviceType() != 0) && (PadUtils.isPad(Utils.getApp()) || pluginAnnotation.deviceType() != 1)))))) {
                    pluginConfData.setModuleId(pluginAnnotation.moduleId());
                    pluginConfData.setDesc(pluginAnnotation.desc());
                    if (pluginAnnotation.ircType().length > 0) {
                        pluginConfData.setIrcType(Arrays.asList(pluginAnnotation.ircType()));
                    }
                    if (pluginAnnotation.metaDataKey().length > 0) {
                        pluginConfData.setMetaDataKey(Arrays.asList(pluginAnnotation.metaDataKey()));
                    }
                    if (pluginAnnotation.noActiveKey().length > 0) {
                        pluginConfData.setNoActiveKey(Arrays.asList(pluginAnnotation.noActiveKey()));
                    }
                    pluginConfData.setLaunchType(pluginAnnotation.launchType());
                    pluginConfData.setClassName(next.getName());
                    ViewLevels viewLevels = (ViewLevels) next.getAnnotation(ViewLevels.class);
                    if (viewLevels != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (ViewLevel viewLevel : viewLevels.value()) {
                            PluginConfData.ViewLevelBean viewLevelBean = new PluginConfData.ViewLevelBean();
                            viewLevelBean.setKey(viewLevel.name());
                            viewLevelBean.setValue(viewLevel.level());
                            arrayList2.add(viewLevelBean);
                        }
                        pluginConfData.setViewLevel(arrayList2);
                    }
                }
            }
            arrayList.add(pluginConfData);
        }
        return arrayList;
    }

    @Deprecated
    public static void generateData(List<Class<? extends BaseLivePluginDriver>> list) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (Class next : list) {
            PluginConfData pluginConfData = new PluginConfData();
            PluginAnnotation pluginAnnotation = (PluginAnnotation) next.getAnnotation(PluginAnnotation.class);
            if (pluginAnnotation != null) {
                pluginConfData.setModuleId(pluginAnnotation.moduleId());
                pluginConfData.setDesc(pluginAnnotation.desc());
                pluginConfData.setIrcType(Arrays.asList(pluginAnnotation.ircType()));
                pluginConfData.setMetaDataKey(Arrays.asList(pluginAnnotation.metaDataKey()));
                pluginConfData.setNoActiveKey(Arrays.asList(pluginAnnotation.noActiveKey()));
                pluginConfData.setLaunchType(pluginAnnotation.launchType());
                pluginConfData.setClassName(next.getName());
                ViewLevels viewLevels = (ViewLevels) next.getAnnotation(ViewLevels.class);
                if (viewLevels != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (ViewLevel viewLevel : viewLevels.value()) {
                        PluginConfData.ViewLevelBean viewLevelBean = new PluginConfData.ViewLevelBean();
                        viewLevelBean.setKey(viewLevel.name());
                        viewLevelBean.setValue(viewLevel.level());
                        arrayList2.add(viewLevelBean);
                    }
                    pluginConfData.setViewLevel(arrayList2);
                }
            }
            Log.i("PluginUtil-config", pluginConfData.toString());
            arrayList.add(pluginConfData);
        }
        Log.i("PluginUtil-time", (System.currentTimeMillis() - currentTimeMillis) + "ms");
    }
}
