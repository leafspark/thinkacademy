package com.linkedin.android.litr.render;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import com.linkedin.android.litr.codec.Encoder;
import com.linkedin.android.litr.codec.Frame;
import com.linkedin.android.litr.filter.BufferFilter;
import com.linkedin.android.litr.utils.ByteBufferPool;
import com.linkedin.android.litr.utils.MediaFormatUtils;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001.B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J&\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\"2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010(\u001a\u00020&2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010)\u001a\u00020&H\u0016J\u001a\u0010*\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010\u00132\u0006\u0010,\u001a\u00020-H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00060\u0015R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/linkedin/android/litr/render/AudioRenderer;", "Lcom/linkedin/android/litr/render/Renderer;", "encoder", "Lcom/linkedin/android/litr/codec/Encoder;", "filters", "", "Lcom/linkedin/android/litr/filter/BufferFilter;", "(Lcom/linkedin/android/litr/codec/Encoder;Ljava/util/List;)V", "audioProcessor", "Lcom/linkedin/android/litr/render/AudioProcessor;", "audioProcessorFactory", "Lcom/linkedin/android/litr/render/AudioProcessorFactory;", "bufferPool", "Lcom/linkedin/android/litr/utils/ByteBufferPool;", "", "released", "Ljava/util/concurrent/atomic/AtomicBoolean;", "renderQueue", "Ljava/util/concurrent/LinkedBlockingDeque;", "Lcom/linkedin/android/litr/codec/Frame;", "renderThread", "Lcom/linkedin/android/litr/render/AudioRenderer$RenderThread;", "samplingRatio", "", "sourceChannelCount", "", "sourceMediaFormat", "Landroid/media/MediaFormat;", "sourceSampleRate", "targetChannelCount", "targetMediaFormat", "targetSampleDurationUs", "targetSampleRate", "getInputSurface", "Landroid/view/Surface;", "hasFilters", "", "init", "", "outputSurface", "onMediaFormatChanged", "release", "renderFrame", "inputFrame", "presentationTimeNs", "", "RenderThread", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: AudioRenderer.kt */
public final class AudioRenderer implements Renderer {
    private AudioProcessor audioProcessor;
    private final AudioProcessorFactory audioProcessorFactory;
    /* access modifiers changed from: private */
    public final ByteBufferPool bufferPool;
    /* access modifiers changed from: private */
    public final Encoder encoder;
    private final List<BufferFilter> filters;
    /* access modifiers changed from: private */
    public AtomicBoolean released;
    /* access modifiers changed from: private */
    public final LinkedBlockingDeque<Frame> renderQueue;
    private final RenderThread renderThread;
    private double samplingRatio;
    private int sourceChannelCount;
    private MediaFormat sourceMediaFormat;
    private int sourceSampleRate;
    /* access modifiers changed from: private */
    public int targetChannelCount;
    private MediaFormat targetMediaFormat;
    /* access modifiers changed from: private */
    public double targetSampleDurationUs;
    private int targetSampleRate;

