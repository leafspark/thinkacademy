package com.tal.app.thinkacademy.live.business.livemessage.entity.body;

public class LiveBackMsgBody {
    private int bizld;
    private int classId;
    private int planId;
    private long startTimeStamp;

    public LiveBackMsgBody(int i, int i2, long j, int i3) {
        this.planId = i;
        this.bizld = i2;
        this.startTimeStamp = j;
        this.classId = i3;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }

    public int getBizld() {
        return this.bizld;
    }

    public void setBizld(int i) {
        this.bizld = i;
    }

    public long getStartTimeStamp() {
        return this.startTimeStamp;
    }

    public void setStartTimeStamp(long j) {
        this.startTimeStamp = j;
    }

    public int getClassId() {
        return this.classId;
    }

    public void setClassId(int i) {
        this.classId = i;
    }
}
