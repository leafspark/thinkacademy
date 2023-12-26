package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class CustomLog extends BaseEventInfo {
    @SerializedName("i")
    public String mInfo;
    @SerializedName("p")
    public String mParam;

    public String toString() {
        return "CustomLogBean{mInfo='" + this.mInfo + '\'' + ", mParam='" + this.mParam + '\'' + '}';
    }
}
