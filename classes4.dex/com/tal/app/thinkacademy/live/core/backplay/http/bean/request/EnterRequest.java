package com.tal.app.thinkacademy.live.core.backplay.http.bean.request;

public class EnterRequest {
    private int bizId;
    private int courseId;
    private int isParentAudition;
    private int planId;
    private int updateUserInfo;

    public EnterRequest(int i, int i2, int i3, int i4, int i5) {
        this.bizId = i;
        this.planId = i2;
        this.courseId = i3;
        this.updateUserInfo = i4;
        this.isParentAudition = i5;
    }

    public int getIsParentAudition() {
        return this.isParentAudition;
    }

    public void setIsParentAudition(int i) {
        this.isParentAudition = i;
    }

    public int getBizId() {
        return this.bizId;
    }

    public void setBizId(int i) {
        this.bizId = i;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int i) {
        this.courseId = i;
    }

    public int getUpdateUserInfo() {
        return this.updateUserInfo;
    }

    public void setUpdateUserInfo(int i) {
        this.updateUserInfo = i;
    }
}
