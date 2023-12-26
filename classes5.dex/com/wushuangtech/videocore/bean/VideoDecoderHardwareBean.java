package com.wushuangtech.videocore.bean;

public class VideoDecoderHardwareBean implements Comparable<VideoDecoderHardwareBean> {
    public long createTime;
    public String deviceId;
    public String mediaCodecAddress;
    public String videoDecoderAddress;

    public String toString() {
        return "VideoDecoderHardwareBean{videoDecoderAddress='" + this.videoDecoderAddress + '\'' + ", mediaCodecAddress='" + this.mediaCodecAddress + '\'' + ", deviceId='" + this.deviceId + '\'' + ", createTime=" + this.createTime + '}';
    }

    public int compareTo(VideoDecoderHardwareBean videoDecoderHardwareBean) {
        return this.createTime > videoDecoderHardwareBean.createTime ? 1 : -1;
    }
}
