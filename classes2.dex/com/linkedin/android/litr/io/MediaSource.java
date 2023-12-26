package com.linkedin.android.litr.io;

import android.media.MediaFormat;
import java.nio.ByteBuffer;

public interface MediaSource {
    void advance();

    int getOrientationHint();

    int getSampleFlags();

    long getSampleTime();

    int getSampleTrackIndex();

    MediaRange getSelection();

    long getSize();

    int getTrackCount();

    MediaFormat getTrackFormat(int i);

    int readSampleData(ByteBuffer byteBuffer, int i);

    void release();

    void seekTo(long j, int i);

    void selectTrack(int i);

    /* renamed from: com.linkedin.android.litr.io.MediaSource$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static MediaRange $default$getSelection(MediaSource _this) {
            return new MediaRange(0, Long.MAX_VALUE);
        }
    }
}
