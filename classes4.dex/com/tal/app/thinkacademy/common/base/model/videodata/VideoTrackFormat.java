package com.tal.app.thinkacademy.common.base.model.videodata;

public class VideoTrackFormat extends MediaTrackFormat {
    public int bitrate;
    public long duration;
    public int frameRate;
    public int height;
    public int keyFrameInterval;
    public int rotation;
    public int width;

    public VideoTrackFormat(int i, String str) {
        super(i, str);
    }

    public VideoTrackFormat(VideoTrackFormat videoTrackFormat) {
        super(videoTrackFormat);
        this.width = videoTrackFormat.width;
        this.height = videoTrackFormat.height;
        this.bitrate = videoTrackFormat.bitrate;
        this.frameRate = videoTrackFormat.frameRate;
        this.keyFrameInterval = videoTrackFormat.keyFrameInterval;
        this.duration = videoTrackFormat.duration;
        this.rotation = videoTrackFormat.rotation;
    }
}
