package com.linkedin.android.litr.transcoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import com.linkedin.android.litr.codec.Decoder;
import com.linkedin.android.litr.codec.Encoder;
import com.linkedin.android.litr.exception.TrackTranscoderException;
import com.linkedin.android.litr.io.MediaSource;
import com.linkedin.android.litr.io.MediaTarget;
import com.linkedin.android.litr.render.Renderer;
import java.nio.ByteBuffer;

public class PassthroughTranscoder extends TrackTranscoder {
    private static final int DEFAULT_BUFFER_SIZE = 1048576;
    private static final String TAG = "PassthroughTranscoder";
    int lastResult;
    ByteBuffer outputBuffer;
    MediaCodec.BufferInfo outputBufferInfo;

    public String getDecoderName() {
        return "passthrough";
    }

    public String getEncoderName() {
        return "passthrough";
    }

    PassthroughTranscoder(MediaSource mediaSource, int i, MediaTarget mediaTarget, int i2) {
        super(mediaSource, i, mediaTarget, i2, (MediaFormat) null, (Renderer) null, (Decoder) null, (Encoder) null);
    }

    public void start() throws TrackTranscoderException {
        this.mediaSource.selectTrack(this.sourceTrack);
        this.outputBufferInfo = new MediaCodec.BufferInfo();
    }

    public void stop() {
        ByteBuffer byteBuffer = this.outputBuffer;
        if (byteBuffer != null) {
            byteBuffer.clear();
            this.outputBuffer = null;
        }
    }

    public int processNextFrame() {
        int i;
        int i2 = this.lastResult;
        if (i2 == 3) {
            return i2;
        }
        if (!this.targetTrackAdded) {
            this.targetFormat = this.mediaSource.getTrackFormat(this.sourceTrack);
            if (this.duration > 0) {
                this.targetFormat.setLong("durationUs", this.duration);
            }
            this.targetTrack = this.mediaMuxer.addTrack(this.targetFormat, this.targetTrack);
            this.targetTrackAdded = true;
            this.outputBuffer = ByteBuffer.allocate(this.targetFormat.containsKey("max-input-size") ? this.targetFormat.getInteger("max-input-size") : 1048576);
            this.lastResult = 1;
            return 1;
        }
        int sampleTrackIndex = this.mediaSource.getSampleTrackIndex();
        if (sampleTrackIndex == -1 || sampleTrackIndex == this.sourceTrack) {
            this.lastResult = 2;
            int readSampleData = this.mediaSource.readSampleData(this.outputBuffer, 0);
            long sampleTime = this.mediaSource.getSampleTime();
            int sampleFlags = this.mediaSource.getSampleFlags();
            if (readSampleData < 0 || (sampleFlags & 4) != 0) {
                this.outputBuffer.clear();
                this.progress = 1.0f;
                this.lastResult = 3;
                Log.d(TAG, "Reach EoS on input stream");
            } else if (sampleTime >= this.sourceMediaSelection.getEnd()) {
                this.outputBuffer.clear();
                this.progress = 1.0f;
                this.outputBufferInfo.set(0, 0, sampleTime - this.sourceMediaSelection.getStart(), this.outputBufferInfo.flags | 4);
                this.mediaMuxer.writeSampleData(this.targetTrack, this.outputBuffer, this.outputBufferInfo);
                advanceToNextTrack();
                this.lastResult = 3;
                Log.d(TAG, "Reach selection end on input stream");
            } else {
                if (sampleTime >= this.sourceMediaSelection.getStart()) {
                    if ((sampleFlags & 1) != 0) {
                        int i3 = Build.VERSION.SDK_INT;
                        i = 1;
                    } else {
                        i = 0;
                    }
                    long start = sampleTime - this.sourceMediaSelection.getStart();
                    if (this.duration > 0) {
                        this.progress = ((float) start) / ((float) this.duration);
                    }
                    this.outputBufferInfo.set(0, readSampleData, start, i);
                    this.mediaMuxer.writeSampleData(this.targetTrack, this.outputBuffer, this.outputBufferInfo);
                }
                this.mediaSource.advance();
            }
            return this.lastResult;
        }
        this.lastResult = 2;
        return 2;
    }
}
