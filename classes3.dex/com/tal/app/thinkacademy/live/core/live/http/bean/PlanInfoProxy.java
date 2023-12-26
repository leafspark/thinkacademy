package com.tal.app.thinkacademy.live.core.live.http.bean;

public class PlanInfoProxy {
    private PlanInfo planInfo;

    public PlanInfoProxy(PlanInfo planInfo2) {
        this.planInfo = planInfo2;
    }

    public String getId() {
        return this.planInfo.getId();
    }

    public String getName() {
        return this.planInfo.getName();
    }

    public int getPattern() {
        return this.planInfo.getPattern();
    }

    public long getStartStampTime() {
        return this.planInfo.getStartStampTime();
    }

    public long getEndStampTime() {
        return this.planInfo.getEndStampTime();
    }

    public String getSubjectIds() {
        return this.planInfo.getSubjectIds();
    }

    public String getSubjectName() {
        return this.planInfo.getSubjectName();
    }

    public String getGradeIds() {
        return this.planInfo.getGradeIds();
    }

    public String getGradeName() {
        return this.planInfo.getGradeName();
    }

    public String getLiveTypeId() {
        return this.planInfo.getLiveTypeId();
    }

    public long getPackageId() {
        return this.planInfo.getPackageId();
    }
}
