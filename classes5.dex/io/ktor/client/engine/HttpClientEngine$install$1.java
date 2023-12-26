package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ClientEventsKt;
import io.ktor.client.utils.EmptyContent;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "content"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$install$1", f = "HttpClientEngine.kt", i = {0, 0}, l = {70, 82}, m = "invokeSuspend", n = {"$this$intercept", "requestData"}, s = {"L$0", "L$1"})
/* compiled from: HttpClientEngine.kt */
final class HttpClientEngine$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpClient $client;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ HttpClientEngine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpClientEngine$install$1(HttpClient httpClient, HttpClientEngine httpClientEngine, Continuation<? super HttpClientEngine$install$1> continuation) {
        super(3, continuation);
        this.$client = httpClient;
        this.this$0 = httpClientEngine;
    }

    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpClientEngine$install$1 httpClientEngine$install$1 = new HttpClientEngine$install$1(this.$client, this.this$0, continuation);
        httpClientEngine$install$1.L$0 = pipelineContext;
        httpClientEngine$install$1.L$1 = obj;
        return httpClientEngine$install$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        PipelineContext pipelineContext;
        HttpRequestData httpRequestData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PipelineContext pipelineContext2 = (PipelineContext) this.L$0;
            Object obj2 = this.L$1;
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            httpRequestBuilder.takeFromWithExecutionContext((HttpRequestBuilder) pipelineContext2.getContext());
            if (obj2 == null) {
                httpRequestBuilder.setBody(EmptyContent.INSTANCE);
                httpRequestBuilder.setBodyType((TypeInfo) null);
            } else if (obj2 instanceof OutgoingContent) {
                httpRequestBuilder.setBody(obj2);
                httpRequestBuilder.setBodyType((TypeInfo) null);
            } else {
                httpRequestBuilder.setBody(obj2);
                KType typeOf = Reflection.typeOf(Object.class);
                httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(Object.class), typeOf));
            }
            this.$client.getMonitor().raise(ClientEventsKt.getHttpRequestIsReadyForSending(), httpRequestBuilder);
            httpRequestData = httpRequestBuilder.build();
            httpRequestData.getAttributes().put(HttpClientEngineKt.getCLIENT_CONFIG(), this.$client.getConfig$ktor_client_core());
            HttpClientEngineKt.validateHeaders(httpRequestData);
            HttpClientEngine.DefaultImpls.checkExtensions(this.this$0, httpRequestData);
            this.L$0 = pipelineContext2;
            this.L$1 = httpRequestData;
            this.label = 1;
            Object access$executeWithinCallContext = HttpClientEngine.DefaultImpls.executeWithinCallContext(this.this$0, httpRequestData, (Continuation) this);
            if (access$executeWithinCallContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj3 = access$executeWithinCallContext;
            pipelineContext = pipelineContext2;
            obj = obj3;
        } else if (i == 1) {
            httpRequestData = (HttpRequestData) this.L$1;
            pipelineContext = (PipelineContext) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        HttpClientCall httpClientCall = new HttpClientCall(this.$client, httpRequestData, (HttpResponseData) obj);
        final HttpResponse response = httpClientCall.getResponse();
        this.$client.getMonitor().raise(ClientEventsKt.getHttpResponseReceived(), response);
        Job job = JobKt.getJob(response.getCoroutineContext());
        final HttpClient httpClient = this.$client;
        job.invokeOnCompletion(new Function1<Throwable, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                if (th != null) {
                    httpClient.getMonitor().raise(ClientEventsKt.getHttpResponseCancelled(), response);
                }
            }
        });
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (pipelineContext.proceedWith(httpClientCall, (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
