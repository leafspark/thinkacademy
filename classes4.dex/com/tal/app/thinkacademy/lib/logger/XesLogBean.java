package com.tal.app.thinkacademy.lib.logger;

public class XesLogBean {
    private XesLogContentBean content;
    private XesLogExtraBean extra;
    private int level;
    private String tag;

    public XesLogBean(String str, int i, XesLogContentBean xesLogContentBean, XesLogExtraBean xesLogExtraBean) {
        this.tag = str;
        this.level = i;
        this.content = xesLogContentBean;
        this.extra = xesLogExtraBean;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public XesLogContentBean getContent() {
        return this.content;
    }

    public void setContent(XesLogContentBean xesLogContentBean) {
        this.content = xesLogContentBean;
    }

    public XesLogExtraBean getExtra() {
        return this.extra;
    }

    public void setExtra(XesLogExtraBean xesLogExtraBean) {
        this.extra = xesLogExtraBean;
    }
}
