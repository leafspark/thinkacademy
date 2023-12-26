package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class ThreadDumpInfoBean {
    @SerializedName("di")
    public String mDumpInfo;
    @SerializedName("ti")
    public String mThreadId;
    @SerializedName("n")
    public String mThreadName;

    public String toString() {
        return "ThreadDumpInfoBean{mThreadId='" + this.mThreadId + '\'' + ", mThreadName='" + this.mThreadName + '\'' + ", mDumpInfo='" + this.mDumpInfo + '\'' + '}';
    }
}
