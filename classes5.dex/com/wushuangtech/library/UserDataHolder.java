package com.wushuangtech.library;

public class UserDataHolder {
    private boolean mAudioRemoteStopRecv;
    private boolean mVideoRemoteStopRecv;

    public void setAudioRemoteStopRecv(boolean z) {
        this.mAudioRemoteStopRecv = z;
    }

    public void setVideoRemoteStopRecv(boolean z) {
        this.mVideoRemoteStopRecv = z;
    }

    public boolean isAudioRemoteStopRecv() {
        return this.mAudioRemoteStopRecv;
    }

    public boolean isVideoRemoteStopRecv() {
        return this.mVideoRemoteStopRecv;
    }
}
