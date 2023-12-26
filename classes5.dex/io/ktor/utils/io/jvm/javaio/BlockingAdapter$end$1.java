package io.ktor.utils.io.jvm.javaio;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"io/ktor/utils/io/jvm/javaio/BlockingAdapter$end$1", "Lkotlin/coroutines/Continuation;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Blocking.kt */
public final class BlockingAdapter$end$1 implements Continuation<Unit> {
    private final CoroutineContext context;
    final /* synthetic */ BlockingAdapter this$0;

    BlockingAdapter$end$1(BlockingAdapter blockingAdapter) {
        this.this$0 = blockingAdapter;
        this.context = blockingAdapter.getParent() != null ? UnsafeBlockingTrampoline.INSTANCE.plus(blockingAdapter.getParent()) : (CoroutineContext) UnsafeBlockingTrampoline.INSTANCE;
    }

    public CoroutineContext getContext() {
        return this.context;
    }

    public void resumeWith(Object obj) {
        Object obj2;
        boolean z;
        Job parent;
        Throwable r0;
        Object r02 = Result.m323exceptionOrNullimpl(obj);
        if (r02 == null) {
            r02 = Unit.INSTANCE;
        }
        BlockingAdapter blockingAdapter = this.this$0;
        do {
            obj2 = blockingAdapter.state;
            z = obj2 instanceof Thread;
            if (!(z ? true : obj2 instanceof Continuation ? true : Intrinsics.areEqual(obj2, this))) {
                return;
            }
        } while (!BlockingAdapter.state$FU.compareAndSet(blockingAdapter, obj2, r02));
        if (z) {
            PollersKt.getParkingImpl().unpark(obj2);
        } else if ((obj2 instanceof Continuation) && (r0 = Result.m323exceptionOrNullimpl(obj)) != null) {
            Result.Companion companion = Result.Companion;
            ((Continuation) obj2).resumeWith(Result.m320constructorimpl(ResultKt.createFailure(r0)));
        }
        if (Result.m326isFailureimpl(obj) && !(Result.m323exceptionOrNullimpl(obj) instanceof CancellationException) && (parent = this.this$0.getParent()) != null) {
            Job.DefaultImpls.cancel$default(parent, (CancellationException) null, 1, (Object) null);
        }
        DisposableHandle access$getDisposable$p = this.this$0.disposable;
        if (access$getDisposable$p != null) {
            access$getDisposable$p.dispose();
        }
    }
}
