package com.tal.app.thinkacademy.live.business.voice;

public class VoiceStatus {
    private long currentTime;
    private int planId;
    private boolean pub;
    private int teacherId;

    public long getCurrentTime() {
        return this.currentTime;
    }

    public void setCurrentTime(long j) {
        this.currentTime = j;
    }

    public boolean isPub() {
        return this.pub;
    }

    public void setPub(boolean z) {
        this.pub = z;
    }

    public int getTeacherId() {
        return this.teacherId;
    }

    public void setTeacherId(int i) {
        this.teacherId = i;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }
}
