package com.tal.app.thinkacademy.live.business.sign.entity.body;

public class SignInBody {
    private int classId;
    private int planId;

    public SignInBody(int i, int i2) {
        this.planId = i;
        this.classId = i2;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }

    public int getClassId() {
        return this.classId;
    }

    public void setClassId(int i) {
        this.classId = i;
    }
}
