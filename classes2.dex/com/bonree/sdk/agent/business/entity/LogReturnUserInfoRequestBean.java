package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class LogReturnUserInfoRequestBean {
    @SerializedName("ai")
    public String appId;
    @SerializedName("di")
    public String deviceId;
    @SerializedName("ei")
    public String extraInfo;
    @SerializedName("ui")
    public String userId;

    public String toString() {
        return "UserInfoRequestBean{appId='" + this.appId + '\'' + ", deviceId='" + this.deviceId + '\'' + ", userId='" + this.userId + '\'' + ", extraInfo='" + this.extraInfo + '\'' + '}';
    }
}
