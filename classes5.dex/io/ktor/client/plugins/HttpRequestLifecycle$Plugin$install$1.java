package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestLifecycle$Plugin$install$1", f = "HttpRequestLifecycle.kt", i = {0}, l = {35}, m = "invokeSuspend", n = {"executionContext"}, s = {"L$0"})
/* compiled from: HttpRequestLifecycle.kt */
final class HttpRequestLifecycle$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpRequestLifecycle$Plugin$install$1(HttpClient httpClient, Continuation<? super HttpRequestLifecycle$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$scope = httpClient;
    }

    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpRequestLifecycle$Plugin$install$1 httpRequestLifecycle$Plugin$install$1 = new HttpRequestLifecycle$Plugin$install$1(this.$scope, continuation);
        httpRequestLifecycle$Plugin$install$1.L$0 = pipelineContext;
        return httpRequestLifecycle$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CompletableJob completableJob;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            CompletableJob Job = JobKt.Job(((HttpRequestBuilder) pipelineContext.getContext()).getExecutionContext());
            Job job = this.$scope.getCoroutineContext().get(Job.Key);
            Intrinsics.checkNotNull(job);
            HttpRequestLifecycleKt.attachToClientEngineJob(Job, job);
            try {
                ((HttpRequestBuilder) pipelineContext.getContext()).setExecutionContext$ktor_client_core(Job);
                this.L$0 = Job;
                this.label = 1;
                if (pipelineContext.proceed((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                completableJob = Job;
            } catch (Throwable th) {
                th = th;
                completableJob = Job;
                try {
                    completableJob.completeExceptionally(th);
                    throw th;
                } catch (Throwable th2) {
                    completableJob.complete();
                    throw th2;
                }
            }
        } else if (i == 1) {
            completableJob = (CompletableJob) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        completableJob.complete();
        return Unit.INSTANCE;
    }
}
