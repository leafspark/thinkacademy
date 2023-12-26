package com.linkedin.android.litr.io;

import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.linkedin.android.litr.exception.MediaSourceException;
import com.linkedin.android.litr.utils.TranscoderUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

public class MediaExtractorMediaSource implements MediaSource {
    private final MediaExtractor mediaExtractor;
    private final MediaRange mediaRange;
    private int orientationHint;
    private long size;

    public MediaExtractorMediaSource(Context context, Uri uri) throws MediaSourceException {
        this(context, uri, new MediaRange(0, Long.MAX_VALUE));
    }

    public MediaExtractorMediaSource(Context context, Uri uri, MediaRange mediaRange2) throws MediaSourceException {
        this.mediaRange = mediaRange2;
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        this.mediaExtractor = mediaExtractor2;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaExtractor2.setDataSource(context, uri, (Map) null);
            mediaMetadataRetriever.setDataSource(context, uri);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
            if (extractMetadata != null) {
                this.orientationHint = Integer.parseInt(extractMetadata);
            }
            this.size = TranscoderUtils.getSize(context, uri);
            mediaMetadataRetriever.release();
        } catch (IOException e) {
            mediaMetadataRetriever.release();
            throw new MediaSourceException(MediaSourceException.Error.DATA_SOURCE, uri, e);
        }
    }

    public int getOrientationHint() {
        return this.orientationHint;
    }

    public int getTrackCount() {
        return this.mediaExtractor.getTrackCount();
    }

    public MediaFormat getTrackFormat(int i) {
        return this.mediaExtractor.getTrackFormat(i);
    }

    public void selectTrack(int i) {
        this.mediaExtractor.selectTrack(i);
    }

    public void seekTo(long j, int i) {
        this.mediaExtractor.seekTo(j, i);
    }

    public int getSampleTrackIndex() {
        return this.mediaExtractor.getSampleTrackIndex();
    }

    public int readSampleData(ByteBuffer byteBuffer, int i) {
        return this.mediaExtractor.readSampleData(byteBuffer, i);
    }

    public long getSampleTime() {
        return this.mediaExtractor.getSampleTime();
    }

    public int getSampleFlags() {
        return this.mediaExtractor.getSampleFlags();
    }

    public void advance() {
        this.mediaExtractor.advance();
    }

    public void release() {
        this.mediaExtractor.release();
    }

    public long getSize() {
        return this.size;
    }

    public MediaRange getSelection() {
        return this.mediaRange;
    }
}
