package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.util.InternalAPI;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b&\u0018\u00002\u00020\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\b8VX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/engine/HttpClientEngineBase;", "", "engineName", "<init>", "(Ljava/lang/String;)V", "", "close", "()V", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext$delegate", "Lkotlin/Lazy;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Ljava/lang/String;", "ktor-client-core", "Lio/ktor/client/engine/HttpClientEngine;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpClientEngineBase.kt */
public abstract class HttpClientEngineBase implements HttpClientEngine {
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClientEngineBase.class, "closed");
    private volatile /* synthetic */ int closed = 0;
    private final Lazy coroutineContext$delegate = LazyKt.lazy(new HttpClientEngineBase$coroutineContext$2(this));
    /* access modifiers changed from: private */
    public final String engineName;

    public HttpClientEngineBase(String str) {
        Intrinsics.checkNotNullParameter(str, "engineName");
        this.engineName = str;
    }

    public Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return HttpClientEngine.DefaultImpls.getSupportedCapabilities(this);
    }

    @InternalAPI
    public void install(HttpClient httpClient) {
        HttpClientEngine.DefaultImpls.install(this, httpClient);
    }

    public CoroutineContext getCoroutineContext() {
        return (CoroutineContext) this.coroutineContext$delegate.getValue();
    }

    public void close() {
        if (closed$FU.compareAndSet(this, 0, 1)) {
            CompletableJob completableJob = getCoroutineContext().get(Job.Key);
            CompletableJob completableJob2 = completableJob instanceof CompletableJob ? completableJob : null;
            if (completableJob2 != null) {
                completableJob2.complete();
                completableJob2.invokeOnCompletion(new HttpClientEngineBase$close$1(this));
            }
        }
    }
}
