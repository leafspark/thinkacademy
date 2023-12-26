package com.tal.app.thinkacademy.live.business.redpackage.bean.body;

public class GrabRedPacketBody {
    private int classId;
    private String interactId;
    private int planId;

    public GrabRedPacketBody(int i, String str, int i2) {
        this.planId = i;
        this.interactId = str;
        this.classId = i2;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }

    public String getInteractId() {
        return this.interactId;
    }

    public void setInteractId(String str) {
        this.interactId = str;
    }
}
