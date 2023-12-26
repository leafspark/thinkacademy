package com.linkedin.android.litr.frameextract;

import android.graphics.Bitmap;
import android.os.Handler;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.linkedin.android.litr.frameextract.VideoFrameExtractor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0012H\u0002¨\u0006\u0013"}, d2 = {"com/linkedin/android/litr/frameextract/VideoFrameExtractor$rootListener$1", "Lcom/linkedin/android/litr/frameextract/FrameExtractListener;", "onCancelled", "", "id", "", "timestampUs", "", "onError", "cause", "", "onExtracted", "bitmap", "Landroid/graphics/Bitmap;", "onStarted", "runOnListenerHandler", "listener", "func", "Lkotlin/Function1;", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoFrameExtractor.kt */
public final class VideoFrameExtractor$rootListener$1 implements FrameExtractListener {
    final /* synthetic */ VideoFrameExtractor this$0;

    VideoFrameExtractor$rootListener$1(VideoFrameExtractor videoFrameExtractor) {
        this.this$0 = videoFrameExtractor;
    }

    public void onStarted(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "id");
        VideoFrameExtractor.ActiveExtractJob activeExtractJob = (VideoFrameExtractor.ActiveExtractJob) this.this$0.activeJobMap.get(str);
        runOnListenerHandler(activeExtractJob != null ? activeExtractJob.getListener() : null, new VideoFrameExtractor$rootListener$1$onStarted$1(str, j));
    }

    public void onExtracted(String str, long j, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        VideoFrameExtractor.ActiveExtractJob activeExtractJob = (VideoFrameExtractor.ActiveExtractJob) this.this$0.activeJobMap.get(str);
        runOnListenerHandler(activeExtractJob != null ? activeExtractJob.getListener() : null, new VideoFrameExtractor$rootListener$1$onExtracted$1(this, str, j, bitmap));
    }

    public void onCancelled(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "id");
        VideoFrameExtractor.ActiveExtractJob activeExtractJob = (VideoFrameExtractor.ActiveExtractJob) this.this$0.activeJobMap.get(str);
        runOnListenerHandler(activeExtractJob != null ? activeExtractJob.getListener() : null, new VideoFrameExtractor$rootListener$1$onCancelled$1(this, str, j));
    }

    public void onError(String str, long j, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "id");
        VideoFrameExtractor.ActiveExtractJob activeExtractJob = (VideoFrameExtractor.ActiveExtractJob) this.this$0.activeJobMap.get(str);
        runOnListenerHandler(activeExtractJob != null ? activeExtractJob.getListener() : null, new VideoFrameExtractor$rootListener$1$onError$1(this, str, j, th));
    }

    private final void runOnListenerHandler(FrameExtractListener frameExtractListener, Function1<? super FrameExtractListener, Unit> function1) {
        if (frameExtractListener != null) {
            Handler access$getListenerHandler$p = this.this$0.getListenerHandler();
            Runnable videoFrameExtractor$rootListener$1$runOnListenerHandler$1 = new VideoFrameExtractor$rootListener$1$runOnListenerHandler$1(function1, frameExtractListener);
            if (!(access$getListenerHandler$p instanceof Handler)) {
                access$getListenerHandler$p.post(videoFrameExtractor$rootListener$1$runOnListenerHandler$1);
            } else {
                AsynchronousInstrumentation.handlerPost(access$getListenerHandler$p, videoFrameExtractor$rootListener$1$runOnListenerHandler$1);
            }
        }
    }
}
