package com.linkedin.android.litr.render;

import android.media.MediaCodec;
import com.linkedin.android.litr.codec.Frame;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/linkedin/android/litr/render/PassthroughAudioProcessor;", "Lcom/linkedin/android/litr/render/AudioProcessor;", "()V", "processFrame", "", "sourceFrame", "Lcom/linkedin/android/litr/codec/Frame;", "targetFrame", "release", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PassthroughAudioProcessor.kt */
public final class PassthroughAudioProcessor implements AudioProcessor {
    public void release() {
    }

    public void processFrame(Frame frame, Frame frame2) {
        Intrinsics.checkNotNullParameter(frame, "sourceFrame");
        Intrinsics.checkNotNullParameter(frame2, "targetFrame");
        if (frame.buffer == null || frame2.buffer == null) {
            throw new IllegalArgumentException("Source or target frame doesn't have a buffer, cannot process it!");
        }
        frame2.buffer.put(frame.buffer);
        frame2.buffer.flip();
        MediaCodec.BufferInfo bufferInfo = frame2.bufferInfo;
        bufferInfo.offset = 0;
        bufferInfo.size = frame.bufferInfo.size;
        bufferInfo.presentationTimeUs = frame.bufferInfo.presentationTimeUs;
        bufferInfo.flags = frame.bufferInfo.flags;
    }
}
