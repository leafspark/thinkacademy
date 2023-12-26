package com.tal.app.thinkacademy.live.business.studentvideo.bean.body;

public class StudentVideoUidBody {
    private int cameraPerm;
    private int classId;
    private int isParentAudition;
    private int planId;
    private int tutorId;

    public StudentVideoUidBody(int i, int i2, int i3, int i4, int i5) {
        this.planId = i;
        this.classId = i2;
        this.tutorId = i3;
        this.cameraPerm = i4;
        this.isParentAudition = i5;
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

    public int getTutorId() {
        return this.tutorId;
    }

    public void setTutorId(int i) {
        this.tutorId = i;
    }

    public int getCameraPerm() {
        return this.cameraPerm;
    }

    public void setCameraPerm(int i) {
        this.cameraPerm = i;
    }

    public int getIsParentAudition() {
        return this.isParentAudition;
    }

    public void setIsParentAudition(int i) {
        this.isParentAudition = i;
    }
}
