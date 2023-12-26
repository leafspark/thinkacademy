package com.linkedin.android.litr.frameextract;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"Lcom/linkedin/android/litr/frameextract/FrameExtractListener;", "", "onCancelled", "", "id", "", "timestampUs", "", "onError", "cause", "", "onExtracted", "bitmap", "Landroid/graphics/Bitmap;", "onStarted", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: FrameExtractListener.kt */
public interface FrameExtractListener {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* compiled from: FrameExtractListener.kt */
    public static final class DefaultImpls {
        public static void onCancelled(FrameExtractListener frameExtractListener, String str, long j) {
            Intrinsics.checkNotNullParameter(str, "id");
        }

        public static void onError(FrameExtractListener frameExtractListener, String str, long j, Throwable th) {
            Intrinsics.checkNotNullParameter(str, "id");
        }

        public static void onExtracted(FrameExtractListener frameExtractListener, String str, long j, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        }

        public static void onStarted(FrameExtractListener frameExtractListener, String str, long j) {
            Intrinsics.checkNotNullParameter(str, "id");
        }
    }

    void onCancelled(String str, long j);

    void onError(String str, long j, Throwable th);

    void onExtracted(String str, long j, Bitmap bitmap);

    void onStarted(String str, long j);
}
