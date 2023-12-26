package com.tal.app.thinkacademy.live.business.liveplay.bean;

import android.view.SurfaceView;

public class TeacherOnStageMsg {
    private boolean isOnLine = false;
    private boolean isOpenCamera = false;
    private boolean isOpenMic = false;
    private SurfaceView mSurfaceView = null;
    private long mTeacherAudioUid = -1;
    private String mTeacherName;

    public boolean isOnLine() {
        return this.isOnLine;
    }

    public void setOnLine(boolean z) {
        this.isOnLine = z;
    }

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

    public SurfaceView getSurfaceView() {
        return this.mSurfaceView;
    }

    public void setSurfaceView(SurfaceView surfaceView) {
        this.mSurfaceView = surfaceView;
    }

    public long getTeacherAudioUid() {
        return this.mTeacherAudioUid;
    }

    public void setTeacherAudioUid(long j) {
        this.mTeacherAudioUid = j;
    }

    public String getTeacherName() {
        return this.mTeacherName;
    }

    public void setTeacherName(String str) {
        this.mTeacherName = str;
    }
}
