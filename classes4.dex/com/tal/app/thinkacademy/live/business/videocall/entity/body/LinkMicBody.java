package com.tal.app.thinkacademy.live.business.videocall.entity.body;

public class LinkMicBody {
    private int cameraAvailable;
    private int classId;
    private int courseId;
    private String interactId;
    private int mikeAvailable;
    private int planId;
    private int teacherId;
    private int tutorId;

    public LinkMicBody(int i, int i2, int i3, int i4, int i5, String str, int i6, int i7) {
        this.teacherId = i;
        this.tutorId = i2;
        this.planId = i3;
        this.courseId = i4;
        this.classId = i5;
        this.interactId = str;
        this.cameraAvailable = i6;
        this.mikeAvailable = i7;
    }

    public int getTeacherId() {
        return this.teacherId;
    }

    public void setTeacherId(int i) {
        this.teacherId = i;
    }

    public int getTutorId() {
        return this.tutorId;
    }

    public void setTutorId(int i) {
        this.tutorId = i;
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

    public int getClassId() {
        return this.classId;
    }

    public void setClassId(int i) {
        this.classId = i;
    }

    public String getInteractId() {
        return this.interactId;
    }

    public void setInteractId(String str) {
        this.interactId = str;
    }

    public int getCameraAvailable() {
        return this.cameraAvailable;
    }

    public void setCameraAvailable(int i) {
        this.cameraAvailable = i;
    }

    public int getMikeAvailable() {
        return this.mikeAvailable;
    }

    public void setMikeAvailable(int i) {
        this.mikeAvailable = i;
    }
}
