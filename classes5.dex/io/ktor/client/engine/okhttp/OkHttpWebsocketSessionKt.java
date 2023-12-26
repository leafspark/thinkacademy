package io.ktor.client.engine.okhttp;

import io.ktor.websocket.CloseReason;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"DEFAULT_CLOSE_REASON_ERROR", "Lio/ktor/websocket/CloseReason;", "isReserved", "", "ktor-client-okhttp"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpWebsocketSession.kt */
public final class OkHttpWebsocketSessionKt {
    /* access modifiers changed from: private */
    public static final CloseReason DEFAULT_CLOSE_REASON_ERROR = new CloseReason(CloseReason.Codes.INTERNAL_ERROR, "Client failure");

    /* access modifiers changed from: private */
    public static final boolean isReserved(CloseReason closeReason) {
        CloseReason.Codes byCode = CloseReason.Codes.Companion.byCode(closeReason.getCode());
        return byCode == null || byCode == CloseReason.Codes.CLOSED_ABNORMALLY;
    }
}
