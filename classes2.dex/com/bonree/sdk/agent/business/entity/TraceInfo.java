package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class TraceInfo {
    @SerializedName("i")
    private String mInfo;
    @SerializedName("ti")
    private long mTime;
    @SerializedName("t")
    private String mType;

    public long getTime() {
        return this.mTime;
    }

    public void setTime(long j) {
        this.mTime = j;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getInfo() {
        return this.mInfo;
    }

    public void setInfo(String str) {
        this.mInfo = str;
    }

    public String toString() {
        return "TraceInfo{mTime=" + this.mTime + ", mType='" + this.mType + '\'' + ", mInfo='" + this.mInfo + '\'' + '}';
    }
}
