package com.tal.app.thinkacademy.live.business.heartbeat.entity.request;

public class HeartBeatPlaybackBody {
    private int bizId;
    private String classId;
    private String dottingTime;
    private int duration;
    private int fromType;
    private boolean isLive;
    private String planId;
    private int planStatus;
    private String playProgress;
    private String stuCouId;

    public HeartBeatPlaybackBody(String str, int i, String str2, int i2, boolean z, int i3, String str3, String str4, int i4, String str5) {
        this.classId = str;
        this.bizId = i;
        this.planId = str2;
        this.planStatus = i2;
        this.isLive = z;
        this.fromType = i3;
        this.dottingTime = str3;
        this.playProgress = str4;
        this.duration = i4;
        this.stuCouId = str5;
    }

    public String getClassId() {
        return this.classId;
    }

    public void setClassId(String str) {
        this.classId = str;
    }

    public int getBizId() {
        return this.bizId;
    }

    public void setBizId(int i) {
        this.bizId = i;
    }

    public String getPlanId() {
        return this.planId;
    }

    public void setPlanId(String str) {
        this.planId = str;
    }

    public int getPlanStatus() {
        return this.planStatus;
    }

    public void setPlanStatus(int i) {
        this.planStatus = i;
    }

    public boolean isLive() {
        return this.isLive;
    }

    public void setLive(boolean z) {
        this.isLive = z;
    }

    public int getFromType() {
        return this.fromType;
    }

    public void setFromType(int i) {
        this.fromType = i;
    }

    public String getDottingTime() {
        return this.dottingTime;
    }

    public void setDottingTime(String str) {
        this.dottingTime = str;
    }

    public String getPlayProgress() {
        return this.playProgress;
    }

    public void setPlayProgress(String str) {
        this.playProgress = str;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public String getStuCouId() {
        return this.stuCouId;
    }

    public void setStuCouId(String str) {
        this.stuCouId = str;
    }
}
