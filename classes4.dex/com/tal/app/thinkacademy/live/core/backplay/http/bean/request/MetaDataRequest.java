package com.tal.app.thinkacademy.live.core.backplay.http.bean.request;

public class MetaDataRequest {
    private int bizId;
    private int courseId;
    private int planId;
    private int playbackStatus;

    public MetaDataRequest(int i, int i2, int i3, int i4) {
        this.bizId = i;
        this.planId = i2;
        this.courseId = i3;
        this.playbackStatus = i4;
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

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int i) {
        this.courseId = i;
    }

    public int getPlaybackStatus() {
        return this.playbackStatus;
    }

    public void setPlaybackStatus(int i) {
        this.playbackStatus = i;
    }
}
