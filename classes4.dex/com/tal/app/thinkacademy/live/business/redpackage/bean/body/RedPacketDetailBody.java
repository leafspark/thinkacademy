package com.tal.app.thinkacademy.live.business.redpackage.bean.body;

public class RedPacketDetailBody {
    private String interactId;
    private int planId;

    public RedPacketDetailBody(int i, String str) {
        this.planId = i;
        this.interactId = str;
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
