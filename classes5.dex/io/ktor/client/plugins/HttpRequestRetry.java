package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 )2\u00020\u0001:\u0006&'()*+B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\u001eJ\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0012H\u0002JE\u0010\u0013\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2#\u0010\u0013\u001a\u001f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0002\b\u000e2\u0006\u0010\"\u001a\u00020#H\u0002JM\u0010\u0019\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2#\u0010\u0013\u001a\u001f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0002\b\u000e2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u001aH\u0002R/\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\nR%\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R%\u0010\u0010\u001a\u0019\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0002\b\u000eX\u0004¢\u0006\u0002\n\u0000R+\u0010\u0013\u001a\u001f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0002\b\u000eX\u0004¢\u0006\u0002\n\u0000R+\u0010\u0019\u001a\u001f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0002\b\u000eX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetry;", "", "configuration", "Lio/ktor/client/plugins/HttpRequestRetry$Configuration;", "(Lio/ktor/client/plugins/HttpRequestRetry$Configuration;)V", "delay", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/jvm/functions/Function2;", "delayMillis", "Lio/ktor/client/plugins/HttpRequestRetry$DelayContext;", "", "Lkotlin/ExtensionFunctionType;", "maxRetries", "modifyRequest", "Lio/ktor/client/plugins/HttpRequestRetry$ModifyRequestContext;", "Lio/ktor/client/request/HttpRequestBuilder;", "shouldRetry", "Lkotlin/Function3;", "Lio/ktor/client/plugins/HttpRequestRetry$ShouldRetryContext;", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/statement/HttpResponse;", "", "shouldRetryOnException", "", "intercept", "client", "Lio/ktor/client/HttpClient;", "intercept$ktor_client_core", "prepareRequest", "request", "retryCount", "call", "Lio/ktor/client/call/HttpClientCall;", "subRequest", "cause", "Configuration", "DelayContext", "ModifyRequestContext", "Plugin", "RetryEventData", "ShouldRetryContext", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpRequestRetry.kt */
public final class HttpRequestRetry {
    /* access modifiers changed from: private */
    public static final EventDefinition<RetryEventData> HttpRequestRetryEvent = new EventDefinition<>();
    public static final Plugin Plugin = new Plugin((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AttributeKey<HttpRequestRetry> key = new AttributeKey<>("RetryFeature");
    /* access modifiers changed from: private */
    public final Function2<Long, Continuation<? super Unit>, Object> delay;
    /* access modifiers changed from: private */
    public final Function2<DelayContext, Integer, Long> delayMillis;
    /* access modifiers changed from: private */
    public final int maxRetries;
    /* access modifiers changed from: private */
    public final Function2<ModifyRequestContext, HttpRequestBuilder, Unit> modifyRequest;
    /* access modifiers changed from: private */
    public final Function3<ShouldRetryContext, HttpRequest, HttpResponse, Boolean> shouldRetry;
    /* access modifiers changed from: private */
    public final Function3<ShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> shouldRetryOnException;

    public HttpRequestRetry(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.shouldRetry = configuration.getShouldRetry$ktor_client_core();
        this.shouldRetryOnException = configuration.getShouldRetryOnException$ktor_client_core();
        this.delayMillis = configuration.getDelayMillis$ktor_client_core();
        this.delay = configuration.getDelay$ktor_client_core();
        this.maxRetries = configuration.getMaxRetries();
        this.modifyRequest = configuration.getModifyRequest$ktor_client_core();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetry$ShouldRetryContext;", "", "retryCount", "", "(I)V", "getRetryCount", "()I", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpRequestRetry.kt */
    public static final class ShouldRetryContext {
        private final int retryCount;

        public ShouldRetryContext(int i) {
            this.retryCount = i;
        }

        public final int getRetryCount() {
            return this.retryCount;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetry$DelayContext;", "", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "response", "Lio/ktor/client/statement/HttpResponse;", "cause", "", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/statement/HttpResponse;Ljava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "getRequest", "()Lio/ktor/client/request/HttpRequestBuilder;", "getResponse", "()Lio/ktor/client/statement/HttpResponse;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpRequestRetry.kt */
    public static final class DelayContext {
        private final Throwable cause;
        private final HttpRequestBuilder request;
        private final HttpResponse response;

        public DelayContext(HttpRequestBuilder httpRequestBuilder, HttpResponse httpResponse, Throwable th) {
            Intrinsics.checkNotNullParameter(httpRequestBuilder, "request");
            this.request = httpRequestBuilder;
            this.response = httpResponse;
            this.cause = th;
        }

        public final HttpRequestBuilder getRequest() {
            return this.request;
        }

        public final HttpResponse getResponse() {
            return this.response;
        }

        public final Throwable getCause() {
            return this.cause;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B+\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetry$ModifyRequestContext;", "", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "response", "Lio/ktor/client/statement/HttpResponse;", "cause", "", "retryCount", "", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/statement/HttpResponse;Ljava/lang/Throwable;I)V", "getCause", "()Ljava/lang/Throwable;", "getRequest", "()Lio/ktor/client/request/HttpRequestBuilder;", "getResponse", "()Lio/ktor/client/statement/HttpResponse;", "getRetryCount", "()I", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpRequestRetry.kt */
    public static final class ModifyRequestContext {
        private final Throwable cause;
        private final HttpRequestBuilder request;
        private final HttpResponse response;
        private final int retryCount;

        public ModifyRequestContext(HttpRequestBuilder httpRequestBuilder, HttpResponse httpResponse, Throwable th, int i) {
            Intrinsics.checkNotNullParameter(httpRequestBuilder, "request");
            this.request = httpRequestBuilder;
            this.response = httpResponse;
            this.cause = th;
            this.retryCount = i;
        }

        public final HttpRequestBuilder getRequest() {
            return this.request;
        }

        public final HttpResponse getResponse() {
            return this.response;
        }

        public final Throwable getCause() {
            return this.cause;
        }

        public final int getRetryCount() {
            return this.retryCount;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\u0018\u00002\u00020\u0001B+\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetry$RetryEventData;", "", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "retryCount", "", "response", "Lio/ktor/client/statement/HttpResponse;", "cause", "", "(Lio/ktor/client/request/HttpRequestBuilder;ILio/ktor/client/statement/HttpResponse;Ljava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "getRequest", "()Lio/ktor/client/request/HttpRequestBuilder;", "getResponse", "()Lio/ktor/client/statement/HttpResponse;", "getRetryCount", "()I", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpRequestRetry.kt */
    public static final class RetryEventData {
        private final Throwable cause;
        private final HttpRequestBuilder request;
        private final HttpResponse response;
        private final int retryCount;

        public RetryEventData(HttpRequestBuilder httpRequestBuilder, int i, HttpResponse httpResponse, Throwable th) {
            Intrinsics.checkNotNullParameter(httpRequestBuilder, "request");
            this.request = httpRequestBuilder;
            this.retryCount = i;
            this.response = httpResponse;
            this.cause = th;
        }

        public final HttpRequestBuilder getRequest() {
            return this.request;
        }

        public final int getRetryCount() {
            return this.retryCount;
        }

        public final HttpResponse getResponse() {
            return this.response;
        }

        public final Throwable getCause() {
            return this.cause;
        }
    }

    @KtorDsl
    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010+\u001a\u00020\u00072\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020\"J2\u0010\u0003\u001a\u00020\u00072\"\u0010/\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ>\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020\"2,\u0010/\u001a(\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0010J.\u00103\u001a\u00020\u00072\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020\"J%\u0010\u0018\u001a\u00020\u00072\u001d\u0010/\u001a\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\b\u0010J\u0006\u00107\u001a\u00020\u0007J\u0010\u00108\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0002J5\u00109\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u000f2#\u0010/\u001a\u001f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u001e¢\u0006\u0002\b\u0010J\u0010\u0010:\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u000fJ5\u0010;\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u000f2#\u0010/\u001a\u001f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\"0\u001e¢\u0006\u0002\b\u0010J\u0010\u0010<\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u000fJ\u0010\u0010=\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u000fR;\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004X\u000eø\u0001\u0000¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR1\u0010\r\u001a\u0019\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R1\u0010\u0018\u001a\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\b\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000bR7\u0010\u001d\u001a\u001f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u001e¢\u0006\u0002\b\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R7\u0010'\u001a\u001f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\"0\u001e¢\u0006\u0002\b\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetry$Configuration;", "", "()V", "delay", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "", "getDelay$ktor_client_core", "()Lkotlin/jvm/functions/Function2;", "setDelay$ktor_client_core", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "delayMillis", "Lio/ktor/client/plugins/HttpRequestRetry$DelayContext;", "", "Lkotlin/ExtensionFunctionType;", "getDelayMillis$ktor_client_core", "setDelayMillis$ktor_client_core", "maxRetries", "getMaxRetries", "()I", "setMaxRetries", "(I)V", "modifyRequest", "Lio/ktor/client/plugins/HttpRequestRetry$ModifyRequestContext;", "Lio/ktor/client/request/HttpRequestBuilder;", "getModifyRequest$ktor_client_core", "setModifyRequest$ktor_client_core", "shouldRetry", "Lkotlin/Function3;", "Lio/ktor/client/plugins/HttpRequestRetry$ShouldRetryContext;", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/statement/HttpResponse;", "", "getShouldRetry$ktor_client_core", "()Lkotlin/jvm/functions/Function3;", "setShouldRetry$ktor_client_core", "(Lkotlin/jvm/functions/Function3;)V", "shouldRetryOnException", "", "getShouldRetryOnException$ktor_client_core", "setShouldRetryOnException$ktor_client_core", "constantDelay", "millis", "randomizationMs", "respectRetryAfterHeader", "block", "Lkotlin/ParameterName;", "name", "retry", "exponentialDelay", "base", "", "maxDelayMs", "noRetry", "randomMs", "retryIf", "retryOnException", "retryOnExceptionIf", "retryOnExceptionOrServerErrors", "retryOnServerErrors", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpRequestRetry.kt */
    public static final class Configuration {
        private Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> delay = ((Function2) new HttpRequestRetry$Configuration$delay$1((Continuation<? super HttpRequestRetry$Configuration$delay$1>) null));
        public Function2<? super DelayContext, ? super Integer, Long> delayMillis;
        private int maxRetries;
        private Function2<? super ModifyRequestContext, ? super HttpRequestBuilder, Unit> modifyRequest = ((Function2) HttpRequestRetry$Configuration$modifyRequest$1.INSTANCE);
        public Function3<? super ShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> shouldRetry;
        public Function3<? super ShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> shouldRetryOnException;

        public Configuration() {
            retryOnExceptionOrServerErrors(3);
            exponentialDelay$default(this, 0.0d, 0, 0, false, 15, (Object) null);
        }

        public final Function3<ShouldRetryContext, HttpRequest, HttpResponse, Boolean> getShouldRetry$ktor_client_core() {
            Function3<? super ShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> function3 = this.shouldRetry;
            if (function3 != null) {
                return function3;
            }
            Intrinsics.throwUninitializedPropertyAccessException("shouldRetry");
            return null;
        }

        public final void setShouldRetry$ktor_client_core(Function3<? super ShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> function3) {
            Intrinsics.checkNotNullParameter(function3, "<set-?>");
            this.shouldRetry = function3;
        }

        public final Function3<ShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> getShouldRetryOnException$ktor_client_core() {
            Function3<? super ShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> function3 = this.shouldRetryOnException;
            if (function3 != null) {
                return function3;
            }
            Intrinsics.throwUninitializedPropertyAccessException("shouldRetryOnException");
            return null;
        }

        public final void setShouldRetryOnException$ktor_client_core(Function3<? super ShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> function3) {
            Intrinsics.checkNotNullParameter(function3, "<set-?>");
            this.shouldRetryOnException = function3;
        }

        public final Function2<DelayContext, Integer, Long> getDelayMillis$ktor_client_core() {
            Function2<? super DelayContext, ? super Integer, Long> function2 = this.delayMillis;
            if (function2 != null) {
                return function2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("delayMillis");
            return null;
        }

        public final void setDelayMillis$ktor_client_core(Function2<? super DelayContext, ? super Integer, Long> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.delayMillis = function2;
        }

        public final Function2<ModifyRequestContext, HttpRequestBuilder, Unit> getModifyRequest$ktor_client_core() {
            return this.modifyRequest;
        }

        public final void setModifyRequest$ktor_client_core(Function2<? super ModifyRequestContext, ? super HttpRequestBuilder, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.modifyRequest = function2;
        }

        public final Function2<Long, Continuation<? super Unit>, Object> getDelay$ktor_client_core() {
            return this.delay;
        }

        public final void setDelay$ktor_client_core(Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.delay = function2;
        }

        public final int getMaxRetries() {
            return this.maxRetries;
        }

        public final void setMaxRetries(int i) {
            this.maxRetries = i;
        }

        public final void noRetry() {
            this.maxRetries = 0;
            setShouldRetry$ktor_client_core(HttpRequestRetry$Configuration$noRetry$1.INSTANCE);
            setShouldRetryOnException$ktor_client_core(HttpRequestRetry$Configuration$noRetry$2.INSTANCE);
        }

        public final void modifyRequest(Function2<? super ModifyRequestContext, ? super HttpRequestBuilder, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "block");
            this.modifyRequest = function2;
        }

        public static /* synthetic */ void retryIf$default(Configuration configuration, int i, Function3 function3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = -1;
            }
            configuration.retryIf(i, function3);
        }

        public final void retryIf(int i, Function3<? super ShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> function3) {
            Intrinsics.checkNotNullParameter(function3, "block");
            if (i != -1) {
                this.maxRetries = i;
            }
            setShouldRetry$ktor_client_core(function3);
        }

        public static /* synthetic */ void retryOnExceptionIf$default(Configuration configuration, int i, Function3 function3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = -1;
            }
            configuration.retryOnExceptionIf(i, function3);
        }

        public final void retryOnExceptionIf(int i, Function3<? super ShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> function3) {
            Intrinsics.checkNotNullParameter(function3, "block");
            if (i != -1) {
                this.maxRetries = i;
            }
            setShouldRetryOnException$ktor_client_core(function3);
        }

        public static /* synthetic */ void retryOnException$default(Configuration configuration, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = -1;
            }
            configuration.retryOnException(i);
        }

        public final void retryOnException(int i) {
            retryOnExceptionIf(i, HttpRequestRetry$Configuration$retryOnException$1.INSTANCE);
        }

        public static /* synthetic */ void retryOnServerErrors$default(Configuration configuration, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = -1;
            }
            configuration.retryOnServerErrors(i);
        }

        public final void retryOnServerErrors(int i) {
            retryIf(i, HttpRequestRetry$Configuration$retryOnServerErrors$1.INSTANCE);
        }

        public static /* synthetic */ void retryOnExceptionOrServerErrors$default(Configuration configuration, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = -1;
            }
            configuration.retryOnExceptionOrServerErrors(i);
        }

        public final void retryOnExceptionOrServerErrors(int i) {
            retryOnServerErrors(i);
            retryOnException(i);
        }

        public static /* synthetic */ void delayMillis$default(Configuration configuration, boolean z, Function2 function2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            configuration.delayMillis(z, function2);
        }

        public final void delayMillis(boolean z, Function2<? super DelayContext, ? super Integer, Long> function2) {
            Intrinsics.checkNotNullParameter(function2, "block");
            setDelayMillis$ktor_client_core(new HttpRequestRetry$Configuration$delayMillis$1(z, function2));
        }

        public static /* synthetic */ void constantDelay$default(Configuration configuration, long j, long j2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                j = 1000;
            }
            if ((i & 2) != 0) {
                j2 = 1000;
            }
            if ((i & 4) != 0) {
                z = true;
            }
            configuration.constantDelay(j, j2, z);
        }

        public final void constantDelay(long j, long j2, boolean z) {
            boolean z2 = true;
            if (j > 0) {
                if (j2 < 0) {
                    z2 = false;
                }
                if (z2) {
                    delayMillis(z, new HttpRequestRetry$Configuration$constantDelay$1(j, this, j2));
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        public static /* synthetic */ void exponentialDelay$default(Configuration configuration, double d, long j, long j2, boolean z, int i, Object obj) {
            configuration.exponentialDelay((i & 1) != 0 ? 2.0d : d, (i & 2) != 0 ? 60000 : j, (i & 4) != 0 ? 1000 : j2, (i & 8) != 0 ? true : z);
        }

        public final void exponentialDelay(double d, long j, long j2, boolean z) {
            boolean z2 = true;
            if (d > 0.0d) {
                if (j > 0) {
                    if (j2 < 0) {
                        z2 = false;
                    }
                    if (z2) {
                        delayMillis(z, new HttpRequestRetry$Configuration$exponentialDelay$1(d, j, this, j2));
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        public final void delay(Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> function2) {
            Intrinsics.checkNotNullParameter(function2, "block");
            this.delay = function2;
        }

        /* access modifiers changed from: private */
        public final long randomMs(long j) {
            if (j == 0) {
                return 0;
            }
            return Random.Default.nextLong(j);
        }
    }

    public final void intercept$ktor_client_core(HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "client");
        ((HttpSend) HttpClientPluginKt.plugin(httpClient, HttpSend.Plugin)).intercept((Function3<? super Sender, ? super HttpRequestBuilder, ? super Continuation<? super HttpClientCall>, ? extends Object>) new HttpRequestRetry$intercept$1(this, httpClient, (Continuation<? super HttpRequestRetry$intercept$1>) null));
    }

    /* access modifiers changed from: private */
    public final boolean shouldRetry(int i, int i2, Function3<? super ShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> function3, HttpClientCall httpClientCall) {
        return i < i2 && ((Boolean) function3.invoke(new ShouldRetryContext(i + 1), httpClientCall.getRequest(), httpClientCall.getResponse())).booleanValue();
    }

    /* access modifiers changed from: private */
    public final boolean shouldRetryOnException(int i, int i2, Function3<? super ShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> function3, HttpRequestBuilder httpRequestBuilder, Throwable th) {
        return i < i2 && ((Boolean) function3.invoke(new ShouldRetryContext(i + 1), httpRequestBuilder, th)).booleanValue();
    }

    /* access modifiers changed from: private */
    public final HttpRequestBuilder prepareRequest(HttpRequestBuilder httpRequestBuilder) {
        HttpRequestBuilder takeFrom = new HttpRequestBuilder().takeFrom(httpRequestBuilder);
        CompletableJob Job$default = JobKt.Job$default((Job) null, 1, (Object) null);
        takeFrom.setExecutionContext$ktor_client_core(Job$default);
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(httpRequestBuilder.getExecutionContext()), (CoroutineContext) null, (CoroutineStart) null, new HttpRequestRetry$prepareRequest$1(Job$default, (Continuation<? super HttpRequestRetry$prepareRequest$1>) null), 3, (Object) null);
        httpRequestBuilder.getExecutionContext().invokeOnCompletion(new HttpRequestRetry$prepareRequest$2(Job$default));
        return takeFrom;
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J!\u0010\u0013\u001a\u00020\u00032\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\u0002\b\u0016H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetry$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/HttpRequestRetry$Configuration;", "Lio/ktor/client/plugins/HttpRequestRetry;", "()V", "HttpRequestRetryEvent", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/plugins/HttpRequestRetry$RetryEventData;", "getHttpRequestRetryEvent", "()Lio/ktor/events/EventDefinition;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "", "plugin", "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpRequestRetry.kt */
    public static final class Plugin implements HttpClientPlugin<Configuration, HttpRequestRetry> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Plugin() {
        }

        public AttributeKey<HttpRequestRetry> getKey() {
            return HttpRequestRetry.key;
        }

        public final EventDefinition<RetryEventData> getHttpRequestRetryEvent() {
            return HttpRequestRetry.HttpRequestRetryEvent;
        }

        public HttpRequestRetry prepare(Function1<? super Configuration, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Configuration configuration = new Configuration();
            function1.invoke(configuration);
            return new HttpRequestRetry(configuration);
        }

        public void install(HttpRequestRetry httpRequestRetry, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpRequestRetry, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            httpRequestRetry.intercept$ktor_client_core(httpClient);
        }
    }
}
