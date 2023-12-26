package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class IosSymbolicBean {
    @SerializedName("ba")
    public String mBaseAddress;
    @SerializedName("bi")
    public String mBinaryInfo;
    @SerializedName("eu")
    public String mErroruuid;

    public String toString() {
        return "IosSymbolicBean{" + "mBinaryInfo='" + this.mBinaryInfo + '\'' + ", mErroruuid='" + this.mErroruuid + '\'' + ", mBaseAddress='" + this.mBaseAddress + '\'' + '}';
    }
}
