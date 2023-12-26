package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class DataFusionInfo {
    @SerializedName("app")
    public String mAppFusionInfo;

    public DataFusionInfo(String str) {
        this.mAppFusionInfo = str;
    }

    public String toString() {
        return "DataFusionInfo{mAppFusionInfo='" + this.mAppFusionInfo + '\'' + '}';
    }
}
