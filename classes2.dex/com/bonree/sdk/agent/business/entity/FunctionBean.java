package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class FunctionBean {
    @SerializedName("c")
    public String mClassName;
    @SerializedName("e")
    public String mEvent;
    @SerializedName("st")
    public long mStartTime;

    public String toString() {
        return "FunctionBean{" + "mStartTime=" + this.mStartTime + ", mClassName='" + this.mClassName + '\'' + ", mEvent='" + this.mEvent + '\'' + '}';
    }
}
