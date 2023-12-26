package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class DefinedLogBean {
    @SerializedName("di")
    public String mDefineInfo;
    @SerializedName("mi")
    public String mMemberId;
    @SerializedName("st")
    public long mStartTimeUs;

    public String toString() {
        return "DefinedLogBean{" + "mStartTimeUs=" + this.mStartTimeUs + ", mDefineInfo='" + this.mDefineInfo + '\'' + ", mMemberId='" + this.mMemberId + '\'' + '}';
    }
}
