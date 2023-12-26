package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.util.CoroutinesUtilsKt;
import io.ktor.util.InternalAPI;
import java.util.Objects;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0011\u0010\u001a\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bR\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R!\u0010\r\u001a\u00020\f8VX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\n\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lio/ktor/client/engine/HttpClientJvmEngine;", "Lio/ktor/client/engine/HttpClientEngine;", "engineName", "", "(Ljava/lang/String;)V", "_dispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "get_dispatcher", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "_dispatcher$delegate", "Lkotlin/Lazy;", "clientContext", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext$delegate", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher$annotations", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "close", "", "createCallContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.ERROR, message = "Use HttpClientEngineBase instead.", replaceWith = @ReplaceWith(expression = "HttpClientEngineBase", imports = {}))
/* compiled from: HttpClientJvmEngine.kt */
public abstract class HttpClientJvmEngine implements HttpClientEngine {
    private final Lazy _dispatcher$delegate = LazyKt.lazy(new HttpClientJvmEngine$_dispatcher$2(this));
    /* access modifiers changed from: private */
    public final CoroutineContext clientContext = CoroutinesUtilsKt.SilentSupervisor$default((Job) null, 1, (Object) null);
    private final Lazy coroutineContext$delegate;

    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    public static /* synthetic */ void getDispatcher$annotations() {
    }

    public HttpClientJvmEngine(String str) {
        Intrinsics.checkNotNullParameter(str, "engineName");
        this.coroutineContext$delegate = LazyKt.lazy(new HttpClientJvmEngine$coroutineContext$2(this, str));
    }

    public Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return HttpClientEngine.DefaultImpls.getSupportedCapabilities(this);
    }

    @InternalAPI
    public void install(HttpClient httpClient) {
        HttpClientEngine.DefaultImpls.install(this, httpClient);
    }

    /* access modifiers changed from: private */
    public final ExecutorCoroutineDispatcher get_dispatcher() {
        return (ExecutorCoroutineDispatcher) this._dispatcher$delegate.getValue();
    }

    public CoroutineDispatcher getDispatcher() {
        return get_dispatcher();
    }

    public CoroutineContext getCoroutineContext() {
        return (CoroutineContext) this.coroutineContext$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final Object createCallContext(Continuation<? super CoroutineContext> continuation) {
        CoroutineContext Job = JobKt.Job(this.clientContext.get(Job.Key));
        CoroutineContext plus = getCoroutineContext().plus(Job);
        Job job = continuation.getContext().get(Job.Key);
        Job.invokeOnCompletion(new HttpClientJvmEngine$createCallContext$2(job != null ? Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new HttpClientJvmEngine$createCallContext$onParentCancelCleanupHandle$1(plus), 2, (Object) null) : null));
        return plus;
    }

    public void close() {
        CompletableJob completableJob = this.clientContext.get(Job.Key);
        Objects.requireNonNull(completableJob, "null cannot be cast to non-null type kotlinx.coroutines.CompletableJob");
        CompletableJob completableJob2 = completableJob;
        completableJob2.complete();
        completableJob2.invokeOnCompletion(new HttpClientJvmEngine$close$1(this));
    }
}
