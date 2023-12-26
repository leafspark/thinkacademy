package com.wushuangtech.expansion.bean;

public class RemoteVideoStats {
    public int avDiff;
    public int decodeDur;
    public int decoderOutputFrameRate;
    public int delay;
    public String deviceId;
    public int height;
    public int jitter;
    public int latency;
    public int packetLossRate;
    public int receivedBitrate;
    public int rendererOutputFrameRate;
    public int rtt;
    public long uid;
    public int width;

    public RemoteVideoStats(long j) {
        this.uid = j;
    }

    public String toString() {
        return "RemoteVideoStats{uid=" + this.uid + ", deviceId='" + this.deviceId + '\'' + ", width=" + this.width + ", height=" + this.height + ", receivedBitrate=" + this.receivedBitrate + ", decoderOutputFrameRate=" + this.decoderOutputFrameRate + ", rendererOutputFrameRate=" + this.rendererOutputFrameRate + ", delay=" + this.delay + ", packetLossRate=" + this.packetLossRate + ", avDiff=" + this.avDiff + ", latency=" + this.latency + ", jitter=" + this.jitter + ", decodeDur=" + this.decodeDur + ", rtt=" + this.rtt + '}';
    }
}
