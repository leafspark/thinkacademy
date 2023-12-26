package io.ktor.utils.io;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectClause0;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001J\t\u0010\u001f\u001a\u00020 H\u0001J\u0015\u0010\u001f\u001a\u00020\u000f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0001J\u001b\u0010\u001f\u001a\u00020 2\u0010\b\u0002\u0010!\u001a\n\u0018\u00010#j\u0004\u0018\u0001`$H\u0001J6\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010'\u001a\u0002H&2\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u0002H&0)H\u0001¢\u0006\u0002\u0010+J(\u0010,\u001a\u0004\u0018\u0001H-\"\b\b\u0000\u0010-*\u00020*2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H-0\u0014H\u0003¢\u0006\u0002\u0010.J\r\u0010/\u001a\u00060#j\u0002`$H\u0001JF\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u00020\u000f2\b\b\u0002\u00103\u001a\u00020\u000f2'\u00104\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\"¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020 05j\u0002`8H\u0001J2\u00100\u001a\u0002012'\u00104\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\"¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020 05j\u0002`8H\u0001J\u0011\u00109\u001a\u00020 HAø\u0001\u0000¢\u0006\u0002\u0010:J\u0015\u0010;\u001a\u00020<2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0001J\u0011\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<H\u0003J\u0011\u0010=\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0003H\u0003J\t\u0010@\u001a\u00020\u000fH\u0001J\b\u0010A\u001a\u00020BH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000fX\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u000fX\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0012\u0010\u0012\u001a\u00020\u000fX\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006C"}, d2 = {"Lio/ktor/utils/io/ChannelJob;", "Lio/ktor/utils/io/ReaderJob;", "Lio/ktor/utils/io/WriterJob;", "Lkotlinx/coroutines/Job;", "delegate", "channel", "Lio/ktor/utils/io/ByteChannel;", "(Lkotlinx/coroutines/Job;Lio/ktor/utils/io/ByteChannel;)V", "getChannel", "()Lio/ktor/utils/io/ByteChannel;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "getCancellationException", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "plus", "context", "other", "start", "toString", "", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Coroutines.kt */
final class ChannelJob implements ReaderJob, WriterJob, Job {
    private final ByteChannel channel;
    private final Job delegate;

    public ChildHandle attachChild(ChildJob childJob) {
        Intrinsics.checkNotNullParameter(childJob, "child");
        return this.delegate.attachChild(childJob);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        this.delegate.cancel();
    }

    public void cancel(CancellationException cancellationException) {
        this.delegate.cancel(cancellationException);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable th) {
        return this.delegate.cancel(th);
    }

    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return this.delegate.fold(r, function2);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.delegate.get(key);
    }

    public CancellationException getCancellationException() {
        return this.delegate.getCancellationException();
    }

    public Sequence<Job> getChildren() {
        return this.delegate.getChildren();
    }

    public CoroutineContext.Key<?> getKey() {
        return this.delegate.getKey();
    }

    public SelectClause0 getOnJoin() {
        return this.delegate.getOnJoin();
    }

    public DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "handler");
        return this.delegate.invokeOnCompletion(function1);
    }

    public DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "handler");
        return this.delegate.invokeOnCompletion(z, z2, function1);
    }

    public boolean isActive() {
        return this.delegate.isActive();
    }

    public boolean isCancelled() {
        return this.delegate.isCancelled();
    }

    public boolean isCompleted() {
        return this.delegate.isCompleted();
    }

    public Object join(Continuation<? super Unit> continuation) {
        return this.delegate.join(continuation);
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.delegate.minusKey(key);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        return this.delegate.plus(coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public Job plus(Job job) {
        Intrinsics.checkNotNullParameter(job, "other");
        return this.delegate.plus(job);
    }

    public boolean start() {
        return this.delegate.start();
    }

    public ChannelJob(Job job, ByteChannel byteChannel) {
        Intrinsics.checkNotNullParameter(job, "delegate");
        Intrinsics.checkNotNullParameter(byteChannel, "channel");
        this.delegate = job;
        this.channel = byteChannel;
    }

    public ByteChannel getChannel() {
        return this.channel;
    }

    public String toString() {
        return "ChannelJob[" + this.delegate + ']';
    }
}
