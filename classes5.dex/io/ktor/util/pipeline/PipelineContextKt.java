package io.ktor.util.pipeline;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00032H\u0010\u0006\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bj\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003`\u000b0\u00072\u0006\u0010\f\u001a\u0002H\u00022\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"pipelineContextFor", "Lio/ktor/util/pipeline/PipelineContext;", "TSubject", "TContext", "", "context", "interceptors", "", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "Lio/ktor/util/pipeline/PipelineInterceptorFunction;", "subject", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "debugMode", "", "(Ljava/lang/Object;Ljava/util/List;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;Z)Lio/ktor/util/pipeline/PipelineContext;", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PipelineContext.kt */
public final class PipelineContextKt {
    public static /* synthetic */ PipelineContext pipelineContextFor$default(Object obj, List list, Object obj2, CoroutineContext coroutineContext, boolean z, int i, Object obj3) {
        if ((i & 16) != 0) {
            z = false;
        }
        return pipelineContextFor(obj, list, obj2, coroutineContext, z);
    }

    public static final <TSubject, TContext> PipelineContext<TSubject, TContext> pipelineContextFor(TContext tcontext, List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> list, TSubject tsubject, CoroutineContext coroutineContext, boolean z) {
        Intrinsics.checkNotNullParameter(tcontext, "context");
        Intrinsics.checkNotNullParameter(list, "interceptors");
        Intrinsics.checkNotNullParameter(tsubject, "subject");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        if (z) {
            return new DebugPipelineContext<>(tcontext, list, tsubject, coroutineContext);
        }
        return new SuspendFunctionGun<>(tsubject, tcontext, list);
    }
}
