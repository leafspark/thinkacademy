package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class CustomBusinessBean {
    @SerializedName("v")
    public String mValue;
    @SerializedName("k")
    public String mkey;

    public String toString() {
        return "CustomBusinessBean{" + "mkey='" + this.mkey + '\'' + ", mValue=" + this.mValue + '}';
    }
}
