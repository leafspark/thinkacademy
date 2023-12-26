package com.tal.app.thinkacademy.live.business.exam.bean;

public class ExamInfoBody {
    private int planId;

    public ExamInfoBody(int i) {
        this.planId = i;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }
}
