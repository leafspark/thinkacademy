package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class CustomMetricEventInfo extends BaseEventInfo {
    @SerializedName("n")
    public String mName;
    @SerializedName("v")
    public long mValue;
    @SerializedName("p")
    public String param;

    public String toString() {
        return "CustomMetricEvent{mName='" + this.mName + '\'' + ", mValue=" + this.mValue + ", param='" + this.param + '\'' + '}';
    }
}
