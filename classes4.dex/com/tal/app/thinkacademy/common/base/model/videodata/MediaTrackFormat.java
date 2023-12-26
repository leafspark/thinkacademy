package com.tal.app.thinkacademy.common.base.model.videodata;

public class MediaTrackFormat {
    public int index;
    public String mimeType;

    MediaTrackFormat(int i, String str) {
        this.index = i;
        this.mimeType = str;
    }

    MediaTrackFormat(MediaTrackFormat mediaTrackFormat) {
        this.index = mediaTrackFormat.index;
        this.mimeType = mediaTrackFormat.mimeType;
    }
}
