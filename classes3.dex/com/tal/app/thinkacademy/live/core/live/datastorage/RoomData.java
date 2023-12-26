package com.tal.app.thinkacademy.live.core.live.datastorage;

import com.tal.app.thinkacademy.common.utils.ServeTime;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.live.constant.LiveConstants;
import com.tal.app.thinkacademy.live.core.live.http.bean.LiveStatus;
import com.tal.app.thinkacademy.live.core.live.http.response.EnterEntity;

public class RoomData {
    private int classroomStatus;
    private LiveAreaCompat.CourseRate mCourseRate;
    private boolean mGraffitiUseCourseRate;
    private boolean mHasChatBox;
    private boolean mIsOnStage;
    private boolean mIsPlayback;
    private String mode;
    private ServeTime serveTime;
    private int streamMode;

    public RoomData(boolean z) {
        this.mIsPlayback = z;
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public int getClassroomStatus() {
        return this.classroomStatus;
    }

    public void setClassroomStatus(int i) {
        this.classroomStatus = i;
    }

    public int getStreamMode() {
        return this.streamMode;
    }

    public void setStreamMode(int i) {
        this.streamMode = i;
    }

    public boolean isPlayback() {
        return this.mIsPlayback;
    }

    public void setIsPlayback(boolean z) {
        this.mIsPlayback = z;
    }

    public void updateWithEnter(EnterEntity enterEntity, long j) {
        if (enterEntity != null) {
            ServeTime serveTime2 = new ServeTime(enterEntity.nowTime);
            this.serveTime = serveTime2;
            serveTime2.setRequestTimeOffset(j);
            LiveStatus liveStatus = enterEntity.getLiveStatus();
            if (liveStatus != null) {
                setMode(liveStatus.getStreamMode() == 1 ? LiveConstants.MODE_CLASS : LiveConstants.MODE_TRAINING);
                setClassroomStatus(liveStatus.getClassroomStatus());
            }
        }
    }

    public long getServeNowTime() {
        ServeTime serveTime2 = this.serveTime;
        if (serveTime2 != null) {
            return serveTime2.getServeNowTime();
        }
        return System.currentTimeMillis() / 1000;
    }

    public long getServeNowMillsTime() {
        ServeTime serveTime2 = this.serveTime;
        if (serveTime2 != null) {
            return serveTime2.getServeNowMillsTime();
        }
        return System.currentTimeMillis();
    }

    public boolean isIsOnStage() {
        return this.mIsOnStage;
    }

    public void setIsOnStage(boolean z) {
        this.mIsOnStage = z;
    }

    public boolean isHasChatBox() {
        return this.mHasChatBox;
    }

    public void setHasChatBox(boolean z) {
        this.mHasChatBox = z;
    }

    public LiveAreaCompat.CourseRate getCourseRate() {
        return this.mCourseRate;
    }

    public void setCourseRate(LiveAreaCompat.CourseRate courseRate) {
        this.mCourseRate = courseRate;
    }

    public boolean getGraffitiUseCourseRate() {
        return this.mGraffitiUseCourseRate;
    }

    public void setGraffitiUseCourseRate(boolean z) {
        this.mGraffitiUseCourseRate = z;
    }
}
