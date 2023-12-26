package com.bonree.sdk.agent.business.entity.transfer;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class HeartbeatRequestBean {
    @SerializedName("ac")
    private int authorizeCode;
    @SerializedName("s")
    private String session;
    @SerializedName("sta")
    private int status;
    @SerializedName("tid")
    private String trackID;

    public enum HeartStatus {
        DEFAULT,
        SESSION_CLOSE,
        TIMEOUT
    }

    public String toString() {
        return "HeartbeatRequestBean{status=" + this.status + ", authorizeCode=" + this.authorizeCode + ", trackID='" + this.trackID + '\'' + ", session='" + this.session + '\'' + '}';
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getAuthorizeCode() {
        return this.authorizeCode;
    }

    public void setAuthorizeCode(int i) {
        this.authorizeCode = i;
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
}
