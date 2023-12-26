package com.tal.app.thinkacademy.live.core.backplay.http.bean.request;

public class PlayBackUrlRequest {
    private String appId;
    private int bizId;
    private String fid;
    private int planId;
    private int teacherId;

    public PlayBackUrlRequest(String str, String str2, int i, int i2, int i3) {
        this.appId = str;
        this.fid = str2;
        this.bizId = i;
        this.planId = i2;
        this.teacherId = i3;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(String str) {
        this.fid = str;
    }

    public int getBizId() {
        return this.bizId;
    }

    public void setBizId(int i) {
        this.bizId = i;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }

    public int getTeacherId() {
        return this.teacherId;
    }

    public void setTeacherId(int i) {
        this.teacherId = i;
    }
}
