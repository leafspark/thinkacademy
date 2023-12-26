package com.wushuangtech.bean;

public class AVStreamPublishBean {
    public boolean mAudioMuted = true;
    public String mChannelName;
    public int mRole = 2;
    public boolean mVideoMuted = true;

    public AVStreamPublishBean(String str) {
        this.mChannelName = str;
    }

    public String toString() {
        return "AVStreamPublishBean{mChannelName='" + this.mChannelName + '\'' + ", mAudioMuted=" + this.mAudioMuted + ", mVideoMuted=" + this.mVideoMuted + ", mRole=" + this.mRole + '}';
    }
}
