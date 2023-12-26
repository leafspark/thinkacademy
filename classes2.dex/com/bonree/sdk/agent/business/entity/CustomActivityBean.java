package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class CustomActivityBean {
    @SerializedName("ai")
    public String mActivityId;
    @SerializedName("an")
    public String mActivityName;
    @SerializedName("et")
    public long mEndTimeUs;
    @SerializedName("iq")
    public boolean mIsQuit;
    @SerializedName("st")
    public long mStartTimeUs;

    public String toString() {
        return "CustomActivityBean{" + "mStartTimeUs=" + this.mStartTimeUs + ", mEndTimeUs=" + this.mEndTimeUs + ", mActivityId='" + this.mActivityId + '\'' + ", mActivityName='" + this.mActivityName + '\'' + ", mIsQuit=" + this.mIsQuit + '}';
    }
}
