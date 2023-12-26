package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class AppInfoBean {
    @SerializedName("ai")
    public String appId;
    @SerializedName("an")
    public String appName;
    @SerializedName("av")
    public String appVersion;
    @SerializedName("ci")
    public String channelId;
    @SerializedName("at")
    public int mAppType;

    public String toString() {
        return "AppInfoBean{" + "appId='" + this.appId + '\'' + "appVersion='" + this.appVersion + '\'' + "appName='" + this.appName + '\'' + "channelId='" + this.channelId + '\'' + "mAppType='" + this.mAppType + '\'' + '}';
    }
}
