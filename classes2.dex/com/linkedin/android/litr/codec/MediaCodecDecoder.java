package com.linkedin.android.litr.codec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.linkedin.android.litr.exception.TrackTranscoderException;
import com.linkedin.android.litr.utils.CodecUtils;
import java.nio.ByteBuffer;

public final class MediaCodecDecoder implements Decoder {
    private boolean isReleased;
    private boolean isRunning;
    private MediaCodec mediaCodec;
    private final MediaCodec.BufferInfo outputBufferInfo = new MediaCodec.BufferInfo();

    public void init(MediaFormat mediaFormat, Surface surface) throws TrackTranscoderException {
        MediaCodec andConfigureCodec = CodecUtils.getAndConfigureCodec(mediaFormat, surface, false, TrackTranscoderException.Error.DECODER_NOT_FOUND, TrackTranscoderException.Error.DECODER_FORMAT_NOT_FOUND, TrackTranscoderException.Error.DECODER_CONFIGURATION_ERROR);
        this.mediaCodec = andConfigureCodec;
        this.isReleased = andConfigureCodec == null;
    }

    public void start() throws TrackTranscoderException {
        if (this.mediaCodec == null) {
            throw new IllegalStateException("Codec is not initialized");
        } else if (!this.isRunning) {
            try {
                startDecoder();
            } catch (Exception e) {
                throw new TrackTranscoderException(TrackTranscoderException.Error.INTERNAL_CODEC_ERROR, e);
            }
        }
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public int dequeueInputFrame(long j) {
        return this.mediaCodec.dequeueInputBuffer(j);
    }

    public Frame getInputFrame(int i) {
        ByteBuffer byteBuffer;
        if (i < 0) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            byteBuffer = this.mediaCodec.getInputBuffer(i);
        } else {
            byteBuffer = this.mediaCodec.getInputBuffers()[i];
        }
        return new Frame(i, byteBuffer, (MediaCodec.BufferInfo) null);
    }

    public void queueInputFrame(Frame frame) {
        this.mediaCodec.queueInputBuffer(frame.tag, frame.bufferInfo.offset, frame.bufferInfo.size, frame.bufferInfo.presentationTimeUs, frame.bufferInfo.flags);
    }

    public int dequeueOutputFrame(long j) {
        return this.mediaCodec.dequeueOutputBuffer(this.outputBufferInfo, j);
    }

    public Frame getOutputFrame(int i) {
        ByteBuffer byteBuffer;
        if (i < 0) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            byteBuffer = this.mediaCodec.getOutputBuffer(i);
        } else {
            byteBuffer = this.mediaCodec.getOutputBuffers()[i];
        }
        return new Frame(i, byteBuffer, this.outputBufferInfo);
    }

    public void releaseOutputFrame(int i, boolean z) {
        this.mediaCodec.releaseOutputBuffer(i, z);
    }

    public MediaFormat getOutputFormat() {
        return this.mediaCodec.getOutputFormat();
    }

    public void stop() {
        if (this.isRunning) {
            this.mediaCodec.stop();
            this.isRunning = false;
        }
    }

    public void release() {
        if (!this.isReleased) {
            this.mediaCodec.release();
            this.isReleased = true;
        }
    }

    public String getName() throws TrackTranscoderException {
        try {
            return this.mediaCodec.getName();
        } catch (IllegalStateException e) {
            throw new TrackTranscoderException(TrackTranscoderException.Error.CODEC_IN_RELEASED_STATE, e);
        }
    }

    private void startDecoder() {
        this.mediaCodec.start();
        this.isRunning = true;
    }
}
