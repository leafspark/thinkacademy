package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class AppStartResultBean {
    @SerializedName("ic")
    public boolean isColdStart;
    public transient boolean isWarnStart;
    @SerializedName("lt")
    public long mLoadTimeUs;
    @SerializedName("s")
    public SnapshotBean mSnapshotBean;
    @SerializedName("st")
    public long mStartTimeUs;

    public String toString() {
        return "AppStartResultBean{isWarnStart=" + this.isWarnStart + ", mStartTimeUs=" + this.mStartTimeUs + ", mLoadTimeUs=" + this.mLoadTimeUs + ", isColdStart=" + this.isColdStart + ", mSnapshotBean=" + this.mSnapshotBean + '}';
    }
}
