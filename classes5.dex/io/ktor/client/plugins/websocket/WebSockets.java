package io.ktor.client.plugins.websocket;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.HttpHeaders;
import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.DefaultWebSocketSessionKt;
import io.ktor.websocket.WebSocketExtension;
import io.ktor.websocket.WebSocketExtensionHeader;
import io.ktor.websocket.WebSocketExtensionHeaderKt;
import io.ktor.websocket.WebSocketExtensionsConfig;
import io.ktor.websocket.WebSocketSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001b\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B+\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u001a\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\b J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006$"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSockets;", "", "pingInterval", "", "maxFrameSize", "(JJ)V", "()V", "extensionsConfig", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "contentConverter", "Lio/ktor/serialization/WebsocketContentConverter;", "(JJLio/ktor/websocket/WebSocketExtensionsConfig;Lio/ktor/serialization/WebsocketContentConverter;)V", "getContentConverter", "()Lio/ktor/serialization/WebsocketContentConverter;", "getMaxFrameSize", "()J", "getPingInterval", "addNegotiatedProtocols", "", "context", "Lio/ktor/client/request/HttpRequestBuilder;", "protocols", "", "Lio/ktor/websocket/WebSocketExtensionHeader;", "completeNegotiation", "Lio/ktor/websocket/WebSocketExtension;", "call", "Lio/ktor/client/call/HttpClientCall;", "convertSessionToDefault", "Lio/ktor/websocket/DefaultWebSocketSession;", "session", "Lio/ktor/websocket/WebSocketSession;", "convertSessionToDefault$ktor_client_core", "installExtensions", "Config", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebSockets.kt */
public final class WebSockets {
    public static final Plugin Plugin = new Plugin((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AttributeKey<WebSockets> key = new AttributeKey<>("Websocket");
    private final WebsocketContentConverter contentConverter;
    private final WebSocketExtensionsConfig extensionsConfig;
    private final long maxFrameSize;
    private final long pingInterval;

    public WebSockets(long j, long j2, WebSocketExtensionsConfig webSocketExtensionsConfig, WebsocketContentConverter websocketContentConverter) {
        Intrinsics.checkNotNullParameter(webSocketExtensionsConfig, "extensionsConfig");
        this.pingInterval = j;
        this.maxFrameSize = j2;
        this.extensionsConfig = webSocketExtensionsConfig;
        this.contentConverter = websocketContentConverter;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebSockets(long j, long j2, WebSocketExtensionsConfig webSocketExtensionsConfig, WebsocketContentConverter websocketContentConverter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, webSocketExtensionsConfig, (i & 8) != 0 ? null : websocketContentConverter);
    }

    public final long getPingInterval() {
        return this.pingInterval;
    }

    public final long getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public final WebsocketContentConverter getContentConverter() {
        return this.contentConverter;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebSockets(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? -1 : j, (i & 2) != 0 ? 2147483647L : j2);
    }

    public WebSockets(long j, long j2) {
        this(j, j2, new WebSocketExtensionsConfig(), (WebsocketContentConverter) null, 8, (DefaultConstructorMarker) null);
    }

    public WebSockets() {
        this(-1, 2147483647L, new WebSocketExtensionsConfig(), (WebsocketContentConverter) null, 8, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public final void installExtensions(HttpRequestBuilder httpRequestBuilder) {
        List<WebSocketExtension<?>> build = this.extensionsConfig.build();
        httpRequestBuilder.getAttributes().put(WebSocketsKt.REQUEST_EXTENSIONS_KEY, build);
        Collection arrayList = new ArrayList();
        for (WebSocketExtension protocols : build) {
            CollectionsKt.addAll(arrayList, protocols.getProtocols());
        }
        addNegotiatedProtocols(httpRequestBuilder, (List) arrayList);
    }

    /* access modifiers changed from: private */
    public final List<WebSocketExtension<?>> completeNegotiation(HttpClientCall httpClientCall) {
        List<WebSocketExtensionHeader> list;
        String str = httpClientCall.getResponse().getHeaders().get(HttpHeaders.INSTANCE.getSecWebSocketExtensions());
        if (str == null || (list = WebSocketExtensionHeaderKt.parseWebSocketExtensions(str)) == null) {
            list = CollectionsKt.emptyList();
        }
        Collection arrayList = new ArrayList();
        for (Object next : (List) httpClientCall.getAttributes().get(WebSocketsKt.REQUEST_EXTENSIONS_KEY)) {
            if (((WebSocketExtension) next).clientNegotiation(list)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    private final void addNegotiatedProtocols(HttpRequestBuilder httpRequestBuilder, List<WebSocketExtensionHeader> list) {
        if (!list.isEmpty()) {
            UtilsKt.header(httpRequestBuilder, HttpHeaders.INSTANCE.getSecWebSocketExtensions(), CollectionsKt.joinToString$default(list, ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
    }

    public final DefaultWebSocketSession convertSessionToDefault$ktor_client_core(WebSocketSession webSocketSession) {
        Intrinsics.checkNotNullParameter(webSocketSession, "session");
        if (webSocketSession instanceof DefaultWebSocketSession) {
            return (DefaultWebSocketSession) webSocketSession;
        }
        long j = this.pingInterval;
        DefaultWebSocketSession DefaultWebSocketSession = DefaultWebSocketSessionKt.DefaultWebSocketSession(webSocketSession, j, ((long) 2) * j);
        DefaultWebSocketSession.setMaxFrameSize(this.maxFrameSize);
        return DefaultWebSocketSession;
    }

    @KtorDsl
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0016\u001a\u00020\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\b\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u001b"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSockets$Config;", "", "()V", "contentConverter", "Lio/ktor/serialization/WebsocketContentConverter;", "getContentConverter", "()Lio/ktor/serialization/WebsocketContentConverter;", "setContentConverter", "(Lio/ktor/serialization/WebsocketContentConverter;)V", "extensionsConfig", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "getExtensionsConfig$ktor_client_core", "()Lio/ktor/websocket/WebSocketExtensionsConfig;", "maxFrameSize", "", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "pingInterval", "getPingInterval", "setPingInterval", "extensions", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebSockets.kt */
    public static final class Config {
        private WebsocketContentConverter contentConverter;
        private final WebSocketExtensionsConfig extensionsConfig = new WebSocketExtensionsConfig();
        private long maxFrameSize = 2147483647L;
        private long pingInterval = -1;

        public final WebSocketExtensionsConfig getExtensionsConfig$ktor_client_core() {
            return this.extensionsConfig;
        }

        public final long getPingInterval() {
            return this.pingInterval;
        }

        public final void setPingInterval(long j) {
            this.pingInterval = j;
        }

        public final long getMaxFrameSize() {
            return this.maxFrameSize;
        }

        public final void setMaxFrameSize(long j) {
            this.maxFrameSize = j;
        }

        public final WebsocketContentConverter getContentConverter() {
            return this.contentConverter;
        }

        public final void setContentConverter(WebsocketContentConverter websocketContentConverter) {
            this.contentConverter = websocketContentConverter;
        }

        public final void extensions(Function1<? super WebSocketExtensionsConfig, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            function1.invoke(this.extensionsConfig);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J!\u0010\u000e\u001a\u00020\u00032\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0002\b\u0011H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSockets$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/websocket/WebSockets$Config;", "Lio/ktor/client/plugins/websocket/WebSockets;", "()V", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "", "plugin", "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebSockets.kt */
    public static final class Plugin implements HttpClientPlugin<Config, WebSockets> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Plugin() {
        }

        public AttributeKey<WebSockets> getKey() {
            return WebSockets.key;
        }

        public WebSockets prepare(Function1<? super Config, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config();
            function1.invoke(config);
            return new WebSockets(config.getPingInterval(), config.getMaxFrameSize(), config.getExtensionsConfig$ktor_client_core(), config.getContentConverter());
        }

        public void install(WebSockets webSockets, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(webSockets, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            boolean contains = httpClient.getEngine().getSupportedCapabilities().contains(WebSocketExtensionsCapability.INSTANCE);
            httpClient.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getRender(), new WebSockets$Plugin$install$1(contains, webSockets, (Continuation<? super WebSockets$Plugin$install$1>) null));
            httpClient.getResponsePipeline().intercept(HttpResponsePipeline.Phases.getTransform(), new WebSockets$Plugin$install$2(webSockets, contains, (Continuation<? super WebSockets$Plugin$install$2>) null));
        }
    }
}
