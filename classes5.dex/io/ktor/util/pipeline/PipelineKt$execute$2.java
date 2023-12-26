package io.ktor.util.pipeline;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "TContext", ""}, k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.util.pipeline.PipelineKt$execute$2", f = "Pipeline.kt", i = {}, l = {478}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Pipeline.kt */
public final class PipelineKt$execute$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ TContext $context;
    final /* synthetic */ Pipeline<Unit, TContext> $this_execute;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PipelineKt$execute$2(Pipeline<Unit, TContext> pipeline, TContext tcontext, Continuation<? super PipelineKt$execute$2> continuation) {
        super(1, continuation);
        this.$this_execute = pipeline;
        this.$context = tcontext;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return (Continuation) new PipelineKt$execute$2(this.$this_execute, this.$context, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$this_execute.execute(this.$context, Unit.INSTANCE, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
