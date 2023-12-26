package com.tal.app.thinkacademy.live.business.chatbox.bean;

import java.io.Serializable;

public class TeacherControlChatBean implements Serializable {
    public static final String STATUS_ALL = "all";
    public static final String STATUS_TEACHER = "teacher";
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
