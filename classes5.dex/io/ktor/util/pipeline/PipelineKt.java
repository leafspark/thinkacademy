package io.ktor.util.pipeline;

import io.ktor.util.debug.ContextUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002HHø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001az\u0010\u0007\u001a\u00020\u0001\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\t\u001a\u00020\n2;\b\b\u0010\u000b\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00020\r\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f¢\u0006\u0002\b\u000fH\bø\u0001\u0000¢\u0006\u0002\u0010\u0010*|\u0010\u0011\u001a\u0004\b\u0000\u0010\b\u001a\u0004\b\u0001\u0010\u0002\"5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00020\r\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f¢\u0006\u0002\b\u000f25\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00020\r\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f¢\u0006\u0002\b\u000f*p\b\u0000\u0010\u0012\u001a\u0004\b\u0000\u0010\b\u001a\u0004\b\u0001\u0010\u0002\".\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00020\r\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f2.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00020\r\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"execute", "", "TContext", "", "Lio/ktor/util/pipeline/Pipeline;", "context", "(Lio/ktor/util/pipeline/Pipeline;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercept", "TSubject", "phase", "Lio/ktor/util/pipeline/PipelinePhase;", "block", "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lio/ktor/util/pipeline/Pipeline;Lio/ktor/util/pipeline/PipelinePhase;Lkotlin/jvm/functions/Function3;)V", "PipelineInterceptor", "PipelineInterceptorFunction", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Pipeline.kt */
public final class PipelineKt {
    public static final <TContext> Object execute(Pipeline<Unit, TContext> pipeline, TContext tcontext, Continuation<? super Unit> continuation) {
        Object initContextInDebugMode = ContextUtilsKt.initContextInDebugMode(new PipelineKt$execute$2(pipeline, tcontext, (Continuation<? super PipelineKt$execute$2>) null), continuation);
        return initContextInDebugMode == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? initContextInDebugMode : Unit.INSTANCE;
    }

    private static final <TContext> Object execute$$forInline(Pipeline<Unit, TContext> pipeline, TContext tcontext, Continuation<? super Unit> continuation) {
        InlineMarker.mark(0);
        ContextUtilsKt.initContextInDebugMode(new PipelineKt$execute$2(pipeline, tcontext, (Continuation<? super PipelineKt$execute$2>) null), continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ <TSubject, TContext> void intercept(Pipeline<?, TContext> pipeline, PipelinePhase pipelinePhase, Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(pipeline, "<this>");
        Intrinsics.checkNotNullParameter(pipelinePhase, "phase");
        Intrinsics.checkNotNullParameter(function3, "block");
        Intrinsics.needClassReification();
        pipeline.intercept(pipelinePhase, new PipelineKt$intercept$1(function3, (Continuation<? super PipelineKt$intercept$1>) null));
    }
}
