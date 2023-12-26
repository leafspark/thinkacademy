package com.bonree.sdk.agent.business.entity.transfer;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class UploadDataResponseBean {
    @SerializedName("rc")
    public int mResponseCode;
    @SerializedName("oti")
    public OnlineTrackingInfo onlineTrackingInfo;

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public void setResponseCode(int i) {
        this.mResponseCode = i;
    }

    public OnlineTrackingInfo getOnlineTrackingInfo() {
        return this.onlineTrackingInfo;
    }

    public void setOnlineTrackingInfo(OnlineTrackingInfo onlineTrackingInfo2) {
        this.onlineTrackingInfo = onlineTrackingInfo2;
    }

    public String toString() {
        return "UploadDataResponseBean{mResponseCode=" + this.mResponseCode + ", onlineTrackingInfo=" + this.onlineTrackingInfo + '}';
    }
}
