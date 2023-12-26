package com.wushuangtech.jni.bean;

public class MediaRelayInfo {
    public String mChannelId;
    public String mToken = "";
    public long mUid;

    public String toString() {
        return "MediaRelayInfo{mToken='" + this.mToken + '\'' + ", mChannelId=" + this.mChannelId + ", mUid=" + this.mUid + '}';
    }
}
