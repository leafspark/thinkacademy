package io.ktor.client.engine;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.HttpHeaders;
import io.ktor.http.UnsafeHeaderException;
import io.ktor.util.AttributeKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a9\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\b\b\u0000\u0010\u000f*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u000f0\u000e2\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u00020\n0\u0012¢\u0006\u0002\b\u0013\u001a\u001d\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001e\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"CALL_COROUTINE", "Lkotlinx/coroutines/CoroutineName;", "getCALL_COROUTINE", "()Lkotlinx/coroutines/CoroutineName;", "CLIENT_CONFIG", "Lio/ktor/util/AttributeKey;", "Lio/ktor/client/HttpClientConfig;", "getCLIENT_CONFIG", "()Lio/ktor/util/AttributeKey;", "validateHeaders", "", "request", "Lio/ktor/client/request/HttpRequestData;", "config", "Lio/ktor/client/engine/HttpClientEngineFactory;", "T", "Lio/ktor/client/engine/HttpClientEngineConfig;", "nested", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "createCallContext", "Lkotlin/coroutines/CoroutineContext;", "Lio/ktor/client/engine/HttpClientEngine;", "parentJob", "Lkotlinx/coroutines/Job;", "(Lio/ktor/client/engine/HttpClientEngine;Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpClientEngine.kt */
public final class HttpClientEngineKt {
    private static final CoroutineName CALL_COROUTINE = new CoroutineName("call-context");
    private static final AttributeKey<HttpClientConfig<?>> CLIENT_CONFIG = new AttributeKey<>("client-config");

    public static final CoroutineName getCALL_COROUTINE() {
        return CALL_COROUTINE;
    }

    public static final AttributeKey<HttpClientConfig<?>> getCLIENT_CONFIG() {
        return CLIENT_CONFIG;
    }

    public static final <T extends HttpClientEngineConfig> HttpClientEngineFactory<T> config(HttpClientEngineFactory<? extends T> httpClientEngineFactory, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpClientEngineFactory, "<this>");
        Intrinsics.checkNotNullParameter(function1, "nested");
        return new HttpClientEngineKt$config$1(httpClientEngineFactory, function1);
    }

    public static final Object createCallContext(HttpClientEngine httpClientEngine, Job job, Continuation<? super CoroutineContext> continuation) {
        Job Job = JobKt.Job(job);
        CoroutineContext plus = httpClientEngine.getCoroutineContext().plus((CoroutineContext) Job).plus(CALL_COROUTINE);
        Job job2 = continuation.getContext().get(Job.Key);
        if (job2 != null) {
            Job job3 = Job;
            job3.invokeOnCompletion(new UtilsKt$attachToUserJob$2(Job.DefaultImpls.invokeOnCompletion$default(job2, true, false, new UtilsKt$attachToUserJob$cleanupHandler$1(job3), 2, (Object) null)));
        }
        return plus;
    }

    /* access modifiers changed from: private */
    public static final void validateHeaders(HttpRequestData httpRequestData) {
        Collection arrayList = new ArrayList();
        for (Object next : httpRequestData.getHeaders().names()) {
            if (HttpHeaders.INSTANCE.getUnsafeHeadersList().contains((String) next)) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        if (!list.isEmpty()) {
            throw new UnsafeHeaderException(list.toString());
        }
    }
}
