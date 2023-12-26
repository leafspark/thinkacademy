package com.linkedin.android.litr.analytics;

import android.media.MediaFormat;
import java.util.ArrayList;
import java.util.List;

public class TransformationStatsCollector {
    private List<TrackTransformationInfo> trackTransformationInfos = new ArrayList(2);

    public List<TrackTransformationInfo> getStats() {
        return this.trackTransformationInfos;
    }

    public void addSourceTrack(MediaFormat mediaFormat) {
        TrackTransformationInfo trackTransformationInfo = new TrackTransformationInfo();
        trackTransformationInfo.setSourceFormat(mediaFormat);
        this.trackTransformationInfos.add(trackTransformationInfo);
    }

    public void setTrackCodecs(int i, String str, String str2) {
        TrackTransformationInfo trackTransformationInfo = this.trackTransformationInfos.get(i);
        trackTransformationInfo.setDecoderCodec(str);
        trackTransformationInfo.setEncoderCodec(str2);
    }

    public void setTargetFormat(int i, MediaFormat mediaFormat) {
        this.trackTransformationInfos.get(i).setTargetFormat(mediaFormat);
    }

    public void increaseTrackProcessingDuration(int i, long j) {
        TrackTransformationInfo trackTransformationInfo = this.trackTransformationInfos.get(i);
        trackTransformationInfo.setDuration(trackTransformationInfo.getDuration() + j);
    }
}
