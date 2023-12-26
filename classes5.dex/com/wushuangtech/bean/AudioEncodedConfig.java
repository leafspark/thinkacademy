package com.wushuangtech.bean;

public class AudioEncodedConfig implements Cloneable {
    public int mChannelNum;
    public int mEncodeBitrate;
    public int mEncodeType;
    public int mSampleRate;

    public void copy(AudioEncodedConfig audioEncodedConfig) {
        this.mSampleRate = audioEncodedConfig.mSampleRate;
        this.mChannelNum = audioEncodedConfig.mChannelNum;
        this.mEncodeType = audioEncodedConfig.mEncodeType;
        this.mEncodeBitrate = audioEncodedConfig.mEncodeBitrate;
    }

    public AudioEncodedConfig clone() {
        try {
            return (AudioEncodedConfig) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String toString() {
        return "AudioEncodedConfig{mSampleRate=" + this.mSampleRate + ", mChannelNum=" + this.mChannelNum + ", mEncodeType=" + this.mEncodeType + ", mEncodeBitrate=" + this.mEncodeBitrate + '}';
    }
}
