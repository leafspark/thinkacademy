package com.tal.app.thinkacademy.live.core.plugin;

public final class PluginEventData {
    private String data;
    private Class mClass;
    private Object object;
    private String operation;

    public PluginEventData(Class cls, String str, String str2) {
        this.mClass = cls;
        this.operation = str;
        this.data = str2;
    }

    public PluginEventData(Class cls, String str, String str2, Object obj) {
        this.mClass = cls;
        this.operation = str;
        this.data = str2;
        this.object = obj;
    }

    public Class getmClass() {
        return this.mClass;
    }

    public String getOperation() {
        return this.operation;
    }

    public String getData() {
        return this.data;
    }

    public Object getObject() {
        return this.object;
    }

    public static PluginEventData obtainData(Class cls, String str) {
        return new PluginEventData(cls, str, "");
    }

    public static PluginEventData obtainData(Class cls, String str, String str2) {
        return new PluginEventData(cls, str, str2);
    }

    public static PluginEventData obtainData(Class cls, String str, Object obj) {
        return new PluginEventData(cls, str, (String) null, obj);
    }
}
