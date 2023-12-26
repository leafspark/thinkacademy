package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpTimeout$Plugin$install$1$1$killer$1", f = "HttpTimeout.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HttpTimeout.kt */
final class HttpTimeout$Plugin$install$1$1$killer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpRequestBuilder $context;
    final /* synthetic */ Job $executionContext;
    final /* synthetic */ Long $requestTimeout;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpTimeout$Plugin$install$1$1$killer$1(Long l, HttpRequestBuilder httpRequestBuilder, Job job, Continuation<? super HttpTimeout$Plugin$install$1$1$killer$1> continuation) {
        super(2, continuation);
        this.$requestTimeout = l;
        this.$context = httpRequestBuilder;
        this.$executionContext = job;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new HttpTimeout$Plugin$install$1$1$killer$1(this.$requestTimeout, this.$context, this.$executionContext, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(this.$requestTimeout.longValue(), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        HttpRequestTimeoutException httpRequestTimeoutException = new HttpRequestTimeoutException(this.$context);
        Job job = this.$executionContext;
        String message = httpRequestTimeoutException.getMessage();
        Intrinsics.checkNotNull(message);
        JobKt.cancel(job, message, httpRequestTimeoutException);
        return Unit.INSTANCE;
    }
}
