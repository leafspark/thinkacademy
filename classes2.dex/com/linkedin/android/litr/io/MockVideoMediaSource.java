package com.linkedin.android.litr.io;

import android.media.MediaFormat;
import android.os.Build;
import com.linkedin.android.litr.io.MediaSource;
import com.linkedin.android.litr.utils.MediaFormatUtils;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\u0018\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/linkedin/android/litr/io/MockVideoMediaSource;", "Lcom/linkedin/android/litr/io/MediaSource;", "trackFormat", "Landroid/media/MediaFormat;", "(Landroid/media/MediaFormat;)V", "currentPosition", "", "frameDuration", "orientationHint", "", "selectedTrack", "trackDuration", "advance", "", "getOrientationHint", "getSampleFlags", "getSampleTime", "getSampleTrackIndex", "getSize", "getTrackCount", "getTrackFormat", "track", "readSampleData", "buffer", "Ljava/nio/ByteBuffer;", "offset", "release", "seekTo", "position", "mode", "selectTrack", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: MockVideoMediaSource.kt */
public final class MockVideoMediaSource implements MediaSource {
    private long currentPosition;
    private final long frameDuration;
    private final int orientationHint;
    private int selectedTrack = -1;
    private final long trackDuration;
    private final MediaFormat trackFormat;

    public /* synthetic */ MediaRange getSelection() {
        return MediaSource.CC.$default$getSelection(this);
    }

    public long getSize() {
        return -1;
    }

    public int getTrackCount() {
        return 1;
    }

    public int readSampleData(ByteBuffer byteBuffer, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        return 1;
    }

    public void release() {
    }

    public MockVideoMediaSource(MediaFormat mediaFormat) {
        Intrinsics.checkNotNullParameter(mediaFormat, "trackFormat");
        this.trackFormat = mediaFormat;
        mediaFormat.containsKey("durationUs");
        this.trackDuration = mediaFormat.getLong("durationUs");
        mediaFormat.containsKey("frame-rate");
        this.frameDuration = 1000000 / ((long) MediaFormatUtils.Companion.getFrameRate(mediaFormat, (Number) -1).intValue());
        int i = Build.VERSION.SDK_INT;
        this.orientationHint = mediaFormat.containsKey("rotation-degrees") ? mediaFormat.getInteger("rotation-degrees") : 0;
    }

    public int getOrientationHint() {
        return this.orientationHint;
    }

    public MediaFormat getTrackFormat(int i) {
        return this.trackFormat;
    }

    public void selectTrack(int i) {
        this.selectedTrack = i;
    }

    public void seekTo(long j, int i) {
        this.currentPosition = j;
    }

    public int getSampleTrackIndex() {
        return this.selectedTrack;
    }

    public long getSampleTime() {
        return this.currentPosition;
    }

    public int getSampleFlags() {
        return this.currentPosition < this.trackDuration ? 0 : 4;
    }

    public void advance() {
        this.currentPosition += this.frameDuration;
    }
}
