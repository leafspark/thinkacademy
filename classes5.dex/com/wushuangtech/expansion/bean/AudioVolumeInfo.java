package com.wushuangtech.expansion.bean;

public class AudioVolumeInfo {
    public String mChannelId;
    public long mUid;
    public int mVad;
    public int mVolume;

    public String toString() {
        return "AudioVolumeInfo{mChannelId=" + this.mChannelId + ", mUid=" + this.mUid + ", mVolume=" + this.mVolume + ", mVad=" + this.mVad + '}';
    }
}
