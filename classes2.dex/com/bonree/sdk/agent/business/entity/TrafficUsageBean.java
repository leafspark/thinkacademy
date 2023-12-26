package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class TrafficUsageBean {
    @SerializedName("tu")
    public long mTrafficUsage;
    @SerializedName("sin")
    public String netStateInfoKey;

    public String toString() {
        return "TrafficUsageBean{" + "mTrafficUsage=" + this.mTrafficUsage + ", netStateInfoKey=" + this.netStateInfoKey + '}';
    }
}
