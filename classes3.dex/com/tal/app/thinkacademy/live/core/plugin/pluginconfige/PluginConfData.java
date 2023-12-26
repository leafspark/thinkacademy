package com.tal.app.thinkacademy.live.core.plugin.pluginconfige;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.List;

public class PluginConfData implements Serializable {
    private String className;
    private String desc;
    private List<String> ircType;
    private String launchType;
    private List<String> metaDataKey;
    private String moduleId;
    private List<String> noActiveKey;
    private List<ViewLevelBean> viewLevel;

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public String getModuleId() {
        return this.moduleId;
    }

    public void setModuleId(String str) {
        this.moduleId = str;
    }

    public String getLaunchType() {
        return this.launchType;
    }

    public void setLaunchType(String str) {
        this.launchType = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public List<ViewLevelBean> getViewLevel() {
        return this.viewLevel;
    }

    public void setViewLevel(List<ViewLevelBean> list) {
        this.viewLevel = list;
    }

    public String getViewLevel(String str) {
        List<ViewLevelBean> list = this.viewLevel;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (int i = 0; i < this.viewLevel.size(); i++) {
            if (!TextUtils.isEmpty(str) && str.equals(this.viewLevel.get(i).key)) {
                return this.viewLevel.get(i).key;
            }
        }
        return null;
    }

    public List<String> getIrcType() {
        return this.ircType;
    }

    public void setIrcType(List<String> list) {
        this.ircType = list;
    }

    public void setMetaDataKey(List<String> list) {
        this.metaDataKey = list;
    }

    public List<String> getMetaDataKey() {
        return this.metaDataKey;
    }

    public List<String> getNoActiveKey() {
        return this.noActiveKey;
    }

    public void setNoActiveKey(List<String> list) {
        this.noActiveKey = list;
    }

    public static class ViewLevelBean {
        /* access modifiers changed from: private */
        public String key;
        private int value;

        public String getKey() {
            return this.key;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int i) {
            this.value = i;
        }
    }
}
