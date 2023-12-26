package com.tal.app.thinkacademy.live.core.backplay.http.bean.request;

public class InitModuleRequest {
    private int isParentAudition;
    private int isPlayback;
    private int planId;

    public InitModuleRequest(int i, int i2, int i3) {
        this.planId = i;
        this.isPlayback = i2;
        this.isParentAudition = i3;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }

    public int getIsPlayback() {
        return this.isPlayback;
    }

    public void setIsPlayback(int i) {
        this.isPlayback = i;
    }

    public int getIsParentAudition() {
        return this.isParentAudition;
    }

    public void setIsParentAudition(int i) {
        this.isParentAudition = i;
    }
}
