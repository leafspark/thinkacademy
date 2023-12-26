package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.request.ClientUpgradeContent;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.URLProtocolKt;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpTimeout$Plugin$install$1", f = "HttpTimeout.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HttpTimeout.kt */
final class HttpTimeout$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpTimeout $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpTimeout$Plugin$install$1(HttpTimeout httpTimeout, HttpClient httpClient, Continuation<? super HttpTimeout$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = httpTimeout;
        this.$scope = httpClient;
    }

    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpTimeout$Plugin$install$1 httpTimeout$Plugin$install$1 = new HttpTimeout$Plugin$install$1(this.$plugin, this.$scope, continuation);
        httpTimeout$Plugin$install$1.L$0 = pipelineContext;
        return httpTimeout$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            if (URLProtocolKt.isWebsocket(((HttpRequestBuilder) pipelineContext.getContext()).getUrl().getProtocol()) || (((HttpRequestBuilder) pipelineContext.getContext()).getBody() instanceof ClientUpgradeContent)) {
                return Unit.INSTANCE;
            }
            HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeout.HttpTimeoutCapabilityConfiguration) ((HttpRequestBuilder) pipelineContext.getContext()).getCapabilityOrNull(HttpTimeout.Plugin);
            if (httpTimeoutCapabilityConfiguration == null && this.$plugin.hasNotNullTimeouts()) {
                httpTimeoutCapabilityConfiguration = new HttpTimeout.HttpTimeoutCapabilityConfiguration((Long) null, (Long) null, (Long) null, 7, (DefaultConstructorMarker) null);
                ((HttpRequestBuilder) pipelineContext.getContext()).setCapability(HttpTimeout.Plugin, httpTimeoutCapabilityConfiguration);
            }
            if (httpTimeoutCapabilityConfiguration != null) {
                HttpTimeout httpTimeout = this.$plugin;
                HttpClient httpClient = this.$scope;
                HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) pipelineContext.getContext();
                Long connectTimeoutMillis = httpTimeoutCapabilityConfiguration.getConnectTimeoutMillis();
                if (connectTimeoutMillis == null) {
                    connectTimeoutMillis = httpTimeout.connectTimeoutMillis;
                }
                httpTimeoutCapabilityConfiguration.setConnectTimeoutMillis(connectTimeoutMillis);
                Long socketTimeoutMillis = httpTimeoutCapabilityConfiguration.getSocketTimeoutMillis();
                if (socketTimeoutMillis == null) {
                    socketTimeoutMillis = httpTimeout.socketTimeoutMillis;
                }
                httpTimeoutCapabilityConfiguration.setSocketTimeoutMillis(socketTimeoutMillis);
                Long requestTimeoutMillis = httpTimeoutCapabilityConfiguration.getRequestTimeoutMillis();
                if (requestTimeoutMillis == null) {
                    requestTimeoutMillis = httpTimeout.requestTimeoutMillis;
                }
                httpTimeoutCapabilityConfiguration.setRequestTimeoutMillis(requestTimeoutMillis);
                Long requestTimeoutMillis2 = httpTimeoutCapabilityConfiguration.getRequestTimeoutMillis();
                if (requestTimeoutMillis2 == null) {
                    requestTimeoutMillis2 = httpTimeout.requestTimeoutMillis;
                }
                if (!(requestTimeoutMillis2 == null || requestTimeoutMillis2.longValue() == HttpTimeout.INFINITE_TIMEOUT_MS)) {
                    httpRequestBuilder.getExecutionContext().invokeOnCompletion(new HttpTimeout$Plugin$install$1$1$1(BuildersKt__Builders_commonKt.launch$default(httpClient, (CoroutineContext) null, (CoroutineStart) null, new HttpTimeout$Plugin$install$1$1$killer$1(requestTimeoutMillis2, httpRequestBuilder, httpRequestBuilder.getExecutionContext(), (Continuation<? super HttpTimeout$Plugin$install$1$1$killer$1>) null), 3, (Object) null)));
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
