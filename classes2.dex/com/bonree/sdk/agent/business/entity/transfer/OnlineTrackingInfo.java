package com.bonree.sdk.agent.business.entity.transfer;

import android.text.TextUtils;
import com.bonree.sdk.common.gson.annotations.SerializedName;

public class OnlineTrackingInfo {
    @SerializedName("hbt")
    private long heartbeatTime;
    @SerializedName("hbu")
    private String heartbeatUrl;
    @SerializedName("ict")
    private long instantCycleTimeUpload;
    @SerializedName("s")
    private String session;
    @SerializedName("tid")
    private String trackID;

    public String toString() {
        return "OnlineTrackingInfo{trackID='" + this.trackID + '\'' + ", session='" + this.session + '\'' + ", heartbeatUrl='" + this.heartbeatUrl + '\'' + ", instantCycleTimeUpload='" + this.instantCycleTimeUpload + '\'' + ", heartbeatTime='" + this.heartbeatTime + '\'' + '}';
    }

    public String getTrackID() {
        return this.trackID;
    }

    public void setTrackID(String str) {
        this.trackID = str;
    }

    public String getSession() {
        return this.session;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public String getHeartbeatUrl() {
        return this.heartbeatUrl;
    }

    public void setHeartbeatUrl(String str) {
        this.heartbeatUrl = str;
    }

    public long getInstantCycleTimeUpload() {
        return this.instantCycleTimeUpload;
    }

    public void setInstantCycleTimeUpload(long j) {
        this.instantCycleTimeUpload = j;
    }

    public long getHeartbeatTime() {
        return this.heartbeatTime;
    }

    public void setHeartbeatTime(long j) {
        this.heartbeatTime = j;
    }

    public boolean isInvalid() {
        return TextUtils.isEmpty(this.trackID) || TextUtils.isEmpty(this.session) || TextUtils.isEmpty(this.heartbeatUrl);
    }
}
