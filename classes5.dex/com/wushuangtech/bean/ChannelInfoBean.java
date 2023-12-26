package com.wushuangtech.bean;

public class ChannelInfoBean implements Cloneable {
    public String mChannelName;
    public long mJoinChannelTimestamp;

    /* access modifiers changed from: protected */
    public ChannelInfoBean clone() {
        try {
            return (ChannelInfoBean) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String toString() {
        return "ChannelInfoBean{mChannelName='" + this.mChannelName + '\'' + ", mJoinChannelTimestamp=" + this.mJoinChannelTimestamp + '}';
    }
}
