package io.ktor.client.plugins.websocket;

import io.ktor.util.AttributeKey;
import io.ktor.websocket.WebSocketExtension;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\"\u001e\u0010\u0000\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"REQUEST_EXTENSIONS_KEY", "Lio/ktor/util/AttributeKey;", "", "Lio/ktor/websocket/WebSocketExtension;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebSockets.kt */
public final class WebSocketsKt {
    /* access modifiers changed from: private */
    public static final AttributeKey<List<WebSocketExtension<?>>> REQUEST_EXTENSIONS_KEY = new AttributeKey<>("Websocket extensions");
}
