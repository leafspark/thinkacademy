package com.linkedin.android.litr.io;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;

public interface MediaTarget {
    int addTrack(MediaFormat mediaFormat, int i);

    String getOutputFilePath();

    void release();

    void writeSampleData(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);
}
