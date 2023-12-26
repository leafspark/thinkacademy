package com.wushuangtech.bean;

public class InterCorrectUserBean extends InterCorrectionBean {
    public String mChannelName;
    public long mUid;

    public InterCorrectUserBean(String str, long j) {
        this.mChannelName = str;
        this.mUid = j;
    }

    public String toString() {
        return "InterSetupRemoteBean{mAction=" + this.mAction + ", mInfo=" + this.mInfo + ", mTimestamp=" + this.mTimestamp + ", mChannelId=" + this.mChannelName + ", mUid=" + this.mUid + '}';
    }
}
