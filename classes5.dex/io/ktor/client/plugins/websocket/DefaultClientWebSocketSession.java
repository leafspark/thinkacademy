package io.ktor.client.plugins.websocket;

import io.ktor.client.call.HttpClientCall;
import io.ktor.util.InternalAPI;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketExtension;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0011\u00102\u001a\u000203HAø\u0001\u0000¢\u0006\u0002\u00104J\u0019\u00105\u001a\u0002032\u0006\u00106\u001a\u00020\u0019HAø\u0001\u0000¢\u0006\u0002\u00107J\u001d\u00108\u001a\u0002032\u0012\b\u0002\u00109\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013H\u0001J\t\u0010:\u001a\u000203H\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u00020\u001dX\u000f¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010\"\u001a\u00020#X\u000f¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0018\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190)X\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0018\u0010,\u001a\u00020#X\u000f¢\u0006\f\u001a\u0004\b-\u0010%\"\u0004\b.\u0010'R\u0018\u0010/\u001a\u00020#X\u000f¢\u0006\f\u001a\u0004\b0\u0010%\"\u0004\b1\u0010'\u0002\u0004\n\u0002\b\u0019¨\u0006;"}, d2 = {"Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "Lio/ktor/client/plugins/websocket/ClientWebSocketSession;", "Lio/ktor/websocket/DefaultWebSocketSession;", "call", "Lio/ktor/client/call/HttpClientCall;", "delegate", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/websocket/DefaultWebSocketSession;)V", "getCall", "()Lio/ktor/client/call/HttpClientCall;", "closeReason", "Lkotlinx/coroutines/Deferred;", "Lio/ktor/websocket/CloseReason;", "getCloseReason", "()Lkotlinx/coroutines/Deferred;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "extensions", "", "Lio/ktor/websocket/WebSocketExtension;", "getExtensions", "()Ljava/util/List;", "incoming", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lio/ktor/websocket/Frame;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "masking", "", "getMasking", "()Z", "setMasking", "(Z)V", "maxFrameSize", "", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "outgoing", "Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "pingIntervalMillis", "getPingIntervalMillis", "setPingIntervalMillis", "timeoutMillis", "getTimeoutMillis", "setTimeoutMillis", "flush", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "send", "frame", "(Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "negotiatedExtensions", "terminate", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClientSessions.kt */
public final class DefaultClientWebSocketSession implements ClientWebSocketSession, DefaultWebSocketSession {
    private final /* synthetic */ DefaultWebSocketSession $$delegate_0;
    private final HttpClientCall call;

    public Object flush(Continuation<? super Unit> continuation) {
        return this.$$delegate_0.flush(continuation);
    }

    public Deferred<CloseReason> getCloseReason() {
        return this.$$delegate_0.getCloseReason();
    }

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public List<WebSocketExtension<?>> getExtensions() {
        return this.$$delegate_0.getExtensions();
    }

    public ReceiveChannel<Frame> getIncoming() {
        return this.$$delegate_0.getIncoming();
    }

    public boolean getMasking() {
        return this.$$delegate_0.getMasking();
    }

    public long getMaxFrameSize() {
        return this.$$delegate_0.getMaxFrameSize();
    }

    public SendChannel<Frame> getOutgoing() {
        return this.$$delegate_0.getOutgoing();
    }

    public long getPingIntervalMillis() {
        return this.$$delegate_0.getPingIntervalMillis();
    }

    public long getTimeoutMillis() {
        return this.$$delegate_0.getTimeoutMillis();
    }

    public Object send(Frame frame, Continuation<? super Unit> continuation) {
        return this.$$delegate_0.send(frame, continuation);
    }

    public void setMasking(boolean z) {
        this.$$delegate_0.setMasking(z);
    }

    public void setMaxFrameSize(long j) {
        this.$$delegate_0.setMaxFrameSize(j);
    }

    public void setPingIntervalMillis(long j) {
        this.$$delegate_0.setPingIntervalMillis(j);
    }

    public void setTimeoutMillis(long j) {
        this.$$delegate_0.setTimeoutMillis(j);
    }

    @InternalAPI
    public void start(List<? extends WebSocketExtension<?>> list) {
        Intrinsics.checkNotNullParameter(list, "negotiatedExtensions");
        this.$$delegate_0.start(list);
    }

    @Deprecated(message = "Use cancel() instead.", replaceWith = @ReplaceWith(expression = "cancel()", imports = {"kotlinx.coroutines.cancel"}))
    public void terminate() {
        this.$$delegate_0.terminate();
    }

    public DefaultClientWebSocketSession(HttpClientCall httpClientCall, DefaultWebSocketSession defaultWebSocketSession) {
        Intrinsics.checkNotNullParameter(httpClientCall, "call");
        Intrinsics.checkNotNullParameter(defaultWebSocketSession, "delegate");
        this.call = httpClientCall;
        this.$$delegate_0 = defaultWebSocketSession;
    }

    public HttpClientCall getCall() {
        return this.call;
    }
}
