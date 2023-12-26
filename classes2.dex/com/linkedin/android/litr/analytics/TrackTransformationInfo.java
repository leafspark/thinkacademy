package com.linkedin.android.litr.analytics;

import android.media.MediaFormat;

public class TrackTransformationInfo {
    public static final long UNKNOWN_VALUE = -1;
    private String decoderCodec;
    private long duration = -1;
    private String encoderCodec;
    private MediaFormat sourceFormat;
    private MediaFormat targetFormat;

    public MediaFormat getSourceFormat() {
        return this.sourceFormat;
    }

    public MediaFormat getTargetFormat() {
        return this.targetFormat;
    }

    public String getDecoderCodec() {
        return this.decoderCodec;
    }

    public String getEncoderCodec() {
        return this.encoderCodec;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setSourceFormat(MediaFormat mediaFormat) {
        this.sourceFormat = mediaFormat;
    }

    public void setTargetFormat(MediaFormat mediaFormat) {
        this.targetFormat = mediaFormat;
    }

    public void setDecoderCodec(String str) {
        this.decoderCodec = str;
    }

    public void setEncoderCodec(String str) {
        this.encoderCodec = str;
    }

    public void setDuration(long j) {
        this.duration = j;
    }
}
