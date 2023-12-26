package io.ktor.utils.io.internal;

import io.ktor.utils.io.ByteBufferChannel;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\b\u0000\u0018\u00002\u00020\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lio/ktor/utils/io/internal/JoiningState;", "Lio/ktor/utils/io/ByteBufferChannel;", "delegatedTo", "", "delegateClose", "<init>", "(Lio/ktor/utils/io/ByteBufferChannel;Z)V", "", "awaitClose", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "complete", "()V", "Lkotlinx/coroutines/Job;", "getCloseWaitJob", "()Lkotlinx/coroutines/Job;", "closeWaitJob", "Z", "getDelegateClose", "()Z", "Lio/ktor/utils/io/ByteBufferChannel;", "getDelegatedTo", "()Lio/ktor/utils/io/ByteBufferChannel;", "ktor-io", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteBufferChannelInternals.kt */
public final class JoiningState {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _closeWaitJob$FU = AtomicReferenceFieldUpdater.newUpdater(JoiningState.class, Object.class, "_closeWaitJob");
    private volatile /* synthetic */ Object _closeWaitJob = null;
    private volatile /* synthetic */ int closed = 0;
    private final boolean delegateClose;
    private final ByteBufferChannel delegatedTo;

    public JoiningState(ByteBufferChannel byteBufferChannel, boolean z) {
        Intrinsics.checkNotNullParameter(byteBufferChannel, "delegatedTo");
        this.delegatedTo = byteBufferChannel;
        this.delegateClose = z;
    }

    public final boolean getDelegateClose() {
        return this.delegateClose;
    }

    public final ByteBufferChannel getDelegatedTo() {
        return this.delegatedTo;
    }

    private final Job getCloseWaitJob() {
        CompletableJob Job$default;
        do {
            Job job = (Job) this._closeWaitJob;
            if (job != null) {
                return job;
            }
            Job$default = JobKt.Job$default((Job) null, 1, (Object) null);
        } while (!_closeWaitJob$FU.compareAndSet(this, (Object) null, Job$default));
        if (this.closed == 1) {
            Job.DefaultImpls.cancel$default((Job) Job$default, (CancellationException) null, 1, (Object) null);
        }
        return Job$default;
    }

    public final void complete() {
        this.closed = 1;
        Job job = (Job) _closeWaitJob$FU.getAndSet(this, (Object) null);
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final Object awaitClose(Continuation<? super Unit> continuation) {
        if (this.closed == 1) {
            return Unit.INSTANCE;
        }
        Object join = getCloseWaitJob().join(continuation);
        return join == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? join : Unit.INSTANCE;
    }
}
