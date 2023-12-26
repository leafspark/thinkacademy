package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class MethodInfoBean {
    @SerializedName("ic")
    public boolean isCustom;
    public transient long mEndRealTimeMs;
    @SerializedName("et")
    public long mEndTimeUs;
    public transient int mMethodType;
    @SerializedName("n")
    public String mName;
    @SerializedName("p")
    public String mParam;
    public transient long mStartRealTimeMs;
    @SerializedName("st")
    public long mStartTimeUs;

    public String toString() {
        return "MethodInfoBean{mStartRealTimeMs=" + this.mStartRealTimeMs + ", mEndRealTimeMs=" + this.mEndRealTimeMs + ", mMethodType=" + this.mMethodType + ", mStartTimeUs=" + this.mStartTimeUs + ", mEndTimeUs=" + this.mEndTimeUs + ", mName='" + this.mName + '\'' + ", mParam='" + this.mParam + '\'' + ", isCustom=" + this.isCustom + '}';
    }
}
