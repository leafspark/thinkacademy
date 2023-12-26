package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class StateChangeEventInfoBean extends BaseEventInfo {
    @SerializedName("d")
    public String description;
    @SerializedName("tn")
    public NetWorkStateInfoBean targetNetStateInfo;
    @SerializedName("t")
    public int type;

    public String toString() {
        StringBuilder sb = new StringBuilder("StateChangeEventBean{");
        sb.append("type='");
        sb.append(this.type);
        sb.append('\'');
        sb.append(", description=");
        sb.append(this.description);
        if (this.targetNetStateInfo == null) {
            sb.append(", targetNetStateInfo=null");
        } else {
            sb.append(", targetNetStateInfo=");
            sb.append(this.targetNetStateInfo.toString());
        }
        sb.append('}');
        return sb.toString();
    }
}
