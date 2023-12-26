package com.tal.app.thinkacademy.live.business.heartbeat.entity;

public class UserHeartBeatRequestParam {
    private int bizId;
    private String classId;
    private String dottingTime;
    private int duration;
    private int fromType;
    private boolean isLive;
    private boolean isSuspend;
    private String planId;
    private int planStatus;
    private String playProgress;
    private String stuCouId;

    public boolean isSuspend() {
        return this.isSuspend;
    }

    public void setSuspend(boolean z) {
        this.isSuspend = z;
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

    public String getStuCouId() {
        return this.stuCouId;
    }

    public void setStuCouId(String str) {
        this.stuCouId = str;
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

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public String getPlayProgress() {
        return this.playProgress;
    }

    public void setPlayProgress(String str) {
        this.playProgress = str;
    }

    public String toString() {
        return "UserOnLineRequestParam{classId='" + this.classId + '\'' + ", bizId=" + this.bizId + ", planId='" + this.planId + '\'' + ", planStatus=" + this.planStatus + ", stuCouId='" + this.stuCouId + '\'' + ", isLive=" + this.isLive + ", fromType=" + this.fromType + ", dottingTime='" + this.dottingTime + '\'' + ", playProgress='" + this.playProgress + '\'' + ", duration=" + this.duration + '}';
    }
}
