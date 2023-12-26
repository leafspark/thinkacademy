package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.List;

public class CustomSpeedTestEventBean extends BaseEventInfo {
    @SerializedName("oip")
    public String mOptimumIP;
    @SerializedName("sti")
    public List<SpeedTestInfo> mSpeedTestInfo;

    public String toString() {
        return "CustomSpeedTestEventBean{mOptimumIP='" + this.mOptimumIP + '\'' + ", mSpeedTestInfo=" + this.mSpeedTestInfo + '}';
    }
}
