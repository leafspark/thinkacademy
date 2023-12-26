package com.bonree.sdk.agent.business.entity.battery;

import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.common.gson.annotations.SerializedName;

public class BatteryEventInfoBean extends BaseEventInfo {
    @SerializedName("at")
    public int activityType;
    @SerializedName("as")
    public int appState;
    public transient long batteryTimeMS;
    @SerializedName("id")
    public String identifier;
    @SerializedName("plt")
    public long periodLoadTimeUS;
    @SerializedName("tt")
    public int triggerType;

    public String toString() {
        return "BatteryEventInfoBean{" + "identifier='" + this.identifier + '\'' + ", activityType=" + this.activityType + ", triggerType=" + this.triggerType + ", periodLoadTimeUS=" + this.periodLoadTimeUS + ", appState=" + this.appState + '}';
    }
}
