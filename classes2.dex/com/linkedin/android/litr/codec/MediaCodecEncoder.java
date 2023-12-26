package com.linkedin.android.litr.codec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.linkedin.android.litr.exception.TrackTranscoderException;
import com.linkedin.android.litr.utils.CodecUtils;
import java.nio.ByteBuffer;

public class MediaCodecEncoder implements Encoder {
    private final MediaCodec.BufferInfo encoderOutputBufferInfo = new MediaCodec.BufferInfo();
    private boolean isReleased = true;
    private boolean isRunning;
    private MediaCodec mediaCodec;

    public void init(MediaFormat mediaFormat) throws TrackTranscoderException {
        if (!mediaFormat.containsKey("color-format")) {
            mediaFormat.setInteger("color-format", 2130708361);
        }
        MediaCodec andConfigureCodec = CodecUtils.getAndConfigureCodec(mediaFormat, (Surface) null, true, TrackTranscoderException.Error.ENCODER_NOT_FOUND, TrackTranscoderException.Error.ENCODER_FORMAT_NOT_FOUND, TrackTranscoderException.Error.ENCODER_CONFIGURATION_ERROR);
        this.mediaCodec = andConfigureCodec;
        this.isReleased = andConfigureCodec == null;
    }

    public Surface createInputSurface() {
        return this.mediaCodec.createInputSurface();
    }

    public void start() throws TrackTranscoderException {
        try {
            startEncoder();
        } catch (Exception e) {
            throw new TrackTranscoderException(TrackTranscoderException.Error.INTERNAL_CODEC_ERROR, e);
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

    public void signalEndOfInputStream() {
        this.mediaCodec.signalEndOfInputStream();
    }

    public int dequeueOutputFrame(long j) {
        return this.mediaCodec.dequeueOutputBuffer(this.encoderOutputBufferInfo, j);
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
        return new Frame(i, byteBuffer, this.encoderOutputBufferInfo);
    }

    public void releaseOutputFrame(int i) {
        this.mediaCodec.releaseOutputBuffer(i, false);
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

    private void startEncoder() {
        if (!this.isRunning) {
            this.mediaCodec.start();
            this.isRunning = true;
        }
    }
}
