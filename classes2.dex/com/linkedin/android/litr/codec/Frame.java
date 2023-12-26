package com.linkedin.android.litr.codec;

import android.media.MediaCodec;
import java.nio.ByteBuffer;

public class Frame {
    public final ByteBuffer buffer;
    public final MediaCodec.BufferInfo bufferInfo;
    public final int tag;

    public Frame(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo2) {
        this.tag = i;
        this.buffer = byteBuffer;
        if (bufferInfo2 == null) {
            this.bufferInfo = new MediaCodec.BufferInfo();
        } else {
            this.bufferInfo = bufferInfo2;
        }
    }
}
