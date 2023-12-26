package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class CustomEventInfoBean extends BaseEventInfo {
    @SerializedName("ci")
    public String correlationId;
    @SerializedName("d")
    public long mDuration;
    @SerializedName("i")
    public String mId;
    @SerializedName("l")
    public String mLabel;
    @SerializedName("n")
    public String mName;
    @SerializedName("p")
    public String mParam;
    @SerializedName("t")
    public int mType;
    public transient long startTime;

    public String toString() {
        return "CustomEventInfoBean{mId='" + this.mId + '\'' + ", mName='" + this.mName + '\'' + ", mParam='" + this.mParam + '\'' + ", mType=" + this.mType + ", mDuration=" + this.mDuration + ", mLabel='" + this.mLabel + '\'' + ", correlationId='" + this.correlationId + '\'' + '}';
    }
}
