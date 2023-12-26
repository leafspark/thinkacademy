package com.linkedin.android.litr.transcoder;

import android.media.MediaFormat;
import android.util.Log;
import com.linkedin.android.litr.codec.Decoder;
import com.linkedin.android.litr.codec.Encoder;
import com.linkedin.android.litr.codec.Frame;
import com.linkedin.android.litr.exception.TrackTranscoderException;
import com.linkedin.android.litr.io.MediaSource;
import com.linkedin.android.litr.io.MediaTarget;
import com.linkedin.android.litr.render.GlVideoRenderer;
import com.linkedin.android.litr.render.Renderer;
import com.linkedin.android.litr.utils.MediaFormatUtils;
import java.util.concurrent.TimeUnit;

public class VideoTrackTranscoder extends TrackTranscoder {
    private static final String TAG = "VideoTrackTranscoder";
    int lastDecodeFrameResult = 2;
    int lastEncodeFrameResult = 2;
    int lastExtractFrameResult = 2;
    GlVideoRenderer renderer;
    private MediaFormat sourceVideoFormat;
    private MediaFormat targetVideoFormat;

    VideoTrackTranscoder(MediaSource mediaSource, int i, MediaTarget mediaTarget, int i2, MediaFormat mediaFormat, Renderer renderer2, Decoder decoder, Encoder encoder) throws TrackTranscoderException {
        super(mediaSource, i, mediaTarget, i2, mediaFormat, renderer2, decoder, encoder);
        this.targetVideoFormat = mediaFormat;
        if (renderer2 instanceof GlVideoRenderer) {
            this.renderer = (GlVideoRenderer) renderer2;
            initCodecs();
            return;
        }
        throw new IllegalArgumentException("Cannot use non-OpenGL video renderer in " + TAG);
    }

    private void initCodecs() throws TrackTranscoderException {
        MediaFormat trackFormat = this.mediaSource.getTrackFormat(this.sourceTrack);
        this.sourceVideoFormat = trackFormat;
        Number number = MediaFormatUtils.getNumber(trackFormat, "frame-rate");
        if (number != null) {
            this.targetVideoFormat.setInteger("frame-rate", number.intValue());
        }
        this.encoder.init(this.targetFormat);
        this.renderer.init(this.encoder.createInputSurface(), this.sourceVideoFormat, this.targetVideoFormat);
        this.decoder.init(this.sourceVideoFormat, this.renderer.getInputSurface());
    }

    public void start() throws TrackTranscoderException {
        this.mediaSource.selectTrack(this.sourceTrack);
        this.encoder.start();
        this.decoder.start();
    }

    public void stop() {
        this.encoder.stop();
        this.encoder.release();
        this.decoder.stop();
        this.decoder.release();
        this.renderer.release();
    }

    public int processNextFrame() throws TrackTranscoderException {
        if (!this.encoder.isRunning() || !this.decoder.isRunning()) {
            return -3;
        }
        int i = 2;
        if (this.lastExtractFrameResult != 3) {
            this.lastExtractFrameResult = extractAndEnqueueInputFrame();
        }
        if (this.lastDecodeFrameResult != 3) {
            this.lastDecodeFrameResult = resizeDecodedInputFrame();
        }
        if (this.lastEncodeFrameResult != 3) {
            this.lastEncodeFrameResult = writeEncodedOutputFrame();
        }
        int i2 = this.lastEncodeFrameResult;
        if (i2 == 1) {
            i = 1;
        }
        if (this.lastExtractFrameResult == 3 && this.lastDecodeFrameResult == 3 && i2 == 3) {
            return 3;
        }
        return i;
    }

    private int extractAndEnqueueInputFrame() throws TrackTranscoderException {
        int sampleTrackIndex = this.mediaSource.getSampleTrackIndex();
        if (sampleTrackIndex != this.sourceTrack && sampleTrackIndex != -1) {
            return 2;
        }
        int dequeueInputFrame = this.decoder.dequeueInputFrame(0);
        if (dequeueInputFrame >= 0) {
            Frame inputFrame = this.decoder.getInputFrame(dequeueInputFrame);
            if (inputFrame != null) {
                int readSampleData = this.mediaSource.readSampleData(inputFrame.buffer, 0);
                long sampleTime = this.mediaSource.getSampleTime();
                int sampleFlags = this.mediaSource.getSampleFlags();
                if (readSampleData < 0 || (sampleFlags & 4) != 0) {
                    inputFrame.bufferInfo.set(0, 0, -1, 4);
                    this.decoder.queueInputFrame(inputFrame);
                    Log.d(TAG, "EoS reached on the input stream");
                } else if (sampleTime >= this.sourceMediaSelection.getEnd()) {
                    inputFrame.bufferInfo.set(0, 0, -1, 4);
                    this.decoder.queueInputFrame(inputFrame);
                    advanceToNextTrack();
                    Log.d(TAG, "EoS reached on the input stream");
                } else {
                    inputFrame.bufferInfo.set(0, readSampleData, sampleTime, sampleFlags);
                    this.decoder.queueInputFrame(inputFrame);
                    this.mediaSource.advance();
                    return 2;
                }
                return 3;
            }
            throw new TrackTranscoderException(TrackTranscoderException.Error.NO_FRAME_AVAILABLE);
        } else if (dequeueInputFrame == -1) {
            return 2;
        } else {
            String str = TAG;
            Log.e(str, "Unhandled value " + dequeueInputFrame + " when decoding an input frame");
            return 2;
        }
    }

