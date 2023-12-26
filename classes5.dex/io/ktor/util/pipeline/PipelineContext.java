package io.ktor.util.pipeline;

import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006J\u001b\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0000H @ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H&J\u0011\u0010\u0013\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u0013\u0010\u0005\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u00028\u0000X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "TSubject", "", "TContext", "Lkotlinx/coroutines/CoroutineScope;", "context", "(Ljava/lang/Object;)V", "getContext", "()Ljava/lang/Object;", "Ljava/lang/Object;", "subject", "getSubject", "setSubject", "execute", "initial", "execute$ktor_utils", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finish", "", "proceed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "proceedWith", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
@KtorDsl
/* compiled from: PipelineContext.kt */
public abstract class PipelineContext<TSubject, TContext> implements CoroutineScope {
    private final TContext context;

    public abstract Object execute$ktor_utils(TSubject tsubject, Continuation<? super TSubject> continuation);

    public abstract void finish();

    public abstract TSubject getSubject();

    public abstract Object proceed(Continuation<? super TSubject> continuation);

    public abstract Object proceedWith(TSubject tsubject, Continuation<? super TSubject> continuation);

    public abstract void setSubject(TSubject tsubject);

    public PipelineContext(TContext tcontext) {
        Intrinsics.checkNotNullParameter(tcontext, "context");
        this.context = tcontext;
    }

    public final TContext getContext() {
        return this.context;
    }
}
