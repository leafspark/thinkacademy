package com.tal.app.thinkacademy.live.core.plugin;

import android.text.TextUtils;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.core.interfaces.IBaseLiveControllerProvider;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfo;
import com.tal.app.thinkacademy.live.core.plugin.pluginconfige.PluginConfData;
import java.util.Map;

public class LivePluginManager {
    private static final String TAG = "PluginManager";
    private IBaseLiveControllerProvider mBaseLiveControllerProvider;

    public LivePluginManager(IBaseLiveControllerProvider iBaseLiveControllerProvider) {
        this.mBaseLiveControllerProvider = iBaseLiveControllerProvider;
    }

    public void loadEnterReqSuccessPlugin(boolean z) {
        Map pluginConfDataMap;
        Map auditEnterModuleMap = this.mBaseLiveControllerProvider.getAuditEnterModuleMap();
        int i = CourseInfo.ROLE_NORMAL_USER;
        if (!(this.mBaseLiveControllerProvider.getDataStorage() == null || this.mBaseLiveControllerProvider.getDataStorage().getCourseInfo() == null)) {
            i = this.mBaseLiveControllerProvider.getDataStorage().getCourseInfo().getIsAudition();
        }
        if ((z || i != CourseInfo.ROLE_AUDITION || (auditEnterModuleMap != null && auditEnterModuleMap.size() > 0)) && (pluginConfDataMap = this.mBaseLiveControllerProvider.getPluginConfDataMap()) != null) {
            for (String str : pluginConfDataMap.keySet()) {
                PluginConfData pluginConfData = (PluginConfData) pluginConfDataMap.get(str);
                if ("enter".equals(pluginConfData.getLaunchType())) {
                    if (z || i != CourseInfo.ROLE_AUDITION || auditEnterModuleMap.containsKey(pluginConfData.getModuleId())) {
                        BaseLivePluginDriver loadPlugin = PluginLoadHelper.loadPlugin(this.mBaseLiveControllerProvider, pluginConfData);
                        if (loadPlugin != null) {
                            XesLog.dt(TAG, new Object[]{"enter 接口请求成功之后初始化插件 " + pluginConfData.getClassName() + " 插件 被激活！！"});
                            this.mBaseLiveControllerProvider.getActivePluginMap().put(str, loadPlugin);
                        }
                    } else {
                        XesLog.it(TAG, new Object[]{"旁听生该插件不需要加载>>>className=" + pluginConfData.getClassName()});
                    }
                }
            }
        }
    }

    public void loadInitModuleReqSuccessPlugin() {
        IBaseLiveControllerProvider iBaseLiveControllerProvider = this.mBaseLiveControllerProvider;
        if (iBaseLiveControllerProvider != null) {
            Map pluginConfDataMap = iBaseLiveControllerProvider.getPluginConfDataMap();
            Map initModuleMap = this.mBaseLiveControllerProvider.getInitModuleMap();
            if (pluginConfDataMap != null) {
                for (String str : pluginConfDataMap.keySet()) {
                    PluginConfData pluginConfData = (PluginConfData) pluginConfDataMap.get(str);
                    if ("initmodule".equals(pluginConfData.getLaunchType())) {
                        String str2 = (String) initModuleMap.get(pluginConfData.getModuleId());
                        if (TextUtils.isEmpty(str2)) {
                            XesLog.dt(TAG, new Object[]{"initModule接口请求成功之后初始化插件 " + pluginConfData.getClassName() + " 插件 后端接口没有配置无需激活！！"});
                        } else {
                            BaseLivePluginDriver loadPlugin = PluginLoadHelper.loadPlugin(this.mBaseLiveControllerProvider, pluginConfData, str2);
                            if (loadPlugin != null) {
                                XesLog.dt(TAG, new Object[]{"initModule接口请求成功之后初始化插件" + pluginConfData.getClassName() + " 插件 被激活！！"});
                                this.mBaseLiveControllerProvider.getActivePluginMap().put(str, loadPlugin);
                            }
                        }
                    }
                }
            }
        }
    }

    public BaseLivePluginDriver loadPlugin(String str) {
        PluginConfData pluginConfData;
        Map pluginConfDataMap = this.mBaseLiveControllerProvider.getPluginConfDataMap();
        Map initModuleMap = this.mBaseLiveControllerProvider.getInitModuleMap();
        if (pluginConfDataMap == null || initModuleMap == null || (pluginConfData = (PluginConfData) pluginConfDataMap.get(str)) == null || !"delay".equals(pluginConfData.getLaunchType())) {
            return null;
        }
        String str2 = (String) initModuleMap.get(pluginConfData.getModuleId());
        if (TextUtils.isEmpty(str2)) {
            XesLog.dt(TAG, new Object[]{pluginConfData.getClassName() + " 插件 后端接口没有配置无需激活！！"});
            return null;
        }
        BaseLivePluginDriver loadPlugin = PluginLoadHelper.loadPlugin(this.mBaseLiveControllerProvider, pluginConfData, str2);
        if (loadPlugin != null) {
            XesLog.dt(TAG, new Object[]{pluginConfData.getClassName() + " 插件 被激活！！"});
            this.mBaseLiveControllerProvider.getActivePluginMap().put(str, loadPlugin);
        }
        return loadPlugin;
    }

    public void destroyPlugin(BaseLivePluginDriver baseLivePluginDriver) {
        Map activePluginMap;
        if (baseLivePluginDriver != null && (activePluginMap = this.mBaseLiveControllerProvider.getActivePluginMap()) != null) {
            activePluginMap.remove(baseLivePluginDriver.getClass().getName());
        }
    }
}
