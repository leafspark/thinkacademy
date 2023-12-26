package com.tal.app.thinkacademy.live.business.studentvideo.bean.body;

public class StudentListBody {
    private int classId;
    private int isParentAudition;
    private int planId;

    public StudentListBody(int i, int i2, int i3) {
        this.planId = i;
        this.classId = i2;
        this.isParentAudition = i3;
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

    public int getIsParentAudition() {
        return this.isParentAudition;
    }

    public void setIsParentAudition(int i) {
        this.isParentAudition = i;
    }
}
