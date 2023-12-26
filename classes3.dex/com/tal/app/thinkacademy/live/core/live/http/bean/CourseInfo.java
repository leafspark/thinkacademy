package com.tal.app.thinkacademy.live.core.live.http.bean;

public class CourseInfo {
    public static int ROLE_AUDITION = 1;
    public static int ROLE_NORMAL_USER;
    private int bizId;
    private int classId;
    private int courseId;
    private int isAudition;
    private boolean isParentAuditionLocal = false;
    private int planId;
    private int stuId;
    private int teamId;
    private int tutorId;

    public int getClassId() {
        return this.classId;
    }

    public void setClassId(int i) {
        this.classId = i;
    }

    public int getTeamId() {
        return this.teamId;
    }

    public void setTeamId(int i) {
        this.teamId = i;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int i) {
        this.courseId = i;
    }

    public int getStuId() {
        return this.stuId;
    }

    public void setStuId(int i) {
        this.stuId = i;
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

    public int getTutorId() {
        return this.tutorId;
    }

    public void setTutorId(int i) {
        this.tutorId = i;
    }

    public int getIsAudition() {
        return this.isAudition;
    }

    public void setIsAudition(int i) {
        this.isAudition = i;
    }

    public boolean isParentAuditionLocal() {
        return this.isParentAuditionLocal;
    }

    public void setParentAuditionLocal(boolean z) {
        this.isParentAuditionLocal = z;
    }
}
