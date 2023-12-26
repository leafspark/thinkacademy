package com.tal.app.thinkacademy.live.core.live.http.bean;

import com.google.gson.JsonObject;

public class ModuleConfig {
    private int moduleId;
    private String pluginId;
    private String pluginName;
    private JsonObject properties;

    public String getPluginId() {
        return this.pluginId;
    }

    public void setPluginId(String str) {
        this.pluginId = str;
    }

    public String getPluginName() {
        return this.pluginName;
    }

    public void setPluginName(String str) {
        this.pluginName = str;
    }

    public int getModuleId() {
        return this.moduleId;
    }

    public void setModuleId(int i) {
        this.moduleId = i;
    }

    public JsonObject getProperties() {
        return this.properties;
    }

    public void setProperties(JsonObject jsonObject) {
        this.properties = jsonObject;
    }

    public String toString() {
        return "ModuleConfig{pluginId=" + this.pluginId + ", pluginName='" + this.pluginName + '\'' + ", moduleId=" + this.moduleId + ", properties='" + this.properties + '\'' + '}';
    }
}
