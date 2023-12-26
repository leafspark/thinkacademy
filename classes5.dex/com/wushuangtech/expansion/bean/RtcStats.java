package com.wushuangtech.expansion.bean;

public class RtcStats implements Cloneable {
    public double cpuAppUsage;
    public double cpuTotalUsage;
    public int gatewayRtt;
    public int lastmileDelay;
    private String mChannelName;
    public int memoryAppUsageInKbytes;
    public double memoryAppUsageRatio;
    public double memoryTotalUsageRatio;
    public int rxAudioBytes;
    public int rxAudioKBitRate;
    public int rxBytes;
    public int rxKBitRate;
    public int rxPacketLossRate;
    public int rxVideoBytes;
    public int rxVideoKBitRate;
    public int totalDuration;
    public int txAudioBytes;
    public int txAudioKBitRate;
    public int txBytes;
    public int txKBitRate;
    public int txPacketLossRate;
    public int txVideoBytes;
    public int txVideoKBitRate;
    public int users;

    public void reset() {
        this.txBytes = 0;
        this.txAudioBytes = 0;
        this.txVideoBytes = 0;
        this.txKBitRate = 0;
        this.txAudioKBitRate = 0;
        this.txVideoKBitRate = 0;
        this.rxBytes = 0;
        this.rxAudioBytes = 0;
        this.rxVideoBytes = 0;
        this.rxKBitRate = 0;
        this.rxAudioKBitRate = 0;
        this.rxVideoKBitRate = 0;
    }

    public String getChannelName() {
        return this.mChannelName;
    }

    public void setChannelName(String str) {
        this.mChannelName = str;
    }

    public RtcStats clone() {
        try {
            return (RtcStats) super.clone();
        } catch (Exception unused) {
            return null;
        }
    }

    public String toString() {
        return "RtcStats{totalDuration=" + this.totalDuration + ", txBytes=" + this.txBytes + ", rxBytes=" + this.rxBytes + ", txAudioBytes=" + this.txAudioBytes + ", txVideoBytes=" + this.txVideoBytes + ", rxAudioBytes=" + this.rxAudioBytes + ", rxVideoBytes=" + this.rxVideoBytes + ", txKBitRate=" + this.txKBitRate + ", rxKBitRate=" + this.rxKBitRate + ", txAudioKBitRate=" + this.txAudioKBitRate + ", rxAudioKBitRate=" + this.rxAudioKBitRate + ", txVideoKBitRate=" + this.txVideoKBitRate + ", rxVideoKBitRate=" + this.rxVideoKBitRate + ", cpuAppUsage=" + this.cpuAppUsage + ", cpuTotalUsage=" + this.cpuTotalUsage + ", txPacketLossRate=" + this.txPacketLossRate + ", rxPacketLossRate=" + this.rxPacketLossRate + ", users=" + this.users + ", lastmileDelay=" + this.lastmileDelay + ", gatewayRtt=" + this.gatewayRtt + ", memoryAppUsageRatio=" + this.memoryAppUsageRatio + ", memoryTotalUsageRatio=" + this.memoryTotalUsageRatio + ", memoryAppUsageInKbytes=" + this.memoryAppUsageInKbytes + '}';
    }
}
