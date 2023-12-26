package com.linkedin.android.litr;

import android.media.MediaFormat;
import com.linkedin.android.litr.codec.Decoder;
import com.linkedin.android.litr.codec.Encoder;
import com.linkedin.android.litr.io.MediaSource;
import com.linkedin.android.litr.io.MediaTarget;
import com.linkedin.android.litr.render.Renderer;

public class TrackTransform {
    private final Decoder decoder;
    private final Encoder encoder;
    private final MediaSource mediaSource;
    private final MediaTarget mediaTarget;
    private final Renderer renderer;
    private final int sourceTrack;
    private final MediaFormat targetFormat;
    private final int targetTrack;

    private TrackTransform(MediaSource mediaSource2, Decoder decoder2, Renderer renderer2, Encoder encoder2, MediaTarget mediaTarget2, MediaFormat mediaFormat, int i, int i2) {
        this.mediaSource = mediaSource2;
        this.decoder = decoder2;
        this.renderer = renderer2;
        this.encoder = encoder2;
        this.mediaTarget = mediaTarget2;
        this.targetFormat = mediaFormat;
        this.sourceTrack = i;
        this.targetTrack = i2;
    }

    public MediaSource getMediaSource() {
        return this.mediaSource;
    }

    public Decoder getDecoder() {
        return this.decoder;
    }

    public Renderer getRenderer() {
        return this.renderer;
    }

    public Encoder getEncoder() {
        return this.encoder;
    }

    public MediaTarget getMediaTarget() {
        return this.mediaTarget;
    }

    public MediaFormat getTargetFormat() {
        return this.targetFormat;
    }

    public int getSourceTrack() {
        return this.sourceTrack;
    }

    public int getTargetTrack() {
        return this.targetTrack;
    }

    public static class Builder {
        private Decoder decoder;
        private Encoder encoder;
        private final MediaSource mediaSource;
        private final MediaTarget mediaTarget;
        private Renderer renderer;
        private final int sourceTrack;
        private MediaFormat targetFormat;
        private int targetTrack;

        public Builder(MediaSource mediaSource2, int i, MediaTarget mediaTarget2) {
            this.mediaSource = mediaSource2;
            this.sourceTrack = i;
            this.mediaTarget = mediaTarget2;
            this.targetTrack = i;
        }

        public Builder setDecoder(Decoder decoder2) {
            this.decoder = decoder2;
            return this;
        }

        public Builder setRenderer(Renderer renderer2) {
            this.renderer = renderer2;
            return this;
        }

        public Builder setEncoder(Encoder encoder2) {
            this.encoder = encoder2;
            return this;
        }

        public Builder setTargetFormat(MediaFormat mediaFormat) {
            this.targetFormat = mediaFormat;
            return this;
        }

        public Builder setTargetTrack(int i) {
            this.targetTrack = i;
            return this;
        }

        public TrackTransform build() {
            return new TrackTransform(this.mediaSource, this.decoder, this.renderer, this.encoder, this.mediaTarget, this.targetFormat, this.sourceTrack, this.targetTrack);
        }
    }
}
