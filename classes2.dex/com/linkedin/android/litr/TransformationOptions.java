package com.linkedin.android.litr;

import com.linkedin.android.litr.filter.BufferFilter;
import com.linkedin.android.litr.filter.GlFilter;
import com.linkedin.android.litr.io.MediaRange;
import java.util.List;

public class TransformationOptions {
    public final List<BufferFilter> audioFilters;
    public final int granularity;
    public final MediaRange sourceMediaRange;
    public final List<GlFilter> videoFilters;

    private TransformationOptions(int i, List<GlFilter> list, List<BufferFilter> list2, MediaRange mediaRange) {
        this.granularity = i;
        this.videoFilters = list;
        this.audioFilters = list2;
        this.sourceMediaRange = mediaRange == null ? new MediaRange(0, Long.MAX_VALUE) : mediaRange;
    }

    public static class Builder {
        private List<BufferFilter> audioFilters;
        private int granularity = 100;
        private MediaRange sourceMediaRange;
        private List<GlFilter> videoFilters;

        public Builder setGranularity(int i) {
            this.granularity = i;
            return this;
        }

        public Builder setVideoFilters(List<GlFilter> list) {
            this.videoFilters = list;
            return this;
        }

        public Builder setAudioFilters(List<BufferFilter> list) {
            this.audioFilters = list;
            return this;
        }

        public Builder setSourceMediaRange(MediaRange mediaRange) {
            this.sourceMediaRange = mediaRange;
            return this;
        }

        public TransformationOptions build() {
            return new TransformationOptions(this.granularity, this.videoFilters, this.audioFilters, this.sourceMediaRange);
        }
    }
}
