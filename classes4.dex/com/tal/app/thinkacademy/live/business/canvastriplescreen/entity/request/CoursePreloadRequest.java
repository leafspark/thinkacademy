package com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.request;

public class CoursePreloadRequest {
    private int planId;
    private int stuId;

    public CoursePreloadRequest(int i, int i2) {
        this.stuId = i;
        this.planId = i2;
    }

    public int getStuId() {
        return this.stuId;
    }

    public void setStuId(int i) {
        this.stuId = i;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }
}
