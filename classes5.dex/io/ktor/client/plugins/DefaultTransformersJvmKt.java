package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"platformRequestDefaultTransform", "Lio/ktor/http/content/OutgoingContent;", "contentType", "Lio/ktor/http/ContentType;", "context", "Lio/ktor/client/request/HttpRequestBuilder;", "body", "", "platformResponseDefaultTransformers", "", "Lio/ktor/client/HttpClient;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultTransformersJvm.kt */
public final class DefaultTransformersJvmKt {
    public static final void platformResponseDefaultTransformers(HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "<this>");
        httpClient.getResponsePipeline().intercept(HttpResponsePipeline.Phases.getParse(), new DefaultTransformersJvmKt$platformResponseDefaultTransformers$1((Continuation<? super DefaultTransformersJvmKt$platformResponseDefaultTransformers$1>) null));
    }

    public static final OutgoingContent platformRequestDefaultTransform(ContentType contentType, HttpRequestBuilder httpRequestBuilder, Object obj) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "context");
        Intrinsics.checkNotNullParameter(obj, "body");
        if (obj instanceof InputStream) {
            return new DefaultTransformersJvmKt$platformRequestDefaultTransform$1(httpRequestBuilder, contentType, obj);
        }
        return null;
    }
}
