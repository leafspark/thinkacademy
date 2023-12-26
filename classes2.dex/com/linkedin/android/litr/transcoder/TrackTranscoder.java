package com.linkedin.android.litr.transcoder;

import android.media.MediaFormat;
import com.linkedin.android.litr.codec.Decoder;
import com.linkedin.android.litr.codec.Encoder;
import com.linkedin.android.litr.exception.TrackTranscoderException;
import com.linkedin.android.litr.io.MediaRange;
import com.linkedin.android.litr.io.MediaSource;
import com.linkedin.android.litr.io.MediaTarget;
import com.linkedin.android.litr.render.Renderer;

public abstract class TrackTranscoder {
    public static final int ERROR_TRANSCODER_NOT_RUNNING = -3;
    public static final int NO_SELECTED_TRACK = -1;
    public static final int RESULT_EOS_REACHED = 3;
    public static final int RESULT_FRAME_PROCESSED = 2;
    public static final int RESULT_OUTPUT_MEDIA_FORMAT_CHANGED = 1;
    public static final int UNDEFINED_VALUE = -1;
    protected final Decoder decoder;
    protected long duration = -1;
    protected final Encoder encoder;
    protected final MediaTarget mediaMuxer;
    protected final MediaSource mediaSource;
    protected float progress;
    protected final Renderer renderer;
    protected final MediaRange sourceMediaSelection;
    protected int sourceTrack;
    protected MediaFormat targetFormat;
    protected int targetTrack;
    protected boolean targetTrackAdded;

    public abstract int processNextFrame() throws TrackTranscoderException;

    public abstract void start() throws TrackTranscoderException;

    public abstract void stop();

    TrackTranscoder(MediaSource mediaSource2, int i, MediaTarget mediaTarget, int i2, MediaFormat mediaFormat, Renderer renderer2, Decoder decoder2, Encoder encoder2) {
        this.mediaSource = mediaSource2;
        this.sourceTrack = i;
        this.targetTrack = i2;
        this.mediaMuxer = mediaTarget;
        this.targetFormat = mediaFormat;
        this.renderer = renderer2;
        this.decoder = decoder2;
        this.encoder = encoder2;
        MediaRange selection = mediaSource2.getSelection();
        this.sourceMediaSelection = selection;
        MediaFormat trackFormat = mediaSource2.getTrackFormat(i);
        if (trackFormat.containsKey("durationUs")) {
            long j = trackFormat.getLong("durationUs");
            this.duration = j;
            if (mediaFormat != null) {
                mediaFormat.setLong("durationUs", j);
            }
        }
        if (selection.getEnd() >= selection.getStart()) {
            long min = Math.min(this.duration, selection.getEnd());
            this.duration = min;
            this.duration = min - selection.getStart();
            return;
        }
        throw new IllegalArgumentException("Range end should be greater than range start");
    }

    public int getSourceTrack() {
        return this.sourceTrack;
    }

    public int getTargetTrack() {
        return this.targetTrack;
    }

    public float getProgress() {
        return this.progress;
    }

    public String getEncoderName() throws TrackTranscoderException {
        return this.encoder.getName();
    }

    public String getDecoderName() throws TrackTranscoderException {
        return this.decoder.getName();
    }

    public MediaFormat getTargetMediaFormat() {
        return this.targetFormat;
    }

    /* access modifiers changed from: protected */
    public void advanceToNextTrack() {
        while (this.mediaSource.getSampleTrackIndex() == this.sourceTrack) {
            this.mediaSource.advance();
            if ((this.mediaSource.getSampleFlags() & 4) != 0) {
                return;
            }
        }
    }
}
