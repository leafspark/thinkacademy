package com.linkedin.android.litr.frameextract;

import android.graphics.Bitmap;
import com.linkedin.android.litr.frameextract.behaviors.FrameExtractBehaviorFrameListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/linkedin/android/litr/frameextract/FrameExtractJob$behaviorFrameListener$1", "Lcom/linkedin/android/litr/frameextract/behaviors/FrameExtractBehaviorFrameListener;", "onFrameExtracted", "", "bitmap", "Landroid/graphics/Bitmap;", "onFrameFailed", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: FrameExtractJob.kt */
public final class FrameExtractJob$behaviorFrameListener$1 implements FrameExtractBehaviorFrameListener {
    final /* synthetic */ FrameExtractJob this$0;

    FrameExtractJob$behaviorFrameListener$1(FrameExtractJob frameExtractJob) {
        this.this$0 = frameExtractJob;
    }

    public void onFrameExtracted(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Bitmap access$renderExtractedFrame = this.this$0.renderExtractedFrame(bitmap);
        if (access$renderExtractedFrame != null) {
            FrameExtractListener access$getListener$p = this.this$0.listener;
            if (access$getListener$p != null) {
                access$getListener$p.onExtracted(this.this$0.jobId, this.this$0.params.getTimestampUs(), access$renderExtractedFrame);
                return;
            }
            return;
        }
        FrameExtractListener access$getListener$p2 = this.this$0.listener;
        if (access$getListener$p2 != null) {
            access$getListener$p2.onError(this.this$0.jobId, this.this$0.params.getTimestampUs(), (Throwable) null);
        }
    }

    public void onFrameFailed() {
        FrameExtractListener access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            access$getListener$p.onError(this.this$0.jobId, this.this$0.params.getTimestampUs(), (Throwable) null);
        }
    }
}
