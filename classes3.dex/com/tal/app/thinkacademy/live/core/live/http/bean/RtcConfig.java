package com.tal.app.thinkacademy.live.core.live.http.bean;

public class RtcConfig {
    public String classRoomId;
    public String classToken;
    private String teacherAudioUid;
    private String teacherRoomId;
    private String teacherUid;
    private String teacherVideoUid;
    private String token;
    private int tutorIsRtc;
    private String tutorRoomId;
    private String tutorToken;
    private String tutorUid;

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getTeacherVideoUid() {
        return this.teacherVideoUid;
    }

    public void setTeacherVideoUid(String str) {
        this.teacherVideoUid = str;
    }

    public String getTeacherAudioUid() {
        return this.teacherAudioUid;
    }

    public void setTeacherAudioUid(String str) {
        this.teacherAudioUid = str;
    }

    public String getTutorToken() {
        return this.tutorToken;
    }

    public void setTutorToken(String str) {
        this.tutorToken = str;
    }

    public String getTutorUid() {
        return this.tutorUid;
    }

    public void setTutorUid(String str) {
        this.tutorUid = str;
    }

    public int getTutorIsRtc() {
        return this.tutorIsRtc;
    }

    public void setTutorIsRtc(int i) {
        this.tutorIsRtc = i;
    }

    public String getTeacherRoomId() {
        return this.teacherRoomId;
    }

    public void setTeacherRoomId(String str) {
        this.teacherRoomId = str;
    }

    public String getTutorRoomId() {
        return this.tutorRoomId;
    }

    public void setTutorRoomId(String str) {
        this.tutorRoomId = str;
    }

    public String getTeacherUid() {
        return this.teacherUid;
    }

    public void setTeacherUid(String str) {
        this.teacherUid = str;
    }
}
