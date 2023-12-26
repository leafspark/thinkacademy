package io.ktor.websocket;

import io.ktor.util.InternalAPI;
import io.ktor.websocket.WebSocketSession;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0010\u001a\u00020\u00112\u0012\b\u0002\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013H'R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\bX¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u00020\bX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0015"}, d2 = {"Lio/ktor/websocket/DefaultWebSocketSession;", "Lio/ktor/websocket/WebSocketSession;", "closeReason", "Lkotlinx/coroutines/Deferred;", "Lio/ktor/websocket/CloseReason;", "getCloseReason", "()Lkotlinx/coroutines/Deferred;", "pingIntervalMillis", "", "getPingIntervalMillis", "()J", "setPingIntervalMillis", "(J)V", "timeoutMillis", "getTimeoutMillis", "setTimeoutMillis", "start", "", "negotiatedExtensions", "", "Lio/ktor/websocket/WebSocketExtension;", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultWebSocketSession.kt */
public interface DefaultWebSocketSession extends WebSocketSession {
    Deferred<CloseReason> getCloseReason();

    long getPingIntervalMillis();

    long getTimeoutMillis();

    void setPingIntervalMillis(long j);

    void setTimeoutMillis(long j);

    @InternalAPI
    void start(List<? extends WebSocketExtension<?>> list);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultWebSocketSession.kt */
    public static final class DefaultImpls {
        public static Object send(DefaultWebSocketSession defaultWebSocketSession, Frame frame, Continuation<? super Unit> continuation) {
            Object send = WebSocketSession.DefaultImpls.send(defaultWebSocketSession, frame, continuation);
            return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
        }

        public static /* synthetic */ void start$default(DefaultWebSocketSession defaultWebSocketSession, List list, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    list = CollectionsKt.emptyList();
                }
                defaultWebSocketSession.start(list);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
        }
    }
}
