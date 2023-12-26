package com.tal.app.thinkacademy.live.business.liveplay.bean;

public class TeacherStatusInfo {
    private boolean isAudioMute = false;
    private boolean isOnLine = true;
    private boolean isOpenCamera = false;
    private boolean isOpenMic = false;
    private boolean isVideoMute = false;

    public boolean isOpenMic() {
        return this.isOpenMic;
    }

    public void setOpenMic(boolean z) {
        this.isOpenMic = z;
    }

    public boolean isOpenCamera() {
        return this.isOpenCamera;
    }

    public void setOpenCamera(boolean z) {
        this.isOpenCamera = z;
    }

    public boolean isOnLine() {
        return this.isOnLine;
    }

    public void setOnLine(boolean z) {
        this.isOnLine = z;
    }

    public boolean isVideoMute() {
        return this.isVideoMute;
    }

    public void setVideoMute(boolean z) {
        this.isVideoMute = z;
    }

    public boolean isAudioMute() {
        return this.isAudioMute;
    }

    public void setAudioMute(boolean z) {
        this.isAudioMute = z;
    }
}
