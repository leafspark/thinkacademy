package com.tal.app.thinkacademy.live.business.liveplay.bean;

public class RtcStatusRequest {
    private int cameraIsOpen;
    private int cameraPermission;
    private int classId;
    private int micIsOpen;
    private int micPermission;
    private int planId;
    private int status;

    public RtcStatusRequest(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.classId = i;
        this.planId = i2;
        this.status = i3;
        this.micPermission = i4;
        this.cameraPermission = i5;
        this.micIsOpen = i6;
        this.cameraIsOpen = i7;
    }

    public int getClassId() {
        return this.classId;
    }

    public void setClassId(int i) {
        this.classId = i;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getMicPermission() {
        return this.micPermission;
    }

    public void setMicPermission(int i) {
        this.micPermission = i;
    }

    public int getCameraPermission() {
        return this.cameraPermission;
    }

    public void setCameraPermission(int i) {
        this.cameraPermission = i;
    }

    public int getMicIsOpen() {
        return this.micIsOpen;
    }

    public void setMicIsOpen(int i) {
        this.micIsOpen = i;
    }

    public int getCameraIsOpen() {
        return this.cameraIsOpen;
    }

    public void setCameraIsOpen(int i) {
        this.cameraIsOpen = i;
    }
}
