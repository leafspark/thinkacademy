package com.tal.app.thinkacademy.live.business.gift.bean.request;

public class GiftStatusRequest {
    private String interactId;
    private int planId;

    public GiftStatusRequest(int i, String str) {
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
