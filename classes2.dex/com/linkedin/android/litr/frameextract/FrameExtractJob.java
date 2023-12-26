package com.linkedin.android.litr.frameextract;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.util.Log;
import com.linkedin.android.litr.frameextract.behaviors.FrameExtractBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\f\b\u0001\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/linkedin/android/litr/frameextract/FrameExtractJob;", "Ljava/lang/Runnable;", "jobId", "", "params", "Lcom/linkedin/android/litr/frameextract/FrameExtractParameters;", "behavior", "Lcom/linkedin/android/litr/frameextract/behaviors/FrameExtractBehavior;", "listener", "Lcom/linkedin/android/litr/frameextract/FrameExtractListener;", "(Ljava/lang/String;Lcom/linkedin/android/litr/frameextract/FrameExtractParameters;Lcom/linkedin/android/litr/frameextract/behaviors/FrameExtractBehavior;Lcom/linkedin/android/litr/frameextract/FrameExtractListener;)V", "behaviorFrameListener", "com/linkedin/android/litr/frameextract/FrameExtractJob$behaviorFrameListener$1", "Lcom/linkedin/android/litr/frameextract/FrameExtractJob$behaviorFrameListener$1;", "<set-?>", "", "isStarted", "()Z", "error", "", "cause", "", "extract", "renderExtractedFrame", "Landroid/graphics/Bitmap;", "bitmap", "run", "Companion", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: FrameExtractJob.kt */
public final class FrameExtractJob implements Runnable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "FrameExtractJob";
    private final FrameExtractBehavior behavior;
    private final FrameExtractJob$behaviorFrameListener$1 behaviorFrameListener = new FrameExtractJob$behaviorFrameListener$1(this);
    private boolean isStarted;
    /* access modifiers changed from: private */
    public final String jobId;
    /* access modifiers changed from: private */
    public final FrameExtractListener listener;
    /* access modifiers changed from: private */
    public final FrameExtractParameters params;

    public FrameExtractJob(String str, FrameExtractParameters frameExtractParameters, FrameExtractBehavior frameExtractBehavior, FrameExtractListener frameExtractListener) {
        Intrinsics.checkNotNullParameter(str, "jobId");
        Intrinsics.checkNotNullParameter(frameExtractParameters, "params");
        Intrinsics.checkNotNullParameter(frameExtractBehavior, "behavior");
        this.jobId = str;
        this.params = frameExtractParameters;
        this.behavior = frameExtractBehavior;
        this.listener = frameExtractListener;
    }

    public final boolean isStarted() {
        return this.isStarted;
    }

    public void run() {
        this.isStarted = true;
        try {
            extract();
        } catch (RuntimeException e) {
            Throwable th = e;
            Log.e(TAG, "FrameExtractJob error", th);
            if (e.getCause() instanceof InterruptedException) {
                FrameExtractListener frameExtractListener = this.listener;
                if (frameExtractListener != null) {
                    frameExtractListener.onCancelled(this.jobId, this.params.getTimestampUs());
                    return;
                }
                return;
            }
            error(th);
        }
    }

    /* access modifiers changed from: private */
    public final Bitmap renderExtractedFrame(Bitmap bitmap) {
        if (Thread.interrupted()) {
            FrameExtractListener frameExtractListener = this.listener;
            if (frameExtractListener != null) {
                frameExtractListener.onCancelled(this.jobId, this.params.getTimestampUs());
            }
            return null;
        }
        if (this.params.getDestSize() != null) {
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, this.params.getDestSize().x, this.params.getDestSize().y);
        }
        if (!Thread.interrupted()) {
            return this.params.getRenderer().renderFrame(bitmap, this.params.getTimestampUs() * 1000);
        }
        FrameExtractListener frameExtractListener2 = this.listener;
        if (frameExtractListener2 != null) {
            frameExtractListener2.onCancelled(this.jobId, this.params.getTimestampUs());
        }
        return null;
    }

    private final void extract() {
        FrameExtractListener frameExtractListener;
        FrameExtractListener frameExtractListener2 = this.listener;
        if (frameExtractListener2 != null) {
            frameExtractListener2.onStarted(this.jobId, this.params.getTimestampUs());
        }
        if (this.params.getTimestampUs() < 0) {
            FrameExtractListener frameExtractListener3 = this.listener;
            if (frameExtractListener3 != null) {
                frameExtractListener3.onCancelled(this.jobId, this.params.getTimestampUs());
                return;
            }
            return;
        }
        try {
            if (Thread.interrupted()) {
                FrameExtractListener frameExtractListener4 = this.listener;
                if (frameExtractListener4 != null) {
                    frameExtractListener4.onCancelled(this.jobId, this.params.getTimestampUs());
                }
            } else if (!this.behavior.extract(this.params, this.behaviorFrameListener) && (frameExtractListener = this.listener) != null) {
                frameExtractListener.onCancelled(this.jobId, this.params.getTimestampUs());
            }
        } catch (Throwable th) {
            error(th);
        }
    }

    private final void error(Throwable th) {
        Log.e(TAG, "Error encountered while extracting frames", th);
        FrameExtractListener frameExtractListener = this.listener;
        if (frameExtractListener != null) {
            frameExtractListener.onError(this.jobId, this.params.getTimestampUs(), th);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/linkedin/android/litr/frameextract/FrameExtractJob$Companion;", "", "()V", "TAG", "", "litr_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FrameExtractJob.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("FrameExtractJob", "FrameExtractJob::class.java.simpleName");
    }
}
