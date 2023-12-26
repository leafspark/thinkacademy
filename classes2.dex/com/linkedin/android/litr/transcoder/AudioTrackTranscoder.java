package com.linkedin.android.litr.transcoder;

import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import com.linkedin.android.litr.codec.Decoder;
import com.linkedin.android.litr.codec.Encoder;
import com.linkedin.android.litr.codec.Frame;
import com.linkedin.android.litr.exception.TrackTranscoderException;
import com.linkedin.android.litr.io.MediaSource;
import com.linkedin.android.litr.io.MediaTarget;
import com.linkedin.android.litr.render.Renderer;
import java.util.concurrent.TimeUnit;

public class AudioTrackTranscoder extends TrackTranscoder {
    private static final String TAG = "AudioTrackTranscoder";
    int lastDecodeFrameResult = 2;
    int lastEncodeFrameResult = 2;
    int lastExtractFrameResult = 2;
    private MediaFormat sourceAudioFormat;

    AudioTrackTranscoder(MediaSource mediaSource, int i, MediaTarget mediaTarget, int i2, MediaFormat mediaFormat, Renderer renderer, Decoder decoder, Encoder encoder) throws TrackTranscoderException {
        super(mediaSource, i, mediaTarget, i2, mediaFormat, renderer, decoder, encoder);
        initCodecs();
    }

    private void initCodecs() throws TrackTranscoderException {
        this.sourceAudioFormat = this.mediaSource.getTrackFormat(this.sourceTrack);
        this.encoder.init(this.targetFormat);
        this.renderer.init((Surface) null, this.sourceAudioFormat, this.targetFormat);
        this.decoder.init(this.sourceAudioFormat, (Surface) null);
    }

    public void start() throws TrackTranscoderException {
        this.mediaSource.selectTrack(this.sourceTrack);
        this.encoder.start();
        this.decoder.start();
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
            this.lastDecodeFrameResult = queueDecodedInputFrame();
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

    public void stop() {
        this.renderer.release();
        this.encoder.stop();
        this.encoder.release();
        this.decoder.stop();
        this.decoder.release();
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
                    Log.d(TAG, "Selection end reached on the input stream");
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

    private int queueDecodedInputFrame() throws TrackTranscoderException {
        int dequeueOutputFrame = this.decoder.dequeueOutputFrame(0);
        if (dequeueOutputFrame >= 0) {
            Frame outputFrame = this.decoder.getOutputFrame(dequeueOutputFrame);
            if (outputFrame != null) {
                if (outputFrame.bufferInfo.presentationTimeUs >= this.sourceMediaSelection.getStart() || (outputFrame.bufferInfo.flags & 4) != 0) {
                    this.renderer.renderFrame(outputFrame, TimeUnit.MICROSECONDS.toNanos(outputFrame.bufferInfo.presentationTimeUs - this.sourceMediaSelection.getStart()));
                }
                this.decoder.releaseOutputFrame(dequeueOutputFrame, false);
                if ((outputFrame.bufferInfo.flags & 4) == 0) {
                    return 2;
                }
                Log.d(TAG, "EoS on decoder output stream");
                return 3;
            }
            throw new TrackTranscoderException(TrackTranscoderException.Error.NO_FRAME_AVAILABLE);
        } else if (dequeueOutputFrame == -2) {
            this.sourceAudioFormat = this.decoder.getOutputFormat();
            this.renderer.onMediaFormatChanged(this.sourceAudioFormat, this.targetFormat);
            String str = TAG;
            Log.d(str, "Decoder output format changed: " + this.sourceAudioFormat);
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
                this.targetTrack = this.mediaMuxer.addTrack(outputFormat, this.targetTrack);
                this.targetTrackAdded = true;
                this.renderer.onMediaFormatChanged(this.sourceAudioFormat, this.targetFormat);
            }
            Log.d(TAG, "Encoder output format received " + outputFormat);
            return 1;
        }
    }
}
