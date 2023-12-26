package com.wushuangtech.api;

public abstract class RtcBaseManager {
    protected final String mChannelName;
    protected final Object mLock = new Object();

    public abstract void clearResource();

    public RtcBaseManager(String str) {
        this.mChannelName = str;
    }

    public String getChannelName() {
        return this.mChannelName;
    }
}
