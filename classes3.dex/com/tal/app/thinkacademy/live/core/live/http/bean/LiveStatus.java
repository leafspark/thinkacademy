package com.tal.app.thinkacademy.live.core.live.http.bean;

public class LiveStatus {
    private int classroomStatus;
    private boolean startClass;
    private int streamMode;

    public boolean isStartClass() {
        return this.startClass;
    }

    public void setStartClass(boolean z) {
        this.startClass = z;
    }

    public int getStreamMode() {
        return this.streamMode;
    }

    public void setStreamMode(int i) {
        this.streamMode = i;
    }

    public int getClassroomStatus() {
        return this.classroomStatus;
    }

    public void setClassroomStatus(int i) {
        this.classroomStatus = i;
    }

    public String toString() {
        return "LiveStatus{startClass=" + this.startClass + ", streamMode=" + this.streamMode + ", classroomStatus=" + this.classroomStatus + '}';
    }
}
