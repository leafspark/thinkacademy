package com.linkedin.android.litr.codec;

import android.media.MediaFormat;
import android.view.Surface;
import com.linkedin.android.litr.exception.TrackTranscoderException;

public interface Decoder {
    int dequeueInputFrame(long j);

    int dequeueOutputFrame(long j);

    Frame getInputFrame(int i);

    String getName() throws TrackTranscoderException;

    MediaFormat getOutputFormat();

    Frame getOutputFrame(int i);

    void init(MediaFormat mediaFormat, Surface surface) throws TrackTranscoderException;

    boolean isRunning();

    void queueInputFrame(Frame frame);

    void release();

    void releaseOutputFrame(int i, boolean z);

    void start() throws TrackTranscoderException;

    void stop();
}
