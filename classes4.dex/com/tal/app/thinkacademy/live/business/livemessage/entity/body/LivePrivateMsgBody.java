package com.tal.app.thinkacademy.live.business.livemessage.entity.body;

public class LivePrivateMsgBody {
    private int planId;
    private int tutorId;

    public LivePrivateMsgBody(int i, int i2) {
        this.planId = i;
        this.tutorId = i2;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }

    public int getTutorId() {
        return this.tutorId;
    }

    public void setTutorId(int i) {
        this.tutorId = i;
    }
}
