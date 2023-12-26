package com.wushuangtech.expansion.bean;

public class LocalVideoStats implements Cloneable {
    public int delay;
    public int encodedFrameHeight;
    public int encodedFrameWidth;
    public int rtt;
    public int sentBitrate;
    public int sentFrameRate;
    public int txPacketLossRate;
    public int videoBuffer;
    public int videoTargetBps;
    public int videoTargetFps;

    public String toString() {
        return "LocalVideoStats{encodedFrameWidth=" + this.encodedFrameWidth + ", encodedFrameHeight=" + this.encodedFrameHeight + ", sentBitrate=" + this.sentBitrate + ", sentFrameRate=" + this.sentFrameRate + ", videoTargetFps=" + this.videoTargetFps + ", videoTargetBps=" + this.videoTargetBps + ", txPacketLossRate=" + this.txPacketLossRate + ", videoBuffer=" + this.videoBuffer + ", delay=" + this.delay + ", rtt=" + this.rtt + '}';
    }

    public LocalVideoStats clone() {
        try {
            return (LocalVideoStats) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
