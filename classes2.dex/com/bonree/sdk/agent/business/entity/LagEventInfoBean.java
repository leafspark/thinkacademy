package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class LagEventInfoBean extends BaseEventInfo {
    @SerializedName("bi")
    public String mBinaryInfo;
    public transient int mFps;
    public transient long mLagTimeUs;
    @SerializedName("tdi")
    public ThreadDumpInfoBean mThreadDumpInfo;
    @SerializedName("t")
    public int mType;
    @SerializedName("vn")
    public String mViewName;

    public String toString() {
        return "LagEventBean{mFps=" + this.mFps + ", mLagTimeUs=" + this.mLagTimeUs + ", mViewName='" + this.mViewName + '\'' + ", mThreadDumpInfo=" + this.mThreadDumpInfo + ", mType=" + this.mType + '}';
    }
}
