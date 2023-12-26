package com.tal.app.thinkacademy.live.business.gift.bean.request;

public class GiftListRequest {
    private String gradeId;
    private int planId;

    public GiftListRequest(String str, int i) {
        this.gradeId = str;
        this.planId = i;
    }

    public String getGradeId() {
        return this.gradeId;
    }

    public void setGradeId(String str) {
        this.gradeId = str;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }
}
