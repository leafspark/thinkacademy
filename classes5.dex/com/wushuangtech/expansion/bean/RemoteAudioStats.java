package com.wushuangtech.expansion.bean;

public class RemoteAudioStats {
    public int audioDecFps;
    public int audioLossRate;
    public int audioVolume;
    public int avDiff;
    public int decodeDur;
    public int jitter;
    public int jitterBufferDelay;
    public int numChannels;
    public int receivedBitrate;
    public int rtt;
    public int sampleRate;
    public long uid;

    public RemoteAudioStats(long j) {
        this.uid = j;
    }

    public String toString() {
        return "RemoteAudioStats{uid=" + this.uid + ", receivedBitrate=" + this.receivedBitrate + ", audioLossRate=" + this.audioLossRate + ", jitterBufferDelay=" + this.jitterBufferDelay + ", avDiff=" + this.avDiff + ", audioVolume=" + this.audioVolume + ", audioDecFps=" + this.audioDecFps + ", sampleRate=" + this.sampleRate + ", numChannels=" + this.numChannels + ", jitter=" + this.jitter + ", decodeDur=" + this.decodeDur + ", rtt=" + this.rtt + '}';
    }
}
