package com.wushuangtech.expansion.bean;

public class LocalAudioStats implements Cloneable {
    public int audioDelay;
    public int audioEncodeFps;
    public int numChannels;
    public int rtt;
    public int sentBitrate;
    public int sentSampleRate;
    public int txPacketLossRate;
    public int volume;

    public LocalAudioStats clone() {
        try {
            return (LocalAudioStats) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return "LocalAudioStats{sentBitrate=" + this.sentBitrate + ", txPacketLossRate=" + this.txPacketLossRate + ", audioDelay=" + this.audioDelay + ", rtt=" + this.rtt + ", audioEncodeFps=" + this.audioEncodeFps + ", sentSampleRate=" + this.sentSampleRate + ", numChannels=" + this.numChannels + ", volume=" + this.volume + '}';
    }
}
