package com.tal.app.thinkacademy.live.business.voice;

public class VoiceSwitch {
    private long sendTime;
    private VoiceStatus video_bet_student;

    public long getSendTime() {
        return this.sendTime;
    }

    public void setSendTime(long j) {
        this.sendTime = j;
    }

    public VoiceStatus getVideo_bet_student() {
        return this.video_bet_student;
    }

    public void setVideo_bet_student(VoiceStatus voiceStatus) {
        this.video_bet_student = voiceStatus;
    }
}
