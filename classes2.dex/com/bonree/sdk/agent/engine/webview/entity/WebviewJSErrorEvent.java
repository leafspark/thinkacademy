package com.bonree.sdk.agent.engine.webview.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class WebviewJSErrorEvent {
    @SerializedName("col")
    public int col;
    @SerializedName("en")
    public String errorName;
    @SerializedName("l")
    public int line;
    @SerializedName("m")
    public String msg;
    @SerializedName("n")
    public String name;
    @SerializedName("pvid")
    public String pvid;
    @SerializedName("sta")
    public String stack;
    @SerializedName("t")
    public String title;
    @SerializedName("et")
    public String type;
    @SerializedName("url")
    public String url;
}