    private int resizeDecodedInputFrame() throws TrackTranscoderException {
        int dequeueOutputFrame = this.decoder.dequeueOutputFrame(0);
        if (dequeueOutputFrame >= 0) {
            Frame outputFrame = this.decoder.getOutputFrame(dequeueOutputFrame);
            if (outputFrame != null) {
                boolean z = false;
                if ((outputFrame.bufferInfo.flags & 4) != 0) {
                    Log.d(TAG, "EoS on decoder output stream");
                    this.decoder.releaseOutputFrame(dequeueOutputFrame, false);
                    this.encoder.signalEndOfInputStream();
                    return 3;
                }
                if (outputFrame.bufferInfo.presentationTimeUs >= this.sourceMediaSelection.getStart()) {
                    z = true;
                }
                this.decoder.releaseOutputFrame(dequeueOutputFrame, z);
                if (!z) {
                    return 2;
                }
                this.renderer.renderFrame((Frame) null, TimeUnit.MICROSECONDS.toNanos(outputFrame.bufferInfo.presentationTimeUs - this.sourceMediaSelection.getStart()));
                return 2;
            }
            throw new TrackTranscoderException(TrackTranscoderException.Error.NO_FRAME_AVAILABLE);
        } else if (dequeueOutputFrame == -2) {
            MediaFormat outputFormat = this.decoder.getOutputFormat();
            this.sourceVideoFormat = outputFormat;
            this.renderer.onMediaFormatChanged(outputFormat, this.targetVideoFormat);
            String str = TAG;
            Log.d(str, "Decoder output format changed: " + this.sourceVideoFormat);
            return 2;
        } else if (dequeueOutputFrame == -1) {
            return 2;
        } else {
            String str2 = TAG;
            Log.e(str2, "Unhandled value " + dequeueOutputFrame + " when receiving decoded input frame");
            return 2;
        }
    }

    private int writeEncodedOutputFrame() throws TrackTranscoderException {
        int i;
        int dequeueOutputFrame = this.encoder.dequeueOutputFrame(0);
        if (dequeueOutputFrame >= 0) {
            Frame outputFrame = this.encoder.getOutputFrame(dequeueOutputFrame);
            if (outputFrame != null) {
                if ((outputFrame.bufferInfo.flags & 4) != 0) {
                    Log.d(TAG, "Encoder produced EoS, we are done");
                    this.progress = 1.0f;
                    i = 3;
                } else {
                    if (outputFrame.bufferInfo.size > 0 && (outputFrame.bufferInfo.flags & 2) == 0) {
                        this.mediaMuxer.writeSampleData(this.targetTrack, outputFrame.buffer, outputFrame.bufferInfo);
                        if (this.duration > 0) {
                            this.progress = ((float) outputFrame.bufferInfo.presentationTimeUs) / ((float) this.duration);
                        }
                    }
                    i = 2;
                }
                this.encoder.releaseOutputFrame(dequeueOutputFrame);
                return i;
            }
            throw new TrackTranscoderException(TrackTranscoderException.Error.NO_FRAME_AVAILABLE);
        } else if (dequeueOutputFrame != -2) {
            if (dequeueOutputFrame != -1) {
                Log.e(TAG, "Unhandled value " + dequeueOutputFrame + " when receiving encoded output frame");
            }
            return 2;
        } else {
            MediaFormat outputFormat = this.encoder.getOutputFormat();
            if (!this.targetTrackAdded) {
                this.targetFormat = outputFormat;
                this.targetVideoFormat = outputFormat;
                this.targetTrack = this.mediaMuxer.addTrack(outputFormat, this.targetTrack);
                this.targetTrackAdded = true;
                this.renderer.onMediaFormatChanged(this.sourceVideoFormat, this.targetVideoFormat);
            }
            Log.d(TAG, "Encoder output format received " + outputFormat);
            return 1;
        }
    }
}
