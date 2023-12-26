package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessage;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.content.TextContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fBM\b\u0000\u0012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003\u0012\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\n\u0010\n\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\u001d\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\u001a\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00060\u0004j\u0002`\u0005X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u0004j\u0002`\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lio/ktor/client/plugins/HttpPlainText;", "", "charsets", "", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "charsetQuality", "", "", "sendCharset", "responseCharsetFallback", "(Ljava/util/Set;Ljava/util/Map;Ljava/nio/charset/Charset;Ljava/nio/charset/Charset;)V", "acceptCharsetHeader", "", "requestCharset", "addCharsetHeaders", "", "context", "Lio/ktor/client/request/HttpRequestBuilder;", "addCharsetHeaders$ktor_client_core", "read", "call", "Lio/ktor/client/call/HttpClientCall;", "body", "Lio/ktor/utils/io/core/Input;", "read$ktor_client_core", "wrapContent", "content", "requestContentType", "Lio/ktor/http/ContentType;", "Config", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpPlainText.kt */
public final class HttpPlainText {
    public static final Plugin Plugin = new Plugin((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AttributeKey<HttpPlainText> key = new AttributeKey<>("HttpPlainText");
    private final String acceptCharsetHeader;
    private final Charset requestCharset;
    private final Charset responseCharsetFallback;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: java.nio.charset.Charset} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpPlainText(java.util.Set<? extends java.nio.charset.Charset> r11, java.util.Map<java.nio.charset.Charset, java.lang.Float> r12, java.nio.charset.Charset r13, java.nio.charset.Charset r14) {
        /*
            r10 = this;
            java.lang.String r0 = "charsets"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "charsetQuality"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "responseCharsetFallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r10.<init>()
            r10.responseCharsetFallback = r14
            java.util.List r14 = kotlin.collections.MapsKt.toList(r12)
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            io.ktor.client.plugins.HttpPlainText$special$$inlined$sortedByDescending$1 r0 = new io.ktor.client.plugins.HttpPlainText$special$$inlined$sortedByDescending$1
            r0.<init>()
            java.util.Comparator r0 = (java.util.Comparator) r0
            java.util.List r14 = kotlin.collections.CollectionsKt.sortedWith(r14, r0)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r11 = r11.iterator()
        L_0x0032:
            boolean r1 = r11.hasNext()
            r2 = 1
            if (r1 == 0) goto L_0x004b
            java.lang.Object r1 = r11.next()
            r3 = r1
            java.nio.charset.Charset r3 = (java.nio.charset.Charset) r3
            boolean r3 = r12.containsKey(r3)
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x0032
            r0.add(r1)
            goto L_0x0032
        L_0x004b:
            java.util.List r0 = (java.util.List) r0
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            io.ktor.client.plugins.HttpPlainText$special$$inlined$sortedBy$1 r11 = new io.ktor.client.plugins.HttpPlainText$special$$inlined$sortedBy$1
            r11.<init>()
            java.util.Comparator r11 = (java.util.Comparator) r11
            java.util.List r11 = kotlin.collections.CollectionsKt.sortedWith(r0, r11)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r0 = r11
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0066:
            boolean r1 = r0.hasNext()
            java.lang.String r3 = ","
            r4 = 0
            if (r1 == 0) goto L_0x008c
            java.lang.Object r1 = r0.next()
            java.nio.charset.Charset r1 = (java.nio.charset.Charset) r1
            r5 = r12
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x007f
            r4 = r2
        L_0x007f:
            if (r4 == 0) goto L_0x0084
            r12.append(r3)
        L_0x0084:
            java.lang.String r1 = io.ktor.utils.io.charsets.CharsetJVMKt.getName(r1)
            r12.append(r1)
            goto L_0x0066
        L_0x008c:
            r0 = r14
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0093:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0106
            java.lang.Object r1 = r0.next()
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r5 = r1.component1()
            java.nio.charset.Charset r5 = (java.nio.charset.Charset) r5
            java.lang.Object r1 = r1.component2()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            r6 = r12
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x00ba
            r6 = r2
            goto L_0x00bb
        L_0x00ba:
            r6 = r4
        L_0x00bb:
            if (r6 == 0) goto L_0x00c0
            r12.append(r3)
        L_0x00c0:
            double r6 = (double) r1
            r8 = 0
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x00cf
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 > 0) goto L_0x00cf
            r6 = r2
            goto L_0x00d0
        L_0x00cf:
            r6 = r4
        L_0x00d0:
            if (r6 == 0) goto L_0x00fa
            r6 = 100
            float r6 = (float) r6
            float r6 = r6 * r1
            int r1 = kotlin.math.MathKt.roundToInt(r6)
            double r6 = (double) r1
            r8 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r6 = r6 / r8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = io.ktor.utils.io.charsets.CharsetJVMKt.getName(r5)
            r1.append(r5)
            java.lang.String r5 = ";q="
            r1.append(r5)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r12.append(r1)
            goto L_0x0093
        L_0x00fa:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Check failed."
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x0106:
            r0 = r12
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0110
            goto L_0x0111
        L_0x0110:
            r2 = r4
        L_0x0111:
            if (r2 == 0) goto L_0x011c
            java.nio.charset.Charset r0 = r10.responseCharsetFallback
            java.lang.String r0 = io.ktor.utils.io.charsets.CharsetJVMKt.getName(r0)
            r12.append(r0)
        L_0x011c:
            java.lang.String r12 = r12.toString()
            java.lang.String r0 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            r10.acceptCharsetHeader = r12
            if (r13 != 0) goto L_0x0147
            java.lang.Object r11 = kotlin.collections.CollectionsKt.firstOrNull(r11)
            r13 = r11
            java.nio.charset.Charset r13 = (java.nio.charset.Charset) r13
            if (r13 != 0) goto L_0x0147
            java.lang.Object r11 = kotlin.collections.CollectionsKt.firstOrNull(r14)
            kotlin.Pair r11 = (kotlin.Pair) r11
            if (r11 == 0) goto L_0x0141
            java.lang.Object r11 = r11.getFirst()
            java.nio.charset.Charset r11 = (java.nio.charset.Charset) r11
            goto L_0x0142
        L_0x0141:
            r11 = 0
        L_0x0142:
            r13 = r11
            if (r13 != 0) goto L_0x0147
            java.nio.charset.Charset r13 = kotlin.text.Charsets.UTF_8
        L_0x0147:
            r10.requestCharset = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpPlainText.<init>(java.util.Set, java.util.Map, java.nio.charset.Charset, java.nio.charset.Charset):void");
    }

    @KtorDsl
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0005j\u0002`\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001aR$\u0010\u0003\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u001b"}, d2 = {"Lio/ktor/client/plugins/HttpPlainText$Config;", "", "()V", "charsetQuality", "", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "", "getCharsetQuality$ktor_client_core", "()Ljava/util/Map;", "charsets", "", "getCharsets$ktor_client_core", "()Ljava/util/Set;", "responseCharsetFallback", "getResponseCharsetFallback", "()Ljava/nio/charset/Charset;", "setResponseCharsetFallback", "(Ljava/nio/charset/Charset;)V", "sendCharset", "getSendCharset", "setSendCharset", "register", "", "charset", "quality", "(Ljava/nio/charset/Charset;Ljava/lang/Float;)V", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpPlainText.kt */
    public static final class Config {
        private final Map<Charset, Float> charsetQuality = new LinkedHashMap();
        private final Set<Charset> charsets = new LinkedHashSet();
        private Charset responseCharsetFallback = Charsets.UTF_8;
        private Charset sendCharset;

        public final Set<Charset> getCharsets$ktor_client_core() {
            return this.charsets;
        }

        public final Map<Charset, Float> getCharsetQuality$ktor_client_core() {
            return this.charsetQuality;
        }

        public static /* synthetic */ void register$default(Config config, Charset charset, Float f, int i, Object obj) {
            if ((i & 2) != 0) {
                f = null;
            }
            config.register(charset, f);
        }

        public final void register(Charset charset, Float f) {
            Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
            if (f != null) {
                double floatValue = (double) f.floatValue();
                boolean z = false;
                if (0.0d <= floatValue && floatValue <= 1.0d) {
                    z = true;
                }
                if (!z) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
            this.charsets.add(charset);
            if (f == null) {
                this.charsetQuality.remove(charset);
            } else {
                this.charsetQuality.put(charset, f);
            }
        }

        public final Charset getSendCharset() {
            return this.sendCharset;
        }

        public final void setSendCharset(Charset charset) {
            this.sendCharset = charset;
        }

        public final Charset getResponseCharsetFallback() {
            return this.responseCharsetFallback;
        }

        public final void setResponseCharsetFallback(Charset charset) {
            Intrinsics.checkNotNullParameter(charset, "<set-?>");
            this.responseCharsetFallback = charset;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J!\u0010\u000e\u001a\u00020\u00032\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0002\b\u0011H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/HttpPlainText$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/HttpPlainText$Config;", "Lio/ktor/client/plugins/HttpPlainText;", "()V", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "", "plugin", "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpPlainText.kt */
    public static final class Plugin implements HttpClientPlugin<Config, HttpPlainText> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Plugin() {
        }

        public AttributeKey<HttpPlainText> getKey() {
            return HttpPlainText.key;
        }

        public HttpPlainText prepare(Function1<? super Config, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config();
            function1.invoke(config);
            return new HttpPlainText(config.getCharsets$ktor_client_core(), config.getCharsetQuality$ktor_client_core(), config.getSendCharset(), config.getResponseCharsetFallback());
        }

        public void install(HttpPlainText httpPlainText, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpPlainText, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            httpClient.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getRender(), new HttpPlainText$Plugin$install$1(httpPlainText, (Continuation<? super HttpPlainText$Plugin$install$1>) null));
            httpClient.getResponsePipeline().intercept(HttpResponsePipeline.Phases.getTransform(), new HttpPlainText$Plugin$install$2(httpPlainText, (Continuation<? super HttpPlainText$Plugin$install$2>) null));
        }
    }

    /* access modifiers changed from: private */
    public final Object wrapContent(String str, ContentType contentType) {
        Charset charset;
        ContentType plain = contentType == null ? ContentType.Text.INSTANCE.getPlain() : contentType;
        if (contentType == null || (charset = ContentTypesKt.charset(contentType)) == null) {
            charset = this.requestCharset;
        }
        return new TextContent(str, ContentTypesKt.withCharset(plain, charset), (HttpStatusCode) null, 4, (DefaultConstructorMarker) null);
    }

    public final String read$ktor_client_core(HttpClientCall httpClientCall, Input input) {
        Intrinsics.checkNotNullParameter(httpClientCall, "call");
        Intrinsics.checkNotNullParameter(input, "body");
        Charset charset = HttpMessagePropertiesKt.charset((HttpMessage) httpClientCall.getResponse());
        if (charset == null) {
            charset = this.responseCharsetFallback;
        }
        return StringsKt.readText$default(input, charset, 0, 2, (Object) null);
    }

    public final void addCharsetHeaders$ktor_client_core(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "context");
        if (httpRequestBuilder.getHeaders().get(HttpHeaders.INSTANCE.getAcceptCharset()) == null) {
            httpRequestBuilder.getHeaders().set(HttpHeaders.INSTANCE.getAcceptCharset(), this.acceptCharsetHeader);
        }
    }
}
