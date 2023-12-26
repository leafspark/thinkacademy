package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"io/ktor/client/plugins/HttpCallValidatorKt$HttpRequest$1", "Lio/ktor/client/request/HttpRequest;", "attributes", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "call", "Lio/ktor/client/call/HttpClientCall;", "getCall", "()Lio/ktor/client/call/HttpClientCall;", "content", "Lio/ktor/http/content/OutgoingContent;", "getContent", "()Lio/ktor/http/content/OutgoingContent;", "headers", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "method", "Lio/ktor/http/HttpMethod;", "getMethod", "()Lio/ktor/http/HttpMethod;", "url", "Lio/ktor/http/Url;", "getUrl", "()Lio/ktor/http/Url;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpCallValidator.kt */
public final class HttpCallValidatorKt$HttpRequest$1 implements HttpRequest {
    final /* synthetic */ HttpRequestBuilder $builder;
    private final Attributes attributes;
    private final Headers headers;
    private final HttpMethod method;
    private final Url url;

    HttpCallValidatorKt$HttpRequest$1(HttpRequestBuilder httpRequestBuilder) {
        this.$builder = httpRequestBuilder;
        this.method = httpRequestBuilder.getMethod();
        this.url = httpRequestBuilder.getUrl().build();
        this.attributes = httpRequestBuilder.getAttributes();
        this.headers = httpRequestBuilder.getHeaders().build();
    }

    public CoroutineContext getCoroutineContext() {
        return HttpRequest.DefaultImpls.getCoroutineContext(this);
    }

    public HttpClientCall getCall() {
        throw new IllegalStateException("Call is not initialized".toString());
    }

    public HttpMethod getMethod() {
        return this.method;
    }

    public Url getUrl() {
        return this.url;
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    public Headers getHeaders() {
        return this.headers;
    }

    public OutgoingContent getContent() {
        Object body = this.$builder.getBody();
        OutgoingContent outgoingContent = body instanceof OutgoingContent ? (OutgoingContent) body : null;
        if (outgoingContent != null) {
            return outgoingContent;
        }
        throw new IllegalStateException(("Content was not transformed to OutgoingContent yet. Current body is " + this.$builder.getBody()).toString());
    }
}
