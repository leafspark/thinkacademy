package com.linkedin.android.litr.render;

import com.linkedin.android.litr.codec.Frame;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J)\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H J!\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0011H J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\t\u0010\u0019\u001a\u00020\u000eH R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/linkedin/android/litr/render/OboeAudioProcessor;", "Lcom/linkedin/android/litr/render/AudioProcessor;", "sourceChannelCount", "", "sourceSampleRate", "targetChannelCount", "targetSampleRate", "(IIII)V", "presentationTimeNs", "", "sampleDurationUs", "", "samplingRatio", "initProcessor", "", "processAudioFrame", "sourceBuffer", "Ljava/nio/ByteBuffer;", "sampleCount", "targetBuffer", "processFrame", "sourceFrame", "Lcom/linkedin/android/litr/codec/Frame;", "targetFrame", "release", "releaseProcessor", "Companion", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: OboeAudioProcessor.kt */
public final class OboeAudioProcessor implements AudioProcessor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private long presentationTimeNs = 0;
    private double sampleDurationUs;
    private final double samplingRatio;
    private final int sourceChannelCount;
    private final int targetChannelCount;

    private final native void initProcessor(int i, int i2, int i3, int i4);

    private final native int processAudioFrame(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2);

    private final native void releaseProcessor();

    public OboeAudioProcessor(int i, int i2, int i3, int i4) {
        this.sourceChannelCount = i;
        this.targetChannelCount = i3;
        initProcessor(i, i2, i3, i4);
        double d = (double) i4;
        this.samplingRatio = d / ((double) i2);
        this.sampleDurationUs = 1000000.0d / d;
    }

    public void processFrame(Frame frame, Frame frame2) {
        Intrinsics.checkNotNullParameter(frame, "sourceFrame");
        Intrinsics.checkNotNullParameter(frame2, "targetFrame");
        if (frame.buffer == null || frame2.buffer == null) {
            throw new IllegalArgumentException("Source or target frame doesn't have a buffer, cannot process it!");
        }
        int processAudioFrame = processAudioFrame(frame.buffer, frame.bufferInfo.size / (this.sourceChannelCount * 2), frame2.buffer);
        int i = processAudioFrame * 2 * this.targetChannelCount;
        frame2.buffer.rewind();
        frame2.buffer.limit(i);
        frame2.bufferInfo.set(0, i, this.presentationTimeNs, frame.bufferInfo.flags);
        this.presentationTimeNs += (long) (((double) processAudioFrame) * this.sampleDurationUs);
    }

    public void release() {
        releaseProcessor();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/linkedin/android/litr/render/OboeAudioProcessor$Companion;", "", "()V", "litr_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: OboeAudioProcessor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        System.loadLibrary("litr-jni");
    }
}
