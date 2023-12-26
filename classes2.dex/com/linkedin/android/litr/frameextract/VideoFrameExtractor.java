package com.linkedin.android.litr.frameextract;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.linkedin.android.litr.frameextract.behaviors.FrameExtractBehavior;
import com.linkedin.android.litr.frameextract.queue.ComparableFutureTask;
import com.linkedin.android.litr.frameextract.queue.PriorityExecutorUtil;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0016\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002$%B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u000bH\u0002J\u0006\u0010!\u001a\u00020\u0019J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bJ\u0006\u0010#\u001a\u00020\u0019R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006&"}, d2 = {"Lcom/linkedin/android/litr/frameextract/VideoFrameExtractor;", "", "context", "Landroid/content/Context;", "listenerLooper", "Landroid/os/Looper;", "extractBehavior", "Lcom/linkedin/android/litr/frameextract/behaviors/FrameExtractBehavior;", "(Landroid/content/Context;Landroid/os/Looper;Lcom/linkedin/android/litr/frameextract/behaviors/FrameExtractBehavior;)V", "activeJobMap", "", "", "Lcom/linkedin/android/litr/frameextract/VideoFrameExtractor$ActiveExtractJob;", "executorService", "Ljava/util/concurrent/ThreadPoolExecutor;", "listenerHandler", "Landroid/os/Handler;", "getListenerHandler", "()Landroid/os/Handler;", "listenerHandler$delegate", "Lkotlin/Lazy;", "rootListener", "com/linkedin/android/litr/frameextract/VideoFrameExtractor$rootListener$1", "Lcom/linkedin/android/litr/frameextract/VideoFrameExtractor$rootListener$1;", "extract", "", "requestId", "params", "Lcom/linkedin/android/litr/frameextract/FrameExtractParameters;", "listener", "Lcom/linkedin/android/litr/frameextract/FrameExtractListener;", "onCompleteJob", "jobId", "release", "stop", "stopAll", "ActiveExtractJob", "Companion", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoFrameExtractor.kt */
public final class VideoFrameExtractor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "VideoThumbnailExtractor";
    /* access modifiers changed from: private */
    public final Map<String, ActiveExtractJob> activeJobMap;
    private final ThreadPoolExecutor executorService;
    private FrameExtractBehavior extractBehavior;
    private final Lazy listenerHandler$delegate;
    /* access modifiers changed from: private */
    public final Looper listenerLooper;
    private final VideoFrameExtractor$rootListener$1 rootListener;

    public VideoFrameExtractor(Context context) {
        this(context, (Looper) null, (FrameExtractBehavior) null, 6, (DefaultConstructorMarker) null);
    }

    public VideoFrameExtractor(Context context, Looper looper) {
        this(context, looper, (FrameExtractBehavior) null, 4, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public final Handler getListenerHandler() {
        return (Handler) this.listenerHandler$delegate.getValue();
    }

    public VideoFrameExtractor(Context context, Looper looper, FrameExtractBehavior frameExtractBehavior) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(looper, "listenerLooper");
        Intrinsics.checkNotNullParameter(frameExtractBehavior, "extractBehavior");
        this.listenerLooper = looper;
        this.extractBehavior = frameExtractBehavior;
        this.activeJobMap = new LinkedHashMap();
        this.listenerHandler$delegate = LazyKt.lazy(new VideoFrameExtractor$listenerHandler$2(this));
        this.executorService = PriorityExecutorUtil.INSTANCE.newSingleThreadPoolPriorityExecutor();
        this.rootListener = new VideoFrameExtractor$rootListener$1(this);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VideoFrameExtractor(android.content.Context r1, android.os.Looper r2, com.linkedin.android.litr.frameextract.behaviors.FrameExtractBehavior r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000d
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            java.lang.String r5 = "Looper.getMainLooper()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
        L_0x000d:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0018
            com.linkedin.android.litr.frameextract.behaviors.MediaMetadataExtractBehavior r3 = new com.linkedin.android.litr.frameextract.behaviors.MediaMetadataExtractBehavior
            r3.<init>(r1)
            com.linkedin.android.litr.frameextract.behaviors.FrameExtractBehavior r3 = (com.linkedin.android.litr.frameextract.behaviors.FrameExtractBehavior) r3
        L_0x0018:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.linkedin.android.litr.frameextract.VideoFrameExtractor.<init>(android.content.Context, android.os.Looper, com.linkedin.android.litr.frameextract.behaviors.FrameExtractBehavior, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final void extract(String str, FrameExtractParameters frameExtractParameters, FrameExtractListener frameExtractListener) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(frameExtractParameters, "params");
        if (this.activeJobMap.containsKey(str)) {
            Log.w(TAG, "Request with ID " + str + " already exists");
            return;
        }
        ComparableFutureTask comparableFutureTask = new ComparableFutureTask(new FrameExtractJob(str, frameExtractParameters, this.extractBehavior, this.rootListener), null, frameExtractParameters.getPriority());
        this.executorService.execute(comparableFutureTask);
        this.activeJobMap.put(str, new ActiveExtractJob(comparableFutureTask, frameExtractListener));
    }

    public final void stop(String str) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        ActiveExtractJob activeExtractJob = this.activeJobMap.get(str);
        if (activeExtractJob != null) {
            if (!activeExtractJob.getFuture().isCancelled() && !activeExtractJob.getFuture().isDone()) {
                activeExtractJob.getFuture().cancel(true);
            }
            if (!activeExtractJob.getFuture().isStarted()) {
                this.activeJobMap.remove(str);
            }
        }
    }

    public final void stopAll() {
        Iterator<Map.Entry<String, ActiveExtractJob>> it = this.activeJobMap.entrySet().iterator();
        while (it.hasNext()) {
            ActiveExtractJob activeExtractJob = (ActiveExtractJob) it.next().getValue();
            if (!activeExtractJob.getFuture().isCancelled() && !activeExtractJob.getFuture().isDone()) {
                activeExtractJob.getFuture().cancel(true);
            }
            if (!activeExtractJob.getFuture().isStarted()) {
                it.remove();
            }
        }
    }

    public final void release() {
        this.executorService.shutdownNow();
        this.extractBehavior.release();
        this.activeJobMap.clear();
    }

    /* access modifiers changed from: private */
    public final void onCompleteJob(String str) {
        this.activeJobMap.remove(str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/linkedin/android/litr/frameextract/VideoFrameExtractor$ActiveExtractJob;", "", "future", "Lcom/linkedin/android/litr/frameextract/queue/ComparableFutureTask;", "listener", "Lcom/linkedin/android/litr/frameextract/FrameExtractListener;", "(Lcom/linkedin/android/litr/frameextract/queue/ComparableFutureTask;Lcom/linkedin/android/litr/frameextract/FrameExtractListener;)V", "getFuture", "()Lcom/linkedin/android/litr/frameextract/queue/ComparableFutureTask;", "getListener", "()Lcom/linkedin/android/litr/frameextract/FrameExtractListener;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "litr_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VideoFrameExtractor.kt */
    private static final class ActiveExtractJob {
        private final ComparableFutureTask<?> future;
        private final FrameExtractListener listener;

        public static /* synthetic */ ActiveExtractJob copy$default(ActiveExtractJob activeExtractJob, ComparableFutureTask<?> comparableFutureTask, FrameExtractListener frameExtractListener, int i, Object obj) {
            if ((i & 1) != 0) {
                comparableFutureTask = activeExtractJob.future;
            }
            if ((i & 2) != 0) {
                frameExtractListener = activeExtractJob.listener;
            }
            return activeExtractJob.copy(comparableFutureTask, frameExtractListener);
        }

        public final ComparableFutureTask<?> component1() {
            return this.future;
        }

        public final FrameExtractListener component2() {
            return this.listener;
        }

        public final ActiveExtractJob copy(ComparableFutureTask<?> comparableFutureTask, FrameExtractListener frameExtractListener) {
            Intrinsics.checkNotNullParameter(comparableFutureTask, "future");
            return new ActiveExtractJob(comparableFutureTask, frameExtractListener);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActiveExtractJob)) {
                return false;
            }
            ActiveExtractJob activeExtractJob = (ActiveExtractJob) obj;
            return Intrinsics.areEqual(this.future, activeExtractJob.future) && Intrinsics.areEqual(this.listener, activeExtractJob.listener);
        }

        public int hashCode() {
            ComparableFutureTask<?> comparableFutureTask = this.future;
            int i = 0;
            int hashCode = (comparableFutureTask != null ? comparableFutureTask.hashCode() : 0) * 31;
            FrameExtractListener frameExtractListener = this.listener;
            if (frameExtractListener != null) {
                i = frameExtractListener.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "ActiveExtractJob(future=" + this.future + ", listener=" + this.listener + ")";
        }

        public ActiveExtractJob(ComparableFutureTask<?> comparableFutureTask, FrameExtractListener frameExtractListener) {
            Intrinsics.checkNotNullParameter(comparableFutureTask, "future");
            this.future = comparableFutureTask;
            this.listener = frameExtractListener;
        }

        public final ComparableFutureTask<?> getFuture() {
            return this.future;
        }

        public final FrameExtractListener getListener() {
            return this.listener;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/linkedin/android/litr/frameextract/VideoFrameExtractor$Companion;", "", "()V", "TAG", "", "litr_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VideoFrameExtractor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