    public AudioRenderer(Encoder encoder2) {
        this(encoder2, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public Surface getInputSurface() {
        return null;
    }

    public AudioRenderer(Encoder encoder2, List<BufferFilter> list) {
        Intrinsics.checkNotNullParameter(encoder2, "encoder");
        this.encoder = encoder2;
        this.filters = list == null ? CollectionsKt.emptyList() : list;
        this.sourceChannelCount = -1;
        this.targetChannelCount = -1;
        this.sourceSampleRate = -1;
        this.targetSampleRate = -1;
        this.samplingRatio = 1.0d;
        this.bufferPool = new ByteBufferPool(true);
        this.audioProcessorFactory = new AudioProcessorFactory();
        this.released = new AtomicBoolean(false);
        this.renderQueue = new LinkedBlockingDeque<>();
        this.renderThread = new RenderThread();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AudioRenderer(Encoder encoder2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(encoder2, (i & 2) != 0 ? null : list);
    }

    public void init(Surface surface, MediaFormat mediaFormat, MediaFormat mediaFormat2) {
        onMediaFormatChanged(mediaFormat, mediaFormat2);
        this.released.set(false);
        this.renderThread.start();
        for (BufferFilter init : this.filters) {
            init.init(mediaFormat2);
        }
    }

    public void onMediaFormatChanged(MediaFormat mediaFormat, MediaFormat mediaFormat2) {
        Number number;
        Number number2;
        Number number3;
        Number number4;
        if (mediaFormat == null || (number = MediaFormatUtils.Companion.getChannelCount(mediaFormat, (Number) -1)) == null) {
            number = (Number) -1;
        }
        if (mediaFormat2 == null || (number2 = MediaFormatUtils.Companion.getChannelCount(mediaFormat2, (Number) -1)) == null) {
            number2 = (Number) -1;
        }
        if (mediaFormat == null || (number3 = MediaFormatUtils.Companion.getSampleRate(mediaFormat, (Number) -1)) == null) {
            number3 = (Number) -1;
        }
        if (mediaFormat2 == null || (number4 = MediaFormatUtils.Companion.getSampleRate(mediaFormat2, (Number) -1)) == null) {
            number4 = (Number) -1;
        }
        int i = this.sourceChannelCount;
        if ((number instanceof Integer) && i == ((Integer) number).intValue()) {
            int i2 = this.targetChannelCount;
            if ((number2 instanceof Integer) && i2 == ((Integer) number2).intValue()) {
                int i3 = this.sourceSampleRate;
                if ((number3 instanceof Integer) && i3 == ((Integer) number3).intValue()) {
                    int i4 = this.targetSampleRate;
                    if ((number4 instanceof Integer) && i4 == ((Integer) number4).intValue()) {
                        return;
                    }
                }
            }
        }
        AudioProcessor audioProcessor2 = this.audioProcessor;
        if (audioProcessor2 != null) {
            audioProcessor2.release();
        }
        this.audioProcessor = this.audioProcessorFactory.createAudioProcessor(mediaFormat, mediaFormat2);
        this.sourceChannelCount = number.intValue();
        this.targetChannelCount = number2.intValue();
        this.sourceSampleRate = number3.intValue();
        this.targetSampleRate = number4.intValue();
        this.targetSampleDurationUs = 1000000.0d / number4.doubleValue();
        this.samplingRatio = number4.doubleValue() / number3.doubleValue();
        this.sourceMediaFormat = mediaFormat;
        this.targetMediaFormat = mediaFormat2;
    }

    public void renderFrame(Frame frame, long j) {
        if (!this.released.get() && frame != null) {
            Frame frame2 = new Frame(frame.tag, this.bufferPool.get(((int) Math.ceil(((double) (frame.bufferInfo.size / (this.sourceChannelCount * 2))) * this.samplingRatio)) * this.targetChannelCount * 2), new MediaCodec.BufferInfo());
            AudioProcessor audioProcessor2 = this.audioProcessor;
            if (audioProcessor2 != null) {
                audioProcessor2.processFrame(frame, frame2);
            }
            for (BufferFilter apply : this.filters) {
                apply.apply(frame2);
            }
            this.renderQueue.add(frame2);
        }
    }

    public void release() {
        this.released.set(true);
        AudioProcessor audioProcessor2 = this.audioProcessor;
        if (audioProcessor2 != null) {
            audioProcessor2.release();
        }
        this.bufferPool.clear();
    }

    public boolean hasFilters() {
        return !this.filters.isEmpty();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/linkedin/android/litr/render/AudioRenderer$RenderThread;", "Ljava/lang/Thread;", "(Lcom/linkedin/android/litr/render/AudioRenderer;)V", "renderFrame", "", "tag", "", "inputFrame", "Lcom/linkedin/android/litr/codec/Frame;", "run", "litr_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AudioRenderer.kt */
    private final class RenderThread extends Thread {
        public RenderThread() {
        }

        public void run() {
            while (!AudioRenderer.this.released.get()) {
                Frame frame = (Frame) AudioRenderer.this.renderQueue.peekFirst();
                if (frame != null) {
                    int dequeueInputFrame = AudioRenderer.this.encoder.dequeueInputFrame(0);
                    if (dequeueInputFrame >= 0) {
                        renderFrame(dequeueInputFrame, frame);
                    } else if (dequeueInputFrame != -1) {
                        Log.e("AudioRenderer", "Unhandled value " + dequeueInputFrame + " when receiving decoded input frame");
                    }
                }
            }
            AudioRenderer.this.renderQueue.clear();
        }

        private final void renderFrame(int i, Frame frame) {
            boolean z;
            Frame inputFrame = AudioRenderer.this.encoder.getInputFrame(i);
            if (inputFrame != null && inputFrame.buffer != null && frame.buffer != null) {
                inputFrame.bufferInfo.offset = 0;
                inputFrame.bufferInfo.flags = frame.bufferInfo.flags;
                inputFrame.bufferInfo.presentationTimeUs = frame.bufferInfo.presentationTimeUs + ((long) (((double) (frame.buffer.position() / (AudioRenderer.this.targetChannelCount * 2))) * AudioRenderer.this.targetSampleDurationUs));
                if (inputFrame.buffer.limit() >= frame.buffer.remaining()) {
                    inputFrame.bufferInfo.size = frame.buffer.remaining();
                    z = true;
                } else {
                    inputFrame.bufferInfo.size = inputFrame.buffer.limit();
                    inputFrame.bufferInfo.flags &= -5;
                    z = false;
                }
                int i2 = inputFrame.bufferInfo.size;
                for (int i3 = 0; i3 < i2; i3++) {
                    inputFrame.buffer.put(frame.buffer.get());
                }
                if (z) {
                    AudioRenderer.this.renderQueue.removeFirst();
                    AudioRenderer.this.bufferPool.put(frame.buffer);
                }
                AudioRenderer.this.encoder.queueInputFrame(inputFrame);
            }
        }
    }
}
