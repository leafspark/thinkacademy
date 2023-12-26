package io.ktor.client.request;

import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ!\u0010 \u001a\u0004\u0018\u0001H!\"\u0004\b\u0000\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0\u001b¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020%H\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006&"}, d2 = {"Lio/ktor/client/request/HttpRequestData;", "", "url", "Lio/ktor/http/Url;", "method", "Lio/ktor/http/HttpMethod;", "headers", "Lio/ktor/http/Headers;", "body", "Lio/ktor/http/content/OutgoingContent;", "executionContext", "Lkotlinx/coroutines/Job;", "attributes", "Lio/ktor/util/Attributes;", "(Lio/ktor/http/Url;Lio/ktor/http/HttpMethod;Lio/ktor/http/Headers;Lio/ktor/http/content/OutgoingContent;Lkotlinx/coroutines/Job;Lio/ktor/util/Attributes;)V", "getAttributes", "()Lio/ktor/util/Attributes;", "getBody", "()Lio/ktor/http/content/OutgoingContent;", "getExecutionContext", "()Lkotlinx/coroutines/Job;", "getHeaders", "()Lio/ktor/http/Headers;", "getMethod", "()Lio/ktor/http/HttpMethod;", "requiredCapabilities", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "getRequiredCapabilities$ktor_client_core", "()Ljava/util/Set;", "getUrl", "()Lio/ktor/http/Url;", "getCapabilityOrNull", "T", "key", "(Lio/ktor/client/engine/HttpClientEngineCapability;)Ljava/lang/Object;", "toString", "", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpRequest.kt */
public final class HttpRequestData {
    private final Attributes attributes;
    private final OutgoingContent body;
    private final Job executionContext;
    private final Headers headers;
    private final HttpMethod method;
    private final Set<HttpClientEngineCapability<?>> requiredCapabilities;
    private final Url url;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0039, code lost:
        r2 = r2.keySet();
     */
    @io.ktor.util.InternalAPI
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequestData(io.ktor.http.Url r2, io.ktor.http.HttpMethod r3, io.ktor.http.Headers r4, io.ktor.http.content.OutgoingContent r5, kotlinx.coroutines.Job r6, io.ktor.util.Attributes r7) {
        /*
            r1 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "method"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "body"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "executionContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "attributes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r1.<init>()
            r1.url = r2
            r1.method = r3
            r1.headers = r4
            r1.body = r5
            r1.executionContext = r6
            r1.attributes = r7
            io.ktor.util.AttributeKey r2 = io.ktor.client.engine.HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY()
            java.lang.Object r2 = r7.getOrNull(r2)
            java.util.Map r2 = (java.util.Map) r2
            if (r2 == 0) goto L_0x003f
            java.util.Set r2 = r2.keySet()
            if (r2 != 0) goto L_0x0043
        L_0x003f:
            java.util.Set r2 = kotlin.collections.SetsKt.emptySet()
        L_0x0043:
            r1.requiredCapabilities = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.request.HttpRequestData.<init>(io.ktor.http.Url, io.ktor.http.HttpMethod, io.ktor.http.Headers, io.ktor.http.content.OutgoingContent, kotlinx.coroutines.Job, io.ktor.util.Attributes):void");
    }

    public final Url getUrl() {
        return this.url;
    }

    public final HttpMethod getMethod() {
        return this.method;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final OutgoingContent getBody() {
        return this.body;
    }

    public final Job getExecutionContext() {
        return this.executionContext;
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final <T> T getCapabilityOrNull(HttpClientEngineCapability<T> httpClientEngineCapability) {
        Intrinsics.checkNotNullParameter(httpClientEngineCapability, "key");
        Map map = (Map) this.attributes.getOrNull(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY());
        if (map != null) {
            return map.get(httpClientEngineCapability);
        }
        return null;
    }

    public final Set<HttpClientEngineCapability<?>> getRequiredCapabilities$ktor_client_core() {
        return this.requiredCapabilities;
    }

    public String toString() {
        return "HttpRequestData(url=" + this.url + ", method=" + this.method + ')';
    }
}
