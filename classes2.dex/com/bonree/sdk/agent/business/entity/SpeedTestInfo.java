package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class SpeedTestInfo {
    @SerializedName("ip")
    public String mIp;
    @SerializedName("n")
    public String mName;
    @SerializedName("s")
    public int mSpeed;

    public String getIp() {
        return this.mIp;
    }

    public void setIp(String str) {
        this.mIp = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int getSpeed() {
        return this.mSpeed;
    }

    public void setSpeed(int i) {
        this.mSpeed = i;
    }

    public SpeedTestInfo(String str, String str2, int i) {
        this.mIp = str;
        this.mName = str2;
        this.mSpeed = i;
    }

    public String toString() {
        return "SpeedTestInfoBean{mIp='" + this.mIp + '\'' + ", mName='" + this.mName + '\'' + ", mSpeed=" + this.mSpeed + '}';
    }
}
