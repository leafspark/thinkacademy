package com.linkedin.android.litr.codec;

import android.graphics.Rect;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u001eH\u0016J\u0018\u0010\"\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u000eH\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J\b\u0010%\u001a\u00020\u001eH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/linkedin/android/litr/codec/PassthroughDecoder;", "Lcom/linkedin/android/litr/codec/Decoder;", "inputBufferCapacity", "", "(I)V", "availableFrames", "", "Lcom/linkedin/android/litr/codec/Frame;", "decodeQueue", "", "decodedFrames", "", "dequeuedInputFrames", "isRunning", "", "mediaFormat", "Landroid/media/MediaFormat;", "surface", "Landroid/view/Surface;", "dequeueInputFrame", "timeout", "", "dequeueOutputFrame", "getInputFrame", "tag", "getName", "", "getOutputFormat", "getOutputFrame", "init", "", "queueInputFrame", "frame", "release", "releaseOutputFrame", "render", "start", "stop", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PassthroughDecoder.kt */
public final class PassthroughDecoder implements Decoder {
    private final Set<Frame> availableFrames = new LinkedHashSet();
    private final List<Integer> decodeQueue = new ArrayList();
    private final Map<Integer, Frame> decodedFrames = new LinkedHashMap();
    private final Map<Integer, Frame> dequeuedInputFrames = new LinkedHashMap();
    private boolean isRunning;
    private MediaFormat mediaFormat;
    private Surface surface;

    public String getName() {
        return "PassthroughDecoder";
    }

    public void release() {
    }

    public PassthroughDecoder(int i) {
        for (int i2 = 0; i2 < 2; i2++) {
            this.availableFrames.add(new Frame(i2, ByteBuffer.allocate(i), new MediaCodec.BufferInfo()));
        }
    }

    public void init(MediaFormat mediaFormat2, Surface surface2) {
        Intrinsics.checkNotNullParameter(mediaFormat2, "mediaFormat");
        this.mediaFormat = mediaFormat2;
        this.surface = surface2;
    }

    public void start() {
        this.isRunning = true;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public int dequeueInputFrame(long j) {
        Frame frame = (Frame) CollectionsKt.firstOrNull(this.availableFrames);
        if (frame == null) {
            return -1;
        }
        this.availableFrames.remove(frame);
        this.dequeuedInputFrames.put(Integer.valueOf(frame.tag), frame);
        return frame.tag;
    }

    public Frame getInputFrame(int i) {
        return this.dequeuedInputFrames.get(Integer.valueOf(i));
    }

    public void queueInputFrame(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        this.dequeuedInputFrames.remove(Integer.valueOf(frame.tag));
        this.decodeQueue.add(Integer.valueOf(frame.tag));
        this.decodedFrames.put(Integer.valueOf(frame.tag), frame);
    }

    public int dequeueOutputFrame(long j) {
        if (!this.decodeQueue.isEmpty()) {
            return this.decodeQueue.remove(0).intValue();
        }
        return -1;
    }

    public Frame getOutputFrame(int i) {
        return this.decodedFrames.get(Integer.valueOf(i));
    }

    public void releaseOutputFrame(int i, boolean z) {
        Surface surface2 = this.surface;
        if (surface2 != null && z) {
            surface2.unlockCanvasAndPost(surface2.lockCanvas((Rect) null));
        }
        Frame remove = this.decodedFrames.remove(Integer.valueOf(i));
        if (remove != null) {
            this.availableFrames.add(remove);
        }
    }

    public MediaFormat getOutputFormat() {
        MediaFormat mediaFormat2 = this.mediaFormat;
        if (mediaFormat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaFormat");
        }
        return mediaFormat2;
    }

    public void stop() {
        this.isRunning = false;
    }
}
