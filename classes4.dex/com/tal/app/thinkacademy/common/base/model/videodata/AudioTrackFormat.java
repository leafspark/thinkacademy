package com.tal.app.thinkacademy.common.base.model.videodata;

public class AudioTrackFormat extends MediaTrackFormat {
    public int bitrate;
    public int channelCount;
    public long duration;
    public int samplingRate;

    public AudioTrackFormat(int i, String str) {
        super(i, str);
    }

    public AudioTrackFormat(AudioTrackFormat audioTrackFormat) {
        super(audioTrackFormat);
        this.channelCount = audioTrackFormat.channelCount;
        this.samplingRate = audioTrackFormat.samplingRate;
        this.bitrate = audioTrackFormat.bitrate;
        this.duration = audioTrackFormat.duration;
    }
}
