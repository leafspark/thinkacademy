package com.wushuangtech.expansion.bean;

public class ChannelMediaInfo {
    public String mChannelId;
    public String mToken;
    public long mUid;

    public ChannelMediaInfo(String str, String str2, long j) {
        this.mChannelId = str;
        this.mToken = str2;
        this.mUid = j;
    }

    public String toString() {
        return "ChannelMediaInfo{mChannelId=" + this.mChannelId + ", mToken='" + this.mToken + '\'' + ", mUid=" + this.mUid + '}';
    }
}
