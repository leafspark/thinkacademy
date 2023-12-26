package com.wushuangtech.bean;

public class AVSourceSyncBean {
    public String mChannelName;
    public long mUid;

    public AVSourceSyncBean(String str, long j) {
        this.mChannelName = str;
        this.mUid = j;
    }

    public String toString() {
        return "AVSourceSyncBean{mChannelName='" + this.mChannelName + '\'' + ", mUid=" + this.mUid + '}';
    }
}
