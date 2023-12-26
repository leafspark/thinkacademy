package com.linkedin.android.litr.frameextract.behaviors;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.linkedin.android.litr.frameextract.FrameExtractMode;
import com.linkedin.android.litr.frameextract.FrameExtractParameters;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/linkedin/android/litr/frameextract/behaviors/MediaMetadataExtractBehavior;", "Lcom/linkedin/android/litr/frameextract/behaviors/FrameExtractBehavior;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "retrieverToMediaUri", "Lcom/linkedin/android/litr/frameextract/behaviors/MediaMetadataExtractBehavior$RetrieverToMediaUri;", "extract", "", "params", "Lcom/linkedin/android/litr/frameextract/FrameExtractParameters;", "listener", "Lcom/linkedin/android/litr/frameextract/behaviors/FrameExtractBehaviorFrameListener;", "release", "", "retrieveFrame", "retrieverOptions", "", "setupRetriever", "Landroid/media/MediaMetadataRetriever;", "mediaUri", "Landroid/net/Uri;", "RetrieverToMediaUri", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: MediaMetadataExtractBehavior.kt */
public final class MediaMetadataExtractBehavior implements FrameExtractBehavior {
    private final Context context;
    private RetrieverToMediaUri retrieverToMediaUri;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FrameExtractMode.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[FrameExtractMode.Fast.ordinal()] = 1;
            iArr[FrameExtractMode.Exact.ordinal()] = 2;
        }
    }

    public MediaMetadataExtractBehavior(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    private final synchronized MediaMetadataRetriever setupRetriever(Uri uri) {
        MediaMetadataRetriever mediaMetadataRetriever;
        MediaMetadataRetriever retriever;
        RetrieverToMediaUri retrieverToMediaUri2 = this.retrieverToMediaUri;
        if (retrieverToMediaUri2 != null) {
            if (!(!Intrinsics.areEqual(retrieverToMediaUri2.getMediaUri(), uri))) {
                mediaMetadataRetriever = retrieverToMediaUri2.getRetriever();
            }
        }
        if (!(retrieverToMediaUri2 == null || (retriever = retrieverToMediaUri2.getRetriever()) == null)) {
            retriever.release();
        }
        MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
        mediaMetadataRetriever2.setDataSource(this.context, uri);
        this.retrieverToMediaUri = new RetrieverToMediaUri(mediaMetadataRetriever2, uri);
        mediaMetadataRetriever = mediaMetadataRetriever2;
        return mediaMetadataRetriever;
    }

    public boolean extract(FrameExtractParameters frameExtractParameters, FrameExtractBehaviorFrameListener frameExtractBehaviorFrameListener) {
        Intrinsics.checkNotNullParameter(frameExtractParameters, "params");
        Intrinsics.checkNotNullParameter(frameExtractBehaviorFrameListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        int i = WhenMappings.$EnumSwitchMapping$0[frameExtractParameters.getMode().ordinal()];
        if (i == 1) {
            return retrieveFrame(frameExtractParameters, 2, frameExtractBehaviorFrameListener);
        }
        if (i == 2) {
            return retrieveFrame(frameExtractParameters, 3, frameExtractBehaviorFrameListener);
        }
        throw new NoWhenBranchMatchedException();
    }

    public void release() {
        MediaMetadataRetriever retriever;
        RetrieverToMediaUri retrieverToMediaUri2 = this.retrieverToMediaUri;
        if (retrieverToMediaUri2 != null && (retriever = retrieverToMediaUri2.getRetriever()) != null) {
            retriever.release();
        }
    }

    private final boolean retrieveFrame(FrameExtractParameters frameExtractParameters, int i, FrameExtractBehaviorFrameListener frameExtractBehaviorFrameListener) {
        Bitmap frameAtTime = setupRetriever(frameExtractParameters.getMediaUri()).getFrameAtTime(frameExtractParameters.getTimestampUs(), i);
        if (frameAtTime != null) {
            frameExtractBehaviorFrameListener.onFrameExtracted(frameAtTime);
            return true;
        }
        frameExtractBehaviorFrameListener.onFrameFailed();
        return true;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/linkedin/android/litr/frameextract/behaviors/MediaMetadataExtractBehavior$RetrieverToMediaUri;", "", "retriever", "Landroid/media/MediaMetadataRetriever;", "mediaUri", "Landroid/net/Uri;", "(Landroid/media/MediaMetadataRetriever;Landroid/net/Uri;)V", "getMediaUri", "()Landroid/net/Uri;", "getRetriever", "()Landroid/media/MediaMetadataRetriever;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "litr_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MediaMetadataExtractBehavior.kt */
    public static final class RetrieverToMediaUri {
        private final Uri mediaUri;
        private final MediaMetadataRetriever retriever;

        public static /* synthetic */ RetrieverToMediaUri copy$default(RetrieverToMediaUri retrieverToMediaUri, MediaMetadataRetriever mediaMetadataRetriever, Uri uri, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaMetadataRetriever = retrieverToMediaUri.retriever;
            }
            if ((i & 2) != 0) {
                uri = retrieverToMediaUri.mediaUri;
            }
            return retrieverToMediaUri.copy(mediaMetadataRetriever, uri);
        }

        public final MediaMetadataRetriever component1() {
            return this.retriever;
        }

        public final Uri component2() {
            return this.mediaUri;
        }

        public final RetrieverToMediaUri copy(MediaMetadataRetriever mediaMetadataRetriever, Uri uri) {
            Intrinsics.checkNotNullParameter(mediaMetadataRetriever, "retriever");
            Intrinsics.checkNotNullParameter(uri, "mediaUri");
            return new RetrieverToMediaUri(mediaMetadataRetriever, uri);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RetrieverToMediaUri)) {
                return false;
            }
            RetrieverToMediaUri retrieverToMediaUri = (RetrieverToMediaUri) obj;
            return Intrinsics.areEqual(this.retriever, retrieverToMediaUri.retriever) && Intrinsics.areEqual(this.mediaUri, retrieverToMediaUri.mediaUri);
        }

        public int hashCode() {
            MediaMetadataRetriever mediaMetadataRetriever = this.retriever;
            int i = 0;
            int hashCode = (mediaMetadataRetriever != null ? mediaMetadataRetriever.hashCode() : 0) * 31;
            Uri uri = this.mediaUri;
            if (uri != null) {
                i = uri.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "RetrieverToMediaUri(retriever=" + this.retriever + ", mediaUri=" + this.mediaUri + ")";
        }

        public RetrieverToMediaUri(MediaMetadataRetriever mediaMetadataRetriever, Uri uri) {
            Intrinsics.checkNotNullParameter(mediaMetadataRetriever, "retriever");
            Intrinsics.checkNotNullParameter(uri, "mediaUri");
            this.retriever = mediaMetadataRetriever;
            this.mediaUri = uri;
        }

        public final Uri getMediaUri() {
            return this.mediaUri;
        }

        public final MediaMetadataRetriever getRetriever() {
            return this.retriever;
        }
    }
}
