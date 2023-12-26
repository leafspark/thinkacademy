package com.linkedin.android.litr.frameextract.queue;

import com.linkedin.android.litr.frameextract.FrameExtractJob;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u0000 \u0011*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0003:\u0001\u0011B\u001f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/linkedin/android/litr/frameextract/queue/ComparableFutureTask;", "T", "Ljava/util/concurrent/FutureTask;", "", "job", "Lcom/linkedin/android/litr/frameextract/FrameExtractJob;", "result", "priority", "", "(Lcom/linkedin/android/litr/frameextract/FrameExtractJob;Ljava/lang/Object;J)V", "isStarted", "", "()Z", "sequenceNumber", "compareTo", "", "other", "Companion", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: ComparableFutureTask.kt */
public final class ComparableFutureTask<T> extends FutureTask<T> implements Comparable<ComparableFutureTask<T>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AtomicLong sharedSequence = new AtomicLong();
    private final FrameExtractJob job;
    private long priority;
    private final long sequenceNumber = sharedSequence.getAndIncrement();

    public ComparableFutureTask(FrameExtractJob frameExtractJob, T t, long j) {
        super(frameExtractJob, t);
        this.job = frameExtractJob;
        this.priority = j;
    }

    public final boolean isStarted() {
        FrameExtractJob frameExtractJob = this.job;
        if (frameExtractJob != null) {
            return frameExtractJob.isStarted();
        }
        return false;
    }

    public int compareTo(ComparableFutureTask<T> comparableFutureTask) {
        Intrinsics.checkNotNullParameter(comparableFutureTask, "other");
        int i = (this.priority > comparableFutureTask.priority ? 1 : (this.priority == comparableFutureTask.priority ? 0 : -1));
        if (i != 0) {
            return i;
        }
        return this.sequenceNumber < comparableFutureTask.sequenceNumber ? -1 : 1;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/linkedin/android/litr/frameextract/queue/ComparableFutureTask$Companion;", "", "()V", "sharedSequence", "Ljava/util/concurrent/atomic/AtomicLong;", "getSharedSequence", "()Ljava/util/concurrent/atomic/AtomicLong;", "litr_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ComparableFutureTask.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AtomicLong getSharedSequence() {
            return ComparableFutureTask.sharedSequence;
        }
    }
}
