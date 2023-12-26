package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0002\u0006\u0007B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lio/ktor/client/plugins/HttpRedirect;", "", "checkHttpMethod", "", "allowHttpsDowngrade", "(ZZ)V", "Config", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpRedirect.kt */
public final class HttpRedirect {
    /* access modifiers changed from: private */
    public static final EventDefinition<HttpResponse> HttpResponseRedirect = new EventDefinition<>();
    public static final Plugin Plugin = new Plugin((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AttributeKey<HttpRedirect> key = new AttributeKey<>("HttpRedirect");
    /* access modifiers changed from: private */
    public final boolean allowHttpsDowngrade;
    /* access modifiers changed from: private */
    public final boolean checkHttpMethod;

    public /* synthetic */ HttpRedirect(boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2);
    }

    private HttpRedirect(boolean z, boolean z2) {
        this.checkHttpMethod = z;
        this.allowHttpsDowngrade = z2;
    }

    @KtorDsl
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lio/ktor/client/plugins/HttpRedirect$Config;", "", "()V", "allowHttpsDowngrade", "", "getAllowHttpsDowngrade", "()Z", "setAllowHttpsDowngrade", "(Z)V", "checkHttpMethod", "getCheckHttpMethod", "setCheckHttpMethod", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpRedirect.kt */
    public static final class Config {
        private boolean allowHttpsDowngrade;
        private boolean checkHttpMethod = true;

        public final boolean getCheckHttpMethod() {
            return this.checkHttpMethod;
        }

        public final void setCheckHttpMethod(boolean z) {
            this.checkHttpMethod = z;
        }

        public final boolean getAllowHttpsDowngrade() {
            return this.allowHttpsDowngrade;
        }

        public final void setAllowHttpsDowngrade(boolean z) {
            this.allowHttpsDowngrade = z;
        }
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J!\u0010\u0013\u001a\u00020\u00032\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\u0002\b\u0016H\u0016J5\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010 R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lio/ktor/client/plugins/HttpRedirect$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/HttpRedirect$Config;", "Lio/ktor/client/plugins/HttpRedirect;", "()V", "HttpResponseRedirect", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/statement/HttpResponse;", "getHttpResponseRedirect", "()Lio/ktor/events/EventDefinition;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "", "plugin", "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "handleCall", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/Sender;", "context", "Lio/ktor/client/request/HttpRequestBuilder;", "origin", "allowHttpsDowngrade", "", "client", "(Lio/ktor/client/plugins/Sender;Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/call/HttpClientCall;ZLio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpRedirect.kt */
    public static final class Plugin implements HttpClientPlugin<Config, HttpRedirect> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Plugin() {
        }

        public AttributeKey<HttpRedirect> getKey() {
            return HttpRedirect.key;
        }

        public final EventDefinition<HttpResponse> getHttpResponseRedirect() {
            return HttpRedirect.HttpResponseRedirect;
        }

        public HttpRedirect prepare(Function1<? super Config, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config();
            function1.invoke(config);
            return new HttpRedirect(config.getCheckHttpMethod(), config.getAllowHttpsDowngrade(), (DefaultConstructorMarker) null);
        }

        public void install(HttpRedirect httpRedirect, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpRedirect, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            ((HttpSend) HttpClientPluginKt.plugin(httpClient, HttpSend.Plugin)).intercept((Function3<? super Sender, ? super HttpRequestBuilder, ? super Continuation<? super HttpClientCall>, ? extends Object>) new HttpRedirect$Plugin$install$1(httpRedirect, httpClient, (Continuation<? super HttpRedirect$Plugin$install$1>) null));
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00d9  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00f6  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00f9  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0107  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0134 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0135  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0151  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object handleCall(io.ktor.client.plugins.Sender r10, io.ktor.client.request.HttpRequestBuilder r11, io.ktor.client.call.HttpClientCall r12, boolean r13, io.ktor.client.HttpClient r14, kotlin.coroutines.Continuation<? super io.ktor.client.call.HttpClientCall> r15) {
            /*
                r9 = this;
                boolean r0 = r15 instanceof io.ktor.client.plugins.HttpRedirect$Plugin$handleCall$1
                if (r0 == 0) goto L_0x0014
                r0 = r15
                io.ktor.client.plugins.HttpRedirect$Plugin$handleCall$1 r0 = (io.ktor.client.plugins.HttpRedirect$Plugin$handleCall$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L_0x0014
                int r15 = r0.label
                int r15 = r15 - r2
                r0.label = r15
                goto L_0x0019
            L_0x0014:
                io.ktor.client.plugins.HttpRedirect$Plugin$handleCall$1 r0 = new io.ktor.client.plugins.HttpRedirect$Plugin$handleCall$1
                r0.<init>(r9, r15)
            L_0x0019:
                java.lang.Object r15 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L_0x005a
                if (r2 != r3) goto L_0x0052
                boolean r10 = r0.Z$0
                java.lang.Object r11 = r0.L$7
                kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
                java.lang.Object r12 = r0.L$6
                java.lang.String r12 = (java.lang.String) r12
                java.lang.Object r13 = r0.L$5
                io.ktor.http.URLProtocol r13 = (io.ktor.http.URLProtocol) r13
                java.lang.Object r14 = r0.L$4
                kotlin.jvm.internal.Ref$ObjectRef r14 = (kotlin.jvm.internal.Ref.ObjectRef) r14
                java.lang.Object r2 = r0.L$3
                kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                java.lang.Object r4 = r0.L$2
                io.ktor.client.HttpClient r4 = (io.ktor.client.HttpClient) r4
                java.lang.Object r5 = r0.L$1
                io.ktor.client.plugins.Sender r5 = (io.ktor.client.plugins.Sender) r5
                java.lang.Object r6 = r0.L$0
                io.ktor.client.plugins.HttpRedirect$Plugin r6 = (io.ktor.client.plugins.HttpRedirect.Plugin) r6
                kotlin.ResultKt.throwOnFailure(r15)
                r8 = r13
                r13 = r10
                r10 = r5
                r5 = r14
                r14 = r8
                goto L_0x013a
            L_0x0052:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L_0x005a:
                kotlin.ResultKt.throwOnFailure(r15)
                io.ktor.client.statement.HttpResponse r15 = r12.getResponse()
                io.ktor.http.HttpStatusCode r15 = r15.getStatus()
                boolean r15 = io.ktor.client.plugins.HttpRedirectKt.isRedirect(r15)
                if (r15 != 0) goto L_0x006c
                return r12
            L_0x006c:
                kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
                r15.<init>()
                r15.element = r12
                kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
                r2.<init>()
                r2.element = r11
                io.ktor.client.request.HttpRequest r11 = r12.getRequest()
                io.ktor.http.Url r11 = r11.getUrl()
                io.ktor.http.URLProtocol r11 = r11.getProtocol()
                io.ktor.client.request.HttpRequest r12 = r12.getRequest()
                io.ktor.http.Url r12 = r12.getUrl()
                java.lang.String r12 = io.ktor.http.UrlKt.getAuthority(r12)
                r6 = r9
                r8 = r14
                r14 = r11
                r11 = r15
                r15 = r8
            L_0x0097:
                io.ktor.events.Events r4 = r15.getMonitor()
                io.ktor.events.EventDefinition r5 = r6.getHttpResponseRedirect()
                java.lang.Object r7 = r11.element
                io.ktor.client.call.HttpClientCall r7 = (io.ktor.client.call.HttpClientCall) r7
                io.ktor.client.statement.HttpResponse r7 = r7.getResponse()
                r4.raise(r5, r7)
                java.lang.Object r4 = r11.element
                io.ktor.client.call.HttpClientCall r4 = (io.ktor.client.call.HttpClientCall) r4
                io.ktor.client.statement.HttpResponse r4 = r4.getResponse()
                io.ktor.http.Headers r4 = r4.getHeaders()
                io.ktor.http.HttpHeaders r5 = io.ktor.http.HttpHeaders.INSTANCE
                java.lang.String r5 = r5.getLocation()
                java.lang.String r4 = r4.get(r5)
                io.ktor.client.request.HttpRequestBuilder r5 = new io.ktor.client.request.HttpRequestBuilder
                r5.<init>()
                java.lang.Object r7 = r2.element
                io.ktor.client.request.HttpRequestBuilder r7 = (io.ktor.client.request.HttpRequestBuilder) r7
                r5.takeFromWithExecutionContext(r7)
                io.ktor.http.URLBuilder r7 = r5.getUrl()
                io.ktor.http.ParametersBuilder r7 = r7.getParameters()
                r7.clear()
                if (r4 == 0) goto L_0x00e0
                io.ktor.http.URLBuilder r7 = r5.getUrl()
                io.ktor.http.URLParserKt.takeFrom(r7, r4)
            L_0x00e0:
                if (r13 != 0) goto L_0x00f9
                boolean r4 = io.ktor.http.URLProtocolKt.isSecure(r14)
                if (r4 == 0) goto L_0x00f9
                io.ktor.http.URLBuilder r4 = r5.getUrl()
                io.ktor.http.URLProtocol r4 = r4.getProtocol()
                boolean r4 = io.ktor.http.URLProtocolKt.isSecure(r4)
                if (r4 != 0) goto L_0x00f9
                java.lang.Object r10 = r11.element
                return r10
            L_0x00f9:
                io.ktor.http.URLBuilder r4 = r5.getUrl()
                java.lang.String r4 = io.ktor.http.URLBuilderKt.getAuthority(r4)
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r4)
                if (r4 != 0) goto L_0x0114
                io.ktor.http.HeadersBuilder r4 = r5.getHeaders()
                io.ktor.http.HttpHeaders r7 = io.ktor.http.HttpHeaders.INSTANCE
                java.lang.String r7 = r7.getAuthorization()
                r4.remove(r7)
            L_0x0114:
                r2.element = r5
                java.lang.Object r4 = r2.element
                io.ktor.client.request.HttpRequestBuilder r4 = (io.ktor.client.request.HttpRequestBuilder) r4
                r0.L$0 = r6
                r0.L$1 = r10
                r0.L$2 = r15
                r0.L$3 = r11
                r0.L$4 = r2
                r0.L$5 = r14
                r0.L$6 = r12
                r0.L$7 = r11
                r0.Z$0 = r13
                r0.label = r3
                java.lang.Object r4 = r10.execute(r4, r0)
                if (r4 != r1) goto L_0x0135
                return r1
            L_0x0135:
                r5 = r2
                r2 = r11
                r8 = r4
                r4 = r15
                r15 = r8
            L_0x013a:
                r11.element = r15
                java.lang.Object r11 = r2.element
                io.ktor.client.call.HttpClientCall r11 = (io.ktor.client.call.HttpClientCall) r11
                io.ktor.client.statement.HttpResponse r11 = r11.getResponse()
                io.ktor.http.HttpStatusCode r11 = r11.getStatus()
                boolean r11 = io.ktor.client.plugins.HttpRedirectKt.isRedirect(r11)
                if (r11 != 0) goto L_0x0151
                java.lang.Object r10 = r2.element
                return r10
            L_0x0151:
                r11 = r2
                r15 = r4
                r2 = r5
                goto L_0x0097
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRedirect.Plugin.handleCall(io.ktor.client.plugins.Sender, io.ktor.client.request.HttpRequestBuilder, io.ktor.client.call.HttpClientCall, boolean, io.ktor.client.HttpClient, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
