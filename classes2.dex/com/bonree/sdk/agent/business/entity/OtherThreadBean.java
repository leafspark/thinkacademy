package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class OtherThreadBean {
    @SerializedName("st")
    public String mThreadDump;
    @SerializedName("ti")
    public long mThreadId;
    @SerializedName("tn")
    public String mThreadName;

    public String toString() {
        return "OtherThreadBean{" + "mThreadId=" + this.mThreadId + ", mThreadName='" + this.mThreadName + '\'' + ", mThreadDump='" + this.mThreadDump + '\'' + '}';
    }
}
