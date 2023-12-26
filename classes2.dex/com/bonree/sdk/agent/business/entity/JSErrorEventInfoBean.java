package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class JSErrorEventInfoBean extends BaseEventInfo {
    @SerializedName("col")
    public int col;
    @SerializedName("l")
    public int line;
    @SerializedName("cbbq")
    public String mCustomBusinessBody;
    @SerializedName("cbhq")
    public String mCustomBusinessHeader;
    @SerializedName("cbq")
    public String mCustomBusinessQuery;
    @SerializedName("m")
    public String msg;
    @SerializedName("n")
    public String name;
    @SerializedName("pct")
    public long pageCreateTime;
    @SerializedName("pvid")
    public String pvid;
    @SerializedName("sta")
    public String stack;
    public transient long startTime;
    @SerializedName("t")
    public String title;
    @SerializedName("et")
    public String type;
    @SerializedName("url")
    public String url;

    public String toString() {
        return "JSErrorEventBean{startTime=" + this.startTime + ", pvid='" + this.pvid + '\'' + ", url='" + this.url + '\'' + ", title='" + this.title + '\'' + ", name='" + this.name + '\'' + ", type='" + this.type + '\'' + ", msg='" + this.msg + '\'' + ", line=" + this.line + ", col=" + this.col + ", stack='" + this.stack + '\'' + ", pct='" + this.pageCreateTime + '\'' + ", cbhq='" + this.mCustomBusinessHeader + '\'' + ", cbbq='" + this.mCustomBusinessBody + '\'' + ", cbq='" + this.mCustomBusinessQuery + '\'' + '}';
    }
}
