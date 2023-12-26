package com.linkedin.android.litr.render;

import android.media.MediaFormat;
import android.view.Surface;
import com.linkedin.android.litr.codec.Frame;

public interface Renderer {
    Surface getInputSurface();

    boolean hasFilters();

    void init(Surface surface, MediaFormat mediaFormat, MediaFormat mediaFormat2);

    void onMediaFormatChanged(MediaFormat mediaFormat, MediaFormat mediaFormat2);

    void release();

    void renderFrame(Frame frame, long j);
}
