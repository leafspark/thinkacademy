package com.linkedin.android.litr.frameextract;

import android.graphics.Point;
import android.net.Uri;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.linkedin.android.litr.render.SingleFrameRenderer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003JG\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006'"}, d2 = {"Lcom/linkedin/android/litr/frameextract/FrameExtractParameters;", "", "mediaUri", "Landroid/net/Uri;", "timestampUs", "", "renderer", "Lcom/linkedin/android/litr/render/SingleFrameRenderer;", "mode", "Lcom/linkedin/android/litr/frameextract/FrameExtractMode;", "destSize", "Landroid/graphics/Point;", "priority", "(Landroid/net/Uri;JLcom/linkedin/android/litr/render/SingleFrameRenderer;Lcom/linkedin/android/litr/frameextract/FrameExtractMode;Landroid/graphics/Point;J)V", "getDestSize", "()Landroid/graphics/Point;", "getMediaUri", "()Landroid/net/Uri;", "getMode", "()Lcom/linkedin/android/litr/frameextract/FrameExtractMode;", "getPriority", "()J", "getRenderer", "()Lcom/linkedin/android/litr/render/SingleFrameRenderer;", "getTimestampUs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: FrameExtractParameters.kt */
public final class FrameExtractParameters {
    private final Point destSize;
    private final Uri mediaUri;
    private final FrameExtractMode mode;
    private final long priority;
    private final SingleFrameRenderer renderer;
    private final long timestampUs;

    public FrameExtractParameters(Uri uri, long j, SingleFrameRenderer singleFrameRenderer) {
        this(uri, j, singleFrameRenderer, (FrameExtractMode) null, (Point) null, 0, 56, (DefaultConstructorMarker) null);
    }

    public FrameExtractParameters(Uri uri, long j, SingleFrameRenderer singleFrameRenderer, FrameExtractMode frameExtractMode) {
        this(uri, j, singleFrameRenderer, frameExtractMode, (Point) null, 0, 48, (DefaultConstructorMarker) null);
    }

    public FrameExtractParameters(Uri uri, long j, SingleFrameRenderer singleFrameRenderer, FrameExtractMode frameExtractMode, Point point) {
        this(uri, j, singleFrameRenderer, frameExtractMode, point, 0, 32, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FrameExtractParameters copy$default(FrameExtractParameters frameExtractParameters, Uri uri, long j, SingleFrameRenderer singleFrameRenderer, FrameExtractMode frameExtractMode, Point point, long j2, int i, Object obj) {
        FrameExtractParameters frameExtractParameters2 = frameExtractParameters;
        return frameExtractParameters.copy((i & 1) != 0 ? frameExtractParameters2.mediaUri : uri, (i & 2) != 0 ? frameExtractParameters2.timestampUs : j, (i & 4) != 0 ? frameExtractParameters2.renderer : singleFrameRenderer, (i & 8) != 0 ? frameExtractParameters2.mode : frameExtractMode, (i & 16) != 0 ? frameExtractParameters2.destSize : point, (i & 32) != 0 ? frameExtractParameters2.priority : j2);
    }

    public final Uri component1() {
        return this.mediaUri;
    }

    public final long component2() {
        return this.timestampUs;
    }

    public final SingleFrameRenderer component3() {
        return this.renderer;
    }

    public final FrameExtractMode component4() {
        return this.mode;
    }

    public final Point component5() {
        return this.destSize;
    }

    public final long component6() {
        return this.priority;
    }

    public final FrameExtractParameters copy(Uri uri, long j, SingleFrameRenderer singleFrameRenderer, FrameExtractMode frameExtractMode, Point point, long j2) {
        Intrinsics.checkNotNullParameter(uri, "mediaUri");
        Intrinsics.checkNotNullParameter(singleFrameRenderer, "renderer");
        Intrinsics.checkNotNullParameter(frameExtractMode, HummerStyleUtils.Hummer.MODE);
        return new FrameExtractParameters(uri, j, singleFrameRenderer, frameExtractMode, point, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FrameExtractParameters)) {
            return false;
        }
        FrameExtractParameters frameExtractParameters = (FrameExtractParameters) obj;
        return Intrinsics.areEqual(this.mediaUri, frameExtractParameters.mediaUri) && this.timestampUs == frameExtractParameters.timestampUs && Intrinsics.areEqual(this.renderer, frameExtractParameters.renderer) && Intrinsics.areEqual(this.mode, frameExtractParameters.mode) && Intrinsics.areEqual(this.destSize, frameExtractParameters.destSize) && this.priority == frameExtractParameters.priority;
    }

    public int hashCode() {
        Uri uri = this.mediaUri;
        int i = 0;
        int hashCode = uri != null ? uri.hashCode() : 0;
        long j = this.timestampUs;
        int i2 = ((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        SingleFrameRenderer singleFrameRenderer = this.renderer;
        int hashCode2 = (i2 + (singleFrameRenderer != null ? singleFrameRenderer.hashCode() : 0)) * 31;
        FrameExtractMode frameExtractMode = this.mode;
        int hashCode3 = (hashCode2 + (frameExtractMode != null ? frameExtractMode.hashCode() : 0)) * 31;
        Point point = this.destSize;
        if (point != null) {
            i = point.hashCode();
        }
        long j2 = this.priority;
        return ((hashCode3 + i) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "FrameExtractParameters(mediaUri=" + this.mediaUri + ", timestampUs=" + this.timestampUs + ", renderer=" + this.renderer + ", mode=" + this.mode + ", destSize=" + this.destSize + ", priority=" + this.priority + ")";
    }

    public FrameExtractParameters(Uri uri, long j, SingleFrameRenderer singleFrameRenderer, FrameExtractMode frameExtractMode, Point point, long j2) {
        Intrinsics.checkNotNullParameter(uri, "mediaUri");
        Intrinsics.checkNotNullParameter(singleFrameRenderer, "renderer");
        Intrinsics.checkNotNullParameter(frameExtractMode, HummerStyleUtils.Hummer.MODE);
        this.mediaUri = uri;
        this.timestampUs = j;
        this.renderer = singleFrameRenderer;
        this.mode = frameExtractMode;
        this.destSize = point;
        this.priority = j2;
    }

    public final Uri getMediaUri() {
        return this.mediaUri;
    }

    public final long getTimestampUs() {
        return this.timestampUs;
    }

    public final SingleFrameRenderer getRenderer() {
        return this.renderer;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FrameExtractParameters(Uri uri, long j, SingleFrameRenderer singleFrameRenderer, FrameExtractMode frameExtractMode, Point point, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, j, singleFrameRenderer, (i & 8) != 0 ? FrameExtractMode.Fast : frameExtractMode, (i & 16) != 0 ? null : point, (i & 32) != 0 ? 0 : j2);
    }

    public final FrameExtractMode getMode() {
        return this.mode;
    }

    public final Point getDestSize() {
        return this.destSize;
    }

    public final long getPriority() {
        return this.priority;
    }
}
