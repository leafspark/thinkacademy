package com.tal.app.thinkacademy.lib.logger;

import com.google.gson.JsonObject;

public class XesLogJsonObjectBean {
    private JsonObject content;
    private XesLogExtraBean extra;
    private String level;
    private String tag;

    public XesLogJsonObjectBean(String str, String str2, JsonObject jsonObject, XesLogExtraBean xesLogExtraBean) {
        this.tag = str;
        this.level = str2;
        this.content = jsonObject;
        this.extra = xesLogExtraBean;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String str) {
        this.level = str;
    }

    public JsonObject getContent() {
        return this.content;
    }

    public void setContent(JsonObject jsonObject) {
        this.content = jsonObject;
    }

    public XesLogExtraBean getExtra() {
        return this.extra;
    }

    public void setExtra(XesLogExtraBean xesLogExtraBean) {
        this.extra = xesLogExtraBean;
    }
}
