package com.tal.app.thinkacademy.live.business.topic.bean.request;

public class InteractStatusRequest {
    private int classId;
    private String interactId;
    private int planId;

    public InteractStatusRequest(int i, int i2, String str) {
        this.planId = i;
        this.classId = i2;
        this.interactId = str;
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

    public String getInteractId() {
        return this.interactId;
    }

    public void setInteractId(String str) {
        this.interactId = str;
    }
}
