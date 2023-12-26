package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.concurrent.TimeUnit;

public class AppStateInfoBean {
    @SerializedName("pft")
    public long mPeriodicForegroundTimeUs;
    @SerializedName("pplt")
    public long mPeriodicProcessLifeTimeUs;

    public String toString() {
        return "AppStateInfoBean{应用进程存活时长=" + TimeUnit.MICROSECONDS.toSeconds(this.mPeriodicProcessLifeTimeUs) + ", 前台存活时长 =" + TimeUnit.MICROSECONDS.toSeconds(this.mPeriodicForegroundTimeUs) + '}';
    }
}
