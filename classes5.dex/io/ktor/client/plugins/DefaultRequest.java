package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLProtocol;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.KtorDsl;
import io.ktor.util.StringValuesKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB \b\u0002\u0012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u0007R\u001f\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lio/ktor/client/plugins/DefaultRequest;", "", "block", "Lkotlin/Function1;", "Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "DefaultRequestBuilder", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultRequest.kt */
public final class DefaultRequest {
    public static final Plugin Plugin = new Plugin((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AttributeKey<DefaultRequest> key = new AttributeKey<>("DefaultRequest");
    /* access modifiers changed from: private */
    public final Function1<DefaultRequestBuilder, Unit> block;

    public /* synthetic */ DefaultRequest(Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1);
    }

    private DefaultRequest(Function1<? super DefaultRequestBuilder, Unit> function1) {
        this.block = function1;
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J!\u0010\u0018\u001a\u00020\u00032\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u001a¢\u0006\u0002\b\u001bH\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001c"}, d2 = {"Lio/ktor/client/plugins/DefaultRequest$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "Lio/ktor/client/plugins/DefaultRequest;", "()V", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "concatenatePath", "", "", "parent", "child", "install", "", "plugin", "scope", "Lio/ktor/client/HttpClient;", "mergeUrls", "baseUrl", "Lio/ktor/http/Url;", "requestUrl", "Lio/ktor/http/URLBuilder;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultRequest.kt */
    public static final class Plugin implements HttpClientPlugin<DefaultRequestBuilder, DefaultRequest> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Plugin() {
        }

        public AttributeKey<DefaultRequest> getKey() {
            return DefaultRequest.key;
        }

        public DefaultRequest prepare(Function1<? super DefaultRequestBuilder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            return new DefaultRequest(function1, (DefaultConstructorMarker) null);
        }

        public void install(DefaultRequest defaultRequest, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(defaultRequest, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            httpClient.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getBefore(), new DefaultRequest$Plugin$install$1(defaultRequest, (Continuation<? super DefaultRequest$Plugin$install$1>) null));
        }

        /* access modifiers changed from: private */
        public final void mergeUrls(Url url, URLBuilder uRLBuilder) {
            if (Intrinsics.areEqual(uRLBuilder.getProtocol(), URLProtocol.Companion.getHTTP())) {
                uRLBuilder.setProtocol(url.getProtocol());
            }
            if (!(uRLBuilder.getHost().length() > 0)) {
                URLBuilder URLBuilder = URLUtilsKt.URLBuilder(url);
                URLBuilder.setProtocol(uRLBuilder.getProtocol());
                if (uRLBuilder.getPort() != 0) {
                    URLBuilder.setPort(uRLBuilder.getPort());
                }
                URLBuilder.setEncodedPathSegments(DefaultRequest.Plugin.concatenatePath(URLBuilder.getEncodedPathSegments(), uRLBuilder.getEncodedPathSegments()));
                if (uRLBuilder.getEncodedFragment().length() > 0) {
                    URLBuilder.setEncodedFragment(uRLBuilder.getEncodedFragment());
                }
                ParametersBuilder ParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
                StringValuesKt.appendAll(ParametersBuilder$default, URLBuilder.getEncodedParameters());
                URLBuilder.setEncodedParameters(uRLBuilder.getEncodedParameters());
                for (Map.Entry entry : ParametersBuilder$default.entries()) {
                    String str = (String) entry.getKey();
                    List list = (List) entry.getValue();
                    if (!URLBuilder.getEncodedParameters().contains(str)) {
                        URLBuilder.getEncodedParameters().appendAll(str, list);
                    }
                }
                URLUtilsKt.takeFrom(uRLBuilder, URLBuilder);
            }
        }

        private final List<String> concatenatePath(List<String> list, List<String> list2) {
            if (list2.isEmpty()) {
                return list;
            }
            if (list.isEmpty()) {
                return list2;
            }
            if (((CharSequence) CollectionsKt.first(list2)).length() == 0) {
                return list2;
            }
            List createListBuilder = CollectionsKt.createListBuilder((list.size() + list2.size()) - 1);
            int size = list.size() - 1;
            for (int i = 0; i < size; i++) {
                createListBuilder.add(list.get(i));
            }
            createListBuilder.addAll(list2);
            return CollectionsKt.build(createListBuilder);
        }
    }

    @KtorDsl
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u001f\u0010\u001c\u001a\u00020\u001d2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001f¢\u0006\u0002\b J\u001f\u0010\u0018\u001a\u00020\u001d2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001d0\u001f¢\u0006\u0002\b J\u000e\u0010\u0018\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\fJV\u0010\u0018\u001a\u00020\u001d2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f2\u0019\b\u0002\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001d0\u001f¢\u0006\u0002\b ¢\u0006\u0002\u0010$R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "Lio/ktor/http/HttpMessageBuilder;", "()V", "attributes", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "headers", "Lio/ktor/http/HeadersBuilder;", "getHeaders", "()Lio/ktor/http/HeadersBuilder;", "value", "", "host", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "", "port", "getPort", "()I", "setPort", "(I)V", "url", "Lio/ktor/http/URLBuilder;", "getUrl", "()Lio/ktor/http/URLBuilder;", "setAttributes", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "urlString", "scheme", "path", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultRequest.kt */
    public static final class DefaultRequestBuilder implements HttpMessageBuilder {
        private final Attributes attributes = AttributesJvmKt.Attributes(true);
        private final HeadersBuilder headers = new HeadersBuilder(0, 1, (DefaultConstructorMarker) null);
        private final URLBuilder url = new URLBuilder((URLProtocol) null, (String) null, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 511, (DefaultConstructorMarker) null);

        public DefaultRequestBuilder() {
        }

        public HeadersBuilder getHeaders() {
            return this.headers;
        }

        public final URLBuilder getUrl() {
            return this.url;
        }

        public final Attributes getAttributes() {
            return this.attributes;
        }

        public final void url(Function1<? super URLBuilder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            function1.invoke(this.url);
        }

        public static /* synthetic */ void url$default(DefaultRequestBuilder defaultRequestBuilder, String str, String str2, Integer num, String str3, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                num = null;
            }
            if ((i & 8) != 0) {
                str3 = null;
            }
            if ((i & 16) != 0) {
                function1 = (Function1) DefaultRequest$DefaultRequestBuilder$url$1.INSTANCE;
            }
            defaultRequestBuilder.url(str, str2, num, str3, function1);
        }

        public final void url(String str, String str2, Integer num, String str3, Function1<? super URLBuilder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            URLBuilderKt.set(this.url, str, str2, num, str3, function1);
        }

        public final void url(String str) {
            Intrinsics.checkNotNullParameter(str, "urlString");
            URLParserKt.takeFrom(this.url, str);
        }

        public final String getHost() {
            return this.url.getHost();
        }

        public final void setHost(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            this.url.setHost(str);
        }

        public final int getPort() {
            return this.url.getPort();
        }

        public final void setPort(int i) {
            this.url.setPort(i);
        }

        public final void setAttributes(Function1<? super Attributes, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            function1.invoke(this.attributes);
        }
    }
}
