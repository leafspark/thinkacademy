package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"defaultTransformers", "", "Lio/ktor/client/HttpClient;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultTransform.kt */
public final class DefaultTransformKt {
    public static final void defaultTransformers(HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "<this>");
        httpClient.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getRender(), new DefaultTransformKt$defaultTransformers$1((Continuation<? super DefaultTransformKt$defaultTransformers$1>) null));
        httpClient.getResponsePipeline().intercept(HttpResponsePipeline.Phases.getParse(), new DefaultTransformKt$defaultTransformers$2((Continuation<? super DefaultTransformKt$defaultTransformers$2>) null));
        DefaultTransformersJvmKt.platformResponseDefaultTransformers(httpClient);
    }
}
