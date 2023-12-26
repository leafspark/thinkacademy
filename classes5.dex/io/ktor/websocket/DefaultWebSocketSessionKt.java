package io.ktor.websocket;

import io.ktor.websocket.CloseReason;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineName;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"IncomingProcessorCoroutineName", "Lkotlinx/coroutines/CoroutineName;", "NORMAL_CLOSE", "Lio/ktor/websocket/CloseReason;", "OutgoingProcessorCoroutineName", "DefaultWebSocketSession", "Lio/ktor/websocket/DefaultWebSocketSession;", "session", "Lio/ktor/websocket/WebSocketSession;", "pingInterval", "", "timeoutMillis", "ktor-websockets"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultWebSocketSession.kt */
public final class DefaultWebSocketSessionKt {
    /* access modifiers changed from: private */
    public static final CoroutineName IncomingProcessorCoroutineName = new CoroutineName("ws-incoming-processor");
    /* access modifiers changed from: private */
    public static final CloseReason NORMAL_CLOSE = new CloseReason(CloseReason.Codes.NORMAL, "OK");
    /* access modifiers changed from: private */
    public static final CoroutineName OutgoingProcessorCoroutineName = new CoroutineName("ws-outgoing-processor");

    public static /* synthetic */ DefaultWebSocketSession DefaultWebSocketSession$default(WebSocketSession webSocketSession, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = -1;
        }
        if ((i & 4) != 0) {
            j2 = 15000;
        }
        return DefaultWebSocketSession(webSocketSession, j, j2);
    }

    public static final DefaultWebSocketSession DefaultWebSocketSession(WebSocketSession webSocketSession, long j, long j2) {
        Intrinsics.checkNotNullParameter(webSocketSession, "session");
        if (!(webSocketSession instanceof DefaultWebSocketSession)) {
            return new DefaultWebSocketSessionImpl(webSocketSession, j, j2);
        }
        throw new IllegalArgumentException("Cannot wrap other DefaultWebSocketSession".toString());
    }
}
