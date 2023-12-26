package com.tal.app.thinkacademy.live.business.videocall.entity;

public class StudentEntity {
    public String cameraAvailable;
    public String cameraIsOpen;
    private String className;
    private String id;
    private boolean isOnMic;
    private String name;

    public StudentEntity(String str, String str2) {
        this.id = str;
        this.name = str2;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public boolean isOnMic() {
        return this.isOnMic;
    }

    public void setOnMic(boolean z) {
        this.isOnMic = z;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public String toString() {
        return "StudentEntity{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", isOnMic=" + this.isOnMic + ", className='" + this.className + '\'' + '}';
    }
}
