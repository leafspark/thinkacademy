package com.linkedin.android.litr.codec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u001eH\u0016J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J\b\u0010%\u001a\u00020\u001eH\u0016J\b\u0010&\u001a\u00020\u001eH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/linkedin/android/litr/codec/PassthroughBufferEncoder;", "Lcom/linkedin/android/litr/codec/Encoder;", "inputBufferCapacity", "", "(I)V", "availableFrames", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/linkedin/android/litr/codec/Frame;", "dequeuedInputFrames", "Ljava/util/concurrent/ConcurrentHashMap;", "encodeQueue", "encodedFrames", "isRunning", "", "mediaFormat", "Landroid/media/MediaFormat;", "mediaFormatChanged", "createInputSurface", "Landroid/view/Surface;", "dequeueInputFrame", "timeout", "", "dequeueOutputFrame", "getInputFrame", "tag", "getName", "", "getOutputFormat", "getOutputFrame", "init", "", "targetFormat", "queueInputFrame", "frame", "release", "releaseOutputFrame", "signalEndOfInputStream", "start", "stop", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PassthroughBufferEncoder.kt */
public final class PassthroughBufferEncoder implements Encoder {
    private final LinkedBlockingQueue<Frame> availableFrames = new LinkedBlockingQueue<>();
    private final ConcurrentHashMap<Integer, Frame> dequeuedInputFrames = new ConcurrentHashMap<>();
    private final LinkedBlockingQueue<Integer> encodeQueue = new LinkedBlockingQueue<>();
    private final ConcurrentHashMap<Integer, Frame> encodedFrames = new ConcurrentHashMap<>();
    private boolean isRunning;
    private MediaFormat mediaFormat;
    private boolean mediaFormatChanged;

    public Surface createInputSurface() {
        return null;
    }

    public String getName() {
        return "PassthroughEncoder";
    }

    public void signalEndOfInputStream() {
    }

    public PassthroughBufferEncoder(int i) {
        for (int i2 = 0; i2 < 2; i2++) {
            this.availableFrames.add(new Frame(i2, ByteBuffer.allocate(i), new MediaCodec.BufferInfo()));
        }
    }

    public void init(MediaFormat mediaFormat2) {
        Intrinsics.checkNotNullParameter(mediaFormat2, "targetFormat");
        this.mediaFormat = mediaFormat2;
    }

    public void start() {
        this.isRunning = true;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public int dequeueInputFrame(long j) {
        int i;
        synchronized (this) {
            Frame frame = (Frame) CollectionsKt.firstOrNull(this.availableFrames);
            if (frame != null) {
                this.availableFrames.remove(frame);
                this.dequeuedInputFrames.put(Integer.valueOf(frame.tag), frame);
                i = frame.tag;
            } else {
                i = -1;
            }
        }
        return i;
    }

    public Frame getInputFrame(int i) {
        return this.dequeuedInputFrames.get(Integer.valueOf(i));
    }

    public void queueInputFrame(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        synchronized (this) {
            ByteBuffer byteBuffer = frame.buffer;
            if (byteBuffer != null) {
                byteBuffer.flip();
            }
            this.dequeuedInputFrames.remove(Integer.valueOf(frame.tag));
            this.encodedFrames.put(Integer.valueOf(frame.tag), frame);
            this.encodeQueue.add(Integer.valueOf(frame.tag));
        }
    }

    public int dequeueOutputFrame(long j) {
        if (!this.mediaFormatChanged) {
            this.mediaFormatChanged = true;
            return -2;
        }
        Integer poll = this.encodeQueue.poll(j, TimeUnit.MICROSECONDS);
        if (poll != null) {
            return poll.intValue();
        }
        return -1;
    }

    public Frame getOutputFrame(int i) {
        return this.encodedFrames.get(Integer.valueOf(i));
    }

    public void releaseOutputFrame(int i) {
        synchronized (this) {
            Frame remove = this.encodedFrames.remove(Integer.valueOf(i));
            if (remove != null) {
                ByteBuffer byteBuffer = remove.buffer;
                if (byteBuffer != null) {
                    byteBuffer.clear();
                }
                Boolean.valueOf(this.availableFrames.add(remove));
            }
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

    public void release() {
        this.availableFrames.clear();
        this.dequeuedInputFrames.clear();
        this.encodeQueue.clear();
        this.encodedFrames.clear();
    }
}
