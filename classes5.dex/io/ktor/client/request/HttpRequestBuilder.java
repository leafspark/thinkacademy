package io.ktor.client.request;

import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.utils.EmptyContent;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.http.Parameters;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLProtocol;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.AttributesKt;
import io.ktor.util.InternalAPI;
import io.ktor.util.StringValuesKt;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 <2\u00020\u0001:\u0001<B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010)\u001a\u00020*J%\u0010+\u001a\u0004\u0018\u0001H,\"\b\b\u0000\u0010,*\u00020\b2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.¢\u0006\u0002\u0010/J\u001f\u00100\u001a\u0002012\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020103¢\u0006\u0002\b4J+\u00105\u001a\u000201\"\b\b\u0000\u0010,*\u00020\b2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.2\u0006\u00106\u001a\u0002H,¢\u0006\u0002\u00107J\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0000J\u0010\u0010:\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0000H\u0007J%\u0010%\u001a\u0002012\u001d\u00102\u001a\u0019\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u0002010;¢\u0006\u0002\b4R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F@GX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0015@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006="}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/http/HttpMessageBuilder;", "()V", "attributes", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "<set-?>", "", "body", "getBody", "()Ljava/lang/Object;", "setBody", "(Ljava/lang/Object;)V", "value", "Lio/ktor/util/reflect/TypeInfo;", "bodyType", "getBodyType", "()Lio/ktor/util/reflect/TypeInfo;", "setBodyType", "(Lio/ktor/util/reflect/TypeInfo;)V", "Lkotlinx/coroutines/Job;", "executionContext", "getExecutionContext", "()Lkotlinx/coroutines/Job;", "setExecutionContext$ktor_client_core", "(Lkotlinx/coroutines/Job;)V", "headers", "Lio/ktor/http/HeadersBuilder;", "getHeaders", "()Lio/ktor/http/HeadersBuilder;", "method", "Lio/ktor/http/HttpMethod;", "getMethod", "()Lio/ktor/http/HttpMethod;", "setMethod", "(Lio/ktor/http/HttpMethod;)V", "url", "Lio/ktor/http/URLBuilder;", "getUrl", "()Lio/ktor/http/URLBuilder;", "build", "Lio/ktor/client/request/HttpRequestData;", "getCapabilityOrNull", "T", "key", "Lio/ktor/client/engine/HttpClientEngineCapability;", "(Lio/ktor/client/engine/HttpClientEngineCapability;)Ljava/lang/Object;", "setAttributes", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "setCapability", "capability", "(Lio/ktor/client/engine/HttpClientEngineCapability;Ljava/lang/Object;)V", "takeFrom", "builder", "takeFromWithExecutionContext", "Lkotlin/Function2;", "Companion", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpRequest.kt */
public final class HttpRequestBuilder implements HttpMessageBuilder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Attributes attributes = AttributesJvmKt.Attributes(true);
    private Object body = EmptyContent.INSTANCE;
    private Job executionContext = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
    private final HeadersBuilder headers = new HeadersBuilder(0, 1, (DefaultConstructorMarker) null);
    private HttpMethod method = HttpMethod.Companion.getGet();
    private final URLBuilder url = new URLBuilder((URLProtocol) null, (String) null, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 511, (DefaultConstructorMarker) null);

    public final URLBuilder getUrl() {
        return this.url;
    }

    public final HttpMethod getMethod() {
        return this.method;
    }

    public final void setMethod(HttpMethod httpMethod) {
        Intrinsics.checkNotNullParameter(httpMethod, "<set-?>");
        this.method = httpMethod;
    }

    public HeadersBuilder getHeaders() {
        return this.headers;
    }

    public final Object getBody() {
        return this.body;
    }

    @InternalAPI
    public final void setBody(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.body = obj;
    }

    public final TypeInfo getBodyType() {
        return (TypeInfo) this.attributes.getOrNull(RequestBodyKt.getBodyTypeAttributeKey());
    }

    @InternalAPI
    public final void setBodyType(TypeInfo typeInfo) {
        if (typeInfo != null) {
            this.attributes.put(RequestBodyKt.getBodyTypeAttributeKey(), typeInfo);
        } else {
            this.attributes.remove(RequestBodyKt.getBodyTypeAttributeKey());
        }
    }

    public final Job getExecutionContext() {
        return this.executionContext;
    }

    public final void setExecutionContext$ktor_client_core(Job job) {
        Intrinsics.checkNotNullParameter(job, "<set-?>");
        this.executionContext = job;
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final void url(Function2<? super URLBuilder, ? super URLBuilder, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        URLBuilder uRLBuilder = this.url;
        function2.invoke(uRLBuilder, uRLBuilder);
    }

    public final HttpRequestData build() {
        Url build = this.url.build();
        HttpMethod httpMethod = this.method;
        Headers build2 = getHeaders().build();
        Object obj = this.body;
        OutgoingContent outgoingContent = obj instanceof OutgoingContent ? (OutgoingContent) obj : null;
        if (outgoingContent != null) {
            return new HttpRequestData(build, httpMethod, build2, outgoingContent, this.executionContext, this.attributes);
        }
        throw new IllegalStateException(("No request transformation found: " + this.body).toString());
    }

    public final void setAttributes(Function1<? super Attributes, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        function1.invoke(this.attributes);
    }

    @InternalAPI
    public final HttpRequestBuilder takeFromWithExecutionContext(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "builder");
        this.executionContext = httpRequestBuilder.executionContext;
        return takeFrom(httpRequestBuilder);
    }

    public final HttpRequestBuilder takeFrom(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "builder");
        this.method = httpRequestBuilder.method;
        this.body = httpRequestBuilder.body;
        setBodyType(httpRequestBuilder.getBodyType());
        URLUtilsKt.takeFrom(this.url, httpRequestBuilder.url);
        URLBuilder uRLBuilder = this.url;
        uRLBuilder.setEncodedPathSegments(uRLBuilder.getEncodedPathSegments());
        StringValuesKt.appendAll(getHeaders(), httpRequestBuilder.getHeaders());
        AttributesKt.putAll(this.attributes, httpRequestBuilder.attributes);
        return this;
    }

    public final <T> void setCapability(HttpClientEngineCapability<T> httpClientEngineCapability, T t) {
        Intrinsics.checkNotNullParameter(httpClientEngineCapability, "key");
        Intrinsics.checkNotNullParameter(t, "capability");
        ((Map) this.attributes.computeIfAbsent(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY(), HttpRequestBuilder$setCapability$capabilities$1.INSTANCE)).put(httpClientEngineCapability, t);
    }

    public final <T> T getCapabilityOrNull(HttpClientEngineCapability<T> httpClientEngineCapability) {
        Intrinsics.checkNotNullParameter(httpClientEngineCapability, "key");
        Map map = (Map) this.attributes.getOrNull(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY());
        if (map != null) {
            return map.get(httpClientEngineCapability);
        }
        return null;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder$Companion;", "", "()V", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
