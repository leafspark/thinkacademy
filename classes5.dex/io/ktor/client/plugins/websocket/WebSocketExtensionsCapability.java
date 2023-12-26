package io.ktor.client.plugins.websocket;

import io.ktor.client.engine.HttpClientEngineCapability;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSocketExtensionsCapability;", "Lio/ktor/client/engine/HttpClientEngineCapability;", "", "()V", "toString", "", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebSockets.kt */
public final class WebSocketExtensionsCapability implements HttpClientEngineCapability<Unit> {
    public static final WebSocketExtensionsCapability INSTANCE = new WebSocketExtensionsCapability();

    public String toString() {
        return "WebSocketExtensionsCapability";
    }

    private WebSocketExtensionsCapability() {
    }
}
