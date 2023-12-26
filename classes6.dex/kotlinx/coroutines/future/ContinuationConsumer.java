package kotlinx.coroutines.future;

import java.util.concurrent.CompletionException;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u0006\u0012\u0004\u0018\u0001H\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00018\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/future/ContinuationConsumer;", "T", "Ljava/util/function/BiConsumer;", "", "cont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/Continuation;)V", "accept", "", "result", "exception", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "kotlinx-coroutines-jdk8"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Future.kt */
final class ContinuationConsumer<T> implements BiConsumer<T, Throwable> {
    public volatile Continuation<? super T> cont;

    public ContinuationConsumer(Continuation<? super T> continuation) {
        this.cont = continuation;
    }

    public void accept(T t, Throwable th) {
        Throwable cause;
        Continuation<? super T> continuation = this.cont;
        if (continuation != null) {
            if (th == null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.constructor-impl(t));
                return;
            }
            CompletionException completionException = th instanceof CompletionException ? (CompletionException) th : null;
            if (!(completionException == null || (cause = completionException.getCause()) == null)) {
                th = cause;
            }
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(th)));
        }
    }
}
