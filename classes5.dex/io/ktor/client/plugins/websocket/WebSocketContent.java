package io.ktor.client.plugins.websocket;

import io.ktor.client.request.ClientUpgradeContent;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.websocket.UtilsKt;
import io.ktor.util.Base64Kt;
import io.ktor.util.CryptoKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSocketContent;", "Lio/ktor/client/request/ClientUpgradeContent;", "()V", "headers", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "nonce", "", "toString", "verify", "", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebSocketContent.kt */
public final class WebSocketContent extends ClientUpgradeContent {
    private final Headers headers;
    private final String nonce;

    public String toString() {
        return "WebSocketContent";
    }

    public WebSocketContent() {
        String str = Base64Kt.encodeBase64(CryptoKt.generateNonce(16));
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().apply(builderAction).toString()");
        this.nonce = str;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, (DefaultConstructorMarker) null);
        headersBuilder.append(HttpHeaders.INSTANCE.getUpgrade(), "websocket");
        headersBuilder.append(HttpHeaders.INSTANCE.getConnection(), "upgrade");
        headersBuilder.append(HttpHeaders.INSTANCE.getSecWebSocketKey(), str);
        headersBuilder.append(HttpHeaders.INSTANCE.getSecWebSocketVersion(), "13");
        this.headers = headersBuilder.build();
    }

    public Headers getHeaders() {
        return this.headers;
    }

    public void verify(Headers headers2) {
        Intrinsics.checkNotNullParameter(headers2, "headers");
        String str = headers2.get(HttpHeaders.INSTANCE.getSecWebSocketAccept());
        if (str != null) {
            String websocketServerAccept = UtilsKt.websocketServerAccept(this.nonce);
            if (!Intrinsics.areEqual(websocketServerAccept, str)) {
                throw new IllegalStateException(("Failed to verify server accept header. Expected: " + websocketServerAccept + ", received: " + str).toString());
            }
            return;
        }
        throw new IllegalStateException(("Server should specify header " + HttpHeaders.INSTANCE.getSecWebSocketAccept()).toString());
    }
}
