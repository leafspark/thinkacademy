package com.tal.app.thinkacademy.live.business.gift.bean.request;

public class SendGiftRequest {
    private int classId;
    private int giftId;
    private String interactId;
    private int planId;

    public SendGiftRequest(int i, String str, int i2, int i3) {
        this.planId = i;
        this.interactId = str;
        this.giftId = i2;
        this.classId = i3;
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

    public int getGiftId() {
        return this.giftId;
    }

    public void setGiftId(int i) {
        this.giftId = i;
    }

    public int getClassId() {
        return this.classId;
    }

    public void setClassId(int i) {
        this.classId = i;
    }
}
